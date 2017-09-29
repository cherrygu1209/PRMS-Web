/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.radiopresenter.restful;

/**
 *
 * @author Raghu
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sg.edu.nus.iss.phoenix.radiopresenter.entity.RadioPresenter;
import sg.edu.nus.iss.phoenix.radiopresenter.restful.RadioPresenters;
import sg.edu.nus.iss.phoenix.radiopresenter.service.ReviewSelectPresenterService;

/**
 * REST Web Service
 *
 * @author Raghu
 */
@Path("radiopresenter")
@RequestScoped
public class PresenterRESTService {

    @Context
    private UriInfo context;
    
    private ReviewSelectPresenterService service;

    /**
     * Creates a new instance of RadioPresenterRESTService
     */
    public PresenterRESTService() {
        service = new ReviewSelectPresenterService();
    }

    /**
     * Retrieves representation of an instance of resource
     * @return an instance of resource
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RadioPresenter getRadioPresenter() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public RadioPresenters getAllRadioPresenters() throws SQLException {
        ArrayList<RadioPresenter> rplist = (ArrayList<RadioPresenter>) service.reviewSelectRadioPresenter();
        RadioPresenters rpsList = new RadioPresenters();
        rpsList.setRpList(new ArrayList<RadioPresenter>());
        
        for (int i = 0; i < rplist.size(); i++) {
            rpsList.getRpList().add(
                new RadioPresenter(rplist.get(i).getName()));
                    //rplist.get(i).getDescription(), 
                    //rplist.get(i).getTypicalDuration()));
        }

        return rpsList;
    }
   
    /**
     * PUT method for updating or creating an instance of resource
     * @param content representation for the resource
     */
    /* @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateRadioPresenter(RadioPresenter rp) {
        service.processModify(rp);
    }
    
    /**
     * POST method for creating an instance of resource
     * @param content representation for the resource
     */
   /* @PUT
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createRadioPresenter(RadioPresenter rp) {
        service.processCreate(rp);
    }
   
    /**
     * DELETE method for deleting an instance of resource
     * @param name name of the resource
     */
   /* @DELETE
    @Path("/delete/{rpname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteRadioPresenter(@PathParam("rpname") String name) {
        String name2;
        try { 
            name2 = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(); 
            return;
        }

        service.processDelete(name2);*/
    }
