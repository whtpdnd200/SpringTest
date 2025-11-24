package com.devwork.springtest.ajax;

import com.devwork.springtest.ajax.domain.Booking;
import com.devwork.springtest.ajax.service.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/pension")
@Controller
public class PensionController {

    @Autowired
    private PensionService pensionService;

    // 기본 화면 뷰
    @GetMapping("/home")
    public String home() {

        return "/ajax/test03/pension";
    }


    // 예약 목록 뷰
    @GetMapping("/booking-list")
    public String list(Model model) {

        model.addAttribute("bookingList", pensionService.getBookingList());
        return "/ajax/test03/bookingList";
    }

    // 예약하기 뷰
    @GetMapping("/form")
    public String booking() {

        return "/ajax/test03/bookingForm";
    }

    // 예약 목록 삭제 API
    @ResponseBody
    @GetMapping("/delete")
    public Map<String, Boolean> removeBooking(@RequestParam("id") int id) {
        Map<String, Boolean> resultMap = new HashMap<>();
        resultMap.put("result", pensionService.deleteBooking(id));
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/add")
    public Map<String, Boolean> addBooking(@ModelAttribute Booking booking) {

        Map<String, Boolean> resultMap = new HashMap<>();

        resultMap.put("result", pensionService.insertBooking(booking));

        return resultMap;
    }

    @ResponseBody
    @GetMapping("/info")
    public Booking getBookingInfo(@RequestParam("name") String name
            , @RequestParam("phoneNumber") String phoneNumber) {

        return pensionService.selectBooking(name, phoneNumber);
        
    }

}
