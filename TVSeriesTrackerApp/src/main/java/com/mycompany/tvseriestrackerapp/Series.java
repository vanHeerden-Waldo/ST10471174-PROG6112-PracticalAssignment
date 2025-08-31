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
    //Scanner UserInput = new Scanner(System.in);

    private ArrayList<SeriesModel> TVSeriesList = new ArrayList<>();
    
    
    public boolean ValidateAge(int Age){
        boolean AgeValid;                          
        if (Age >= 2 && Age<=18) {
            AgeValid=true;
            } else {
                AgeValid=false;
            }
        return AgeValid;  
    }
    
    public boolean CaptureSeries(String ID, String Name, int Age, String Episodes){
        //SeriesModel NewSeries = new SeriesModel(SeriesId, SeriesName, SeriesAge, SeriesNumberOfEpisodes);
        boolean SeriesAdded = false;
            if (!ValidateAge(Age)) {
                SeriesAdded=false;
            } else {
                SeriesModel newSeries = new SeriesModel(ID, Name, String.valueOf(Age), Episodes);
                TVSeriesList.add(newSeries);
                SeriesAdded=true;
            }  
        return SeriesAdded;
        
        /*System.out.print("Enter the series id: ");
        SeriesId=UserInput.next();
        
        UserInput.nextLine();
        
        System.out.print("Enter the series name: ");
        SeriesName=UserInput.nextLine();
       
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
        TVSeriesList.add(NewSeries);*/
    }
    
    public String SearchSeries(String SearchSeriesID) {
        StringBuilder SeriesSearch = new StringBuilder();
        String SearchSeries;
        
        SeriesSearch.append("----------------------------");
        
        boolean SeriesIDFound = false;
        
        for (SeriesModel s : TVSeriesList) {
            if (s.SeriesId.equalsIgnoreCase(SearchSeriesID)) {
                SeriesSearch.append("\nSERIES ID: " + s.SeriesId);
                SeriesSearch.append("\nSERIES NAME: " + s.SeriesName);
                SeriesSearch.append("\nSERIES AGE RESTRICTION: " + s.SeriesAge);
                SeriesSearch.append("\nSERIES NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
                SeriesIDFound=true;
                break;
            }
        }
        if (SeriesIDFound==false) {
            SeriesSearch.append("\nSeries with Series Id: " + SearchSeriesID + " was not found!");
        }
        SeriesSearch.append("\n----------------------------");
        
        SearchSeries = SeriesSearch.toString();
        return SearchSeries;
    }
    
    public boolean UpdateSeries(String UpdateSeriesID, String NewSeriesName, int NewAge, String NewNumberOfEpisodes) {
        boolean SeriesUpdated = false;
        for (SeriesModel s : TVSeriesList) {
            if (s.SeriesId.equalsIgnoreCase(UpdateSeriesID)) {
                if (!ValidateAge(NewAge)) {
                    SeriesUpdated=false;
                    break;
                } else {
                s.SeriesName = NewSeriesName;
                s.SeriesAge = String.valueOf(NewAge);
                s.SeriesNumberOfEpisodes = NewNumberOfEpisodes;
                SeriesUpdated = true;
                }
            }
        }
        return SeriesUpdated;
        
        /*System.out.print("Enter the series id to update: ");
        String UpdateSeriesID = UserInput.next();
        
        boolean SeriesIDFound = false;
        
        for (SeriesModel s : TVSeriesList) {
            if (s.SeriesId.equalsIgnoreCase(UpdateSeriesID) == true) {
                SeriesIDFound = true;
                
                System.out.print("Enter the series name: ");
                s.SeriesName=UserInput.next();
                UserInput.nextLine();
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
        }*/
    }
    
    public boolean DeleteSeries(String DeleteSeriesID){
        boolean SeriesDeleted = false;
        for (SeriesModel s : TVSeriesList) {
            if (s.SeriesId.equalsIgnoreCase(DeleteSeriesID)) {
                TVSeriesList.remove(s);
                SeriesDeleted=true;
                break;
            }
        }    
        return SeriesDeleted;
        /*System.out.print("Enter the series id to delete: ");
        String DeleteSeriesID = UserInput.next();
        System.out.println("Are you sure you want to delete series " + DeleteSeriesID + " from the system? Yes (y) to delete.");
        String ConfirmationDelete = UserInput.next();
        char confirmationDelete = ConfirmationDelete.charAt(0);
        
        boolean SeriesToDeleteFound = false;
        
        
        if (confirmationDelete == 'y' || confirmationDelete == 'Y') {
            for (SeriesModel s : TVSeriesList) {
                if (s.SeriesId.equalsIgnoreCase(DeleteSeriesID) == true) {
                    TVSeriesList.remove(s);
                    System.out.println("Series with Series Id: " + DeleteSeriesID + " WAS deleted!");
                    SeriesToDeleteFound=true;
                    break;
                }
            }
            if (SeriesToDeleteFound == false) {
                System.out.println("No series found with the ID: " + DeleteSeriesID);
            }
        } else {
            System.out.println("Series deletion cancelled.");
        }*/
    }
    
    public String SeriesReport() {
        StringBuilder  SeriesReport = new StringBuilder();
        String seriesReport = null;
        if (TVSeriesList.isEmpty() == true) {
            SeriesReport.append("No series is currently stored.");
        } else {
            int i=0;
            for (SeriesModel s : TVSeriesList) {
                i++;
                SeriesReport.append("\nSeries " + i);
                SeriesReport.append("\n-----------------------------");
                SeriesReport.append("\nSERIES ID: " + s.SeriesId);
                SeriesReport.append("\nSERIES NAME: " + s.SeriesName);
                SeriesReport.append("\nSERIES AGE RESTRICTION: " + s.SeriesAge);
                SeriesReport.append("\nNUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
                SeriesReport.append("\n-----------------------------");
            }
        }
        seriesReport = SeriesReport.toString();
        return seriesReport;
    }
    
    public void ExitSeriesApplication() {
        System.out.println("Closing the application");
        System.exit(0);
    }
}
