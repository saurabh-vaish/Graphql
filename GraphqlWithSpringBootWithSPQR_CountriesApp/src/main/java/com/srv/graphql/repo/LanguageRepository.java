package com.srv.graphql.repo;

import com.srv.graphql.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 25-Dec-19
 */
public interface LanguageRepository extends JpaRepository<Language,Integer> {

    List<Language> findByCode(String code);
}
