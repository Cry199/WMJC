package br.com.wmjc.db.user;

import br.com.wmjc.config.ConnectionPoolConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserCreateDAO {
    public boolean CreateUser(String name, String sobrenome, String senha, String email)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            String sql = "INSERT INTO use (name, Sobrenome, senha, email, tipoDeUsario) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, sobrenome);
            preparedStatement.setString(3, senha);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, "user");
            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

            return true;
        }
        catch (Exception e)
        {
            System.out.println("UserCreateDAO - Erro ao fazer o cadastro " + e.getMessage());
        }

        return false;
    }

    public boolean validarUser(String email)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM use WHERE email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                connection.close();
                return true;
            }
        }
        catch (Exception e)
        {
            System.out.println("UserCreateDAO - Erro ao verificar usuario: " + e.getMessage());
        }
        return false;
    }
}
