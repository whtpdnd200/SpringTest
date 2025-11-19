package com.devwork.springtest.thymeleaf;

import com.devwork.springtest.database.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/store")
@Controller
public class NewStoreController {

    private StoreService storeService;

    @GetMapping("/info")
    public String storeInfo(Model model) {

        model.addAttribute("storeList", storeService.getStoreList());
        return "/thymeleaf/test05/test05";
    }
}
