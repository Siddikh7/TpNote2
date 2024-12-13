package fr.univtours.polytech.tpnote2.rest;


import java.util.List;

import fr.univtours.polytech.tpnote2.business.MovieBusinessImpl;
import fr.univtours.polytech.tpnote2.model.MovieBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;


@Path("v1.0.0")
public class MovieRest {

    @Inject
    private MovieBusinessImpl lbr;

    @GET
    @Path("locations")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<MovieBean> getMovies() {
        return lbr.getMovies();
    }
    
    @DELETE
    @Path("movies/{id}")
    @HeaderParam(jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteMovie(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorizationToken , @PathParam("id") Integer id){
        if(authorizationToken != null && authorizationToken.equals("42")){
            lbr.deleteMovie(id);
            return Response.ok().build();
            //return Response.ok(this.locationBusiness.getLocations()).build(); //pour ajouter la liste des beans dans la réponse
        }else if(authorizationToken == null){
            return Response.status(Status.UNAUTHORIZED).build();
        }else if(authorizationToken != null && !authorizationToken.equals("42")){
            return Response.status(Status.FORBIDDEN).build();
        }else{
            return Response.status(Status.NOT_FOUND).build();
        }
        
    }

    // Méthode appelée lorsqu'on ajoute toutes les informations dans le corps de la requête.
    @POST
    @Path("movies")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createMovie(MovieBean movieBean) {
        System.out.println("ici");
        if(movieBean != null){
            lbr.addMovie(movieBean);
            return Response.status(Status.CREATED).build();
        }else{
            return Response.status(Status.FORBIDDEN).build();
        }
    }

    // // Méthode appelée lorsqu'on soumet un formulaire HTML.
    // @POST
    // @Path("movies2")
    // @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    // public Response addMovie(@FormParam("address") String address,
    //         @FormParam("city") String city,
    //         @FormParam("nightPrice") Double price,
    //         @FormParam("zipCode") String zipCode) {
    //             System.out.println("la");
    //             MovieBean movieBean = new MovieBean();
    //             movieBean.setNote(zipCode);
    //             movieBean.setTitle(city);
    //             return Response.status(Status.CREATED).build();
        
    // }

    //ne marche pas
    @PUT
    @Path("movies/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateLocation(MovieBean movieBean, @PathParam("id") Integer id){
        if(movieBean != null){
            //locationBean2 est l'ancien bean, celui qui contient les anciennes infos à MAJ
            //locationBean est le bean qui contient les nouvelles infos
            MovieBean movieBean2 = lbr.getMovie(id);

            movieBean.setNote(movieBean.getNote());
            movieBean.setTitle(movieBean.getTitle());

            lbr.updateMovie(movieBean2);
            return Response.ok().build();
        }else{
            return Response.status(Status.UNAUTHORIZED).build();
        }
    }

    //ne marche pas
    @PATCH
    @Path("movies/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateMovie2(MovieBean movieBean, @PathParam("id") Integer id){
        MovieBean movieBean2 = lbr.getMovie(id);
        /*if(movieBean.getNote() != null && movieBean.getNote() != null){
            movieBean2.setNote(0);(movieBean.getNote());            
        }*/
        if(movieBean.getTitle() != null && movieBean.getTitle() != ""){
            movieBean2.setTitle(movieBean.getTitle());
        }
        return Response.status(Status.CREATED).build();
        
    }
}
