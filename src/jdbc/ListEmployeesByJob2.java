package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ListEmployeesByJob2 {

	public static void main(String[] args) throws Exception {

		try (Connection con = 
				 DriverManager.getConnection
				   ("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			
			// Take input
			Scanner s = new Scanner(System.in);
			System.out.print("Enter job id :");
			String jobid = s.nextLine();
			
			PreparedStatement ps = con.prepareStatement
					 ("select first_name, salary from employees where job_id = ?");
			
			ps.setString(1, jobid);  // replace parameter (?) with value 
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				System.out.printf("%-15s  %8d\n",rs.getString("first_name"),
						 rs.getInt("salary"));
			}
			
			rs.close();
			ps.close();
		}

	}

}
