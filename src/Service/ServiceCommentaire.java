/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Configuration.MyConnexion;
import Utilitaire.Utilitaire;
import Entite.Commentaire;
import IService.IServiceCommentaire;
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
public class ServiceCommentaire implements IServiceCommentaire {

    String REQ_CREATE = "INSERT INTO commentaire "
            + "(id_publication,description,id_user,date_creation) "
            + "VALUES (?,?,?,?)";
    String REQ_GET = "SELECT * FROM commentaire";
    String REQ_GET_USER = "SELECT * FROM commentaire WHERE id_user=?";
    String REQ_GET_PUBLICATION="SELECT * FROM commentaire WHERE id_publication=?";
    String REQ_COUNT = "SELECT COUNT(*) FROM commentaire";
    String REQ_UPDATE = "UPDATE commentaire SET "
            + "description=?,date_creation=? "
            + "WHERE id=?";
    String REQ_DELETE = "DELETE FROM commentaire WHERE id=?";

    @Override
    public void create(Commentaire e, int id_publication, int id_user) {
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setObject(1, id_publication);
            ps.setObject(2, e.getDescription());
            ps.setObject(3, id_user);
            ps.setObject(4, e.getDate_creation());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.first();
            e.setId(rs.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
    }

    @Override
    public List<Commentaire> retrieve() {
        List<Commentaire> tmp = new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET);
            rs = ps.executeQuery();
            while (rs.next()) {
                Commentaire p = new Commentaire();
                p.setId(rs.getInt(1));
                p.setDescription(rs.getString(3));
                p.setDate_creation(rs.getDate(5));
                tmp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
        return tmp;
    }

    @Override
    public void update(Commentaire e) {
        PreparedStatement ps =null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_UPDATE);
            ps.setObject(1, e.getDescription());
            ps.setObject(2, e.getDate_creation());
            ps.setObject(3, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
        }
    }

    @Override
    public void delete(Commentaire e) {
        PreparedStatement ps=null ;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_DELETE);
            System.out.println(e.getId());
            ps.setInt(1, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
        }
    }

    /*@Override
    public Commentaire retrievePublication(int id_publication) {
        Commentaire p= null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET);
            rs = ps.executeQuery();
            if (rs.first()) {
                p = new Commentaire();
                p.setId(rs.getInt(1));
                p.setDescription(rs.getString(3));
                p.setDate_creation(rs.getDate(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
        return p;
    }*/

    @Override
    public List<Commentaire> retrieveIdUser(int id_user) {
        List<Commentaire> tmp = new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET_USER);
            ps.setInt(1, id_user);
            rs = ps.executeQuery();
            while (rs.next()) {
                Commentaire p = new Commentaire();
                p.setId(rs.getInt(1));
                p.setDescription(rs.getString(3));
                p.setDate_creation(rs.getDate(5));
                tmp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
        return tmp;
    }

    @Override
    public List<Commentaire> retrieve(int id_publication) {
        List<Commentaire> tmp = new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET_PUBLICATION);
            ps.setInt(1, id_publication);
            rs = ps.executeQuery();
            while (rs.next()) {
                Commentaire p = new Commentaire();
                p.setId(rs.getInt(1));
                p.setDescription(rs.getString(3));
                p.setDate_creation(rs.getDate(5));
                tmp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
            Utilitaire.close(rs);
        }
        return tmp;
    }

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

}
