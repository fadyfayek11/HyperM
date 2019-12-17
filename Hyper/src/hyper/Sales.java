package hyper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author marti
 */
public class Sales extends Inventory{
    private static double SumBeforeDiscount=0;
     private static double SumAfterDiscount=0;
     private int x=0;
     
     public Sales() {
    }
    //main constructor
    public Sales(String productDate, String productName, int productID, int productAmount, double initialPrice) throws ParseException{
    super(productDate,productName,  productID,  productAmount, initialPrice);
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
        int x=this.NoOfProducts(); 
        int i=0;
         String [] arr =new  String[x];
         try(Scanner reader=new Scanner(new File("ProductFile.txt"));){
              while (reader.hasNext()){
                 String Line=reader.nextLine();
                 String[] seperate=Line.split("@");
                 arr [i]= "     "+seperate[0]+"                                                                                   "+seperate[1]+"                                                                                     "+ seperate[2]+ "                                                                                    "+seperate[3]+"                                                                                    "+ seperate[4];
                  i++; 
            
             }
         }
     
     
         
         
        
             
         return arr;
    }       
          
            
    
    public String[] SearchForProducts(String ProductName)throws FileNotFoundException,IOException{
        String [] arr =new  String[1];
        try (Scanner reader = new Scanner(new File("ProductFile.txt"))) {
            
            
         while (reader.hasNext()){
                 String Line=reader.nextLine();
                 String[] seperate=Line.split("@");
                
                   if(seperate[1].equals(ProductName)){
                        arr [0]= "     "+seperate[0]+"                                    "+seperate[1]+"                                              "+ seperate[2]+ "                              "+seperate[3]+"                                 "+ seperate[4];
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
        PrintWriter  writer = new PrintWriter(new FileWriter(TempFile),true);
        String Line; 

        String Line1;
                while ((Line=reader.readLine())!=null){
              
                    String[] seperate=Line.split("@");
                    if(seperate[1].equals(ProductName)){
                        SumBeforeDiscount+= Double.parseDouble(seperate[3])*quantity;
                        SumAfterDiscount+=super.getProductFinalPrice()*quantity;
                        int numAmount = Integer.parseInt(seperate[4]) - quantity;
                        seperate[4] = Integer.toString(numAmount);
                          Line1 = seperate[0] + "@" + seperate[1] + "@" + seperate[2] + "@" + seperate[3] + "@" +seperate[4]+"@" ;
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
                 int numAmount = Integer.parseInt(seperated[4]) + quantity;
                 seperated[4] = Integer.toString(numAmount);
                 Line1 = seperated[0] + "@" + seperated[1] + "@" + seperated[2] + "@" + seperated[3] + "@" + seperated[4]+"@";
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
     
    
     public String[] EndOrder(){
        String arr[]=new String[2];
          arr[0]=Double.toString(SumBeforeDiscount);
               arr[1]=Double.toString(SumAfterDiscount);
                SumBeforeDiscount=0;
                SumAfterDiscount=0;
                
        return arr;
    }
     
     
     
}  
     
     
     
     
     








