package com.devwork.springtest.ajax;

import com.devwork.springtest.ajax.domain.Booking;
import com.devwork.springtest.ajax.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/pension")
@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // 기본 화면 뷰
    @GetMapping("/home")
    public String home() {

        return "/ajax/test03/pension";
    }


    // 예약 목록 뷰
    @GetMapping("/booking-list")
    public String list(Model model) {

        model.addAttribute("bookingList", bookingService.getBookingList());
        return "/ajax/test03/bookingList";
    }

    // 예약하기 뷰
    @GetMapping("/form")
    public String booking() {

        return "/ajax/test03/bookingForm";
    }

    // 예약 정보 삭제 API
    @ResponseBody
    @GetMapping("/delete")
    public Map<String, Boolean> removeBooking(@RequestParam("id") int id) {
        Map<String, Boolean> resultMap = new HashMap<>();
        resultMap.put("result", bookingService.deleteBooking(id));
        return resultMap;
    }

    // 예약 정보 삽입 API
    @ResponseBody
    @PostMapping("/add")
    public Map<String, Boolean> addBooking(@ModelAttribute Booking booking) {

        Map<String, Boolean> resultMap = new HashMap<>();

        resultMap.put("result", bookingService.insertBooking(booking));

        return resultMap;
    }

    // 예약 정보 API
    @ResponseBody
    @GetMapping("/info")
    public Map<String, Object> getBookingInfo(@RequestParam("name") String name
            , @RequestParam("phoneNumber") String phoneNumber) {

        Map<String, Object> resultMap = new HashMap<>();
        Booking booking = bookingService.selectBooking(name, phoneNumber);


        if(booking == null) {
            resultMap.put("result", "empty");
        } else {
            resultMap.put("result", "notEmpty");
            resultMap.put("booking", booking);
        }

        return resultMap;
    }

}
