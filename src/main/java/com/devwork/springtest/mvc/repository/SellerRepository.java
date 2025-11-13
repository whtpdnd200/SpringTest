package com.devwork.springtest.mvc.repository;

import com.devwork.springtest.mvc.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerRepository {

    public int insertSeller(
            @Param("nickname") String name
            , @Param("image") String image
            , @Param("temperature") double temperature
    );

    public Seller selectLastSeller();
}
