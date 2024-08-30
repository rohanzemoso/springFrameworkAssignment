package com.example.project.controller;

import com.example.project.model.City;
import com.example.project.model.Country;
import com.example.project.service.CountryService;
import com.example.project.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    private static final String COUNTRY = "country";

    private final CountryService countryService;
    private final CityService cityService;

    @Autowired
    public CountryController(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @GetMapping("/list")
    public String listCountries(Model model) {
        List<Country> countries = countryService.listCountry();
        model.addAttribute("countries", countries);
        return "listCountries";
    }

    @PostMapping("/save")
    public String saveCountry(@ModelAttribute Country country, Model model) {
        if (country.getId() != null && country.getId() > 0) {
            Country existingCountry = countryService.getCountryById(country.getId());
            existingCountry.setName(country.getName());
            existingCountry.setTravelledFrom(country.getTravelledFrom());
            countryService.updateCountry(existingCountry);
        } else {
            countryService.saveCountry(country);
        }
        return "redirect:/list";
    }

    @GetMapping("/form")
    public String showFormForAddCountry(Model model) {
        Country country = new Country();
        model.addAttribute(COUNTRY, country);
        return "countryForm";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdateCountry(@RequestParam("countryId") int id, Model model) {
        Country country = countryService.getCountryById(id);
        model.addAttribute(COUNTRY, country);
        return "updateCountry";
    }

    @PostMapping("/delete")
    public String deleteCountry(@RequestParam("countryId") int id) {
        countryService.deleteCountry(id);
        return "redirect:/list";
    }

    @GetMapping("/listCities")
    public String listCities(@RequestParam("countryId") int countryId, Model model) {
        Country country = countryService.getCountryById(countryId);
        List<City> cities = cityService.listCityByCountryId(countryId);
        model.addAttribute(COUNTRY, country);
        model.addAttribute("cities", cities);
        return "listCities";
    }

    @GetMapping("/addCityForm")
    public String showFormForAddCity(@RequestParam("countryId") int countryId, Model model) {
        City city = new City();
        Country country = countryService.getCountryById(countryId);
        city.setCountry(country);
        model.addAttribute("city", city);
        return "cityForm";
    }

    @PostMapping("/saveCity")
    public String saveCity(@ModelAttribute City city, Model model) {
        cityService.saveCity(city);
        return "redirect:/listCities?countryId=" + city.getCountry().getId();
    }

    @GetMapping("/deleteCity")
    public String deleteCity(@RequestParam("cityId") int cityId, @RequestParam("countryId") int countryId) {
        cityService.deleteCity(cityId);
        return "redirect:/listCities?countryId=" + countryId;
    }
}
