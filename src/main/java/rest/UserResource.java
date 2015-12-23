package rest;

import annotation.UserParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.User;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "/user", description = "Operations about user")
public class UserResource {

  @GET
  @ApiOperation(value = "Return user data", response = User.class)
  public Response user(@NotNull @Valid @UserParam User user) {
    return Response.ok(user, MediaType.APPLICATION_JSON)
                   .build();
  }
}


