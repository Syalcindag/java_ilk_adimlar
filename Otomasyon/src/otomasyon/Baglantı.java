/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Sefa
 */
public class Baglantı {

        String host = "jdbc:derby://localhost:1527/otomasyon";
        String uName ="otomasyon";
        String uPass = "123";
        
        public Connection baglan(){
           Connection con = null;
            try {
                
                con=  DriverManager.getConnection(host, uName, uPass);
            } catch (SQLException ex) {
                Logger.getLogger(Baglantı.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;

        }
    
}
