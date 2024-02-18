package br.com.wmjc.servlet.user.login;

import br.com.wmjc.db.user.UserLoginDAO;
import br.com.wmjc.model.user.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tipoLogin")
public class UserLoginTipoServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getSession().setAttribute("clickUser", "login");

        req.getRequestDispatcher("/Pages/jsp/public/login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserModel user = new UserLoginDAO().UsertypeFinder(username, password);

        if(!user.getTipoUser().isEmpty())
        {
            req.getSession().setAttribute("loggedUser", user);
        }

        if(user == null)
        {
            req.setAttribute("message", "Usuario invalido");
        }
        else if(user.getTipoUser().equals("admin"))
        {
            req.setAttribute("message", "Bem-Vindo " + user.getEmail() + " você é um administrador");

            req.getRequestDispatcher("/Pages/jsp/private/admin/adminP.jsp").forward(req, resp);
        }
        else if(user.getTipoUser().equals("user"))
        {
            req.setAttribute("message", "Bem-Vindo " + user.getEmail() + " você é um usuario comum");

            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
