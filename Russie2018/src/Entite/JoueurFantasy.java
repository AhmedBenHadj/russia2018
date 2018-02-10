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
 * @author quickstrikes96
 */
public class JoueurFantasy {

    private int id;
    private Joueur Joueur;
    private int posteF;
    private int etat;
    private int prix;
    private int points;
    private List<EquipeFantasy> FEquipes;

    public JoueurFantasy() {
        this.Joueur = new Joueur();
        this.FEquipes = new ArrayList();

    }

    public JoueurFantasy(int id, Joueur Joueur, ArrayList<EquipeFantasy> FEquipes, int posteF, int etat, int prix, int points) {
        this.id = id;
        this.Joueur = new Joueur();
        this.FEquipes = new ArrayList<EquipeFantasy>();
        this.posteF = posteF;
        this.etat = etat;
        this.prix = prix;
        this.points = points;
    }

    public JoueurFantasy(Joueur Joueur, int posteF, int etat, int prix, int points) {

        this.Joueur = new Joueur();
        this.posteF = posteF;
        this.etat = etat;
        this.prix = prix;
        this.points = points;
    }

    public Joueur getJoueur() {
        return Joueur;
    }

    public void setJoueur(Joueur Joueur) {
        this.Joueur = Joueur;
    }

    public int getPosteF() {
        return posteF;
    }

    public void setPosteF(int poste) {
        this.posteF = poste;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<EquipeFantasy> getFEquipes() {
        return FEquipes;
    }

    public void setFEquipes(List<EquipeFantasy> FEquipes) {
        this.FEquipes = FEquipes;
    }

    

}
