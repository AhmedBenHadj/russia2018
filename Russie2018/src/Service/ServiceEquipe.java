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
public class ServiceEquipe implements IServiceEquipe {

    Connection cnx;
    PreparedStatement pst;

    public ServiceEquipe() {
        cnx = MyConnexion.getInstance();
    }

    @Override
    public boolean ajouter(Equipe e) {
        if (e == null) {
            return false;
        }
        try {
            String req = "INSERT INTO equipe (id_entraineur,nom,drapeau,maillot,progress,pts,id_groupe) values(?,?,?,?,?,?,?)";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, e.getEntraineur().getId());
            pst.setString(2, e.getNom());
            pst.setString(3, e.getDrapeau());
            pst.setString(4, e.getMaillot());
            pst.setObject(5, e.getProgress().toString());
            pst.setInt(6,0);
            pst.setInt(7, e.getGroupe().getId());
            pst.executeUpdate();
        } catch (SQLException s) {
            System.out.println(s);
        }
        return true;
    }

    @Override
    public void modifier(int id, Entraineur Entraineur, String nom, String drapeau, String maillot,Equipe.Progress progress,int pts) {
        try {
            String req = "UPDATE equipe SET id_entraineur=?,nom=?,drapeau=?,maillot=?,progress=?,pts=? WHERE id=?";
            pst = cnx.prepareStatement(req);
            pst.setInt(1, Entraineur.getId());
            pst.setString(2, nom);
            pst.setString(3, drapeau);
            pst.setString(4, maillot);
            pst.setObject(5, progress.toString());
            pst.setInt(6, pts);
            pst.setInt(7, id);
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
                E.setEntraineur(new ServiceEntraineur().get(res.getInt(2)));
                E.setNom(res.getString("nom"));
                E.setDrapeau(res.getString("drapeau"));
                E.setMaillot(res.getString("maillot"));
                E.setProgress(Equipe.Progress.valueOf(res.getString("progress")));
                E.setPts(res.getInt(7));
                E.setGroupe(new ServiceGroupe().get(res.getInt(8)));  
                //E.setListe_joueur(this.get_Joueurs(id));
                E.setListe_joueur(new ArrayList<Joueur>());
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return E;
    }
    
    public Equipe get_by_name(String nom) {
        Equipe E = new Equipe();
        try {
            String req = "SELECT * FROM equipe WHERE nom=?";
            pst = cnx.prepareStatement(req);
            pst.setString(1, nom);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                E.setId(res.getInt(1));
                E.setEntraineur(new ServiceEntraineur().get(res.getInt(2)));
                E.setNom(res.getString("nom"));
                E.setDrapeau(res.getString("drapeau"));
                E.setMaillot(res.getString("maillot"));
                E.setProgress(Equipe.Progress.valueOf(res.getString("progress")));
                E.setPts(res.getInt(7));
                E.setGroupe(new ServiceGroupe().get(res.getInt(8)));  
                //E.setListe_joueur(this.get_Joueurs(id));
                E.setListe_joueur(new ArrayList<Joueur>());
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
                Equipe E = new Equipe(res.getInt(1), new ServiceEntraineur().get(res.getInt(2)), res.getString("nom"), res.getString("drapeau"), res.getString("maillot"),this.get_Joueurs(res.getInt(1)),new ServiceGroupe().get(res.getInt(8)),res.getInt(7),Equipe.Progress.valueOf(res.getString("progress")));
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
                Equipe E = new Equipe(res.getInt(1), new ServiceEntraineur().get(res.getInt(2)), res.getString("nom"), res.getString("drapeau"), res.getString("maillot"),this.get_Joueurs(res.getInt(1)),new ServiceGroupe().get(res.getInt(8)),res.getInt(7),Equipe.Progress.valueOf(res.getString("progress")));
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
        if (champs.equals("id") || champs.equals("nom") || champs.equals("drapeau") || champs.equals("maillot") || champs.equals("id_entraineur") || champs.equals("pts") || champs.equals("progress")) {
            try {
                String req = "SELECT * FROM equipe ORDER BY ?";
                pst = cnx.prepareStatement(req);
                pst.setString(1, champs);
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    Equipe E = new Equipe(res.getInt(1), new ServiceEntraineur().get(res.getInt(2)), res.getString("nom"), res.getString("drapeau"), res.getString("maillot"),this.get_Joueurs(res.getInt(1)),new ServiceGroupe().get(res.getInt(8)),res.getInt(7),Equipe.Progress.valueOf(res.getString("progress")));
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
                    Joueur j = new Joueur(res.getInt(1), new ServiceEquipe().get(res.getInt(2)), res.getString("nom"), res.getString("prenom"), res.getInt(5), res.getString("poste"), res.getInt(7), res.getString("club"),res.getString("image"));
                    liste.add(j);
                }
            } catch (SQLException s) {
                System.out.println(s);
            }
        }
        return liste;
    }
    
    @Override
    public List<Joueur> get_Joueurs(int id) {
        List<Joueur> liste = new ArrayList<>();
            try {
                String req = "SELECT * FROM joueur WHERE id_equipe=?";
                pst = cnx.prepareStatement(req);
                pst.setInt(1, id);
                ResultSet res = pst.executeQuery();
                while (res.next()) {
                    Joueur j = new Joueur(res.getInt(1), this.get(res.getInt(2)), res.getString("nom"), res.getString("prenom"), res.getInt(5), res.getString("poste"), res.getInt(7), res.getString("club"),res.getString("image"));
                    liste.add(j);
                }
            } catch (SQLException s) {
                System.out.println(s);
            }
        
        return liste;
    }
    public List<Equipe> get_by_group(String nom_groupe) {
        List<Equipe> liste = new ArrayList<>();
        try {
            String req = "SELECT * FROM equipe WHERE id_groupe="+new ServiceGroupe().get(nom_groupe).getId();
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Equipe E = new Equipe(res.getInt(1), new ServiceEntraineur().get(res.getInt(2)), res.getString("nom"), res.getString("drapeau"), res.getString("maillot"),this.get_Joueurs(res.getInt(1)),new ServiceGroupe().get(res.getInt(8)),res.getInt(7),Equipe.Progress.valueOf(res.getString("progress")));
                liste.add(E);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return liste;
    }
    public int recuperer_Id_par_nom(String n){
        int i=0;
        try{
            String req ="SELECT id FROM equipe WHERE nom=?";
            PreparedStatement pst= cnx.prepareStatement(req);
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
