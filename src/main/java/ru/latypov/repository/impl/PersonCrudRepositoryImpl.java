package ru.latypov.repository.impl;

import ru.latypov.dao.impl.PersonDaoImpl;
import ru.latypov.dao.impl.RefCarPersonDaoImpl;
import ru.latypov.dao.impl.RefHousePersonDaoImpl;
import ru.latypov.entity.Person;
import ru.latypov.repository.PersonCrudRepository;

import java.util.List;

public class PersonCrudRepositoryImpl implements PersonCrudRepository {
    private final PersonDaoImpl personDao = new PersonDaoImpl();
    private final RefCarPersonDaoImpl refCarPersonDao = new RefCarPersonDaoImpl();
    private final RefHousePersonDaoImpl  refHousePersonDao = new RefHousePersonDaoImpl();

    public Person createPerson(Person person) {
        return personDao.createPerson(person);
    }

    public Person getPersonById(long id) {
        var personById = personDao.getPersonById(id);
       var personCars = refCarPersonDao.getAllCarsByPersonId(personById.getId());
        personById.setCars(personCars);
        var allHousesByPersonId = refHousePersonDao.getAllHousesByPersonId(personById.getId());
        personById.setHouses(allHousesByPersonId);
        return personById;
    }

    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    public Person updatePerson(Person person) {
        return personDao.updatePerson(person);
    }

    public void deletePersonById(Long id) {
        personDao.deletePerson(id);
        refCarPersonDao.deleteCarByPersonId(id);
        refHousePersonDao.deleteHouseByPersonId(id);
    }

    public void deleteAllPersons() {
        personDao.deleteAllPersons();
    }


}
