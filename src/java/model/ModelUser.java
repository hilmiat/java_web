/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author hilmiat
 */
public class ModelUser {
    /**
     * Get all User
     */
    public List<User> getAllUser(){
        List<User> data = new ArrayList<User>();
        //query ke db
        return data;
    }
    /**
     * create user
     */
    public void createUser(User user){
        //insert ke db
    }
    /**
     * auth
     */
    public User auth(String email, String pass){
        User user;
        try {
            //cari di db
            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getKoneksi();
            String sql = "SELECT * FROM user WHERE email = ? and password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,email);
//            MessageDigest md;
            String passhash = this.hashPass(pass);
//            try {
//                md = MessageDigest.getInstance("md5");
//                md.update(pass.getBytes());
//                byte[] digest = md.digest();
//                passhash = DatatypeConverter.printHexBinary(digest);
//            } catch (NoSuchAlgorithmException ex) {
//                
//            }
            
            ps.setString(2,passhash);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                System.out.println("Sukses login sebagai "+user.getEmail());
            }else{
                user = null;
                System.out.println("Gagal Login");
            }
            con.close();
            
        } catch (SQLException ex) {
            user = null;
            ex.printStackTrace();
//            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public void register(User user){
        try {
            Connection con = new Koneksi().getKoneksi();
            String sql = "INSERT INTO user(email,password,fullname) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, this.hashPass(user.getPassword()));
            ps.setString(3, user.getFullname());
            ps.executeUpdate();
//            ps.close();
//            con.close();
            System.out.println("selesai insert");
        } catch (SQLException ex) {
            System.out.println("gagal insert");
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String hashPass(String pass){
        MessageDigest md;
        String passhash="";
        try {
                md = MessageDigest.getInstance("md5");
                md.update(pass.getBytes());
                byte[] digest = md.digest();
                passhash = DatatypeConverter.printHexBinary(digest);
            } catch (NoSuchAlgorithmException ex) {
                
            }
        return passhash;
    }
}
