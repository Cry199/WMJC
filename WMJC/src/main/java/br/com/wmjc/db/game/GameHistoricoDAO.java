package br.com.wmjc.db.game;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.game.GameGeneralModel;
import br.com.wmjc.model.game.historico.GameHistoricoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
}
