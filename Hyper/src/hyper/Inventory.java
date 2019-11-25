/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

/**
 *
 * @author mohra
 */
public class Inventory extends Products{
    
    //defult constractor
    public Inventory(){
        
    }
    
         //add product
    public void AddProducts(int date, String name ,int productid , int amount , double productprice){
        //will be done after making the database or files
    }
    
         //remove product
    public void DeleteProduct(String productname , int productid){
        //will be done after making the database or files
    }
              
          //get message when expiry date of product get close
    public void ExpirationWarning(int date , String product){
           //will be done after making the database or files
    }
     
           //get message when product is lacking
    public void ShortageWarn(int amount , String productname){
           //will be done after making the database or files
    }
    
}
