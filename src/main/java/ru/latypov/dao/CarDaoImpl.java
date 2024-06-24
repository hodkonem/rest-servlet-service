package ru.latypov.dao;

import ru.latypov.constant_app.JdbcUtils;
import ru.latypov.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl {
    public List<Car> getAllCars() {
        List<Car> result = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM Car";

        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getLong("id"));
                car.setModel(resultSet.getString("model"));
                result.add(car);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Car getCarById(long id) {
        String SQL_SELECT = "SELECT * FROM Car WHERE id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Car car = new Car();
                    car.setId(resultSet.getLong("id"));
                    car.setModel(resultSet.getString("model"));
                    return car;
                }
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Car createCar(Car car) {
        String SQL_INSERT = "INSERT INTO Car(id, model, person_id) VALUES (?, ?, ?)";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setLong(2, car.getPersonId());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        car.setId(generatedKeys.getLong(1));
                    }
                }
                return car;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Car updateCar(Car car) {
        String SQL_UPDATE = "UPDATE Car SET model = ? WHERE id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setLong(2, car.getId());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return car;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteCar(long id) {
        String SQL_DELETE = "DELETE FROM car WHERE id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE)) {
            preparedStatement.setLong(1, id);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteAllCars() {
        String SQL_DELETE = "DELETE FROM car";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOwnerToCar(Long idCar, Long idPerson) {
        String SQL_UPDATE_CAR = "UPDATE Car SET person_id = ? WHERE id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE_CAR)) {
            preparedStatement.setLong(1, idPerson);
            preparedStatement.setLong(2, idCar);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows != 1) {
                throw new RuntimeException("Машина не найдена");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
