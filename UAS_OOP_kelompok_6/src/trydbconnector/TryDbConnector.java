package trydbconnector;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TryDbConnector {
    public static Connection connection;
    public static Statement statement;
    public static void main(String[] args) throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/db_reservasi_baru";
            String user = "root";
            String pswd = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, user, pswd);
            String query = "INSERT INTO tb_mahasiswa(nim, nama) VALUES('21010233', 'gatau')";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.execute();
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(TryDbConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
