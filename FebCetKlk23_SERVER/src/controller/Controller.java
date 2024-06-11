/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;

/**
 *
 * @author PC
 */
public class Controller {
    private static Controller instance;
    private DBBroker dbb;

    private Controller(){
        dbb = new DBBroker();
    }

    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
    
}
