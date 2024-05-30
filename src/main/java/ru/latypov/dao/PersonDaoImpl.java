package ru.latypov.dao;

import ru.latypov.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl {

    public void getAllPerson() {
        List<Person> result = new ArrayList<>();
        String SQL_SELECT = "Select * from Person";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("ID");

                Person person = new Person();
                person.setId(id);

                result.add(person);

            }
            result.forEach(person -> System.out.println(person.getId()));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
