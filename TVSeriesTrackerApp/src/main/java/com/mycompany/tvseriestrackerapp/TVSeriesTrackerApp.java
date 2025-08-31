/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tvseriestrackerapp;
import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */
public class TVSeriesTrackerApp {
    
    public static void main(String[] args) {
        String SeriesId;
        String SeriesName;
        String SeriesAge;
        String SeriesNumberOfEpisodes;
        
        Scanner UserChoice = new Scanner(System.in);
        Series User_1 = new Series();
        Scanner UserInput = new Scanner(System.in);
        
        System.out.println("LATEST SERIES - 2025");
        System.out.println("********************************");
        
        while (true) {
            boolean AgeValid =false;            
            System.out.println("Enter (1) to launch menu or any other key to exit.");
            String LaunchKeyInputted = UserChoice.nextLine();
            char launchKeyInputted = LaunchKeyInputted.charAt(0);                
            if (launchKeyInputted == '1') {
                System.out.println("Please select one of the following menu items:");
                System.out.println("(1) Capture a new series.");
                System.out.println("(2) Search for a series.");
                System.out.println("(3) Update series.");
                System.out.println("(4) Delete a series.");
                System.out.println("(5) Print series report - 2025");
                System.out.println("(6) Exit Application");
                String userChoice = UserChoice.nextLine();
                char userchoice = userChoice.charAt(0);
                switch (userchoice) {
                    case '1':
                        int Age = 0;
                        System.out.print("Enter the series id: ");
                        SeriesId=UserInput.next();
        
                        UserInput.nextLine();
        
                        System.out.print("Enter the series name: ");
                        SeriesName=UserInput.nextLine();
       
                        System.out.print("Enter the series age restriction: "); 
                        while (AgeValid ==false ) {
                            if (UserInput.hasNextInt()) {
                                Age = UserInput.nextInt();
                                UserInput.nextLine();
                                AgeValid = User_1.ValidateAge(Age);
                                if (AgeValid == false) {
                                    System.out.println("You have entered a incorrect series age!!!");
                                    System.out.print("Please re-enter the series age >> ");
                                }
                            } else {
                                AgeValid =false;
                                System.out.println("You have entered a incorrect series age!!!");
                                UserInput.nextLine();
                                System.out.print("Please re-enter the series age >> ");
                            }
                        }
                        
                        if (AgeValid == true){
                            System.out.print("Enter the number of episodes for " + SeriesName +": ");
                            SeriesNumberOfEpisodes=UserInput.next();
                            User_1.CaptureSeries(SeriesId, SeriesName, Age, SeriesNumberOfEpisodes);
                        }
                        break;
                    case '2':
                        System.out.print("Enter the series id to search: ");
                        System.out.println(User_1.SearchSeries(UserInput.next()));
                        break;
                    case '3':
                        int UpdateAge = 0;
                        String UpdateSeriesNumberOfEpisodes = null;
                        
                        System.out.print("Enter the series id to update: ");
                        String UpdateSeriesID = UserInput.next();
                        UserInput.nextLine();
        
                
                        System.out.print("Enter the series name: ");
                        String UpdateSeriesName=UserInput.nextLine();
                        
                        System.out.print("Enter the age restriction: ");
                        AgeValid =false;
                        while (AgeValid == false) {           
                            if (UserInput.hasNextInt()) {
                                UpdateAge = UserInput.nextInt();
                                UserInput.nextLine();
                                AgeValid = User_1.ValidateAge(UpdateAge);
                                if (AgeValid == false) {
                                    System.out.println("You have entered a incorrect series age!!!");
                                    System.out.print("Please re-enter the series age >> ");
                                }
                            } else {
                                AgeValid =false;
                                System.out.println("You have entered a incorrect series age!!!");
                                UserInput.nextLine();
                                System.out.print("Please re-enter the series age >> ");
                            }
                        }
                
                        if (AgeValid == true) {
                            System.out.print("Enter the number of episodes: ");
                            UpdateSeriesNumberOfEpisodes=UserInput.next();
                        
                        
                            if (User_1.UpdateSeries(UpdateSeriesID, UpdateSeriesName, UpdateAge, UpdateSeriesNumberOfEpisodes)==false){
                                System.out.println("Series with series id: " + UpdateSeriesID + " was not found!");
                            }
                        }
                        break;
                    case '4':
                        Boolean SeriesDeleted = false;
                        System.out.print("Enter the series id to delete: ");
                        String DeleteSeriesID = UserInput.next();
                        System.out.println("Are you sure you want to delete series " + DeleteSeriesID + " from the system? Yes (y) to delete.");
                        String ConfirmationDelete = UserInput.next();
                        char confirmationDelete = ConfirmationDelete.charAt(0);
                        
                        if (confirmationDelete == 'y' || confirmationDelete == 'Y') {
                            SeriesDeleted = User_1.DeleteSeries(DeleteSeriesID); 
                            if (SeriesDeleted == false) {
                                System.out.println("Series with Series Id: " + DeleteSeriesID + " was not found!");
                            } else {
                                System.out.println("Series with Series Id: " + DeleteSeriesID + " WAS deleted!");
                            }
                        } else {
                            System.out.println("Series deletion cancelled.");
                        }

                        break;
                    case '5':
                        System.out.println(User_1.SeriesReport());
                        break;
                    case '6':
                        User_1.ExitSeriesApplication();
                        break;   
                }
            } else {
                    User_1.ExitSeriesApplication();
            }
        }
    }
}
