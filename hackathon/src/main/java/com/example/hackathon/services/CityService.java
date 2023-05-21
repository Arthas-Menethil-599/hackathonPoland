package com.example.hackathon.services;

import com.example.hackathon.entities.City;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CityService {
    List<City> getAllCities();
    City getCityById(Long id);
    City saveCity(City city);
    City updateCity(Long id, City city);
    void deleteCity(Long id);
}
