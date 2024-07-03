package ru.latypov.servlet;

import java.util.List;

public interface CrudServlet<T> {
    T create(T entity);
    T getById(Long id);
    List<T> getAll();
    T update(T entity);
    void deleteById(Long id);
    void deleteAll();
}

