/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TVSeriesTrackerApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class SeriesTest {
    Series User1 = new Series();
    public SeriesTest() {
       
    }

    /**
     * Test of ValidateAge method, of class Series.
     */
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
       boolean result = User1.ValidateAge(2);
        assertTrue(result);
    }

    /**
     * Test of CaptureSeries method, of class Series.
     */
    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        boolean result = User1.ValidateAge(1);
        assertFalse(result);
    }

    /**
     * Test of SearchSeries method, of class Series.
     */
    @Test
    public void TestSearchSeries() {
        User1.CaptureSeries("1", "The Rangers", 18, "20");
        String Result = User1.SearchSeries("1");
        String Expected = "----------------------------\nSERIES ID: 1\nSERIES NAME: The Rangers\nSERIES AGE RESTRICTION: 18\nSERIES NUMBER OF EPISODES: 20\n----------------------------";
        assertEquals(Expected, Result);
    }
    
    /*
     Test of SearchSeries Method, of class Series
    */
    @Test
    public void TestSearchSeries_SeriesNotFound() {
        User1.CaptureSeries("1", "The Rangers", 18, "20");
        String Result = User1.SearchSeries("2");
        String Expected = "----------------------------\nSeries with Series Id: 2 was not found!\n----------------------------";
        assertEquals(Expected, Result);
    }

    /**
     * Test of UpdateSeries method, of class Series.
     */
    @Test
    public void TestUpdateSeries() {
       User1.CaptureSeries("1", "The Park Rangers", 15, "10");
       boolean Result = User1.UpdateSeries("1", "The Rangers", 18, "20");
       assertTrue(Result);
    }

    /**
     * Test of DeleteSeries method, of class Series.
     */
    @Test
    public void testDeleteSeries() {
       User1.CaptureSeries("1", "The Rangers", 18, "20");
       boolean Result = User1.DeleteSeries("1");
       assertTrue(Result);
    }

    /**
     * Test of DeleteSeries method, of class Series.
     */
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        User1.CaptureSeries("1", "The Rangers", 18, "20");
        boolean Result = User1.DeleteSeries("2");
        assertFalse(Result);
    }

    
}
