package br.com.wmjc.db.game;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.game.commentsGame.GameCommentsModel;
import br.com.wmjc.model.user.profile.Comments.ProfileComments;

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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ComentarioDejogo Where idJogo = ?");
            preparedStatement.setString(1, idGame);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<GameCommentsModel> comments = new ArrayList<>();

            while (resultSet.next())
            {
                BigInteger idUser = BigInteger.valueOf(resultSet.getInt("iddoUser"));
                BigInteger idJogo = BigInteger.valueOf(resultSet.getInt("idJogo"));
                String comment = resultSet.getString("Comentario");

                GameCommentsModel gameCommentsModel = new GameCommentsModel(idUser, idJogo, comment);
                comments.add(gameCommentsModel);
            }

            System.out.println("Lista de comentarios: " + comments);

            return comments;
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e.getMessage()); return null;
        }
    }

}
