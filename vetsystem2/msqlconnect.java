/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetsystem2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Crisp
 */
public class msqlconnect {
    Connection conn = null;
    public static Connection ConnectDb() throws SQLException{
        
            try {
                Class.forName("com.mysql.jdbc.Driver");
           
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/miniproject","root","");
            JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
             } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e);
                return null;
            }
    }
    }
     
    

