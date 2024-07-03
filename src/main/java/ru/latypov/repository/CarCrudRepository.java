package ru.latypov.repository;

import ru.latypov.entity.Car;

import java.util.List;

public interface CarCrudRepository {
    void deleteAll();

    void deleteById(Long id);

    Car update(Car car);

    List<Car> getAll();

    Car getById(Long id);

    Car create(Car car);
}
