package ru.latypov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.latypov.dto.CarDTO;
import ru.latypov.dto.PersonDTO;
import ru.latypov.entity.Person;

import java.util.List;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    @Mapping(target = "carDTOlist", source = "person", qualifiedByName = "mapCarToDto")
    PersonDTO toDTO(Person person);
    Person toEntity(PersonDTO personDTO);
    @Named("mapCarToDto")
    default List<CarDTO> mapCarToDto(Person person){
       return CarMapper.INSTANCE.toDtoList(person.getCars());
    }
    // todo настроить мапинг в персонДТО домов аналогично тому, как настроены машины
}
