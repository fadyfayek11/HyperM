/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JList;
import javax.swing.border.Border;

/**
 *
 * @author marti
 */
public class SalesGUI extends JFrame {
   JPanel jp=new JPanel();
   JButton ButtonBack;
   JButton ButtonOrder;
   JButton ButtonEnd;
   JButton ButtonSearch;
   JButton ButtonShowAll;
   JButton ButtonReturn;
   JButton close;
   JLabel Sales;
   JTextField TextProductName;
   JTextField TextQuantity;
   JTextField TextSearch;
 
   JLabel jl=new JLabel("");
    public SalesGUI() throws IOException{
        setTitle("SALES");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1650,750);
        setContentPane(new JLabel(new ImageIcon("IMG-20191201-WA0008.png")));
          



//Button "back"
           Icon icon =new ImageIcon("");
           ButtonBack=new  JButton(icon);
           ButtonBack.setBounds(0, 0, 25, 25);
           add(ButtonBack);
//           ButtonSearch.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                
//                
//            }
//           });
           




// Label "Sales"
           Sales=new JLabel("Sales");  
           Sales.setForeground(Color.white);
           Font f=new Font("TimesRoman",Font.BOLD,80);
           Sales.setBounds(40, 60,300 , 80);
           Sales.setFont(f);
           add(Sales);
           
           
 //text "search"         
           TextSearch=new JTextField("Search");
           Font f2=new Font("TimesRoman",Font.PLAIN,15);
           TextSearch.setFont(f2);
           TextSearch.setBounds(30, 300, 250, 30);
           add( TextSearch);
           
           
  //button "search"         
           Icon icon2 =new ImageIcon("top-transparent-icon-photos.jpg");
           ButtonSearch=new  JButton(icon2);
           ButtonSearch.setBounds(290, 300, 30, 30);
           add(ButtonSearch);
           ButtonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
               Sales sp=new Sales();
                String arr[]=null ;
                try {
                    arr=sp.SearchForProducts( TextSearch.getText());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
                if("DOES NOT EXIST".equals(arr[0])){
                JOptionPane.showMessageDialog(null, arr[0], "ALERT", JOptionPane.WARNING_MESSAGE);
                }
                else{
                     JFrame frame=new JFrame();
                    frame.setVisible(true);
                     frame. setSize(750,100);
                    DefaultListModel<String>List=new DefaultListModel<>();
                     JList<String>list=new JList<>(List);
                     List.addElement("      ID                           Product Name                           Date                                        Price                                   Amount");
                    List.addElement(arr[0]);
                    frame.setResizable(false);
                     frame.add(list);
                }  
            }
           });
           
           
           
         
           
           
           
           
//button "add"           
           Icon icon3 =new ImageIcon("images(2).png");
           ButtonOrder=new  JButton(icon3);
           ButtonOrder.setBounds(290,420, 30,30);
           add(ButtonOrder);
           Font f1=new Font("TimesRoman",Font.CENTER_BASELINE,20);
           
           ButtonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    jl.setText("Added to cart");
                
                    Sales sp=new Sales();
                    sp.MadeOrder(TextProductName.getText(),Integer.parseInt(TextQuantity.getText()));
                    
                    TextProductName.setText("");
                    TextQuantity.setText("");
                } catch (IOException ex) {
                   System.out.println(ex.getMessage());
                }
                
            }
           });
           
            
           jl.setBounds(450, 420, 150, 20);
           jl.setFont(f1);
           jl.setForeground(Color.white);
            add(jl); 
           
           
 //text "product name"          
            TextProductName=new JTextField("Product Name");
            TextProductName.setFont(f2);
           TextProductName.setBounds(30, 420, 120, 30);
           add(TextProductName);
           
           
 //text "quantity"
            TextQuantity=new JTextField("Quantity");
           TextQuantity.setFont(f2);
           TextQuantity.setBounds(160,420,120,30);
           add(TextQuantity);
           
           
           
           
//button "finish an order"          
           Icon icon4 =new ImageIcon("images-(1).png");
            ButtonEnd=new  JButton(icon4); 
            ButtonEnd.setBounds(330,420,30,30);
          add(ButtonEnd);
           ButtonEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               String arr[]=new  String[2];
               Sales sp=new Sales();
                arr=sp.EndOrder();
                 JFrame frame=new JFrame();
                 frame.setVisible(true);
                 frame. setSize(750,80);
                 frame.setResizable(false);
                 DefaultListModel<String>List=new DefaultListModel<>();
                 JList<String>list=new JList<>(List);
                 List.addElement("  total before discount                                    total after discount");  
                 List.addElement("                 "+arr[0]+"                                                                        "+arr[1]);
                 frame.add(list);
              
            }
           });
        
           
           
           
 //button "return"          
            Icon icon5 =new ImageIcon("images(3).png");
           ButtonReturn=new  JButton(icon5);
           ButtonReturn.setFont(f1); 
           ButtonReturn.setBounds(370,420,30,30);
           add(ButtonReturn);
           ButtonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    jl.setText("Item returned");
                    
                    Sales sp=new Sales();
                    sp.returnFromSales(Integer.parseInt(TextQuantity.getText()),TextProductName.getText());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
            }
           });
        
            
         
          
          
//button "show all products"          
          ButtonShowAll=new  JButton("show all products"); 
          ButtonShowAll.setFont(f1);
           ButtonShowAll.setBounds(30, 550, 250, 30);
           add(ButtonShowAll);
           ButtonShowAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                 JFrame frame=new JFrame();
                frame.setVisible(true);
                frame. setSize(1650,750);
                Sales s=new Sales(); 
                String arr[]=null ;
                int x;
                 DefaultListModel<String>List=new DefaultListModel<>();
                JList<String>list=new JList<>(List);
                JScrollPane scroll=new JScrollPane();
                scroll.setViewportView(list);
                List.addElement("      ID                                                                           Product Name                                                                          Date                                                                                       Price                                                                                    Amount");
                frame.add(scroll);
                scroll.setBounds(500, 400, 500, 500);
               
                try {
                         arr=s.ShowAllProducts();
                         x = s.NoOfProducts(); 
                         for(int i=0;i<x;i++){
                        List.addElement(arr[i]);
                }
                } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                }
                  
            }
           });
          
           

           
            validate();  
    }

   
    
    
     }