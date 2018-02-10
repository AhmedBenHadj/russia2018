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
 * @author quickstrikes96
 */
public interface IServiceJoueurFantasy {
    
    public void ajouter_joueur(JoueurFantasy J,int id_equipe);
    public void eliminer_joueur(JoueurFantasy J);
    public List<JoueurFantasy> rechercher_joueur();
    public List<JoueurFantasy> afficher_tous();
    public void modifier(JoueurFantasy J);

    
    
}
