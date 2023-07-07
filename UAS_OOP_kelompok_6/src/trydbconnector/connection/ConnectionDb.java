package trydbconnector.connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDb {
    public static Connection connection;
    public static Statement statement;
    
    public static Connection configDb() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/db_reservasi_baru";
            String user = "root";
            String pswd = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, user, pswd);
            statement = connection.createStatement();
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
