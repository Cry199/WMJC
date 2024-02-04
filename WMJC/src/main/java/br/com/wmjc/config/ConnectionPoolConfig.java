package br.com.wmjc.config;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolConfig {

    private static BasicDataSource dataSource;

    private ConnectionPoolConfig() {
        getDataSource();
    }

    public static BasicDataSource getDataSource() {

        if (dataSource == null)
        {
            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_ON_EXIT=FALSE");
            dataSource.setUsername("sa");
            dataSource.setPassword("sa");
            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(10);
            dataSource.setMaxTotal(50);

            System.out.println("New connection pool created with successful");
        }

        return dataSource;
    }

    public static Connection getConnection() throws SQLException { return getDataSource().getConnection(); }

    public static void backupDatabase()
    {
        try (Connection conn = getDataSource().getConnection(); Statement stmt = conn.createStatement())
        {
            System.out.println("Fazendo backup do banco de dados");
            stmt.execute("SCRIPT TO 'src/main/java/br/com/wmjc/db/script/db.sql'");
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao fazer backup");
            System.out.println(e.getMessage());
        }
    }

    public static void restoreDatabase()
    {
        try (Connection conn = getDataSource().getConnection(); Statement stmt = conn.createStatement())
        {
            System.out.println("Rodando script");
            stmt.execute("RUNSCRIPT FROM 'src/main/java/br/com/wmjc/db/script/db.sql'");
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao restaurar backup");
            System.out.println(e.getMessage());
        }
    }
}