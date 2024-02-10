package br.com.wmjc.servlet.game;

import br.com.wmjc.db.game.GameDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/create-game")
public class GameCreateServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");

        HttpSession session = req.getSession();
        session.setAttribute("idDoUser", id);

        req.getRequestDispatcher("/Pages/jsp/private/game/gameCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String idUser = req.getParameter("idUser");
        String name = req.getParameter("nomeGame");
        String description = req.getParameter("description");
        String imgGame = req.getParameter("imgGame");

        String nomeDaTabela = name.replaceAll("[^a-zA-Z]", "").toLowerCase();

        new GameDAO().createGame(idUser, name, nomeDaTabela, description, imgGame);

        resp.sendRedirect("/index");
    }
}
