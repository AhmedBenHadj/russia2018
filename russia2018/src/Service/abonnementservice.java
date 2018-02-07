/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.DataSource;
import Entite.abonnement;
import Entite.joueur;
import Entite.User;
import Entite.entraineur;
import IServices.Iabonnement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eloss
 */
public class abonnementservice implements Iabonnement{
    Connection cnx;
    PreparedStatement pst;
    
    public abonnementservice(){
        cnx = DataSource.getInstance().getConnexion();
    }
    
    @Override
    public boolean ajouter(abonnement a) {
         if(a == null)
            return false ;
        try{
            String req = "INSERT INTO abonnement (id_user,id_joueur) values(?,?)";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, a.getUser().getId());
            pst.setInt(2, a.getJoueur().getId());
            pst.executeUpdate();           
        }catch(SQLException s){
            System.out.println(s);
        }
        return true ;
    }

    @Override
    public void modifier(int id,User user,joueur joueur) {
        try{
            String req ="UPDATE abonnement SET id_user=?,id_joueur=? WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1,user.getId());
            pst.setInt(2,joueur.getId());
            pst.setInt(3,id);
            pst.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public boolean supprimer(abonnement a) {
        if(a == null)
            return false ;
        try{
            String req ="DELETE FROM abonnement WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, a.getId());
            pst.executeUpdate();
        }
        catch(SQLException s){
            System.out.println(s);
        }
        return true ;
    }

    @Override
    public abonnement get(int id) {
         abonnement E = new abonnement() ;
        try{
            String req ="SELECT * FROM abonnement WHERE id=?";
            pst= cnx.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                E.setId(id);
                E.setUser(new ServiceUser().retrieveId(res.getInt(2)));
                E.setJoueur(new joueurservice().get(res.getInt(3)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return E;
    }

    @Override
    public List<abonnement> getALL() {
        List<abonnement> liste = new ArrayList<>();
        try{
            String req ="SELECT * FROM abonnement";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                abonnement E = new abonnement(res.getInt(1),new ServiceUser().retrieveId(res.getInt(2)),new joueurservice().get(res.getInt(3)));
                liste.add(E);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return liste ;
    }


    @Override
    public List<abonnement> D_chercher_of_joueur(String nom) {
        List<abonnement> liste = new ArrayList<>();
        try{
            String req="SELECT * FROM abonnement WHERE id_joueur=(SELECT id FROM joueur WHERE nom LIKE '"+nom+"%')";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery() ;
            while(res.next()){
                abonnement E = new abonnement(res.getInt(1),new ServiceUser().retrieveId(res.getInt(2)),new joueurservice().get(res.getInt(3)));
                liste.add(E);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return liste ;
    }

    @Override
    public List<joueur> get_joueurs() {
        List<joueur> liste = new ArrayList<>();
        try{
            String req ="SELECT * FROM joueur WHERE id=(SELECT id_joueur FROM abonnement)";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                joueur j = new joueur(res.getInt(1),new equipeservice().get(res.getInt(2)), res.getString("nom"), res.getString("prenom"), res.getInt(5),res.getString("poste"),res.getInt(7), res.getString("club"));
                liste.add(j);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return liste ;
    }

    @Override
    public List<User> get_users() {
        List<User> liste = new ArrayList<>();
        try{
            String req ="SELECT * FROM User WHERE id=(SELECT id_user FROM abonnement)";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                User u = null;
                u = new User();
                u.setId(res.getInt(1));
                u.setNom(res.getString(2));
                u.setPrenom(res.getString(3));
                u.setUsername(res.getString(4));
                u.setEmail(res.getString(5));
                u.setMdp(res.getString(6));
                u.setRole(User.Role.valueOf(res.getString(7)));
                u.setImage(res.getString(8));
                u.setType(res.getInt(9));
                u.setEtat(res.getInt(10));
                u.setDate_creation(res.getDate(11));
                u.setConnecte(User.Connecte.valueOf(res.getString(12)));
                liste.add(u);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return liste ;
    }

    @Override
    public Map<User, List<joueur>> get_users_etleur_joueur() {
        Map<User,List<joueur>> mymap = new HashMap<>();
        joueur aux = new joueur();
        for(User u : this.get_users()){
            List<joueur> liste = new ArrayList<>();
            try{
            String req ="SELECT * FROM joueur WHERE id=(SELECT id_joueur FROM abonnement WHERE id_user=?)";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, u.getId());
            ResultSet res = pst.executeQuery();
            while(res.next()){
                joueur j = new joueur(res.getInt(1),new equipeservice().get(res.getInt(2)), res.getString("nom"), res.getString("prenom"), res.getInt(5),res.getString("poste"),res.getInt(7), res.getString("club"));
                if(mymap.containsKey(u)){
                    mymap.get(u).add(j);
                }
                else{
                    liste.add(j);
                    mymap.put(u, liste);
                }
            }
            }catch(SQLException e){
            System.out.println(e);
            }           
        }
        return mymap;
    }
    public boolean s_abonner_a(User user ,joueur joueur){
        if(user != null && joueur != null){
            abonnement a = new abonnement(user, joueur);
            this.ajouter(a);
            return true ;
        }
        return false ;
    }
    
}
