package com.srv.graphql.service;

import com.srv.graphql.model.Continent;

import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */
public interface ContinentService {

     Continent saveContinent(Continent continent);

     List<Continent> saveAllContinent(List<Continent> continent);

     Integer updateContinent(Continent continent);

     Continent getOneContinent(Integer continentId);

     List<Continent> getAllContinents();

     Integer deleteContinent(Integer continentId);

     Boolean checkContinent(Integer continentId);

     List<Continent> getContinentsByCode(String code);
}
