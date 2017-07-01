package json;

import java.util.ArrayList;

import com.google.gson.Gson;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CreateJsonFromJobsWithGson {

	public static void main(String[] args) throws Exception {
	 
		OracleCachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select * from jobs");
		crs.execute();
		
		ArrayList<Job> jobs = new ArrayList<>();
		while( crs.next()) {
		      Job j = new Job(crs.getString(1), crs.getString(2));
			  jobs.add(j);
		}
		
		Gson gson = new Gson();
		System.out.println( gson.toJson(jobs));
		
	}

}
