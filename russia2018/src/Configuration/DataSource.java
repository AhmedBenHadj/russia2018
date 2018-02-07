/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eloss
 */
public class DataSource {
    
    Connection cnx = null;
    final String url = "jdbc:mysql://localhost/cup2018";
    final String user = "root";
    final String password = "";
    static DataSource instance = null;
    
    private DataSource(){
        try{
            cnx = DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static DataSource getInstance(){
        return (instance == null ? instance = new DataSource() : instance);
    }
    
    public Connection getConnexion(){
        return this.cnx;
    }
    
}
