package hyper;


import static hyper.User.finaltype;
import static hyper.User.infoofemployee;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fady Fayek
 */
public class InfoGui extends User implements ActionListener{
    //LoginFrame fw=new LoginFrame();
    
   int id=LoginFrame.sid;
    
    JLabel Name;
    JLabel Phone;
    JLabel Password;
    JLabel rePassword;
    
    
    JLabel Name1;
    JLabel Phone1;
    JLabel Password1;
    JLabel Type;
    JLabel id1;
    
    JLabel yourName1;
    JLabel yourPhone1;
    JLabel yourPassword1;
    JLabel yourType;
    JLabel yourid1;
    
    
    JButton updata;
    JButton back;
    
    JTextField name;
    JTextField phone;
    JPasswordField pass1;
    JPasswordField pass2;
    
    JTable table=new JTable();
    
    JFrame f=new JFrame();
    public void infoway() throws IOException  {
      show();
      f.setLayout(null);
      Font font2 = new Font("SansSerif", Font.PLAIN, 18);
      f.setSize(900,650);
      f.setLocationRelativeTo(f);
      //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLabel background;
      JPanel panal=new JPanel();
      f.setTitle("update/refresh");
      
      
      Name=new JLabel("New Name/Name");
      Phone=new JLabel("New Phone/Phone");
      Password=new JLabel("New Password/Password");
      rePassword=new JLabel("rePassword");
      updata=new JButton("Updata");
      back=new JButton("back");
      
     
      Name1=new JLabel("Your Name : ");
      Phone1=new JLabel("Your Phone : ");
      Password1=new JLabel("Your Password : ");
      id1=new JLabel("Your ID : ");
      Type=new JLabel("Your Type : ");
      
      
      
      id1.setBounds(500,120,70,30);
      id1.setForeground(Color.white);
      f.add(id1);
      
      Name1.setBounds(500,150,90,30);
      Name1.setForeground(Color.white);
      f.add(Name1);
      
       
      Password1.setBounds(500,180,100,30);
      Password1.setForeground(Color.white);
      f.add(Password1);
      
      
      Phone1.setBounds(500,210,90,30);
      Phone1.setForeground(Color.white);
      f.add(Phone1);
      
      
      
      Type.setBounds(500,240,90,30);
      Type.setForeground(Color.white);
      f.add(Type);
      
      
      
      
      
      
      
      
      name=new JTextField();
      phone=new JTextField();
      pass1=new JPasswordField();
      pass2=new JPasswordField();
     
           
      
      f.getContentPane().setBackground(Color.decode("#a4aaf2"));
      
      updata.setBounds(700,500,150,30);
      updata.setBackground(Color.WHITE);
      updata.setFont(font2);
      f.add(updata);
      
      back.setBounds(40,500,150,30);
      back.setBackground(Color.WHITE);
      back.setFont(font2);
      f.add(back);
      
   
      
      Name.setBounds(50,120,200,30);
      Name.setForeground(Color.white);
      f.add(Name);
      
      
      name.setBounds(50,150, 200, 30);
      name.setBackground(Color.lightGray);
      name.setFont(font2);
      name.setForeground(Color.black);
      name.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.orange));
      f.add(name);
      
      Phone.setBounds(50,170,200,30);
      Phone.setForeground(Color.white);
      f.add(Phone);
      
      
      phone.setBounds(50,200, 200, 30);
      phone.setBackground(Color.lightGray);
      phone.setFont(font2);
      phone.setForeground(Color.black);
      phone.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.orange));
      f.add(phone);
      
      Password.setBounds(50,220,200,30);
      Password.setForeground(Color.white);
      f.add(Password);
      
      pass1.setBounds(50,250, 200, 30);
      pass1.setBackground(Color.lightGray);
      pass1.setFont(font2);
      pass1.setForeground(Color.black);
      pass1.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.orange));
      f.add(pass1);
      
      rePassword.setBounds(50,270,200,30);
      rePassword.setForeground(Color.white);
      f.add(rePassword);
      
      pass2.setBounds(50,300,200,30);
      pass2.setBackground(Color.lightGray);
      pass2.setFont(font2);
      pass2.setForeground(Color.black);
      pass2.setBorder(BorderFactory.createMatteBorder(0, 0,3, 0, Color.orange));
      f.add(pass2);
      
    
     
      
      
      
      
      
     
      f.setResizable(false);
      f.setVisible(true);
      updata.addActionListener(this);
      back.addActionListener(this);
      
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            
            if (e.getSource()==updata) {
               try {
                 
                String newname=name.getText().toString();
                String newphone=phone.getText().toString();;
                String newpass=pass1.getText().toString();;
                String newpass2=pass2.getText().toString();;
                
                    
                     if (newname.equals("")&&newpass.equals("")&&newphone.equals("")&&newpass2.equals("")) {
                        JOptionPane.showMessageDialog(null,"No data to update");
                        show();
                }
                    else if (newpass == null ? newpass2 != null : !newpass.equals(newpass2)) {
                        System.out.println("sory pass");
                        show();
                    }
                    else if (newpass2.equals("")||newname.equals("")||newpass.equals("")||newphone.equals("")) {
                         System.out.println("empty");
                         show();
                    }
                     else
                    {
                        
                        show();
                        UpdateInfo(id,finaltype, newname, newphone, newpass);
                        
                        name.setText("");
                        phone.setText("");
                        pass1.setText("");
                        pass2.setText("");
                    }
                
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                
                
                
            
        }
            if (e.getSource()==back) {
                f.setVisible(false);
               /* String myname=infoofemployee.get(0).toString();
                String mytype=infoofemployee.get(1).toString();
                String myid=infoofemployee.get(2).toString();
                String mypassword=infoofemployee.get(3).toString();
                String myphone=infoofemployee.get(4).toString();
                System.out.println(myid+""+myname);*/
                //DefaultListModel model=(DefaultListModel) table.getModel();
                /*String [] c={"ID","Name","Password","Type","Phone Number"};
                DefaultTableModel model=new DefaultTableModel();
                model.addColumn(c[0]);
                model.addColumn(c[1]);
                model.addColumn(c[2]);
                model.addColumn(c[3]);
                model.addColumn(c[4]);
                model.addColumn(c[5]);
                
                String[]r=new String[6];
                for (int i = 0; i <= infoofemployee.size(); i++){
                r[0]= infoofemployee.get(i).toString()+"";
                r[1]= infoofemployee.get(i).toString()+"";
                r[2]= infoofemployee.get(i).toString()+"";
                r[3]= infoofemployee.get(i).toString()+"";
                r[4]= infoofemployee.get(i).toString()+"";
                r[5]= infoofemployee.get(i).toString()+"";
                model.addRow(r);
                }
                
                table.setModel(model);
                table.setBounds(200, 30,400,100);
                f.add(table);*/
            }
            
    }
    public void show() throws IOException
    {
      ShowMyInfo(id); 
      String myname=infoofemployee.get(0).toString();
      String mytype=infoofemployee.get(1).toString();
      String myid=infoofemployee.get(2).toString();
      String mypassword=infoofemployee.get(3).toString();
      String myphone=infoofemployee.get(4).toString();
      
      
        
      yourName1=new JLabel(myname);
      yourPhone1=new JLabel(myphone);
      yourPassword1=new JLabel(mypassword);
      yourid1=new JLabel(myid);
      yourType=new JLabel(mytype);
      
      
      
      yourid1.setBounds(600,120,70,30);
      yourid1.setForeground(Color.white);
      f.add(yourid1);
      yourName1.setBounds(600,150,90,30);
      yourName1.setForeground(Color.white);
      f.add(yourName1);
      yourPassword1.setBounds(600,180,100,30);
      yourPassword1.setForeground(Color.white);
      f.add(yourPassword1);
      yourPhone1.setBounds(600,210,90,30);
      yourPhone1.setForeground(Color.white);
      f.add(yourPhone1);
      yourType.setBounds(600,240,90,30);
      yourType.setForeground(Color.white);
      f.add(yourType);
      infoofemployee.clear();
    
    
    }
    
}
