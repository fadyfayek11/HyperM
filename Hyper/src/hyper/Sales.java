package hyper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author marti
 */
public class Sales extends Inventory{
    private double sum=0;
    
    //empty constructor
    public Sales(){}
    
    //main constructor
    public Sales(Date productDate, String productName, int productID, int productAmount, double initialPrice, int discount){
    super(productDate,productName, productID,  productAmount, initialPrice, discount);
    }
    
    
    
    
    public void ShowAllProducts()throws FileNotFoundException, IOException{
     Scanner reader=new Scanner(new File("ProductFile.txt"));
             
         while (reader.hasNext()){
            String Line=reader.nextLine();
            System.out.println(Line); 
    }
    reader.close();
    }        
          
            
    
    public void SearchForProducts(String ProductName)throws FileNotFoundException, IOException{
         Scanner reader=new Scanner(new File("ProductFile.txt"));
         Scanner input=new Scanner(System.in);
         while (reader.hasNext()){
             String Line=reader.nextLine();
             String[] seperate=Line.split("@");
             if(seperate[1].equals(ProductName)){
                 System.out.println("product exists  for data  enter 1");
                 int i=input.nextInt();
                 if(i==1)
                     System.out.println("ID :" + seperate[0]+"Product Name :"+seperate[1]+"Product Price:"+seperate[2]+"Product Amount"+seperate[3]);}
         }
    reader.close();
    }
    
    
     public void MadeOrder(String ProductName,int quantity)throws FileNotFoundException, IOException{
          Scanner input=new Scanner(System.in);
        Scanner reader=new Scanner(new File("ProductFile.txt"));
       while(ProductName!=null){
          while (reader.hasNext()){
         String Line=reader.nextLine();
         String[] seperate=Line.split("@");
         if(seperate[1].equals(ProductName)){
         System.out.println("prise : "+Integer.parseInt(seperate[2])*quantity);
         sum+= Integer.parseInt(seperate[2])*quantity;
         super.soldItems(quantity, ProductName);
      }
          ProductName=input.next();
          quantity=input.nextInt();
                        
      }
      System.out.println("total should be payed = "+sum);
      sum=0;
       }
       reader.close();
     }
     
    }