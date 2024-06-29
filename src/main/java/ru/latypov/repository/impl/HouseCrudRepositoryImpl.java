package ru.latypov.repository.impl;

import ru.latypov.dao.HouseDaoImpl;
import ru.latypov.repository.HouseCrudRepository;

public class HouseCrudRepositoryImpl implements HouseCrudRepository {
    private final HouseDaoImpl houseDao = new HouseDaoImpl();
//todo сделать все круды Когда получаем дом, нужно найти всех персонов, которые живут в этом доме
}
