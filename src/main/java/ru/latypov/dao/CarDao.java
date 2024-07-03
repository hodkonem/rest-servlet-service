package ru.latypov.dao;

import ru.latypov.entity.Car;

import java.util.List;

public interface CarDao {
    boolean deleteCar(long id);

    Car updateCar(Car car);

    Car createCar(Car car);

    Car getCarById(long id);

    List<Car> getAllCars();

    void deleteAllCars();
}
