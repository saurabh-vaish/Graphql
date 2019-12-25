package com.srv.graphql.service.impl;

import com.srv.graphql.model.Continent;
import com.srv.graphql.repo.ContinentRepository;
import com.srv.graphql.service.ContinentService;
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
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentRepository repo;

    @Override
    public Continent saveContinent(Continent Continent) {
        return repo.save(Continent);
    }

    @Override
    public List<Continent> saveAllContinent(List<Continent> continent) {
        return repo.saveAll(continent);
    }

    @Override
    public Integer updateContinent(Continent Continent) {
        return saveContinent(Continent).getContinentId();
    }

    @Override
    public Continent getOneContinent(Integer id) {
        Optional<Continent> op = repo.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<Continent> getAllContinents() {
        return repo.findAll();
    }

    @Override
    public Integer deleteContinent(Integer continentId) {
        if(checkContinent(continentId)==Boolean.TRUE)
        {
            repo.deleteById(continentId);
            return continentId;
        }else {
            return null;
        }
    }

    @Override
    public Boolean checkContinent(Integer continentId) {
        return repo.existsById(continentId);
    }

    @Override
    public List<Continent> getContinentsByCode(String code) {
        return repo.findByCode(code);
    }

}
