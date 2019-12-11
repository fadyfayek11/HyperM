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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JList;

/**
 *
 * @author marti
 */
public class SalesGUI extends JFrame {
   JPanel jp=new JPanel();
   JButton ButtonOrder;
   JButton ButtonEnd;
   JButton ButtonSearch;
   JButton ButtonShowAll;
   JButton ButtonReturn;
   JLabel Sales;
   JTextField TextProductName;
   JTextField TextQuantity;
   JTextField TextSearch;
   JTable T;
   
    public SalesGUI() throws IOException{
        setTitle("SALES");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

           setContentPane(new JLabel(new ImageIcon("IMG-20191201-WA0008.png")));
           setLayout(new FlowLayout());
          
           
           Sales=new JLabel("Sales");  
           Font f=new Font("TimesRoman",Font.BOLD,80);
           Sales.setForeground(Color.white);
           Sales.setFont(f);
           add(Sales);
           
           setSize(1650,750);
           
           
           
           ButtonOrder=new  JButton("order");
           Font f1=new Font("TimesRoman",Font.CENTER_BASELINE,20);
           ButtonOrder.setFont(f1);
           ButtonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sales sp=new Sales();
                try {
                    sp.MadeOrder(TextProductName.getText(),Integer.parseInt(TextQuantity.getText()));
                } catch (IOException ex) {
                    Logger.getLogger(SalesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           });
           ButtonOrder.setPreferredSize(new Dimension(130, 30) );
           add(ButtonOrder);
            
           
             
            TextProductName=new JTextField("Product Name");
            Font f2=new Font("TimesRoman",Font.PLAIN,15);
           TextProductName.setFont(f2);
           TextProductName.setPreferredSize(new Dimension(150, 30) );
           add(TextProductName);
           

            TextQuantity=new JTextField("Quantity");
           TextQuantity.setFont(f2);
           TextQuantity.setPreferredSize(new Dimension(150, 30) );
           add(TextQuantity);
           
           
           
           
           
            ButtonEnd=new  JButton("End Order");
           ButtonEnd.setFont(f1);
           ButtonEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sales sp=new Sales();
                 sp.EndOrder();
            }
           });
          ButtonEnd.setPreferredSize(new Dimension(130, 30) );
           add(ButtonEnd);
           
           
           
           
            TextSearch=new JTextField("Search");
           TextSearch.setFont(f2);
            TextSearch.setPreferredSize(new Dimension(150, 30) );
           add( TextSearch);
           
           
           
           Icon icon =new ImageIcon("top-transparent-icon-photos.jpg");
           ButtonSearch=new  JButton(icon);
           ButtonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Sales sp=new Sales();
                String arr[]=null ;
                try {
                    arr=sp.SearchForProducts( TextSearch.getText());
                } catch (IOException ex) {
                    Logger.getLogger(SalesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if("DOES NOT EXIST".equals(arr[0])){
                JOptionPane.showMessageDialog(null, arr[0], "ALERT", JOptionPane.WARNING_MESSAGE);
                }
                else{
                     JFrame frame=new JFrame();
                    frame.setVisible(true);
                     frame. setSize(600,200);
                    DefaultListModel<String>List=new DefaultListModel<>();List.addElement("     ID                          Product Name                         Price                         Amount                         Discount");  
                    List.addElement(arr[0]);
                 final JList<String>list=new JList<>(List);
                 JScrollPane scroll=new JScrollPane();
                 scroll.setViewportView(list);
                 frame.add(scroll);    
                }  
            }
           });
           ButtonSearch.setPreferredSize(new Dimension(30, 30) );
           add(ButtonSearch);
         
          
          
          
          ButtonShowAll=new  JButton("show all products"); 
          ButtonShowAll.setFont(f1);
           ButtonShowAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                JFrame frame=new JFrame();
                frame.setVisible(true);
                frame. setSize(1650,750);
                Sales s=new Sales(); 
                String arr[]=null ;
                try {
                    arr=s.ShowAllProducts();
                } catch (IOException ex) {
                    Logger.getLogger(SalesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                DefaultListModel<String>List=new DefaultListModel<>();
                int x;
                List.addElement("     ID                                                                                            Product Name                                                                                           Price                                                                                             Amount                                                                                       Discount");
                try {
                    x = s.NoOfProducts(); 
                    for(int i=0;i<x;i++){
                        List.addElement(arr[i]);
                    } 
                } catch (IOException ex) {
                    Logger.getLogger(SalesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
                
                 final JList<String>list=new JList<>(List);
                 JScrollPane scroll=new JScrollPane();
                 scroll.setViewportView(list);
                 frame.add(scroll);
            }
           });
           ButtonShowAll.setPreferredSize(new Dimension(250, 35) );
           add(ButtonShowAll);
           
           
           
           
           
           
            ButtonReturn=new  JButton("return products");
           ButtonReturn.setFont(f1);
           ButtonReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Sales sp=new Sales();
                try {
                    sp.returnFromSales(Integer.parseInt(TextQuantity.getText()),TextProductName.getText());
                } catch (IOException ex) {
                    Logger.getLogger(SalesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           });
           ButtonReturn.setPreferredSize(new Dimension(130, 30) );
           add(ButtonReturn);
           
            validate();  
    }

    
     }