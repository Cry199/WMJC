package br.com.wmjc.servlet.game.comment;

import br.com.wmjc.db.game.GameCommentsDAO;
import br.com.wmjc.db.user.profile.ProfileCommentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gameDeleteComment")
public class GameDeleteCommentServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String idGame = req.getParameter("idGame");
        String id = req.getParameter("id");

        new GameCommentsDAO().deleteComment(id);

        resp.sendRedirect("/jogo-detalhes?id=" + idGame);
    }
}
