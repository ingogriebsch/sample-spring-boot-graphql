package com.github.ingogriebsch.sample.spring.boot.graphql.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.ingogriebsch.sample.spring.boot.graphql.model.Continent;
import com.github.ingogriebsch.sample.spring.boot.graphql.model.Country;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByContinentId_should_return_empty_iterable_if_called_with_null() throws Exception {
        assertThat(countryRepository.findByContinentId(null)).isNotNull().isEmpty();
    }

    @Test
    public void findByContinentId_should_return_related_countries() throws Exception {
        Continent continent = testEntityManager.persistAndFlush(new Continent("Continent"));
        Country country = new Country("country");
        country.setContinent(continent);
        country = testEntityManager.persistAndFlush(country);

        assertThat(countryRepository.findByContinentId(continent.getId())).isNotNull().containsExactly(country);
    }
}
