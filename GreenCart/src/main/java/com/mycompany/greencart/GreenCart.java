/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.greencart;
import java.util.*;
/**
 *
 * @author lab_services_student
 */
public class GreenCart {

    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);
        System.out.println("PROBLEM THIS APP SOLVES\nConsumers usually struggle to make environmentally conscious choices while shopping. This app is intended to make it easier for consumers to track and manage their purchases based on environmental sustainability scores associated with the product.\n-----------------------------------------------\nPress enter to continue.");
        UserInput.nextLine();
        
        ProductManager User = new ProductManager();
        while(true) {
            System.out.println("GreenCart: An environmentally conscious shopping experience.\n----------------------------------");
            System.out.println("Select one of the options below: (Type 1,2,3, etc.)");
            System.out.println("(1) Add a new product to the shop.");
            System.out.println("(2) Search entire product catalog.");
            System.out.println("(3) Update the information of a product.");
            System.out.println("(4) Delete a product from the catalog.");
            System.out.println("(5) Display the entire product catalog.");
            System.out.println("(6) Add a product to your cart.");
            System.out.println("(7) View your cart.");
            System.out.println("(8) Remove an item from your cart.");
            System.out.println("(9) Checkout (Purchase the items in your cart)");
            System.out.println("(10) Exit the shopping app.");
            int UserChoice = UserInput.nextInt();
            UserInput.nextLine();
            switch (UserChoice) {
                case 1:
                    boolean ProductIDValid = false;
                    System.out.println("Is the product you want to add a refurbished product? Y/N");
                    String refurbishedproduct = UserInput.nextLine();
                    char Refurbishedproduct = refurbishedproduct.charAt(0);
                    boolean RefurbishedProduct = false;
                    if (Refurbishedproduct == 'Y' || Refurbishedproduct == 'y'){
                       RefurbishedProduct=true; 
                    }
                    System.out.print("Please enter the ID of the product you want to add: ");
                    while (ProductIDValid == false) {
                        if (UserInput.hasNextInt() == true) {
                            int ProductID=UserInput.nextInt();
                            ProductIDValid=true;
                        } else {
                            System.out.print("You have entered an invalid ID for your product. Your product ID can only consist of numbers. Please try again: ");
                            UserInput.nextLine();
                        }
                    }
                    
                    UserInput.nextLine();
                    System.out.print("Please enter the name of your product: ");
                    String ProductName=UserInput.nextLine();
                    
                    System.out.print("Please enter the category under which your product will fall: ");
                    String ProductCategory = UserInput.nextLine();
                    
                    boolean PriceValid = false;
                    System.out.print("Please enter the price of your product (In ZAR): R");
                    while (PriceValid == false) {
                        if (UserInput.hasNextDouble() == true) {
                            double ProductPrice = UserInput.nextDouble();
                            PriceValid=true;
                        } else {
                            System.out.print("The price you entered is invalid. It can only consist of numbers. Please try again: R");
                            UserInput.nextLine();
                        }
                    }
                    
                    UserInput.nextLine();
                    boolean EnvironmentalScoreValid=false;
                    System.out.print("Please enter an environmental score of your product that is between 0 and 10 (including 0 and 10): ");
                    while (EnvironmentalScoreValid==false){
                        if (UserInput.hasNextInt() == true ) {
                            int EnvironmentalScore = UserInput.nextInt();
                            if (User.ValidateEnvironmentalScore(EnvironmentalScore) == true) {
                                EnvironmentalScoreValid=true;
                            } else {
                                UserInput.nextLine();
                                System.out.print("The score you entered is invalid. It must be between 0 and 10 (Including 0 and 10). Please try again: ");
                                UserInput.nextLine();
                            }
                        } else {
                            System.out.print("The score you entered is invalid. It must be a number and between 0 and 10 (including 0 and 10). Please try again: ");
                            UserInput.nextLine();
                        }
                    }
                    int ProductType;
                    int ProductAge = 0;
                    char ProductQuality = 'N';
                    if (RefurbishedProduct == true){
                        ProductType = 1;
                        boolean ProductAgeValid =false;
                        System.out.print("Please enter the age of your refurbished product in years: ");
                        while (ProductAgeValid == false){
                            if (UserInput.hasNextInt() == true) {
                                ProductAge = UserInput.nextInt();
                                ProductAgeValid=true;
                            } else {
                                UserInput.nextLine();
                                System.out.print("The age that you entered is invalid. Please enter a number for the age in years: ");
                                UserInput.nextLine();
                            }
                        }
                        
                        UserInput.nextLine();
                        boolean ProductQualityValid = false;
                        System.out.print("Please enter the quality of your refurbished product (use B for Bad, G for Good, N for Like New): ");
                        String productQuality = UserInput.nextLine();
                        ProductQuality=productQuality.charAt(0);
                        while (ProductQualityValid == false){
                            switch (ProductQuality) {
                                case 'B' :
                                    ProductQualityValid=true;
                                    break;
                                case 'b':
                                    ProductQualityValid=true;
                                    break;
                                case 'N':
                                    ProductQualityValid=true;
                                    break;
                                case 'n':
                                    ProductQualityValid=true;
                                    break;
                                case 'G':
                                    ProductQualityValid=true;
                                    break;
                                case 'g':
                                    ProductQualityValid=true;
                                    break;
                            }
                        }
                    } else {
                        ProductType = 0;
                    }
                    System.out.println("");
                    System.out.println(User.AddProduct(ProductAge, ProductName, ProductCategory, ProductAge, ProductAge, ProductType, ProductAge, ProductQuality));
                    break;
                case 2:
                    boolean SearchProductIDValid = false;
                    int SearchProductID = 0;
                    System.out.println("Enter the ID of the product you want to search: ");
                    while (SearchProductIDValid==false) {
                        if (UserInput.hasNextInt() == true) {
                            SearchProductID = UserInput.nextInt();
                            SearchProductIDValid=true;
                            System.out.println(User.SearchProductCatalog(SearchProductID));
                        } else {
                            System.out.print("The ID of the product you wanted to search for is invalid. Please type in a number: ");
                            UserInput.nextLine();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Please enter the ID of the product you want to update the details of: ");
                    boolean UpdateProductIDValid = false;
                    int UpdateProductID = 0;
                    while (UpdateProductIDValid==false) {
                        if (UserInput.hasNextInt() == true) {
                            UpdateProductID = UserInput.nextInt();
                            UpdateProductIDValid=true;
                        } else {
                            System.out.print("The ID of the product you wanted to update for is invalid. Please type in a number: ");
                            UserInput.nextLine();
                        }
                    }
                    System.out.println("Is this a refurbished product that you want to update? Y/N");
                    String Updaterefurbishedproduct = UserInput.nextLine();
                    char UpdateRefurbishedproduct = Updaterefurbishedproduct.charAt(0);
                    boolean UpdateRefurbishedProduct = false;
                    int UpdatedProductType = 0;
                    if (UpdateRefurbishedproduct == 'Y' || UpdateRefurbishedproduct == 'y'){
                        UpdatedProductType = 1;
                        UpdateRefurbishedProduct=true; 
                    }
                    System.out.print("Enter the updated name of your product: ");
                    String UpdatedProductName = UserInput.nextLine();
                    
                    System.out.print("Enter the updated category of your product: ");
                    String UpdatedProductCategory = UserInput.nextLine();
                    
                    boolean UpdatedPriceValid = false;
                    System.out.print("Enter the updated price of your product: R");
                    while (UpdatedPriceValid == false) {
                        if (UserInput.hasNextDouble() == true) {
                            double UpdatedProductPrice = UserInput.nextDouble();
                            UpdatedPriceValid=true;
                        } else {
                            System.out.print("The price you entered is invalid. It can only consist of numbers. Please try again: R");
                            UserInput.nextLine();
                        }
                    }
                    
                    UserInput.nextLine();
                    boolean UpdatedEnvironmentalScoreValid=false;
                    System.out.print("Please enter the updated environmental score of your product that is between 0 and 10 (including 0 and 10): ");
                    while (UpdatedEnvironmentalScoreValid==false){
                        if (UserInput.hasNextInt() == true ) {
                            int UpdatedEnvironmentalScore = UserInput.nextInt();
                            if (User.ValidateEnvironmentalScore(UpdatedEnvironmentalScore) == true) {
                                UpdatedEnvironmentalScoreValid=true;
                            } else {
                                UserInput.nextLine();
                                System.out.print("The updated score you entered is invalid. It must be between 0 and 10 (Including 0 and 10). Please try again: ");
                                UserInput.nextLine();
                            }
                        } else {
                            System.out.print("The updated score you entered is invalid. It must be a number and between 0 and 10 (including 0 and 10). Please try again: ");
                            UserInput.nextLine();
                        }
                    }
                    
                    if (UpdateRefurbishedProduct == true){
                        UpdatedProductType = 1;
                        boolean UpdateProductAgeValid =false;
                        System.out.print("Please enter the age of your refurbished product in years: ");
                        while (UpdateProductAgeValid == false){
                            if (UserInput.hasNextInt() == true) {
                                ProductAge = UserInput.nextInt();
                                ProductAgeValid=true;
                            } else {
                                UserInput.nextLine();
                                System.out.print("The age that you entered is invalid. Please enter a number for the age in years: ");
                                UserInput.nextLine();
                            }
                        }
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                case 10:
                    
                    break;
            }
        }
    }
}
