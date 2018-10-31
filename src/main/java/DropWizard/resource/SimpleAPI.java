package DropWizard.resource;

import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by deepak.jayaprakash on 31/10/18.
 */
@Path("/simpleAPI")
@Produces(MediaType.APPLICATION_JSON)
public class SimpleAPI {

    @GET
    @Path("/getTest")
    public Response hystrixTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "value1");
        try {
            return Response.ok(jsonObject).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
