
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

import GUI.InventoryFrame;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;  


/**
 *
 * @author mohra
 */


public class Inventory extends Products{

    
    //defult constractor
    public Inventory()
    {
    
    }

    /*main constractor*/
    public Inventory(String productDate, String productName, int productID, int productAmount, double initialPrice) throws ParseException {
        String sDate1= productDate;
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
        
        this.setProductID(productID);
        this.setProductName(productName);
        this.setProductAmount(productAmount);
        this.setProductDate(date1);
        this.setInitialPrice(initialPrice);
        
    }
    
       //SearchProduct
   public Object SearchProduct(String productName ) throws IOException, ParseException {
       File f =new File("ProductFile.txt");
        FileReader f2=new FileReader(f);
        BufferedReader f3=new BufferedReader(f2);
        String line;
        boolean found=false;
        Inventory x = new Inventory();
        
        while((line=f3.readLine())!=null)
        {
            if(line.contains(productName))
            {
                String[] l=line.split("@");
                
                String sDate1= l[2];
                Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                
                x.setProductID(Integer.parseInt(l[0]));
                x.setProductName(l[1]);
                x.setProductDate(date1);
                x.setInitialPrice(Double.parseDouble(l[3]));
                x.setProductAmount(Integer.parseInt(l[4]));
                
                for(String data:l)
                System.out.println(data);
                
            }
        }
        
        f2.close();
        f3.close();
        return x;
    }
       
  
    
         //add product
    public boolean AddProducts() throws IOException,FileNotFoundException {
            File f =new File("ProductFile.txt");
            FileWriter f1 = new FileWriter(f,true);
            FileReader f2=new FileReader(f);
            BufferedReader f3=new BufferedReader(f2);
            String line;
            boolean found=false;
            
            if(f.exists()){ 
                while((line=f3.readLine())!=null)
                {
                    String[] seperated = line.split("@");
                    
                    if( Integer.parseInt(seperated[0]) == getProductID() ){  //check id id is unique or not
                        System.out.println("this id is already existed ,Please enter correct id");
                        found=true;
                        break;
                    }
                    
                    if( seperated[1].equals(getProductName()) ){ //check not repeat product name
                        System.out.println("this product name is already existed");
                        found=true;
                        break;
                    }

                }
                if(!found){
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
                    String strDate = formatter.format(getProductDate());  
        
                    f1.write(getProductID()+"@");
                    f1.write(getProductName()+"@");
                    f1.write(strDate+"@");
                    f1.write(getInitialPrice()+"@");
                    f1.write(getProductAmount()+"@\n");
                  
                    f1.close();
                }
                f3.close();
                f1.close();
                f2.close();
            }
            
            if (found == true){
                return false;
            }
            else
                return true;
    }
            

    
    
         //remove product
    public boolean DeleteProduct(String productName) throws IOException{
            File f =new File("ProductFile.txt");
            File TempFile= new File("TempFile.txt");
            BufferedReader reader=new BufferedReader(new FileReader(f));
            PrintWriter  writer =new PrintWriter(new FileWriter(TempFile));
            
            String line;
            while((line=reader.readLine())!=null){
                    if(line.contains(productName)){
                        continue; 
                    }
                    writer.println(line);
            }
            
            reader.close();
            writer.close();
            
            f.delete();
            boolean DeleteSuccessful = TempFile.renameTo(f);
            if(DeleteSuccessful){
                System.out.println("THE PRODUCT DELETED IS SUCCESSFULLY ");
                return true;
            }
            else{
                System.out.println("ENTER CORRECT PRODUCT-ID AND PRODUCT-NAME ");
                return false;
            }
    }
    
    //List Products
    public ArrayList<Products> ListProduct() throws FileNotFoundException, IOException, ParseException{
            File f = new File("ProductFile.txt");
            BufferedReader reader = new BufferedReader(new FileReader(f));
            ArrayList <Products> Product = new ArrayList <Products>();
            
            String line;
            
            while( (line=reader.readLine())!=null ){
                String[] l=line.split("@");
                Products x = new Products();
                
                 String sDate1= l[2];
                 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
                
                for(String lists:l)
                {
                 System.out.println(lists);   
                }
                
                x.setProductID(Integer.parseInt(l[0]));
                x.setProductName(l[1]);
                x.setProductDate(date1);
                x.setInitialPrice(Double.parseDouble(l[3]));
                x.setProductAmount(Integer.parseInt(l[4]));
                
                Product.add(x);
            }
            reader.close();
            return Product;
        }
    
          //update product
    public boolean UpdateProduct() throws IOException , FileNotFoundException{
            File f =new File("ProductFile.txt");
            File TempFile= new File("TempFile.txt");
            BufferedReader reader=new BufferedReader(new FileReader(f));
            PrintWriter  writer =new PrintWriter(new FileWriter(TempFile));
            
            boolean update = false;
            
            //Check if product is already exists in the ProductFile or not
            if( this.SearchProductIfExist(getProductName()) ){
                
                if( uniqueID( getProductID() , getProductName()) ){ //Check if id is unique
                    if(TempFile.exists()){
                        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
                        String strDate = formatter.format(this.getProductDate());
            
                        writer.write(this.getProductID()+"@");
                        writer.write(this.getProductName()+"@");
                        writer.write(strDate+"@");
                        writer.write(this.getInitialPrice()+"@");
                        writer.write(this.getProductAmount()+"@\n");
                        
                        update=true;
                    }
                }
                else{
                    System.out.println("this id is already exists ,please enter correct id");
                }
            }
            else{
                System.out.println("This product don't found");
            }
            
            //write in tempFile all products
            String Line;
            while((Line=reader.readLine())!=null){ //read from product file
                    if(Line.contains(this.getProductName())){ 
                        continue; 
                    }
                    writer.write(Line);
                    update=true;
            }
            writer.close();
            reader.close();
            
            f.delete();
              
            boolean UpdateSuccessful = TempFile.renameTo(f); //rename tempFile to original file 
            if(UpdateSuccessful)
                System.out.println("THE PRODUCT IS UPDATE ");
            else
                System.out.println("PLEASE TRY AGAIN");
            
            return update;
    }

       
    //method to check if id is unique or not
    private boolean uniqueID(int productID , String productName) throws IOException , FileNotFoundException{
        File f =new File("ProductFile.txt");
        FileReader f1 = new FileReader(f);
        BufferedReader reader=new BufferedReader(f1);
        String Line; boolean found=false;
        
        while((Line=reader.readLine())!=null)
        {
            String[] seperated = Line.split("@");
            
            if( Integer.parseInt(seperated[0]) == productID && seperated[1] == productName){
                found=true;
            }

            if( Integer.parseInt(seperated[0]) == productID && seperated[1] != productName){  //check id id is unique or not
                System.out.println("this id is already existed , Please enter correct id");
                found=false;
            }
                
                
        }
        reader.close();
        f1.close();
        if(found == true){
            return false;
        }
        else{
            return true;
        }
    }
  

    //method to check if product is existed or not
    private boolean SearchProductIfExist(String productName ) throws IOException {
       File f =new File("ProductFile.txt");
        FileReader f2=new FileReader(f);
        BufferedReader f3=new BufferedReader(f2);
        String line;
        boolean found=false;
        while((line=f3.readLine())!=null)
        {
            if(line.contains(productName))
            {
                found=true;
            }
        }
        
        f2.close();
        f3.close();
        
        if(found){
            return true;
        }else{
            return false;
        }
    }
          //get message when expiry date of product get close
    public void ExpirationWarning(int productDate , String productName){
           //will be done after making the database or files
    }
     
           //get message when product is lacking
    public boolean ShortageWarn() throws FileNotFoundException, IOException{
        File f =new File("ProductFile.txt");
        BufferedReader reader=new BufferedReader(new FileReader(f));
        
        String Line;
        while((Line=reader.readLine())!=null)
        {
            String[] seperated = Line.split("@");
            if( Integer.parseInt(seperated[3]) <=100){
                System.out.println(seperated[1]+" is lacking");
                return true;
            }
        }
        reader.close();
        return false;
    }
    
            //method to manage damage items
    public void DamageItem(int DamagedItem , String ProductName) throws FileNotFoundException, IOException{
        File f =new File("ProductFile.txt");
        File TempFile =new File("TempFile.txt");
        BufferedReader reader=new BufferedReader(new FileReader(f));
        PrintWriter  writer = new PrintWriter(new FileWriter(TempFile));
        
        String Line;   String Line1;
        
        while((Line=reader.readLine())!=null)
        {
            String[] seperated = Line.split("@");
            if( seperated[1].equals(ProductName)){
                 int numAmount = Integer.parseInt(seperated[3]) - DamagedItem;
                 seperated[3] = Integer.toString(numAmount);
                 Line1 = seperated[0] + "@" + seperated[1] + "@" + seperated[2] + "@" + seperated[3] + "@" + seperated[4] + "@" ;
                 writer.println(Line1);
            }
            else {
                writer.println(Line);
            }
        }
         
        writer.close();
        reader.close();
        
        f.delete();
        TempFile.renameTo(f);
    }
    
    
    
    //method to manage items that is sold
    //in the marketing class when make an order use this method
    public void soldItems(int numOfitems , String ProductName) throws FileNotFoundException, IOException{
        File f =new File("ProductFile.txt");
        File TempFile =new File("TempFile.txt");
        BufferedReader reader=new BufferedReader(new FileReader(f));
        PrintWriter  writer = new PrintWriter(new FileWriter(TempFile));
        
        String Line;   String Line1;
        
        while((Line=reader.readLine())!=null)
        {
            String[] seperated = Line.split("@");
            if( seperated[1].equals(ProductName)){
                 int numAmount = Integer.parseInt(seperated[3]) - numOfitems;
                 seperated[3] = Integer.toString(numAmount);
                 Line1 = seperated[0] + "@" + seperated[1] + "@" + seperated[2] + "@" + seperated[3] + "@" + seperated[4] + "@" ;
                 writer.println(Line1);
            }
            else {
                writer.println(Line);
            }
        }
         
        writer.close();
        reader.close();
        
        f.delete();
        TempFile.renameTo(f);
    }
    
    
    //method to manage return items from sales
    //in the marketing class when cancel an order use this method
    public void returnFromSales(int numOfReturnedItems , String ProductName ) throws FileNotFoundException, IOException{
        File f =new File("ProductFile.txt");
        File TempFile =new File("TempFile.txt");
        BufferedReader reader=new BufferedReader(new FileReader(f));
        PrintWriter  writer = new PrintWriter(new FileWriter(TempFile));
        
        String Line;   String Line1;
        
        while((Line=reader.readLine())!=null)
        {
            String[] seperated = Line.split("@");
            if( seperated[1].equals(ProductName)){
                 int numAmount = Integer.parseInt(seperated[3]) + numOfReturnedItems;
                 seperated[3] = Integer.toString(numAmount);
                 Line1 = seperated[0] + "@" + seperated[1] + "@" + seperated[2] + "@" + seperated[3] + "@" + seperated[4] + "@" ;
                 writer.println(Line1);
            }
            else {
                writer.println(Line);
            }
        }
         
        writer.close();
        reader.close();
        
        f.delete();
        TempFile.renameTo(f);
    }
    
    
}