package br.com.wmjc.servlet.game;

import br.com.wmjc.db.game.GameHistoricoDAO;
import br.com.wmjc.model.game.historico.GameHistoricoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GameHistoricoServlet")
public class GameHistoricoServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        GameHistoricoModel gameHistoricoModel = new GameHistoricoModel();

        gameHistoricoModel.setIdUser(Integer.parseInt(req.getParameter("idUser")));
        gameHistoricoModel.setIdGame(Integer.parseInt(req.getParameter("idGame")));

        new GameHistoricoDAO().insertHistorico(gameHistoricoModel);
    }
}
