package com.github.ingogriebsch.sample.spring.boot.graphql.resolver;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.ingogriebsch.sample.spring.boot.graphql.model.Continent;
import com.github.ingogriebsch.sample.spring.boot.graphql.repository.ContinentRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    @NonNull
    private final ContinentRepository continentRepository;

    public Iterable<Continent> continents() {
        return continentRepository.findAll();
    }

    public Optional<Continent> continentByName(@NonNull String name) {
        return continentRepository.findByName(name);
    }

}
