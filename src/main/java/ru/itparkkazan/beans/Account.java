package ru.itparkkazan.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    private int accountNumber;
    private int sum;
    private Person client;
    Boolean isBlocked;

    /**
     * Переопределенный метод вывода класса счета в строку
     * @return номер счета и сумму на нём через разделитель
     */
    @Override
    public String toString() {
        return String.join(" | ", String.valueOf(accountNumber), String.valueOf(sum));
    }
}
