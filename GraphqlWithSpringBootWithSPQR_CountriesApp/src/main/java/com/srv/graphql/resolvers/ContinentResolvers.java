package com.srv.graphql.resolvers;

import com.srv.graphql.model.Continent;
import com.srv.graphql.service.ContinentService;
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
public class ContinentResolvers {

    @Autowired
    private ContinentService service;

    /// for query

    @GraphQLQuery(name = "continents")
    public List<Continent> getAllContinents()
    {
        return service.getAllContinents();
    }

    @GraphQLQuery(name="continent")
    public List<Continent> getContinentByCode(@GraphQLArgument(name="code") String code)
    {
        return service.getContinentsByCode(code);
    }


//    @GraphQLQuery(name="customer")
//    public  Continent getCustomer(@GraphQLContext Continent Continent)
//    {
//        return new Continent().set;
//    }

//    @GraphQLQuery(name="")

//     Mutation

    @GraphQLMutation(name="saveContinent")
    public Continent saveContinent(@GraphQLArgument(name="continent") Continent continent)
    {
        return service.saveContinent(continent);
    }

    @GraphQLMutation(name="saveAllContinents")
    public List<Continent> saveAllContinents(@GraphQLArgument(name="continents") List<Continent> continent)
    {
        return service.saveAllContinent(continent);
    }



    @GraphQLMutation(name="updateContinent")
    public Integer updateContinent(@GraphQLArgument(name="continent") Continent continent)
    {
        return service.updateContinent(continent);
    }

    @GraphQLMutation(name="deleteContinent")
    public Integer deleteContinent(@GraphQLArgument(name="id") Integer id)
    {
        return service.deleteContinent(id);
    }


}
