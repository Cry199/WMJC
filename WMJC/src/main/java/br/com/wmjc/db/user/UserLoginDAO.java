package br.com.wmjc.db.user;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.user.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserLoginDAO {
    public boolean verificarLogin(String email, String senha) {
        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM use WHERE email = ? AND senha = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Erro ao verificar login: " + e.getMessage());
        }
        return false;
    }

    public List<UserModel> UsertypeFinder(String email, String senha) {
        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM use WHERE email = ? AND senha = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<UserModel> users = new ArrayList<>();

            while (resultSet.next()) {
                String mail = resultSet.getString("email");
                String sen = resultSet.getString("senha");
                String tipoUSer = resultSet.getString("tipoDeUsario");

                UserModel user = new UserModel(mail, sen, tipoUSer);
                users.add(user);
            }

            System.out.println("Lista de usuarios: " + users);
            connection.close();
            return users;

        } catch (Exception e) {
            System.out.println("Erro ao verificar login: " + e.getMessage());

            return null;
        }
    }
}

