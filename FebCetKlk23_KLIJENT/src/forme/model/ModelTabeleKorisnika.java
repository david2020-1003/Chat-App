/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import model.User;

/**
 *
 * @author PC
 */
public class ModelTabeleKorisnika extends AbstractTableModel {

    private List<User> lista;
    private String[] kolone = {"id","korisnickoIme"};

    public ModelTabeleKorisnika() {
    }

    public ModelTabeleKorisnika(List<User> lista) {
        this.lista = lista;
    }

    public List<User> getLista() {
        return lista;
    }

    public void setLista(List<User> lista) {
        this.lista = lista;
    }
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User u = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return u.getUserId();
            case 1:
                return u.getKorisnickoIme();
            default:
                return "NA";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}
