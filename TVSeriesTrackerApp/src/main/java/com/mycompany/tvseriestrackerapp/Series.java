/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriestrackerapp;

/**
 *
 * @author lab_services_student
 */
import java.util.*;

public class Series {
    Scanner UserInput = new Scanner(System.in);
    private String SeriesId;
    private String SeriesName;
    private String SeriesAge;
    private String SeriesNumberOfEpisodes;
    
    
    public void CaptureSeries(){
        System.out.print("Enter the series id: ");
        SeriesId=UserInput.next();
        
        System.out.print("Enter the series name: ");
        SeriesName=UserInput.next();
       
        System.out.print("Enter the series age restriction: "); 
        boolean AgeValid =false;
        while (AgeValid == false) {           
            int Age;
            if (UserInput.hasNextInt() == true) {
                Age = UserInput.nextInt();
                UserInput.nextLine();
                if (Age >= 2 && Age<=18) {
                    SeriesAge=String.valueOf(Age);
                    AgeValid=true;
                } else {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                    Age=UserInput.nextInt();
                }
            } else { 
               System.out.println("You have entered a incorrect series age!!!");
               System.out.print("Please re-enter the series age >> ");
               UserInput.nextLine();
            }   
        }
        
        System.out.print("Enter the number of episodes for " + SeriesName +": ");
        SeriesNumberOfEpisodes=UserInput.next();
        
        System.out.println("Series processed successfully!!!");
    }
    
    public void SearchSeries() {
        System.out.println("Enter the series id to search: ");
    }
}
