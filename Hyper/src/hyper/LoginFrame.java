/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

import hyper.User;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.*;

/**
 *
 * @author Fady Fayek
 */
public class LoginFrame extends User implements ActionListener{
    public static int sid;
    JLabel id;
    JLabel pass;
    
    JButton button;
    
    JTextField email;
    JPasswordField jPasswordField;
    
    JFrame f=new JFrame();
    public void loginto()
   {
       
    
    JLabel background;
    JPanel panal=new JPanel();
    id=new JLabel("ID");
    pass=new JLabel("Password");
    button=new JButton("Log in");
    id.setBounds(120,205,200,30);
    id.setForeground(Color.WHITE);
    f.add(id);
    pass.setBounds(120,255,200,30);
    pass.setForeground(Color.WHITE);
    f.add(pass);
    jPasswordField=new JPasswordField();
    jPasswordField.setCaretColor(Color.gray);
    jPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.orange));
    email=new JTextField();
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    email.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.orange));
    email.setCaretColor(Color.gray);
    email.setBackground(Color.white);
    email.setBounds(120,230,200,30);
    email.setFont(font1);
    jPasswordField.setFont(font1);
    f.add(email);
  
    f.setTitle("Login");
    f.setSize(450,700);
    f.setLayout(null);
    f.setLocationRelativeTo(f);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    button.setBounds(160,400,120,30);
    button.setBackground(Color.white);
    Font font2 = new Font("SansSerif", Font.PLAIN, 18);
    button.setFont(font2);
    f.add(button);
    ImageIcon image=new ImageIcon("image.jpg");
    background=new JLabel("",image,JLabel.CENTER);
    background.setBounds(0,0,450,700);
    jPasswordField.setBounds(120,280,200,30);
    jPasswordField.setBackground(Color.white);
    ImageIcon img = new ImageIcon("icon.png");
    f.setIconImage(img.getImage());
 
    f.add(jPasswordField);
    
    f.setResizable(false);
   
    f.add(background);
    
    f.setVisible(true);
    button.addActionListener(this);
    
   }   

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button)
        {
            try {
                String email2=email.getText().toString();
                String password=jPasswordField.getText().toString();
                
                 
                int i = Integer.parseInt(email2);
                sid=i;
                //System.out.println(sid);
                if (email2.equals(" ")&&password.equals(" ")) {
                    System.out.println("empty");
                    
                }
                else if (email2.equals("")&&password.equals("")) {
                     System.out.println("empty");
                }
                else if (email2.equals("")||password.equals("")) {
                    System.out.println("empty");
                }
                else if (email2.equals(" ")&&password.equals(" ")) {
                    System.out.println("empty");
                }
               else
                {
                 if(login(email2, password)==1)
                 {
                   f.setVisible(false);
                 }
                 
                }
                
               
               
                
            } catch (NumberFormatException ex) {
                System.out.println(ex+"");
                // Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                        
    
        }
 }

    

    
   

