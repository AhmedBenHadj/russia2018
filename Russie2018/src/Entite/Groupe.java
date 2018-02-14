/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.List;

/**
 *
 * @author hseli
 */
public class Groupe {
    private int id;
    private List<Match> GM;
    private String nom;
    private List<Equipe> liste_equipe ;
    public Groupe(){
        
    }
    public Groupe(int id, List<Match> GM, String nom) {
        this.id = id;
        this.GM = GM;
        this.nom = nom;
    }
    public Groupe(List<Match> GM, String nom) {
        this.GM = GM;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Match> getGM() {
        return GM;
    }

    public void setGM(List<Match> GM) {
        this.GM = GM;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Groupe{" + "id=" + id + ", GM=" + GM + ", nom=" + nom + '}';
    }
    
    
    
 }
