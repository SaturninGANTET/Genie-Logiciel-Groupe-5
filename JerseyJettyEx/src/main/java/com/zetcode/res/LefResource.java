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
import dao.Markeur;
import dao.MarkeurDao;
import dao.Places;
import dao.User;
import dao.UserDao;

import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Path("/lef")
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
    	
    @POST
    @Path("/marker/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String markerAdd(@FormParam("lat") Double lat,@FormParam("lng") Double lng) {
        MarkeurDao markeurDao = Dao.getMarkeurDao();
        Markeur mark = new Markeur();
        mark.setLatitude(lat);
        mark.setLongitude(lng);
        markeurDao.addMarkeur(mark);
        return "Marqueur ajouté";
   }
    
    @POST
    @Path("/marker/modifyName")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String markerModifyName(@FormParam("lat") double lat,@FormParam("lng") double lng, @FormParam("newName") String newName) {
        MarkeurDao markeurDao = Dao.getMarkeurDao();
        Markeur mark = markeurDao.getMarkeur(lng, lat);
        if(Objects.isNull(newName))
        	return "pas de nouveau nom";
        markeurDao.modifyMarkeurName(mark, newName);
        return "Marqueur modifié";
    }
    
    
    @GET
    @Path("/marker/get/{lat}/{lng}")
    @Produces(MediaType.TEXT_PLAIN)
    public String markerGet(@PathParam("lat") Double lat,@PathParam("lng") Double lng) {
        MarkeurDao markeurDao = Dao.getMarkeurDao();
        Markeur mark = markeurDao.getMarkeur(lng, lat);
    //    return lat + "" + lng;
        return  "<input id=\"ActualmarkName\">"+mark.getName()+"</span><br><br><button id=\"btn2\">add message</button><br><br><button id=\"btn3\">add picture</button><br>";
    }
    
    @DELETE
    @Path("/marker/delete/{lat}/{lng}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String markerDelete(@PathParam("lat") Double lat,@PathParam("lng") Double lng) {
    	MarkeurDao markeurDao = Dao.getMarkeurDao();
    	Markeur mark = markeurDao.getMarkeur(lng, lat);
    	markeurDao.deleteMarkeur(mark);
    	return "marquer supprimé";
    }
    
    @GET
    @Path("/marker/getAll")
    @Produces(MediaType.TEXT_PLAIN)
    public String markerGetAll() {
        MarkeurDao markeurDao = Dao.getMarkeurDao();
        List<Markeur> mark = markeurDao.getAllMarkeur();
        String ret = "";
        for(Markeur m : mark) {
        	ret += m.getLatitude() +"&" + m.getLongitude() + "\n";
        }
        return ret;
    }
    
}
