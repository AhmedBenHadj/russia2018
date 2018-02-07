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
public interface Iequipe {
    boolean ajouter(equipe e) ;
    void modifier(int id,entraineur entraineur,String nom,String drapeau ,String maillot) ;
    boolean supprimer(equipe e);
    equipe get(int id);
    List<equipe> getALL();
    List<equipe> D_chercher(String nom);
    entraineur get_entraineur(equipe e);
    List<equipe> get_tri_selon(String champs);
    List<joueur> get_joueurs(equipe e);
}
