package ru.itparkkazan.servlets;

import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.utils.ServletUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/views/*")
public class SessionFilterServlet implements Filter {
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (httpServletRequest.getSession().getAttribute(ClientCredential.ID.getClientCredential()) == null ) {
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.INDEX_PAGE.getPage());
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}
}
