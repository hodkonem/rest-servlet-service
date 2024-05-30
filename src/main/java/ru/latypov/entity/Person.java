package ru.latypov.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class Person {
    private long id;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Car> cars;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<House> houses;
}
