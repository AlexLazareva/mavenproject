package ru.itparkkazan.enums;

public enum DbProperty {
    /**
     * Драйвер БД
     */
    DRIVER_NAME_PROPERTY_NAME("driver_name"),

    /**
     * Адрес БД
     */
    URL_PROPERTY_NAME("url"),

    /**
     * Пользователь для подключения
     */
    USER_PROPERTY_NAME("user"),

    /**
     * Пользователь для подключения
     */
    PSSWD_PROPERTY_NAME("password");

    private String property;

    DbProperty(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
