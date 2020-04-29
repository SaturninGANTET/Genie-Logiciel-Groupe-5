package com.zetcode.res;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import dao.Map;
import dao.Places;
import dao.User;

import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;

import java.util.ArrayList;
import java.util.List;

@Path("/lef")
public class ConnexionResource {
    @PUT
    @Path("putmessage/{id}/{mdp}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String putMessage(@PathParam("id") String name,@PathParam("mdp") String motDePasse,@QueryParam("description") @DefaultValue ("Ce lieu ne contient pas encore de description") String description) {
        return "Tentative de Connexion de " + name + " avec le mdp : " + motDePasse +"avec comme description :" + description;
    }
}
