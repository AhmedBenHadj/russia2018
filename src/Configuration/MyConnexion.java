/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skanderbejaoui
 */
public class MyConnexion {

    private static String url = "jdbc:mysql://localhost:3306/cup20181";
    private static String login = "root";
    private static String pwd = "";
    private static Connection instance = null;
    public static Connection getInstance() {
        if (instance == null) {
            try {
                instance = DriverManager.getConnection(url, login, pwd);
            } catch (SQLException ex) {
                Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }
}
