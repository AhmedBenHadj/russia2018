/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.MyConnexion;
import Entite.FichePari;
import Entite.*;
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
        String req = "insert into fiche_pari(cotetotal,etat,id_user,misetotal,date,gain)Values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnexion.getInstance().prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);
       
            ps.setFloat(1,fp.getCote_total());
            ps.setString(2, fp.getEtat().Encours.toString());
            ps.setInt(3, fp.getU().getId());
            ps.setFloat(4,fp.getMisetotal());
            ps.setDate(5,fp.getDate());
            ps.setFloat(6,fp.getGain());
            ps.executeUpdate();
            ResultSet res = ps.getGeneratedKeys();
            res.first();
            fp.setId(res.getInt(1));
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
            PreparedStatement ps = MyConnexion.getInstance().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
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
    public FichePari affichertousFP(int id,int idd) {
        String req = "SELECT * FROM" +
"(SELECT equipe.nom FROM equipe,match_2018,pari,fiche_pari,user WHERE equipe.id=match_2018.id_equipe_1 and match_2018.id=pari.id_match and pari.id_fiche_pari = fiche_pari.id AND user.id=? and fiche_pari.id_user = user.id AND pari.id=?)t1" 
                +
"INNER JOIN" +
"(SELECT equipe.nom,fiche_pari.cotetotal,fiche_pari.misetotal,fiche_pari.gain,fiche_pari.date FROM equipe,match_2018,pari,fiche_pari,user WHERE equipe.id=match_2018.id_equipe_2 and match_2018.id=pari.id_match and pari.id_fiche_pari = fiche_pari.id AND user.id=? and fiche_pari.id_user = user.id AND pari.id=?)t2";
        FichePari fp = new FichePari();
        fp.setId(idd);
        List<Pari> list = new ArrayList<>();
        try {
            PreparedStatement ps = MyConnexion.getInstance().prepareStatement(req);
            ps.setInt(1, idd);
            
             ps.setInt(2, id);
              ps.setInt(3, idd);
               ps.setInt(4, id);
            ResultSet res = ps.executeQuery();
            if(res.first()){
                Pari p = new Pari();
                p.getM().getE1().setNom(res.getString(1));
                p.getM().getE2().setNom(res.getString(2));
                fp.getParis().add(p);
                
               fp.setCote_total(res.getFloat(3));
                fp.setMisetotal(res.getFloat(4));
                fp.setGain(res.getFloat(5));
                fp.setDate(res.getDate(6));
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fp;
    }
    public List<Integer> get_idPari(){
         List<Integer> liste = new ArrayList<>();
         String req = "Select id from pari";
         try{
             PreparedStatement ps = MyConnexion.getInstance().prepareStatement(req);
             ResultSet res=ps.executeQuery();
             while(res.next()){
                 liste.add(res.getInt(1));
             }
         } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
         return liste;
     }
    
    public FichePari afficherModerateur(int id){
        String req ="SELECT * FROM (SELECT equipe.nom FROM equipe,match_2018,pari,fiche_pari,user WHERE equipe.id=match_2018.id_equipe_1 and match_2018.id=pari.id_match and pari.id_fiche_pari = fiche_pari.id AND fiche_pari.id_user = user.id and pari.id=?)t1 INNER JOIN (SELECT equipe.nom,fiche_pari.cotetotal,fiche_pari.misetotal,fiche_pari.gain,fiche_pari.date,user.username FROM equipe,match_2018,pari,fiche_pari,user WHERE equipe.id=match_2018.id_equipe_2 and match_2018.id=pari.id_match and pari.id_fiche_pari = fiche_pari.id AND fiche_pari.id_user = user.id and pari.id=?)t2";
        FichePari fp = new FichePari();
        fp.setId(id);
         List<Pari> list = new ArrayList<>();
        try {
            PreparedStatement ps = MyConnexion.getInstance().prepareStatement(req);
            ps.setInt(1, id);
            
             ps.setInt(2, id);
             ResultSet res = ps.executeQuery();
                if(res.first()){
                Pari p = new Pari();
                p.getM().getE1().setNom(res.getString(1));
                p.getM().getE2().setNom(res.getString(2));
                fp.getParis().add(p);
                
               fp.setCote_total(res.getFloat(3));
                fp.setMisetotal(res.getFloat(4));
                fp.setGain(res.getFloat(5));
                fp.setDate(res.getDate(6));
                fp.getU().setUsername(res.getString(7));
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicePari.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fp;
    }


}
