package com.srv.graphql.resolvers;

import com.srv.graphql.model.Language;
import com.srv.graphql.service.LanguageService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */

@Component
@GraphQLApi
public class LanguageResolvers {

    @Autowired
    private LanguageService service;

    /// for query

    @GraphQLQuery(name = "languages")
    public List<Language> getAllCountries()
    {
        return service.getAllLanguages();
    }

    @GraphQLQuery(name="language")
    public List<Language> getLanguageByCode(@GraphQLArgument(name="code") String code)
    {
        return service.getLanguagesByCode(code);
    }


//    @GraphQLQuery(name="customer")
//    public  Language getCustomer(@GraphQLContext Language Language)
//    {
//        return new Language().set;
//    }

//    @GraphQLQuery(name="")

//     Mutation

    @GraphQLMutation(name="saveLanguage")
    public Language saveLanguage(@GraphQLArgument(name="Language") Language language)
    {
        return service.saveLanguage(language);
    }

    @GraphQLMutation(name="saveAllLanguages")
    public List<Language> saveAllLanguages(@GraphQLArgument(name="languages") List<Language> languages)
    {
        return service.saveAllLanguage(languages);
    }

    @GraphQLMutation(name="updateLanguage")
    public Integer updateLanguage(@GraphQLArgument(name="Language") Language language)
    {
        return service.updateLanguage(language);
    }

    @GraphQLMutation(name="deleteLanguage")
    public Integer deleteLanguage(@GraphQLArgument(name="id") Integer id)
    {
        return service.deleteLanguage(id);
    }


}
