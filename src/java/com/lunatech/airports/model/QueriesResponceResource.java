/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lunatech.airports.model;

/**
 *
 * @author Antria
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * RESTful API
 * Create and instance of the QueryResponce class and calls its functions and 
 * return them as a String with html tags
 * @author Antria
 */
@Path("/queries")
public class QueriesResponceResource {
    QueriesResponce q = new QueriesResponce();    
    
    /**
     * Calls countryQueryAirports method from QueriesResponce
     * @param country input data from text box 
     * @return String of the ResultSet from the method
     */
    @Path ("/airports/{country}")
    @GET
    public String getAirports(@PathParam("country") String country){
        String responce = "";
        ResultSet airports = q.countryQueryAirports(country);
        if(airports!= null){
            try {
                while(airports.next()){
                    responce += "<tr><td>" + airports.getString("IDENT")+"</td><td>"
                            + airports.getString("AIR_NAME")+"</td><td>" +
                            airports.getString("MUNICIPALITY") +"</td></tr>";    
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueriesResponceResource.class.getName()).log(Level.SEVERE, null, ex);
                return "<p>An error accured</p>";
            }
        }
        return responce;
    }
    
    
    /**
     * Calls countryQueryRunways method from QueriesResponce
     * @param country input data from text box 
     * @return String of the ResultSet from the method
     */
    @Path ("/runways/{country}")
    @GET
    public String getRunways(@PathParam("country") String country){
        String responce = "";
        ResultSet runways = q.countryQueryRunways(country);
        
        if(runways!= null){
            try {
                while(runways.next()){
                    responce += "<tr><td>" + runways.getString("CODE")+"</td><td>"+
                            runways.getString("COUNTRY_NAME")+"</td><td>"
                            +runways.getString("CONTINENT")+ "</td><td>"+
                            runways.getString("IDENT")+ "</td><td>" +
                            runways.getString("AIR_NAME") +"</td><td>"+
                            runways.getString("ID") +"</td><td>"+
                            runways.getString("SURFACE")+"</td><td>" +
                            runways.getString("LE_IDENT") +"</td></tr>";
                }
            } catch (SQLException ex) {
                Logger.getLogger(QueriesResponceResource.class.getName()).log(Level.SEVERE, null, ex);
                return "<p>An error accured</p>";
            }
        }
        return responce;
    }
    
    
    /**
     * Calls top10 method from QueriesResponce
     * @return String of the ResultSet from the method
     */
    @Path ("/top10")
    @GET
    @Produces( MediaType.TEXT_PLAIN) 
    public String getTop10(){
        String responce = "";
        ResultSet rs = this.q.top10();
        try {
            while(rs.next()){
                responce += "<tr><td>" +rs.getString("COUNTRY_NAME")+"</td><td>"
                        +rs.getString("AIR_COUNT") +"</td></tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueriesResponceResource.class.getName()).log(Level.SEVERE, null, ex);
            return "<p>An error accured</p>";
        }
        return responce;
    }
    
    /**
     * Calls top10low() method from QueriesResponce
     * @return String of the ResultSet from the method
     */
    @Path ("/top10low")
    @GET
    @Produces( MediaType.TEXT_PLAIN)
    public String getTop10Low() {
        String responce = "";
        ResultSet rs = this.q.top10low();
        try {
            while(rs.next()){
                responce += "<tr><td>" +rs.getString("COUNTRY_NAME")+"</td><td>"
                        +rs.getString("AIR_COUNT") +"</td></tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueriesResponceResource.class.getName()).log(Level.SEVERE, null, ex);
            return "<p>An error accured</p>";
        }
        return responce;
    }
    
    
    /**
     * Calls commonRunways() method from QueriesResponce
     * @return String of the ResultSet from the method
     */
    @Path ("/commonRunways")
    @GET
    @Produces( MediaType.TEXT_PLAIN)
    public String getCommonRunways(){
        String responce = "";
        ResultSet rs = this.q.commonRunways();
        
        try {
            while(rs.next()){
                responce +="<tr><td>" + rs.getString("LE_IDENT")+"</td>"
                        +" <td>" + rs.getString("LE_COUNT")+"</td></tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueriesResponceResource.class.getName()).log(Level.SEVERE, null, ex);
            return "<p>An error accured</p>";
        }
        return responce;
    }
    
    
    /**
     * Calls uniqueSurface() method from QueriesResponce
     * @return String of the ResultSet from the method
     */
    @Path ("/surface")
    @GET
    @Produces( MediaType.TEXT_PLAIN)
    public String getSurface(){
        String responce = "";
        ResultSet rs = this.q.uniqueSurface();
        
        try {
            while(rs.next()){
                responce +="<tr><td>" + rs.getString("COUNTRY_NAME")+"</td>"
                        +" <td>" + rs.getString("SURFACE")+"</td></tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueriesResponceResource.class.getName()).log(Level.SEVERE, null, ex);
            return "<p>An error accured</p>";
        }
        return responce;
    }
    
}
