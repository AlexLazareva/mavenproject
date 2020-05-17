package ru.itparkkazan.enums;

public enum Page {
    INDEX_PAGE("index.jsp"),
    REG_PAGE("/auth/registration.jsp"),
    AUTH_PAGE("/auth/auth.jsp"),
    ERROR_PAGE("/views/error.jsp"),
    SUCCESS_REG_PAGE("/views/successRegClient.jsp"),
    SUCCESS_AUTH_PAGE("/views/successAuthClient.jsp");

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
