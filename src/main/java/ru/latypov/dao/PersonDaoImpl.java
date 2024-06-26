package ru.latypov.dao;

import ru.latypov.constant_app.JdbcUtils;
import ru.latypov.entity.Person;
import ru.latypov.service.impl.PersonValidateServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl {
    private PersonValidateServiceImpl personValidateService;

    public List<Person> getAllPersons() {
        List<Person> result = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM Person";

        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
             ResultSet resultSet = preparedStatement.executeQuery()) {
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

    public Person getPersonById(long id) {
        String SQL_SELECT = "SELECT * FROM Person WHERE id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getLong("id"));
                    person.setName(resultSet.getString("name"));
                    return person;
                }
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person createPerson(Person person) {
        String SQL_INSERT = "INSERT INTO Person(name) VALUES (?)";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, person.getName());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        person.setId(generatedKeys.getLong(1));
                    }
                }
                return person;
            } else {
                throw new IllegalArgumentException("Name must not contain digits"); //todo посмотреть
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person updatePerson(Person person) {
        String SQL_UPDATE = "UPDATE Person SET name = ? WHERE id = ?";
        try (Connection conn = JdbcUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setLong(2, person.getId());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return person;
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

    public boolean deletePerson(long id) {
        String SQL_DELETE = "DELETE FROM Person WHERE id = ?";
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

    public void deleteAllPersons() {
        String SQL_DELETE = "DELETE FROM Person";
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
