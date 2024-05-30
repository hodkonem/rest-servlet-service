package ru.latypov;

import ru.latypov.dao.PersonDaoImpl;

public class Main {
    public static void main(String[] args) {

        PersonDaoImpl personDao = new PersonDaoImpl();
        personDao.getAllPerson();
    }
}