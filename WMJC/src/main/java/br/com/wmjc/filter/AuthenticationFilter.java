package br.com.wmjc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter("/admin/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest =  (HttpServletRequest) request;

        if(isUserLogado(httpServletRequest))
        {
            chain.doFilter(request, response);
        }
        else
        {
            request.setAttribute("message", "Usuario não logado!");
            request.getRequestDispatcher("/Pages/jsp/login/login.jsp").forward(httpServletRequest, response);
        }
    }

    @Override
    public void destroy() {}

    private boolean isUserLogado(HttpServletRequest httpServletRequest)
    {
        return httpServletRequest.getSession().getAttribute("loggedUser") != null;
    }
}