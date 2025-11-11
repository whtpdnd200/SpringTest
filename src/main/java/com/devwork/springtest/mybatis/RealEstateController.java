package com.devwork.springtest.mybatis;

import com.devwork.springtest.mybatis.domain.RealEstate;
import com.devwork.springtest.mybatis.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mybatis/real-estate/select")
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    @ResponseBody
    @RequestMapping("/1")
    public RealEstate responseRealEstate(@RequestParam("id") int id)
    {
        return realEstateService.getRealEstate(id);
    }

    @ResponseBody
    @RequestMapping("/2")
    public List<RealEstate> responseRowRentPrice(@RequestParam("rent") int rent)
    {
        return realEstateService.getRowRentPrice(rent);
    }

    @ResponseBody
    @RequestMapping("/3")
    public List<RealEstate> responseRowPrice(@RequestParam("area") int area, @RequestParam("price") int price)
    {
        return realEstateService.getRowPrice(area, price);
    }
}
