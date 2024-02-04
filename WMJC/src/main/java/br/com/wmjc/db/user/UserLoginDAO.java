package br.com.wmjc.db.user;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.user.UserModel;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserLoginDAO
{
    public List<UserModel> UsertypeFinder(String email, String senha)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM use WHERE email = ? AND senha = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<UserModel> users = new ArrayList<>();

            while (resultSet.next())
            {
                BigInteger id = new BigInteger(resultSet.getString("id"));
                String mail = resultSet.getString("email");
                String sen = resultSet.getString("senha");
                String tipoUSer = resultSet.getString("tipoDeUsario");
                String username = resultSet.getString("username");

                UserModel user = new UserModel(id, mail, sen, tipoUSer, username);
                users.add(user);
            }

            System.out.println("Lista de usuarios: " + users);

            connection.close();

            return users;

        }
        catch (Exception e)
        {
            System.out.println("Erro ao verificar login: " + e.getMessage());

            return null;
        }
    }

    public UserModel buscandoUserPorId(String string)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM use WHERE IDDOUSER = ?");
            preparedStatement.setString(1, string);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {
                String iduser = resultSet.getString("iddouser");
                String img = resultSet.getString("IMGFERFIL");
                String name = resultSet.getString("NOMEDOPERFIL");

                UserModel user = new UserModel(iduser, img,name );
                return user;
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar usuario por id: " + e.getMessage());
        }
        return null;
    }
}

