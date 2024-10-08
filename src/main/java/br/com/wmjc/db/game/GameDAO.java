package br.com.wmjc.db.game;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.game.GameModel;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GameDAO
{
    public List<GameModel> listandoGames()
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JOGOS");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<GameModel> lista = new ArrayList<>();

            while (resultSet.next())
            {
                BigInteger idJogo = BigInteger.valueOf(resultSet.getInt("id"));
                BigInteger idUser = BigInteger.valueOf(resultSet.getInt("iddoUser"));
                String nomeJogo = resultSet.getString("NomedoJogo");
                String tabJogo = resultSet.getString("nomeDaTabalaDojogo");
                String descriJogo = resultSet.getString("DescricaoDoJogo");
                String capaJogo = resultSet.getString("CapaDoJogo");

                GameModel game = new GameModel(idJogo, idUser, nomeJogo, tabJogo, descriJogo, capaJogo);
                lista.add(game);
            }

            System.out.println("Todos os jogos listados com sucesso :)");

            preparedStatement.close();
            connection.close();

            return lista;
        }
        catch (Exception e)
        {
            System.out.println("GameDAO - Erro: " + e.getMessage()); return null;
        }
    }

    public GameModel buscandoGamePorId(String id)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JOGOS WHERE ID = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            GameModel game = null;

            while (resultSet.next())
            {
                BigInteger idJogo = BigInteger.valueOf(resultSet.getInt("id"));
                BigInteger idUser = BigInteger.valueOf(resultSet.getInt("iddoUser"));
                String nomeJogo = resultSet.getString("NomedoJogo");
                String tabJogo = resultSet.getString("nomeDaTabalaDojogo");
                String descriJogo = resultSet.getString("DescricaoDoJogo");
                String capaJogo = resultSet.getString("CapaDoJogo");

                game = new GameModel(idJogo, idUser, nomeJogo, tabJogo, descriJogo, capaJogo);
            }
            System.out.println("Jogo encontrado com sucesso :)");

            preparedStatement.close();
            connection.close();

            return game;
        }
        catch (Exception e)
        {
            System.out.println("GameDAO - Erro: " + e.getMessage());
            return null;

        }
    }

    public void uptadeGame(String gameName, String picGame, String gameDescription, String id) {

        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE JOGOS SET NomedoJogo = ?, CapaDoJogo = ?, DescricaoDoJogo = ? WHERE ID = ?");
            preparedStatement.setString(1, gameName);
            preparedStatement.setString(2, picGame);
            preparedStatement.setString(3, gameDescription);
            preparedStatement.setString(4, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        }
        catch (Exception e)
        {
            System.out.println("GameDAO - Erro: " + e.getMessage());
        }
    }

    public void deleteGame(String id, String nomeDaTabela)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            // Delete all comments from the game
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM COMENTARIODEJOGO WHERE IDJOGO = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();

            // Delete all plays from the game
            preparedStatement = connection.prepareStatement("DELETE FROM HISTORICO_DE_JOGADAS WHERE ID_DO_JOGO = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();

            // Delete all plays from the game
            preparedStatement = connection.prepareStatement("DELETE FROM JOGOS_MAIS_JOGADOS WHERE IDJOGO = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();

            // Delete the game table
            preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS " + nomeDaTabela);
            preparedStatement.execute();

            // Delete the game
            preparedStatement = connection.prepareStatement("DELETE FROM JOGOS WHERE ID = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();

            preparedStatement.close();
        }
        catch (Exception e)
        {
            System.out.println("GameDAO - Erro: " + e.getMessage());
        }
    }

    public void createGame(String idUser, String name, String nomeDaTabela, String description, String imgGame)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Jogos (iddoUser, NomedoJogo, nomeDaTabalaDojogo, DescricaoDoJogo, CapaDoJogo) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, idUser);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, nomeDaTabela);
            preparedStatement.setString(4, description);
            preparedStatement.setString(5, imgGame);
            preparedStatement.execute();

            System.out.println("Jogo criado com sucesso :)");

            preparedStatement.close();
        }
        catch (Exception e)
        {
            System.out.println("GameDAO - Erro: " + e.getMessage());
        }
    }
}