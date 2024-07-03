package ru.latypov.dao;

import ru.latypov.entity.House;

import java.util.List;

public interface HouseDao {
    void deleteAllHouses();

    boolean deleteHouse(long id);

    House updateHouse(House house);

    House createHouse(House house);

    House getHouseById(long id);

    List<House> getAllHouses();
}
