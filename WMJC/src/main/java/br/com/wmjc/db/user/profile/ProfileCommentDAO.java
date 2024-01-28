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

public class ProfileCommentDAO {

    public List<ProfileComments> CommentList(Integer idPerfil) {

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ComentariosPerfil Where iddoUser = ?");
            preparedStatement.setInt(1, new Integer(idPerfil));

            ResultSet resultSet = preparedStatement.executeQuery();

            List<ProfileComments> comments = new ArrayList<>();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("iddoUser");
                String comment = resultSet.getString("Comentario");
                Integer perfil = resultSet.getInt("idPerfil");

                ProfileComments profileComments = new ProfileComments(id,comment, perfil);
                comments.add(profileComments);
            }

            System.out.println("Lista de comentarios: " + comments);
            connection.close();
            return comments;

        } catch (Exception e) {
            System.out.println("Nenhum comentário no perfil: " + e.getMessage());

            return null;
        }
    }


}
