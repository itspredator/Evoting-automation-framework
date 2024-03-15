package pageobjects;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RTA_loginpage
{	

	static WebDriver driver;
	public RTA_loginpage(WebDriver driver)
	{
		RTA_loginpage.driver=driver;
	}
	String Url="https://10.150.7.19/eVotingWeb/resolutionFileDwn.do";
	By rtaloginbtn=By.xpath("//button[@id='RTALogin']");
	By rtauserid=By.xpath("//input[@id='userId']");
	By rtapass=By.cssSelector("#pwd");
	By rtacaptcha=By.xpath("//input[@id='captcha']");
	By rtaloginbutton=By.xpath("//input[@id='loginButton']");
	By rtalogincaptaimage=By.xpath("//img[@id='captch-image-control']");



	@SuppressWarnings("deprecation")
	public void rtalogin() throws InterruptedException
	{
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(rtaloginbtn).click();
		WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(rtauserid));
		System.out.println("RTA Login page");
		driver.findElement(rtauserid).sendKeys("shr1");
		driver.findElement(rtapass).sendKeys("nsdl@12345");
		/*Actions action=new Actions(driver);
		action.contextClick((WebElement) rtalogincaptaimage).build().perform();
		action.sendKeys(Keys.ARROW_DOWN);*/
		//action.moveByOffset(xOffset, yOffset)*/

		/*WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(rtacaptcha));*/
		driver.findElement(rtacaptcha).click();
		Thread.sleep(10000);
		/*WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.domAttributeToBe(rtacaptcha, attribute, value)*/
		driver.findElement(rtaloginbutton).click();

		if(driver.getTitle().equals("e-Voting Login"))
		{
			System.out.println("Ivalid credentials");
		}
		else
		{
			System.out.println("valid credentials login sucessfully");	
		}


	}






}







