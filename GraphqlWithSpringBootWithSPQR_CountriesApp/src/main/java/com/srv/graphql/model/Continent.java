package com.srv.graphql.model;

import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 25-Dec-19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Continent {

    @Id
    @GeneratedValue(generator = "continent")
    @GenericGenerator(name = "continent",strategy = "increment")
//    @GraphQLIgnore
    private Integer continentId;

    @GraphQLQuery(name = "code",description = "code of the Continent")
    private String code;

    @GraphQLQuery(name = "name",description = "name of the continent")
    private String name;

    @OneToMany(mappedBy = "continent", cascade = {CascadeType.REMOVE}, orphanRemoval = true,fetch = FetchType.EAGER)
    @GraphQLQuery(name="countries",description = "countries in the continent")
    private List<Country> countries;
}