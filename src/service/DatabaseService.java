package service;

import java.sql.SQLException;

public interface DatabaseService {

	
	public Details getDetails(String evenNo) throws SQLException;
	
	public int isExists(String batchId) throws SQLException;

}
