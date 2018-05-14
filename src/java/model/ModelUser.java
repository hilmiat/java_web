/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String sql = "SELECT * FROM user WHERE email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
            }else{
                user = null;
            }
            
        } catch (SQLException ex) {
            user = null;
            ex.printStackTrace();
//            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
