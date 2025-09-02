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
        // Declare variables to store series details
        String SeriesId;
        String SeriesName;
        String SeriesAge;
        String SeriesNumberOfEpisodes;

        // Create Scanner objects for user input
        Scanner UserChoice = new Scanner(System.in); // Used for menu navigation
        Series User_1 = new Series(); // Create an instance of the Series class
        Scanner UserInput = new Scanner(System.in); // Used for capturing series details

        // Display application header
        System.out.println("LATEST SERIES - 2025");
        System.out.println("********************************");

        // Infinite loop to keep the application running until user exits
        while (true) {
            boolean AgeValid = false; // Flag to validate age input

            // Prompt user to launch menu or exit
            System.out.println("Enter (1) to launch menu or any other key to exit.");
            String LaunchKeyInputted = UserChoice.nextLine();
            char launchKeyInputted = LaunchKeyInputted.charAt(0);

            // If user chooses to launch the menu
            if (launchKeyInputted == '1') {
                // Display menu options
                System.out.println("Please select one of the following menu items:");
                System.out.println("(1) Capture a new series.");
                System.out.println("(2) Search for a series.");
                System.out.println("(3) Update series.");
                System.out.println("(4) Delete a series.");
                System.out.println("(5) Print series report - 2025");
                System.out.println("(6) Exit Application");

                // Read user's menu choice
                String userChoice = UserChoice.nextLine();
                char userchoice = userChoice.charAt(0);

                // Handle menu selection using switch-case
                switch (userchoice) {
                    case '1':
                        // Capture a new series
                        int Age = 0;

                        System.out.print("Enter the series id: ");
                        SeriesId = UserInput.next();
                        UserInput.nextLine(); // Consume newline

                        System.out.print("Enter the series name: ");
                        SeriesName = UserInput.nextLine();

                        // Validate age input
                        System.out.print("Enter the series age restriction: ");
                        while (!AgeValid) {
                            if (UserInput.hasNextInt()) {
                                Age = UserInput.nextInt();
                                UserInput.nextLine(); // Consume newline
                                AgeValid = User_1.ValidateAge(Age);
                                if (!AgeValid) {
                                    System.out.println("You have entered an incorrect series age!!!");
                                    System.out.print("Please re-enter the series age >> ");
                                }
                            } else {
                                AgeValid = false;
                                System.out.println("You have entered an incorrect series age!!!");
                                UserInput.nextLine(); // Clear invalid input
                                System.out.print("Please re-enter the series age >> ");
                            }
                        }

                        // If age is valid, capture number of episodes and save series
                        if (AgeValid) {
                            System.out.print("Enter the number of episodes for " + SeriesName + ": ");
                            SeriesNumberOfEpisodes = UserInput.next();
                            User_1.CaptureSeries(SeriesId, SeriesName, Age, SeriesNumberOfEpisodes);
                        }
                        break;

                    case '2':
                        // Search for a series by ID
                        System.out.print("Enter the series id to search: ");
                        System.out.println(User_1.SearchSeries(UserInput.next()));
                        break;

                    case '3':
                        // Update an existing series
                        int UpdateAge = 0;
                        String UpdateSeriesNumberOfEpisodes = null;

                        System.out.print("Enter the series id to update: ");
                        String UpdateSeriesID = UserInput.next();
                        UserInput.nextLine(); // Consume newline

                        System.out.print("Enter the series name: ");
                        String UpdateSeriesName = UserInput.nextLine();

                        // Validate updated age input
                        System.out.print("Enter the age restriction: ");
                        AgeValid = false;
                        while (!AgeValid) {
                            if (UserInput.hasNextInt()) {
                                UpdateAge = UserInput.nextInt();
                                UserInput.nextLine(); // Consume newline
                                AgeValid = User_1.ValidateAge(UpdateAge);
                                if (!AgeValid) {
                                    System.out.println("You have entered an incorrect series age!!!");
                                    System.out.print("Please re-enter the series age >> ");
                                }
                            } else {
                                AgeValid = false;
                                System.out.println("You have entered an incorrect series age!!!");
                                UserInput.nextLine(); // Clear invalid input
                                System.out.print("Please re-enter the series age >> ");
                            }
                        }

                        // If age is valid, update number of episodes and save changes
                        if (AgeValid) {
                            System.out.print("Enter the number of episodes: ");
                            UpdateSeriesNumberOfEpisodes = UserInput.next();

                            // Attempt to update series; notify if not found
                            if (!User_1.UpdateSeries(UpdateSeriesID, UpdateSeriesName, UpdateAge, UpdateSeriesNumberOfEpisodes)) {
                                System.out.println("Series with series id: " + UpdateSeriesID + " was not found!");
                            }
                        }
                        break;

                    case '4':
                        // Delete a series by ID
                        Boolean SeriesDeleted = false;
                        System.out.print("Enter the series id to delete: ");
                        String DeleteSeriesID = UserInput.next();

                        // Confirm deletion
                        System.out.println("Are you sure you want to delete series " + DeleteSeriesID + " from the system? Yes (y) to delete.");
                        String ConfirmationDelete = UserInput.next();
                        char confirmationDelete = ConfirmationDelete.charAt(0);

                        // Proceed with deletion if confirmed
                        if (confirmationDelete == 'y' || confirmationDelete == 'Y') {
                            SeriesDeleted = User_1.DeleteSeries(DeleteSeriesID);
                            if (!SeriesDeleted) {
                                System.out.println("Series with Series Id: " + DeleteSeriesID + " was not found!");
                            } else {
                                System.out.println("Series with Series Id: " + DeleteSeriesID + " WAS deleted!");
                            }
                        } else {
                            System.out.println("Series deletion cancelled.");
                        }
                        break;

                    case '5':
                        // Print report of all series
                        System.out.println(User_1.SeriesReport());
                        break;

                    case '6':
                        // Exit the application
                        User_1.ExitSeriesApplication();
                        break;
                }
            } else {
                // Exit if user does not enter '1'
                User_1.ExitSeriesApplication();
            }
        }
    }
}