package ru.itparkkazan.services;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.util.Properties;

/**
 * Класс для работы с БД
 */
@Slf4j
public class DataSourceService {

    private Properties properties;
    private Connection connection;

    public DataSourceService() {
        try {

        } catch ( e) {

        }
    }
}
