/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author PC
 */
public class Korisnik implements Serializable {
    private int id;
    private String korIme;
    private String korSifra;

    public Korisnik() {
    }

    public Korisnik(int id, String korIme, String korSifra) {
        this.id = id;
        this.korIme = korIme;
        this.korSifra = korSifra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getKorSifra() {
        return korSifra;
    }

    public void setKorSifra(String korSifra) {
        this.korSifra = korSifra;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "id=" + id + ", korIme=" + korIme + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.korIme, other.korIme);
    }
    
    
}
