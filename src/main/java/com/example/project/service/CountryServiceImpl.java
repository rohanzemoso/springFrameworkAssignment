package com.example.project.service;

import com.example.project.dao.CountryDao;
import com.example.project.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    @Override
    public void saveCountry(Country country) {
        countryDao.saveCountry(country);
    }

    @Override
    public List<Country> listCountry() {
        return countryDao.listCountry();
    }

    @Override
    public Country getCountryById(int id) {
        return countryDao.getCountryById(id);
    }

    @Override
    public void updateCountry(Country country) {
        countryDao.updateCountry(country);
    }

    @Override
    public void deleteCountry(int id) {
        countryDao.deleteCountry(id);
    }
}
