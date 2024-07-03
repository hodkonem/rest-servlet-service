package ru.latypov.service;

import ru.latypov.entity.Car;

import java.util.List;

public interface CarCrudService {
    Car create(Car Car);

    Car updateCar(Car Car);

    Car getById(Long id);

    List<Car> getAllCars();

    void deleteById(long id);

    void deleteAll();
}