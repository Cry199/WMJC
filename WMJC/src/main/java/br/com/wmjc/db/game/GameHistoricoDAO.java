package br.com.wmjc.db.game;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.game.GameGeneralModel;
import br.com.wmjc.model.game.historico.GameHistoricoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GameHistoricoDAO
{
    public void insertHistorico(GameHistoricoModel gameHistoricoModel)
    {
        String sql = "INSERT INTO HISTORICO_DE_JOGADAS (ID_USUARIO, ID_DO_JOGO, DATA_HORA) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, gameHistoricoModel.getIdUser());
            preparedStatement.setInt(2, gameHistoricoModel.getIdGame());
            preparedStatement.setString(3, dateTimeFormatter.format(LocalDateTime.now()));
            preparedStatement.execute();

            System.out.println("Historico inserido com sucesso: " + System.currentTimeMillis());

            preparedStatement.close();
        }
        catch (Exception e)
        {
            System.out.println("GameHistoricoDAO - Erro: " + e.getMessage());
        }
    }

    public List<Integer> listarHistoricoPorUsuario(String idUsuario)
    {
        String sql = "SELECT ID_DO_JOGO FROM HISTORICO_DE_JOGADAS\n" +
                "WHERE ID_USUARIO = ?\n" +
                "ORDER BY DATA_HORA DESC\n" +
                "LIMIT 3;";

        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idUsuario);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Integer> list = new ArrayList<>();

            while (resultSet.next())
            {
                list.add(preparedStatement.getResultSet().getInt("ID_DO_JOGO"));
            }

            preparedStatement.close();
            connection.close();

            return list;
        }
        catch (Exception e)
        {
            System.out.println("GameHistoricoDAO - Erro: " + e.getMessage());

            return null;
        }
    }
}
