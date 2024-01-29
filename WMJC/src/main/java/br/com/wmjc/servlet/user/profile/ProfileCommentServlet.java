package br.com.wmjc.servlet.user.profile;

import br.com.wmjc.db.user.profile.ProfileCommentDAO;
import br.com.wmjc.model.user.profile.Comments.ProfileComments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/profileComment")
public class ProfileCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String idPerfil = req.getParameter("idPerfil");

        List<ProfileComments> comments = new ProfileCommentDAO().CommentList(idPerfil);

        req.setAttribute("comments", comments);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
