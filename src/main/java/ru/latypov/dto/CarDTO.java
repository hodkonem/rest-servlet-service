package ru.latypov.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.latypov.entity.Person;

@Data
@NoArgsConstructor
public class CarDTO {
    private long id;
    private Person person;

    public CarDTO(Person person) {
        this.person = person;
    }
}
