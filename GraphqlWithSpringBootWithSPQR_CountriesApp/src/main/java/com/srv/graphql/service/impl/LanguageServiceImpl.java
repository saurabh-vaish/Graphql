package com.srv.graphql.service.impl;

import com.srv.graphql.model.Language;
import com.srv.graphql.repo.LanguageRepository;
import com.srv.graphql.service.LanguageService;
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
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository repo;

    @Override
    public Language saveLanguage(Language Language) {
        return repo.save(Language);
    }

    @Override
    public List<Language> saveAllLanguage(List<Language> language) {
        return repo.saveAll(language);
    }

    @Override
    public Integer updateLanguage(Language Language) {
        return saveLanguage(Language).getLanguageId();
    }

    @Override
    public Language getOneLanguage(Integer id) {
        Optional<Language> op = repo.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<Language> getAllLanguages() {
        return repo.findAll();
    }

    @Override
    public Integer deleteLanguage(Integer LanguageId) {
        if(checkLanguage(LanguageId)==Boolean.TRUE)
        {
            repo.deleteById(LanguageId);
            return LanguageId;
        }else {
            return null;
        }
    }

    @Override
    public Boolean checkLanguage(Integer LanguageId) {
        return repo.existsById(LanguageId);
    }

    @Override
    public List<Language> getLanguagesByCode(String code) {
        return repo.findByCode(code);
    }

}
