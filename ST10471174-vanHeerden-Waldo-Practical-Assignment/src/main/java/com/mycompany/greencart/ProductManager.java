/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.greencart;
import java.util.*;
/**
 *
 * @author lab_services_student
 */
public class ProductManager {
    ArrayList<Product> ProductCatalog = new ArrayList<>(); //Declares an arraylist of Product named ProductCatalog where all of the different products will be stored in
    ArrayList<Integer> Cart = new ArrayList<>(); //Stores product IDs added to the user's cart in order for it to be retrieved later

    
    public boolean ValidateProductQuality(char ProductQuality){ //Validates whether the product quality value entered was valid or not. It must be either bad (B), Good (G) or Like New (N) 
        boolean ProductQualityValid = false;
        if (Character.toUpperCase(ProductQuality) == 'B' || Character.toUpperCase(ProductQuality) == 'G' || Character.toUpperCase(ProductQuality) == 'N' ){
            ProductQualityValid=true;
        }
       return ProductQualityValid; 
    }
    
    public boolean ValidateEnvironmentalScore(int EnvironmentalScore) { //Validates the environmental score of a product.* Score must be between 0 and 10 (inclusive)

        boolean ScoreValid = false;
        
        if (EnvironmentalScore>=0 && EnvironmentalScore<=10) {
            ScoreValid=true;
        }
        
        return ScoreValid;
    }
    
    public String AddProduct(int ProductID, String ProductName, String ProductCategory, double ProductPrice, int EnvironmentalScore, int ProductType, int ProductAge, char ProductQuality){ //Adds a product to the catalog. Differentiates between normal and refurbished products based on ProductType.
     
        String Message = null;
        
        if (ProductType==0) { //If the value stored in ProductType is 0, then treat the product entered as a normal product
            if (ValidateEnvironmentalScore(EnvironmentalScore) == true) {
            ProductCatalog.add(new Product(ProductID, ProductName, ProductCategory, ProductPrice, EnvironmentalScore));
            Message = "The product has been successfully added!";
            } else {
                Message = "The environmental score you entered is invalid! Please try again.";
            }
            
        } else { //If any other value is stored in ProductType instead of 0, then treat the product as a refurbished product
            if (ValidateProductQuality(ProductQuality) == true && ValidateEnvironmentalScore(EnvironmentalScore) == true){
                ProductCatalog.add(new RefurbishedProduct(ProductID, ProductName, ProductCategory, ProductPrice, EnvironmentalScore, ProductAge, ProductQuality));
                Message = "The refurbished product has been successfully added!";
            } else {
                Message = "The value entered is invalid! Please try again.";
            }
        }
      
        return Message;
    }
    
    public String SearchProductCatalog(int ProductID){ //Searches for a product in the catalog by its ID. Returns product details or a not-found message.
     

        String ProductDetails = null;
        boolean ProductFound =false;
        
        for (Product ProductSearch: ProductCatalog) {
            if (ProductSearch.getProductID() == ProductID){
                ProductDetails = ProductSearch.DisplayProductDetails();
                ProductFound=true;
                break;
            }
        }
        if (ProductFound==false){
            ProductDetails="The product that you were looking for was not found. Please try again.";
        }
        
        
        return ProductDetails;
    }
    
   public boolean UpdateProductInfo(int ProductID, String ProductName, String ProductCategory, double ProductPrice, int EnvironmentalScore, int ProductType, int ProductAge, char ProductQuality){ //Updates product information based on its type. Returns true if the update was successful.


       boolean ProductUpdated = false;
       
        if (ProductType==0) { //If the value stored in ProductType is 0, then treat the product entered as a normal product
            if (ValidateEnvironmentalScore(EnvironmentalScore) == true) {
                for (Product ProductDetails: ProductCatalog) {
                    if (ProductDetails.getProductID() == ProductID){
                        ProductDetails.setProductName(ProductName);
                        ProductDetails.setProductCategory(ProductCategory);
                        ProductDetails.setProductPrice(ProductPrice);
                        ProductDetails.setEnvironmentalScore(EnvironmentalScore);
                        ProductUpdated=true;
                        break;
                    }
                }
            } 
        } else { //If any other value is stored in ProductType instead of 0, then treat the product as a refurbished product
            if (ValidateProductQuality(ProductQuality) == true && ValidateEnvironmentalScore(EnvironmentalScore) == true){
                for (Product ProductDetails: ProductCatalog){
                    if (ProductDetails instanceof RefurbishedProduct) {
                        RefurbishedProduct RefurbishedProductDetails = (RefurbishedProduct) ProductDetails;
                        if (RefurbishedProductDetails.getProductID() == ProductID){
                            RefurbishedProductDetails.setProductName(ProductName);
                            RefurbishedProductDetails.setProductCategory(ProductCategory);
                            RefurbishedProductDetails.setProductPrice(ProductPrice);
                            RefurbishedProductDetails.setEnvironmentalScore(EnvironmentalScore);
                            RefurbishedProductDetails.setProductAge(ProductAge);
                            RefurbishedProductDetails.setProductQuality(ProductQuality);
                            ProductUpdated=true;
                            break;
                        }
                    }
                }
                
            }
        }
       
       return ProductUpdated;
   }
   
   public boolean DeleteProduct(int ProductID){ //Deletes a product from the catalog by its ID. Returns true if deletion was successful
        boolean ProductDeleted = false;
        for (Product ProductDetails : ProductCatalog) {
            if (ProductDetails.getProductID() == ProductID) {
                ProductCatalog.remove(ProductDetails);
                ProductDeleted=true;
                break;
            }
        }    
        return ProductDeleted;
   }
   

   public String DisplayProductCatalog(){ //Displays all the products in the catalog. It also separates the product that are refurbished or not
       StringBuilder  productDetails = new StringBuilder();
        String ProductList = null;
        productDetails.append("\n---------------------------------");
        if (ProductCatalog.isEmpty() == true) {
            productDetails.append("No product has been added.");
        } else {
            int ProductCount=0;
            int RefurbishedProductCount = 0;
            for (Product ProductDetails: ProductCatalog) {
                if (ProductDetails instanceof RefurbishedProduct){
                    RefurbishedProductCount++;
                    RefurbishedProduct RefurbishedProductDetails = (RefurbishedProduct) ProductDetails;
                    productDetails.append("\nRefurbished Product " + RefurbishedProductCount);
                    productDetails.append("\n---------------------------------");
                    productDetails.append(RefurbishedProductDetails.DisplayProductDetails());
                } else {
                    ProductCount++;
                    productDetails.append("\nProduct " + ProductCount);
                    productDetails.append("\n---------------------------------");
                    productDetails.append(ProductDetails.DisplayProductDetails());
                }
            }

        }
        ProductList = productDetails.toString();
        return ProductList;
    }

public boolean AddToCart(int ProductID) { //Adds a product to the cart by its ID. Returns true if the product was successfully added.
    boolean ProductAdded = false;
    for (Product ProductDetails: ProductCatalog) {
        if (ProductDetails instanceof RefurbishedProduct) {
            RefurbishedProduct RefurbishedProductDetails = (RefurbishedProduct) ProductDetails;
            if (RefurbishedProductDetails.getProductID() == ProductID) {
                Cart.add(ProductID);
                ProductAdded=true;
            }
        } else {
            if (ProductDetails.getProductID() == ProductID) {
                Cart.add(ProductID);
                ProductAdded=true;
            }
        }
    }
    return ProductAdded;
}
    
public String ViewCart() { //Displays the contents of the cart. Shows product details for each item.
    StringBuilder ListCart = new StringBuilder();
    String CartList = null;
    int Count = 0;
    
    ListCart.append("Your cart:\n\n---------------------------");
    if (!Cart.isEmpty()) {
        while (Count<Cart.size()) {
            ListCart.append(SearchProductCatalog(Cart.get(Count)));
            Count++;
        }
    } else {
        ListCart.append("\nYour cart is currently empty.");
    }

    CartList=ListCart.toString();
    return CartList;
}

public void RemoveItemFromCart(int ProductID) { //Removes the item from the cart based on the ID specified. The ID here is used to indicate what position the product was stored in the cart in.
    Cart.remove(ProductID);
}
    
public String BuyItemsInCart(){ //Orders all items in the cart and removes them from said cart
    Cart.clear();
    return "Your cart has been ordered! Thank you for shopping with us!";
}
    
   
}
