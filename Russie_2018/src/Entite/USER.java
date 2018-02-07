/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skanderbejaoui
 */
public class USER {
    private int id;
    List<FichePari> ficheparis;

    public USER() {
        this.ficheparis=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FichePari> getFicheparis() {
        return ficheparis;
    }

    public void setFicheparis(List<FichePari> ficheparis) {
        this.ficheparis = ficheparis;
    }
    
    
}
