/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

import java.io.*;
import java.util.Date;  


/**
 *
 * @author mohra
 */


public class Inventory extends Products{

    
    //defult constractor
    public Inventory(){
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
                found=true;
            }
        }
        if(!found){
            System.out.println("NOT FOUND");
        }
        f2.close();
        f3.close();
    }
       
  
    
         //add product
    public void AddProducts(/*int date,*/ String name ,int productid , int amount , double productprice) throws IOException,FileNotFoundException {
            File f =new File("ProductFile.txt");
            FileWriter f1 = new FileWriter(f,true);
            FileReader f2=new FileReader(f);
            BufferedReader f3=new BufferedReader(f2);
            String line;
            boolean found=false;
            
            if(f.exists()){
                while((line=f3.readLine())!=null)
                {
                    if(line.contains(name))
                    {
                        System.out.println("Already created");
                        found=true;
                    }
                }
                if(!found){
                    f1.write(productid+"@");
                    f1.write(name+"@");
                    //f1.write(date+"@");
                    f1.write(productprice+"@");
                    f1.write(amount+"@\n");
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
    public void UpdateProduct(String productName,int productID ,int productPrice, int productAmount , int discount) throws IOException{
            File f =new File("ProductFile.txt");
            File TempFile= new File("TempFile.txt");
            BufferedReader reader=new BufferedReader(new FileReader(f));
            PrintWriter  writer =new PrintWriter(new FileWriter(TempFile));
            BufferedReader reader1=new BufferedReader(new FileReader(TempFile));
            
            if(TempFile.exists()){
            writer.write(productID+"@");
            writer.write(productName+"@");
            writer.write(productAmount+"@");
            writer.write(productPrice+"@");
            }
            
            String line;
            String line2=reader1.readLine();
            
            while((line=reader.readLine())!=null){
                    if(line.contains(productName)){
                        writer.println(line2);
                        continue; 
                    }
                    writer.println(line);
            }
            
            reader.close();
            reader1.close();
            writer.close();
            
            f.delete();
            boolean UpdateSuccessful = TempFile.renameTo(f);
            if(UpdateSuccessful)
                System.out.println("THE PRODUCT IS UPDATE ");
            else
                System.out.println("PLEASE TRY AGAIN");
    
    }
       
              
          //get message when expiry date of product get close
    public void ExpirationWarning(int productDate , String productName){
           //will be done after making the database or files
    }
     
           //get message when product is lacking
    public void ShortageWarn(int productAmount , String productName){
           if(productAmount<=100){
               System.out.println(productName+" is lacking");
           }
    }
    
}
