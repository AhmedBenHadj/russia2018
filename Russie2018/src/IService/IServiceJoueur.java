/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.*;

import java.util.List;

/**
 *
 * @author eloss
 */
public interface IServiceJoueur {
    boolean ajouter(Joueur j) ;
    void modifier(int id,Equipe equipe,String nom,String prenom ,int age ,String poste,int numero,String club,String image) ;
    boolean supprimer(Joueur j);
    Joueur get(int id);
    List<Joueur> getALL();
    List<Joueur> D_chercher(String nom);
    Equipe get_Equipe(Joueur j);
    Entraineur get_Entraineur(Joueur j);
    List<Joueur> get_tri_selon(String champs);
}
