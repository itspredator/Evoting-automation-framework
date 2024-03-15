package Testfinalpage;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import pageobjects.RTA_loginpage;
import pageobjects.createeven;
import pageobjects.upload_shareholderregistration;
import utility.ConfigReader;
import utility.DriverFactory;
import utility.datareader;

public class Testpage   {


	DriverFactory driverFactory;
	WebDriver driver;
	ConfigReader configReader;
	static Properties prop;



	public static void main(String[] args) throws IOException, InterruptedException, AWTException {





		/*public void getProperty(){
	    	configReader = new ConfigReader();
	    	prop=configReader.init_prop();
	    }
		@Before(order =1)
		public void launchBrowser() {
			String browserName = prop.getProperty("browser");
			driverFactory = new DriverFactory();
			driver = driverFactory.init_driver(browserName);

		}

		@AfterTest(order=0)
		public void quitBrowser() throws Exception {
			driver.quit();

		}

		@After(order=1)
		public void tearDown(Scenario scenario) throws IOException {
			if(scenario.isFailed()) {
				//take screen shot
				String screenShotName = scenario.getName().replaceAll(" ","_");
				byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				File sourcePath1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 File screenshot = new File( "ScreenShotsForErrorCheck/"+screenShotName + ".png");
				   FileUtils.copyFile(sourcePath1, screenshot);
				scenario.attach(sourcePath, "image/png", screenShotName);
			}
		}*/
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("--guest");
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);*/
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);

		datareader read = new datareader();
		List<Evencreation> evencreation = datareader.readExcel("C:\\Users\\Pinkeshc\\Desktop","Book6.xlsx");
		RTA_loginpage rtal=new RTA_loginpage(driver);
		createeven creven=new createeven(driver);
		upload_shareholderregistration usreg=new upload_shareholderregistration(driver);


		try {
			rtal.rtalogin();
		} finally {
			try {
				creven.evenformfill(evencreation);
			} finally {

				try {
					usreg.uploadshareholderdropdown();
				
				}
				finally {

				}

			}

		}







	}
	// TODO Auto-generated method stub

}

