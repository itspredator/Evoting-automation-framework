package utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;

	// use of java 8 feature thread local
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * this method is used to initialize the thread local driver on basis of given
	 * browser will return webdriver
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("Browser name is as : " + browser);

		if (browser.equals("chrome")) {
			System.out.println("Browser name is as : " + browser + " Selected");
			// Create object of DesiredCapabilities class
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			// Set ACCEPT_SSL_CERTS variable to true
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());

			System.out.println("Browser name is as : " + browser + " Selected");
		} else if (browser.equals("firefox")) {
			// It create firefox profile
			FirefoxProfile profile = new FirefoxProfile();

			// This will set the true value
			profile.setAcceptUntrustedCertificates(true);

			// This will open firefox browser using above created profile

			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("ie")) {
			
			// InternetExplorerOptions options = new InternetExplorerOptions().setPageLoadStrategy(PageLoadStrategy.NONE);

			// options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			//WebDriver driver=new InternetExplorerDriver(options);
			 WebDriverManager.iedriver().setup();
			 tlDriver.set(new InternetExplorerDriver());
		
		}  else {
			System.out.println("Please pass correct value for browser : " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	/*
	 * synchronized key word used when ever if we want to run code on different
	 * machine simultaneously If 5 thread running together then all thread running
	 * and try to call this method for this reason used sync 
	 * thread local piece then we can used as below
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
