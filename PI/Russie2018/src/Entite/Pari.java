/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author skanderbejaoui
 */
public class Pari {
    private int id;
    private Match m;
    private float cote;
    private float mise;
   private FichePari fp;

   
    public float getMise() {
        return mise;
    }

    public void setMise(float mise) {
        this.mise = mise;
    }
    public FichePari getFp() {
        return fp;
    }

    public void setFp(FichePari fp) {
        this.fp = fp;
    }

    public Match getM() {
        return m;
    }

    public void setM(Match m) {
        this.m = m;
    }

    public Pari() {
        this.fp = new FichePari();
        this.m = new Match();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCote() {
        return cote;
    }

    public void setCote(float cote) {
        this.cote = cote;
    }

   
    
}
