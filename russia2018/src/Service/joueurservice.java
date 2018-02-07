/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.DataSource;
import Entite.entraineur;
import Entite.equipe;
import Entite.joueur;
import IServices.Ijoueur;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eloss
 */
public class joueurservice implements Ijoueur{
    Connection cnx;
    PreparedStatement pst;
    
    public joueurservice(){
        cnx = DataSource.getInstance().getConnexion();
    }
    
    @Override
    public boolean ajouter(joueur j) {
        if(j == null)
            return false ;
        try{
            String req = "INSERT INTO joueur (id_equipe,nom,prenom,age,poste,numero,club) values(?,?,?,?,?,?,?)";
            pst = cnx.prepareStatement(req);
            pst.setInt(1,j.getEquipe().getId());
            pst.setString(2, j.getNom());
            pst.setString(3, j.getPrenom());
            pst.setInt(4,j.getAge());
            pst.setString(5, j.getPoste());
            pst.setInt(6,j.getNumero());
            pst.setString(7, j.getClub());
            pst.executeUpdate();           
        }catch(SQLException s){
            System.out.println(s);
        }
        return true ;
    }

    @Override
    public void modifier(int id,equipe equipe, String nom, String prenom, int age, String poste, int numero, String club) {
        try{
            String req ="UPDATE joueur SET id_equipe=?,nom=?,prenom=?,age=?,poste=?,numero=?,club=? WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1,equipe.getId());
            pst.setString(2,nom);
            pst.setString(3,prenom);
            pst.setInt(4,age);
            pst.setString(5,poste);
            pst.setInt(6, numero);
            pst.setString(7,club);
            pst.setInt(8,id);
            pst.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public boolean supprimer(joueur j) {
        if(j == null)
            return false ;
        try{
            String req ="DELETE FROM joueur WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, j.getId());
            pst.executeUpdate();
        }
        catch(SQLException s){
            System.out.println(s);
        }
        return true ;
    }

    @Override
    public joueur get(int id) {
         joueur E = new joueur() ;
        try{
            String req ="SELECT * FROM joueur WHERE id=?";
            pst= cnx.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                E.setId(id);
                E.setEquipe(new equipeservice().get(res.getInt(2)));
                E.setNom(res.getString("nom"));
                E.setPrenom(res.getString("prenom"));
                E.setAge(res.getInt(5));
                E.setPoste(res.getString("poste"));
                E.setNumero(res.getInt(7));
                E.setClub(res.getString("club"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return E;
    }

    @Override
    public List<joueur> getALL() {
        List<joueur> liste = new ArrayList<>();
        try{
            String req ="SELECT * FROM joueur";
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
    public List<joueur> D_chercher(String nom) {
        List<joueur> liste = new ArrayList<>();
        try{
            String req="SELECT * FROM joueur WHERE nom LIKE '"+nom+"%'";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery() ;
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
    public equipe get_equipe(joueur j) {
        equipe eq = new equipe();
        try{           
            String req = "SELECT * FROM equipe WHERE id=(SELECT id_equipe FROM joueur WHERE id=?)";
            pst = cnx.prepareStatement(req);
            pst.setInt(1,j.getId());
            ResultSet res = pst.executeQuery() ;
            while(res.next()){
                eq.setId(res.getInt(1));
                eq.setEntraineur(new entraineurservice().get(res.getInt(2)));                
                eq.setNom(res.getString("nom"));
                eq.setDrapeau(res.getString("drapeau"));
                eq.setMaillot(res.getString("maillot"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return eq ;
    }

    @Override
    public entraineur get_entraineur(joueur j) {
        equipeservice D = new equipeservice() ;
        return D.get_entraineur(this.get_equipe(j));
    }

    @Override
    public List<joueur> get_tri_selon(String champs) {
         List<joueur> liste = new ArrayList<>();
        if(champs.equals("id") || champs.equals("id_equipe") || champs.equals("nom") || champs.equals("prenom") || champs.equals("age") || champs.equals("poste") || champs.equals("numero") || champs.equals("club")){
            try{
                String req="SELECT * FROM joueur ORDER BY ?" ;
                pst = cnx.prepareStatement(req);
                pst.setString(1,champs);
                ResultSet res = pst.executeQuery();
                while(res.next()){
                    joueur j = new joueur(res.getInt(1),new equipeservice().get(res.getInt(2)), res.getString("nom"), res.getString("prenom"), res.getInt(5),res.getString("poste"),res.getInt(7), res.getString("club"));
                    liste.add(j);
                }
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return liste ;
    }
    
}
