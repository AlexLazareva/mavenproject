package ru.itparkkazan.servlets;

import ru.itparkkazan.beans.Client;
import ru.itparkkazan.dao.ClientDAO;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "initClientsTransfer", urlPatterns = "/initClientsTransfer")
public class InitClientTransferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ClientDAO clientDAO = new ClientDAO();
        List<Client> allClients = clientDAO.getAll();
        List<Client> clientsWithoutCurrent = allClients.stream()
                .filter(x -> x.getId() != (int) req.getSession().getAttribute(ClientCredential.ID.getClientCredential()))
                .collect(Collectors.toList());
        req.setAttribute("allClients", clientsWithoutCurrent);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/transfer.jsp");

        try {
           requestDispatcher.forward(
                   req,
                   resp
           );
        } catch (ServletException e) {
            ServletUtil.redirectInsideServlet(req, resp, Page.ERROR_PAGE.getPage());
        } catch (IOException e) {
            ServletUtil.redirectInsideServlet(req, resp, Page.ERROR_PAGE.getPage());
        }
    }
}
