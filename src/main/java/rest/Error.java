package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("error")
public class Error {

  @GET
  public int getError(){
    return 123/0;
  }
}
