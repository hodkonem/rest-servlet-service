package ru.latypov;

import ru.latypov.dao.PersonDaoImpl;
import ru.latypov.entity.Person;

public class Main {
    public static void main(String[] args) {

        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person();
        person.setName("testCreate");
        personDao.createPerson(person);
        personDao.getAllPersons();
    }
}