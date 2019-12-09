/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author marti
 */
public class SalesGUI extends JFrame {
   JPanel jp=new JPanel();
   JButton b1;
   JButton b2;
   JButton b3;
   JButton b4;
   JLabel l1;
   JTextField t1;
   JTextField t2;
   JTextField t3;
   JTable T;
    public SalesGUI(){
        setTitle("SALES");
        setSize(1650, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

           setContentPane(new JLabel(new ImageIcon("IMG-20191201-WA0008.png")));
           setLayout(new FlowLayout());
          
           
           l1=new JLabel("Sales");  
           Font f=new Font("TimesRoman",Font.BOLD,80);
           l1.setForeground(Color.white);
           l1.setFont(f);
           add(l1);
           setSize(388, 388);
           
           setSize(1650,750);
           
           
           
           b1=new  JButton("order");
           Font f1=new Font("TimesRoman",Font.CENTER_BASELINE,20);
           b1.setFont(f1);
           b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sales sp=new Sales();
                try {
                    sp.MadeOrder(t1.getText(),Integer.parseInt(t2.getText()));
                } catch (IOException ex) {
                    Logger.getLogger(SalesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           });
           b1.setPreferredSize(new Dimension(130, 30) );
           add(b1);
            
           
             
            t1=new JTextField("Product Name");
            Font f2=new Font("TimesRoman",Font.PLAIN,15);
           t1.setFont(f2);
           t1.setPreferredSize(new Dimension(150, 30) );
           add(t1);
           

            t2=new JTextField("Quantity");
            Font f3=new Font("TimesRoman",Font.PLAIN,15);
           t2.setFont(f3);
           t2.setPreferredSize(new Dimension(150, 30) );
           add(t2);
           
           
           
           
           
            b2=new  JButton("End Order");
           b2.setFont(f1);
           b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sales sp=new Sales();
                 sp.EndOrder();
            }
           });
           b2.setPreferredSize(new Dimension(130, 30) );
           add(b2);
           
           
           
           
            t3=new JTextField("Product name");
           t3.setFont(f3);
           t3.setPreferredSize(new Dimension(150, 30) );
           add(t3);
           
           
           
           Icon icon =new ImageIcon("top-transparent-icon-photos.jpg");
           b3=new  JButton(icon);
           b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sales sp=new Sales();
                try {
                    sp.SearchForProducts(t3.getText());
                } catch (IOException ex) {
                    Logger.getLogger(SalesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           });
           b3.setPreferredSize(new Dimension(30, 30) );
           add(b3);
         
          
          
          
          b4=new  JButton("show all products"); 
           b4.setFont(f1);
           b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sales sp=new Sales();
                T=new JTable();
                try {
                    sp.ShowAllProducts();
                } catch (IOException ex) {
                    Logger.getLogger(SalesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           });
           b4.setPreferredSize(new Dimension(250, 35) );
           add(b4);
            validate();   
              
    }
     }
    
            
   
    

