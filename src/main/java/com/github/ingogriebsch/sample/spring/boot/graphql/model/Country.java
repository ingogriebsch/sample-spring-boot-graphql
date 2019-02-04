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
