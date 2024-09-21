package br.com.wmjc.servlet.game;

import br.com.wmjc.db.game.GameDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gameInfoEditDelete")
public class GameInfoEditDeleteServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");
        String nomeDaTabela = req.getParameter("nameTable");

        new GameDAO().deleteGame(id, nomeDaTabela);

        req.setAttribute("message", "Deleted with success!");

        resp.sendRedirect("/Jogos");
    }
}
