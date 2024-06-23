package ru.latypov;

import ru.latypov.dao.PersonDaoImpl;
import ru.latypov.dto.PersonDTO;
import ru.latypov.servlet.impl.PersonCrudServletImpl;

public class Main {

    public static void main(String[] args) {
//        PersonDaoImpl personDao = new PersonDaoImpl();
//
//        // Проверка метода getAllPersons()
//        List<Person> allPersons = personDao.getAllPersons();
//        System.out.println("All Persons:");
//        for (Person person : allPersons) {
//            System.out.println(person);
//        }
//
//        // Проверка метода getPersonById()
//        long id = 1; // Укажите существующий id
//        Person personById = personDao.getPersonById(id);
//        System.out.println("Person with id=" + id + ": " + personById);
//
//        // Проверка метода createPerson()
//        Person newPerson = new Person("New Person");
//        Person createdPerson = personDao.createPerson(newPerson);
//        System.out.println("Created Person: " + createdPerson);
//
//        // Проверка метода updatePerson()
//        Person personToUpdate = allPersons.get(0); // Получаем первого человека из списка
//        personToUpdate.setName("Updated Name");
//        Person updatedPerson = personDao.updatePerson(personToUpdate);
//        System.out.println("Updated Person: " + updatedPerson);

        PersonCrudServletImpl personCrudServlet = new PersonCrudServletImpl(new PersonDaoImpl());
        personCrudServlet.createPerson(new PersonDTO("Vasya"));
    }
}