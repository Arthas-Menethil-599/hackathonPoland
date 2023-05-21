package com.example.hackathon.services;

import com.example.hackathon.entities.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryById(Long id);
    Country saveCountry(Country country);
    Country updateCountry(Long id, Country country);
    void deleteCountry(Long id);
}
