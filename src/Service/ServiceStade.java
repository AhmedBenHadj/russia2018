/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entite.*;
import IService.IServiceStade;

/**
 *
 * @author hseli
 */
public class ServiceStade implements IServiceStade {

    @Override
    public void ajouter_Stade(Stade S) {
        String req = "INSERT INTO stade(nom,adresse,capacite,image) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = MyConnexion.getInstance().prepareStatement(req, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, S.getNom());
            ps.setString(2, S.getAdresse());
            ps.setInt(3, S.getCapacite());
            ps.setString(4, S.getImage());

            int i = S.getId();
            ps.executeUpdate();
            ResultSet r = ps.getGeneratedKeys();
            if (r.next()) {
                S.setId(r.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceStade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Stade> get_Stade() {
        List<Stade> l = new ArrayList<>();
        String req = "SELECT * FROM stade";
        try {
            Statement s = MyConnexion.getInstance().createStatement();
            ResultSet r = s.executeQuery(req);
            while (r.next()) {
                Stade m = new Stade();
                m.setId(r.getInt(1));
                m.setNom(r.getString(2));
                m.setAdresse(r.getString(3));
                m.setCapacite(r.getInt(4));
                m.setImage(r.getString(5));
                l.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceStade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public int count_Stade() {
        String req = "SELECT COUNT(*) FROM stade";
        try {
            Statement s = MyConnexion.getInstance().createStatement();
            ResultSet r = s.executeQuery(req);
            r.first();
            return r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceStade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public Stade get(int id) {
        Stade S = new Stade();
        try {
            String req = "SELECT * FROM stade WHERE id=?";
            PreparedStatement pst = MyConnexion.getInstance().prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                S.setId(id);
                S.setNom(res.getString(2));
                S.setAdresse(res.getString(3));
                S.setCapacite(res.getInt(4));
                S.setImage(res.getString(5));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return S;
    }

}
