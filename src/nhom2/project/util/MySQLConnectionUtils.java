package nhom2.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtils {
	private static String DB_URL = "jdbc:mysql://localhost:3306/learningtools";
    private static String USER_NAME = "root";
    private static String PASSWORD = "congdanh010101";
    
    public static Connection getConnection(String dbURL, String userName, 
            String password) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
    	return getConnection(DB_URL, USER_NAME, PASSWORD);
    }
    
    public static void disconnectMySQL(Connection conn) throws SQLException {
    	if(conn !=null && !conn.isClosed()) conn.close();
    }

	
}
