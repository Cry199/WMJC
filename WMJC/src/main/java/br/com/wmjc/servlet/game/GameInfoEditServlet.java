package br.com.wmjc.servlet.game;

import br.com.wmjc.db.game.GameDAO;
import br.com.wmjc.model.game.GameModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gameInfoEdit")
public class GameInfoEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");

        GameModel game = new GameDAO().buscandoGamePorId(id);

        req.setAttribute("game", game);

        req.getRequestDispatcher("/Pages/jsp/public/gameInfoEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String gameName = req.getParameter("gameName");
        String picGame = req.getParameter("picGame");
        String gameDescription = req.getParameter("aa");
        String id = req.getParameter("id");

        new GameDAO().uptadeGame(gameName, picGame, gameDescription, id);

        resp.sendRedirect("/jogo-detalhes?id=" + id);
    }


}
