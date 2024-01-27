package br.com.wmjc.db.user.profile;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.user.profile.ProfileModel;

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
            return lista;
        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;

        }
    }
}
