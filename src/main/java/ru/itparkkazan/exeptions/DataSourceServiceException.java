package ru.itparkkazan.exeptions;

public class DataSourceServiceException extends Exception {
    /**
     * Конструктор без параметров
     */
    public DataSourceServiceException() {
        super();
    }

    /**
     * Конструктор с информационным сообщением
     */
    public DataSourceServiceException(String message) {
        super(message);
    }
}
