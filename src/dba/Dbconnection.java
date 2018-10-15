package dba;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kasuni Gaveshika
 */
public class Dbconnection {
    public static Connection pmartConnection(){
    Connection con = null;
    //String dbname="pmart";
    String user = "root";
    String password="";
    String url="jdbc:mysql://localhost/pmart";
    
    try {
            Class.forName("com.mysql.jdbc.Driver");
            //String url="jdbc:mysql://localhost/pmart";
            con =DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Dbconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return con ;
    }
}
