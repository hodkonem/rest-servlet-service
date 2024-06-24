package ru.latypov.servlet.impl;

import ru.latypov.dao.PersonDaoImpl;
import ru.latypov.dto.PersonDTO;
import ru.latypov.entity.Person;
import ru.latypov.mapper.PersonMapper;
import ru.latypov.service.impl.PersonCrudServiceImpl;
import ru.latypov.servlet.PersonCrudServlet;

import java.util.List;
import java.util.stream.Collectors;

public class PersonCrudServletImpl implements PersonCrudServlet {
    private final PersonCrudServiceImpl personCrudServiceImpl;

    public PersonCrudServletImpl(PersonDaoImpl personDaoImpl) {
        this.personCrudServiceImpl = new PersonCrudServiceImpl(personDaoImpl);
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = PersonMapper.INSTANCE.toEntity(personDTO);
        Person savedPerson = personCrudServiceImpl.createPerson(person);
        return PersonMapper.INSTANCE.toDTO(savedPerson);
    }

    public PersonDTO updatePerson(PersonDTO personDTO) {
        Person person = PersonMapper.INSTANCE.toEntity(personDTO);
        personCrudServiceImpl.updatePerson(person);
        return PersonMapper.INSTANCE.toDTO(person);
    }

    public PersonDTO getPersonById(long id) {
        Person person = personCrudServiceImpl.getPersonById(id);
        return PersonMapper.INSTANCE.toDTO(person);
    }

    public List<PersonDTO> getAllPersons() {
        List<Person> allPersons = personCrudServiceImpl.getAllPersons();
        return allPersons.stream().map(PersonMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    public void deletePerson(long id) {
        personCrudServiceImpl.deletePerson(id);
    }

    public void deleteAllPersons() {
        personCrudServiceImpl.deleteAllPersons();
    }
}
