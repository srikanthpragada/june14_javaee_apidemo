package json;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class CreateJsonWithObjectModel {

	public static void main(String[] args) {

		 JsonObjectBuilder  builder = Json.createObjectBuilder();
		 builder.add("id", 1);
		 builder.add("name", "iPhone 7 plus");
		 builder.add("price", 65000);
		 
		 JsonObject product = builder.build();
		 
		 System.out.println( product);
		 
		 

	}

}
