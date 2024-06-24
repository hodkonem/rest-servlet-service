package ru.latypov.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Car {
    private long id;
    private Person person;
    private String model;

    public Long getPersonId() {
        return person.getId();
    }
}