package br.com.wmjc.db.user.profile;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.user.profile.Comments.ProfileComments;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfileCommentDAO
{
    public List<ProfileComments> CommentList(String idPerfil)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ComentariosPerfil Where IDPERFIL = ?");
            preparedStatement.setString(1, idPerfil);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<ProfileComments> comments = new ArrayList<>();

            while (resultSet.next()) {
                Integer idUser = resultSet.getInt("iddoUser");
                Integer iPerfil = resultSet.getInt("idPerfil");
                String comment = resultSet.getString("Comentario");

                ProfileComments profileComments = new ProfileComments(idUser, iPerfil, comment);
                comments.add(profileComments);
            }

            System.out.println("Lista de comentarios: " + comments);
            connection.close();

            return comments;
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e.getMessage()); return null;
        }
    }
}
