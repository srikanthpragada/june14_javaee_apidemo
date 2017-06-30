package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		// Step 1
		try (Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

			System.out.println("Connected with " + con.getClass().toString());
			
			Statement st = con.createStatement();
			
			System.out.println("Using statement " + st.getClass().toString());
				

		}

	}

}
