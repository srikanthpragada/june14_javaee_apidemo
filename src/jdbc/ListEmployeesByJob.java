package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ListEmployeesByJob {

	public static void main(String[] args) throws Exception {

		try (Connection con = 
				 DriverManager.getConnection
				   ("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

			Statement st = con.createStatement();
			
			Scanner s = new Scanner(System.in);
			System.out.print("Enter job id :");
			String jobid = s.nextLine();
			
			ResultSet rs = st.executeQuery
					 ("select first_name, salary from employees where job_id = '"
			                          + jobid + "'");
			
			while(rs.next()) 
			{
				System.out.printf("%-15s  %8d\n",rs.getString("first_name"),
						 rs.getInt("salary"));
			}
			
			rs.close();
			st.close();
		}

	}

}
