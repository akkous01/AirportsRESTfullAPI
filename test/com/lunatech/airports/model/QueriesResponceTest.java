/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lunatech.airports.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antria
 */
public class QueriesResponceTest {

    
    public static void assertEquals(ResultSet exp, ResultSet act){
        if(exp == null && act != null){
            fail("Expected Null");
        }
        if(exp != null && act == null){
            fail("Expected not Null");
        }
        if(exp == null && act == null){
            return;
        }
        
        try {
            while(exp.next() && act.next()){
               if(!exp.getString(1).equals(act.getString(1))) {
                   fail("Not equal");
               }
            }
            return;
        } catch (SQLException ex) {
            Logger.getLogger(QueriesResponceTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Not equal");
        }
    }

   
      
    /**
     * Test of countryQuery method, of class QueriesResponce.
     */
    @Test
    public void testCountryQueryEmpty() {
        // empty insert
        String inputData = "";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = null;
        ResultSet expRunways = null;
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);
        
    }

    @Test
    public void testCountryQueryCODE_LOWCASE() {
        // empty insert
        String inputData = "cy";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = instance.countryQueryAirports("CY");
        ResultSet expRunways = instance.countryQueryRunways("CY");
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);    
        
    }
    
    @Test
    public void testCountryQueryCODE_LowFirstCASE() {
        // empty insert
        String inputData = "cY";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = instance.countryQueryAirports("CY");
        ResultSet expRunways = instance.countryQueryRunways("CY");
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);     
        
    }
    
    
    @Test
    public void testCountryQueryCODE_FULLNAMECAPITALS() {
        // empty insert
        String inputData = "GREECE";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = instance.countryQueryAirports("Greece");
        ResultSet expRunways = instance.countryQueryRunways("Greece");
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);   
        
    }
    
    @Test
    public void testCountryQueryCODE_FULLNAMELowCase() {
        // empty insert
        String inputData = "netherlands";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = instance.countryQueryAirports("Netherlands");
        ResultSet expRunways = instance.countryQueryRunways("Netherlands");
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);   
        
    }
    
    
    @Test
    public void testCountryQueryCODE_FULLNAMEmix() {
        // empty insert
        String inputData = "nEtherlAndS";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = instance.countryQueryAirports("Netherlands");
        ResultSet expRunways = instance.countryQueryRunways("Netherlands");
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);   
        
    }
    
    
    @Test
    public void testCountryQueryCODE_NONFULLNAMECAPITALS() {
        // empty insert
        String inputData = "Zimb";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = instance.countryQueryAirports("Zimbabwe");
        ResultSet expRunways = instance.countryQueryRunways("Zimbabwe");
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);    
        
    }
    
    @Test
    public void testCountryQueryCODE_NONFULLNAMELowCase() {
        // empty insert
        String inputData = "nethe";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = instance.countryQueryAirports("Netherlands");
        ResultSet expRunways = instance.countryQueryRunways("Netherlands");
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);    
        
    }
    
    
    @Test
    public void testCountryQueryCODE_NONFULLNAMEmix() {
        // empty insert
        String inputData = "nOrw";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = instance.countryQueryAirports("Norway");
        ResultSet expRunways = instance.countryQueryRunways("Norway");
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);   
        
    }
    
    @Test
    public void testCountryQueryCODE_NONValid() {
        // empty insert
        String inputData = "1111";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = instance.countryQueryAirports("111");
        ResultSet expRunways = instance.countryQueryRunways("111");
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);   
        
    }
    
    @Test
    public void testCountryQueryCODE_Spaces() {
        // empty insert
        String inputData = " Greece ";
        QueriesResponce instance = new QueriesResponce();
        ResultSet expAirports = instance.countryQueryAirports("Greece");
        ResultSet expRunways = instance.countryQueryRunways("Greece");
        ResultSet result = instance.countryQueryAirports(inputData); 
        ResultSet resultRun = instance.countryQueryRunways(inputData);         
        assertEquals(expAirports, result); 
        assertEquals(expRunways, resultRun);   
        
    }
    
    
    
    /**
     * Test of main method, of class QueriesResponce.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] arg = null;
//        QueriesResponce.main(arg);
//        
//        
//    }


    
}
