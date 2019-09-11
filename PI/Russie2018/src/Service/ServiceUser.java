/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utilitaire.Utilitaire;
import Configuration.MyConnexion;
import Entite.User;
import IService.IServiceUser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ghassen
 */
public class ServiceUser implements IServiceUser {

    String REQ_CREATE = "INSERT INTO USER "
            + "(nom,prenom,username,email,mdp,role,image,type,etat,date_creation,connecte,jeton,confirmkey) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    String REQ_GET_LIKE_USERNAME = "SELECT username FROM USER WHERE username LIKE ?";
    String REQ_GET_LIKE_EMAIL = "SELECT email FROM USER WHERE username LIKE '?%'";
    String REQ_GET = "SELECT * FROM USER";
    String REQ_GET_PAR_ID = "SELECT * FROM USER WHERE id=?";
    String REQ_GET_PAR_EMAIL = "SELECT * FROM USER WHERE email=?";
    String REQ_GET_PAR_USERNAME = "SELECT * FROM USER WHERE username=?";

    String REQ_UPDATE = "UPDATE USER SET "
            + "nom=?,prenom=?,username=?,email=?,mdp=?,role=?,image=?,type=?,etat=?,date_creation=?,connecte=?,jeton=?,confirmkey=? "
            + "WHERE id=?";
    String REQ_DELETE = "DELETE FROM USER WHERE id=?";
    String REQ_COUNT = "SELECT COUNT(*) FROM USER";

    /**
     * Ajouter un user
     *
     * @param e
     */
    @Override
    public void create(User e) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setObject(1, e.getNom());
            ps.setObject(2, e.getPrenom());
            ps.setObject(3, e.getUsername());
            ps.setObject(4, e.getEmail());
            ps.setObject(5, e.getMdp());
            ps.setObject(6, e.getRole().toString());
            ps.setObject(7, e.getImage());
            ps.setObject(8, e.getType());
            ps.setObject(9, e.getEtat());
            ps.setObject(10, e.getDate_creation());
            ps.setObject(11, e.getConnecte().toString());
            ps.setObject(11, e.getJeton());
            ps.setObject(13, e.getConfirmkey());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.first();
            e.setId(rs.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }

    }

    /**
     *
     * @return la liste des utilisateur
     */
    @Override
    public List<User> retrieve() {
        List<User> tmp = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setUsername(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setMdp(rs.getString(6));
                u.setRole(User.Role.valueOf(rs.getString(7)));
                u.setImage(rs.getString(8));
                u.setType(rs.getInt(9));
                u.setEtat(rs.getInt(10));
                u.setDate_creation(rs.getDate(11));
                u.setConnecte(User.Connecte.valueOf(rs.getString(12)));
                u.setJeton(rs.getFloat(13));
                u.setConfirmkey(rs.getString(14));
                ServiceCommentaire sc = new ServiceCommentaire();
                ServicePublication sp = new ServicePublication();
                u.setCommentaires(sc.retrieveIdUser(u.getId()));
                u.setPublications(sp.retrieveIdUser(u.getId()));
                tmp.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
        return tmp;

    }

    /**
     * get user par email
     *
     * @param email
     * @return User
     */
    @Override
    public User retrieveEmail(String email) {
        User u = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET_PAR_EMAIL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.first()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setUsername(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setMdp(rs.getString(6));
                u.setRole(User.Role.valueOf(rs.getString(7)));
                u.setImage(rs.getString(8));
                u.setType(rs.getInt(9));
                u.setEtat(rs.getInt(10));
                u.setDate_creation(rs.getDate(11));
                u.setConnecte(User.Connecte.valueOf(rs.getString(12)));
                u.setJeton(rs.getFloat(13));
                u.setConfirmkey(rs.getString(14));
                ServiceCommentaire sc = new ServiceCommentaire();
                ServicePublication sp = new ServicePublication();
                u.setCommentaires(sc.retrieveIdUser(u.getId()));
                u.setPublications(sp.retrieveIdUser(u.getId()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
        return u;
    }

    /**
     * get user par username
     *
     * @param username
     * @return User
     */
    @Override
    public User retrieveUsername(String username) {
        User u = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET_PAR_USERNAME);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.first()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setUsername(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setMdp(rs.getString(6));
                u.setRole(User.Role.valueOf(rs.getString(7)));
                u.setImage(rs.getString(8));
                u.setType(rs.getInt(9));
                u.setEtat(rs.getInt(10));
                u.setDate_creation(rs.getDate(11));
                u.setConnecte(User.Connecte.valueOf(rs.getString(12)));
                u.setJeton(rs.getFloat(13));
                u.setConfirmkey(rs.getString(14));
                ServiceCommentaire sc = new ServiceCommentaire();
                ServicePublication sp = new ServicePublication();
                u.setCommentaires(sc.retrieveIdUser(u.getId()));
                u.setPublications(sp.retrieveIdUser(u.getId()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
        return u;
    }

    /**
     * Modifier un utilisateur
     *
     * @param e
     */
    @Override
    public void update(User e) {
        PreparedStatement ps = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_UPDATE);
            ps.setObject(1, e.getNom());
            ps.setObject(2, e.getPrenom());
            ps.setObject(3, e.getUsername());
            ps.setObject(4, e.getEmail());
            ps.setObject(5, e.getMdp());
            ps.setObject(6, e.getRole().toString());
            ps.setObject(7, e.getImage());
            ps.setObject(8, e.getType());
            ps.setObject(9, e.getEtat());
            ps.setObject(10, e.getDate_creation());
            ps.setObject(11, e.getConnecte().toString());
            ps.setObject(12, e.getJeton());
            ps.setObject(13, e.getConfirmkey());
            ps.setObject(14, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
        }
    }

    /**
     * supprimer un utilisateur
     *
     * @param e
     */
    @Override
    public void delete(User e) {
        PreparedStatement ps = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_DELETE);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
        }
    }

    /**
     * nbr des utilisateur
     *
     * @return
     */
    @Override
    public int count() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_COUNT);
            rs = ps.executeQuery();
            rs.first();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
        return -1;
    }

    @Override
    public User retrieveId(int id) {
        User u = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET_PAR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.first()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setUsername(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setMdp(rs.getString(6));
                u.setRole(User.Role.valueOf(rs.getString(7)));
                u.setImage(rs.getString(8));
                u.setType(rs.getInt(9));
                u.setEtat(rs.getInt(10));
                u.setDate_creation(rs.getDate(11));
                u.setConnecte(User.Connecte.valueOf(rs.getString(12)));
                u.setJeton(rs.getFloat(13));
                u.setConfirmkey(rs.getString(14));
                ServiceCommentaire sc = new ServiceCommentaire();
                ServicePublication sp = new ServicePublication();
                u.setCommentaires(sc.retrieveIdUser(u.getId()));
                u.setPublications(sp.retrieveIdUser(u.getId()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
        return u;
    }

    @Override
    public List<String> retrieveLikeUsername(String username) {
        List<String> tmp = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET_LIKE_USERNAME);
            ps.setString(1, username+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String s = rs.getString(1);
                tmp.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
        return tmp;
    }
    
    

}
