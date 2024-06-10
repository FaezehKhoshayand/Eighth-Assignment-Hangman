package hangman;

import java.sql.*;
import java.util.UUID;

// Use JDBC to connect to your database and run queries

public class DatabaseManager {
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String Username = "postgres";
    private static final String Password = "Faezeh@84";
    private static Connection connection;
    private Statement statement;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(jdbcUrl);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("ERROR WHILE CONNECTING TO DATABASE");
            throw new RuntimeException(e);
        }
    }
    public static void signUp(Account account) {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(jdbcUrl, Username, Password);
            c.setAutoCommit(false);
            stmt = c.prepareStatement("INSERT INTO public.UserInfo(\"Name\", \"Username\",\"Password\") VALUES (?, ?, ?);");
            stmt.setString(1, account.getName());
            stmt.setString(2, account.getUsername());
            stmt.setString(3, account.getPassword());
            stmt.executeUpdate();
            c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Account findUser(String username, String password) {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(jdbcUrl, Username, Password);
            c.setAutoCommit(false);

            stmt = c.prepareStatement("SELECT * FROM UserInfo WHERE \"Username\" = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (username.equals(rs.getString("Username")) && password.equals(rs.getString("Password"))) {
                    Account account = new Account(rs.getString("Name"), username, password);
                    return account;
                }
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean usernameExists(String username) {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(jdbcUrl, Username, Password);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully (selectUserInfos)");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM UserInfo;");
            while (rs.next()) {
                if(username.equals(rs.getString("Username"))) {
                    return true;
                }
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Operation done successfully (selectUserInfos)");
        return false;
    }
    public static void main(String[] args) throws SQLException {

    }
}