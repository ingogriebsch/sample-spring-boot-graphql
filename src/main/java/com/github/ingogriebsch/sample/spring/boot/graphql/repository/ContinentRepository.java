package com.github.ingogriebsch.sample.spring.boot.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.ingogriebsch.sample.spring.boot.graphql.model.Continent;

@Repository
public interface ContinentRepository extends CrudRepository<Continent, String> {

}