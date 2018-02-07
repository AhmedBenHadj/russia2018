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
 * @author skanderbejaoui
 */
public class MyConnexion {
    private String url="jdbc:mysql://localhost:3306/cup2018";
  private String login="root";
  private String pwd="";
  private Connection conn;
  private static MyConnexion instance = null;
  private MyConnexion(){
      try{
      conn=DriverManager.getConnection(url,login, pwd);
      System.out.println("Ok");
      }catch(SQLException ex){
          System.out.println("Non");
      }
      
  }
  
  public static MyConnexion getInstance(){
      if(instance==null){
          instance = new MyConnexion();
      }
      return instance;
  }
  
  public Connection getConn(){
      return conn;
  }
}
