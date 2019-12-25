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
public class Country {

//    @GraphQLIgnore
    @Id
    @GeneratedValue(generator = "country")
    @GenericGenerator(name = "country",strategy = "increment")
    private Integer countryId;

    @GraphQLQuery(name = "code",description = "code of the country")
    private String code;

    @GraphQLQuery(name = "name",description = "name of the country")
    private String name;

    @GraphQLQuery(name = "native",description = "native name of the country")
    private String nativeName;

    @GraphQLQuery(name = "phone",description = "phone code of the country")
    private String phone;

    @GraphQLQuery(name = "currency",description = "currency of the country")
    private String currency;

    @ManyToOne
    @JoinColumn(name="continentId")
    @GraphQLQuery(name = "continent",description = "continent of the country")
    private Continent continent;

    @GraphQLQuery(name="languages",description = "languages in the continent")
    @OneToMany( cascade = {CascadeType.REMOVE}, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Language> languages;
}