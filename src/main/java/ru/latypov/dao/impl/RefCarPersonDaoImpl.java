package ru.latypov.dao.impl;

import ru.latypov.constant_app.JdbcUtils;
import ru.latypov.entity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RefCarPersonDaoImpl {
    //todo написать метод добавления жителю машины
    //todo реализовать каскадное удаление. Если удаляем Персона, то у него удаляются все машины с совпадением person_id

    public void deleteCarByPersonId(Long personId) {}

    public List<Car> getAllCarsByPersonId(long id) {
        List<Car> cars = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM Car WHERE person_id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Car car = new Car();
                    car.setId(resultSet.getLong("id"));
                    car.setModel(resultSet.getString("model"));
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }
}
