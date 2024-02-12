package br.com.wmjc.db.game;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.game.GameGeneralModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GameListNameTableDAO
{
    public List<GameGeneralModel> listGameGeneral(String nameTable)
    {
        String sql = "SELECT * FROM " + nameTable;

        try(Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<GameGeneralModel> lista = new ArrayList<>();

            while (resultSet.next())
            {
                GameGeneralModel gameGeneralModel = new GameGeneralModel();
                gameGeneralModel.setId(preparedStatement.getResultSet().getInt("id"));
                gameGeneralModel.setTexto(preparedStatement.getResultSet().getString("texto"));
                gameGeneralModel.setOp1(preparedStatement.getResultSet().getString("op1"));
                gameGeneralModel.setRef1(preparedStatement.getResultSet().getString("ref1"));
                gameGeneralModel.setOp2(preparedStatement.getResultSet().getString("op2"));
                gameGeneralModel.setRef2(preparedStatement.getResultSet().getString("ref2"));
                gameGeneralModel.setOp3(preparedStatement.getResultSet().getString("op3"));
                gameGeneralModel.setRef3(preparedStatement.getResultSet().getString("ref3"));
                gameGeneralModel.setImage(preparedStatement.getResultSet().getString("image"));

                lista.add(gameGeneralModel);
            }

            preparedStatement.close();
            connection.close();

            return lista;
        }
        catch (Exception e)
        {
            System.out.println("GameListNameTableDAO - Erro ao listar tabelas GameListNameTableDAO: " + e.getMessage());

            return null;
        }
    }
}
