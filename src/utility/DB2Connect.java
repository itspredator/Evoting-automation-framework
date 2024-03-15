package utility;

/**
 * @author Rubal Bansal
 * @reviewed Snehal More
 * @version 1.0
 * @Description This class is used to connect database
 * 
 */


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB2Connect {

	public static String jdbcClassName = "com.ibm.db2.jcc.DB2Driver";
	public static String url;
	public static String user;
	public static String password;
	public static Connection connection = null;
	public static Statement statement;
	public static Statement statement2;
	public static Statement statement3;	
	public static Statement statement4;	
	// static Properties properties = new Properties();
	static InputStream inputStream = null;
	private static  ConfigReader configReader= new ConfigReader();
     static Properties prop=configReader.init_prop();
	//Database credentials validated
	public static void databaseCredentials() throws IOException {
		
    	
		
		url = prop.getProperty("DATABASE_URL");
		user = prop.getProperty("DATABASE_USER");
		password = prop.getProperty("DATABASE_PASSWORD");
	}
	
	//Connecting application database db2 	
	public static void connect(){
		try{
			try {
				databaseCredentials();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Class.forName(jdbcClassName).newInstance();
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("connected database");
			statement=connection.createStatement();
			statement2=connection.createStatement();
			statement3=connection.createStatement();
			statement4=connection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Establish connection
		catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	//Database disconnected 
	public static void tearDownSQL() throws Exception{
		connection.close();
	}

}
