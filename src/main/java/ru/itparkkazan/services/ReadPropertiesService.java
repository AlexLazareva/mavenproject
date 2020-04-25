package ru.itparkkazan.services;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.exeptions.DataSourceServiceException;
import ru.itparkkazan.exeptions.PropertyReaderException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class ReadPropertiesService {

    /**
     * Название файла для считывания информации о БД
     */
    public static final String DATA_SOURCE_PROPERTY_PATH = "datasource.properties";

    public static Properties readDataSourceProperty() throws DataSourceServiceException, PropertyReaderException {
        try(InputStream inputStream = ReadPropertiesService.class.getClassLoader().getResourceAsStream(DATA_SOURCE_PROPERTY_PATH)) {
            log.info(String.join(" ", "Считывание файла", DATA_SOURCE_PROPERTY_PATH));
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            log.error(String.join(" ", "Ошибка во время считывания", DATA_SOURCE_PROPERTY_PATH), e);
            throw new PropertyReaderException(String.join(" ", "Ошибка во время считывания файла", DATA_SOURCE_PROPERTY_PATH));
        }
    }
}
