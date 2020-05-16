package ru.itparkkazan.servlets;

import ru.itparkkazan.enums.ClientCredential;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/views/*")
public class SessionFilterServlet implements Filter {
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getSession().getAttribute(ClientCredential.ID.getClientCredential()) == null ) {
            System.out.println("Session is not initializate");
        } else {
            System.out.println("OK!");
        }
    }

    @Override
    public void destroy() {}
}
