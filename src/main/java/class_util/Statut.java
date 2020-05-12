/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_util;

import java.util.List;

/**
 *
 * @author BigWave
 */
public class Statut {    
    private int idStatut;
    private String libelleStatut;  
    

    public Statut(int idStatut, String libelleStatut) {
        this.idStatut = idStatut;
        this.libelleStatut = libelleStatut;        
    }

    public Statut() {
    }   

    public int getIdStatut() {
        return idStatut;
    }

    public void setIdStatut(int idStatut) {
        this.idStatut = idStatut;
    }

    public String getLibelleStatut() {
        return libelleStatut;
    }

    public void setLibelleStatut(String libelleStatut) {
        this.libelleStatut = libelleStatut;
    }       
    
}
