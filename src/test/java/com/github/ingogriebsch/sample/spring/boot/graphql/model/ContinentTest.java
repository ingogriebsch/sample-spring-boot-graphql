package com.github.ingogriebsch.sample.spring.boot.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ContinentTest {

    @Test(expected = NullPointerException.class)
    public void calling_ctor_with_null_should_throw_exception() throws Exception {
        new Continent(null);
    }

    @Test
    public void calling_ctor_with_specific_name_should_create_continent_with_given_name() throws Exception {
        String name = "Continent";
        assertThat(new Continent(name)).isNotNull().hasFieldOrPropertyWithValue("name", name);
    }
}
