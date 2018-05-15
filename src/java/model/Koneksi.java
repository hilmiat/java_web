/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hilmiat
 */
public class Koneksi {
    private Connection con;

    public Koneksi() {
        initDB();
    }

    private void initDB() {
        try {
            String dbhost = "localhost";
            String dbuser = "myuser";
            String dbpass = "mypass";
            String dbname = "anggaran";
            String url = "jdbc:mysql://"+dbhost+":3306/"+dbname;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,dbuser,dbpass);
            System.out.println("Koneksi Sukses");
        } catch (Exception ex) {
            System.out.println("Koneksi Gagal");
            ex.printStackTrace();
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Connection getKoneksi(){
        try {
            if(this.con==null || this.con.isClosed()){
                this.initDB();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.con;
    }
    public void closeKoneksi(){
        if(this.con != null){
            try {
                this.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
