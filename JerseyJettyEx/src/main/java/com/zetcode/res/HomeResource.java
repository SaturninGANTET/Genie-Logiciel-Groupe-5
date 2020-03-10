package com.zetcode.res;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import exercice3.Map;
import exercice3.Places;
import exercice3.User;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;

@Path("/home")
public class HomeResource {

    @PUT
    @Path("addplace/{id}/{map}/{coord}/{title}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String addPlace(@PathParam("id") String id,@PathParam("map") String map,@PathParam("coord") String coord,@PathParam("title") String title,@QueryParam("description") @DefaultValue ("Ce lieu ne contient pas encore de description") String description) {
        return "Ajout d'un lieu favori nommé : " + title + " à la map : " + map + " par l'utilisateur : " + id + " aux coordonnées : " + coord + " avec comme desciption : " + description;
    }

    @GET
    @Path("infoplace/{id}/{map}/{coord}")
    @Produces(MediaType.APPLICATION_JSON)
    public Places infoPlace(@PathParam("id") String id,@PathParam("map") String map,@PathParam("coord") String coord) {
        return new Places();
    }
    
    @GET
    @Path("closestplace/{id}/{map}/{position}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Places> closestPlace(@PathParam("id") String id,@PathParam("map") String map,@PathParam("position") String position) {
        List<Places> test = new ArrayList<Places>();
        test.add(new Places());
        test.add(new Places());
        return test;
    }
    
    @GET
    @Path("othermap/{id}/{map}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map> otherMap(@PathParam("id") String id,@PathParam("map") String map) {
        List<Map> test = new ArrayList<Map>();
        test.add(new Map());
        test.add(new Map());
        return test;
    }
    
    @GET
    @Path("adressbook/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> friendList(@PathParam("id") String id) {
        List<User> test = new ArrayList<User>();
        	test.add(new User());
        	test.add(new User());
        	return test;
    }
    
    @GET
    @Path("adressbook/friendmap/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map> friendMap(@PathParam("id") String id) {
        List<Map> test = new ArrayList<Map>();
        test.add(new Map());
        test.add(new Map());
        return test;
    }
    
    @PUT
    @Path("adressbook/{id}/{friend-id}")
    public List<Map> addFriend(@PathParam("id") String id,@PathParam("friend-id") String friend) {
        List<Map> test = new ArrayList<Map>();
        test.add(new Map());
        test.add(new Map());
    	return test;
    }
    
    @DELETE
    @Path("adressbook/{id}/{friend-id}")
    public List<User> removeFriend(@PathParam("id") String id,@PathParam("friend-id") String friend) {
        List<User> test = new ArrayList<User>();
    	test.add(new User());
    	test.add(new User());
    	return test;
    }
    
    @POST
    @Path("addmodifyplace/{id}/{map}/{coord}")
    public List<Places> modifyPlace(@PathParam("id") String id,@PathParam("map") String map,@PathParam("coord") String coord,@QueryParam("description") String description) {
        List<Places> test = new ArrayList<Places>();
        test.add(new Places());
        test.add(new Places());
        return test;
    }
    
    @DELETE
    @Path("addmodifyplace/{id}/{map}/{coord}")
    public List<Places> removePlace(@PathParam("id") String id,@PathParam("map") String map,@PathParam("coord") String coord) {
        List<Places> test = new ArrayList<Places>();
        test.add(new Places());
        test.add(new Places());
        return test;
    }
}	
