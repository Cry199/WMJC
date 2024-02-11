package br.com.wmjc.db.user.profile;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.user.profile.Comments.ProfileComments;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class ProfileCommentDAO
{
    public List<ProfileComments> CommentList(String idPerfil)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ComentariosPerfil Where IDPERFIL = ? ORDER BY ID DESC");
            preparedStatement.setString(1, idPerfil);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<ProfileComments> comments = new ArrayList<>();

            while (resultSet.next())
            {
                BigInteger id = resultSet.getBigDecimal("ID").toBigInteger();
                Integer idUser = resultSet.getInt("iddoUser");
                Integer iPerfil = resultSet.getInt("idPerfil");
                String comment = resultSet.getString("Comentario");

                ProfileComments profileComments = new ProfileComments(id, idUser, iPerfil, comment);
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

    public void insertComment(String idUser, String idPerfil, String comment) {
        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ComentariosPerfil (iddoUser, idPerfil, Comentario) VALUES (?, ?, ?)");
            preparedStatement.setString(1, idUser);
            preparedStatement.setString(2, idPerfil);
            preparedStatement.setString(3, comment);
            preparedStatement.execute();

            System.out.println("Comentario inserido com sucesso");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void deleteComment(String id)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ComentariosPerfil WHERE id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();

            System.out.println("Comentario deletado com sucesso");
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
