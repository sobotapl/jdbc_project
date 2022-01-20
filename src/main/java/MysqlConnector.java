import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector {

    public static final String SERVER_URL = "jdbc:mysql://localhost:3306";
    public static final String USER_NAME = "root";
    public static final String USER_PASSWORD = "coderslab";


    public static Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(SERVER_URL, USER_NAME , USER_PASSWORD);
        return connection;
    }

    public static Connection connect(String dbName) throws SQLException {
        Connection connection = DriverManager.getConnection(SERVER_URL + "/dbName", USER_NAME , USER_PASSWORD);
        return connection;
    }


}