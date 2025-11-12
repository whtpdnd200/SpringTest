package com.devwork.springtest.mybatis.repository;

import com.devwork.springtest.mybatis.domain.RealEstate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RealEstateRepository {


    public RealEstate selectRealEstate(@Param("id") int id);

    public List<RealEstate> selectRowRentPrice(@Param("rent") int rent);

    public List<RealEstate> selectRowPrice(
            @Param("area") int area
            , @Param("price") int price);

    public int insertRealEstate(RealEstate realEstate);

    public int paramInsertRealEstate(
            @Param("realtorId") int realtorId
            , @Param("address") String address
            , @Param("area") int area
            , @Param("type") String type
            , @Param("price") int price
            , @Param("rentPrice") int rentPrice
    );

    public int updateRealEstateById(
            @Param("id") int id
            , @Param("type") String type
            , @Param("price") int price
    );

    public int deleteRealEstateById(@Param("id") int id);
}
