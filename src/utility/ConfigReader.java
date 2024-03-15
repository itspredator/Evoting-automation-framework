package utility;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static ConfigReader instance=null;
	private Properties prop;




	//case of encapsulation and this class used to load the config.properties file
	// return properties prop object
	@SuppressWarnings("unused")
	private ConfigReader() 
	{

		// TODO Auto-generated constructor stub

		prop=new Properties();
		try {
			FileInputStream ip = new FileInputStream("D:\\Pinkesh\\EVOTINGAUTOMATION\\configuration\\config.properties");
			prop.load(ip);
			ip.close();
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
	}

	public static ConfigReader getinstance()
	{
		if (instance==null)
		{
			instance=new ConfigReader();
		}
		return instance;
	}
	public String getProprty(String key)
	{
		return prop.getProperty(key);
	}

}
