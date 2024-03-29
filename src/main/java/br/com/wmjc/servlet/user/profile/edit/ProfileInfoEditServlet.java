package br.com.wmjc.servlet.user.profile.edit;

import br.com.wmjc.db.user.profile.ProfileDAO;
import br.com.wmjc.model.user.profile.ProfileModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/perfilInfoEdit")
public class ProfileInfoEditServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");

        ProfileModel profile = new ProfileDAO().buscarPorIdUser(id);

        req.setAttribute("profile", profile);

        req.getRequestDispatcher("/Pages/jsp/private/profile/profileInfoEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loggedUser") == null) {
            resp.sendRedirect("/perfil-detalhes");
            return;
        }

        String id = req.getParameter("id");

        String profileName = req.getParameter("profileName");
        String picProfile = req.getParameter("picProfile");

        new ProfileDAO().uptadePerfil(id, profileName, picProfile);

        resp.sendRedirect("/perfil-detalhes?" + id);
    }
}
