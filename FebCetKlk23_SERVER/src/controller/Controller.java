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
import java.util.ArrayList;
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
    private List<User> ulogovaniKorisnici = new ArrayList<>();

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
        User u = dbb.loginUsera(user);
        if(!ulogovaniKorisnici.contains(u)){
            ulogovaniKorisnici.add(u);
        }
        return dbb.loginUsera(user);
    }

    public void posaljiSvima(Poruka poruka) {
        dbb.posaljiSvima(poruka);
    }

    public List<User> getUlogovaniKorisnici() {
        return ulogovaniKorisnici;
    }

    public void posaljiJednom(Poruka poruka) {
        dbb.posaljiJednom(poruka);
    }

    public List<Poruka> vratiSvePorukeKorsinika(User user) {
        return dbb.vratiSvePorukeKorisnika(user);
    }

    
    
    
}
