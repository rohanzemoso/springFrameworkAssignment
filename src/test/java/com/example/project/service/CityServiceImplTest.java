package com.example.project.service;

import com.example.project.dao.CityDao;
import com.example.project.model.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CityServiceImplTest {

    @Mock
    private CityDao cityDao;

    @InjectMocks
    private CityServiceImpl cityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCity() {
        City city = new City();
        cityService.saveCity(city);
        verify(cityDao, times(1)).saveCity(city);
    }

    @Test
    void testListCityByCountryId() {
        int countryId = 1;
        List<City> expectedCities = Arrays.asList(new City(), new City());
        when(cityDao.listCityByCountryId(countryId)).thenReturn(expectedCities);

        List<City> actualCities = cityService.listCityByCountryId(countryId);

        assertNotNull(actualCities);
        assertEquals(2, actualCities.size());
        verify(cityDao, times(1)).listCityByCountryId(countryId);
    }

    @Test
    void testGetCityById() {
        int cityId = 1;
        City expectedCity = new City();
        when(cityDao.getCityById(cityId)).thenReturn(expectedCity);

        City actualCity = cityService.getCityById(cityId);

        assertNotNull(actualCity);
        verify(cityDao, times(1)).getCityById(cityId);
    }

    @Test
    void testUpdateCity() {
        City city = new City();
        cityService.updateCity(city);
        verify(cityDao, times(1)).updateCity(city);
    }

    @Test
    void testDeleteCity() {
        int cityId = 1;
        cityService.deleteCity(cityId);
        verify(cityDao, times(1)).deleteCity(cityId);
    }
}

