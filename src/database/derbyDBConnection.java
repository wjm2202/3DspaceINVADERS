/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Thi
 */
public class derbyDBConnection {
    
    static Connection myconn = null;
    private final static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private final static String jdbc_derby = "jdbc:derby:3DSpaceInvader;create=true";
    public static Connection dbconnect() {
        try {
            //1. Get a connect to the database
            Class.forName(driver);
            //myconn = DriverManager.getConnection("jdbc:derby://localhost:1527/3DSpaceInvader", "teamGlen", "glen1234");
            myconn = DriverManager.getConnection(jdbc_derby, "teamGlen", "glen1234");
            //System.out.println("Connect Successful");
            return myconn;

        } catch (Exception e) {//Catch exception if it fail to connect to Derby Database
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.out.println("Connect fail.");
            return null;
        }
    }
}
