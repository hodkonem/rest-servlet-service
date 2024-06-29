package ru.latypov.repository.impl;

import ru.latypov.dao.CarDaoImpl;
import ru.latypov.entity.Car;
import ru.latypov.repository.CarCrudRepository;

import java.util.List;

public class CarCrudRepositoryImpl implements CarCrudRepository {
    private final CarDaoImpl carDao = new CarDaoImpl();

    public Car createCar(Car car) {
        return carDao.createCar(car);
    }

    public Car getCarById(Long id) {
        return carDao.getCarById(id);
        //todo Если у машины, который ты получил, вызвав метод getCarById, заполнено поле person_id, то получить по этому
        // id персона, то добавить этого персона в машину. Если поле не заполненно, то хозяина нет, машину находить не надо
    }

    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    public Car updateCar(Car car) {
        return carDao.updateCar(car);
    }

    public void deleteCarById(Long id) {
        carDao.deleteCar(id);
    }

    public void deleteAllCars() {
        carDao.deleteAllCars();
    }
}
