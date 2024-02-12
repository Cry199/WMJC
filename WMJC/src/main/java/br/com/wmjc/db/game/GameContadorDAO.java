package br.com.wmjc.db.game;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.game.historico.GameContadorModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GameContadorDAO
{
    public void insertContador(int idGame)
    {
        if (isGameExists(idGame))
        {
            updateContador(idGame);
        }
        else
        {
            insertNewContador(idGame);
        }
    }

    private void insertNewContador(int idGame)
    {
        String sql = "INSERT INTO JOGOS_MAIS_JOGADOS (IDJOGO, QUANTIDADE_JOGADAS) VALUES (?, 0)";

        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idGame);
            preparedStatement.execute();

            System.out.println("Contador inserido com sucesso: " + System.currentTimeMillis());

            preparedStatement.close();
        }
        catch (Exception e)
        {
            System.out.println("GameContadorDAO - Erro: " + e.getMessage());
        }
    }

    private boolean isGameExists(int idGame)
    {
        String sql = "SELECT * FROM JOGOS_MAIS_JOGADOS WHERE IDJOGO = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idGame);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                System.out.println(resultSet.getInt("IDJOGO"));

                if(resultSet.getInt("IDJOGO") != 0)
                {
                    return true;
                }
            }

            System.out.println("Jogo já existe: " + System.currentTimeMillis() + " - ID: " + idGame);
        }
        catch (Exception e)
        {
            System.out.println("GameContadorDAO - Erro: " + e.getMessage());
        }
        return false;
    }

    public void updateContador(int idGame)
    {
        String sql = "UPDATE JOGOS_MAIS_JOGADOS SET QUANTIDADE_JOGADAS = QUANTIDADE_JOGADAS + 1 WHERE IDJOGO = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idGame);
            preparedStatement.execute();

            System.out.println("Contador atualizado com sucesso: " + System.currentTimeMillis());

            preparedStatement.close();
        }
        catch (Exception e)
        {
            System.out.println("GameContadorDAO - Erro: " + e.getMessage());
        }
    }
}
