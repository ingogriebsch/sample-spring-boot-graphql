package com.github.ingogriebsch.sample.spring.boot.graphql;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.ingogriebsch.sample.spring.boot.graphql.model.Continent;
import com.github.ingogriebsch.sample.spring.boot.graphql.repository.ContinentRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Startup implements CommandLineRunner {

    @NonNull
    private final ContinentRepository continentRepository;

    @Override
    public void run(@NonNull String... args) throws Exception {
        List<Continent> continents = newArrayList(new Continent("Africa", 30370000, 1287920000L),
            new Continent("Antarctica", 14000000, 4490L), new Continent("Asia", 44579000, 4545133000L),
            new Continent("Australia", 8600000, 41261000L), new Continent("Europe", 10180000, 742648000L),
            new Continent("North America", 24709000, 587615000L), new Continent("South America", 17840000, 428240000L));
        continentRepository.save(continents);
    }

}
