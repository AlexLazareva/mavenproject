package ru.itparkkazan.beans;

public class Client implements Person {
    /**
     * Конструктор
     *
     * @param login      логин
     * @param psswd      пароль
     * @param firstname  имя
     * @param secondname отчество
     * @param surname    фамилия
     */
    public Client(String login, String psswd, String firstname, String secondname, String surname) {
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
    }

    /**
     * Конструктор
     * @param id идентификатор
     * @param login логин
     * @param psswd пароль
     * @param firstname имя
     * @param secondname отчество
     * @param surname фамилия
     */
    public Client(int id, String login, String psswd, String firstname, String secondname, String surname) {
        this.id = id;
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
    }

    public Client(int id, String login, String psswd, String firstname, String secondName, String surname, Account account) {
        this.id = id;
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondName;
        this.surname = surname;
        this.account = account;
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
    private Account account;

    public Client(int id, String login, String firstname, String secondname, String surname, Account account) {
        this.id = id;
        this.login = login;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
        this.account = account;
    }



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

    public void setAccounts(Account account) {
        this.account = account;
    }

    public Account getClientAccounts() {
        return account;
    }
}
