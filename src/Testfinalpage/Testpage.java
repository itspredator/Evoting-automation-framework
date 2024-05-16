package Testfinalpage;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.RTA_loginpage;
import pageobjects.createeven;
import pageobjects.downlaodpinmailer;
import pageobjects.downloadresponsefile;
import pageobjects.sharholderfiletoupload;
import pageobjects.upload_shareholderregistration;
import utility.ConfigReader;
import utility.DriverFactory;
import utility.datareader;

public class Testpage {

	static DriverFactory driverFactory;
	static WebDriver driver;
	ConfigReader configReader;
	static List<Evencreation> evencreation;
	RTA_loginpage rtal;
	createeven creven;
	upload_shareholderregistration usreg;
	downloadresponsefile dr;
	downlaodpinmailer dpm;
	public static createeven even;
	
	//private static Logger log;
	public Testpage() throws IOException {
		super();

		driver = setup();
		rtal = new RTA_loginpage(driver);
		creven = new createeven(driver);
		usreg = new upload_shareholderregistration(driver);
		dr = new downloadresponsefile(driver);
		dpm = new downlaodpinmailer(driver);
		evencreation = datareader.readExcel("C:\\Users\\Pinkeshc\\Desktop", "Book6.xlsx");
	}

	//@BeforeTest
	public WebDriver setup() throws IOException {

		System.out.println("setup method ");
		ConfigReader configreader = new ConfigReader();
		driverFactory = new DriverFactory();
		String BrowserName = ConfigReader.getProprty("Browser");
		System.out.println(BrowserName);
		driver = driverFactory.init_driver(BrowserName);
		return driver;

	}

	@Test(priority = 1)
	public void testpages() throws IOException, InterruptedException, AWTException {


		rtal.rtalogin();
	}

	@Test(priority = 2)
	public void testevenformfill() throws InterruptedException, AWTException, ClassNotFoundException, IOException, SQLException {
		even = creven.evenformfill(evencreation);

	}

	@Test(priority = 3)
	
	public void testuploadshareholderdropdown()
			throws InterruptedException, AWTException, ClassNotFoundException, IOException, SQLException {
		usreg.uploadshareholderdropdown(even.getExtractionofeven());
	}

	@Test(priority = 4)
	public void testclickondownloadresponsefile() throws InterruptedException, AWTException {
		dr.clickondownloadresponsefile();
		dr.downaloderrorandoutfile();

	}

	@Test(priority = 5)
	public void testclickondownlaodevenwsepinmailerfile() throws InterruptedException, AWTException {
		dpm.clickondownlaodevenwsepinmailerfile(even);
		dpm.generatepinmailerfile(even);

	}


	
//	 @AfterTest 
//	 public void teardown()
//	 { driver.quit();
//	 }
	 

	// public static void main(String[] args) throws IOException,
	// InterruptedException, AWTException {

	/*
	 * @AfterClass public void tearDown(Scenario scenario) throws IOException {
	 * if(scenario.isFailed()) { //take screen shot String screenShotName =
	 * scenario.getName().replaceAll(" ","_"); byte[] sourcePath =
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); File sourcePath1
	 * = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); File screenshot
	 * = new File( "ScreenShotsForErrorCheck/"+screenShotName + ".png");
	 * FileUtils.copyFile(sourcePath1, screenshot); scenario.attach(sourcePath,
	 * "image/png", screenShotName); }
	 */
	/*
	 * @BeforeClass public void setup() throws IOException { ChromeOptions
	 * options=new ChromeOptions(); //options.addArguments("--guest");
	 * options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	 * DesiredCapabilities capabilities = new DesiredCapabilities();
	 * capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true); String
	 * path=System.getProperty("user.dir");
	 * System.setProperty("webdriver.chrome.driver",path+
	 * "\\drivers\\chromedriver.exe"); WebDriver driver= new ChromeDriver(options);
	 * 
	 * }
	 */

	// }
	// TODO Auto-generated method stub

}
