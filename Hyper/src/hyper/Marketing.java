/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author mohra
 */
public class Marketing extends Sales {
     
    //main constractor
    public Marketing(String productDate, String productName, int productID, int productAmount, double initialPrice, int discount) throws ParseException {
        super(productDate , productName , productID , productAmount , initialPrice);
        this.setDiscount(discount);
    }
    
    //default constractor
    public Marketing() {
    }

    
     //method make discount
    public void discount(int discount , int productID ) throws IOException{
        this.setDiscount(discount);
        
        File f =new File("ProductFile.txt");  
        File TempFile= new File("TempFile.txt");
        BufferedReader reader=new BufferedReader(new FileReader(f));
        PrintWriter  writer =new PrintWriter(new FileWriter(TempFile));
        double productFinalPrice = 0;
        String line;
        while((line=reader.readLine())!=null){
                String[] seperated = line.split("@");
                
                if( Integer.parseInt(seperated[0]) == productID ){
                    this.setInitialPrice(Double.parseDouble(seperated[3]));
                    this.setProductFinalPrice(productFinalPrice);
                    seperated[3] = Double.toString(this.getProductFinalPrice());
                    line = seperated[0]+"@"+seperated[1]+"@"+seperated[2]+"@"+seperated[3]+"@"+seperated[4]+"@";
                    writer.println(line);    
                }
                else{
                    writer.println(line);
                }
        }
            
        reader.close();
        writer.close();
            
        f.delete();
        TempFile.renameTo(f);
            
    }
    
    //set reports
    public void report(){
        
    }
   
}


