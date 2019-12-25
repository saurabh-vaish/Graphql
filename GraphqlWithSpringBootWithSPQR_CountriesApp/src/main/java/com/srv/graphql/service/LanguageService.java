package com.srv.graphql.service;

import com.srv.graphql.model.Language;

import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */
public interface LanguageService {

     Language saveLanguage(Language language);

     List<Language> saveAllLanguage(List<Language> language);

     Integer updateLanguage(Language language);

     Language getOneLanguage(Integer languageId);

     List<Language> getAllLanguages();

     Integer deleteLanguage(Integer languageId);

     Boolean checkLanguage(Integer languageId);

     List<Language> getLanguagesByCode(String code);
}
