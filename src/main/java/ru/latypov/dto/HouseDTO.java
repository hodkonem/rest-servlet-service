package ru.latypov.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.latypov.entity.Person;

import java.util.List;

@NoArgsConstructor
@Data
public class HouseDTO {
private long id;
private List<Person> persons;

    public HouseDTO(List<Person> persons) {
        this.persons = persons;
    }
}
