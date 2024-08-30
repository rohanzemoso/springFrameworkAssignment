package com.example.project.service;

import com.example.project.dao.CountryDao;
import com.example.project.model.Country;
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
public class CountryServiceImplTest {

    @Mock
    private CountryDao countryDao;

    @InjectMocks
    private CountryServiceImpl countryService;

    @Before
    public void setUp() {

    }

    @Test
    public void testSaveCountry() {
        Country country = new Country();
        countryService.saveCountry(country);
        verify(countryDao, times(1)).saveCountry(country);
    }

    @Test
    public void testListCountry() {
        List<Country> expectedCountries = Arrays.asList(new Country(), new Country());
        when(countryDao.listCountry()).thenReturn(expectedCountries);

        List<Country> actualCountries = countryService.listCountry();

        assertNotNull(actualCountries);
        assertEquals(2, actualCountries.size());
        verify(countryDao, times(1)).listCountry();
    }

    @Test
    public void testGetCountryById() {
        int countryId = 1;
        Country expectedCountry = new Country();
        when(countryDao.getCountryById(countryId)).thenReturn(expectedCountry);

        Country actualCountry = countryService.getCountryById(countryId);

        assertNotNull(actualCountry);
        verify(countryDao, times(1)).getCountryById(countryId);
    }

    @Test
    public void testUpdateCountry() {
        Country country = new Country();
        countryService.updateCountry(country);
        verify(countryDao, times(1)).updateCountry(country);
    }

    @Test
    public void testDeleteCountry() {
        int countryId = 1;
        countryService.deleteCountry(countryId);
        verify(countryDao, times(1)).deleteCountry(countryId);
    }
}
