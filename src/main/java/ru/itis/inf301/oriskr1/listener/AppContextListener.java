package ru.itis.inf301.oriskr1.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ru.itis.inf301.oriskr1.repository.DBConnection;


@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DBConnection.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBConnection.getInstance().destroy();
    }
}
