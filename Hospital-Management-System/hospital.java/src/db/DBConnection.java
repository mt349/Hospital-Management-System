package db;
import java.sql.*;

public class DBConnection {


    private static final String URL =  System.getenv("DB_URL");

    private static final String USER =  System.getenv("DB_USER");

    private static final String PASS = System.getenv("DB_PASS");

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Download Drivers
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL,USER,PASS);
    }

    
}


