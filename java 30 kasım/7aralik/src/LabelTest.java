/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PELIN
 */

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class LabelTest
 {
 public static void main( String[] args )
 {
 LabelFrame labelFrame = new LabelFrame(); // create LabelFrame
 labelFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 labelFrame.setSize( 260, 700 ); // set frame size
 labelFrame.setVisible( true ); // display frame
 //labelFrame.setBackground(Color.yellow);
 labelFrame.setLocation(140,567);
 labelFrame.getContentPane().setBackground(Color.WHITE);
 } //labelFrame end main
 } // end class LabelTest
