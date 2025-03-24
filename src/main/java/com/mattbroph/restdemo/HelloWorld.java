package com.mattbroph.restdemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

    @Path("/greetings")
    public class HelloWorld {

        /**
         *  Responds with a simple message to the client.
         *  Url to hit is http://localhost:8080/week_8_web_services_war/services/greetings
         *
         * @return a simple static message
         */
        // The Java method will process HTTP GET requests
        @GET
        // The Java method will produce content identified by the MIME Media type "text/plain"
        @Produces("text/plain")
        public Response getMessage() {
            // Return a simple message
            String output = "Hello World";
            return Response.status(200).entity(output).build();
        }

        /**
         *  Responds with a dynamic message to the client.
         *  Url to hit is http://localhost:8080/week_8_web_services_war/services/greetings/{name}
         *
         * @param name the name to use in the message
         * @return a dynamic message that includes the name param
         */
        @GET
        @Path("{name}")
        @Produces("text/plain")
        public Response getMessageWithNameParam(@PathParam("name") String name) {
            // Return a dynamic message with the name that was passed in
            String output = "Hello " + name + "!";
            return Response.status(200).entity(output).build();
        }

    }