package ru.latypov.service.impl;

import lombok.AllArgsConstructor;
import ru.latypov.entity.Car;
import ru.latypov.repository.CarCrudRepository;
import ru.latypov.repository.impl.CarCrudRepositoryImpl;
import ru.latypov.service.CarCrudService;

import java.util.List;

@AllArgsConstructor
public class CarCrudServiceImpl implements CarCrudService {
    private final CarCrudRepository carCrudRepository;

    @Override
    public Car create(Car car) {
        Car savedCar = carCrudRepository.create(car);
        return savedCar;
    }

    @Override
    public Car updateCar(Car car) {
        Car updatedCar = carCrudRepository.update(car);
        return updatedCar;
    }

    @Override
    public Car getById(Long id) {
        Car car = carCrudRepository.getById(id);
        if (car != null) {
            return car;
        }
        throw new RuntimeException("Машина по id не найдена");
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = carCrudRepository.getAll();
        return cars;
    }

    @Override
    public void deleteById(long id) {
        carCrudRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        carCrudRepository.deleteAll();
    }
}
