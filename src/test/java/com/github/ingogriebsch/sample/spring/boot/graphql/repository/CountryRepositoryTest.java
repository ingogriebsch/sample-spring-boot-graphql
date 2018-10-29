/*
 * Copyright 2018 Ingo Griebsch
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
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
