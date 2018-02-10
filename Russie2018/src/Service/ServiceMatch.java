/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.MyConnexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entite.*;
import IService.IServiceMatch;

/**
 *
 * @author hseli
 */
public class ServiceMatch implements IServiceMatch {

    @Override
    public void ajouter_Match(Match M) {
        String req="INSERT INTO match_2018(id_groupe,id_equipe_1,id_equipe_2,id_stade,date,score,etat,duree,nombre_spectateur) VALUES (?,?,?,?,?,?,?,?,?)";
       
           
           try {
               PreparedStatement ps = MyConnexion.getInstance().prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);
               ps.setInt(1,M.getG().getId());
               ps.setInt(2,M.getE1().getId());
               ps.setInt(3,M.getE2().getId());
               ps.setInt(4,M.getS().getId());
               ps.setTimestamp(5,M.getDate());
               ps.setInt(9,M.getNombre_spectateur());
               ps.setInt(8,M.getDuree());
               ps.setString(6,M.getScore());
               ps.setString(7,M.getEtat().name());
               int i=M.getId();
               ps.executeUpdate();
               ResultSet r=ps.getGeneratedKeys();
               if(r.next()){
                   M.setId(r.getInt(1));
               }
           } catch (SQLException ex) {
               Logger.getLogger(ServiceMatch.class.getName()).log(Level.SEVERE, null, ex);
           }
    }


    @Override
    public void modifier_Match(Match M) {
         String req="UPDATE match_2018 SET id_groupe=?,id_equipe_1=?,id_equipe_2=?,id_stade=?,date=?,score=?,etat=?,duree=?,nombre_spectateur=? WHERE id=? ";
        try {
            PreparedStatement ps= MyConnexion.getInstance().prepareStatement(req);
            ps.setInt(1,M.getG().getId());
            ps.setInt(2,M.getE1().getId());
            ps.setInt(3,M.getE2().getId());
            ps.setInt(4,M.getS().getId());
            ps.setTimestamp(5,M.getDate());
            ps.setString(6,M.getScore());
            ps.setString(7,M.getEtat().name());
            ps.setInt(8,M.getDuree());
            ps.setInt(9,M.getNombre_spectateur());
            ps.setInt(10,M.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Match> get_Match() {
        List<Match> l=new ArrayList<>();
       String req="SELECT * FROM match_2018";
        try {
            Statement s=MyConnexion.getInstance().createStatement();
            ResultSet r=s.executeQuery(req);
            while(r.next()){
                Match m=new Match();
                m.setId(r.getInt(1));
                m.setG(new ServiceGroupe().get(r.getInt(2)));
                m.setE1(new ServiceEquipe().get(r.getInt(3)));
                m.setE2(new ServiceEquipe().get(r.getInt(4)));
                m.setS(new ServiceStade().get(r.getInt(5)));
                m.setDate(r.getTimestamp(6));
                m.setScore(r.getString(7));
                m.setEtat(Match.EtatMatch.valueOf(r.getString(8)));
                m.setDuree(r.getInt(9));
                m.setNombre_spectateur(r.getInt(10));
                l.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
       return l;
    }

    @Override
    public int count_Match() {
        String req="SELECT COUNT(*) FROM match_2018";
        try {
            Statement s=MyConnexion.getInstance().createStatement();
            ResultSet r=s.executeQuery(req);
            r.first();
            return r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public Match get(int id) {
        Match E = new Match() ;
        try{
            String req ="SELECT * FROM match_2018 WHERE id=?";
            PreparedStatement pst= MyConnexion.getInstance().prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                E.setId(id);
                E.setG(new ServiceGroupe().get(res.getInt(2)));
                E.setE1(new ServiceEquipe().get(res.getInt(3)));
                E.setE2(new ServiceEquipe().get(res.getInt(4)));
                E.setS(new ServiceStade().get(res.getInt(5)));
                E.setDate(res.getTimestamp(6));
                E.setScore(res.getString(7));
                E.setEtat(Match.EtatMatch.valueOf(res.getString(8)));
                E.setDuree(res.getInt(9));
                E.setNombre_spectateur(10);
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return E;
    }

    @Override
    public List<Match> get_Match_Par_ID(int id) {
        List<Match> l=new ArrayList<>();
       String req="SELECT * FROM match_2018 WHERE id_groupe=?";
        try {
            PreparedStatement pst= MyConnexion.getInstance().prepareStatement(req);
            pst.setInt(1, id);
            ResultSet r = pst.executeQuery();
            while(r.next()){
                Match m=new Match();
                m.setId(id);
                m.setG(new ServiceGroupe().get(r.getInt(2)));
                m.setE1(new ServiceEquipe().get(r.getInt(3)));
                m.setE2(new ServiceEquipe().get(r.getInt(4)));
                m.setS(new ServiceStade().get(r.getInt(5)));
                m.setDate(r.getTimestamp(6));
                m.setScore(r.getString(7));
                m.setEtat(Match.EtatMatch.valueOf(r.getString(8)));
                m.setDuree(r.getInt(9));
                m.setNombre_spectateur(r.getInt(10));
                l.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
       return l;
    }
    
}
