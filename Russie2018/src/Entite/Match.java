/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author hseli
 */

public class Match {
     private int id;
    public enum EtatMatch{Debut,Encours,Terminé};
    public enum progress{pool,last_16,quart_final,demi_final,final_}
    private Groupe G;
    private Equipe E1;
    private Equipe E2;
    private Stade S;
    private Date date;
    private Time heure;
    private Score score1;
    private String score;
    private EtatMatch etat;
    private int duree;
    private int nombre_spectateur;
    private progress type;
    //ArrayList<Evenement> EventMatch;
    // ArrayList<Commentaire> CommMatch;

    

    
    public Match(){
        
    }

    public Match(Groupe G, Equipe E1, Equipe E2, Stade S, Date date, Time heure, Score score1, String score, EtatMatch etat, int duree, int nombre_spectateur, progress type) {
        this.G = G;
        this.E1 = E1;
        this.E2 = E2;
        this.S = S;
        this.date = date;
        this.heure = heure;
        this.score1 = score1;
        this.score = score;
        this.etat = etat;
        this.duree = duree;
        this.nombre_spectateur = nombre_spectateur;
        this.type = type;
    }

    public Match(int i,Date date,Time heure,Equipe E1,Score score,Equipe E2,Stade S){
        this.id=i;
        this.date = date;
        this.heure = heure;
        this.E1 = E1;
        this.score1 = score;
        this.E2 = E2;
        this.S = S;

    }

    public progress getType() {
        return type;
    }

    public void setType(progress type) {
        this.type = type;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

   

    public Score getScore1() {
        return score1;
    }

    public void setScore1(Score score1) {
        this.score1 = score1;
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
     
    
    @Override
    public String toString() {
        return "Match{" + "id=" + id + ", G=" + G + ", E1=" + E1 + ", E2=" + E2 + ", S=" + S + ", date=" + date + ", score=" + score + ", etat=" + etat + ", duree=" + duree + ", nombre_spectateur=" + nombre_spectateur + ", type=" + type + '}';
    }

   
    
    
    
}
