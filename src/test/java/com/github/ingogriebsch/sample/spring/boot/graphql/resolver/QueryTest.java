package com.github.ingogriebsch.sample.spring.boot.graphql.resolver;

import static com.google.common.collect.Sets.newHashSet;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

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

    @Test
    public void continentByName_should_return_empty_optional_if_continent_not_available() throws Exception {
        String name = "Africa";
        given(continentRepository.findByName(name)).willReturn(Optional.empty());

        Optional<Continent> optional = query.continentByName(name);
        assertThat(optional).isNotNull();
        assertThat(optional.isPresent()).isFalse();
    }

    @Test
    public void continentByName_should_return_optional_if_continent_available() throws Exception {
        Continent continent = new Continent("Africa");
        given(continentRepository.findByName(continent.getName())).willReturn(of(continent));

        Optional<Continent> optional = query.continentByName(continent.getName());
        assertThat(optional).isNotNull();
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional.get()).isEqualTo(continent);
    }
}
