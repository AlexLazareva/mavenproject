package ru.itparkkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.beans.PayData;
import ru.itparkkazan.dao.AccountDAO;
import ru.itparkkazan.dao.PayDataDAO;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.processors.AccountProcessor;
import ru.itparkkazan.utils.ServletUtil;
import ru.itparkkazan.utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Сервлет для обратотки оплаты
 */
@Slf4j
@WebServlet(name = "pay", urlPatterns = "/pay")
public class PayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String payTargetCount = httpServletRequest.getParameter("payTargetCount");
        String paySum = httpServletRequest.getParameter("paySum");

        PayDataDAO payDataDAO = new PayDataDAO();
        try {
            Client payClient = SessionUtil.getClientFromSession(httpServletRequest.getSession());
            AccountProcessor.withdrawalAccount(payClient.getAccount(), Integer.parseInt(paySum));
            AccountDAO accountDAO = new AccountDAO();
            accountDAO.update(payClient.getAccount());
            PayData payData = new PayData(payClient, payTargetCount, Integer.parseInt(paySum), new Date());
            payDataDAO.insert(payData);
        } catch (Exception e) {
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
