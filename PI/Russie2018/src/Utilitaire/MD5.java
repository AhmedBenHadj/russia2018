/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Ghassen
 */
public class MD5 {
    public static String generateKey(String mdp){
        String generatedKey = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(mdp.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedKey = sb.toString();
        }catch (NoSuchAlgorithmException e){}
        return generatedKey;
    }
}
