package fr.univtours.polytech.tpnote2.rest;


import java.util.List;

import fr.univtours.polytech.tpnote2.business.MovieBusinessImpl;
import fr.univtours.polytech.tpnote2.model.LocationBean;
import fr.univtours.polytech.tpnote2.model.MovieBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
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
    public List<MovieBean> getLocations() {
        return lbr.getMovies();
    }
    
    @DELETE
    @Path("locations/{id}")
    @HeaderParam(jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteLocation(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorizationToken , @PathParam("id") Integer id){
        if(authorizationToken != null && authorizationToken.equals("42")){
            lbr.deleteLocation(id);
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
    @Path("locations")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createLocation(LocationBean locationBean) {
        System.out.println("ici");
        if(locationBean != null){
            lbr.addLocation(locationBean);
            return Response.status(Status.CREATED).build();
        }else{
            return Response.status(Status.FORBIDDEN).build();
        }
    }

    // Méthode appelée lorsqu'on soumet un formulaire HTML.
    @POST
    @Path("locations2")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createLocation(@FormParam("address") String address,
            @FormParam("city") String city,
            @FormParam("nightPrice") Double price,
            @FormParam("zipCode") String zipCode) {
                System.out.println("la");
                LocationBean locationBean = new LocationBean();
                locationBean.setAddress(address);
                locationBean.setCity(city);
                locationBean.setNightPrice(price);
                locationBean.setZipCode(zipCode);
                return Response.status(Status.CREATED).build();
        
    }

    //ne marche pas
    @PUT
    @Path("locations/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateLocation(LocationBean locationBean, @PathParam("id") Integer id){
        if(locationBean != null){
            //locationBean2 est l'ancien bean, celui qui contient les anciennes infos à MAJ
            //locationBean est le bean qui contient les nouvelles infos
            LocationBean locationBean2 = lbr.getLocation(id);

            locationBean2.setAddress(locationBean.getAddress());
            locationBean2.setCity(locationBean.getCity());
            locationBean2.setNightPrice(locationBean.getNightPrice());
            locationBean2.setZipCode(locationBean.getZipCode());
        
            lbr.updateLocation(locationBean2);
            return Response.ok().build();
        }else{
            return Response.status(Status.UNAUTHORIZED).build();
        }
    }

    //ne marche pas
    @PATCH
    @Path("locations/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateLocation2(LocationBean locationBean, @PathParam("id") Integer id){
        LocationBean locationBean2 = lbr.getLocation(id);
        if(locationBean.getAddress() != null && locationBean.getAddress() != ""){
            locationBean2.setAddress(locationBean.getAddress());            
        }
        if(locationBean.getCity() != null && locationBean.getCity() != ""){
            locationBean2.setCity(locationBean.getCity());
        }
        if(locationBean.getNightPrice() != null){
            locationBean2.setNightPrice(locationBean.getNightPrice());
        }
        if(locationBean.getZipCode() != null && locationBean.getZipCode() != ""){
            locationBean2.setZipCode(locationBean.getZipCode());
        }
        if(locationBean.getLatitude() != null && locationBean.getLatitude() != 0D){
            locationBean2.setLatitude(locationBean.getLatitude());
        }
        if(locationBean.getLongitude() != null && locationBean.getLongitude() != 0D){
            locationBean2.setLongitude(locationBean.getLongitude());
        }
        return Response.status(Status.CREATED).build();
        
    }
}
