/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import hyper.Inventory;
import hyper.Products;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mohra
 */
public class InventoryFrame extends JFrame {

    JLabel background ;
    
    JLabel inventory = new JLabel ("INVENTORY");
    JLabel searchLabel = new JLabel ("Search For A Product");
    JLabel nameLabel = new JLabel ("Product Name:");
    JLabel IDLabel = new JLabel ("Product ID:");
    JLabel priceLabel = new JLabel ("Product Price:");
    JLabel AmountLabel = new JLabel ("Product Amount:");
    JLabel dateLabel = new JLabel ("Product Date:");
    JLabel SucessORFail = new JLabel ("");
    JTable ListTable = new JTable();
    
    Font font = new Font("SansSerif", Font.BOLD, 50);
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    
    JTextField TextFieldSearch = new JTextField();
    JTextField TextFieldproductName = new JTextField();
    JTextField TextFieldproductID = new JTextField();
    JTextField TextFieldproductAmount = new JTextField();
    JTextField TextFieldproductPrice = new JTextField();
    JTextField TextFieldproductExpiryDate = new JTextField();
    
    
    JButton searchButton = new JButton();
    JButton addButton = new JButton("Add Product");
    JButton updateButton = new JButton("Update Product");
    JButton deleteButton = new JButton("Delete Product");
    JButton listButton = new JButton("Show All Products");
    
    Border border = BorderFactory.createLineBorder(Color.ORANGE, 5);
    
    
    
    
    public InventoryFrame() throws IOException, FileNotFoundException, ParseException {    
        invFrame();
        
       
    }
    

    public void invFrame() throws IOException, FileNotFoundException, ParseException{
        
        
        this.setTitle("Inventory Section");
        this.setSize(1300,750);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //this.setLayout(null);
        
        //background
        ImageIcon image = new ImageIcon("background.jpg");
        background = new JLabel("",image,JLabel.CENTER);
        background.setBounds(0, 0, 1400 , 750);
        add(background);
        

        //Inventory
        inventory.setBounds(20, 10 , 320 , 120);
        inventory.setFont(font);
        inventory.setForeground(Color.LIGHT_GRAY);
        background.add(inventory);
                   
        //search
        searchLabel.setBounds(20, 120, 250, 32);
        searchLabel.setFont(font1);
        searchLabel.setForeground(Color.LIGHT_GRAY);
        background.add(searchLabel);
        
        
        //sreach button
        TextFieldSearch.setBounds(20, 160, 360, 32);
        searchButton.setIcon(new ImageIcon("searchIcon.png"));
        searchButton.setBounds(400, 160, 32, 32);
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    SearchactionPerformed(evt);
                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
        });
        background.add(TextFieldSearch);
        background.add(searchButton);
        validate();
        
        
        //productName
        nameLabel.setBounds(20, 230, 300, 32);
        nameLabel.setFont(font1);
        nameLabel.setForeground(Color.LIGHT_GRAY);
        background.add(nameLabel);
        
        TextFieldproductName.setBounds(200, 230, 200, 32);
        background.add(TextFieldproductName);
        
        
        //productID
        IDLabel.setBounds(20, 270, 200, 32);
        IDLabel.setFont(font1);
        IDLabel.setForeground(Color.LIGHT_GRAY);
        background.add(IDLabel);
        
        TextFieldproductID.setBounds(200, 270, 200, 32);
        background.add(TextFieldproductID);
        
        
        //productPrice
        priceLabel.setBounds(20, 310, 200, 32);
        priceLabel.setFont(font1);
        priceLabel.setForeground(Color.LIGHT_GRAY);
        background.add(priceLabel);
        
        TextFieldproductPrice.setBounds(200, 310, 200, 32);
        background.add(TextFieldproductPrice);
        
        
        //productAmount
        AmountLabel.setBounds(20, 350, 200, 32);
        AmountLabel.setFont(font1);
        AmountLabel.setForeground(Color.LIGHT_GRAY);
        background.add(AmountLabel);
        
        TextFieldproductAmount.setBounds(200,350,200,32);
        background.add(TextFieldproductAmount);
        
        //productDate
        dateLabel.setBounds(20, 390, 200, 32);
        dateLabel.setFont(font1);
        dateLabel.setForeground(Color.LIGHT_GRAY);
        background.add(dateLabel);
        
        TextFieldproductExpiryDate.setBounds(200, 390, 200, 32);
        background.add(TextFieldproductExpiryDate);
        
        
        
        //add product
        addButton.setBounds(50, 480, 150, 32);
        addButton.setBackground(Color.WHITE);
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    addactionPerformed(evt);
                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                   System.out.println(ex);
                }
            }
        });
        background.add(addButton);
        
        
        
        //delete product
        deleteButton.setBounds(230, 480, 150, 32);
        deleteButton.setBackground(Color.WHITE);
        background.add(deleteButton);
        deleteButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    DeleteactionPerformed(evt);
                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
        });
        
        
       //update product
       updateButton.setBounds(50, 530, 150, 32);
       updateButton.setBackground(Color.WHITE);
       background.add(updateButton);
       updateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    updateactionPerformed(evt);
                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
        });
       
       
       
       //list product
       listButton.setBounds(230, 530, 150, 32);
       listButton.setBackground(Color.WHITE);
       background.add(listButton);
       listButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    addRawData();
                } catch (IOException ex) {
                    System.out.println(ex);
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
            }
        });
       
       
       //sucess or fail
       SucessORFail.setBounds(50, 580, 600, 30);
       SucessORFail.setFont(font1);
       SucessORFail.setForeground(Color.WHITE);
       background.add(SucessORFail);
       
       
        //get message when product is lacking
       Inventory i = new Inventory();
       String lackProduct = i.ShortageWarn();
       if(lackProduct != null){
           JOptionPane.showMessageDialog(this, "The Amount of "+ lackProduct +" is less than 100" , "ERROR", JOptionPane.ERROR_MESSAGE); 
        
       }
       
       //get message when expiry date of product get close
       String x = i.ExpirationWarning();
       if(x != null){
           JOptionPane.showMessageDialog(this, x +" has expired" , "ERROR", JOptionPane.ERROR_MESSAGE); 
       }
       
       
    }
    
    
    


    private void resetData() {
        TextFieldproductName.setText("");
        TextFieldproductID.setText("");
        TextFieldproductAmount.setText("");
        TextFieldproductPrice.setText("");
        TextFieldproductExpiryDate.setText("");
        
    }

    public void addactionPerformed(ActionEvent e) throws IOException, ParseException {
        
        if(!TextFieldproductName.getText().equals("") && !TextFieldproductID.getText().equals("") && !TextFieldproductAmount.getText().equals("") && !TextFieldproductPrice.getText().equals("") && !TextFieldproductExpiryDate.getText().equals("")){


            Inventory i = new Inventory();
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(TextFieldproductExpiryDate.getText());

            i.setProductID(Integer.parseInt(TextFieldproductID.getText()));
            i.setProductName(TextFieldproductName.getText());
            i.setInitialPrice(Double.parseDouble(TextFieldproductPrice.getText()));
            i.setProductAmount(Integer.parseInt(TextFieldproductAmount.getText()));
            i.setProductDate(date1);


            if(i.AddProducts()){
                SucessORFail.setText("Added Successfully");
                resetData();
            }
            else{
                SucessORFail.setText("Failed to add");
            }
            

        }else{
        SucessORFail.setText("Missing required Fields.. Please fields complete before add");
       }
        
    }
    
    
    public void SearchactionPerformed(ActionEvent e) throws IOException, ParseException {
        if(!TextFieldSearch.getText().equals("")){
            Inventory i = new Inventory();
            Inventory returned =   (Inventory) i.SearchProduct(TextFieldSearch.getText());
            if(returned.getProductID() > 0){
                setData(returned);
                SucessORFail.setText("");
            }
            else{
                SucessORFail.setText("Not Found");
            }
        }else{
            SucessORFail.setText("Missing required Fields.. Please fields complete before add");
            }
        
    }
    
    private void setData(Inventory i){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy");
        String strDate = formatter.format(i.getProductDate());
        
        TextFieldproductName.setText(""+ i.getProductName());
        TextFieldproductID.setText("" + i.getProductID());
        TextFieldproductAmount.setText("" + i.getProductAmount());
        TextFieldproductPrice.setText("" + i.getInitialPrice());
        TextFieldproductExpiryDate.setText("" +strDate );
    }

    
   public void DeleteactionPerformed(ActionEvent e) throws IOException, ParseException {
     
       if(!TextFieldSearch.getText().equals("")){
            Inventory i= new Inventory();
            if(i.DeleteProduct( TextFieldSearch.getText()) ){
                 SucessORFail.setText("Deleted Successfully");
                 resetData();
            }else{
                SucessORFail.setText("Failed to Delete");
            }
       }else{
           SucessORFail.setText("Missing required Fields.. Please Search for product first");
       }
    }
   
   
   public void updateactionPerformed(ActionEvent e) throws IOException, ParseException {
        
        if(!TextFieldproductName.getText().equals("") && !TextFieldproductID.getText().equals("") && !TextFieldproductAmount.getText().equals("") && !TextFieldproductPrice.getText().equals("") && !TextFieldproductExpiryDate.getText().equals("")){
            
            Inventory i = new Inventory();
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(TextFieldproductExpiryDate.getText());

            i.setProductID(Integer.parseInt(TextFieldproductID.getText()));
            i.setProductName(TextFieldproductName.getText());
            i.setInitialPrice(Double.parseDouble(TextFieldproductPrice.getText()));
            i.setProductAmount(Integer.parseInt(TextFieldproductAmount.getText()));
            i.setProductDate(date1);
            
            if(i.UpdateProduct()){
                SucessORFail.setText("Updated Successfully");
                 resetData();
            }else{
                SucessORFail.setText("Failed to Update");
            }
        }else{
           SucessORFail.setText("Missing required Fields.. Please Search for product first");
       }
            
   }

   public void addRawData() throws IOException, FileNotFoundException, ParseException{
       DefaultTableModel model = (DefaultTableModel) ListTable.getModel();
       
       String columnName[] = {"Product ID", "Product Name" , "Date", "Price" , "Amount"};
       String data[][]={ {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""}}; 
       
       
       
       final JTable ListTable = new JTable(data , columnName);
       JScrollPane scrollPane = new JScrollPane(ListTable);
       ListTable.setBounds(700, 230, 600, 280);
       ListTable.setBackground(Color.WHITE);
       background.add(ListTable);
       
       Inventory i = new Inventory();
       
       ArrayList<Products> Product = new ArrayList<Products>();
       Product = i.ListProduct();
       int j = 0 ;
       
        for (Products x : Product) {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
            String strDate = formatter.format(x.getProductDate());
            
            data[j][0] = Integer.toString(x.getProductID());
            data[j][1] =x.getProductName();
            data[j][2] = Double.toString(x.getInitialPrice());
            data[j][3] = strDate;
            data[j][4] = Integer.toString(x.getProductAmount()); 
             j++; 
            model.addRow(data);
        }
       
   }
   
   
}

    
