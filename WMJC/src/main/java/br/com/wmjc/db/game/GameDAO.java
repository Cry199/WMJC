package br.com.wmjc.db.game;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.game.GameModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GameDAO {

    public List<GameModel> listandoGames() {

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JOGOS");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<GameModel> lista = new ArrayList<>();

            while (resultSet.next()){
                String nomeJogo = resultSet.getString("NomedoJogo");
                String tabJogo = resultSet.getString("nomeDaTabalaDojogo");
                String descriJogo = resultSet.getString("DescricaoDoJogo");
                String capaJogo = resultSet.getString("CapaDoJogo");

                GameModel game = new GameModel(nomeJogo, tabJogo, descriJogo, capaJogo);
                lista.add(game);
            }
            System.out.println("Todos os jogos listados com sucesso :)");
            return lista;
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;

        }
    }
}