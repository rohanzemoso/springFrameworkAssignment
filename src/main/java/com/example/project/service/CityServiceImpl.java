package com.example.project.service;

import com.example.project.dao.CityDao;
import com.example.project.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final CityDao cityDao;

    @Autowired
    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public void saveCity(City city) {
        cityDao.saveCity(city);
    }

    @Override
    public List<City> listCityByCountryId(int userId) {
        return cityDao.listCityByCountryId(userId);
    }

    @Override
    public City getCityById(int id) {
        return cityDao.getCityById(id);
    }

    @Override
    public void updateCity(City city) {
        cityDao.updateCity(city);
    }

    @Override
    public void deleteCity(int id) {
        cityDao.deleteCity(id);
    }
}
