/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Configuration.MyConnexion;
import IService.*;
import Entite.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eloss
 */
public class ServiceEntraineur implements IServiceEntraineur{
    Connection cnx;
    PreparedStatement pst;
    
    public ServiceEntraineur(){
        cnx = MyConnexion.getInstance();
    }

    @Override
    public boolean ajouter(Entraineur e) {
        if(e == null)
            return false ;
        try{
            String req = "INSERT INTO entraineur (nom,prenom,description) values(?,?,?)";
            pst = cnx.prepareStatement(req);
            pst.setString(1, e.getNom());
            pst.setString(2, e.getPrenom());
            pst.setString(3,e.getDescription());
            pst.executeUpdate();           
        }catch(SQLException s){
            System.out.println(s);
        }
        return true ;
    }

    @Override
    public void modifier(int id ,String nom, String prenom, String description) {
        try{
            String req ="UPDATE entraineur SET nom=?,prenom=?,description=? WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setString(1,nom);
            pst.setString(2,prenom);
            pst.setString(3,description);
            pst.setInt(4,id);
            pst.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public boolean supprimer(Entraineur e) {
        if(e == null)
            return false ;
        try{
            String req ="DELETE FROM entraineur WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, e.getId());
            pst.executeUpdate();
        }
        catch(SQLException s){
            System.out.println(s);
        }
        return true ;
    }

    @Override
    public Entraineur get(int id) {
        Entraineur E = new Entraineur() ;
        try{
            String req ="SELECT * FROM entraineur WHERE id=?";
            pst= cnx.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                E.setId(id);
                E.setNom(res.getString("nom"));
                E.setPrenom(res.getString("prenom"));
                E.setDescription(res.getString("description"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return E;
    }

    @Override
    public List<Entraineur> getALL() {
        List<Entraineur> liste = new ArrayList<>();
        try{
            String req ="SELECT * FROM entraineur";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                Entraineur E = new Entraineur(res.getInt(1), res.getString("nom"), res.getString("prenom"), res.getString("description"));
                liste.add(E);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return liste ;
    }

    @Override
    public List<Entraineur> D_chercher(String nom) {
        List<Entraineur> liste = new ArrayList<>();
        try{
            String req="SELECT * FROM entraineur WHERE nom LIKE '"+nom+"%'";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery() ;
            while(res.next()){
                Entraineur E = new Entraineur(res.getInt(1), res.getString("nom"), res.getString("prenom"), res.getString("description"));
                liste.add(E);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return liste ;
    }

    @Override
    public List<Entraineur> get_tri_selon(String champs) {
         List<Entraineur> liste = new ArrayList<>();
        if(champs.equals("id") || champs.equals("nom") || champs.equals("prenom") || champs.equals("description")){
            try{
                String req="SELECT * FROM entraineur ORDER BY ?" ;
                pst = cnx.prepareStatement(req);
                pst.setString(1,champs);
                ResultSet res = pst.executeQuery();
                while(res.next()){
                    Entraineur E = new Entraineur(res.getInt(1), res.getString("nom"), res.getString("prenom"), res.getString("description"));
                    liste.add(E);
                }
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return liste ;
    }
}
