package edu.learn.rest.RestfulWebservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Helloworld {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String messgae(){
		return("Hello to restful webservices world Nicole..........!!!!!!!!!!!!!");
	}
	}