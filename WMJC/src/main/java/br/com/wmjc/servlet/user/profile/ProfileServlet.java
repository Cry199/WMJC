package br.com.wmjc.servlet.user.profile;

import br.com.wmjc.db.game.GameDAO;
import br.com.wmjc.db.user.profile.ProfileDAO;
import br.com.wmjc.model.game.GameModel;
import br.com.wmjc.model.user.profile.ProfileModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userProfile")

public class ProfileServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<ProfileModel> profileList = new ProfileDAO().exibPerfil();

        req.setAttribute("perfil", profileList);

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}