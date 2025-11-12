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
@RequestMapping("/mybatis/real-estate")
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    @ResponseBody
    @RequestMapping("/select/1")
    public RealEstate responseRealEstate(@RequestParam("id") int id) {
        return realEstateService.getRealEstate(id);
    }

    @ResponseBody
    @RequestMapping("/select/2")
    public List<RealEstate> responseRowRentPrice(@RequestParam("rent") int rent) {
        return realEstateService.getRowRentPrice(rent);
    }

    @ResponseBody
    @RequestMapping("/select/3")
    public List<RealEstate> responseRowPrice(
            @RequestParam("area") int area
            , @RequestParam("price") int price) {
        return realEstateService.getRowPrice(area, price);
    }

    @ResponseBody
    @RequestMapping("/insert/1")
    public String writeRealEstate() {
        RealEstate realEstate = new RealEstate();
        realEstate.setRealtorId(3);
        realEstate.setAddress("푸르지용 리버 303동 1104호");
        realEstate.setArea(89);
        realEstate.setType("매매");
        realEstate.setPrice(100000);
        return "입력 성공 : " + realEstateService.createRealEstate(realEstate);
    }

    @ResponseBody
    @RequestMapping("/insert/2")
    public String paramWriteRealEstate(@RequestParam("realtorId") int realtorId) {
        return "입력 성공 : " + realEstateService.paramCreateRealEstate(realtorId
                , "썅떼빌리버 오피스텔 814호"
                , 45
                , "월세"
                , 100000
                , 120);
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateRealEstateById() {
        return "수정 성공 : " + realEstateService.updateRealEstateById(22, "전세", 700000);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String deleteRealEstateById(@RequestParam("id") int id) {
        return "삭제 성공 : " + realEstateService.deleteRealEstateById(id);
    }
}
