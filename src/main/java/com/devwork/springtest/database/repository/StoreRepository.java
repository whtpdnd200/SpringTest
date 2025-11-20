package com.devwork.springtest.database.repository;

import com.devwork.springtest.database.domain.Store;
import com.devwork.springtest.thymeleaf.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreRepository {

    public List<Store> getStoreList();

    public List<Review> selectReviewList(@Param("storeId") int storeId);
}
