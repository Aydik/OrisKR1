package ru.itis.inf301.oriskr1.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;

import java.sql.*;

public class DBConnection {

    private static DBConnection instance;
    private static HikariDataSource dataSource;


    private DBConnection() {
        initDB();
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    private void initDB() {
        try {
            Class.forName("org.postgresql.Driver");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/oriskr1");
            config.setUsername("postgres");
            config.setPassword("passwd");
            config.setConnectionTimeout(50000);
            config.setMaximumPoolSize(10);
            dataSource = new HikariDataSource(config);

            Flyway flyway = Flyway.configure().dataSource(dataSource)
                    .baselineOnMigrate(true).load();
            System.out.println("start migration");
            flyway.migrate();
            System.out.println("migration done");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public synchronized void releaseConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public void destroy() {
        dataSource.close();
    }
}