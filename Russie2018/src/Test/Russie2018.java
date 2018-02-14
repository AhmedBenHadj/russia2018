/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.Entraineur;
import Entite.Equipe;
import Entite.Groupe;
import Entite.Joueur;
import Entite.Match;
import Entite.User;
import Service.ServiceEntraineur;
import Service.ServiceEquipe;
import Service.ServiceGroupe;
import Service.ServiceJoueur;
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
        List<Match> liste2 = new ArrayList<>();
        Groupe G = new Groupe(liste2, "C");
        ServiceGroupe S2 = new ServiceGroupe();
        Entraineur E2 = new Entraineur("ahmed", "zadz", "sddsd");
        ServiceEntraineur S = new ServiceEntraineur();
        //S.ajouter(E2);
        ServiceEquipe S1 = new ServiceEquipe();
        List<Joueur> liste = new ArrayList<>(S1.get_Joueurs(10)) ;
        Equipe E1 = new Equipe(S.get(1), "italia", "azra9", "a7mer", liste,S2.get(1), 0);
        //System.out.println(S2.get(1));
        //S1.ajouter(E1); 
        //E1.setListe_joueur(S1.get_Joueurs(E1.getId()));
        E1 = S1.get(10);
        E1.setListe_joueur(liste);
        System.out.println(E1);
        //Joueur J = new Joueur(S1.get(10),"belhaj", "ahmed", 20, "AC", 8, "css");
        ServiceJoueur Service_joueur = new ServiceJoueur();
        //Service_joueur.ajouter(J);
        //System.out.println(Service_joueur.getALL());
    }

}
