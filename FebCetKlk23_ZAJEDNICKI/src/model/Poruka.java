/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Poruka implements Serializable {
    private int id;
    private User posiljalac;
    private User primalac;
    private Date datumVreme;
    private String tekst;

    public Poruka() {
    }

    public Poruka(int porukaId, User posiljalac, User primalac, Date datumVreme, String tekst) {
        this.id = porukaId;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.datumVreme = datumVreme;
        this.tekst = tekst;
    }

    public int getPorukaId() {
        return id;
    }

    public void setPorukaId(int porukaId) {
        this.id = porukaId;
    }

    public User getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(User posiljalac) {
        this.posiljalac = posiljalac;
    }

    public User getPrimalac() {
        return primalac;
    }

    public void setPrimalac(User primalac) {
        this.primalac = primalac;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    
    
    
}
