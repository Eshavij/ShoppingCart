package DAO;

/**
 * Created by esha on 2/20/17.
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {


    final static  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String DB_URL="jdbc:mysql://localhost:3306/Shoppingcart";
    final static String DB_HOST="root";
    final static String DB_PASSWORD="password";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection conn=null;
        conn=DriverManager.getConnection(DB_URL,DB_HOST,DB_PASSWORD);
        System.out.println("Connected to database successfully");
        return conn;
    }
}

