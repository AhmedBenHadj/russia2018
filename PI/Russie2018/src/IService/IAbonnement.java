/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.*;
import Entite.User;

import java.util.List;
import java.util.Map;

/**
 *
 * @author eloss
 */
public interface IAbonnement {
    boolean ajouter(Abonnement a) ;
    void modifier(int id,User user,Joueur joueur) ;
    boolean supprimer(Abonnement a);
    Abonnement get(int id);
    List<Abonnement> getALL();
    //List<abonnement> D_chercher_of_user(String nom);
    List<Abonnement> D_chercher_of_Joueur(String nom);
    List<Joueur> get_Joueurs();
    List<User> get_users();
    Map<User ,List<Joueur>> get_users_etleur_Joueur();
    boolean s_abonner_a(User user ,Joueur joueur) ;
}
