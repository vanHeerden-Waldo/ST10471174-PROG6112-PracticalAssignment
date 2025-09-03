/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TVSeriesTrackerApp;

/**
 *
 * @author lab_services_student
 */
public class SeriesModel {
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;
    
    public SeriesModel(String SeriesID, String SeriesName, String SeriesAge, String SeriesNumberOfEpisodes){
        SeriesId=SeriesID;
        this.SeriesName = SeriesName;
        this.SeriesAge=SeriesAge;
        this.SeriesNumberOfEpisodes=SeriesNumberOfEpisodes;
    }
}
