/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.Entraineur;
import Entite.Equipe;
import Entite.FichePari;
import Entite.Groupe;
import Entite.Joueur;
import Entite.Match;
import Entite.User;
import Service.ServiceEntraineur;
import Service.ServiceEquipe;
import Service.ServiceFichePari;
import Service.ServiceGroupe;
import Service.ServicePari;
import Service.ServiceUser;
import Utilitaire.MD5;
import Utilitaire.Password;
import java.math.MathContext;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ghassen
 */
public class Russie2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     //   List<Match> liste2 = new ArrayList<>();
       // Groupe G = new Groupe(liste2, "C");
        //ServiceGroupe S2 = new ServiceGroupe();
        //Entraineur E2 = new Entraineur("ahmed", "zadz", "sddsd");
        //ServiceEntraineur S = new ServiceEntraineur();
        //S.ajouter(E2);
        //ServiceEquipe S1 = new ServiceEquipe();
        //List<Joueur> liste = new ArrayList<>() ;
        //Equipe E1 = new Equipe(S.get(1), "italia", "azra9", "a7mer", liste,S2.get(1), 0);
        //System.out.println(S2.get(1));
        //S1.ajouter(E1);
        //E1.setListe_joueur(S1.get_Joueurs(E1.getId()));
        //System.out.println(S1.get(10));
        User u = new User();
        u.setId(5);
        FichePari fp = new FichePari();
        fp.setU(u);
        //System.out.println(fp.getU().getId());
        ServicePari sp = new ServicePari();
        ServiceFichePari sfp = new ServiceFichePari();
        List<Integer> listee= sfp.get_idPari();
        for (Integer integer : listee) {
            
          // fp = sfp.affichertousFP(integer);
            System.out.println(fp.getGain());
       
        }
       
        
    }

}
