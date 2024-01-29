package br.com.wmjc.servlet.user;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        List<UserModel> user = new UserLoginDAO().UsertypeFinder(username, password);

        if(user.isEmpty())
        {
            req.setAttribute("message", "Usuario invalido");
        }
        else if(user.get(0).getTipoUser().equals("admin"))
        {
            req.setAttribute("message", "Bem-Vindo " + user.get(0).getEmail() + " você é um administrador");
        }
        else if(user.get(0).getTipoUser().equals("user"))
        {
            req.setAttribute("message", "Bem-Vindo " + user.get(0).getEmail() + " você é um usuario comum");
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
