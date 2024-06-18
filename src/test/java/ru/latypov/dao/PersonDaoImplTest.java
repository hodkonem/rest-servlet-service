package ru.latypov.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.latypov.entity.Person;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoImplTest {
    private PersonDaoImpl dao;

    @BeforeEach
    void setUp() {
        dao = new PersonDaoImpl();
    }

    @AfterEach
    void tearDown() {
        dao.deleteAllPersons();
    }

    @Test
    void createPerson() {
        Person person = new Person();
        person.setName("testCreatePerson");
        Person createdPerson = dao.createPerson(person);
       assertNotNull(createdPerson);
       assertEquals(person.getName(), createdPerson.getName());
    }

    @Test
    void getAllPersons() {
        Person person1 = new Person();
        person1.setName("person1");
        dao.createPerson(person1);

        Person person2 = new Person();
        person2.setName("person2");
        dao.createPerson(person2);

        List<Person> persons = dao.getAllPersons();
        assertEquals(2, persons.size());
    }

    @Test
    void updatePerson() {
        Person person = new Person();
        person.setName("testUpdatePerson");
        var createdPerson = dao.createPerson(person);

        createdPerson.setName("updatedPerson");
        var updatedPerson = dao.updatePerson(createdPerson);
        assertEquals("updatedPerson", updatedPerson.getName());
    }

    @Test
    void deletePerson() {
        Person person = new Person();
        person.setName("testDeletePerson");
        var createdPerson = dao.createPerson(person);

        boolean deleted = dao.deletePerson(createdPerson.getId());
        assertTrue(deleted);

        List<Person> persons = dao.getAllPersons();
        assertEquals(0, persons.size());
    }
}