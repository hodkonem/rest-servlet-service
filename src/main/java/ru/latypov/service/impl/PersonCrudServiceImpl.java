package ru.latypov.service.impl;

import lombok.AllArgsConstructor;
import ru.latypov.entity.Person;
import ru.latypov.repository.impl.PersonCrudRepositoryImpl;
import ru.latypov.service.PersonCrudService;

import java.util.List;

@AllArgsConstructor
public class PersonCrudServiceImpl implements PersonCrudService {
    private final PersonCrudRepositoryImpl personCrudRepository;


    public Person createPerson(Person person) {
        return personCrudRepository.createPerson(person);
    }

    public Person updatePerson(Person person) {
        return personCrudRepository.updatePerson(person);
    }

    public Person getPersonById(long id) {
        return personCrudRepository.getPersonById(id);
    }

    public List<Person> getAllPersons() {
        return personCrudRepository.getAllPersons();
    }

    public void deleteAllPersons() {
        personCrudRepository.deleteAllPersons();
    }

    public void deletePerson(long id) {
        personCrudRepository.deletePersonById(id);
    }
}