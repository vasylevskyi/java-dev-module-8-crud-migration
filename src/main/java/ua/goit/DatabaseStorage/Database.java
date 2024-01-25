package ua.goit.DatabaseStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();
    private static final String DB_URL = "jdbc:h2:./MegaSoft";
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
