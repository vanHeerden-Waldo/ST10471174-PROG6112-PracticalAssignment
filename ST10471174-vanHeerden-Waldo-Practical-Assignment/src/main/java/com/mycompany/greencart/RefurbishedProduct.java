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
    
    public RefurbishedProduct(int productID, String productName, String productCategory, double productPrice, int environmentalScore, int productAge, char productQuality) { //Constructor method for the class
        super(productID, productName, productCategory, productPrice, environmentalScore);
        ProductAge=productAge;
        ProductQuality=productQuality;
    }
    
    public void setProductAge(int ProductAge){ //Mutator for ProductAge variable
        this.ProductAge=ProductAge;
    }
    
    public void setProductQuality(char ProductQuality){ //Mutator for ProductQuality variable
        this.ProductQuality=ProductQuality;
    }
    
    public int getProductAge(){ //Accessor for ProductAge variable
        return ProductAge;
    }
    
    public char getProductQuality(){ //Accessor for ProductQuality variable
        return ProductQuality;
    }
   
    @Override
    public String DisplayProductDetails(){ //This method returns all the details of the product if it was stored as a refurbished product
        StringBuilder ProductInfo = new StringBuilder();
        String ProductDetails = null;
        
        ProductInfo.append("\nRefurbished Product ID: " + getProductID());
        ProductInfo.append("\nRefurbished Product Name: " + getProductName());
        ProductInfo.append("\nRefurbished Product Category: " + getProductCategory());
        ProductInfo.append("\nRefurbished Product Price: R" + getProductPrice());
        ProductInfo.append("\nRefurbished Product's Environmental Score: " + getEnvironmentalScore());
        ProductInfo.append("\nAge of the Refurbished Product: " + ProductAge + " years old");
        switch (ProductQuality) {
            case 'B':
                ProductInfo.append("\nCondition of Refurbished Product: Bad");
                break;
            case 'G':
                ProductInfo.append("\nCondition of Refurbished Product: Good");
                break;
            case 'N':
                ProductInfo.append("\nCondition of Refurbished Product: Like New");
                break;
        }
        ProductInfo.append("\n---------------------------------");
        
        ProductDetails=ProductInfo.toString();
        return ProductDetails;
    }
    
    
    
}
