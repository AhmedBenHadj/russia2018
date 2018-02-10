/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import java.util.List;
import Entite.*;

/**
 *
 * @author hseli
 */
public interface IServiceEvenement {
    public void ajouter_Evenement(Evenement Ev);
    public List<Evenement> get_Evenement();
    public int count_Evenement();
    public Evenement get(int id);
}
