/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entite.entraineur;
import java.util.List;

/**
 *
 * @author eloss
 */
public interface Ientraineur {
    boolean ajouter(entraineur e) ;
    void modifier(int id,String nom,String prenom ,String description) ;
    boolean supprimer(entraineur e);
    entraineur get(int id);
    List<entraineur> getALL();
    List<entraineur> D_chercher(String nom);
    public List<entraineur> get_tri_selon(String champs);
}
