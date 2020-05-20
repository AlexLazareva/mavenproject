package beans;

import org.junit.Test;
import ru.itparkkazan.beans.PaySystemCore;

public class PaySystemCoreTest {
    private static final String IVANOV_LOGIN = "Ivan";
    private static final String IVANOV_PASSWD = "Ivan";
    private static final String IVANOV_FIRSTNAME = "Сергей";
    private static final String IVANOV_SECONDNAME = "Сергеевич";
    private static final String IVANOV_SURNAME = "Иванов";

    private static final String PETROV_LOGIN = "Petrov";
    private static final String PETROV_PASSWD = "Petrov";
    private static final String PETROV_FIRSTNAME = "Антон";
    private static final String PETROV_SECONDNAME = "Антонович";
    private static final String PETROV_SURNAME = "Петров";

    private PaySystemCore paySystemCore;

    /**
     * Метод проверки отображения всех счетов платежной системы
     */
    @Test
    public void showAllAccountsTest() {
        paySystemCore.showAllClients();
    }

    /**
     * Метод проверки отображения всех клиентов платежной системы
     */
    @Test
    public void showAllClientsTest() {
        paySystemCore.showAllClients();
    }

    /**
     * Метод проверки отображения полной информации клиент-счета платежной системы
     */
    @Test
    public void showAllClientAccountsTest() {
        paySystemCore.showAllClientAccounts();
    }
}
