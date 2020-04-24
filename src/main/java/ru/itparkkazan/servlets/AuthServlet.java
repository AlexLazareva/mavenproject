package ru.itparkkazan.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthServlet extends HttpServlet {
    private static final String LOGIN = "login";
    private static final String PSSWD = "psswd";

    private String clientLogin;
    private String clientPsswd;

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        readClientCredentials(httpServletRequest);
    }

    private void readClientCredentials(HttpServletRequest httpServletRequest) {
        clientLogin = httpServletRequest.getParameter(LOGIN);
        clientPsswd = httpServletRequest.getParameter(PSSWD);
    }
}
