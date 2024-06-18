package ru.latypov;

import ru.latypov.dao.PersonDaoImpl;
import ru.latypov.entity.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person();
        person.setName("testCreate");
        Person createdPerson = personDao.createPerson(person);
        System.out.println("Created person: " + createdPerson);

        List<Person> allPersons = personDao.getAllPersons();
        System.out.println("All persons: " + allPersons);
    }
}