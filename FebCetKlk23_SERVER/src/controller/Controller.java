/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import model.Admin;

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
    
    
}
