package ru.latypov.service;

import ru.latypov.entity.House;

import java.util.List;

public interface HouseCrudService{

    void deleteAll();

    void deleteById(Long id);

    House update(House house);

    List<House> getAll();

    House getById(Long id);

    House create(House house);
}
