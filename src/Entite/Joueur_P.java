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
public class Joueur_P {
    private int id;
    private Joueur J;
    private int temps_joue;

    public Joueur_P(){
        
    }
    public Joueur_P(int id, Joueur J, int temps_joue) {
        this.id = id;
        this.J = J;
        this.temps_joue = temps_joue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Joueur getJ() {
        return J;
    }

    public void setJ(Joueur J) {
        this.J = J;
    }

    public int getTemps_joue() {
        return temps_joue;
    }

    public void setTemps_joue(int temps_joue) {
        this.temps_joue = temps_joue;
    }
    
    
    
}
