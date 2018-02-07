/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author eloss
 */
public class equipe {
    private int id ;
    private String nom ;
    private String drapeau ;
    private String maillot ;
    private entraineur entraineur ;
    
    public equipe(){
        this.id = 0 ;
        this.nom = "";
        this.drapeau="";
        this.maillot="";
        entraineur = new entraineur();
    }
    public equipe(int id ,entraineur entraineur,String nom ,String drapeau ,String maillot){
        this.id=id; 
        this.entraineur =entraineur;
        this.nom = nom ;
        this.drapeau = drapeau;
        this.maillot = maillot;
    }
    public equipe(entraineur entraineur,String nom ,String drapeau ,String maillot){
        this.entraineur = entraineur;
        this.nom = nom ;
        this.drapeau = drapeau;
        this.maillot = maillot;
    }

    @Override
    public String toString() {
        return "id=" + id + ", id_entraineur=" + entraineur.getId() + ", nom=" + nom + ", drapeau=" + drapeau + ", maillot=" + maillot ;
    }
    @Override
    public boolean equals(Object o){
        if(o != null && o instanceof equipe){
            equipe e = (equipe) o ;
            if(e.getId() == this.id)
                return true ;
        }
        return false ;
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

    public String getDrapeau() {
        return drapeau;
    }

    public void setDrapeau(String drapeau) {
        this.drapeau = drapeau;
    }

    public String getMaillot() {
        return maillot;
    }

    public void setMaillot(String maillot) {
        this.maillot = maillot;
    }
    public entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(entraineur entraineur) {
        this.entraineur = entraineur;
    }    
}
