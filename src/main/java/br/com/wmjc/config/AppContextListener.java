package br.com.wmjc.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        System.out.println("Iniciando a aplicação");

        ConnectionPoolConfig.restoreDatabase();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                ConnectionPoolConfig.backupDatabase();
            }
        });
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        System.out.println("Finalizando a aplicação");
    }
}