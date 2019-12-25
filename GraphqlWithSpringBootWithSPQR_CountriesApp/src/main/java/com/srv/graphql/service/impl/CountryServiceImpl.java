package com.srv.graphql.service.impl;

import com.srv.graphql.model.Country;
import com.srv.graphql.repo.CountryRepository;
import com.srv.graphql.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository repo;

    @Override
    public Country saveCountry(Country country) {
        return repo.save(country);
    }

    @Override
    public List<Country> saveAllCountry(List<Country> country) {
        return repo.saveAll(country);
    }

    @Override
    public Integer updateCountry(Country country) {
        return saveCountry(country).getCountryId();
    }

    @Override
    public Country getOneCountry(Integer id) {
        Optional<Country> op = repo.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<Country> getAllCountries() {
        return repo.findAll();
    }

    @Override
    public Integer deleteCountry(Integer continentId) {
        if(checkCountry(continentId)==Boolean.TRUE)
        {
            repo.deleteById(continentId);
            return continentId;
        }else {
            return null;
        }
    }

    @Override
    public Boolean checkCountry(Integer continentId) {
        return repo.existsById(continentId);
    }

    @Override
    public List<Country> getCountriesByCode(String code) {
        return repo.findByCode(code);
    }

}
