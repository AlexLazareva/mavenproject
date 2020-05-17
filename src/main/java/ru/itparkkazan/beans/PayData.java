package ru.itparkkazan.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class PayData {
    private Client client;
    private String targetAccount;
    private int sum;
    private Date date;
}
