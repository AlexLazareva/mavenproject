package ru.itparkkazan.exeptions;

public class UnregistredAccountException extends Exception {
    /**
     * Конструктор без параметров
     */
    public UnregistredAccountException() {
        super();
    }

    /**
     * Конструктор с инфрмационным сообщением
     * @param message
     */
    public UnregistredAccountException(String message) {
        super(message);
    }
}
