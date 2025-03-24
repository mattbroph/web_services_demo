package com.mattbroph.persistence;



import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.*;
import com.mattbroph.swapi.Planet;
//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.*;

public class SwapiDao {


    /**
     * Demonstrates how to create a Planet object with Object Mapper.
     * Planet class was created using RoboPojoGenerator from response json
     */
     public Planet getPlanet() {
        // TODO add a param to get the "1" param

         Client client = ClientBuilder.newClient();
         // TODO read in the uri from a properties file
         WebTarget target =
                 client.target("https://swapi.info/api/planets/1");
         String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

         // Create a planet object us ObjectMapper (imported via fasterxml.jackson.databind*;)
         ObjectMapper mapper = new ObjectMapper();
         Planet planet = null;

         try {
             planet = mapper.readValue(response, Planet.class);
         } catch (JsonProcessingException e) {
            // TODO setup logging and write this to the log
            e.printStackTrace();
         }

         return planet;

     }


}
