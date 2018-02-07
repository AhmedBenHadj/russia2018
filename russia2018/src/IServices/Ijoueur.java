/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entite.entraineur;
import Entite.equipe;
import Entite.joueur;
import java.util.List;

/**
 *
 * @author eloss
 */
public interface Ijoueur {
    boolean ajouter(joueur j) ;
    void modifier(int id,equipe equipe,String nom,String prenom ,int age ,String poste,int numero,String club) ;
    boolean supprimer(joueur j);
    joueur get(int id);
    List<joueur> getALL();
    List<joueur> D_chercher(String nom);
    equipe get_equipe(joueur j);
    entraineur get_entraineur(joueur j);
    List<joueur> get_tri_selon(String champs);
}
