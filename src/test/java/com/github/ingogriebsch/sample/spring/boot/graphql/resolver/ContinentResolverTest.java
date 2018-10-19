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
import com.github.ingogriebsch.sample.spring.boot.graphql.model.Country;
import com.github.ingogriebsch.sample.spring.boot.graphql.repository.CountryRepository;

@RunWith(MockitoJUnitRunner.class)
public class ContinentResolverTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private ContinentResolver continentResolver;

    @Test(expected = NullPointerException.class)
    public void getCountries_should_throw_exception_if_called_with_null() throws Exception {
        continentResolver.getCountries(null);
    }

    @Test
    public void getCountries_should_return_related_countries() throws Exception {
        Continent continent = new Continent("Continent");
        Country country = new Country("Country");

        given(countryRepository.findByContinentId(continent.getId())).willReturn(newHashSet(country));

        Iterable<Country> countries = continentResolver.getCountries(continent);
        assertThat(countries).isNotNull().containsExactly(country);
    }
}
