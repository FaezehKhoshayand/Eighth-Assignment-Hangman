package hangman;

import java.sql.*;

// Use JDBC to connect to your database and run queries

public class DatabaseManager {
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "Faezeh@84";
    private static Connection connection;
    private Statement statement;

    
}