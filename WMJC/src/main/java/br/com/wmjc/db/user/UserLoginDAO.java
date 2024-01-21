package br.com.wmjc.db.user;

import br.com.wmjc.config.ConnectionPoolConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDAO
{
    public boolean verificarLogin(String email, String senha)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM use WHERE email = ? AND senha = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        }
        catch (Exception e)
        {
            System.out.println("Erro ao verificar login: " + e.getMessage());
        }
        return false;
    }

    public boolean verificarCadastro()
    {
        return false;
    }
}
