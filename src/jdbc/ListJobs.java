package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListJobs {

	public static void main(String[] args) throws Exception {

		try (Connection con = 
				 DriverManager.getConnection
				   ("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {

			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery
					 ("select job_title, max_salary from jobs order by 1");
			
			while(rs.next()) 
			{
				// System.out.printf("%30s  %8d\n",rs.getString(1), rs.getInt(2));
				System.out.printf("%-35s  %8d\n",rs.getString("job_title"),
						 rs.getInt("max_salary"));
			}
			
			rs.close();
			st.close();
		}

	}

}
