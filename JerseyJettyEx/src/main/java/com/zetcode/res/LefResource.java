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

import dao.Dao;
import dao.Map;
import dao.Places;
import dao.User;
import dao.UserDao;

import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/login")
public class LefResource {

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String logIn(@FormParam("email") String name,@FormParam("pass") String motDePasse) {
    	UserDao userDao = Dao.getUserDao();
    	User user = userDao.getUserByEmail(name);
    	if(Objects.isNull(user)) {
    		return "Email ou mot de passe incorrect";
    	}
    	else if(user.getPassword().equals(motDePasse)) {
    		return "Connecté";
    	} else {
    		return "EMail ou mot de passe incorrect";
    	}
    }
    
    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register(@FormParam("email") String name,@FormParam("pass") String motDePasse) {
    	if(Objects.isNull(name) ||Objects.isNull(motDePasse)) {
    		return "Remplir tout les champs";
    	}
    	UserDao userDao = Dao.getUserDao();
    	if(!Objects.isNull(userDao.getUserByEmail(name))){
    		return "L'utilisateur existe déjà";
    	}
    	User nouveau = new User();
    	nouveau.setEmail(name);
    	nouveau.setPassword(motDePasse);
    	userDao.addUser(nouveau);
    	return "Utilisateur ajouté";
    }
}
