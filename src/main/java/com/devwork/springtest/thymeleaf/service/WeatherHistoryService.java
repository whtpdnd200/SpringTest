package com.devwork.springtest.thymeleaf.service;

import com.devwork.springtest.thymeleaf.domain.WeatherHistory;
import com.devwork.springtest.thymeleaf.repository.WeatherHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherHistoryService {

    @Autowired
    private WeatherHistoryRepository weatherHistoryRepository;

    public List<WeatherHistory> getWeatherList() {
        return weatherHistoryRepository.selectWeatherList();
    }
}
