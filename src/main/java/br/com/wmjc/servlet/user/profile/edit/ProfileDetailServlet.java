package br.com.wmjc.servlet.user.profile.edit;

import br.com.wmjc.db.game.GameDAO;
import br.com.wmjc.db.game.GameHistoricoDAO;
import br.com.wmjc.db.user.UserLoginDAO;
import br.com.wmjc.db.user.profile.ProfileCommentDAO;
import br.com.wmjc.db.user.profile.ProfileDAO;
import br.com.wmjc.model.game.GameModel;
import br.com.wmjc.model.user.UserModel;
import br.com.wmjc.model.user.profile.Comments.ProfileCommentUserProfileModel;
import br.com.wmjc.model.user.profile.Comments.ProfileComments;
import br.com.wmjc.model.user.profile.ProfileModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/perfil-detalhes")
public class ProfileDetailServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");

        ProfileModel profile = new ProfileDAO().buscarPorIdUser(id);

        if(profile == null)
        {
            resp.sendRedirect("/perfil-criar?id=" + id);
        }
        else
        {
            List<ProfileComments> comments = new ProfileCommentDAO().CommentList(profile.getIdProfile().toString());

            List<ProfileCommentUserProfileModel> commentUserProfiles = new ArrayList<>();

            for (ProfileComments comment : comments)
            {
                ProfileModel userProfile = new ProfileDAO().buscarPorIdUser(comment.getIdUser().toString());
                commentUserProfiles.add(new ProfileCommentUserProfileModel(userProfile, comment));
            }

            List<GameModel> gameList = new ArrayList<>();
            for(Integer i : new GameHistoricoDAO().listarHistoricoPorUsuario(id))
            {
                gameList.add(new GameDAO().buscandoGamePorId(i.toString()));
            }

            HttpSession session = req.getSession();
            session.setAttribute("activitys", gameList);
            session.setAttribute("profile", profile);
            session.setAttribute("comments", commentUserProfiles);

            req.getRequestDispatcher("/Pages/jsp/public/profile/profileDetails.jsp").forward(req, resp);
        }
    }
}

