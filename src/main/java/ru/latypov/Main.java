package ru.latypov;

import ru.latypov.dao.PersonDaoImpl;
import ru.latypov.entity.Person;

public class Main {
    public static void main(String[] args) {

        PersonDaoImpl personDao = new PersonDaoImpl();
        Person person = new Person();
        person.setName("testCreate");

        // Проверка поиска существующего объекта
        Person createdPerson = personDao.createPerson(person);
        System.out.println("Created person: " + createdPerson);

        Person foundPerson = personDao.getPersonById(createdPerson.getId());
        System.out.println("Found person: " + foundPerson);


    }
}