package com.devwork.springtest.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherHistoryController {


    @GetMapping("/info")
    public String weatherInfo() {

        return "thymeleaf/test04/test04";
    }
}
