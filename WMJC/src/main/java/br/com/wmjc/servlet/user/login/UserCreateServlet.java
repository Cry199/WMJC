package br.com.wmjc.servlet.user.login;

import br.com.wmjc.db.user.UserCreateDAO;
import br.com.wmjc.db.user.UserLoginDAO;
import br.com.wmjc.model.user.UserModel;
import org.h2.command.ddl.CreateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tipoCadastro")
public class UserCreateServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");

        boolean x = new UserCreateDAO().CreateUser(nome, sobrenome, senha, email);

        if(x)
        {
          req.setAttribute("message", "Criado com sucesso");
        }
        else
        {
            req.setAttribute("message", "Erro ao criar a conta");
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
