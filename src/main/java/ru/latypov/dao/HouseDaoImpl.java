package ru.latypov.dao;

import ru.latypov.constant_app.JdbcUtils;
import ru.latypov.entity.House;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseDaoImpl {

    public List<House> getAllHouses() {
        List<House> result = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM house";

        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                House house = new House();
                house.setId(resultSet.getLong("id"));
                house.setStreet(resultSet.getString("street"));
                result.add(house);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public House getHouseById(long id) {
        String SQL_SELECT = "SELECT * FROM house WHERE id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    House house = new House();
                    house.setId(resultSet.getLong("id"));
                    house.setStreet(resultSet.getString("street"));
                    return house;
                }
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public House createHouse(House house) {
        String SQL_INSERT = "INSERT INTO house(street) VALUES (?)";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, house.getStreet());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        house.setId(generatedKeys.getLong(1));
                    }
                }
                return house;
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


    public House updateHouse(House house) {
        String SQL_UPDATE = "UPDATE house SET street = ? WHERE id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, house.getStreet());
            preparedStatement.setLong(2, house.getId());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return house;
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

    public boolean deleteHouse(long id) {
        String SQL_DELETE = "DELETE FROM house WHERE id = ?";
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

    public void deleteAllHouses() {
        String SQL_DELETE = "DELETE FROM house";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
