package ru.latypov.service.impl;

import lombok.AllArgsConstructor;
import ru.latypov.dao.PersonDaoImpl;
import ru.latypov.entity.Person;
import ru.latypov.service.PersonCrudService;

import java.util.List;

@AllArgsConstructor
public class PersonCrudServiceImpl implements PersonCrudService {
    private final PersonDaoImpl personDaoimpl;

    public Person getPersonById(long id) {
        return personDaoimpl.getPersonById(id);
    }

    public List<Person> getAllPersons() {
        return personDaoimpl.getAllPersons();
    }

    public Person updatePerson(Person person) {
        return personDaoimpl.updatePerson(person);
    }

    public void deletePerson(long id) {
        personDaoimpl.deletePerson(id);
    }

    public Person createPerson(Person person) {
        return personDaoimpl.createPerson(person);
    }

    public void deleteAllPersons() {
        personDaoimpl.deleteAllPersons();
    }
}