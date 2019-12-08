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
    private static double SumBeforeDiscount=0;
     private static double SumAfterDiscount=0;
     private int x=0;
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
            String[] seperate=Line.split("@");
             System.out.println(seperate[0]+seperate[1]+seperate[2]+seperate[3]);
    }
    reader.close();
    }        
          
            
    
    public void SearchForProducts(String ProductName)throws FileNotFoundException, IOException{
        try (Scanner reader = new Scanner(new File("ProductFile.txt"))) {
            Scanner input=new Scanner(System.in);
            while (reader.hasNext()){
                String Line=reader.nextLine();
                String[] seperate=Line.split("@");
                if(seperate[1].equals(ProductName)){
                        System.out.println("ID :" + seperate[0]+"Product Name :"+seperate[1]+"Product Price:"+seperate[2]+"Product Amount"+seperate[3]);
                        x=1;
                }
                
            }
            
            reader.close();
        }
        if(x==0){
            System.out.println("NOT EXIST");
        }
    }
    
    
     public void MadeOrder(String ProductName,int quantity)throws FileNotFoundException, IOException{
          Scanner input=new Scanner(System.in);
                try (Scanner reader = new Scanner(new File("ProductFile.txt"))) {
                while (reader.hasNext()){
                    String Line=reader.nextLine();
                    String[] seperate=Line.split("@");
                    if(seperate[1].equals(ProductName)){
                        super.soldItems(quantity,ProductName); 
                         System.out.println("price before discount : "+Integer.parseInt(seperate[2])*quantity);
                        System.out.println("price after discount : "+super.getProductFinalPrice()*quantity);
                        SumBeforeDiscount+= Integer.parseInt(seperate[2])*quantity;
                        SumAfterDiscount+=super.getProductFinalPrice()*quantity;
                    } 
                }
        }
     }

     public void EndOrder(){
          System.out.println("total before discount = "+SumBeforeDiscount);
                System.out.println("total shoud be payed = "+SumAfterDiscount);
                SumBeforeDiscount=0;
                SumAfterDiscount=0;
    }
     }