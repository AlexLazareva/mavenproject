package ru.itparkkazan.dao;

/**
 * Запросы к таблице pay_data
 */
public class PayDataQuerier {
    /**
     * SQL-запрос для вставки в БД информации о платеже
     */
    protected static final String INSERT_INTO_PAY_DATA_VALUES = "INSERT INTO PAYSYSTEM.PAYSYSTEM.PAY_DATA (CLIENT_ID, TARGET_ACCOUNT, SUM, DATE) VALUES (?, ?, ?, ?)";
}
