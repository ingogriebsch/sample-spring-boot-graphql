package com.github.ingogriebsch.sample.spring.boot.graphql.model;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor(access = PACKAGE)
public class Continent {

    @Id
    @Setter(PRIVATE)
    private String name;
    private Integer area;
    private Long population;

    public Continent(@NonNull String name) {
        this.name = name;
    }
}
