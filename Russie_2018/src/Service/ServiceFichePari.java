/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.MyConnexion;
import Entite.FichePari;
import Entite.Pari;
import Entite.USER;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skanderbejaoui
 */
public class ServiceFichePari implements IService.IServiceFichePari {

    @Override
    public void ajouterfichepari(FichePari fp) {
        String req="insert into fiche_pari(cotetotal,etat,id_user,misetotal)Values(?,?,?,?)";
        try {
            PreparedStatement ps= MyConnexion.getInstance().getConn().prepareStatement(req);
           float c=0;
            for (Pari p : fp.getParis()) {
               c+= p.getCote();
                        
            }
            float m =0;
            for (Pari p : fp.getParis()) {
               m+= p.getMise();
                        
            }
              ps.setFloat(1,c);
            ps.setString(2,fp.getEtat().Encours.toString());
            ps.setInt(3,fp.getU().getId());
            ps.setFloat(4,m);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pari> afficherfichepari(FichePari fp) {
      List<Pari> fp1 = new ArrayList<>();
      ServicePari sp = new ServicePari();
        for (Pari p : fp.getParis()) {
            fp1.add(sp.afficherPari(p.getId()));
        }
        return fp1;
    }

    @Override
    public FichePari rechercherfichepari(int id) {
         String req = "SELECT * FROM fiche_pari WHERE id=?";
        FichePari fp = new FichePari();
        try {
            PreparedStatement ps = MyConnexion.getInstance().getConn().prepareStatement(req);
            ps.setInt(1,id);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                fp.setId(res.getInt(1));
                fp.setCote_total(res.getFloat(2));
                
                fp.setEtat(FichePari.EtatFiche.valueOf(res.getString(3)));
         
               fp.getU().setId(res.getInt(4));
               fp.setMisetotal(res.getFloat(5));
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fp;
    }

    @Override
    public List<FichePari> affichertousFP(int id) {
       String req ="select * from fiche_pari where id_user=?";
       List<FichePari> fpp = new ArrayList<>();
        try {
            PreparedStatement ps = MyConnexion.getInstance().getConn().prepareStatement(req);
            ps.setInt(1,id);
            ResultSet res = ps.executeQuery();
            while(res.next()){
               FichePari fp = new FichePari();
               fp.setId(res.getInt(1));
               fp.setCote_total(res.getFloat(2));
               fp.setEtat(FichePari.EtatFiche.valueOf(res.getString(3)));
               fp.getU().setId(res.getInt(4));
              fp.setMisetotal(res.getFloat(5));
              fpp.add(fp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fpp;
    }
    
}

  
