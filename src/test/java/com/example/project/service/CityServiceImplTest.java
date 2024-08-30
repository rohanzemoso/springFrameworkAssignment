package com.example.project.service;

import com.example.project.dao.CityDao;
import com.example.project.model.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceImplTest {

    @Mock
    private CityDao cityDao;

    @InjectMocks
    private CityServiceImpl cityService;

    @Before
    public void setUp() {}

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
    public void testGetCityById_whenCityIdNotPresent_shouldReturnNull() {
        int cityId = 1;

        when(cityDao.getCityById(cityId)).thenReturn(null);

        City actualCity = cityService.getCityById(cityId);

        assertNull(actualCity);

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

    @Test
    public void testDeleteCity_whenCityIdNotPresent_shouldThrowException() {
        int cityId = 1;
        doThrow(new EntityNotFoundException("City not found with id: " + cityId))
                .when(cityDao).deleteCity(cityId);
        try {
            cityService.deleteCity(cityId);
            fail("expected EntityNotFoundException to be thrown");
        } catch (EntityNotFoundException e) {
            assertEquals("City not found with id: " + cityId, e.getMessage());
        }
        verify(cityDao, times(1)).deleteCity(cityId);
    }
}
