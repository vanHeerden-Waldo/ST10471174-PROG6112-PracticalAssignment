/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencart;

/**
 *
 * @author lab_services_student
 */
public class Product {
    private int ProductID;
    private String ProductName;
    private String ProductCategory;
    private double ProductPrice;
    private int EnvironmentalScore;
    
    public Product(int productID, String productName, String productCategory, double productPrice, int environmentalScore){ //Constructor for class Product
        ProductID = productID;
        ProductName=productName;
        ProductCategory=productCategory;
        ProductPrice=productPrice;
        EnvironmentalScore=EnvironmentalScore;
    }
    
    
    public void setProductName(String ProductName) { //Mutator for ProductName variable
        this.ProductName=ProductName;
    }
    
    public void setProductCategory(String ProductCategory){ //Mutator for Product category variable
        this.ProductCategory=ProductCategory;
    }
    
    public void setProductPrice(double ProductPrice){ //Mutator for the product price variable
        this.ProductPrice=ProductPrice;
    }
    
    public void setEnvironmentalScore(int EnvironmentalScore){
        this.EnvironmentalScore=EnvironmentalScore;
    }
    
    public int getProductID(){ //Accessor for the Produt ID variable
        return ProductID;
    }
    
    public String getProductName(){
        return ProductName;
    }
    
    public String getProductCategory(){
        return ProductCategory;
    }
    
    public double getProductPrice(){
        return ProductPrice;
    }
    
    public int getEnvironmentalScore(){
        return EnvironmentalScore;
    }
    
    public String DisplayProductDetails() {
        StringBuilder ProductInfo = new StringBuilder();
        String ProductDetails = null;
        
        ProductInfo.append("Product ID: " + ProductID);
        ProductInfo.append("Product Name: " + ProductName);
        ProductInfo.append("Product Category: " + ProductCategory);
        ProductInfo.append("Product Price: R" + ProductPrice);
        ProductInfo.append("Product's Environmental Score: " + EnvironmentalScore);
        
        ProductDetails=ProductInfo.toString();
        return ProductDetails;
    }
}
