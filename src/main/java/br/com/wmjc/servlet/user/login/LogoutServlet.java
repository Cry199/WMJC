package br.com.wmjc.servlet.user.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getSession().invalidate();

        req.setAttribute("message", "Usuario deslogado com sucesso!");

        req.getRequestDispatcher("/Pages/jsp/public/login/login.jsp").forward(req, resp);
    }
}
