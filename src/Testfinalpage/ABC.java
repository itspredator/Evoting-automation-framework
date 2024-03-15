package Testfinalpage;
import java.util.Properties;
import utility.ConfigReader;

public class ABC {

	static Properties properties;
	
	public ABC() 
	{
		properties = ConfigReader.init_prop();
		
	}
	
	public static void main(String[] args) {
		System.out.println(properties.getProperty("Voting_Type"));
	}

}
