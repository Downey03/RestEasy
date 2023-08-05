
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

@Path("/student")
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("") public Response addStudent(CLie){
        System.out.println(student.toString());
//        Student student1 = new Gson().fromJson(new StringReader(getRequestBody(req)),Student.class);

       var map = DataService.getData();
       map.put(map.size()+1,student);
        System.out.println(map);
       return Response.created(URI.create("/student/1")).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedia(@PathParam("id") int id) throws IOException {
        return Response.ok(DataService.getData().get(id)).build();
    }

}
