/*
 * Copyright 2019 Ingo Griebsch
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.github.ingogriebsch.sample.spring.boot.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.github.ingogriebsch.sample.spring.boot.graphql.model.Continent;
import com.github.ingogriebsch.sample.spring.boot.graphql.model.Country;
import com.github.ingogriebsch.sample.spring.boot.graphql.repository.CountryRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContinentResolver implements GraphQLResolver<Continent> {

    @NonNull
    private final CountryRepository countryRepository;

    public Iterable<Country> getCountries(@NonNull Continent continent) {
        return countryRepository.findByContinentId(continent.getId());
    }
}
