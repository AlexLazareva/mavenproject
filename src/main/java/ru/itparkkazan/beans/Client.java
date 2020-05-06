package ru.itparkkazan.beans;

import java.util.List;

public class Client implements Person {

    public Client(String login, String psswd, String firstname, String secondname, String surname) {
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
    }

    public Client(int id, String login, String psswd, String firstname, String secondname, String surname) {
        this.id = id;
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
    }

    /**
     * Конструктор по-умолчанию
     */
    public Client() {}

    private int id;
    private String login;
    private String psswd;
    private String firstname;
    private String secondname;
    private String surname;
    private List<Account> clientAccounts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPsswd() {
        return psswd;
    }

    public void setPsswd(String psswd) {
        this.psswd = psswd;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getFullName() {
        return String.join(" ", surname, firstname, secondname);
    }

    @Override
    public void setAccounts(List<Account> personAccounts) {
        this.clientAccounts = personAccounts;
    }

    public List<Account> getClientAccounts() {
        return clientAccounts;
    }
}
