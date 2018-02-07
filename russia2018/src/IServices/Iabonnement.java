/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entite.abonnement;
import Entite.joueur;
import Entite.User;

import java.util.List;
import java.util.Map;

/**
 *
 * @author eloss
 */
public interface Iabonnement {
    boolean ajouter(abonnement a) ;
    void modifier(int id,User user,joueur joueur) ;
    boolean supprimer(abonnement a);
    abonnement get(int id);
    List<abonnement> getALL();
    //List<abonnement> D_chercher_of_user(String nom);
    List<abonnement> D_chercher_of_joueur(String nom);
    List<joueur> get_joueurs();
    List<User> get_users();
    Map<User ,List<joueur>> get_users_etleur_joueur();
    boolean s_abonner_a(User user ,joueur joueur) ;
}
