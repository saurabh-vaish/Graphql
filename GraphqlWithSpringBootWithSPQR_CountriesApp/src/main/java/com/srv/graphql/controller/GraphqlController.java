package com.srv.graphql.controller;


import com.srv.graphql.resolvers.ContinentResolvers;
import com.srv.graphql.resolvers.CountryResolvers;
import com.srv.graphql.resolvers.LanguageResolvers;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */

@RestController
public class GraphqlController{

    @Autowired
    private ContinentResolvers continentResolvers;

    @Autowired
    private CountryResolvers countryResolvers;

    @Autowired
    private LanguageResolvers languageResolvers;

    private final GraphQL graphQL;

    @Autowired
    public GraphqlController(ContinentResolvers continentResolvers,CountryResolvers countryResolvers,LanguageResolvers languageResolvers)
    {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withResolverBuilders(new AnnotatedResolverBuilder())
                .withOperationsFromSingletons(continentResolvers,countryResolvers,languageResolvers)
//                .withOperationBuilder(new DefaultOperationBuilder(DefaultOperationBuilder.TypeInference.LIMITED))
//                .withValueMapperFactory(new JacksonValueMapperFactory())
                .generate();

        graphQL = GraphQL.newGraphQL(schema).build();
    }

    // for rest requests

    @PostMapping(value = "/graphiql", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> indexFromAnnotated(@RequestBody Map<String, String> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request.get("query"))
                .operationName(request.get("operationName"))
                .context(raw)
                .build());
        return executionResult.toSpecification();
    }


//    @Override
//    protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
//        return errors.stream()
//                .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
//                .map(e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
//                .collect(Collectors.toList());
//    }

}
