package jdbc;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class ListJobsUsingRowSet {

	public static void main(String[] args) throws Exception {

		try (CachedRowSet crs = new OracleCachedRowSet())
		{
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs order by 1");
			crs.execute();
			
			crs.absolute(20);
		
			while(crs.next()) 
			{
				// System.out.printf("%30s  %8d\n",rs.getString(1), rs.getInt(2));
				System.out.printf("%-35s  %8d\n",crs.getString("job_title"),
						 crs.getInt("max_salary"));
			}
		}

	}

}
