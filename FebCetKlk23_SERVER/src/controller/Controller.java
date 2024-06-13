/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import baza.Konekcija;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Admin;
import model.Poruka;
import model.User;

/**
 *
 * @author PC
 */
public class Controller {
    private static Controller instance;
    private DBBroker dbb;
    private Admin admin;

    private Controller(){
        dbb = new DBBroker();
    }

    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public boolean login(String username, String pass) {
        admin = dbb.login(username,pass);
        if(admin == null){
            return false;
        }else{
            return true;
        }
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public boolean proveriKorIme(String korIme) {
        return dbb.proveriKorIme(korIme);
    }

    public boolean unesiKorisnika(String korIme, String lozinka) {
        return dbb.unesiKorisnika(korIme,lozinka);
    }

    public List<Poruka> vratiPoruke(int offset) {
        return dbb.vratiPoruke(offset);
    }

    public User loginUsera(User user) {
        return dbb.loginUsera(user);
    }
    
    
}
