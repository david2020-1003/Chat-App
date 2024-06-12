/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class PokreniServer extends Thread {
    private ServerSocket serverskiSoket;
    private Socket s;
    private boolean kraj = false;

    @Override
    public void run() {
        try {
            serverskiSoket = new ServerSocket(9000);
            System.out.println("Soket je otvoren");
            while(!kraj){
                s = serverskiSoket.accept();
                System.out.println("Klijent je povezan");
                
                ObradaKlijentskihZahteva nit = new ObradaKlijentskihZahteva(s);
                nit.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }
    
    public void zaustaviServer(){
        try {
            kraj = true;
            serverskiSoket.close();
            System.out.println("Soket je zatvoren");
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
