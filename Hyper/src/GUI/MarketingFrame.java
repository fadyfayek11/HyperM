/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import hyper.Marketing;
import hyper.Sales;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author mohra
 */
public class MarketingFrame extends JFrame implements ActionListener{
    
    JLabel background ;
    JLabel marketing = new JLabel ("Marketing");
    
    JLabel productname = new JLabel("Product Name");
    JLabel discount = new JLabel("Discount");
    JLabel SucessORFail = new JLabel ("");
    
    JTextField TextFieldproductName = new JTextField();
    //JTextField TextFieldproductID = new JTextField();
    JTextField TextFielddiscount = new JTextField();
   
    JButton discountButton = new JButton("Add Discount");
    JButton reportButton =new  JButton("Make Report");
    
    Font font = new Font("SansSerif", Font.BOLD, 50);
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    
    public MarketingFrame() {
        
        this.setTitle("Marketing Section");
        this.setSize(1650,750);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        
        //background
        ImageIcon image = new ImageIcon("IMG-20191201-WA0008.png");
        background = new JLabel("",image,JLabel.CENTER);
        background.setBounds(0, 0, 1650 , 750);
        add(background);
        
        //marketing
        marketing.setBounds(20, 10 , 320 , 120);
        marketing.setFont(font);
        marketing.setForeground(Color.LIGHT_GRAY);
        background.add(marketing);
        
        //product name
        productname.setBounds(20, 310, 200, 32);
        productname.setFont(font1);
        productname.setForeground(Color.LIGHT_GRAY);
        background.add(productname);
        
        TextFieldproductName.setBounds(200, 310, 200, 32);
        background.add(TextFieldproductName);
        
        //discount
        discount.setBounds(20, 350, 200, 32);
        discount.setFont(font1);
        discount.setForeground(Color.LIGHT_GRAY);
        background.add(discount);
        
        TextFielddiscount.setBounds(200,350,200,32);
        background.add(TextFielddiscount);
       
        //label
       SucessORFail.setBounds(50, 580, 600, 30);
       SucessORFail.setFont(font1);
       SucessORFail.setForeground(Color.WHITE);
       background.add(SucessORFail);
       
       
        //add discount
        discountButton.setBounds(50, 480, 150, 32);
        discountButton.setBackground(Color.WHITE);
        discountButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    discountactionPerformed(evt);
                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                   System.out.println(ex);
                }
            }
        });
        background.add(discountButton);
        
        
        //report button
        reportButton.setBounds(230, 480, 150, 32);
        reportButton.setBackground(Color.WHITE);
        background.add(reportButton);
        reportButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    ReportactionPerformed(evt);
                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
        });
        
    }     
        

    
    public void discountactionPerformed(ActionEvent e) throws IOException, ParseException {
        
            if(!TextFieldproductName.getText().equals("") && !TextFielddiscount.getText().equals("") ){
                Marketing m = new Marketing();
                
                if(m.discount(Integer.parseInt(TextFielddiscount.getText()) ,TextFieldproductName.getText())){
                    SucessORFail.setText("Added Discount Successfully");
                }
                else{
                SucessORFail.setText("Failed to add discount");
                }
                
            }else{
        SucessORFail.setText("Missing required Fields.. Please fields complete before add");
       }

    }
    
    public void ReportactionPerformed(ActionEvent e) throws IOException, ParseException {
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
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}