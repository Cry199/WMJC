package br.com.wmjc.db.user.profile;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.user.profile.ProfileModel;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {

    public List<ProfileModel> exibPerfil() {

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERFIL_DO_USARIO ");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<ProfileModel> lista = new ArrayList<>();

            while (resultSet.next()){
                String profileName = resultSet.getString("NomeDoPerfil");
                String picProfile = resultSet.getString("imgFerfil");


                ProfileModel perfil = new ProfileModel(profileName, picProfile);
                lista.add(perfil);
            }
            System.out.println("Perfil carregado newba 0_0");

            connection.close();
            return lista;
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public ProfileModel buscarPorIdUser(String id)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERFIL_DO_USARIO WHERE IDDOUSER = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            ProfileModel perfil = null;

            while (resultSet.next())
            {
                BigInteger idDoUser = BigInteger.valueOf(resultSet.getInt("iddoUser"));
                String profileName = resultSet.getString("NomeDoPerfil");
                String picProfile = resultSet.getString("imgFerfil");

                perfil = new ProfileModel(idDoUser, profileName, picProfile);
            }

            connection.close();

            return perfil;
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e.getMessage()); return null;
        }
    }
}
