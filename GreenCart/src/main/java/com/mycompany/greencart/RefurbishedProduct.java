/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencart;

/**
 *
 * @author lab_services_student
 */
public class RefurbishedProduct extends Product {
    private int ProductAge;
    private char ProductQuality;
    
    public RefurbishedProduct(int productID, String productName, String productCategory, double productPrice, int environmentalScore, int productAge, char productQuality) {
        super(productID, productName, productCategory, productPrice, environmentalScore);
        ProductAge=productAge;
        ProductQuality=productQuality;
    }
    
    public void setProductAge(int ProductAge){
        this.ProductAge=ProductAge;
    }
    
    public void setProductQuality(char ProductQuality){
        this.ProductQuality=ProductQuality;
    }
    
    public int getProductAge(){
        return ProductAge;
    }
    
    public char getProductQuality(){
        return ProductQuality;
    }
   
    @Override
    public String DisplayProductDetails(){
        StringBuilder ProductInfo = new StringBuilder();
        String ProductDetails = null;
        
        ProductInfo.append("Product ID: " + getProductID());
        ProductInfo.append("Product Name: " + getProductName());
        ProductInfo.append("Product Category: " + getProductCategory());
        ProductInfo.append("Product Price: R" + getProductPrice());
        ProductInfo.append("Product's Environmental Score: " + getEnvironmentalScore());
        ProductInfo.append("Age of the Product: " + ProductAge + " years old");
        switch (ProductQuality) {
            case 'B':
                ProductInfo.append("Condition of Product: Bad");
                break;
            case 'G':
                ProductInfo.append("Condition of Product: Good");
                break;
            case 'N':
                ProductInfo.append("Condition of Product: Like New");
                break;
        }
        
        ProductDetails=ProductInfo.toString();
        return ProductDetails;
    }
    
    
    
}
