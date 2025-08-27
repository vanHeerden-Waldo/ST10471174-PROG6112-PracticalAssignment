/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.tvseriestrackerapp;

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
    public void testSearchSeries() {
        
        User1.SearchSeries();
        
    }

    /**
     * Test of UpdateSeries method, of class Series.
     */
    @Test
    public void testUpdateSeries() {
    }

    /**
     * Test of DeleteSeries method, of class Series.
     */
    @Test
    public void testDeleteSeries() {
    }

    /**
     * Test of SeriesReport method, of class Series.
     */
    @Test
    public void testSeriesReport() {
    }

    /**
     * Test of ExitSeriesApplication method, of class Series.
     */
    @Test
    public void testExitSeriesApplication() {
    }
    
}
