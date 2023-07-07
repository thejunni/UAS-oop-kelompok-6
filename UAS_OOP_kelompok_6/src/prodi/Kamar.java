package prodi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import trydbconnector.connection.ConnectionDb;

public class Kamar {
    private int id;
    private String type;
    private int jumlah;
    private int harga;

    public Kamar(int id, String type, int jumlah, int harga) {
        this.id = id;
        this.type = type;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public int getId() { 
        return id;
    }

    public String getType() {
        return type;
    }
    
    public int getJumlah() {
        return jumlah;
    }
    
    public int getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return this.type;
    }
    
    public static List<Kamar> getListKamar() throws SQLException {
        List<Kamar> listKamar = new ArrayList<>();
        try {
            String query = "SELECT id_kamar, type_kamar, jumlah_kamar, harga FROM db_kamar";
            Connection con = ConnectionDb.configDb();
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while(res.next()){
                Kamar kamar = new Kamar(res.getInt("id_kamar"), res.getString("type_kamar"), res.getInt("jumlah_kamar"), res.getInt("harga"));
                listKamar.add(kamar);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return listKamar;
    }
}
