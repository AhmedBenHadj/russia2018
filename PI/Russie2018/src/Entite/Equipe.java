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
public class Equipe {
    private int id ;
    private String nom ;
    private String drapeau ;
    private String maillot ;
    private Entraineur entraineur ;
    
    public Equipe(){
        this.id = 0 ;
        this.nom = "";
        this.drapeau="";
        this.maillot="";
        entraineur = new Entraineur();
    }
    public Equipe(int id ,Entraineur entraineur,String nom ,String drapeau ,String maillot){
        this.id=id; 
        this.entraineur =entraineur;
        this.nom = nom ;
        this.drapeau = drapeau;
        this.maillot = maillot;
    }
    public Equipe(Entraineur entraineur,String nom ,String drapeau ,String maillot){
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
        if(o != null && o instanceof Equipe){
            Equipe e = (Equipe) o ;
            if(e.getId() == this.id)
                return true ;
        }
        return false ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        return hash;
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
    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }    
}
