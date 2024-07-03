package ru.latypov.servlet.impl;

import ru.latypov.dto.CarDTO;
import ru.latypov.entity.Car;
import ru.latypov.mapper.CarMapper;
import ru.latypov.service.CarCrudService;
import ru.latypov.servlet.CrudServlet;

import java.util.List;

public class CarCrudServletImpl implements CrudServlet<CarDTO> {
    private final CarCrudService carCrudService;

    public CarCrudServletImpl(CarCrudService carCrudService) {
        this.carCrudService = carCrudService;
    }

    @Override
    public CarDTO create(CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.toEntity(carDTO);
        return CarMapper.INSTANCE.toDTO(carCrudService.create(car));
    }

    @Override
    public CarDTO getById(Long id) {
        return CarMapper.INSTANCE.toDTO(carCrudService.getById(id));
    }

    @Override
    public List<CarDTO> getAll() {
        return CarMapper.INSTANCE.toDtoList(carCrudService.getAllCars());
    }

    @Override
    public CarDTO update(CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.toEntity(carDTO);
        return CarMapper.INSTANCE.toDTO(carCrudService.updateCar(car));
    }

    @Override
    public void deleteById(Long id) {
        carCrudService.deleteById(id);
    }

    @Override
    public void deleteAll() {
        carCrudService.deleteAll();
    }
}
