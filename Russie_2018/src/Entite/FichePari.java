/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skanderbejaoui
 */
public class FichePari {
    public enum EtatFiche{Encours,Terminé};
    private int id;
    private float cote_total;
    private EtatFiche etat;
    private List<Pari> paris;
    private USER u;
    private float misetotal;

    public float getMisetotal() {
        return misetotal;
    }

    public void setMisetotal(float misetotal) {
        this.misetotal = misetotal;
    }
    public FichePari() {
        this.u = new USER();
        this.paris = new ArrayList<>();
    }

    public List<Pari> getParis() {
        return paris;
    }

    public void setParis(List<Pari> paris) {
        this.paris = paris;
    }

    public USER getU() {
        return u;
    }

    public void setU(USER u) {
        this.u = u;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCote_total() {
        return cote_total;
    }

    public void setCote_total(float cote_total) {
        this.cote_total = cote_total;
    }


    public EtatFiche getEtat() {
        return etat;
    }

    public void setEtat(EtatFiche etat) {
        this.etat = etat;
    }
    
    

}
