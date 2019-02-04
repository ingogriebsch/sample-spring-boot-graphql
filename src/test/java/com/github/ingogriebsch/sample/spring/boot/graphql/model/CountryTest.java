/*
 * Copyright 2019 Ingo Griebsch
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.github.ingogriebsch.sample.spring.boot.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CountryTest {

    @Test(expected = NullPointerException.class)
    public void calling_ctor_with_null_should_throw_exception() throws Exception {
        new Country(null);
    }

    @Test
    public void calling_ctor_with_specific_name_should_create_country_with_given_name() throws Exception {
        String name = "Country";
        assertThat(new Country(name)).isNotNull().hasFieldOrPropertyWithValue("name", name);
    }
}
