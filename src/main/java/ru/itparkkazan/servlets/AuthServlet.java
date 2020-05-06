package ru.itparkkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.dao.ClientDAO;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.exeptions.UnregistredClientException;
import ru.itparkkazan.utils.ServletUtil;
import ru.itparkkazan.utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@WebServlet(name = "auth", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String clientLogin = httpServletRequest.getParameter(ClientCredential.LOGIN.getClientCredential());
        String clientPsswd = httpServletRequest.getParameter(ClientCredential.PSSWD.getClientCredential());

        ClientDAO clientDAO = new ClientDAO();
        Client client = null;

        try {
            client = clientDAO.get(clientLogin, clientPsswd);
            if (client == null) {
                //TODO Вывести предупреждение "Проблемы с БД, обратитесь к администратору"
            }
        } catch (UnregistredClientException e) {
            log.error(e.getMessage());
        }
        HttpSession httpSession = httpServletRequest.getSession();
        SessionUtil.fillSession(httpSession, client);
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_PAGE.getPage());
    }
}
