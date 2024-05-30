package ru.latypov.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
public class House {
    private long id;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Person> persons;
}
