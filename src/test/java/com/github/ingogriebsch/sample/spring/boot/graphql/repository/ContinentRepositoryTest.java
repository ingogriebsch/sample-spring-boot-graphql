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

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.ingogriebsch.sample.spring.boot.graphql.model.Continent;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ContinentRepositoryTest {

    @Autowired
    private ContinentRepository continentRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByName_should_return_empty_optional_if_called_with_null() throws Exception {
        Optional<Continent> continent = continentRepository.findByName(null);

        assertThat(continent).isNotNull();
        assertThat(continent.isPresent()).isFalse();
    }

    @Test
    public void findByName_should_return_matching_continent_if_available() throws Exception {
        Continent continent = testEntityManager.persistAndFlush(new Continent("Continent"));

        Optional<Continent> found = continentRepository.findByName(continent.getName());

        assertThat(found).isNotNull();
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get()).isEqualTo(continent);
    }

    @Test
    public void findByName_should_return_empty_optional_if_not_available() throws Exception {
        testEntityManager.persistAndFlush(new Continent("Continent"));

        Optional<Continent> found = continentRepository.findByName("Some completely different continent");

        assertThat(found).isNotNull();
        assertThat(found.isPresent()).isFalse();
    }
}
