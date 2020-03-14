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

@Path("/connexion")
public class ConnexionResource {

    @PUT
    @Path("getmessage/{id}/{mdp}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String getMessage(@PathParam("id") String name,@PathParam("mdp") String motDePasse) {
        return "Tentative de Connexion de " + name + " avec le mdp : " + motDePasse;
    }
}



/*
@Path("rien")
public class MyMessage {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "My message\n";
    }
}
*/
