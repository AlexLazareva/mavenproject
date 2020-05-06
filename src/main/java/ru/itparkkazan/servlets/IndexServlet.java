package ru.itparkkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.enums.Page;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "index", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private static final String ENTER_PARAMETER = "enter";
    private static final String REG_PARAMETER = "reg";

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String enterCommand = httpServletRequest.getParameter(ENTER_PARAMETER);
        String regCommand = httpServletRequest.getParameter(REG_PARAMETER);
        String pageCommand = Page.INDEX_PAGE.getPage();

        if (enterCommand != null) {
            pageCommand = Page.AUTH_PAGE.getPage();
        } else if (regCommand != null) {
            pageCommand = Page.REG_PAGE.getPage();
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + pageCommand);
    }
}
