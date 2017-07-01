package json;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class CreateJob {

	public static void main(String[] args) {

       JsonObjectBuilder builder = Json.createObjectBuilder();
       builder.add("id", "PROG");
       builder.add("title", "Programmer");
       
       
       
       JsonObject job = builder.build();
       System.out.println(job.toString());
       
       
	}

}
