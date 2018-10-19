package com.github.ingogriebsch.sample.spring.boot.graphql.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.github.ingogriebsch.sample.spring.boot.graphql.model.Continent;
import com.github.ingogriebsch.sample.spring.boot.graphql.model.Country;
import com.github.ingogriebsch.sample.spring.boot.graphql.repository.CountryRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ContinentResolver implements GraphQLResolver<Continent> {

    @NonNull
    private final CountryRepository countryRepository;

    public Iterable<Country> getCountries(@NonNull Continent continent) {
        return countryRepository.findByContinentId(continent.getId());
    }
}
