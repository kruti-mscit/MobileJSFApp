/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.MobileBeanLocal;
import entity.Category;
import entity.Mobile;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author kruti
 */
@Path("mobile")
@RequestScoped
public class RestMobileResource {

    @Context
    private UriInfo context;
    
    @EJB MobileBeanLocal mbl;

    /**
     * Creates a new instance of RestMobileResource
     */
    public RestMobileResource() {
    }

    @Path("addCat/{catname}")
    @POST
    public void addCat(@PathParam("catname") String catname) {
        mbl.addCat(catname);
    }

    @Path("deleteCat/{catid}")
    @DELETE
    public void deleteCat(@PathParam("catid") Integer catid) {
        mbl.deleteCat(catid);
    }
    
    @Path("getAllCats")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getAllCats() {
        return mbl.getAllCats();
    }

    @Path("addMobile/{company}/{model}/{year}/{memory}/{catid}")
    @POST
    public void addMobile(@PathParam("company") String company,@PathParam("model") String model,@PathParam("year") int year,@PathParam("memory") int memory,@PathParam("catid") Integer catid) {
        mbl.addMobile(company, model, year, memory, catid);
    }

    @Path("deleteMobile/{mobileid}")
    @DELETE
    public void deleteMobile(@PathParam("mobileid") Integer mobileid) {
        mbl.deleteMobile(mobileid);
    }

    @Path("getAllMobiles")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Mobile> getAllMobiles() {
        return mbl.getAllMobiles();
    }

//    @Path("getAllMobilesByFilter")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<Mobile> getAllMobilesByFilter(Collection<String> company, Collection<String> category, Collection<Integer> memory) {
//        return mbl.getAllMobilesByFilter(company, category, memory);
//    }
    
    @Path("getAllMobilesByFilter")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Mobile> getAllMobilesByFilter(Collection<String> category) {
        return mbl.getAllMobilesByFilter(null, category, null);
    }
    
    
    
    ///////////////////////////////////////////////////////////////////////////////
    //  1.  Push Code github along with steps to create new connection pool and jdbc resource
    //  2.  Try to create new connection pool
    //  3.  Try to run simple security and role based security
    //  4.  Try to run filter (search)
    //  5.  Try to think all steps (JPA,EJB,Rest,JSF)..
    //  6.  See bean logic part once..  (many to many)
    
}
