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
public class Equipe {
    private int id;
    private Entraineur e;
    private String nom;

    public Equipe() {
    }

    public Equipe(Entraineur e, String nom) {
        this.e = e;
        this.nom = nom;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
