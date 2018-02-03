package Dao;

import java.sql.*;


public final class DbConnection {

    private static DbConnection instance = null;
    private Connection connection = null;
    private final String DBNAME = "jdbc:sqlite:db.db";

    private DbConnection() {
        getConnectionToDatabase();
    }

    public static DbConnection getInstance() {
        if (instance == null) ; {
            instance = new DbConnection();
        }
        return instance;
    }

    private void getConnectionToDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(DBNAME);
        } catch (SQLException exception) {
        } catch (NullPointerException exception) {
            System.out.println("Database exception");
        } catch (ClassNotFoundException exception) {
            System.out.println("Class not found");
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        getInstance();
    }
}

