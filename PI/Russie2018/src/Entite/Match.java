/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author skanderbejaoui
 */
public class Match {
    private int id;
    private Equipe e1;
    private Equipe e2;
    private Date date;
    private float nbspec;

    public Match(Equipe e1, Equipe e2, Date date, float nbspec) {
        this.e1 = e1;
        this.e2 = e2;
        this.date = date;
        this.nbspec = nbspec;
    }

    public Equipe getE1() {
        return e1;
    }

    public void setE1(Equipe e1) {
        this.e1 = e1;
    }

    public Equipe getE2() {
        return e2;
    }

    public void setE2(Equipe e2) {
        this.e2 = e2;
    }

    
    
    public Match() {
        this.e1=new Equipe();
        this.e2=new Equipe();
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getNbspec() {
        return nbspec;
    }

    public void setNbspec(float nbspec) {
        this.nbspec = nbspec;
    }
    
    
}
