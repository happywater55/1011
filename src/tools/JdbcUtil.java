package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    private static String url = "jdbc:mysql:///excise";
    private static String user = "root";
    private static String password = "jia219";
    private static String driver = "com.mysql.jdbc.Driver";

    static {
        try {
            Class.forName(driver);
        }
        catch (Exception e){
            System.out.println("exception");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
}
