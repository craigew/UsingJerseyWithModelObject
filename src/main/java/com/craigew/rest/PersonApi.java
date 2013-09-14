package com.craigew.rest;

import com.craigew.model.PersonResponse;
import com.craigew.model.Person;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonApi {

    @Path("/greet")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject sayHello() {
        try {
            return new JSONObject().put("greeting", "Hello world");
        } catch (JSONException e) {
            return null;
        }

    }

    @Path("/greet/{name}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse sayHelloToSomeone(@PathParam("name") String name){
        PersonResponse personResponse =new PersonResponse();
        personResponse.setResponse("Hello " + name);
        return personResponse;
    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse createAPerson(Person person){
        System.out.println("Creating a person");
        PersonResponse personResponse =new PersonResponse();
        personResponse.setResponse(person.getName() + " " + person.getSurname() + " added to the database");
        return personResponse;
    }

    @Path("/update/{personId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse updateAPerson(@PathParam("personId") int personId,Person person){
        System.out.println("Updating a person");
        PersonResponse personResponse =new PersonResponse();
        personResponse.setResponse(person.getName() + " " + person.getSurname() + " with id " + personId + " updated in the database");
        return personResponse;
    }

    @Path("/remove/{personId}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse removeAPerson(@PathParam("personId") int personId){
        System.out.println("Deleting a person");
        PersonResponse personResponse =new PersonResponse();
        personResponse.setResponse(personId + " removed from the database");
        return personResponse;
    }
}
