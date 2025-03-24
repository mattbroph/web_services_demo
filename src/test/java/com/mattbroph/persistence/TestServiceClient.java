package com.mattbroph.persistence;

import com.fasterxml.jackson.databind.*;
import com.swapi.Planet;

import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    // IN YOUR PROJECT
    // You will have a dao that has this code in it
    // You would have the URI loaded into a properties file
    // Have a unit test to have a particular class
    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://swapi.info/api/planets/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // Create a planet object us ObjectMapper (imported via fasterxml.jackson.databind*;)
        ObjectMapper mapper = new ObjectMapper();
        Planet planet = mapper.readValue(response, Planet.class);

        // Test that the object was created properly
        assertEquals("Tatooine", planet.getName());



    }
}