package com.github.ingogriebsch.sample.spring.boot.graphql.resolver;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.ingogriebsch.sample.spring.boot.graphql.model.Continent;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Continent> continents() {
        return newArrayList(new Continent("Africa"));
    }

}
