
package midterm_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connection_IT26b_Mid {
    
    private static final String URL = "jdbc:mysql://localhost:3306/it26b_midterm";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() {
        Connection conn = null;
        
        try  {
            conn = DriverManager.getConnection(url:URL, user:USER, password:PASSWORD);
            System.out.println(a: "Database Completed Successfully");
        } catch (SQLException e) {
            System.out.println(a: "Connection Failed");
            e.printStackTrace();
        }
        return conn;
    }
}