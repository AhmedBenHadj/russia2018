/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Configuration.MyConnexion;
import Entite.*;
import IService.IServiceEquipeFantasy;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quickstrikes96
 */
public class ServiceEquipeFantasy implements IServiceEquipeFantasy {

    @Override
    public void creer_equipefantasy(EquipeFantasy E) {

        try {
            String query = "insert into equipe_fantasy (id_user , nom , pointstotal , classement , valeur , banque , transfers) values(?,?,0,0,0.0,0.0,0)";
            PreparedStatement stm = MyConnexion.getInstance().prepareStatement(query);
            stm.setInt(1, E.getUser().getId());
            stm.setString(2, E.getNom());
            stm.executeUpdate();

            System.out.println("Equipe Fantasy ajoutée correctement");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJoueurFantasy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
