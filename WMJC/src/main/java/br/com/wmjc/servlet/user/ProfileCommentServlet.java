package br.com.wmjc.servlet.user;

import br.com.wmjc.db.user.ProfileCommentDAO;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer idPerfil = Integer.valueOf(req.getParameter("comment"));

        List<ProfileComments> comments = new ProfileCommentDAO().CommentList(idPerfil);

        req.setAttribute("comments", comments);

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
