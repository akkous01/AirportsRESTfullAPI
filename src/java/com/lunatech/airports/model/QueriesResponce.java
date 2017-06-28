package com.lunatech.airports.model;

/**
 * QueriesResponce
 * This class is connected with the database to retrieve data with queries
 * @author Antria
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Antria
 */
public class QueriesResponce {
        
    String url = "jdbc:derby://localhost:1527/RunwaysDB"; 
    String username = "antria";
    String pass = "antria";
    
    Connection conn = null; 
    PreparedStatement st = null;
    ResultSet resultSet = null;
    
    public QueriesResponce(){
         try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Derby driver not found.");
        }
        try {
            conn = DriverManager.getConnection(url,username, pass);
        }
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
            e.printStackTrace();
        } 
        
    }
    
    /**
     * Get a country and return the Runways
     * @param inputData country code or country name or beginning of the country name
     * @return ResultSet from DB
     */
    public ResultSet countryQueryRunways(String inputData){
       ResultSet rs = null;
        try {
            st = null;
            if(null == inputData || inputData.equals("")){
                return null;
            }
            inputData = inputData.trim();
            String code = inputData.toUpperCase();
            String name = inputData.substring(0, 1).toUpperCase() + inputData.substring(1).toLowerCase();
            st = conn.prepareStatement(
                "select COUNTRIES.CODE, COUNTRIES.COUNTRY_NAME, COUNTRIES.CONTINENT, AIRPORTS.IDENT, AIRPORTS.AIR_NAME, RUNWAYS.ID, RUNWAYS.SURFACE, RUNWAYS.LE_IDENT from RUNWAYS  "+
                 "left outer Join AIRPORTS  on AIRPORTS.IDENT =RUNWAYS.AIRPORT_ID "+
                 "left outer join COUNTRIES on COUNTRIES.CODE = AIRPORTS.ISO_CODE "+
                 "where  COUNTRIES.CODE = '"+code+"' OR COUNTRIES.COUNTRY_NAME LIKE '"+name+"%'"
                 );   
           
            rs = st.executeQuery();
            return rs;
           
        }
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
            e.printStackTrace();
        } 
        return null;
    }
    
    /**
     * Get a country and return the airports
     * @param inputData country code or country name or beginning of the country name
     * @return ResultSet from DB
     */
    public ResultSet countryQueryAirports(String inputData){
       ResultSet rs = null;
        try {
            st = null;
            if(null == inputData || inputData.equals("")){
                return null;
            }
            inputData = inputData.trim();
            String code = inputData.toUpperCase();
            String name = inputData.substring(0, 1).toUpperCase() + inputData.substring(1).toLowerCase();
            st = conn.prepareStatement(
                    "select AIRPORTS.IDENT, AIRPORTS.AIR_NAME, AIRPORTS.MUNICIPALITY FROM AIRPORTS  "+
                    "left outer join COUNTRIES on COUNTRIES.CODE = AIRPORTS.ISO_CODE "+
                    "where  COUNTRIES.CODE = '"+code+"' OR COUNTRIES.COUNTRY_NAME LIKE '"+name+"%'"
                    );               
          
            rs = st.executeQuery();
            return rs;
            
        }
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
            e.printStackTrace();
        } 
        return null;
    }
    
    /**
     * Returns the top 10 countries with the most airports from the DB
     * @return ResultSet of the query
     */
    public ResultSet top10(){
        try {
            st = null;
            resultSet = null;
            st = conn.prepareStatement(
                "SELECT COUNTRIES.COUNTRY_NAME,  AIR.AIR_COUNT   "+
                "FROM COUNTRIES LEFT  JOIN ( "+
                "SELECT ISO_CODE, COUNT(*) AS AIR_COUNT "+ 
                "FROM AIRPORTS "+
                "GROUP BY ISO_CODE ORDER BY AIR_COUNT DESC "+
                "FETCH FIRST 10 ROWS ONLY "+
                ") AS AIR ON AIR.ISO_CODE = COUNTRIES.CODE "+
                "WHERE AIR.AIR_COUNT > 0");     
                   
                    
            resultSet = st.executeQuery();
            
        }
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
            e.printStackTrace();
        } 
        return resultSet;
    }
    
    /**
     * Returns the top 10 countries with the least airports from the DB
     * @return ResultSet of the query
     */
    public ResultSet top10low(){
        try {
            st = null;
            resultSet = null;
            st = conn.prepareStatement(
                "SELECT COUNTRIES.COUNTRY_NAME,  AIR.AIR_COUNT   "+
                "FROM COUNTRIES LEFT  JOIN ( "+
                "SELECT ISO_CODE, COUNT(*) AS AIR_COUNT "+ 
                "FROM AIRPORTS "+
                "GROUP BY ISO_CODE ORDER BY AIR_COUNT  "+
                "FETCH FIRST 10 ROWS ONLY "+
                ") AS AIR ON AIR.ISO_CODE = COUNTRIES.CODE "+
                "WHERE AIR.AIR_COUNT > 0");          
            
            
                   
                    
            resultSet = st.executeQuery();
            
        }
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
            e.printStackTrace();
        } 
        return resultSet;
    }
    
    /**
     * Returns the top 10 most common runways in the DB
     * @return ResultSet of the query
     */
    public ResultSet commonRunways(){
       try {
            st = null;
            resultSet = null;
            st = conn.prepareStatement(
                    "SELECT LE_IDENT , COUNT(*) as LE_COUNT "+ 
                    "FROM RUNWAYS "+
                    "GROUP BY LE_IDENT ORDER BY LE_COUNT DESC "+
                    "FETCH FIRST 10 ROWS ONLY");
            resultSet = st.executeQuery();
            
        }
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
            e.printStackTrace();
        } 
        return resultSet;
   }
   
    /**
     * Returns the surfaces for each country from the DB
     * @return ResultSet of the query
     */
    public ResultSet uniqueSurface(){
       try {
            st = null;
            resultSet = null;
            st = conn.prepareStatement(
                "SELECT DISTINCT  COUNTRIES.COUNTRY_NAME, RUNWAYS.SURFACE "+
                "FROM RUNWAYS LEFT JOIN AIRPORTS ON AIRPORTS.IDENT = RUNWAYS.AIRPORT_ID "+
                "LEFT JOIN COUNTRIES ON COUNTRIES.CODE = AIRPORTS.ISO_CODE" );
            resultSet = st.executeQuery();
            
        }
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
            e.printStackTrace();
        } 
        return resultSet;
   }
    
}
