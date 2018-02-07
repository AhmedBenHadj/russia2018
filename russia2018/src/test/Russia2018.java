/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entite.User;
import Entite.abonnement;
import Entite.entraineur;
import Entite.equipe;
import Entite.joueur;
import Service.ServiceUser;
import Service.abonnementservice;
import Service.entraineurservice;
import Service.equipeservice;
import Service.joueurservice;
import java.sql.Date;
import java.sql.SQLException;
import java.time.DateTimeException;

/**
 *
 * @author eloss
 */
public class Russia2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        entraineurservice S = new entraineurservice();
        entraineur E = new entraineur("benhaj","ahmed", "dazdza");
        equipe equi = new equipe(S.get(1), "portugal", "iiiii", "llllll");
        equipeservice D = new equipeservice();
        joueurservice P = new joueurservice();
        joueur J = new joueur(D.get(2),"lilwayne", "chika",21,"droite",8, "css");
        User U = new User(1,1, new Date(2010,2,2),"ddd","fffff", "vvvv", "email", "ffff", "image", User.Role.admin, User.Connecte.ON) ;
        ServiceUser service = new ServiceUser();
        abonnement A = new abonnement(service.retrieveId(1) , P.get(2));
        abonnementservice service_abo = new abonnementservice();
        //*********ENTRAINEUR**************
        /*
        S.ajouter(E);
        S.modifier(1,"ddddd", "dddd", "ddddd");
        System.out.println(S.getALL());
        System.out.println(S.D_chercher("d"));
        System.out.println(S.get(1));
        */
        //**********EQUIPE*****************
        /*
        D.ajouter(equi);
        System.out.println(D.getALL());
        D.modifier(1, 1, "sss", "lien", "lien");
        D.supprimer(D.get(3));
        System.out.println(D.getALL());
        System.out.println(D.get(1));
        System.out.println(D.D_chercher("tu"));
        System.out.println(D.get_entraineur(D.get(1)));
        System.out.println(D.get_tri_selon("nom"));
        System.out.println(D.get_joueurs(D.get(1)));
        */
        //*********JOUEUR*******************
        
        //P.ajouter(J);
        //System.out.println(P.getALL());
        //System.out.println(P.get_entraineur(P.get(6)));
        /*
        System.out.println(P.get(3));
        System.out.println(P.getALL());
        P.modifier(2, 1, "sdds", "ddddddd", 77, "gauche",88, "css");
        P.supprimer(P.get(5));
        System.out.println(P.get_entraineur(P.get(2)));
        System.out.println(P.get_tri_selon("club"));
        */
        //****************USER***************
        /*service.create(U);
        System.out.println(service.retrieve());
        */
        //********ABONNEMENT*********
        //service_abo.ajouter(A);
        //System.out.println(service_abo.getALL());
        //System.out.println(service_abo.get_users_etleur_joueur());
        //System.out.println(service_abo.D_chercher_of_joueur("sd"));
    }   
}
