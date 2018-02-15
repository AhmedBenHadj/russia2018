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
public interface IServiceGroupe {
    public void ajouter_Groupe(Groupe G,int id_match);
    public List<Groupe> get_Groupe();
    public int count_Groupe();
    public Groupe get(int id);
}
