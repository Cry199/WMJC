package br.com.wmjc.servlet.game.create;

import br.com.wmjc.db.game.GameCreateGeneralDAO;
import br.com.wmjc.db.game.GameListNameTableDAO;
import br.com.wmjc.model.game.GameGeneralModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/gameListAtual")
public class GameListAtualSerlvet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String nameTable = request.getParameter("nameTable");

        if(new GameCreateGeneralDAO().createTableGameGeneral(nameTable))
        {
            List<GameGeneralModel> gameList = new GameListNameTableDAO().listGameGeneral(nameTable);

            HttpSession session = request.getSession();
            session.setAttribute("nameTable", nameTable);

            request.setAttribute("gameList", gameList);

            request.getSession().setAttribute("clickUser", "listGame");

            request.getRequestDispatcher("/Pages/jsp/private/game/gameCreateFinal.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("message", "Erro ao criar falar como o administrador do sistema.");

            response.sendRedirect("index.jsp");
        }
    }
}
