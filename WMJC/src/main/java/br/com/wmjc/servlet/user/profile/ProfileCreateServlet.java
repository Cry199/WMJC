package br.com.wmjc.servlet.user.profile;

import br.com.wmjc.db.user.profile.ProfileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/perfil-criar")
public class ProfileCreateServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");
        String profileName = req.getParameter("profileName");
        String picProfile = req.getParameter("picProfile");

        if(new ProfileDAO().validarPerfil(id))
        {
            req.setAttribute("message", "Erro ao criar o perfil");
        }
        else
        {
            req.setAttribute("message", "Perfil criado com sucesso");

            new ProfileDAO().createProfile(id, profileName, picProfile);

            req.setAttribute("message", "Perfil criado com sucesso");
        }
    }
}
