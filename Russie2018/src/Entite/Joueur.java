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
public class Joueur {
    private int id ;
    private Equipe equipe ;
    private String nom ;
    private String prenom ;
    private int age ;
    private String poste ;
    private int numero ;
    private String club ;
    private String image ;
    
    public Joueur(){
        this.id =0 ;
        this.equipe = new Equipe();
        this.nom="";
        this.prenom="";
        this.age=0;
        this.poste="";
        this.numero=0;
        this.club="";
        this.image="";
    }
    public Joueur(int id ,Equipe equipe,String nom ,String prenom ,int age ,String poste,int numero ,String club,String image){
        this.id = id ;
        this.equipe =equipe;
        this.nom = nom ;
        this.prenom = prenom ;
        this.age = age ;
        this.poste = poste ;
        this.numero=numero;
        this.club = club ;
        this.image= image ;
    }

    
    public Joueur(Equipe equipe,String nom ,String prenom ,int age ,String poste ,int numero,String club,String image){
        this.equipe = equipe;
        this.nom = nom ;
        this.prenom = prenom ;
        this.age = age ;
        this.poste = poste ;
        this.numero= numero;
        this.club = club ;
        this.image = image ;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    @Override
    public String toString(){
       return "id :"+id+" id_equipe :"+this.equipe.getId()+" nom :"+this.nom+" prenom :"+this.prenom+" age :"+this.age+" poste :"+this.poste+" numero :"+this.numero+" club :"+this.club ; 
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null && o instanceof Joueur){
            Joueur j= (Joueur) o ;
            if(j.getId() == this.id)
                return true ;
        }
        return false ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
