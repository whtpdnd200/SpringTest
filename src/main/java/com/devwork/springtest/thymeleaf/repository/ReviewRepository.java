package com.devwork.springtest.thymeleaf.repository;

import com.devwork.springtest.thymeleaf.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewRepository {

    public List<Review> selectReviewList(@Param("storeId") int storeId);
}
