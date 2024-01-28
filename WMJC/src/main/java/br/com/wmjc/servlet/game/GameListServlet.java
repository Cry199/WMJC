package br.com.wmjc.servlet.game;

import br.com.wmjc.db.game.GameDAO;
import br.com.wmjc.model.game.GameModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Jogos")
public class GameListServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<GameModel> gameList = new GameDAO().listandoGames();

        req.setAttribute("games", gameList);

        req.getRequestDispatcher("/Pages/jsp/public/games.jsp").forward(req, resp);
    }
}