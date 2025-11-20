package com.devwork.springtest.thymeleaf.service;

import com.devwork.springtest.thymeleaf.domain.Review;
import com.devwork.springtest.thymeleaf.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewList(int storeId) {
        return reviewRepository.selectReviewList(storeId);
    }
}
