/*
 * Client
 * This class is called from the JSP files to get the data from the RESTful 
 * Webservice that communicates with the database
 */
package com.lunatech.airports.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

/**
 * Class ClientQuery
 * @author Antria
 */
public class ClientQuery {
    ClientConfig config ;
    Client client;
    WebTarget target ;
    
    /**
     * Establish connection with REST
     */
    public ClientQuery(){
        config = new ClientConfig();
        client = ClientBuilder.newClient(config);
        target = client.target(getBaseURI()); 
    }
    
    /**
     * Connect with URI
     * @return URI with rest API
     */
    private static URI getBaseURI() {
        return UriBuilder.fromUri(
                "http://localhost:8080/com.lunatech.airports").build();
    }
    
    /**
     * Call the method to get the top 10 countries with the most airports
     * @return String with html tags to create a table
     */
    public String top10(){
        return target.path("rest").path("queries").path("top10").request().accept(MediaType.TEXT_PLAIN).get(String.class);
    }
    
    /**
     * Call the method to get the top 10 countries with the least airports
     * @return String with html tags to create a table
     */
    public String top10Low(){
        return target.path("rest").path("queries").path("top10low").request().accept(MediaType.TEXT_PLAIN).get(String.class);
    }
    
    /**
     * Call the method to get the top 10 most common runways identification with the most airports
     * @return String with html tags to create a table
     */
    public String commonRunways(){
        return target.path("rest").path("queries").path("commonRunways").request().accept(MediaType.TEXT_PLAIN).get(String.class);
    }
    
    /**
     * Call the method to get the surfaces for each country
     * @return String with html tags to create a table
     */
    public String surface(){
        return target.path("rest").path("queries").path("surface").request().accept(MediaType.TEXT_PLAIN).get(String.class);
    }
    
    /**
     * Get the runways for the specific country
     * @param country input from text box
     * @return String with html tags to create a table
     */
    public String getRunways(String country){
        return target.path("rest").path("queries").path("runways/"+country).request().accept(MediaType.TEXT_PLAIN).get(String.class);
    }
    
    /**
     * Get the airports for the specific country
     * @param country input from text box
     * @return String with html tags to create a table
     */
    public String getAirports(String country){
        return target.path("rest").path("queries").path("airports/"+country).request().accept(MediaType.TEXT_PLAIN).get(String.class);
    }
    
    public static void main(String[] args) {
        ClientQuery q = new ClientQuery();
        System.out.println(q.top10());
        System.out.println(q.top10Low());
        System.out.println(q.commonRunways());
        System.out.println(q.surface());
        
        System.out.println(q.getRunways("CY"));
        System.out.println(q.getAirports("CY"));
    }
}
