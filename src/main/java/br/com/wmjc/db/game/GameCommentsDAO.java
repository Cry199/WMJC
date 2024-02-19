package br.com.wmjc.db.game;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.game.commentsGame.GameCommentsModel;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GameCommentsDAO
{
    public List<GameCommentsModel> exibComentariosJogo(String idGame)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ComentarioDejogo Where idJogo = ? ORDER BY ID DESC");
            preparedStatement.setString(1, idGame);

            System.out.println("SQL: " + preparedStatement.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            List<GameCommentsModel> comments = new ArrayList<>();

            while (resultSet.next())
            {
                BigInteger id = BigInteger.valueOf(resultSet.getInt("id"));
                BigInteger idUser = BigInteger.valueOf(resultSet.getInt("iddoUser"));
                BigInteger idJogo = BigInteger.valueOf(resultSet.getInt("idJogo"));
                String comment = resultSet.getString("Comentario");

                GameCommentsModel gameCommentsModel = new GameCommentsModel(id, idUser, idJogo, comment);
                comments.add(gameCommentsModel);
            }

            System.out.println("Lista de comentarios: " + comments);

            preparedStatement.close();
            connection.close();

            return comments;
        }
        catch (Exception e)
        {
            System.out.println("GameCommentsDAO - Erro: " + e.getMessage()); return null;
        }
    }

    public void insertComment(String idUser, String idGame, String comment)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ComentarioDejogo (iddoUser, idJogo, Comentario) VALUES (?, ?, ?)");
            preparedStatement.setString(1, idUser);
            preparedStatement.setString(2, idGame);
            preparedStatement.setString(3, comment);
            preparedStatement.execute();

            System.out.println("Comentario inserido com sucesso");
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void deleteComment(String id)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ComentarioDejogo WHERE id = ?");
            preparedStatement.setString(1, id);

            preparedStatement.execute();

            System.out.println("GameCommentsDAO: Comentario deletado com sucesso");
        }
        catch (Exception e)
        {
            System.out.println("GameCommentsDAO - Erro: " + e.getMessage());
        }
    }
}
