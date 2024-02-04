package br.com.wmjc.servlet.game;

import br.com.wmjc.db.game.GameCommentsDAO;
import br.com.wmjc.db.game.GameDAO;
import br.com.wmjc.db.user.profile.ProfileCommentDAO;
import br.com.wmjc.db.user.profile.ProfileDAO;
import br.com.wmjc.model.user.profile.Comments.ProfileComments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/gameComment")
public class GameCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String idUser = req.getParameter("idDoUser");
        String idJogo = req.getParameter("idJogo");
        String comment = req.getParameter("comment");

        String idPerfilD = new ProfileDAO().buscarPorIdUserString(idUser);

        new GameCommentsDAO().insertComment(idPerfilD, idJogo, comment);

        resp.sendRedirect("/jogo-detalhes?id=" + idJogo);
    }
}
