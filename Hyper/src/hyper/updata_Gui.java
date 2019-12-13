/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author DELL
 */
public class updata_Gui extends JFrame {
      JLabel l1=new JLabel(" old Id");
      JLabel l2=new JLabel(" new Id");
      JLabel l3=new JLabel(" old type");
      JLabel l4=new JLabel(" new type");
      JLabel l5=new JLabel(" name");
      JLabel l6=new JLabel("phone ");
      JLabel l7=new JLabel("password ");
      String[] a={"Admin","Marketing Employee","Inventory Employee","Seller Employee"};
      JComboBox co=new JComboBox(a);
      JComboBox co1=new JComboBox(a);
      JTextField  t1=new JTextField();
      JTextField  t2=new JTextField();
      JTextField  t3=new JTextField();
      JTextField  t4=new JTextField();
      JPasswordField  t5=new JPasswordField ();
      JButton b=new JButton("update");
      Font f=new Font("TimesRoman",Font.BOLD,15);
    public updata_Gui(){
         setTitle("update Employee Info");
         setSize(1650,750);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(new JLabel(new ImageIcon("IMG-20191201-WA0008.png")));
        setVisible(true);
 
          l1.setForeground(Color.white);
          l1.setBounds(300,100,170,50);
          l1.setFont(f);
          l2.setForeground(Color.white);
          l2.setBounds(300,200,170,50);
          l2.setFont(f);
          l3.setForeground(Color.white);
          l3.setBounds(300,300,170,50);
          l3.setFont(f); 
          l4.setForeground(Color.white);
          l4.setBounds(300,400,170,50);
          l4.setFont(f); 
          l5.setForeground(Color.white);
          l5.setBounds(300,500,170,50);
          l5.setFont(f); 
          l6.setForeground(Color.white);
          l6.setBounds(300,600,170,50);
          l6.setFont(f); 
          l7.setForeground(Color.white);
          l7.setBounds(300,700,170,50);
           l7.setFont(f);
          add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
                 
  
          co.setBounds(400,300,170,50);
         add(co);
          
          co1.setBounds(400,400,170,50);
         add(co1);
          
          t1.setBounds(400, 100, 170, 50);
         
          t2.setBounds(400, 200, 170, 50);
          
          t3.setBounds(400, 500, 170, 50);
           
          t4.setBounds(400, 600, 170, 50);
        add(t1);
        add(t2);
        add(t3);
        add(t4);

t5.setBounds(400, 700, 170, 50);
add(t5);

b.setBounds(1000, 400, 150,40 );
add(b);
         

       b.addActionListener((ActionEvent e)->{
             String old_id=(t1.getText()).toString();
     String new_id=(t2.getText()).toString();
     String oldtype= co.getSelectedItem().toString();
     String newtype= co1.getSelectedItem().toString();
     String name=t3.getText().toString();
     String phone=t4.getText().toString();
     String pass=t5.getText().toString();
     AdminClass A2=new AdminClass();
        try {
            A2.UpdateInfo(old_id, new_id, oldtype, newtype, name, phone, pass);
        } catch (IOException ex) {
            Logger.getLogger(updata_Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
       
             });
    }
}