package ru.itparkkazan.utils;

import ru.itparkkazan.beans.Account;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.dao.AccountDAO;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.exeptions.UnregistredAccountException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SessionUtil {
    public static Map<String, String> readClientCredentials(HttpServletRequest httpServletRequest) {
        Map<String, String> result  = new HashMap<>();
        String clientFirstName = httpServletRequest.getParameter(ClientCredentialsInfo.FIRST_NAME);
        String clientSecondName = httpServletRequest.getParameter(ClientCredentialsInfo.SECOND_NAME);
        String clientSurname = httpServletRequest.getParameter(ClientCredentialsInfo.SURNAME);
        String clientLogin = httpServletRequest.getParameter(ClientCredentialsInfo.LOGIN);
        String clientPsswd = httpServletRequest.getParameter(ClientCredentialsInfo.PSSWD);

        result.put(ClientCredentialsInfo.FIRST_NAME, clientFirstName);
        result.put(ClientCredentialsInfo.SECOND_NAME, clientSecondName);
        result.put(ClientCredentialsInfo.SURNAME, clientSurname);
        result.put(ClientCredentialsInfo.LOGIN, clientLogin);
        result.put(ClientCredentialsInfo.PSSWD, clientPsswd);

        return result;
    }

    public static void fillSession(HttpSession httpSession, Client client) {
        httpSession.setAttribute(ClientCredentialsInfo.FIRST_NAME, client.getFirstname());
        httpSession.setAttribute(ClientCredentialsInfo.SECOND_NAME, client.getSecondname());
        httpSession.setAttribute(ClientCredentialsInfo.SURNAME, client.getSurname());
        httpSession.setAttribute(ClientCredentialsInfo.LOGIN, client.getLogin());
        httpSession.setAttribute(ClientCredentialsInfo.PSSWD, client.getPsswd());
        httpSession.setMaxInactiveInterval(300);
    }

    public static Client getClientFromSession(HttpSession httpSession) throws UnregistredAccountException {
        AccountDAO accountDAO = new AccountDAO();
        Account account = accountDAO.getById((int) httpSession.getAttribute(ClientCredential.ACCOUNT_ID.getClientCredential()));
        return new Client(
                (int) httpSession.getAttribute(ClientCredential.ID.getClientCredential()),
                (String) httpSession.getAttribute(ClientCredential.LOGIN.getClientCredential()),
                (String) httpSession.getAttribute(ClientCredential.FIRST_NAME.getClientCredential()),
                (String) httpSession.getAttribute(ClientCredential.SECOND_NAME.getClientCredential()),
                (String) httpSession.getAttribute(ClientCredential.SURNAME.getClientCredential()),
                account);
    }
}
