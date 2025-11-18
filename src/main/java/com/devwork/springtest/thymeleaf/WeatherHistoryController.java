package com.devwork.springtest.thymeleaf;

import com.devwork.springtest.thymeleaf.service.WeatherHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherHistoryController {

    @Autowired
    private WeatherHistoryService weatherHistoryService;

    @GetMapping("/info")
    public String weatherInfo(Model model) {
        model.addAttribute("weatherList", weatherHistoryService.getWeatherList());
        return "thymeleaf/test04/test04";
    }

    @GetMapping("/add")
    public String weatherAdd() {

        return "thymeleaf/test04/test04Add";
    }
}
