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

@WebServlet("/gameCreateFinal")
public class GameCreateFinalServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getSession().setAttribute("clickUser", "createGame");

        request.getRequestDispatcher("/Pages/jsp/private/game/gameCreateFinal.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println(request.getParameterNames());

        String nameTable = request.getParameter("nameTable");

        String texto = request.getParameter("texto");
        String op1 = request.getParameter("op1");
        String ref1 = request.getParameter("ref1");
        String op2 = request.getParameter("op2");
        String ref2 = request.getParameter("ref2");
        String op3 = request.getParameter("op3");
        String ref3 = request.getParameter("ref3");
        String image = request.getParameter("imgText");

        if(new GameCreateGeneralDAO().createTableGameGeneral(nameTable))
        {
            GameGeneralModel gameGeneralModel = new GameGeneralModel(texto, op1, ref1, op2, ref2, op3, ref3, image);

            new GameCreateGeneralDAO().insertGameGeneral(gameGeneralModel, nameTable);

            List<GameGeneralModel> gameList = new GameListNameTableDAO().listGameGeneral(nameTable);

            request.setAttribute("gameList", gameList);

            HttpSession session = request.getSession();
            session.setAttribute("nameTable", nameTable);

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
