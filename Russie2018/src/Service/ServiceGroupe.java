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
import IService.IServiceGroupe;

/**
 *
 * @author hseli
 */
public class ServiceGroupe implements IServiceGroupe {

    @Override
    public void ajouter_Groupe(Groupe G,int id_match) {
        String req="INSERT INTO groupe(nom) VALUES (?)";
       
           
           try {
               PreparedStatement ps = MyConnexion.getInstance().prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);
               ps.setString(1,G.getNom());              
               int i=G.getId();
               ps.executeUpdate();
               ResultSet r=ps.getGeneratedKeys();
               if(r.next()){
                   G.setId(r.getInt(1));
               }
           } catch (SQLException ex) {
               Logger.getLogger(ServiceGroupe.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    @Override
    public List<Groupe> get_Groupe() {
        List<Groupe> l=new ArrayList<>();
       String req="SELECT * FROM groupe";
        try {
            Statement s=MyConnexion.getInstance().createStatement();
            ResultSet r=s.executeQuery(req);
            while(r.next()){
                Groupe m=new Groupe();
                m.setId(r.getInt(1));
                m.setGM(new ServiceMatch().get_Match_Par_ID(r.getInt(1)));
                m.setNom(r.getString(2));
                l.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceGroupe.class.getName()).log(Level.SEVERE, null, ex);
        }
       return l;
    }

    @Override
    public int count_Groupe() {
         String req="SELECT COUNT(*) FROM groupe";
        try {
            Statement s=MyConnexion.getInstance().createStatement();
            ResultSet r=s.executeQuery(req);
            r.first();
            return r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceGroupe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public Groupe get(int id) {
         Groupe E = new Groupe() ;
        try{
            String req ="SELECT * FROM groupe WHERE id=?";
           PreparedStatement pst= MyConnexion.getInstance().prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                E.setId(id);
                E.setGM(new ServiceMatch().get_Match_Par_ID(id));
                E.setNom(res.getString(2));          
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return E;
    }
    
    public Groupe get(String nom) {
         Groupe E = new Groupe() ;
        try{
            String req ="SELECT * FROM groupe WHERE nom=?";
           PreparedStatement pst= MyConnexion.getInstance().prepareStatement(req);
            pst.setString(1, nom);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                E.setId(res.getInt(1));
                E.setGM(new ServiceMatch().get_Match_Par_ID(res.getInt(1)));
                E.setNom(res.getString(2));          
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return E;
    }
    
}
