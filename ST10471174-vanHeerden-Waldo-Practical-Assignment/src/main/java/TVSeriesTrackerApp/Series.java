/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TVSeriesTrackerApp;

/**
 *
 * @author lab_services_student
 */
import java.util.*;

public class Series {

    // List to store all TV series entries
    private ArrayList<SeriesModel> TVSeriesList = new ArrayList<>();

    /**
     * Validates the age restriction for a series.
     * Only allows ages between 2 and 18 (inclusive).
     */
    public boolean ValidateAge(int Age){
        boolean AgeValid;
        if (Age >= 2 && Age <= 18) {
            AgeValid = true;
        } else {
            AgeValid = false;
        }
        return AgeValid;
    }

    /**
     * Captures and adds a new series to the list.
     * Returns true if the series was successfully added.
     */
    public boolean CaptureSeries(String ID, String Name, int Age, String Episodes){
        boolean SeriesAdded = false;
        if (!ValidateAge(Age)) {
            SeriesAdded = false; // Invalid age, do not add
        } else {
            // Create new SeriesModel object and add to list
            SeriesModel newSeries = new SeriesModel(ID, Name, String.valueOf(Age), Episodes);
            TVSeriesList.add(newSeries);
            SeriesAdded = true;
        }
        return SeriesAdded;
    }

    /**
     * Searches for a series by its ID.
     * Returns a formatted string with series details or a not-found message.
     */
    public String SearchSeries(String SearchSeriesID) {
        StringBuilder SeriesSearch = new StringBuilder();
        String SearchSeries;

        SeriesSearch.append("----------------------------");

        boolean SeriesIDFound = false;

        // Loop through the list to find matching series ID
        for (SeriesModel s : TVSeriesList) {
            if (s.SeriesId.equalsIgnoreCase(SearchSeriesID)) {
                // Append series details to output
                SeriesSearch.append("\nSERIES ID: " + s.SeriesId);
                SeriesSearch.append("\nSERIES NAME: " + s.SeriesName);
                SeriesSearch.append("\nSERIES AGE RESTRICTION: " + s.SeriesAge);
                SeriesSearch.append("\nSERIES NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
                SeriesIDFound = true;
                break;
            }
        }

        // If not found, show error message
        if (!SeriesIDFound) {
            SeriesSearch.append("\nSeries with Series Id: " + SearchSeriesID + " was not found!");
        }

        SeriesSearch.append("\n----------------------------");
        SearchSeries = SeriesSearch.toString();
        return SearchSeries;
    }

    /**
     * Updates an existing series with new details.
     * Returns true if the update was successful.
     */
    public boolean UpdateSeries(String UpdateSeriesID, String NewSeriesName, int NewAge, String NewNumberOfEpisodes) {
        boolean SeriesUpdated = false;

        // Loop through the list to find matching series ID
        for (SeriesModel s : TVSeriesList) {
            if (s.SeriesId.equalsIgnoreCase(UpdateSeriesID)) {
                // Validate new age before updating
                if (!ValidateAge(NewAge)) {
                    SeriesUpdated = false;
                    break;
                } else {
                    // Update series details
                    s.SeriesName = NewSeriesName;
                    s.SeriesAge = String.valueOf(NewAge);
                    s.SeriesNumberOfEpisodes = NewNumberOfEpisodes;
                    SeriesUpdated = true;
                }
            }
        }
        return SeriesUpdated;
    }

    /**
     * Deletes a series from the list based on its ID.
     * Returns true if the series was successfully deleted.
     */
    public boolean DeleteSeries(String DeleteSeriesID){
        boolean SeriesDeleted = false;

        // Loop through the list to find and remove matching series
        for (SeriesModel s : TVSeriesList) {
            if (s.SeriesId.equalsIgnoreCase(DeleteSeriesID)) {
                TVSeriesList.remove(s);
                SeriesDeleted = true;
                break;
            }
        }
        return SeriesDeleted;
    }

    /**
     * Generates a report of all stored series.
     * Returns a formatted string with all series details.
     */
    public String SeriesReport() {
        StringBuilder SeriesReport = new StringBuilder();
        String seriesReport = null;

        // Check if list is empty
        if (TVSeriesList.isEmpty()) {
            SeriesReport.append("No series is currently stored.");
        } else {
            int i = 0;
            // Loop through each series and append its details
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

    /**
     * Exits the application gracefully.
     */
    public void ExitSeriesApplication() {
        System.out.println("Closing the application");
        System.exit(0);
    }
}