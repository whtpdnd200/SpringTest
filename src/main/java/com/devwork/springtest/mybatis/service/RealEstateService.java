package com.devwork.springtest.mybatis.service;

import com.devwork.springtest.mybatis.domain.RealEstate;
import com.devwork.springtest.mybatis.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class RealEstateService {

    @Autowired
    private RealEstateRepository realEstateRepository;

    public RealEstate getRealEstate(int id) {
        return realEstateRepository.selectRealEstate(id);
    }

    public List<RealEstate> getRowRentPrice(int rent) {
        return realEstateRepository.selectRowRentPrice(rent);
    }

    public List<RealEstate> getRowPrice(int area, int price) {
        return realEstateRepository.selectRowPrice(area, price);
    }

    public int createRealEstate(RealEstate realEstate) {
        return realEstateRepository.insertRealEstate(realEstate);
    }

    public int paramCreateRealEstate(
            int realtorId
            , String address
            , int area
            , String type
            , int price
            , int rentPrice) {
        return realEstateRepository.paramInsertRealEstate(realtorId, address, area, type, price, rentPrice);
    }

    public int updateRealEstateById(int id, String type, int price) {
        return realEstateRepository.updateRealEstateById(id, type, price);
    }

    public int deleteRealEstateById(int id) {
        return realEstateRepository.deleteRealEstateById(id);
    }
}
