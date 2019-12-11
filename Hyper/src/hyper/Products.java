/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

import java.util.*;

/**
 *
 * @author Ahmed Kamal
 */
public class Products {
   
    
   private Date productDate; //Please study the date datatype
   private String productName ;
   private int productID;
   private int productAmount ;
   private double initialPrice;
   private int discount ;
   private double productFinalPrice;

   //EMPTY CONSTRUCTOR 
    public Products() {
        
    }

    //The Main constructor
    public Products(Date productDate, String productName, int productID, int productAmount, double initialPrice, int discount) {   
        this.productDate = productDate;
        this.productName = productName;
        this.productID = productID;
        this.productAmount = productAmount;
        this.initialPrice = initialPrice;
        this.discount = discount;
    }

    //Setters and getters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public double getProductFinalPrice() {
        return productFinalPrice;
    }

    public void setProductFinalPrice(double productFinalPrice) {
        this.productFinalPrice = this.getInitialPrice()*(100-discount)/100;
    }
   
    
    
   
}


