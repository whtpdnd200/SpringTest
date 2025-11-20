package com.devwork.springtest.thymeleaf;

import com.devwork.springtest.database.service.StoreService;
import com.devwork.springtest.thymeleaf.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/store")
@Controller
public class NewStoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/info")
    public String storeInfo(Model model) {

        model.addAttribute("storeList", storeService.getStoreList());
        return "/thymeleaf/test05/test05";
    }

    @GetMapping("/review")
    public String storeReview(Model model, @RequestParam("store-id") int storeId
                                , @RequestParam("store-name") String StoreName) {

        model.addAttribute("storeName", StoreName);
        model.addAttribute("reviewList", reviewService.getReviewList(storeId));
        return "/thymeleaf/test05/test05Review";
    }
}
