/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class Admin_Gui extends JFrame {
    JButton b= new JButton("add Employee");
    JButton b2= new JButton("Delete Employee");
    JButton b3= new JButton("Update Employee Info");
    JButton b4= new JButton("Show Employee List");
    JButton b5= new JButton("Search for Employee ");
    JTextField  t1=new JTextField();
    JPasswordField  t2=new JPasswordField ();
    JTextField  t3=new JTextField();
    JTextField  t4=new JTextField();
    JLabel l1=new JLabel("Id");
    JLabel l3=new JLabel("Password");
    JLabel l2=new JLabel("Employee Name");
    Font f=new Font("TimesRoman",Font.BOLD,15);
    JLabel l5=new JLabel("Type");
    JLabel l4=new JLabel("Phone Number");
    String[] a={"Admin","Marketing Employee","Inventory Employee","Seller Employee"};
    JComboBox co=new JComboBox(a);
    public Admin_Gui(){
        setTitle("Admin Page");
        setSize(1650, 750);
        setContentPane(new JLabel(new ImageIcon("IMG-20191201-WA0008.png")));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          b.setBounds(500,550,200,40);
          b.setBackground(Color.white);
           
          b2.setBounds(750,550,200,40);
          b2.setBackground(Color.white);
           
          b3.setBounds(500,600,200,40);
          b3.setBackground(Color.white);
           
          b4.setBounds(750,600,200,40);
          b4.setBackground(Color.white);
         
          b5.setBounds(600,650,200,40);
          b5.setBackground(Color.white);
      add(b);
      add(b2);
      add(b3);
      add(b4);
      add(b5);
          
          t1.setBounds(700,80,170,40);
          t2.setBounds(700,180,170,40);
          t3.setBounds(700,280,170,40);
          t4.setBounds(700,380,170,40);
          add(t1);
          add(t2);
          add(t3);
          add(t4);
          
          l1.setForeground(Color.yellow);
           l2.setForeground(Color.yellow);
          
           l3.setForeground(Color.yellow);
           l4.setForeground(Color.yellow);
            l5.setForeground(Color.yellow);
           
           l1.setBounds(500,80,170,50);
           
          l3.setBounds(500,280,170,50);
          l2.setBounds(500,180,170,50);
          l4.setBounds(500,380,170,50);
          l5.setBounds(500,480,170,50);
          
          l1.setFont(f);
          l2.setFont(f);
          l3.setFont(f);
          l4.setFont(f);
          l5.setFont(f);
         add(l1);
         add(l2);
          add(l3);
          add(l4);
          add(l5);  
          String[] a={"Admin","Marketing Employee","Inventory Employee","Seller Employee"};
         
          co.setBounds(700,480,170,40);
         add(co);
                  
         
         
   
   
    AdminClass A1=new AdminClass();
          co.addActionListener((ActionEvent e)->{
       String txt=co.getSelectedItem().toString();
       A1.setType(txt);
             });
              t1.addActionListener((ActionEvent e)->{
       int id=Integer.parseInt(t1.getText());
       A1.setId_of_employee(id);
             }); 
            t2.addActionListener((ActionEvent e)->{
       String passwors=t2.getText();
       A1.setPassword(passwors);
             }); 
                t3.addActionListener((ActionEvent e)->{
       String name=t3.getSelectedText();
       A1.setName(name);
             }); 
                    t4.addActionListener((ActionEvent e)->{
       String phone=t4.getSelectedText();
       A1.setNumber(phone);
             }); 
   
          b.addActionListener((ActionEvent e)->{
            try {
                A1.getdata();
                A1.AddEmployee();
                JOptionPane.showMessageDialog(null,"New Employee Added","succssesful",JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(Admin_Gui.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"try again","failed",JOptionPane.ERROR_MESSAGE);
            }
             }); 
               b2.addActionListener((ActionEvent e)->{
       String id=(t1.getText());
           String txt=co.getSelectedItem().toString();
            try {
                A1.Delete(id, txt);
                JOptionPane.showMessageDialog(null,"One Employee Deleted","succssesful",JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"try again","failed",JOptionPane.ERROR_MESSAGE);
            }
       
             });
                            b4.addActionListener((ActionEvent e)->{
       
              String txt=co.getSelectedItem().toString();
            try {
                A1.ListofEmployee(txt);
            } catch (IOException ex) {
                Logger.getLogger(Admin_Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                            });   
                            b5.addActionListener((ActionEvent e)->{
                       String txt=co.getSelectedItem().toString();    
                       String name=t3.getSelectedText();
            try {
                A1.SearchEmployee(name, txt);
            } catch (IOException ex) {
                Logger.getLogger(Admin_Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
    });
                            
                            
                           b3.addActionListener((ActionEvent e)->{
            Admin_Gui h2=new Admin_Gui();
            h2.setVisible(true);
            setSize(1650,750);
            setTitle("update Employee Info");
                  dispose();             
                            });
              
         
      
             
          
    
}
    }
