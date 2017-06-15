package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateSalary {

	public static void main(String[] args) throws Exception {

		try (Connection con = 
				 DriverManager.getConnection
				   ("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

			Statement st = con.createStatement();
			int count = st.executeUpdate
					("update employees set salary = 6000 where employee_id =1111");
			if(count == 1)
				System.out.println("Updated!");
			else
				System.out.println("Employee Id Not Found!");
		}

	}

}
