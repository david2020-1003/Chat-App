/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.niti;

import forme.KlijentskaForma;
import forme.model.ModelTabeleKorisnika;
import forme.model.ModelTabelePoruka;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;
import model.Poruka;
import model.User;
import operacije.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author PC
 */
public class Nit extends Thread {
 
    private KlijentskaForma kf;

    public void setKf(KlijentskaForma kf) {
        this.kf = kf;
    }
    
    
    
    @Override
    public void run() {
        while(true){
            try {
                KlijentskiZahtev kz1 = new KlijentskiZahtev(Operacije.VRATI_SVE_ULOGOVANE, null);
                Komunikacija.getInstance().posaljiZahtev(kz1);
                
                ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
                List<User> ulogovaniKorisnici = (List<User>) so.getOdgovor();
                
                ModelTabeleKorisnika mtk = new ModelTabeleKorisnika(ulogovaniKorisnici);
                kf.getjTableTrenutnoUlogovani().setModel(mtk);
                
                KlijentskiZahtev kz2 = new KlijentskiZahtev(Operacije.VRATI_SVE_PORUKE_KORISNIKA, kf.getKorisnik());
                Komunikacija.getInstance().posaljiZahtev(kz2);
                
                List<Poruka> svePoruke = (List<Poruka>) Komunikacija.getInstance().primiOdgovor().getOdgovor();
                
                if(svePoruke.size() <= 3){
                    ModelTabelePoruka mtp1 = new ModelTabelePoruka(svePoruke);
                    kf.getjTablePoslednje3Poruke().setModel(mtp1);
                }
                if(svePoruke.size()>3){
                    List<Poruka> poslednje3 = svePoruke.subList(svePoruke.size()-3, svePoruke.size());
                    List<Poruka> sveOstale = svePoruke.subList(0, svePoruke.size()-4);
                    
                    ModelTabelePoruka mtp2 = new ModelTabelePoruka(poslednje3);
                    ModelTabelePoruka mtp3 = new ModelTabelePoruka(sveOstale);
                    
                    kf.getjTablePoslednje3Poruke().setModel(mtp2);
                    kf.getjTableOstalePoruke().setModel(mtp3);
                    
                }
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Nit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
