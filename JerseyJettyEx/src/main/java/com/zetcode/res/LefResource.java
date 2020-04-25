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
import javax.ws.rs.FormParam;

import java.util.ArrayList;
import java.util.List;

@Path("/login")
public class LefResource {

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String putMessage(@FormParam("email") String name,@FormParam("pass") String motDePasse) {
        return "Tentative de Connexion de " + name + " avec le mdp : " + motDePasse;
    }
}
