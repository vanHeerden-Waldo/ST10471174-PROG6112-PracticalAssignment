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
        Scanner UserChoice = new Scanner(System.in);
        Series User_1 = new Series();
        
        System.out.println("LATEST SERIES - 2025");
        System.out.println("********************************");
        
        while (true) {
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
                        User_1.CaptureSeries();
                        break;
                    case '2':
                        User_1.SearchSeries();
                        break;
                    case '3':
                        User_1.UpdateSeries();
                        break;
                    case '4':
                        User_1.DeleteSeries();
                        break;
                    case '5':
                        User_1.SeriesReport();
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
