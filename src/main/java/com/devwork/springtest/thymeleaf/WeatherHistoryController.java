package com.devwork.springtest.thymeleaf;

import com.devwork.springtest.thymeleaf.domain.WeatherHistory;
import com.devwork.springtest.thymeleaf.service.WeatherHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherHistoryController {

    @Autowired
    private WeatherHistoryService weatherHistoryService;
    
    @GetMapping("/info")
    public String weatherInfo(Model model) {
        model.addAttribute("weatherList", weatherHistoryService.getWeatherList());
        return "/thymeleaf/test04/test04";
    }

    @GetMapping("/addForm")
    public String weatherAddForm() {

        return "/thymeleaf/test04/test04Add";
    }

    @GetMapping("/add")
    public String weatherAdd(Model model, @ModelAttribute("weatherHistory") WeatherHistory weatherHistory) {

        int count = weatherHistoryService.createWeather(weatherHistory);
        return "redirect:/thymeleaf/weather/info";
    }
}
