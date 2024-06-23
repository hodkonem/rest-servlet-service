package ru.latypov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.latypov.dto.PersonDTO;
import ru.latypov.entity.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonDTO toDTO(Person person);
    Person toEntity(PersonDTO personDTO);
}
