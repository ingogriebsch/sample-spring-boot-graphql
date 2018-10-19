package com.github.ingogriebsch.sample.spring.boot.graphql.model;

import static java.util.UUID.randomUUID;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor(access = PACKAGE)
public class Country {

    @Id
    private final String id = randomUUID().toString();

    @Setter(PRIVATE)
    private String name;
    private Integer area;
    private Long population;
    private Integer density;

    @ManyToOne
    private Continent continent;

    public Country(@NonNull String name) {
        this.name = name;
    }
}
