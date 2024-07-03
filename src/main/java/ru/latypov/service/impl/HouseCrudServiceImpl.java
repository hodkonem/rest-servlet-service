package ru.latypov.service.impl;

import ru.latypov.entity.House;
import ru.latypov.repository.HouseCrudRepository;
import ru.latypov.repository.impl.HouseCrudRepositoryImpl;
import ru.latypov.service.HouseCrudService;

import java.util.List;

public class HouseCrudServiceImpl implements HouseCrudService {
    private final HouseCrudRepository houseCrudRepository = new HouseCrudRepositoryImpl();
    @Override
    public void deleteAll() {
        houseCrudRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        houseCrudRepository.deleteById(id);
    }

    @Override
    public House update(House house) {
        return houseCrudRepository.update(house);
    }

    @Override
    public List<House> getAll() {
        return houseCrudRepository.getAll();
    }

    @Override
    public House getById(Long id) {
        return houseCrudRepository.getById(id);
    }

    @Override
    public House create(House house) {
        return houseCrudRepository.create(house);
    }
}
