package edu.learn.rest.RestfulWebservices.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import edu.learn.rest.RestfulWebservices.Dao.StudentDao;
import edu.learn.rest.RestfulWebservices.model.Student;
@Path("/student")

public class StudentServices {

    @GET
    //@Produces(MediaType.TEXT_XML)
    @Produces("application/json")
    public List<Student> getAllStudents() throws Exception {
    	StudentDao dao = new StudentDao();
        List students = dao.getAllStudents();
        return students;
    }
    
    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response addStudent(Student st) throws Exception{
        st.setMarks(st.getMarks());
        st.setSid(st.getSid());
        st.setSname(st.getSname());
                
        StudentDao dao = new StudentDao();
        dao.addStudent(st);
        
        return Response.ok().build();
    }
    
    @POST
    @Path("/createform")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   // @Consumes("application/json")
    public Response addStudent(@FormParam("sname") String sname, @FormParam("smarks") String smarks, @FormParam("sid") String sid) throws Exception{
    	Student st = new Student();
    	
    	System.out.println("Here is the sname "+sname);
        st.setMarks(Integer.parseInt(smarks));
        st.setSid(Integer.parseInt(sid));
        st.setSname(sname);
    
        StudentDao dao = new StudentDao();
        dao.addStudent(st);
    	
    	return Response.status(200)
    			.entity("addstudent is called, name : " + sname + ", marks : " + smarks + ",id: " +sid )
    			.build();
        
        //return Response.ok().build();
    }
    @PUT
    @Path("/update/{sid}")
    @Consumes("application/json")
    public Response updateStudent(@PathParam("sid") int sid, Student st) throws Exception{
    	StudentDao dao = new StudentDao();
        int count = dao.updateStudent(sid, st);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/delete/{sid}")
    @Consumes("application/json")
    public Response deleteStudent(@PathParam("sid") int sid) throws Exception{
    	StudentDao dao = new StudentDao();
        int count = dao.deleteStudent(sid);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    
}
