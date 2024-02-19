package br.com.wmjc.servlet.game;

import br.com.wmjc.db.game.GameContadorDAO;
import br.com.wmjc.db.game.GamePlayDAO;
import br.com.wmjc.model.game.GameGeneralModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/gamePlay")
public class GamePlayServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");

        String nameTable = req.getParameter("nameTable");

        GameGeneralModel game = new GamePlayDAO().buscandoGamePorId(nameTable, id);

        HttpSession session = req.getSession();
        session.setAttribute("tabelaGame", nameTable);
        session.setAttribute("Jogo", game);

        req.getRequestDispatcher("/Pages/jsp/public/game/gamePlay.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");

        String nameTable = req.getParameter("nameTable");

        GameGeneralModel game = new GamePlayDAO().buscandoGamePorId(nameTable, id);

        HttpSession session = req.getSession();
        session.setAttribute("tabelaGame", nameTable);
        session.setAttribute("Jogo", game);

        req.getRequestDispatcher("/Pages/jsp/public/game/gamePlay.jsp").forward(req, resp);
    }
}
