package com.example.project.controller;

import com.example.project.model.City;
import com.example.project.model.Country;
import com.example.project.service.CityService;
import com.example.project.service.CountryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*; // JUnit 4 assert methods

@RunWith(MockitoJUnitRunner.class)
public class CountryControllerTest {

    @Mock
    private CityService cityService;

    @Mock
    private CountryService countryService;

    @Mock
    private Model model;

    @InjectMocks
    private CountryController countryController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListCountries() {
        Country country1 = new Country();
        country1.setName("Country1");
        Country country2 = new Country();
        country2.setName("Country2");
        List<Country> countries = Arrays.asList(country1, country2);
        when(countryService.listCountry()).thenReturn(countries);
        String viewName = countryController.listCountries(model);
        assertEquals("listCountries", viewName);
        verify(model).addAttribute("countries", countries);
    }

    @Test
    public void testSaveCountryNew() {
        Country country = new Country();
        country.setName("New Country");
        country.setTravelledFrom("Travelled From");
        countryController.saveCountry(country, model);
        verify(countryService).saveCountry(country);
        verifyNoMoreInteractions(countryService, model);
    }

    @Test
    public void testSaveCountryExisting() {
        Country existingCountry = new Country();
        existingCountry.setId(1);
        existingCountry.setName("Existing Country");
        existingCountry.setTravelledFrom("Travelled From");

        Country updatedCountry = new Country();
        updatedCountry.setId(1);
        updatedCountry.setName("Updated Country");
        updatedCountry.setTravelledFrom("Updated Travelled From");

        when(countryService.getCountryById(1)).thenReturn(existingCountry);
        doNothing().when(countryService).updateCountry(any(Country.class));
        String viewName = countryController.saveCountry(updatedCountry, model);
        assertEquals("redirect:/list", viewName);
        verify(countryService).getCountryById(1);
        verify(countryService).updateCountry(existingCountry);
        verifyNoMoreInteractions(countryService, model);
    }

    @Test
    public void testShowFormForAddCountry() {
        String viewName = countryController.showFormForAddCountry(model);
        assertEquals("countryForm", viewName);
        verify(model).addAttribute(eq("country"), any(Country.class));
        verifyNoMoreInteractions(model);
    }

    @Test
    public void testShowFormForUpdateCountry() {
        int id = 1;
        Country country = new Country();
        country.setId(id);
        country.setName("Country Name");
        when(countryService.getCountryById(id)).thenReturn(country);

        String viewName = countryController.showFormForUpdateCountry(id, model);
        assertEquals("updateCountry", viewName);
        verify(countryService).getCountryById(id);
        verify(model).addAttribute("country", country);
        verifyNoMoreInteractions(countryService, model);
    }

    @Test
    public void testDeleteCountry() {
        int id = 1;
        String viewName = countryController.deleteCountry(id);
        assertEquals("redirect:/list", viewName);
        verify(countryService).deleteCountry(id);
        verifyNoMoreInteractions(countryService);
    }

    @Test
    public void testListCities() {
        int countryId = 1;
        Country country = new Country();
        country.setId(countryId);
        country.setName("CountryName");

        City city1 = new City();
        city1.setContent("City1");
        City city2 = new City();
        city2.setContent("City2");
        List<City> cities = Arrays.asList(city1, city2);

        when(countryService.getCountryById(countryId)).thenReturn(country);
        when(cityService.listCityByCountryId(countryId)).thenReturn(cities);
        String viewName = countryController.listCities(countryId, model);
        assertEquals("listCities", viewName);
        verify(model).addAttribute("country", country);
        verify(model).addAttribute("cities", cities);
        verify(countryService).getCountryById(countryId);
        verify(cityService).listCityByCountryId(countryId);
        verifyNoMoreInteractions(countryService, cityService, model);
    }

    @Test
    public void testShowFormForAddCity() {
        int countryId = 1;
        Country mockCountry = new Country();
        City mockCity = new City();
        mockCity.setCountry(mockCountry);

        when(countryService.getCountryById(countryId)).thenReturn(mockCountry);

        String viewName = countryController.showFormForAddCity(countryId, model);
        verify(countryService).getCountryById(countryId);
        verify(model).addAttribute(eq("city"), any(City.class));
        assertEquals("cityForm", viewName);
    }

    @Test
    public void testSaveCity() {
        City mockCity = new City();
        Country mockCountry = new Country();
        mockCity.setCountry(mockCountry);
        mockCountry.setId(1);

        String viewName = countryController.saveCity(mockCity, model);

        verify(cityService).saveCity(mockCity);
        assertEquals("redirect:/listCities?countryId=1", viewName);
    }

    @Test
    public void testDeleteCity() {
        int cityId = 1;
        int countryId = 2;

        String viewName = countryController.deleteCity(cityId, countryId);

        verify(cityService).deleteCity(cityId);
        assertEquals("redirect:/listCities?countryId=2", viewName);
    }
}
