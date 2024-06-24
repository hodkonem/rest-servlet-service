package ru.latypov.service.impl;

import lombok.AllArgsConstructor;
import ru.latypov.dao.CarDaoImpl;
import ru.latypov.service.CarCrudService;

@AllArgsConstructor
public class CarCrudServiceImpl implements CarCrudService {
    private final CarDaoImpl carDaoImpl;
}
