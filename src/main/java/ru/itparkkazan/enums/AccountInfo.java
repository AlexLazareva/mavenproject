package ru.itparkkazan.enums;

public enum AccountInfo {
    /**
     * Идентификатор
     */
    ID("id"),

    /**
     * Номер счета
     */
    ACCOUNT_NUMBER("account_number"),

    /**
     * Сумма пополнения
     */
    SUM("sum"),

    /**
     * Сумма пополнения
     */
    REPLENISH_SUM("replenish_sum"),

    /**
     * Сумма снятия
     */
    WITHDRAWAL_SUM("withdrawal_sum");

    private String accountInfo;

    AccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    public String getAccountInfo() {
        return accountInfo;
    }
}
