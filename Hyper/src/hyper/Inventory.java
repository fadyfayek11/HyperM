/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

import GUI.InventoryFrame;
import java.io.*;
import java.util.Date;  


/**
 *
 * @author mohra
 */


public class Inventory extends Products{

    
    //defult constractor
    public Inventory(){
        //InventoryFrame Invframe = new InventoryFrame();
    }

    /*main constractor*/
    public Inventory(Date productDate, String productName, int productID, int productAmount, double initialPrice, int discount) {
        super(productDate, productName, productID, productAmount, initialPrice, discount);
    }
    
       //SearchProduct
   public void SearchProduct(String productName ) throws IOException {
       File f =new File("ProductFile.txt");
        FileReader f2=new FileReader(f);
        BufferedReader f3=new BufferedReader(f2);
        String line;
        boolean found=false;
        while((line=f3.readLine())!=null)
        {
            if(line.contains(productName))
            {
                String[] l=line.split("@");
                for(String data:l)
                System.out.println(data);
            }
        }
        
        f2.close();
        f3.close();
    }
       
  
    
         //add product
    public void AddProducts(/*int date,*/ String name ,int productID , int amount , double productPrice , int discount) throws IOException,FileNotFoundException {
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
                    
                    if( Integer.parseInt(seperated[0]) == productID ){  //check id id is unique or not
                        System.out.println("this id is already existed ,Please enter correct id");
                        found=true;
                        break;
                    }
                    
                    if( seperated[1].equals(name) ){ //check not repeat product name
                        System.out.println("this product name is already existed");
                        found=true;
                        break;
                    }

                }
                if(!found){
                    f1.write(productID+"@");
                    f1.write(name+"@");
                   //f1.write(date+"@");
                    f1.write(productPrice+"@");
                    f1.write(amount+"@");
                    f1.write(discount+"@\n");
                    f1.close();
                }
                f3.close();
                f1.close();
                f2.close();
            }
    }
            

    
    
         //remove product
    public void DeleteProduct(String productName) throws IOException{
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
            if(DeleteSuccessful)
                System.out.println("THE PRODUCT DELETED IS SUCCESSFULLY ");
            else
                System.out.println("ENTER CORRECT PRODUCT-ID AND PRODUCT-NAME ");
    }
    
    //List Products
    public void ListProduct() throws FileNotFoundException, IOException{
            File f = new File("ProductFile.txt");
            BufferedReader reader = new BufferedReader(new FileReader(f));
            
            String line;
            
            while( (line=reader.readLine())!=null ){
                String[] l=line.split("@");
                for(String lists:l)
                {
                 System.out.println(lists);   
                }
            }
            reader.close();
        }
    
          //update product
    public void UpdateProduct(String productName , int productID , double productPrice, int productAmount /*,Date productDate*/ , int discount) throws IOException , FileNotFoundException{
            File f =new File("ProductFile.txt");
            File TempFile= new File("TempFile.txt");
            BufferedReader reader=new BufferedReader(new FileReader(f));
            PrintWriter  writer =new PrintWriter(new FileWriter(TempFile));
            
            //Check if product is already exists in the ProductFile or not
            if( this.SearchProductIfExist(productName) ){
                
                if( this.uniqueID(productID)){ //Check if id is unique
                    if(TempFile.exists()){
                        writer.write(productID+"@");
                        writer.write(productName+"@");
                        /*writer.write(productDate+"@");*/
                        writer.write(productPrice+"@");
                        writer.write(productAmount+"@");
                        writer.write(discount+"@\n");
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
                    if(Line.contains(productName)){ 
                        continue; 
                    }
                    writer.write(Line);
            }
            writer.close();
            reader.close();
            
            f.delete();
              
            boolean UpdateSuccessful = TempFile.renameTo(f); //rename tempFile to original file 
            if(UpdateSuccessful)
                System.out.println("THE PRODUCT IS UPDATE ");
            else
                System.out.println("PLEASE TRY AGAIN");
    }

       
    //method to check if id is unique or not
    private boolean uniqueID(int productID) throws IOException , FileNotFoundException{
        File f =new File("ProductFile.txt");
        FileReader f1 = new FileReader(f);
        BufferedReader reader=new BufferedReader(f1);
        String Line; boolean found=false;
        while((Line=reader.readLine())!=null)
        {
            String[] seperated = Line.split("@");
                if( Integer.parseInt(seperated[0]) == productID ){  //check id id is unique or not
                    System.out.println("this id is already existed ,Please enter correct id");
                    found=true;
                    break;
                }
        }
        reader.close();
        f1.close();
        if(found)
            return false;
        else
            return true;
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
    public void ShortageWarn() throws FileNotFoundException, IOException{
        File f =new File("ProductFile.txt");
        BufferedReader reader=new BufferedReader(new FileReader(f));
        
        String Line;
        while((Line=reader.readLine())!=null)
        {
            String[] seperated = Line.split("@");
            if( Integer.parseInt(seperated[3]) <=100){
                System.out.println(seperated[1]+" is lacking");
            }
        }
        reader.close();
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
