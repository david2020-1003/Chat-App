/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;

/**
 *
 * @author PC
 */
public class DBBroker {

    public Admin login(String username, String pass) {
        Admin a = null;
        try {
            String upit = "SELECT * FROM ADMIN WHERE KORISNICKOIME = ? AND LOZINKA = ?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("adminId");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                a = new Admin(id, ime, prezime, username, pass);
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
}
