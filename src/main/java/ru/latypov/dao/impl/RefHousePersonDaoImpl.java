package ru.latypov.dao.impl;

import ru.latypov.constant_app.JdbcUtils;
import ru.latypov.entity.House;
import ru.latypov.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RefHousePersonDaoImpl {

    public void createRefPersonHouse(Long personId, Long houseId) {
        String SQL_INSERT = "INSERT INTO ref_house_person(person_id, house_id) VALUES (?, ?)";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, personId);
            preparedStatement.setLong(2, houseId);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("Житель добавлен");
                    }
                }
            } else {
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Person> getAllPersonsByHouseId(Long houseId) {
        List<Person> result = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM Person JOIN ref_house_person ON Person.id = ref_house_person.person_id WHERE ref_house_person.house_id = ?";

        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
        ) {
            preparedStatement.setLong(1, houseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setName(resultSet.getString("name"));
                result.add(person);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deleteHouseByPersonId(Long id) {
        String SQL_DELETE = "DELETE FROM ref_house_person WHERE person_id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE);
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<House> getAllHousesByPersonId(long id) {
        List<House> result = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM house JOIN ref_house_person ON house_id = ref_house_person.house_id WHERE ref_house_person.person_id = ?";

        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
        ) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
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
}
