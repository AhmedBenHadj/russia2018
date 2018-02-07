/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.*;
import Entite.User;
import IService.IServiceUser;
import java.sql.Connection;
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

    Connection cnx;
    PreparedStatement pst;
    
    public ServiceUser(){
        cnx = DataSource.getInstance().getConnexion();
    }
    String REQ_CREATE = "INSERT INTO USER "
            + "(nom,prenom,username,email,mdp,role,image,type,etat,date_creation,connecte) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    String REQ_GET = "SELECT * FROM USER";
    String REQ_GET_PAR_EMAIL = "SELECT * FROM USER WHERE email=?";
    String REQ_GET_PAR_ID = "SELECT * FROM USER WHERE id=?";
    String REQ_GET_PAR_USERNAME = "SELECT * FROM USER WHERE username=?";

    String REQ_UPDATE = "UPDATE USER SET "
            + "nom=?,prenom=?,username=?,email=?,mdp=?,role=?,image=?,type=?,etat=?,date_creation=?,connecte=? "
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
        try {
            pst = cnx.prepareStatement(REQ_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setObject(1, e.getNom());
            pst.setObject(2, e.getPrenom());
            pst.setObject(3, e.getUsername());
            pst.setObject(4, e.getEmail());
            pst.setObject(5, e.getMdp());
            pst.setObject(6, e.getRole().toString());
            pst.setObject(7, e.getImage());
            pst.setObject(8, e.getType());
            pst.setObject(9, e.getEtat());
            pst.setObject(10, e.getDate_creation());
            pst.setObject(11, e.getConnecte().toString());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            rs.first();
            e.setId(rs.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    /**
     *
     * @return la liste des utilisateur
     */
    @Override
    public List<User> retrieve() {
        List<User> tmp = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = cnx.prepareStatement(REQ_GET);
            rs = pst.executeQuery();
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
                tmp.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return tmp;

    }

    /**
     * get user par email
     *
     * @return User
     */
    @Override
    public User retrieveEmail() {
        User u = null;
        ResultSet rs = null;
        try {
            pst = cnx.prepareStatement(REQ_GET_PAR_EMAIL);
            rs = pst.executeQuery();
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return u;
    }
    public User retrieveId(int id) {
        User u = null;
        ResultSet rs = null;
        try {
            pst = cnx.prepareStatement(REQ_GET_PAR_ID);
            pst.setInt(1, id);
            rs = pst.executeQuery();
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
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
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = cnx.prepareStatement(REQ_GET_PAR_USERNAME);
            pst.setString(1, username);
            rs = pst.executeQuery();
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
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
        PreparedStatement pst = null;
        try {
            pst = cnx.prepareStatement(REQ_UPDATE);
            pst.setObject(1, e.getNom());
            pst.setObject(2, e.getPrenom());
            pst.setObject(3, e.getUsername());
            pst.setObject(4, e.getEmail());
            pst.setObject(5, e.getMdp());
            pst.setObject(6, e.getRole().toString());
            pst.setObject(7, e.getImage());
            pst.setObject(8, e.getType());
            pst.setObject(9, e.getEtat());
            pst.setObject(10, e.getDate_creation());
            pst.setObject(11, e.getConnecte().toString());
            pst.setObject(12, e.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * supprimer un utilisateur
     *
     * @param e
     */
    @Override
    public void delete(User e) {
        PreparedStatement pst =null;
        try {
            pst = cnx.prepareStatement(REQ_DELETE);
            pst.setInt(1, e.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * nbr des utilisateur
     *
     * @return
     */
    @Override
    public int count() {
        PreparedStatement pst= null;
        ResultSet rs = null;
        try {
             pst = cnx.prepareStatement(REQ_COUNT);
             rs = pst.executeQuery();
            rs.first();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
