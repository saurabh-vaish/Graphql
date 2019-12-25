package com.srv.graphql.repo;

import com.srv.graphql.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 25-Dec-19
 */
public interface CountryRepository extends JpaRepository<Country,Integer> {

    List<Country> findByCode(String code);
}
