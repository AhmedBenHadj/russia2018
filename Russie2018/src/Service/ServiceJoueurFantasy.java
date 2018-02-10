/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.MyConnexion;
import Entite.*;
import IService.IServiceJoueurFantasy;
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
 * @author quickstrikes96
 */
public class ServiceJoueurFantasy implements IServiceJoueurFantasy {

    @Override
    public void ajouter_joueur(JoueurFantasy J, int id_equipe) {

        try {
            String query = "insert into joueur_fantasy (id_joueur , id_equipe , posteF , etat , prix , points) values(?,?,?,?,?,?)";
            PreparedStatement stm = MyConnexion.getInstance().prepareStatement(query);
            stm.setInt(1, J.getJoueur().getId());
            stm.setInt(2, id_equipe);
            stm.setInt(3, J.getPosteF());
            stm.setInt(4, J.getEtat());
            stm.setInt(5, J.getPrix());
            stm.setInt(6, J.getPoints());
            stm.executeUpdate();

            System.out.println("Joueur Fantasy ajouté correctement");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJoueurFantasy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void eliminer_joueur(JoueurFantasy J) {

        try {
            PreparedStatement prep = MyConnexion.getInstance().prepareStatement("delete from joueur_fantasy where id=?");
            prep.setInt(1, J.getId());
            prep.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJoueurFantasy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<JoueurFantasy> rechercher_joueur() {

        List<JoueurFantasy> FJoueurs = new ArrayList<>();

        try {
            Statement stm = MyConnexion.getInstance().createStatement();
            ResultSet rest
                    = stm.executeQuery("select * from joueur_fantasy where id_joueur like = ?");
            while (rest.next()) {
                JoueurFantasy J = new JoueurFantasy();
                J.setId(rest.getInt(1));
                J.getJoueur().setNom(rest.getString(2));
                J.getJoueur().setAge(rest.getInt(3));
                FJoueurs.add(J);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceJoueurFantasy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FJoueurs;
    }

    @Override
    public List<JoueurFantasy> afficher_tous() {
        List<JoueurFantasy> liste = new ArrayList<>();
        {
            try {
                String req = "SELECT * FROM joueur_fantasy";
                PreparedStatement pst = MyConnexion.getInstance().prepareStatement(req);
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    JoueurFantasy J = new JoueurFantasy(new ServiceJoueur().get(res.getInt(2)), res.getInt(3), res.getInt(4), res.getInt(5), res.getInt(6));
                    liste.add(J);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServiceJoueurFantasy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return liste;
    }

    @Override
    public void modifier(JoueurFantasy J) {
        {
            try {
                String req = "UPDATE joueur_fantasy SET id_joueur=?,posteF=?,etat=?,prix=? WHERE id=?";
                PreparedStatement pst = MyConnexion.getInstance().prepareStatement(req);
                pst.setInt(1, J.getJoueur().getId());
                pst.setInt(2, J.getPosteF());
                pst.setInt(3, J.getEtat());
                pst.setInt(4, J.getPrix());
                pst.setInt(5, J.getPoints());
                //pst.setInt(6,J.getId());
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ServiceJoueurFantasy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
