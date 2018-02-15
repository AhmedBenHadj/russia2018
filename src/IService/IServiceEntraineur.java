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
public interface IServiceEntraineur {
    boolean ajouter(Entraineur e) ;
    void modifier(int id,String nom,String prenom ,String description) ;
    boolean supprimer(Entraineur e);
    Entraineur get(int id);
    List<Entraineur> getALL();
    List<Entraineur> D_chercher(String nom);
    public List<Entraineur> get_tri_selon(String champs);
}
