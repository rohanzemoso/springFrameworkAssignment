package com.example.project.dao;

import com.example.project.model.Country;

import java.util.List;

public interface CountryDao {
    void saveCountry(Country country);
    List<Country> listCountry();
    Country getCountryById(int id);
    void updateCountry(Country country);
    void deleteCountry(int id);
}
