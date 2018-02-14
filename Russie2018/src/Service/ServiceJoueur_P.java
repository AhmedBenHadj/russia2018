/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.MyConnexion;
import Entite.Joueur_P;
import IService.IServiceJoueur_P;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author hseli
 */
public class ServiceJoueur_P implements IServiceJoueur_P {

    @Override
    public void ajouter_JoueurP(Joueur_P JP) {
        String req="INSERT INTO joueur_participant(id_joueur,temps_joue) VALUES (?,?)";
       
           
           try {
               PreparedStatement ps = MyConnexion.getInstance().prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);
               ps.setInt(1,JP.getJ().getId());
               ps.setInt(2,JP.getTemps_joue());
               
               int i=JP.getId();
               ps.executeUpdate();
               ResultSet r=ps.getGeneratedKeys();
               if(r.next()){
                   JP.setId(r.getInt(1));
               }
           } catch (SQLException ex) {
               Logger.getLogger(ServiceJoueur_P.class.getName()).log(Level.SEVERE, null, ex);
           }
    }

    @Override
    public Joueur_P get(int id) {
          Joueur_P S = new Joueur_P() ;
        try{
            String req ="SELECT * FROM joueur_participant WHERE id=?";
           PreparedStatement pst= MyConnexion.getInstance().prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                S.setId(id);
                S.setJ(new ServiceJoueur().get(res.getInt(2)));
                S.setTemps_joue(res.getInt(3));
                
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return S;
    }

    @Override
    public List<Joueur_P> getALL() {
        List<Joueur_P> liste = new ArrayList<>();
        try{
            String req ="SELECT * FROM joueur_participant";
            PreparedStatement pst= MyConnexion.getInstance().prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                Joueur_P E = new Joueur_P(res.getInt(1),new ServiceJoueur().get(res.getInt(2)), res.getInt(3));
                liste.add(E);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return liste ;
    }

    @Override
    public int count_Joueur_P() {
        String req="SELECT COUNT(*) FROM joueur_participant";
        try {
            Statement s=MyConnexion.getInstance().createStatement();
            ResultSet r=s.executeQuery(req);
            r.first();
            return r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJoueur_P.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    @Override
     public int recuperer_Id_par_nom(String n){
        int i=0;
        try{
            String req ="SELECT joueur_participant.id FROM joueur_participant INNER JOIN joueur ON joueur.id=joueur_participant.id_joueur WHERE nom=?";
            PreparedStatement pst= MyConnexion.getInstance().prepareStatement(req);
            pst.setString(1, n);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                i=res.getInt(1);
       
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return i;
    }
    
    
    
}
