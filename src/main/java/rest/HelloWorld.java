package rest;

import model.User;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloWorld {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String hello() {
    return "hello";
  }

  @Consumes(MediaType.APPLICATION_JSON)
  @POST
  public Response hello(@Valid User user) {
    return Response.ok(user, MediaType.APPLICATION_JSON)
                   .build();
  }
}


