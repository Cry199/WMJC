package br.com.wmjc.servlet.user;

import br.com.wmjc.db.user.UserLoginDAO;
import br.com.wmjc.model.user.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserModel user = new UserModel(username, password);

        boolean isValidUser = new UserLoginDAO().verificarLogin(user.getEmail(), user.getSenha());

        if (isValidUser)
        {
            req.setAttribute("message", "Welcome " + user.getEmail());
        }
        else
        {
            req.setAttribute("message", "Invalid credentials!");
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}