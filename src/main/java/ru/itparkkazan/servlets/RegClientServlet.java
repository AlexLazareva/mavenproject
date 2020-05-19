package ru.itparkkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Account;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.dao.AccountDAO;
import ru.itparkkazan.dao.ClientDAO;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.exeptions.UnregistredAccountException;
import ru.itparkkazan.exeptions.UnregistredClientException;
import ru.itparkkazan.utils.ServletUtil;
import ru.itparkkazan.utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@WebServlet(name = "regClient", urlPatterns = "/regClient")
public class RegClientServlet extends HttpServlet {
    /**
     * Обработка post-запроса
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, String> clientCredentials = SessionUtil.readClientCredentials(httpServletRequest);

        if (isLoginAlreadyExist(clientCredentials.get(ClientCredential.LOGIN.getClientCredential()))) {
           try {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + Page.REG_PAGE.getPage() + "?message=" + URLEncoder.encode("Пользователь с таким логином уже есть", "UTF-8"));
           } catch (UnsupportedEncodingException e) {
               log.error("Ошибка при декодировании текста для страницы " + Page.REG_PAGE.getPage(), e);
           } catch (IOException e) {
               e.printStackTrace();
           }
        } else {
            AccountDAO accountDAO = new AccountDAO();

            List<Account> allAccountNumbers = accountDAO.getAll();
            int accountNumber;
            Account currentAccount;

            do {
                accountNumber = ThreadLocalRandom.current().nextInt(10000, 99999);
                currentAccount = new Account(accountNumber);
            } while (allAccountNumbers.contains(currentAccount));
            accountDAO.insert(currentAccount);

            try {
                currentAccount = accountDAO.get(String.valueOf(accountNumber));
            } catch (Exception e) {
                log.error("Ошибка при попытке получить объект счета по номеру ", e);
                //TODO обработать исключение
            }

            //TODO Добавить валидацию пользователя в форме регистрации
            Client client = new Client(
                    clientCredentials.get(ClientCredential.LOGIN.getClientCredential()),
                    clientCredentials.get(ClientCredential.PSSWD.getClientCredential()),
                    clientCredentials.get(ClientCredential.FIRST_NAME.getClientCredential()),
                    clientCredentials.get(ClientCredential.SECOND_NAME.getClientCredential()),
                    clientCredentials.get(ClientCredential.SURNAME.getClientCredential())
            );
            ClientDAO clientDAO = new ClientDAO();
            clientDAO.insert(client);

            HttpSession httpSession = httpServletRequest.getSession();
            try {
                client = clientDAO.get(ClientCredential.LOGIN.getClientCredential(), ClientCredential.PSSWD.getClientCredential());
            } catch (UnregistredClientException | UnregistredAccountException e) {
                log.error("Ошибка при получении пользователя " + ClientCredential.LOGIN.getClientCredential(), e);
            }
            SessionUtil.fillSession(httpSession, client);
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_REG_PAGE.getPage());
        }
    }

    private boolean isLoginAlreadyExist(String login) {
        ClientDAO clientDAO = new ClientDAO();
        List<Client> allClients = clientDAO.getAll();
        return allClients.stream().map(Client::getLogin).anyMatch(x -> x.equalsIgnoreCase(login));
    }
}
