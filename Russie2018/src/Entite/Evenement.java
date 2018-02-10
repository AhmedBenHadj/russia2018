/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;



/**
 *
 * @author hseli
 */
public class Evenement {
    private int id;
    private Match M;
    private Joueur_P JP;
    private int carton;
    private int but;
    private int temps;
    
    public Evenement(){
    }

    public Evenement(int id, Match M, Joueur_P JP, int carton, int but, int temps) {
        this.id = id;
        this.M = M;
        this.JP = JP;
        this.carton = carton;
        this.but = but;
        this.temps = temps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Match getM() {
        return M;
    }

    public void setM(Match M) {
        this.M = M;
    }

    public Joueur_P getJoueur() {
        return JP;
    }

    public void setJoueur(Joueur_P Joueur) {
        this.JP= Joueur;
    }

    public int getCarton() {
        return carton;
    }

    public void setCarton(int carton) {
        this.carton = carton;
    }

    public int getBut() {
        return but;
    }

    public void setBut(int but) {
        this.but = but;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }
    
    
    
    
}
