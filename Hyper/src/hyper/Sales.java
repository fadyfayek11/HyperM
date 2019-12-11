package hyper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
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
    
    
    public int NoOfProducts()throws FileNotFoundException, IOException{
        LineNumberReader reader=new LineNumberReader(new FileReader("ProductFile.txt"));
   
    int i;
    String Line;
    while((Line=reader.readLine())!=null){}
        i=reader.getLineNumber();
        reader.close();
        return i;
    }
    
    
    
    public String[] ShowAllProducts()throws FileNotFoundException, IOException{
     Scanner reader=new Scanner(new File("ProductFile.txt"));
     int x=this.NoOfProducts();
          String [] arr =new  String[x];
          int i=0;
         while (reader.hasNext()){
                 String Line=reader.nextLine();
                 String[] seperate=Line.split("@");
                 arr [i]= "     "+seperate[0]+"                                                                                                     "+seperate[1]+"                                                                                                     "+ seperate[2]+ "                                                                                                     "+seperate[3]+"                                                                                                     "+ seperate[4];
                  i++; 
            
             }
             
         return arr;
    }       
          
            
    
    public String[] SearchForProducts(String ProductName)throws FileNotFoundException,IOException{
        String [] arr =new  String[1];
        try (Scanner reader = new Scanner(new File("ProductFile.txt"))) {
            Scanner input=new Scanner(System.in);
            
         while (reader.hasNext()){
                 String Line=reader.nextLine();
                 String[] seperate=Line.split("@");
                
                   if(seperate[1].equals(ProductName)){
                        arr [0]= "     "+seperate[0]+"                               "+seperate[1]+"                                       "+ seperate[2]+ "                                 "+seperate[3]+"                                  "+ seperate[4];
                        x=1;
                }
            
             }
             if(x==0){
            arr[0]="DOES NOT EXIST";
        } 
         reader.close();
            }
            
            return arr;
        }
       
    
    
    
     public void MadeOrder(String ProductName,int quantity)throws FileNotFoundException, IOException{
         File f =new File("ProductFile.txt");
        File TempFile =new File("TempFile.txt");
          BufferedReader reader=new BufferedReader(new FileReader(f));
        PrintWriter  writer = new PrintWriter(new FileWriter(TempFile));
        String Line; 
        String Line1;
                while ((Line=reader.readLine())!=null){
                    String[] seperate=Line.split("@");
                    if(seperate[1].equals(ProductName)){
                         System.out.println("price before discount : "+Integer.parseInt(seperate[2])*quantity);
                        System.out.println("price after discount : "+super.getProductFinalPrice()*quantity);
                        SumBeforeDiscount+= Integer.parseInt(seperate[2])*quantity;
                        SumAfterDiscount+=super.getProductFinalPrice()*quantity;
                        int numAmount = Integer.parseInt(seperate[3]) - quantity;
                        seperate[3] = Integer.toString(numAmount);
                          Line1 = seperate[0] + "@" + seperate[1] + "@" + seperate[2] + "@" + seperate[3] + "@" +seperate[4] ;
                         writer.println(Line1);
                    } 
                    else{
                        writer.println(Line);
                    }
                }
                 writer.close();
                 reader.close();
                 f.delete();
                 TempFile.renameTo(f);

        }
                


     public void EndOrder(){
          System.out.println("total before discount = "+SumBeforeDiscount);
                System.out.println("total shoud be payed = "+SumAfterDiscount);
                SumBeforeDiscount=0;
                SumAfterDiscount=0;
    }
     
     
     
     
     public void returnFromSales(int quantity , String ProductName ) throws FileNotFoundException, IOException{
        File f =new File("ProductFile.txt");
        File TempFile =new File("TempFile.txt");
        BufferedReader reader=new BufferedReader(new FileReader(f));
        PrintWriter  writer = new PrintWriter(new FileWriter(TempFile));
        
        String Line;   String Line1;
        
        while((Line=reader.readLine())!=null)
        {
            String[] seperated = Line.split("@");
            if( seperated[1].equals(ProductName)){
                 int numAmount = Integer.parseInt(seperated[3]) + quantity;
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








