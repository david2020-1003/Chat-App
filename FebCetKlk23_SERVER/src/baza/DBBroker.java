/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import controller.Controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

    public boolean proveriKorIme(String korIme) {
        try {
            String upit = "SELECT * FROM USER WHERE korisnickoIme ='" + korIme + "'";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            
            ResultSet rs = st.executeQuery(upit);
            if(rs.next()){
                return false;
            }else{
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean unesiKorisnika(String korIme, String lozinka) {
        try {
            String upit = "INSERT INTO USER (korisnickoIme,lozinka) VALUES (?,?)";
            
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1, korIme);
            ps.setString(2, lozinka);
            
            int brojRedova = ps.executeUpdate();
            if(brojRedova > 0){
                JOptionPane.showMessageDialog(null, "Uspesan unos");
                Konekcija.getInstance().getConnection().commit();
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Neuspesan unos");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
