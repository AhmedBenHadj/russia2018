/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

/**
 *
 * @author Ghassen
 */
public class Password {

    public static String hashPassword(String mdp) {
        String salt = BCrypt.gensalt(12);
        String hashed_mdp = BCrypt.hashpw(mdp, salt);
        return hashed_mdp;
    }

    public static boolean checkPassword(String mdp, String hashed_mdp) {
        boolean flag = false;

        if (null == hashed_mdp || !hashed_mdp.startsWith("$2a$")) {
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }

        flag = BCrypt.checkpw(mdp, hashed_mdp);

        return flag;
    }
}
