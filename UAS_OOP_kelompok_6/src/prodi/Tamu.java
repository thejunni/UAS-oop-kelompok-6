package prodi;

import java.sql.Connection; //connection
import java.sql.DriverManager; //driver
import java.sql.Statement; //sql runner
import java.sql.SQLException; //error handler
import java.sql.ResultSet; //Menyimpan hasil query
import java.util.List;
import java.util.ArrayList;
import trydbconnector.connection.ConnectionDb;

public class Tamu {
    private int id;
    private String nama;

    public Tamu(int id, String nama_tamu) {
        this.id = id;
        this.nama = nama_tamu;
    }

    public int getId() { 
        return id;
    }

    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return this.nama;
    }
    
    public static List<Tamu> getListTamu() throws SQLException {
        List<Tamu> listProdi = new ArrayList<>();
        try {
            String query = "SELECT id_tamu, nama_tamu FROM db_tamu";
            Connection con = ConnectionDb.configDb();
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while(res.next()){
                Tamu prodi = new Tamu(res.getInt("id_tamu"), res.getString("nama_tamu"));
                listProdi.add(prodi);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listProdi;
    }
}
