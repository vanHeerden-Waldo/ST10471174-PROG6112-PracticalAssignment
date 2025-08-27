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
    private ArrayList<SeriesModel> TVSeriesList = new ArrayList<>();
    SeriesModel NewSeries = new SeriesModel(SeriesId, SeriesName, SeriesAge, SeriesNumberOfEpisodes);
    
    public boolean ValidateAge(int Age){
        boolean AgeValid;                          
        if (Age >= 2 && Age<=18) {
            SeriesAge=String.valueOf(Age);
            AgeValid=true;
            } else {
                AgeValid=false;
            }
        return AgeValid;  
    }
    
    public void CaptureSeries(){
        
        
        System.out.print("Enter the series id: ");
        SeriesId=UserInput.next();
        
        System.out.print("Enter the series name: ");
        SeriesName=UserInput.next();
       
        UserInput.nextLine();
        System.out.print("Enter the series age restriction: "); 
        boolean AgeValid =false;
        while (AgeValid == false) {           
            if (UserInput.hasNextInt() == true) {
                int Age = UserInput.nextInt();
                UserInput.nextLine();
                if (ValidateAge(Age) == true) {
                    SeriesAge=String.valueOf(Age);
                    AgeValid=true;
                } else {
                    System.out.println("You have entered a incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                }
            } else { 
               System.out.println("You have entered a incorrect series age!!!");
               UserInput.nextLine();
               System.out.print("Please re-enter the series age >> ");
            }   
        }
        
        System.out.print("Enter the number of episodes for " + SeriesName +": ");
        SeriesNumberOfEpisodes=UserInput.next();
        
        
        System.out.println("Series processed successfully!!!");
        NewSeries.SeriesId=this.SeriesId;
        NewSeries.SeriesName=this.SeriesName;
        NewSeries.SeriesAge=this.SeriesAge;
        NewSeries.SeriesNumberOfEpisodes=this.SeriesNumberOfEpisodes;
        TVSeriesList.add(NewSeries);
    }
    
    public void SearchSeries() {
        System.out.println("Enter the series id to search: ");
        String SearchSeriesID = UserInput.next();
        System.out.println("----------------------------");
        
        boolean SeriesIDFound = false;
        
        for (SeriesModel s : TVSeriesList) {
            if (s.SeriesId.equalsIgnoreCase(SearchSeriesID)) {
                System.out.println("SERIES ID: " + s.SeriesId);
                System.out.println("SERIES NAME: " + s.SeriesName);
                System.out.println("SERIES AGE RESTRICTION: " + s.SeriesAge);
                System.out.println("SERIES NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
                SeriesIDFound=true;
                break;
            }
        }
        if (SeriesIDFound==false) {
            System.out.println("Series with Series Id: " + SearchSeriesID + " was not found!");
        }
        System.out.println("----------------------------");
    }
    
    public void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String UpdateSeriesID = UserInput.next();
        
        boolean SeriesIDFound = false;
        
        for (SeriesModel s : TVSeriesList) {
            if (s.SeriesId.equalsIgnoreCase(UpdateSeriesID) == true) {
                SeriesIDFound = true;
                
                System.out.print("Enter the series name: ");
                s.SeriesName=UserInput.next();
                
                System.out.print("Enter the age restriction: ");
                boolean AgeValid =false;
                while (AgeValid == false) {           
                    if (UserInput.hasNextInt() == true) {
                        int Age = UserInput.nextInt();
                        UserInput.nextLine();
                        if (ValidateAge(Age) == true) {
                            s.SeriesAge=String.valueOf(Age);
                            AgeValid=true;
                        } else {
                            System.out.println("You have entered a incorrect series age!");
                            System.out.print("Please re-enter the series age >> ");
                        }
                    } else { 
                        System.out.println("You have entered a incorrect series age!");
                        UserInput.nextLine();
                        System.out.print("Please re-enter the series age >> ");
                    }   
                }
                
                System.out.print("Enter the number of episodes: ");
                s.SeriesNumberOfEpisodes=UserInput.next();
            }
        }
        if (SeriesIDFound==false){
            System.out.println("Series with series id: " + UpdateSeriesID + " was not found!");
        }
    }
    
    public void DeleteSeries(){
        System.out.print("Enter the series id to delete: ");
        String DeleteSeriesID = UserInput.next();
        System.out.println("Are you sure you want to delete series " + DeleteSeriesID + " from the system? Yes (y) to delete.");
        String ConfirmationDelete = UserInput.next();
        char confirmationDelete = ConfirmationDelete.charAt(0);
        
        boolean SeriesToDeleteFound = false;
        
        
        
        for (SeriesModel s : TVSeriesList) {
            if (s.SeriesId.equalsIgnoreCase(DeleteSeriesID) == true) {
                TVSeriesList.remove(s);
                System.out.println("Series with Series Id: " + DeleteSeriesID + " WAS deleted!");
                SeriesToDeleteFound=true;
                break;
            }
        }
    }
}
