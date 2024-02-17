package br.com.wmjc.servlet.game;

import br.com.wmjc.db.game.GameContadorDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GameContadorServlet")
public class GameContadorServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int idGame = Integer.parseInt(req.getParameter("idGame"));

        new GameContadorDAO().updateContador(idGame);
    }
}
