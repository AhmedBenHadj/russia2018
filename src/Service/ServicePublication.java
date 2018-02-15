/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utilitaire.Utilitaire;
import Configuration.MyConnexion;
import Entite.Publication;
import IService.IServicePublication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Crud publication
 *
 * @author Ghassen
 */
public class ServicePublication implements IServicePublication {

    String REQ_CREATE = "INSERT INTO publication "
            + "(id_user,titre,date_creation,lien,description,liked,disliked,type) "
            + "VALUES (?,?,?,?,?,?,?,?)";

    String REQ_GET = "SELECT * FROM publication";
    String REQ_GET_USER = "SELECT * FROM publication WHERE id_user=?";
    String REQ_GET_TYPE = "SELECT * FROM publication WHERE type=?";

    String REQ_UPDATE = "UPDATE publication SET "
            + "titre=?,date_creation=?,lien=?,description=?,liked=?,disliked=?,type=? "
            + "WHERE id=?";

    String REQ_DELETE = "DELETE FROM publication WHERE id=?";

    String REQ_COUNT_ALL = "SELECT COUNT(*) FROM publication";
    String REQ_COUNT_TYPE = "SELECT COUNT(*) FROM publication WHERE type=?";

    /**
     * ajouter une publication
     *
     * @param e
     */
    @Override
    public void create(Publication e) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setObject(1, e.getUser().getId());
            ps.setObject(2, e.getTitre());
            ps.setObject(3, e.getDate_creation());
            ps.setObject(4, e.getLien());
            ps.setObject(5, e.getDescription());
            ps.setObject(6, e.getLiked());
            ps.setObject(7, e.getDisliked());
            ps.setObject(8, e.getType().toString());
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
     * get des publication
     *
     * @return
     */
    @Override
    public List<Publication> retrieve() {
        List<Publication> tmp = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET);
            rs = ps.executeQuery();
            while (rs.next()) {
                ServiceUser su = new ServiceUser();
                ServiceCommentaire sc = new ServiceCommentaire();
                Publication p = new Publication();
                p.setCommentaires(sc.retrieve());
                p.setId(rs.getInt(1));
                p.setUser(su.retrieveId(rs.getInt(2)));
                p.setTitre(rs.getString(3));
                p.setDate_creation(rs.getDate(4));
                p.setLien(rs.getString(5));
                p.setDescription(rs.getString(6));
                p.setLiked(rs.getInt(7));
                p.setDisliked(rs.getInt(8));
                p.setType(Publication.Type.valueOf(rs.getString(9)));
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

    /**
     * get Galerie
     *
     * @return la galerie
     */
    @Override
    public List<Publication> retrieveGalerie() {
        List<Publication> tmp = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET_TYPE);
            ps.setString(1, Publication.Type.galerie.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                ServiceUser su = new ServiceUser();
                ServiceCommentaire sc = new ServiceCommentaire();
                Publication p = new Publication();
                p.setCommentaires(sc.retrieve());
                p.setTitre(rs.getString(3));
                p.setId(rs.getInt(1));
                p.setUser(su.retrieveId(rs.getInt(2)));
                p.setDate_creation(rs.getDate(4));
                p.setLien(rs.getString(5));
                p.setDescription(rs.getString(6));
                p.setLiked(rs.getInt(7));
                p.setDisliked(rs.getInt(8));
                p.setType(Publication.Type.valueOf(rs.getString(9)));
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

    /**
     * get article
     *
     * @return les articles
     */
    @Override
    public List<Publication> retrieveArticle() {
        List<Publication> tmp = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET_TYPE);
            ps.setString(1, Publication.Type.article.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                ServiceUser su = new ServiceUser();
                ServiceCommentaire sc = new ServiceCommentaire();
                Publication p = new Publication();
                p.setCommentaires(sc.retrieve());
                p.setTitre(rs.getString(3));
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString(3));
                p.setDate_creation(rs.getDate(4));
                p.setLien(rs.getString(5));
                p.setDescription(rs.getString(6));
                p.setLiked(rs.getInt(7));
                p.setDisliked(rs.getInt(8));
                p.setType(Publication.Type.valueOf(rs.getString(9)));
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

    /**
     * modifier une publication
     *
     * @param e
     */
    @Override
    public void update(Publication e) {
        PreparedStatement ps = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_UPDATE);
            ps.setObject(1, e.getTitre());
            ps.setObject(2, e.getDate_creation());
            ps.setObject(3, e.getLien());
            ps.setObject(4, e.getDescription());
            ps.setObject(5, e.getLiked());
            ps.setObject(6, e.getDisliked());
            ps.setObject(7, e.getType().toString());
            System.out.println(e.getType().toString());
            ps.setObject(8, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utilitaire.close(ps);
        }
    }

    /**
     * supprimer une publication
     *
     * @param e
     */
    @Override
    public void delete(Publication e) {
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
     * nbr des publication
     *
     * @return
     */
    @Override
    public int count() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_COUNT_ALL);
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

    /**
     * taille de la galerie
     *
     * @return int
     */
    @Override
    public int countGalerie() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_COUNT_TYPE);
            ps.setString(1, Publication.Type.galerie.toString());
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

    /**
     * nbr des articles
     *
     * @return int
     */
    @Override
    public int countArticle() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_COUNT_TYPE);
            ps.setString(1, Publication.Type.article.toString());
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
    public List<Publication> retrieveIdUser(int id_user) {
        List<Publication> tmp = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_GET_USER);
            ps.setInt(1, id_user);
            rs = ps.executeQuery();
            while (rs.next()) {
                Publication p = new Publication();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString(3));
                p.setDate_creation(rs.getDate(4));
                p.setLien(rs.getString(5));
                p.setDescription(rs.getString(6));
                p.setLiked(rs.getInt(7));
                p.setDisliked(rs.getInt(8));
                p.setType(Publication.Type.valueOf(rs.getString(9)));
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
    public void create(Publication e, int id_user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = MyConnexion.getInstance().prepareStatement(REQ_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setObject(1, id_user);
            ps.setObject(2, e.getTitre());
            ps.setObject(3, e.getDate_creation());
            ps.setObject(4, e.getLien());
            ps.setObject(5, e.getDescription());
            ps.setObject(6, e.getLiked());
            ps.setObject(7, e.getDisliked());
            ps.setObject(8, e.getType().toString());
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
}
