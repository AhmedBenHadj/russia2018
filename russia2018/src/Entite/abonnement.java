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
public class abonnement {
    private int id ;
    private User user ;
    private joueur joueur ;
    
    public abonnement(){
        this.id=0 ;
        this.user= new User() ;
        this.joueur= new joueur();
    }
    public abonnement(int id ,User user ,joueur joueur){
        this.id=id ;
        this.user =user;
        this.joueur =joueur;
    }
    public abonnement(User user,joueur joueur){
        this.user =user;
        this.joueur =joueur;
    }
    
    @Override
    public String toString(){
        return  "id :"+this.id+" id_user :"+this.user.getId()+" id_joueur :"+this.joueur.getId() ;
    }
    
    @Override
    public boolean equals(Object o){
       if(o != null && o instanceof abonnement){
           abonnement a = (abonnement) o ;
           if(a.getId() == this.id)
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(joueur joueur) {
        this.joueur = joueur;
    }

    
}
