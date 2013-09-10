package com.craigew.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/greetings")
public class HelloWorld {

    @Path("/hello")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello(){
        return "hello world";
    }

    @Path("/hello/{name}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHelloToSomeone(@PathParam("name") String name){
        return new StringBuilder().append("Hello ")
                .append(name).toString();
    }
}
