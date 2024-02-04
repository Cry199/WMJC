package br.com.wmjc.servlet.game;

import br.com.wmjc.db.game.GameCommentsDAO;
import br.com.wmjc.db.game.GameDAO;
import br.com.wmjc.db.user.UserLoginDAO;
import br.com.wmjc.db.user.profile.ProfileCommentDAO;
import br.com.wmjc.db.user.profile.ProfileDAO;
import br.com.wmjc.model.game.GameModel;
import br.com.wmjc.model.game.commentsGame.GameCommentUserProfileModel;
import br.com.wmjc.model.game.commentsGame.GameCommentsModel;
import br.com.wmjc.model.user.UserModel;
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

@WebServlet("/jogo-detalhes")
public class GameDetailsServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");

        GameModel game = new GameDAO().buscandoGamePorId(id);

        List<GameCommentsModel> comments = new GameCommentsDAO().exibComentariosJogo(id);

        List<GameCommentUserProfileModel> commentUserProfiles = new ArrayList<>();

        for (GameCommentsModel comment : comments)
        {
            ProfileModel profile = new ProfileDAO().buscarPorIdUserGame(comment.getIdUser().toString());
            commentUserProfiles.add(new GameCommentUserProfileModel(comment, profile));
        }

        HttpSession session = req.getSession();
        session.setAttribute("game", game);

        session.setAttribute("comments", commentUserProfiles);

        req.getRequestDispatcher("/Pages/jsp/public/gameDetails.jsp").forward(req, resp);
    }
}