/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Joueur_P;
import java.util.List;


/**
 *
 * @author hseli
 */
public interface IServiceJoueur_P {
     public void ajouter_JoueurP(Joueur_P JP);
     public int count_Joueur_P();
     public Joueur_P get(int id);
     public List<Joueur_P> getALL();
     public int recuperer_Id_par_nom(String n);
}
