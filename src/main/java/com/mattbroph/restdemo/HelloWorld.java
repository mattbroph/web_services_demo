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

        /**
         *  Responds with a dynamic message to the client in html format
         *  Url to hit is http://localhost:8080/week_8_web_services_war/services/greetings/{name}/html
         *
         * @param name the name to use in the message
         * @return a dynamic message that includes the name param in html format
         */
        @GET
        @Path("{name}/html")
        @Produces("text/html")
        public Response getMessageWithNameParamReturnHtml(@PathParam("name") String name) {
            // Return a dynamic message with the name that was passed in
            String output = "<html><body><h1>Hello " + name + "!</h1></body></html>";
            return Response.status(200).entity(output).build();
        }

        /**
         *  Responds with a dynamic message to the client in json format
         *  Url to hit is http://localhost:8080/week_8_web_services_war/services/greetings/{name}/json
         *
         * @param name the name to use in the message
         * @return a dynamic message that includes the name param in json format
         */
        @GET
        @Path("{name}/json")
        @Produces("application/json")
        public Response getMessageWithNameParamReturnJson(@PathParam("name") String name) {
            // Return a dynamic message with the name that was passed in
            String output = "{ \"message\": \"Hello " + name + "!\" }";
            return Response.status(200).entity(output).build();
        }


    }