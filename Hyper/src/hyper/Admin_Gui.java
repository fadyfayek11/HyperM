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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
public class Admin_Gui extends JFrame  implements ActionListener  {
    JButton b= new JButton("add Employee");
    JButton b2= new JButton("Delete Employee");
    JButton b3= new JButton("Update Employee Info");
    JButton b4= new JButton("Show Employee List");
    JButton b5= new JButton("Search for Employee ");
    JTextField  t1=new JTextField();
    JTextField  t2=new JTextField();
    JPasswordField  t3=new JPasswordField ();
    JTextField  t4=new JTextField();
    JLabel l1=new JLabel("Id");
    JLabel l3=new JLabel("Password");
    JLabel l2=new JLabel("Employee Name");
    Font f=new Font("TimesRoman",Font.BOLD,15);
    JLabel l5=new JLabel("Type");
    JLabel l4=new JLabel("Phone Number");
    String[] a={"Admin","Marketing Employee","Inventory Employee","Seller Employee"};
    JComboBox co=new JComboBox(a);
    JButton logout;
    JButton info;
     JLabel background ;
    public Admin_Gui(){
        setTitle("Admin Page");
        setSize(1650,750);
        setContentPane(new JLabel(new ImageIcon("IMG-20191201-WA0008.png")));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setResizable(false); 
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
      
      //Button "log out"
           Icon icon =new ImageIcon("out.png");
           logout=new  JButton(icon);
           logout.setBounds(1350,600, 50, 50);
           logout.setBackground(Color.white);
           JLabel out=new JLabel("log out");
           out.setForeground(Color.WHITE);
           out.setBounds(1420,600,100,50);
           Font font=new Font("SansSerif", Font.BOLD, 24);
           out.setFont(font);
            logout.addActionListener(this);
            add(out);
            add(logout);
            
            
            
            
              //Button "info"
           Icon iconinfo =new ImageIcon("info.png");
           info=new  JButton(iconinfo);
           info.setBounds(1350,500, 50, 50);
           info.setBackground(Color.white);
           JLabel info1=new JLabel("Info");
           info1.setForeground(Color.WHITE);
           info1.setBounds(1420,500,100,50);
           info1.setFont(font);
            info.addActionListener(this);
            add(info);
            add(info1);
            
            
            
            ImageIcon img = new ImageIcon("icon.png");
            setIconImage(img.getImage());
          
          t1.setBounds(700,80,170,30);
          t2.setBounds(700,180,170,30);
          t3.setBounds(700,280,170,30);
          t4.setBounds(700,380,170,30);
          add(t1);
          add(t2);
          add(t3);
          add(t4);
          
          l1.setForeground(Color.white);
           l2.setForeground(Color.white);
          
           l3.setForeground(Color.white);
           l4.setForeground(Color.white);
            l5.setForeground(Color.white);
           
           l1.setBounds(500,80,170,40);
           
          l3.setBounds(500,280,170,40);
          l2.setBounds(500,180,170,40);
          l4.setBounds(500,380,170,40);
          l5.setBounds(500,480,170,40);
          
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
         /* co.addActionListener((ActionEvent e)->{
       String txt=co.getSelectedItem().toString();
       A1.setType(txt);
             });
              t1.addActionListener((ActionEvent e)->{
       int id=Integer.parseInt(t1.getText());
       A1.setId_of_employee(id);
             }); 
            t3.addActionListener((ActionEvent e)->{
       String passwors=t3.getText();
       A1.setPassword(passwors);
             }); 
                t3.addActionListener((ActionEvent e)->{
       String name=t3.getSelectedText();
       A1.setName(name);
             }); 
                    t4.addActionListener((ActionEvent e)->{
       String phone=t4.getSelectedText();
       A1.setNumber(phone);
             }); */
   
          b.addActionListener((ActionEvent e)->{
               int id=Integer.parseInt(t1.getText());
                 String passwors=t3.getText();
                  String name=t2.getText();
                  String phone=t4.getText();
                   A1.setName(name);
       A1.setId_of_employee(id);
           String txt=co.getSelectedItem().toString();
       A1.setType(txt);
               if (passwors.length() < 8) {
                  JOptionPane.showMessageDialog(null,"the password should be more than 8 char","failed",JOptionPane.ERROR_MESSAGE);
        } else {
                   
             A1.setPassword(passwors);
        }
                  if (phone.length() <= 11 && phone.length() > 10) {

            A1.setNumber(phone);
        } else {
                      JOptionPane.showMessageDialog(null,"incorrect phone number-should be 11 number","failed",JOptionPane.ERROR_MESSAGE);
         
        }
            try {
                 
       File f=new File(A1.getId_of_employee()+".txt");
       if(!f.exists()){
       if (A1.getPassword()==passwors&&A1.getNumber()==phone) { 
       
      
            A1.getdata();
                A1.AddEmployee();
                JOptionPane.showMessageDialog(null,"New Employee Added","succssesful",JOptionPane.INFORMATION_MESSAGE);
       }
       
                 
                 t1.setText(" ");
                 t2.setText(" ");
                 t3.setText("");
                 t4.setText(" ");
             
       }
       else if(f.exists()){
           JOptionPane.showMessageDialog(null,"Emplyee id is aready founded","failed",JOptionPane.ERROR_MESSAGE);
       }
       
           }catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"try again error","failed",JOptionPane.ERROR_MESSAGE);
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
              ArrayList<String>l1=new ArrayList<String>();
              
         
            
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
            updata_Gui h=new updata_Gui ();
            h.setVisible(true);
            setSize(1650,750);
            setTitle("update Employee Info");
                  dispose(); 
             
  
                       
                           });
              
         
      
            // b5.addActionListener(this);
          
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==logout)
        {
            setVisible(false);
            LoginFrame loginFrame=new LoginFrame();
            loginFrame.loginto();
        }
         if (e.getSource()==info)
        {
            try {
                InfoGui jGui=new InfoGui();
                jGui.infoway();
            } catch (IOException ex) {
                Logger.getLogger(Admin_Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    }
