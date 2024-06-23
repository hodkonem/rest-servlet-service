package ru.latypov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.latypov.dto.HouseDTO;
import ru.latypov.entity.House;

@Mapper
public interface HouseMapper {
    HouseMapper INSTANCE = Mappers.getMapper(HouseMapper.class);
    HouseDTO toDTO(House house);
    House toEntity(HouseDTO houseDTO);
}
