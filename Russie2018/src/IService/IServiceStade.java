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
public interface IServiceStade {
    
    public void ajouter_Stade(Stade S);
    public List<Stade> get_Stade();
    public int count_Stade();
    public Stade get(int id);
}
