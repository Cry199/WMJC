package br.com.wmjc.db.game;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.game.GameGeneralModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameCreateGeneralDAO
{
    public boolean createTableGameGeneral(String nameTable)
    {
        String sql = "CREATE TABLE " + nameTable + " (id INT NOT NULL AUTO_INCREMENT, texto VARCHAR(255) NOT NULL, " +
                "op1 TEXT NOT NULL, ref1 INT NOT NULL, op2 TEXT NOT NULL, ref2 INT NOT NULL, op3 TEXT NOT NULL, " +
                "ref3 INT NOT NULL, image TEXT NOT NULL)";

        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            System.out.println("Tabela criada com sucesso: " + nameTable);

            return true;
        }
        catch (SQLException e)
        {
            if (isTableExists(nameTable))
            {
                System.out.println("Tabela '" + nameTable + "' já existe.");

                return true;
            }
            else
            {
                System.out.println("Erro na criação da tabela: " + e.getMessage());
                return false;
            }
        }
    }

    private boolean isTableExists(String nameTable)
    {
        String sql = "SELECT * FROM " + nameTable;

        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();

            return true;
        }
        catch (SQLException e)
        {
            return false;
        }
    }

    public void insertGameGeneral(GameGeneralModel gameGeneralModel, String nameTable)
    {
        String sql = "INSERT INTO " + nameTable + " (texto, op1, ref1, op2, ref2, op3, ref3, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, gameGeneralModel.getTexto());
            preparedStatement.setString(2, gameGeneralModel.getOp1());
            preparedStatement.setString(3, gameGeneralModel.getRef1());
            preparedStatement.setString(4, gameGeneralModel.getOp2());
            preparedStatement.setString(5, gameGeneralModel.getRef2());
            preparedStatement.setString(6, gameGeneralModel.getOp3());
            preparedStatement.setString(7, gameGeneralModel.getRef3());
            preparedStatement.setString(8, gameGeneralModel.getImage());
            preparedStatement.executeUpdate();

            System.out.println("Insert: " + preparedStatement);
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
