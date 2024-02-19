package br.com.wmjc.db.user.profile;

import br.com.wmjc.config.ConnectionPoolConfig;
import br.com.wmjc.model.user.profile.ProfileModel;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO
{
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

    public String buscarPorIdUserString(String id)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERFIL_DO_USARIO WHERE IDDOUSER = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                String profileName = resultSet.getString("id");

                preparedStatement.close();
                connection.close();

                return profileName;
            }
        }
        catch (Exception e)
        {
            System.out.println("ProfileDAO - Erro: " + e.getMessage());
        }
        return null;
    }

    public ProfileModel buscarPorIdUser(String id)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERFIL_DO_USARIO  WHERE iddoUser = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            ProfileModel perfil = null;

            while (resultSet.next())
            {
                BigInteger idPerfil = BigInteger.valueOf(resultSet.getInt("id"));
                BigInteger idDoUser = BigInteger.valueOf(resultSet.getInt("iddoUser"));
                String profileName = resultSet.getString("NomeDoPerfil");
                String picProfile = resultSet.getString("imgFerfil");
                String typeUser = resultSet.getString("TipoDeUser");

                perfil = new ProfileModel(idPerfil, idDoUser, profileName, picProfile, typeUser);
            }

            connection.close();

            return perfil;
        }
        catch (Exception e)
        {
            System.out.println("ProfileDAO - Erro: " + e.getMessage()); return null;
        }
    }

    public ProfileModel buscarPorIdUserGame(String id)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERFIL_DO_USARIO  WHERE id = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            ProfileModel perfil = null;

            while (resultSet.next())
            {
                BigInteger idPerfil = BigInteger.valueOf(resultSet.getInt("id"));
                BigInteger idDoUser = BigInteger.valueOf(resultSet.getInt("iddoUser"));
                String profileName = resultSet.getString("NomeDoPerfil");
                String picProfile = resultSet.getString("imgFerfil");
                String typeUser = resultSet.getString("TipoDeUser");

                perfil = new ProfileModel(idPerfil, idDoUser, profileName, picProfile, typeUser);
            }

            connection.close();

            return perfil;
        }
        catch (Exception e)
        {
            System.out.println("ProfileDAO - Erro: " + e.getMessage()); return null;
        }
    }

    public void uptadePerfil(String id, String profileName, String picProfile)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PERFIL_DO_USARIO SET NOMEDOPERFIL = ?, imgFerfil = ? WHERE IDDOUSER = ?");
            preparedStatement.setString(1, profileName);
            preparedStatement.setString(2, picProfile);
            preparedStatement.setString(3, id);

            preparedStatement.executeUpdate();

            connection.close();
        }
        catch (Exception e)
        {
            System.out.println("ProfileDAO - Erro: " + e.getMessage());
        }
    }

    public void createProfile(String id, String profileName, String picProfile)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Perfil_Do_Usario (iddoUser, NomeDoPerfil, imgFerfil, TipoDeUser) VALUES (?, ?, ?, ?);");
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, profileName);
            preparedStatement.setString(3, picProfile);
            preparedStatement.setString(4, "user");

            preparedStatement.executeUpdate();

            connection.close();
        }
        catch (Exception e)
        {
            System.out.println("ProfileDAO - Erro: " + e.getMessage());
        }
    }

    public Boolean validarPerfil(String id)
    {
        try (Connection connection = ConnectionPoolConfig.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERFIL_DO_USARIO WHERE IDDOUSER = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                connection.close();
                return true;
            }
        }
        catch (Exception e)
        {
            System.out.println("ProfileDAO - Erro: " + e.getMessage());
        }
        return false;
    }
}
