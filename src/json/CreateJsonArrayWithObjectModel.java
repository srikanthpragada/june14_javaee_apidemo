package json;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class CreateJsonArrayWithObjectModel {

	public static void main(String[] args) {
		 JsonArrayBuilder productsBuilder = Json.createArrayBuilder();
		 
		 JsonObjectBuilder  builder = Json.createObjectBuilder();
		 builder.add("id", 1);
		 builder.add("name", "iPhone 7 plus");
		 builder.add("price", 65000);
		 productsBuilder.add(builder.build());
		 
		 builder = Json.createObjectBuilder();
		 builder.add("id", 2);
		 builder.add("name", "Dell Laptop");
		 builder.add("price", 55000);
		 productsBuilder.add(builder.build());
		 
		 JsonArray products = productsBuilder.build();
				 
		 System.out.println( products);
		 
		 

	}

}
