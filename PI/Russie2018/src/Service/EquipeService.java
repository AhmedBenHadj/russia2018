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
public class EquipeService implements IEquipe {

    Connection cnx;
    PreparedStatement pst;

    public EquipeService() {
        cnx = MyConnexion.getInstance();
    }

    @Override
    public boolean ajouter(Equipe e) {
        if (e == null) {
            return false;
        }
        try {
            String req = "INSERT INTO equipe (id_entraineur,nom,drapeau,maillot) values(?,?,?,?)";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, e.getEntraineur().getId());
            pst.setString(2, e.getNom());
            pst.setString(3, e.getDrapeau());
            pst.setString(4, e.getMaillot());
            pst.executeUpdate();
        } catch (SQLException s) {
            System.out.println(s);
        }
        return true;
    }

    @Override
    public void modifier(int id, Entraineur Entraineur, String nom, String drapeau, String maillot) {
        try {
            String req = "UPDATE equipe SET id_entraineur=?,nom=?,drapeau=?,maillot=? WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, Entraineur.getId());
            pst.setString(2, nom);
            pst.setString(3, drapeau);
            pst.setString(4, maillot);
            pst.setInt(5, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean supprimer(Equipe e) {
        if (e == null) {
            return false;
        }
        try {
            String req = "DELETE FROM equipe WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, e.getId());
            pst.executeUpdate();
        } catch (SQLException s) {
            System.out.println(s);
        }
        return true;
    }

    @Override
    public Equipe get(int id) {
        Equipe E = new Equipe();
        try {
            String req = "SELECT * FROM equipe WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                E.setId(id);
                E.setEntraineur(new EntraineurService().get(res.getInt(2)));
                E.setNom(res.getString("nom"));
                E.setDrapeau(res.getString("drapeau"));
                E.setMaillot(res.getString("maillot"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return E;
    }

    @Override
    public List<Equipe> getALL() {
        List<Equipe> liste = new ArrayList<>();
        try {
            String req = "SELECT * FROM equipe";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Equipe E = new Equipe(res.getInt(1), new EntraineurService().get(res.getInt(2)), res.getString("nom"), res.getString("drapeau"), res.getString("maillot"));
                liste.add(E);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return liste;
    }

    @Override
    public List<Equipe> D_chercher(String nom) {
        List<Equipe> liste = new ArrayList<>();
        try {
            String req = "SELECT * FROM equipe WHERE nom LIKE '" + nom + "%'";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Equipe E = new Equipe(res.getInt(1), new EntraineurService().get(res.getInt(2)), res.getString("nom"), res.getString("drapeau"), res.getString("maillot"));
                liste.add(E);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return liste;
    }

    @Override
    public Entraineur get_Entraineur(Equipe e) {
        Entraineur entr = new Entraineur();
        try {
            String req = "SELECT * FROM entraineur WHERE id=(SELECT id_entraineur FROM Equipe WHERE id=?)";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, e.getId());
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                entr.setId(res.getInt(1));
                entr.setNom(res.getString("nom"));
                entr.setPrenom(res.getString("prenom"));
                entr.setDescription(res.getString("description"));
            }
        } catch (SQLException s) {
            System.out.println(s);
        }
        return entr;
    }

    @Override
    public List<Equipe> get_tri_selon(String champs) {
        List<Equipe> liste = new ArrayList<>();
        if (champs.equals("id") || champs.equals("nom") || champs.equals("drapeau") || champs.equals("maillot") || champs.equals("id_entraineur")) {
            try {
                String req = "SELECT * FROM equipe ORDER BY ?";
                pst = cnx.prepareStatement(req);
                pst.setString(1, champs);
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    Equipe E = new Equipe(res.getInt(1), new EntraineurService().get(res.getInt(2)), res.getString("nom"), res.getString("drapeau"), res.getString("maillot"));
                    liste.add(E);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return liste;
    }

    @Override
    public List<Joueur> get_Joueurs(Equipe e) {
        List<Joueur> liste = new ArrayList<>();
        if (e != null) {
            try {
                String req = "SELECT * FROM joueur WHERE id_equipe=?";
                pst = cnx.prepareStatement(req);
                pst.setInt(1, e.getId());
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    Joueur j = new Joueur(res.getInt(1), new EquipeService().get(res.getInt(2)), res.getString("nom"), res.getString("prenom"), res.getInt(5), res.getString("poste"), res.getInt(7), res.getString("club"));
                    liste.add(j);
                }
            } catch (SQLException s) {
                System.out.println(s);
            }
        }
        return liste;
    }

}
