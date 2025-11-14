package com.devwork.springtest.mvc;

import com.devwork.springtest.mvc.domain.Realtor;
import com.devwork.springtest.mvc.service.RealtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc/realtor")
public class RealtorController {

    @Autowired
    private RealtorService realtorService;

    @GetMapping("/add")
    public String form() {

        return "mvc/realtorAdd";
    }

    @GetMapping("/info")
    public String responseInfo(
            @RequestParam("office") String office
            , @RequestParam("phoneNumber") String phoneNumber
            , @RequestParam("address") String address
            , @RequestParam("grade") String grade
    ) {
        Realtor realtor = new Realtor();
        realtor.setOffice(office);
        realtor.setPhoneNumber(phoneNumber);
        realtor.setAddress(address);
        realtor.setGrade(grade);
        realtorService.createRealtor(realtor);

        return "";
    }
}
