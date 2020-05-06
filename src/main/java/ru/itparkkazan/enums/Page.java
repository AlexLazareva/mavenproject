package ru.itparkkazan.enums;

public enum Page {
    INDEX_PAGE("index.jsp"),
    REG_PAGE("/views/registration.jsp"),
    AUTH_PAGE("/views/auth.jsp"),
    ERROR_PAGE("/views/error.jsp"),
    SUCCESS_PAGE("/views/successRegClient.jsp");

    private final String page;

    Page(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public String toString() {
        return page;
    }
}
