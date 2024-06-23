package ru.latypov.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PersonDTO {
    private long id;
    private String name;

    public PersonDTO(String name) {
        this.name = name;
    }
}
