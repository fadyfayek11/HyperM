/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Ahmed Kamal
 */
public class SalesGUI {

    /**
     * @param args the command line arguments */
     
    public static void main(String[] args) {
       
         JFrame sales_frame = new JFrame("Sales Gui");
       
       sales_frame.setSize(1920,1080);
       sales_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        JPanel sales_panel = new JPanel();    
        sales_frame.add(sales_panel);
        
        JLabel Sales = new JLabel("SALES");
    }
    
}
