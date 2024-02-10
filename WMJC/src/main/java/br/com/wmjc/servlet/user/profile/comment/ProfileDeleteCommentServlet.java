package br.com.wmjc.servlet.user.profile.comment;

import br.com.wmjc.db.user.profile.ProfileCommentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profileDeleteComment")
public class ProfileDeleteCommentServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");
        String idDoDonoPerfil = req.getParameter("idDoDonoPerfil");

        new ProfileCommentDAO().deleteComment(id);

        resp.sendRedirect("/perfil-detalhes?id=" + idDoDonoPerfil);
    }
}
