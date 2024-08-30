package com.example.project.service;

import com.example.project.dao.CityDao;
import com.example.project.model.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceImplTest {

    @Mock
    private CityDao cityDao;

    @InjectMocks
    private CityServiceImpl cityService;

    @Before
    public void setUp() {
        // No need for MockitoAnnotations.openMocks(this); when using @RunWith(MockitoJUnitRunner.class)
    }

    @Test
    public void testSaveCity() {
        City city = new City();
        cityService.saveCity(city);
        verify(cityDao, times(1)).saveCity(city);
    }

    @Test
    public void testListCityByCountryId() {
        int countryId = 1;
        List<City> expectedCities = Arrays.asList(new City(), new City());
        when(cityDao.listCityByCountryId(countryId)).thenReturn(expectedCities);

        List<City> actualCities = cityService.listCityByCountryId(countryId);

        assertNotNull(actualCities);
        assertEquals(2, actualCities.size());
        verify(cityDao, times(1)).listCityByCountryId(countryId);
    }

    @Test
    public void testGetCityById() {
        int cityId = 1;
        City expectedCity = new City();
        when(cityDao.getCityById(cityId)).thenReturn(expectedCity);

        City actualCity = cityService.getCityById(cityId);

        assertNotNull(actualCity);
        verify(cityDao, times(1)).getCityById(cityId);
    }

    @Test
    public void testUpdateCity() {
        City city = new City();
        cityService.updateCity(city);
        verify(cityDao, times(1)).updateCity(city);
    }

    @Test
    public void testDeleteCity() {
        int cityId = 1;
        cityService.deleteCity(cityId);
        verify(cityDao, times(1)).deleteCity(cityId);
    }
}
