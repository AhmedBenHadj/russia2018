/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.FichePari;
import Entite.Pari;
import java.util.List;

/**
 *
 * @author skanderbejaoui
 */
public interface IServiceFichePari {
    public void ajouterfichepari(FichePari fp);
    public List<Pari> afficherfichepari(FichePari fp);
    public FichePari rechercherfichepari(int id);
    public FichePari affichertousFP(int id,int idd);
    public List<Integer> get_idPari();
    public FichePari afficherModerateur(int id);
}
