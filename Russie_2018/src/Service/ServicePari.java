/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.MyConnexion;
import Entite.Equipe;
import Entite.Pari;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skanderbejaoui
 */
public class ServicePari implements IService.IServicePari {

    String reqe="Select * from "
            + "(SELECT equipe.nom from equipe,match_2018,pari where equipe.id=match_2018.id_equipe_1 and match_2018.id=pari.id_match and pari.id =?) t1"
            + "INNER JOIN "
            + "(SELECT equipe.nom,pari.cote,pari.mise from equipe,match_2018,pari where equipe.id=match_2018.id_equipe_2 and match_2018.id=pari.id_match and pari.id =?) t2";
    @Override
    public void ajouterPari(Pari p) {
        String req="insert into pari(id_match,cote,id_fiche_pari,mise)Values(?,?,?,?)";
        try {
            PreparedStatement ps= MyConnexion.getInstance().getConn().prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,p.getM().getId());
            ps.setFloat(2,p.getCote());
            ps.setInt(3,p.getFp().getId());
            ps.setFloat(4, p.getMise());
            ps.executeUpdate();
            ResultSet res = ps.getGeneratedKeys();
            res.first();
            p.setId(res.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void annulerPari(Pari p) {
        String req ="delete from pari where id = ?";
        try{
            PreparedStatement ps= MyConnexion.getInstance().getConn().prepareStatement(req);
            ps.setInt(1,p.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierPari(Pari p) {
       String req ="update pari set mise =? where id= ?";
        try{
            PreparedStatement ps= MyConnexion.getInstance().getConn().prepareStatement(req);
            ps.setFloat(1,p.getMise());
            ps.setInt(2,p.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Pari afficherPari(int id){
        Pari p = new Pari();
        
        try {
            PreparedStatement ps = MyConnexion.getInstance().getConn().prepareStatement(reqe);
            ps.setInt(1,id);
            ps.setInt(2,id);
            ResultSet res = ps.executeQuery();
            if(res.first()){
                p.getM().getE1().setNom(res.getString(1));
                
                p.getM().getE2().setNom(res.getString(2));
                p.setCote(res.getFloat(3));
               
                p.setMise(res.getFloat(4));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }

    @Override
    public Pari rechercherPari(int id) {
        String req = "SELECT * FROM pari WHERE id=?";
        Pari p = new Pari();
        try {
            PreparedStatement ps = MyConnexion.getInstance().getConn().prepareStatement(req);
            ps.setInt(1,id);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                p.setId(res.getInt(1));
                p.getM().setId(2);
                
                p.setCote(res.getFloat(3));
         
               p.getFp().setId(res.getInt(4));
                p.setMise(res.getFloat(5));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    
    


    
}
