/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Poruka;
import model.User;

/**
 *
 * @author PC
 */
public class ModelTabelePoruka extends AbstractTableModel {
    private List<Poruka> lista;
    private String[] kolone = {"datumVreme","posiljalac","primalac","tekst"};

    public ModelTabelePoruka() {
    }

    public ModelTabelePoruka(List<Poruka> lista) {
        this.lista = lista;
    }
    
    public List<Poruka> getLista() {
        return lista;
    }

    public void setLista(List<Poruka> lista) {
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
        Poruka p = lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getDatumVreme();
            case 1:
                return p.getPosiljalac().getUserId();
            case 2:
                return p.getPrimalac().getUserId();
            case 3:
                return p.getTekst().length() > 20 ?
                        p.getTekst().substring(0,20) :
                        p.getTekst();
            default:
                return "NA";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
}
