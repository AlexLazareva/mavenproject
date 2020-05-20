package ru.itparkkazan.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaySystemCore {
    private List<Account> paySystemAccounts;
    private List<Person> paySystemClients;
    private Map<Client, List<Account>> paySystemClientAccounts;

    private void initClientAccounts() {
        //TODO реализовать метод инициализации полной информации клиент-счета платежной системы
    }

    /**
     * Метод вывода всех счетов ядра платежной системы
     */
    public void showAllAccounts() {
        System.out.println("Список всех счетов: ");
        for (Account account : paySystemAccounts) {
            System.out.println(account.toString());
        }
    }

    public void showAllClients() {
        //TODO написать метод вывода всех клиентов,
        // переопределив в классе Client метод toString для отображения ФИО и списка счетов клиента.
    }

    /**
     * Метод вывода полной информации клиент-счета ядра платежной системы
     */
    public void showAllClientAccounts() {
        for (Map.Entry<Client, List<Account>> entry : paySystemClientAccounts.entrySet()) {
            Client client = entry.getKey();
            System.out.println(client.getFullName());
            System.out.println(client.getClientAccounts());
//            for (Account account : client.getClientAccounts()) {
//                System.out.println(String.join("", " ", account.toString()));
//            }
        }
    }
}
