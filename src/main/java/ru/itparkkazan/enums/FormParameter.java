package ru.itparkkazan.enums;

public enum FormParameter {
    /**
     * Параметр для входа в систему
     */
    ENTER_PARAMETER("enter"),

    /**
     * Параметр для регистрации в системе
     */
    REG_PARAMETER("reg");

    private String formParameter;

    FormParameter(String formParameter) {
        this.formParameter = formParameter;
    }

    public String getFormParameter() {
        return formParameter;
    }
}
