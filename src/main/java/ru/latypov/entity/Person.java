package ru.latypov.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Data
public class Person {
    private long id;
    private String name;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Car> cars;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<House> houses;

    public Person(String newPerson) {
        this.name = newPerson;
        this.cars = new ArrayList<>();
        this.houses = new ArrayList<>();
    }
}
