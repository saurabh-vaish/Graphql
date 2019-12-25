package com.srv.graphql.service;

import com.srv.graphql.model.Country;

import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */
public interface CountryService {

     Country saveCountry(Country country);

     List<Country> saveAllCountry(List<Country> country);

     Integer updateCountry(Country country);

     Country getOneCountry(Integer countryId);

     List<Country> getAllCountries();

     Integer deleteCountry(Integer countryId);

     Boolean checkCountry(Integer countryId);

     List<Country> getCountriesByCode(String code);
}
