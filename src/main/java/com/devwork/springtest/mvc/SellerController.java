package com.devwork.springtest.mvc;

import com.devwork.springtest.mvc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mvc/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/add")
    public String addForm() {

        return "/mvc/sellerAdd";
    }

    @ResponseBody
    @PostMapping("/addResult")
    public String addUser(
            @RequestParam("nickname") String name
            , @RequestParam(value = "image", required = false) String image
            , @RequestParam("temperature") double temperature
    ) {
        return "입력 성공 : " + sellerService.createUser(name, image, temperature);
    }

    @GetMapping("/sellerInfo")
    public String sellerInfo(Model model, @RequestParam(value = "id", required = false) Integer id) {

        model.addAttribute("result", sellerService.getSeller(id));
        return "/mvc/sellerInfo";
    }
}
