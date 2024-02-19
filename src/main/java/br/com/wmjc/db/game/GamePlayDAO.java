package br.com.wmjc.db.game;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.game.GameGeneralModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GamePlayDAO
{
    public GameGeneralModel buscandoGamePorId(String tabelaGame,String id)
    {
        String sql = "SELECT * FROM " + tabelaGame +" WHERE id = ?";

        try(Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            GameGeneralModel gameGeneralModel = new GameGeneralModel();

            while (resultSet.next())
            {
                gameGeneralModel.setId(preparedStatement.getResultSet().getInt("id"));
                gameGeneralModel.setTexto(preparedStatement.getResultSet().getString("texto"));
                gameGeneralModel.setOp1(preparedStatement.getResultSet().getString("op1"));
                gameGeneralModel.setRef1(preparedStatement.getResultSet().getString("ref1"));
                gameGeneralModel.setOp2(preparedStatement.getResultSet().getString("op2"));
                gameGeneralModel.setRef2(preparedStatement.getResultSet().getString("ref2"));
                gameGeneralModel.setOp3(preparedStatement.getResultSet().getString("op3"));
                gameGeneralModel.setRef3(preparedStatement.getResultSet().getString("ref3"));
                gameGeneralModel.setImage(preparedStatement.getResultSet().getString("image"));
            }

            preparedStatement.close();
            connection.close();

            return gameGeneralModel;
        }
        catch (Exception e)
        {
            System.out.println("GamePlayDAO - Erro ao buscar game por id: " + e.getMessage());
            return null;
        }
    }

    public boolean isTableExists(String nameTable)
    {
        String sql = "SELECT * FROM " + nameTable;

        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();

            preparedStatement.close();
            connection.close();

            return true;
        }
        catch (Exception e)
        {
            System.out.println("GamePlayDAO - Erro: " + e.getMessage());

            return false;
        }
    }
}
