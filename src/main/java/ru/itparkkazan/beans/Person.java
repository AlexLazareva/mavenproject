package ru.itparkkazan.beans;

import java.util.List;

public interface Person {
    /**
     * Метод для получения полного имени
     * @return
     */
    // TODO описать методы интерфейса персоны
    String getFullName();

    /**
     * Сеттер счетов
     * @param account
     */
    void setAccounts(List<Account> personAccounts);
}
