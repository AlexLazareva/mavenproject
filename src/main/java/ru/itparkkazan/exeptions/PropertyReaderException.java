package ru.itparkkazan.exeptions;

public class PropertyReaderException extends Exception {
    /**
     * Конструктор без параметров
     */
    public PropertyReaderException() {
        super();
    }

    /**
     * Конструктор с информационным сообщением
     */
    public PropertyReaderException(String message) {
        super(message);
    }
}
