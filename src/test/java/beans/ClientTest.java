package beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itparkkazan.beans.Client;

public class ClientTest {
    private static final String LOGIN = "Test";
    private static final String PASSWD = "Test";
    private static final String FIRSTNAME = "Петр";
    private static final String SECONDNAME = "Петрович";
    private static final String SURNAME = "Петров";

    private Client client;

    @Before
    public void initClient() {
        client = new Client(LOGIN, PASSWD, FIRSTNAME, SECONDNAME, SURNAME);
    }

    @Test
    public void basicClient() {
        Assert.assertNotNull(client);
        System.out.println("Client's link from basic test " + client);
        Assert.assertEquals(client.toString(), String.valueOf(client));
    }

    @Test
    public void getFullNameTest() {
        String fullName = SURNAME + " " + FIRSTNAME + " " + SECONDNAME;
        Assert.assertEquals(fullName, client.getFullName());

        System.out.println("Client's link from getFullNameTest " + client);
    }
}
