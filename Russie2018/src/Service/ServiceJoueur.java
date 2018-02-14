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
public class ServiceJoueur implements IServiceJoueur {

    Connection cnx;
    PreparedStatement pst;

    public ServiceJoueur() {
        cnx = MyConnexion.getInstance();
    }

    @Override
    public boolean ajouter(Joueur j) {
        if (j == null) {
            return false;
        }
        try {
            String req = "INSERT INTO joueur (id_equipe,nom,prenom,age,poste,numero,club,image) values(?,?,?,?,?,?,?,?)";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, j.getEquipe().getId());
            pst.setString(2, j.getNom());
            pst.setString(3, j.getPrenom());
            pst.setInt(4, j.getAge());
            pst.setString(5, j.getPoste());
            pst.setInt(6, j.getNumero());
            pst.setString(7, j.getClub());
            pst.setString(8,j.getImage());
            pst.executeUpdate();
        } catch (SQLException s) {
            System.out.println(s);
        }
        return true;
    }

    @Override
    public void modifier(int id, Equipe Equipe, String nom, String prenom, int age, String poste, int numero, String club,String image) {
        try {
            String req = "UPDATE joueur SET id_equipe=?,nom=?,prenom=?,age=?,poste=?,numero=?,club=?,image=? WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, Equipe.getId());
            pst.setString(2, nom);
            pst.setString(3, prenom);
            pst.setInt(4, age);
            pst.setString(5, poste);
            pst.setInt(6, numero);
            pst.setString(7, club);
            pst.setString(8,image);
            pst.setInt(9, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean supprimer(Joueur j) {
        if (j == null) {
            return false;
        }
        try {
            String req = "DELETE FROM joueur WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, j.getId());
            pst.executeUpdate();
        } catch (SQLException s) {
            System.out.println(s);
        }
        return true;
    }

    @Override
    public Joueur get(int id) {
        Joueur E = new Joueur();
        try {
            String req = "SELECT * FROM joueur WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                E.setId(id);
                E.setEquipe(new ServiceEquipe().get(res.getInt(2)));
                E.setNom(res.getString("nom"));
                E.setPrenom(res.getString("prenom"));
                E.setAge(res.getInt(5));
                E.setPoste(res.getString("poste"));
                E.setNumero(res.getInt(7));
                E.setClub(res.getString("club"));
                E.setImage(res.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return E;
    }
    public Joueur get(String nom) {
        Joueur E = new Joueur();
        try {
            String req = "SELECT * FROM joueur WHERE nom=?";
            pst = cnx.prepareStatement(req);
            pst.setString(1, nom);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                E.setId(res.getInt(1));
                E.setEquipe(new ServiceEquipe().get(res.getInt(2)));
                E.setNom(res.getString("nom"));
                E.setPrenom(res.getString("prenom"));
                E.setAge(res.getInt(5));
                E.setPoste(res.getString("poste"));
                E.setNumero(res.getInt(7));
                E.setClub(res.getString("club"));
                E.setImage(res.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return E;
    }

    @Override
    public List<Joueur> getALL() {
        List<Joueur> liste = new ArrayList<>();
        try {
            String req = "SELECT * FROM joueur";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Joueur j = new Joueur(res.getInt(1), new ServiceEquipe().get(res.getInt(2)), res.getString("nom"), res.getString("prenom"), res.getInt(5), res.getString("poste"), res.getInt(7), res.getString("club"),res.getString("image"));
                liste.add(j);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return liste;
    }

    @Override
    public List<Joueur> D_chercher(String nom) {
        List<Joueur> liste = new ArrayList<>();
        try {
            String req = "SELECT * FROM joueur WHERE nom LIKE '" + nom + "%'";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Joueur j = new Joueur(res.getInt(1), new ServiceEquipe().get(res.getInt(2)), res.getString("nom"), res.getString("prenom"), res.getInt(5), res.getString("poste"), res.getInt(7), res.getString("club"),res.getString("image"));
                liste.add(j);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return liste;
    }

    @Override
    public Equipe get_Equipe(Joueur j) {
        Equipe eq = new Equipe();
        try {
            String req = "SELECT * FROM equipe WHERE id=(SELECT id_equipe FROM joueur WHERE id=?)";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, j.getId());
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                eq.setId(res.getInt(1));
                eq.setEntraineur(new ServiceEntraineur().get(res.getInt(2)));
                eq.setNom(res.getString("nom"));
                eq.setDrapeau(res.getString("drapeau"));
                eq.setMaillot(res.getString("maillot"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return eq;
    }

    @Override
    public Entraineur get_Entraineur(Joueur j) {
        ServiceEquipe D = new ServiceEquipe();
        return D.get_Entraineur(this.get_Equipe(j));
    }

    @Override
    public List<Joueur> get_tri_selon(String champs) {
        List<Joueur> liste = new ArrayList<>();
        if (champs.equals("id") || champs.equals("id_equipe") || champs.equals("nom") || champs.equals("prenom") || champs.equals("age") || champs.equals("poste") || champs.equals("numero") || champs.equals("club")) {
            try {
                String req = "SELECT * FROM joueur ORDER BY ?";
                pst = cnx.prepareStatement(req);
                pst.setString(1, champs);
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    Joueur j = new Joueur(res.getInt(1), new ServiceEquipe().get(res.getInt(2)), res.getString("nom"), res.getString("prenom"), res.getInt(5), res.getString("poste"), res.getInt(7), res.getString("club"),res.getString("image"));
                    liste.add(j);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return liste;
    }

}
