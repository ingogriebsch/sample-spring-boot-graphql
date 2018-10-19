package com.github.ingogriebsch.sample.spring.boot.graphql.resolver;

import static com.google.common.collect.Sets.newHashSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.ingogriebsch.sample.spring.boot.graphql.model.Continent;
import com.github.ingogriebsch.sample.spring.boot.graphql.repository.ContinentRepository;

@RunWith(MockitoJUnitRunner.class)
public class QueryTest {

    @Mock
    private ContinentRepository continentRepository;

    @InjectMocks
    private Query query;

    @Test
    public void continents_should_return_empty_iterable_if_no_continent_available() throws Exception {
        given(continentRepository.findAll()).willReturn(newHashSet());

        Iterable<Continent> continents = query.continents();
        assertThat(continents).isNotNull().isEmpty();
    }

    @Test
    public void continents_should_return_available_continents() throws Exception {
        Continent continent = new Continent("Continent");
        given(continentRepository.findAll()).willReturn(newHashSet(continent));

        Iterable<Continent> continents = query.continents();
        assertThat(continents).isNotNull().contains(continent);
    }
}
