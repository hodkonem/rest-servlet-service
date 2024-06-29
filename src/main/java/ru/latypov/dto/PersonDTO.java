package ru.latypov.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class PersonDTO {
    private long id;
    private String name;
    List<HouseDTO> houseDTO;
    List<CarDTO> carDTOlist;

    public PersonDTO(String name) {
        this.name = name;
    }
}
