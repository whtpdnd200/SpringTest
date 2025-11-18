package com.devwork.springtest.thymeleaf.repository;

import com.devwork.springtest.thymeleaf.domain.WeatherHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeatherHistoryRepository {

    public List<WeatherHistory> selectWeatherList();
}
