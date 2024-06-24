package ru.latypov.service.impl;

public class PersonValidateServiceImpl {
    public boolean validateName(String name) {
        return !name.matches(".*\\d+.*");
    }
}