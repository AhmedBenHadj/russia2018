/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entite.Equipe;
import Entite.FichePari;
import Entite.Match;
import Entite.Pari;
import Entite.USER;
import Service.ServiceFichePari;
import Service.ServicePari;

/**
 *
 * @author skanderbejaoui
 */
public class Russie_2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        USER u = new USER();
        u.setId(1);
        FichePari fp = new FichePari();
        Match m = new Match();
        m.setId(1);
        fp.setId(2);
      
        Pari p1 = new Pari();
        p1.setFp(fp);
        
        p1.setM(m);
        p1.setMise(53);
        Pari p2 = new Pari();
        p2.setFp(fp);
        p2.setM(m);
        Pari p3 = new Pari();
        p3.setFp(fp);
        p3.setM(m);
        Pari p4 = new Pari();
         p4.setFp(fp);
        p4.setM(m);
        Pari p5 = new Pari();
        
         p5.setFp(fp);
        p5.setM(m);
        p5.setMise(98);
        ServiceFichePari sfp = new ServiceFichePari();
        ServicePari sp = new ServicePari();
        p5.setId(17);
       
        System.out.println(p5.getId());
        sp.modifierPari(p5);
        
    }
    
}
