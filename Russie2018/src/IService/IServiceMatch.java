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
public interface IServiceMatch {
    
    public void ajouter_Match(Match M);
    public void modifier_Match(Match M);
    public Match get(int id);
    public List<Match> get_Match();
    public int count_Match();
    public List<Match> get_Match_Par_ID(int id);
    
}
