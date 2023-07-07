package trydbconnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import trydbconnector.connection.ConnectionDb;
import prodi.Tamu;

public class FormData extends javax.swing.JFrame {
    private String tbTamuId;
    private String tbTransaksiId;
    private int tamuId;
    private int duration;
    private String tbKamarId;
    public FormData() throws SQLException {
        initComponents();
        load_table();
        load_transaksi();
        load_table_kamar();
//        setListProdi();
//setListTamu();
    }
    
//    private void setListTamu() throws SQLException {
//        List<Tamu> listProdi = Tamu.getListTamu();
//        for(Tamu p : listProdi){
//            NamaTamu.addItem(p);
//        }
//    }
    private void calculateTotal() {
      double hargaKamar = 1000000; // Harga kamar statis
    int jumlahHari = Integer.parseInt(duration_reservasi.getText());
    
    double totalPerHari = hargaKamar * jumlahHari;
    DecimalFormat decimalFormat = new DecimalFormat("Rp #,##0");
    String formattedTotalPerHari = decimalFormat.format(totalPerHari);
    
    total_harga_perhari.setText(formattedTotalPerHari);
}
    private void load_transaksi() {
       DefaultTableModel tableModel = new DefaultTableModel();
       tableModel.addColumn("Nama Tamu");
       tableModel.addColumn("No Transaksi");
       tableModel.addColumn("Tanggal Checkin");
       tableModel.addColumn("Tanggal Checkout");
       tableModel.addColumn("total_harga");
       tableModel.addColumn("status_transaksi");
       
        try {
            String query = "SELECT db_tamu.nama_tamu, no_transaksi, tanggal_check_in, tanggal_check_out, total_harga, status_transaksi from db_transaksi INNER JOIN db_tamu on db_transaksi.id_tamu = db_tamu.id_tamu;";
            Connection con = ConnectionDb.configDb();
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(query);
            while(result.next()){
                System.out.println(result.getString(4));
                Object[] data = new Object[]{result.getInt("nama_transaksi"), result.getString("no_transaksi"), result.getDate("tanggal_checkin"), result.getDate("tangga_checkout"), result.getString("total_harga"), result.getString("status")};
                tableModel.addRow(data);
                TabelTamu.setModel(tableModel);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void load_table() {
       DefaultTableModel tableModel = new DefaultTableModel();
       tableModel.addColumn("Id Tamu");
       tableModel.addColumn("Nama Tamu");
       tableModel.addColumn("No Identitas");
       tableModel.addColumn("Email");
       tableModel.addColumn("No Telepon");
       tableModel.addColumn("Alamat");
       
        try {
            String query = "SELECT * FROM db_tamu";
            Connection con = ConnectionDb.configDb();
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(query);
            while(result.next()){
                System.out.println(result.getString(4));
                Object[] data = new Object[]{result.getInt("id_tamu"), result.getString("nama_tamu"), result.getInt("no_identitas"), result.getString("email"), result.getString("no_telepon"), result.getString("alamat")};
                tableModel.addRow(data);
                TabelTamu.setModel(tableModel);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private void load_table_kamar() {
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Id Kamar");
    tableModel.addColumn("Type Kamar");
    tableModel.addColumn("Jumlah Kamar");
    tableModel.addColumn("Harga");
       
    try {
        String query = "SELECT * FROM db_kamar";
        Connection con = ConnectionDb.configDb();
        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery(query);
        while (result.next()) {
            Object[] data = new Object[]{
                result.getInt("id_kamar"),
                result.getString("type_kamar"),
                result.getInt("jumlah_kamar"),
                result.getInt("harga")
            };
            tableModel.addRow(data);
            TableKamar.setModel(tableModel);
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    
}
   

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Nama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        No = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        Telp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Alamat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelTamu = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        type_kamar = new javax.swing.JTextField();
        jumlah_kamar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jbtn_edit = new javax.swing.JButton();
        jBtnClear = new javax.swing.JButton();
        jBtnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableKamar = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        duration_reservasi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_save_reservasi = new javax.swing.JButton();
        btn_edit_reservasi = new javax.swing.JButton();
        btn_clear_reservasi = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelReservasi = new javax.swing.JTable();
        Nama_tamu_reservasi = new javax.swing.JComboBox<>();
        type_kamar_reservasi = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        total_harga_perhari = new javax.swing.JTextArea();
        cek_total = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Nama Tamu :");

        Nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaActionPerformed(evt);
            }
        });

        jLabel6.setText("No Identitas :");

        jLabel10.setText("E- Mail         :");

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        jLabel7.setText("No Telepon :");

        jLabel8.setText("Alamat        :");

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        TabelTamu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama Tamu", "No Identitas", "E-mail", "No Telepon", "Alamat"
            }
        ));
        TabelTamu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelTamuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelTamu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Telp, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Form Tamu", jPanel2);

        jLabel1.setText("Type Kamar :");

        jumlah_kamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlah_kamarActionPerformed(evt);
            }
        });

        jLabel2.setText("Jumlah Kamar :");

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });

        jLabel3.setText("Harga :");

        jbtn_edit.setText("Edit");
        jbtn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_editActionPerformed(evt);
            }
        });

        jBtnClear.setText("Clear");
        jBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearActionPerformed(evt);
            }
        });

        jBtnSave.setText("Simpan");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        TableKamar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Type Kamar", "Jumlah Kamar", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableKamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableKamarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableKamar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)))
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jumlah_kamar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(type_kamar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtn_edit)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnClear)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnSave)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(type_kamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jumlah_kamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_edit)
                    .addComponent(jBtnClear)
                    .addComponent(jBtnSave))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Form Kamar", jPanel1);

        jLabel9.setText("Nama Tamu :");

        jLabel11.setText("Type_kamar :");

        jLabel12.setText("Lama_menginap :");

        duration_reservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duration_reservasiActionPerformed(evt);
            }
        });

        jLabel13.setText("Total :");

        btn_save_reservasi.setText("Save");
        btn_save_reservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_save_reservasiActionPerformed(evt);
            }
        });

        btn_edit_reservasi.setText("Edit");
        btn_edit_reservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_reservasiActionPerformed(evt);
            }
        });

        btn_clear_reservasi.setText("Clear");
        btn_clear_reservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear_reservasiActionPerformed(evt);
            }
        });

        tabelReservasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabelReservasi);

        Nama_tamu_reservasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Nama_tamu_reservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nama_tamu_reservasiActionPerformed(evt);
            }
        });

        type_kamar_reservasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih kamar", "pilih kamar" }));
        type_kamar_reservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_kamar_reservasiActionPerformed(evt);
            }
        });

        jLabel14.setText("/ Hari");

        total_harga_perhari.setColumns(20);
        total_harga_perhari.setRows(5);
        jScrollPane4.setViewportView(total_harga_perhari);

        cek_total.setText("CEK TOTAL");
        cek_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cek_totalActionPerformed(evt);
            }
        });

        jLabel15.setText("*Harga Kamar = 1.000.000 untuk semua type");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Nama_tamu_reservasi, 0, 238, Short.MAX_VALUE)
                        .addComponent(type_kamar_reservasi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(duration_reservasi, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_save_reservasi)
                        .addComponent(btn_clear_reservasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_edit_reservasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cek_total))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Nama_tamu_reservasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(type_kamar_reservasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(duration_reservasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel13))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btn_save_reservasi)
                        .addGap(18, 18, 18)
                        .addComponent(btn_edit_reservasi)
                        .addGap(24, 24, 24)
                        .addComponent(btn_clear_reservasi)
                        .addGap(18, 18, 18)
                        .addComponent(cek_total)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Form Reservasi", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelTamuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelTamuMouseClicked
        // TODO add your handling code here:
        int row = TabelTamu.rowAtPoint(evt.getPoint());

        tbTamuId = TabelTamu.getValueAt(row, 0).toString();
        String namaTamu = TabelTamu.getValueAt(row, 1).toString();
        Nama.setText(String.valueOf(namaTamu));
        int no_identitas = Integer.parseInt(TabelTamu.getValueAt(row, 2).toString());
        No.setText(String.valueOf(no_identitas));
        String email = TabelTamu.getValueAt(row, 3).toString();
        Email.setText(email);
        String noTelp = TabelTamu.getValueAt(row, 4).toString();
        Telp.setText(noTelp);
        String alamat = TabelTamu.getValueAt(row, 5).toString();
        Alamat.setText(alamat);
    }//GEN-LAST:event_TabelTamuMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String telp = Telp.getText();
        try {
            int convertToInt = Integer.parseInt(telp);
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Kolom Telp harus angka");
        }
        try {
            String sql = "UPDATE db_tamu SET nama_tamu=?, no_identitas=?, email=?, no_telepon=?, alamat=? WHERE id_tamu=?";
            Connection con = ConnectionDb.configDb();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Nama.getText());
            pst.setString(2, No.getText());
            pst.setString(3, Email.getText());
            pst.setInt(4, Integer.parseInt(telp));
            pst.setString(5, Alamat.getText());
            pst.setString(6, tbTamuId);
            //            System.out.println(cbProdi.getSelectedIndex());
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Success Add Data");
            load_table();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM db_tamu WHERE id_tamu=?";
            Connection con = ConnectionDb.configDb();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(tbTamuId));
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Success Delete Data");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        load_table();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String telp = Telp.getText();
        try {
            int convertToInt = Integer.parseInt(telp);
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Kolom Telp harus angka");
        }
        try {
            String sql = "INSERT INTO db_tamu(nama_tamu, no_identitas, email, no_telepon, alamat) VALUES(?, ?, ?, ?, ?)";
            Connection con = ConnectionDb.configDb();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Nama.getText());
            pst.setString(2, No.getText());
            pst.setString(3, Email.getText());
            pst.setInt(4, Integer.parseInt(telp));
            pst.setString(5, Alamat.getText());
            //            System.out.println(cbProdi.getSelectedIndex());
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Success Add Data");
            load_table();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void NamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaActionPerformed

    private void jumlah_kamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlah_kamarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlah_kamarActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void jbtn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_editActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE db_kamar SET type_kamar=?, jumlah_kamar=?, harga=? WHERE id_kamar=?";
            Connection con = ConnectionDb.configDb();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, type_kamar.getText());
            pst.setInt(2, Integer.parseInt(jumlah_kamar.getText()));
            pst.setInt(3, Integer.parseInt(harga.getText()));
            pst.setInt(4, Integer.parseInt(tbKamarId));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Success Update Data");
            load_table_kamar();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jbtn_editActionPerformed

    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM db_kamar WHERE id_kamar=?";
            Connection con = ConnectionDb.configDb();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(tbKamarId));
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "Success Delete Data");
            load_table_kamar();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_jBtnClearActionPerformed

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO db_kamar(type_kamar, jumlah_kamar, harga) VALUES (?, ?, ?)";
            Connection con = ConnectionDb.configDb();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, type_kamar.getText());
            pst.setInt(2, Integer.parseInt(jumlah_kamar.getText()));
            pst.setInt(3, Integer.parseInt( harga.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Success Add Data");
            load_table_kamar();
        } catch (SQLException ex) {
             System.out.println(ex);
        }
    }//GEN-LAST:event_jBtnSaveActionPerformed

    private void TableKamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableKamarMouseClicked
        // TODO add your handling code here:
        int row = TableKamar.rowAtPoint(evt.getPoint());

        tbKamarId = TableKamar.getValueAt(row, 0).toString();
        String typeKamar = TableKamar.getValueAt(row, 1).toString();
        type_kamar.setText(typeKamar);
        int jumlahKamar = Integer.parseInt(TableKamar.getValueAt(row, 2).toString());
        jumlah_kamar.setText(String.valueOf(jumlahKamar));
        int hargakamar = Integer.parseInt(TableKamar.getValueAt(row, 3).toString());
        harga.setText(String.valueOf(hargakamar));
    }//GEN-LAST:event_TableKamarMouseClicked

    private void btn_save_reservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_save_reservasiActionPerformed
        // TODO add your handling code here:
        saveReservation();
    }//GEN-LAST:event_btn_save_reservasiActionPerformed

    private void clearForm() {
    Nama_tamu_reservasi.setSelectedIndex(0);
    type_kamar_reservasi.setSelectedIndex(0);
    duration_reservasi.setText("");
    total_harga_perhari.setText("");
}
    private void saveReservation() {
    String namaTamu = Nama_tamu_reservasi.getSelectedItem().toString();
    String typeKamar = type_kamar_reservasi.getSelectedItem().toString();
    int duration = Integer.parseInt(duration_reservasi.getText());
    double total = Double.parseDouble(total_harga_perhari.getText());

    try {
        Connection connection = ConnectionDb.configDb();
        String query = "INSERT INTO db_reservasi (nama_tamu, type_kamar, duration, total) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, namaTamu);
        statement.setString(2, typeKamar);
        statement.setInt(3, duration);
        statement.setDouble(4, total);
        statement.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data reservasi berhasil disimpan");
        clearForm();
        
        statement.close();
        connection.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data reservasi");
    }
    
}
    private void Nama_tamu_reservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nama_tamu_reservasiActionPerformed
        // TODO add your handling code here:
          Nama_tamu_reservasi.removeAllItems();
        
        try {
            String query = "SELECT type_kamar FROM db_tamu";
            Connection con = ConnectionDb.configDb();
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()) {
                String namaTamu = res.getString("nama_tamu");
                Nama_tamu_reservasi.addItem(namaTamu);
            }
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
        
    }//GEN-LAST:event_Nama_tamu_reservasiActionPerformed

    private void type_kamar_reservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_kamar_reservasiActionPerformed
        // TODO add your handling code here: 
        type_kamar_reservasi.removeAllItems();
        
        try {
            String query = "SELECT type_kamar FROM db_kamar";
            Connection con = ConnectionDb.configDb();
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()) {
                String typeKamar = res.getString("type_kamar");
                type_kamar_reservasi.addItem(typeKamar);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_type_kamar_reservasiActionPerformed

    private void duration_reservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duration_reservasiActionPerformed
        // TODO add your handling code here:
        try {
        String durationText = duration_reservasi.getText();
        if (!durationText.isEmpty()) {
            duration = Integer.parseInt(durationText);
//            calculateTotal();
        }
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(this, "Durasi harus berupa angka");
        }
    }//GEN-LAST:event_duration_reservasiActionPerformed

    private void btn_edit_reservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_reservasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_reservasiActionPerformed

    private void btn_clear_reservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear_reservasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clear_reservasiActionPerformed

    private void cek_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cek_totalActionPerformed
        // TODO add your handling code here:
        
        calculateTotal();
    }//GEN-LAST:event_cek_totalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormData().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Alamat;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Nama;
    private javax.swing.JComboBox<String> Nama_tamu_reservasi;
    private javax.swing.JTextField No;
    private javax.swing.JTable TabelTamu;
    private javax.swing.JTable TableKamar;
    private javax.swing.JTextField Telp;
    private javax.swing.JButton btn_clear_reservasi;
    private javax.swing.JButton btn_edit_reservasi;
    private javax.swing.JButton btn_save_reservasi;
    private javax.swing.JButton cek_total;
    private javax.swing.JTextField duration_reservasi;
    private javax.swing.JTextField harga;
    private javax.swing.JButton jBtnClear;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JButton jbtn_edit;
    private javax.swing.JTextField jumlah_kamar;
    private javax.swing.JTable tabelReservasi;
    private javax.swing.JTextArea total_harga_perhari;
    private javax.swing.JTextField type_kamar;
    private javax.swing.JComboBox<String> type_kamar_reservasi;
    // End of variables declaration//GEN-END:variables
}
