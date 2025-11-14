package com.devwork.springtest.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf/test")
public class ThymeleafController {

    @GetMapping("/1")
    public String test01() {

        return "thymeleaf/test01";
    }
}
