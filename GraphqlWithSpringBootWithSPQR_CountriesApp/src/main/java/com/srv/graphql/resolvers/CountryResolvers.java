package com.srv.graphql.resolvers;

import com.srv.graphql.model.Continent;
import com.srv.graphql.model.Country;
import com.srv.graphql.service.CountryService;
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
public class CountryResolvers {

    @Autowired
    private CountryService service;

    /// for query

    @GraphQLQuery(name = "countries")
    public List<Country> getAllCountries()
    {
        return service.getAllCountries();
    }

    @GraphQLQuery(name="country")
    public List<Country> getCountryById(@GraphQLArgument(name="code") String code)
    {
        return service.getCountriesByCode(code);
    }


//    @GraphQLQuery(name="customer")
//    public  Country getCustomer(@GraphQLContext Country Country)
//    {
//        return new Country().set;
//    }

//    @GraphQLQuery(name="")

//     Mutation

    @GraphQLMutation(name="saveCountry")
    public Country saveCountry(@GraphQLArgument(name="Country") Country country)
    {
        return service.saveCountry(country);
    }

    @GraphQLMutation(name="saveAllCountries")
    public List<Country> saveAllCountries(@GraphQLArgument(name="countries") List<Country> country)
    {
        return service.saveAllCountry(country);
    }

    @GraphQLMutation(name="updateCountry")
    public Integer updateCountry(@GraphQLArgument(name="Country") Country country)
    {
        return service.updateCountry(country);
    }

    @GraphQLMutation(name="deleteCountry")
    public Integer deleteCountry(@GraphQLArgument(name="id") Integer id)
    {
        return service.deleteCountry(id);
    }


}
