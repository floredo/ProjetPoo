/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author vinc
 */
import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnexion {
    public static final String username ="vicsantos";
    public static final String password ="vicsantos";
     public static final String url ="jdbc:mysql://localhost:3306/gestion_article";
     private static Connection connection;
     
     private DatabaseConnexion(){
         try {
             Class.forName("com.mysql.jdbc.Driver");
            connection =DriverManager.getConnection(url ,username,password);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
    public static Connection getConnection() {
        if (connection ==null){
            new DatabaseConnexion();
        }
        return connection;
    }
}
