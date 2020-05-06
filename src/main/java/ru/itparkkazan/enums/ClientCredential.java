package ru.itparkkazan.enums;

public enum ClientCredential {
    ID("id"),
    FIRST_NAME("firstname"),
    SECOND_NAME("secondname"),
    SURNAME("surname"),
    LOGIN("login"),
    PSSWD("psswd"),
    ACCOUNT_ID("account_id");

    private String clientCredentials;

    ClientCredential(String clientCredentials){
        this.clientCredentials = clientCredentials;
    }

    public String getClientCredential() {
        return clientCredentials;
    }
}
