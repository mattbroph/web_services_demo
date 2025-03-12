package com.mattbroph.persistance;

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
        assertEquals("{\n" +
                "\t\"name\": \"Tatooine\",\n" +
                "\t\"rotation_period\": \"23\",\n" +
                "\t\"orbital_period\": \"304\",\n" +
                "\t\"diameter\": \"10465\",\n" +
                "\t\"climate\": \"arid\",\n" +
                "\t\"gravity\": \"1 standard\",\n" +
                "\t\"terrain\": \"desert\",\n" +
                "\t\"surface_water\": \"1\",\n" +
                "\t\"population\": \"200000\",\n" +
                "\t\"residents\": [\n" +
                "\t\t\"https://swapi.info/api/people/1\",\n" +
                "\t\t\"https://swapi.info/api/people/2\",\n" +
                "\t\t\"https://swapi.info/api/people/4\",\n" +
                "\t\t\"https://swapi.info/api/people/6\",\n" +
                "\t\t\"https://swapi.info/api/people/7\",\n" +
                "\t\t\"https://swapi.info/api/people/8\",\n" +
                "\t\t\"https://swapi.info/api/people/9\",\n" +
                "\t\t\"https://swapi.info/api/people/11\",\n" +
                "\t\t\"https://swapi.info/api/people/43\",\n" +
                "\t\t\"https://swapi.info/api/people/62\"\n" +
                "\t],\n" +
                "\t\"films\": [\n" +
                "\t\t\"https://swapi.info/api/films/1\",\n" +
                "\t\t\"https://swapi.info/api/films/3\",\n" +
                "\t\t\"https://swapi.info/api/films/4\",\n" +
                "\t\t\"https://swapi.info/api/films/5\",\n" +
                "\t\t\"https://swapi.info/api/films/6\"\n" +
                "\t],\n" +
                "\t\"created\": \"2014-12-09T13:50:49.641000Z\",\n" +
                "\t\"edited\": \"2014-12-20T20:58:18.411000Z\",\n" +
                "\t\"url\": \"https://swapi.info/api/planets/1\"\n" +
                "}\n", response);
        // Adding some comment
    }
}