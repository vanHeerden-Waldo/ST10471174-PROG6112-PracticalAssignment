/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.greencart;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class ProductManagerTest {
    ProductManager User = new ProductManager();
    public ProductManagerTest() {
    }

    /**
     * Test of ValidateProductQuality method, of class ProductManager.
     */
    @Test
    public void testValidateProductQuality_Valid() {
      boolean Result = User.ValidateProductQuality('N');
      assertTrue(Result);
    }

    /*
    * Test of ValidateProductQuality method, of class ProductManager.
    */
    @Test
    public void testValidateProductQuality_Invalid() {
        boolean Result = User.ValidateProductQuality('D');
        assertFalse(Result);
    }
    
    /**
     * Test of ValidateEnvironmentalScore method, of class ProductManager.
     */
    @Test
    public void testValidateEnvironmentalScore_Valid() {
        boolean Result = User.ValidateEnvironmentalScore(3);
        assertTrue(Result);
    }

    /**
     * Test of ValidateEnvironmentalScore method, of class ProductManager.
     */
    @Test
    public void testValidateEnvironmentalScore_InValid() {
        boolean Result = User.ValidateEnvironmentalScore(12);
        assertFalse(Result);
    }
    
    /**
     * Test of AddProduct method, of class ProductManager.
     */
    @Test
    public void testAddProduct_NormalProductSuccessfullyAdded() {
        String Result = User.AddProduct(0, "iPhone", "Technology", 99, 5, 0, 0, 'N');
        String Expected = "The product has been successfully added!";
        assertEquals(Expected, Result);
    }

    /**
     * Test of AddProduct method, of class ProductManager.
     */
    @Test
    public void testAddProduct_NormalProductFailedToAdd() {
        String Result = User.AddProduct(0, "iPhone", "Technology", 99, 12,0,0,'N');
        String Expected = "The environmental score you entered is invalid! Please try again.";
        assertEquals(Expected, Result);
    }
    
    /**
     * Test of AddProduct method, of class ProductManager.
     */
    @Test
    public void testAddProduct_RefurbishedProductSuccessfullyAdded() {
        String Result = User.AddProduct(0, "iPhone", "Technology", 99, 5, 1, 1, 'N');
        String Expected = "The refurbished product has been successfully added!";
        assertEquals(Expected, Result);
    }
    
    /**
     * Test of AddProduct method, of class ProductManager.
     */
    @Test
    public void testAddProduct_RefurbishedProductInvalidEnvironmentalScore() {
        String Result = User.AddProduct(0, "iPhone", "Technology", 99, 12, 1, 5, 'N');
        String Expected = "The value entered is invalid! Please try again.";
        assertEquals(Expected, Result);
    }
    
    /**
     * Test of AddProduct method, of class ProductManager.
     */
    @Test
    public void testAddProduct_RefurbishedProductInvalidProductQuality() {
        String Result = User.AddProduct(0, "iPhone", "Technology", 99, 5, 1, 5, 'D');
        String Expected = "The value entered is invalid! Please try again.";
        assertEquals(Expected, Result);
    }
    
    /**
     * Test of SearchProductCatalog method, of class ProductManager.
     */
    @Test
    public void testSearchProductCatalog_ProductFound() {
        User.AddProduct(0, "iPhone", "Technology", 99, 5, 0, 0, 'N');
        String Result = User.SearchProductCatalog(0);
        String Expected = "\nProduct ID: 0\nProduct Name: iPhone\nProduct Category: Technology\nProduct Price: R99.0\nProduct's Environmental Score: 5";
        assertEquals(Expected, Result);
    }
    
    /**
     * Test of SearchProductCatalog method, of class ProductManager.
     */
    @Test
    public void testSearchProductCatalog_ProductNotFound() {
        User.AddProduct(0, "iPhone", "Technology", 99, 5, 0, 0, 'N');
        String Result = User.SearchProductCatalog(1);
        String Expected = "The product that you were looking for was not found. Please try again.";
        assertEquals(Expected, Result);
    }

    /**
     * Test of UpdateProductInfo method, of class ProductManager.
     */
    @Test
    public void testUpdateProductInfo_NormalProductSuccess() {
        User.AddProduct(0, "iPhone", "Technology", 99, 5, 0, 0, 'N');
        Boolean Result = User.UpdateProductInfo(0, "iPad", "Tablets", 59, 5, 0, 0, 'N');
        assertTrue(Result);
    }
    
    /**
     * Test of UpdateProductInfo method, of class ProductManager.
     */
    @Test
    public void testUpdateProductInfo_RefurbishedProductSuccess() {
        User.AddProduct(0, "iPhone", "Technology", 99, 5, 1, 2, 'G');
        Boolean Result = User.UpdateProductInfo(0, "iPad", "Tablets", 59, 5, 1, 4, 'N');
        assertTrue(Result);
    }

    /**
     * Test of UpdateProductInfo method, of class ProductManager.
     */
    @Test
    public void testUpdateProductInfo_Failed() {
        User.AddProduct(0, "iPhone", "Technology", 99, 4, 1, 3, 'B');
        Boolean Result = User.UpdateProductInfo(1, "iPad", "Technology", 59, 3, 1, 5, 'G');
        assertFalse(Result);
    }
    
    /**
     * Test of DeleteProduct method, of class ProductManager.
     */
    @Test
    public void testDeleteProduct_Success() {
        User.AddProduct(1, "iPhone", "Technology", 99, 7, 0, 0, 'G');
        Boolean Result = User.DeleteProduct(1);
        assertTrue(Result);
    }
    
    /**
     * Test of DeleteProduct method, of class ProductManager.
     */
    @Test
    public void testDeleteProduct_Failed() {
        User.AddProduct(0, "iPhone", "Technology", 99, 7, 0, 0, 'N');
        Boolean Result = User.DeleteProduct(1);
        assertFalse(Result);
    }
    
    /**
     * Test of DisplayProductCatalog method, of class ProductManager.
     */
    @Test
    public void testDisplayProductCatalog() {
        User.AddProduct(0, "iPhone", "Technology", 99, 7, 0, 0, 'N');
        String Result = User.DisplayProductCatalog();
        String Expected = "\n---------------------------------\nProduct 1\n---------------------------------\nProduct ID: 0\nProduct Name: iPhone\nProduct Category: Technology\nProduct Price: R99.0\nProduct's Environmental Score: 7";
        assertEquals(Expected, Result);
    }

    /**
     * Test of AddToCart method, of class ProductManager.
     */
    @Test
    public void testAddToCart_Success() {
        User.AddProduct(1, "iPhone", "Technology", 99, 6, 0, 0, 'N');
        Boolean Result = User.AddToCart(1);
        assertTrue(Result);
    }
    
    /**
     * Test of AddToCart method, of class ProductManager.
     */
    @Test
    public void testAddToCart_Failed() {
        User.AddProduct(1, "iPhone", "Technology", 99, 6, 0, 0, 'N');
        Boolean Result = User.AddToCart(0);
        assertFalse(Result);
    }

    /**
     * Test of ViewCart method, of class ProductManager.
     */
    @Test
    public void testViewCart_ItemsAdded() {
        User.AddProduct(0, "iPhone", "Technology", 99, 5, 0, 0, 'N');
        User.AddToCart(0);
        String Result = User.ViewCart();
        String Expected = "Your cart:\n\n---------------------------\nProduct ID: 0\nProduct Name: iPhone\nProduct Category: Technology\nProduct Price: R99.0\nProduct's Environmental Score: 5";
        assertEquals(Expected, Result);
    }
    
    /**
     * Test of ViewCart method, of class ProductManager.
     */
    @Test
    public void testViewCart_NoItemsAdded() {
        String Result = User.ViewCart();
        String Expected = "Your cart:\n\n---------------------------\nYour cart is currently empty.";
        assertEquals(Expected, Result);
    }

    /**
     * Test of RemoveItemFromCart method, of class ProductManager.
     */
    @Test
    public void testRemoveItemFromCart() {
        User.AddProduct(0, "iPhone", "Technology", 99, 5, 0, 0, 'N');
        User.AddToCart(0);
        User.RemoveItemFromCart(0);
        String Result = User.ViewCart();
        String Expected = "Your cart:\n\n---------------------------\nYour cart is currently empty.";
        assertEquals(Expected, Result);
    }

    /**
     * Test of BuyItemsInCart method, of class ProductManager.
     */
    @Test
    public void testBuyItemsInCart() {
        String Result = User.BuyItemsInCart();
        String Expected = "Your cart has been ordered! Thank you for shopping with us!";
        assertEquals(Expected, Result);
    }
    
}
