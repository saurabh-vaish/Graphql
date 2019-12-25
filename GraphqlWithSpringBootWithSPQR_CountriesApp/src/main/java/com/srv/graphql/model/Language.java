package com.srv.graphql.model;

import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
public class Language {

//    @GraphQLIgnore
    @Id
    @GeneratedValue(generator = "language")
    @GenericGenerator(name = "language",strategy = "increment")
    private Integer languageId;

    @GraphQLQuery(name = "code",description = "code of the language")
    private String code;

    @GraphQLQuery(name = "name",description = "name of the language")
    private String name;

    @GraphQLQuery(name = "native",description = "native name of the language")
    private String nativeName;


}