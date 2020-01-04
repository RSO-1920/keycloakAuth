package si.fri.rso.api.controllers;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;
import si.fri.rso.services.AuthBean;
import si.fri.rso.lib.KeycloakUserDTO;

import com.kumuluz.ee.logs.cdi.Log;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Log
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/auth")
public class AuthController {

    @Inject
    private AuthBean authBean;

    @GET
    // @RolesAllowed("uma_authorization")
    @Timed(name = "auth_time_all")
    @Counted(name = "auth_counted_all")
    @Metered(name = "auth_metered_all")
    public Response getAccessRights(@HeaderParam("authorization") String authToken, @HeaderParam("channelID") String channelID) {
        System.out.println("CONFIRM USER CREDENTIALS: " + authToken + "  CHANNEL ID: " + channelID);
        if(authBean.confirmUserCredentials(authToken, channelID))
            return Response.status(Response.Status.OK).entity("True").build();
        return Response.status(Response.Status.OK).entity("False").build();
    }

    @POST
    // @RolesAllowed("uma_authorization")
    @Timed(name = "auth_time_post")
    @Counted(name = "auth_counted_post")
    @Metered(name = "auth_metered_post")
    public Response successfulLogin(KeycloakUserDTO keycloakUserDTO) {
        authBean.saveLoginSession(keycloakUserDTO);
        return Response.status(Response.Status.OK).entity("Added Login Session to database").build();
    }


}
