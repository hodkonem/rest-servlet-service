package ru.latypov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.latypov.dto.CarDTO;
import ru.latypov.entity.Car;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDTO toDTO(Car car);

    Car toEntity(CarDTO carDTO);

    List<CarDTO> toDtoList(List<Car> cars);
}
