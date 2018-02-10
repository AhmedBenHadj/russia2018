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
import Service.*;
import Entite.*;
import IService.IServiceEvenement;

/**
 *
 * @author hseli
 */
public class ServiceEvenement implements IServiceEvenement {

    @Override
    public void ajouter_Evenement(Evenement Ev) {
        String req="INSERT INTO evenement(id_match,id_joueur_participant,carton,but,temps) VALUES (?,?,?,?,?)";
       
           
           try {
               PreparedStatement ps = MyConnexion.getInstance().prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);
               ps.setInt(1,Ev.getM().getId());
 
               ps.setInt(2,Ev.getJoueur().getId());
               ps.setInt(3,Ev.getCarton());
               ps.setInt(4,Ev.getBut());
               ps.setInt(5,Ev.getTemps());
               
               int i=Ev.getId();
               ps.executeUpdate();
               ResultSet r=ps.getGeneratedKeys();
               if(r.next()){
                   Ev.setId(r.getInt(1));
               }
           } catch (SQLException ex) {
               Logger.getLogger(ServiceMatch.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    @Override
    public Evenement get(int id) {
        Evenement E = new Evenement() ;
        try{
            String req ="SELECT * FROM evenement WHERE id=?";
           PreparedStatement pst= MyConnexion.getInstance().prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                E.setId(id);
                E.setJoueur(new ServiceJoueur_P().get(res.getInt(2)));
                E.setM(new ServiceMatch().get(res.getInt(3)));
                E.setCarton(res.getInt(4));
                E.setBut(res.getInt(5));
                E.setTemps(res.getInt(6));
                
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return E;
    }

    @Override
    public List<Evenement> get_Evenement() {
        List<Evenement> l=new ArrayList<>();
       String req="SELECT * FROM evenement";
        try {
            Statement s=MyConnexion.getInstance().createStatement();
            ResultSet r=s.executeQuery(req);
            while(r.next()){
                Evenement m=new Evenement();
                m.setId(r.getInt(1));
                m.setM(new ServiceMatch().get(r.getInt(2)));
                m.setJoueur(new ServiceJoueur_P().get(r.getInt(3)));
                m.setCarton(r.getInt(4));
                m.setBut(r.getInt(5));
                m.setTemps(r.getInt(6));
                l.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
       return l;
    }

    @Override
    public int count_Evenement() {
        String req="SELECT COUNT(*) FROM evenement";
        try {
            Statement s=MyConnexion.getInstance().createStatement();
            ResultSet r=s.executeQuery(req);
            r.first();
            return r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
