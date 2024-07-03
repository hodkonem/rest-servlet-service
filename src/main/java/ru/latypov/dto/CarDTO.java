package ru.latypov.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.latypov.entity.Car;
import ru.latypov.entity.Person;

@Data
@NoArgsConstructor
public class CarDTO {
    private long id;
    private Person person;

    public CarDTO(Person person) {
        this.person = person;
    }

    public static CarDTO fromEntity(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setPerson(car.getPerson());
        return carDTO;
    }
}
