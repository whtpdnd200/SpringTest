package com.devwork.springtest.thymeleaf;

import com.devwork.springtest.database.service.StoreService;
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

    @GetMapping("/info")
    public String storeInfo(Model model) {

        model.addAttribute("storeList", storeService.getStoreList());
        return "/thymeleaf/test05/test05";
    }

    @GetMapping("/storeReview")
    public String storeReview(Model model, @RequestParam("storeId") int storeId) {

        model.addAttribute("reviewList", storeService.getReviewList(storeId));
        return "/thymeleaf/test05/test05Review";
    }
}
