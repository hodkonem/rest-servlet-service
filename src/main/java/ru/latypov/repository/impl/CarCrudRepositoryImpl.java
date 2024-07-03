package ru.latypov.repository.impl;

import ru.latypov.dao.CarDao;
import ru.latypov.dao.impl.CarDaoImpl;
import ru.latypov.entity.Car;
import ru.latypov.repository.CrudRepository;

import java.util.List;

public class CarCrudRepositoryImpl implements CrudRepository<Car, Long> {
    private final CarDao carDao = new CarDaoImpl();

    @Override
    public Car create(Car car) {
        return carDao.createCar(car);
    }

    @Override
    public Car getById(Long id) {
        return carDao.getCarById(id);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAllCars();
    }

    @Override
    public Car update(Car car) {
        return carDao.updateCar(car);
    }

    @Override
    public void deleteById(Long id) {
        carDao.deleteCar(id);
    }

    @Override
    public void deleteAll() {
        carDao.deleteAllCars();
    }
}