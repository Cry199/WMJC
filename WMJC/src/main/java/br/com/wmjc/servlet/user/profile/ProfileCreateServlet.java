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

        new ProfileDAO().createProfile(id, profileName, picProfile);

        resp.sendRedirect("/perfil-detalhes?id=" + id);
    }
}
