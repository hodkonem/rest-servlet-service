package ru.latypov.repository;

import java.util.List;

public interface CrudRepository<T> {
    T create(T entity);
    T getById(Long id);
    List<T> getAll();
    T update(T entity);
    void deleteById(Long id);
    void deleteAll();
}