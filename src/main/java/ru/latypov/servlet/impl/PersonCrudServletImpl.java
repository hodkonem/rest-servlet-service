package ru.latypov.servlet.impl;

import ru.latypov.dto.PersonDTO;
import ru.latypov.entity.Person;
import ru.latypov.mapper.PersonMapper;
import ru.latypov.repository.impl.PersonCrudRepositoryImpl;
import ru.latypov.service.impl.PersonCrudServiceImpl;
import ru.latypov.servlet.PersonCrudServlet;

import java.util.List;

public class PersonCrudServletImpl implements PersonCrudServlet {
    private final PersonCrudServiceImpl personCrudServiceImpl;

    public PersonCrudServletImpl(PersonCrudRepositoryImpl personCrudRepositoryImpl) {
        this.personCrudServiceImpl = new PersonCrudServiceImpl(personCrudRepositoryImpl);
    }

    @Override
    public PersonDTO create(PersonDTO person) {
        Person person1 = PersonMapper.INSTANCE.toEntity(person);
        PersonDTO resultDto = PersonMapper.INSTANCE.toDTO(personCrudServiceImpl.createPerson(person1));
        return resultDto;
    }

    @Override
    public PersonDTO getById(Long id) {
        return PersonMapper.INSTANCE.toDTO(personCrudServiceImpl.getPersonById(id));
    }

    @Override
    public List<PersonDTO> getAll() {
        return PersonMapper.INSTANCE.toDtoList(personCrudServiceImpl.getAllPersons());
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        Person entity = PersonMapper.INSTANCE.toEntity(personDTO);
        return PersonMapper.INSTANCE.toDTO(personCrudServiceImpl.updatePerson(entity));
    }

    @Override
    public void deleteById(Long id) {
        personCrudServiceImpl.deletePerson(id);
    }

    @Override
    public void deleteAll() {
        personCrudServiceImpl.deleteAllPersons();
    }
}

