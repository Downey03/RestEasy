
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import javax.swing.text.Utilities;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

@Path("/")
public class StudentService {

    public static String getRequestBody(HttpServletRequest request) {
        StringBuilder jb = new StringBuilder();

        try {
            BufferedReader reader = request.getReader();

            String line;
            while((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception var4) {
        }
        return jb.toString();
    }


    @GET
    @Path("students")
    public Response getStudents(){
        return  Response.ok(new Gson().toJson(DataService.getData())).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("student")
    public Response addStudent(@Context HttpServletRequest req,@Context Student student){
//        System.out.println(student.toString());
        Student student1 = new Gson().fromJson(new StringReader(getRequestBody(req)),Student.class);

        Student student2 = new Student("nak", 3,"saf" );
       var map = DataService.getData();
       map.put(5,student2);
       map.put(1,student1);
        System.out.println(map);
       return Response.created(URI.create("/student/1")).build();
    }

    @GET
    @Path("student/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent(@PathParam("id") int id) throws IOException {
        Student student = DataService.getData().get(id);
        return Response.ok(new Gson().toJson(student)).build();
    }

    @PUT
    @Path("student/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(@PathParam("id") int id, @Context HttpServletRequest req){
        Student student = new Gson().fromJson(new StringReader(getRequestBody(req)),Student.class);
        DataService.getData().put(id,student);
        return Response.accepted().build();
    }

    @DELETE
    @Path("student/{id}")
    public Response deleteStudent(@PathParam("id") int id){
        DataService.getData().remove(id);
        return Response.noContent().build();
    }

}
