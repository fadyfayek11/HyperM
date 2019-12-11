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
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mohra
 */
public class Marketing extends Products {
  private int discount;
     private String m;
     private String list;
     
    //default constractor
    public Marketing() {
    }
  
    //set reports about products 
 public void ListofProducts() throws FileNotFoundException, IOException{
            File f = new File("ProductFile.txt");
            BufferedReader reader = new BufferedReader(new FileReader(f));
            
           
            while( (m=reader.readLine())!=null ){
                String[] l=m.split("#");
                for(String list:l)
                {
                 System.out.println(list);  
                 
         System.out.println("inter product name");
         Scanner reports= new Scanner("ProductFile.txt");
         System . out. println(reports.next());
     
                }
            }
            reader.close();
        }
   
 
     //method make discount
    public void discount(){

    }
   
}

