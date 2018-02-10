/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;


import java.sql.Timestamp;

/**
 *
 * @author hseli
 */

public class Match {
    private int id;
    public enum EtatMatch{Debut,Encours,Terminé};
    private Groupe G;
    private Equipe E1;
    private Equipe E2;
    private Stade S;
    private Timestamp date;
    private String score;
    private EtatMatch etat;
    private int duree;
    private int nombre_spectateur;
    //ArrayList<Evenement> EventMatch;
    // ArrayList<Commentaire> CommMatch;

    

    
    public Match(){
        
    }

    public Match(int id,Groupe G, Equipe E1, Equipe E2, Stade S, Timestamp date, String score, EtatMatch etat, int duree, int nombre_spectateur) {
        this.id = id;
        this.G=G;
        this.E1 = E1;
        this.E2 = E2;
        this.S = S;
        this.date = date;
        this.score = score;
        this.etat = etat;
        this.duree = duree;
        this.nombre_spectateur = nombre_spectateur;
    }

    public Groupe getG() {
        return G;
    }

    public void setG(Groupe G) {
        this.G = G;
    }
 
    public int getDuree() {
        return duree;
    }
    
   public void setDuree(int duree) {
        this.duree = duree;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipe getE1() {
        return E1;
    }

    public void setE1(Equipe E1) {
        this.E1 = E1;
    }

    public Equipe getE2() {
        return E2;
    }

    public void setE2(Equipe E2) {
        this.E2 = E2;
    }

    public Stade getS() {
        return S;
    }

    public void setS(Stade S) {
        this.S = S;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public EtatMatch getEtat() {
        return etat;
    }

    public void setEtat(EtatMatch etat) {
        this.etat = etat;
    }

    public int getNombre_spectateur() {
        return nombre_spectateur;
    }

    public void setNombre_spectateur(int nombre_spectateur) {
        this.nombre_spectateur = nombre_spectateur;
    }

   
    
    
    
}
