/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Utilitaire.MD5;
import Utilitaire.Password;

/**
 *
 * @author Ghassen
 */
public class Russie2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ServiceUser su = new ServiceUser();
        //System.out.println(User.generateUsernameSuggestions("ghassen"));

        String mdp ="a";
        String hashed_mdp= Password.hashPassword(mdp);
        System.out.println(hashed_mdp);
        
        //System.out.println(Password.checkPassword("ghassen", hashed_mdp));
        //User u = su.retrieveUsername("gh");
        //System.out.println(u);
        //System.out.println(su.retrieveLikeUsername("gh"));
        //User.generateUsernameSuggestions("ghassen");
        /*for (Commentaire arg : sc.retrieve()) {
            System.out.println(arg.toString());
        }*/
        //System.out.println(sc.retrieve());
        String t = "a";
        System.out.println(MD5.generateKey(t));
    }

}
