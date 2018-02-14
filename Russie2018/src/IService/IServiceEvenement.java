/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Evenement;
import java.util.List;


/**
 *
 * @author hseli
 */
public interface IServiceEvenement {
    public void ajouter_Evenement(Evenement Ev);
    public List<Evenement> get_Evenement();
    public int count_Evenement();
    public Evenement get(int id);
    public int recuperer_IDMATCH(int i);
    public List<Evenement> get_Event_Par_ID(int id);
}
