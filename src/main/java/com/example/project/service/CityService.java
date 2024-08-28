package com.example.project.service;

import com.example.project.model.City;

import java.util.List;

public interface CityService {
    void saveCity(City city);
    List<City> listCityByCountryId(int userId);
    City getCityById(int id);
    void updateCity(City city);
    void deleteCity(int id);
}
