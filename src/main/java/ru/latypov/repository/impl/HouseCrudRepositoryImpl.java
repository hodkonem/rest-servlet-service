package ru.latypov.repository.impl;

import ru.latypov.dao.HouseDao;
import ru.latypov.dao.impl.HouseDaoImpl;
import ru.latypov.entity.House;
import ru.latypov.repository.HouseCrudRepository;

import java.util.List;

public class HouseCrudRepositoryImpl implements HouseCrudRepository {
    private final HouseDao houseDao = new HouseDaoImpl();

    @Override
    public House create(House entity) {
        return houseDao.createHouse(entity);
    }

    @Override
    public House getById(Long id) {
        return houseDao.getHouseById(id);
    }

    @Override
    public List<House> getAll() {
        return houseDao.getAllHouses();
    }

    @Override
    public House update(House entity) {
        return houseDao.updateHouse(entity);
    }

    @Override
    public void deleteById(Long id) {
        houseDao.deleteHouse(id);
    }

    @Override
    public void deleteAll() {
        houseDao.deleteAllHouses();
    }
//todo сделать все круды Когда получаем дом, нужно найти всех персонов, которые живут в этом доме
}
