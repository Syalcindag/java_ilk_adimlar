/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sefa
 */
public class SınavProgramı extends Dersler implements Menü, Tarih{
    
    String host = "jdbc:derby://localhost:1527/admin";
    String uName = "abc";
    String uPass = "abc";
    
    Scanner scan = new Scanner(System.in);
    int ay, gun;
    public void sınavProgramı() {
           try {
            System.out.println("*********************************");
            Connection conn = null;
            
            try {
                conn = DriverManager.getConnection(host, uName, uPass);
            } catch (SQLException ex) {
                Logger.getLogger(SınavProgramı.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String sql = "SELECT * FROM ABC.sınavprogramı";
            
            Statement sttm =conn.createStatement();
            ResultSet rs =sttm.executeQuery(sql);
            rs.next();
            String ders1 = rs.getString(1);
            String ders2 = rs.getString(2);
            String ders3 = rs.getString(3);
            String ders4 = rs.getString(4);
            String ders5 = rs.getString(5);

            
         
            System.out.println("pazartesi : "+ ders1);
            System.out.println("salı : "+ ders2);
            System.out.println("çarşamba : "+ ders3);
            System.out.println("perşembe : "+ ders4);
            System.out.println("cuma : "+ ders5);

            
        } catch (SQLException ex) {
            Logger.getLogger(SınavProgramı.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public String secim(){
    
      int secim =scan.nextInt();
         switch (secim) {
             case 1:
                 return "lojik";
                 
             case 2:
                 return "Devreler ";
                 
             case 3:
                 return "Veri ";
                 
             case 4:
                 return "Nesneye";
                 
             case 5:
                 return "Olasılık";
                 
             default:
                 
                 return null;
         }
}

    public void sınavProgamOlustur(String d1,String d2, String d3, String d4,String d5){
       
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException ex) {
            Logger.getLogger(SınavProgramı.class.getName()).log(Level.SEVERE, null, ex);
        }


        String sql ="INSERT INTO abc.sınavprogramı(pazartesi, salı, çarşamba, perşembe, cuma)VALUES(?, ?, ?, ?, ?)";

         PreparedStatement ps ;
         try {
             ps = conn.prepareStatement(sql);
             ps.setString(1, d1);
             ps.setString(2, d2);
             ps.setString(3, d3);
             ps.setString(4, d4);
             ps.setString(5, d5);
             
              int sonuc;
               sonuc = ps.executeUpdate();
              if(sonuc > 0)
             {
                 System.out.println("ders eklendi");
             }
         
           
             
         } catch (SQLException ex) {
             Logger.getLogger(SınavProgramı.class.getName()).log(Level.SEVERE, null, ex);
         }
          
            
            
                
            
       
    }

    @Override
    public void menü() {
        String d1, d2, d3, d4, d5;
          dersler();
          System.out.println("Pazartesi'ye eklenenecek ders seçiniz");
          d1 = secim();
          dersler();
          System.out.println("Salı ya eklenecek ders seçiniz");
          d2 = secim();
          dersler();
          System.out.println("Çarşamba ya eklenecek ders seçiniz");
          d3 = secim();
          dersler();
          System.out.println("Perşembe ye eklenecek ders seçiniz");
          d4 = secim();
          dersler();
          System.out.println("Cuma ya eklenecek ders seçiniz");
          d5 = secim();
          
          sınavProgamOlustur(d1, d2, d3, d4, d5);
          tarihOlustur();
          
    }

    @Override
    public void tarihOlustur() {
        System.out.println("Sınav tarihlrini belirleyiniz");
        System.out.println("[ 1 ] ay\n"
                + "[ 2 ] gün");
        System.out.println("kacıncı ay olacagını giriniz");
         ay = scan.nextInt();
        System.out.println("Ayın kacında olacagını giriniz");
        gun = scan.nextInt();
       
        
    }
    public void sınavTarihi(){
        System.out.println("Sınav " + ay + "." + " ayın " + gun + " de");
    }
    
    
}
