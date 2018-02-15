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
public interface IServiceEquipe {
    boolean ajouter(Equipe e) ;
    void modifier(int id, Entraineur Entraineur, String nom, String drapeau, String maillot,Equipe.Progress progress,int pts) ;
    boolean supprimer(Equipe e);
    Equipe get(int id);
    List<Equipe> getALL();
    List<Equipe> D_chercher(String nom);
    Entraineur get_Entraineur(Equipe e);
    List<Equipe> get_tri_selon(String champs);
    List<Joueur> get_Joueurs(Equipe e);
    List<Joueur> get_Joueurs(int id);
}
