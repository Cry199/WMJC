package br.com.wmjc.servlet.game;

import br.com.wmjc.db.game.GameCommentsDAO;
import br.com.wmjc.db.game.GameDAO;
import br.com.wmjc.model.game.GameModel;
import br.com.wmjc.model.game.commentsGame.GameCommentsModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/jogo-detalhes")
public class GameDetailsServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");

        GameModel game = new GameDAO().buscandoGamePorId(id);

        HttpSession session = req.getSession();
        session.setAttribute("game", game);

        List<GameCommentsModel> comments = new GameCommentsDAO().exibComentariosJogo(id);
        req.setAttribute("comments", comments);

        req.getRequestDispatcher("/Pages/jsp/public/gameDetails.jsp").forward(req, resp);
    }
}