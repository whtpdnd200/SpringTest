package com.devwork.springtest.mybatis.repository;

import com.devwork.springtest.mybatis.domain.RealEstate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RealEstateRepository {

    public RealEstate selectRealEstate(@Param("id") int id);

    public List<RealEstate> selectRowRentPrice(@Param("rent") int rent);

    public List<RealEstate> selectRowPrice(@Param("area") int area, @Param("price") int price);
}
