package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RTA_loginpage {

	static WebDriver driver;

	public RTA_loginpage(WebDriver driver) {
		RTA_loginpage.driver = driver;
	}

	String Url = "https://10.150.7.19/eVotingWeb/resolutionFileDwn.do";
	By rtaloginbtn = By.xpath("//button[@id='RTALogin']");
	By rtauserid = By.xpath("//input[@id='userId']");
	By rtapass = By.cssSelector("#pwd");
	By rtacaptchainnputbox = By.xpath("//input[@id='captcha']");
	By rtaloginbutton = By.xpath("//input[@id='loginButton']");
	By rtalogincaptaimage = By.xpath("//img[@id='captch-image-control']");

	@SuppressWarnings("deprecation")
	public void rtalogin() throws InterruptedException, AWTException {
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(rtaloginbtn).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		// wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(rtauserid));
		System.out.println("RTA Login page");
		driver.findElement(rtauserid).sendKeys("shr1");
		driver.findElement(rtapass).sendKeys("nsdl@12345");


		CapchaReader.getCapcha(driver, rtacaptchainnputbox);


		driver.findElement(rtaloginbutton).click();

		if (driver.getTitle().equals("e-Voting Login")) {
			System.out.println("Ivalid credentials");
		} else {
			System.out.println("valid credentials login sucessfully");
		}

	}

}
