package com.github.ingogriebsch.sample.spring.boot.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.ingogriebsch.sample.spring.boot.graphql.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

    Iterable<Country> findByContinentId(String id);

}
