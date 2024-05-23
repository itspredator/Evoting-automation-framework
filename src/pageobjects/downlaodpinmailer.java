package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class downlaodpinmailer
{

	WebDriver driver;	
	public String evno;
	String filestatus;
	public downlaodpinmailer(WebDriver driver)
	{
		this.driver=driver;
	}

	By evotingmenu=By.xpath("//strong[contains(text(),'e-Voting')]");
	By downlaodevenwsepinmailer=By.xpath("//a[contains(text(),'Download Even Wise Pin Mailer File')]");
	By evennoclick=By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/a[1]");
	By generatepinmailerbutton=By.xpath("//input[@id='pinbutton']");
	By refreshstatusbutton=By.xpath("//input[@id='refresh_button']");
	By confirmpinmailerbutton=By.xpath("//input[@id='pinbutton']");
	By backonconfirmpinmailer=By.xpath("//input[@id='refresh_button']");
	By clickongeneratefile=By.xpath("//td[@id='tableCellID']");
	By Fileprocessstatus=By.cssSelector("table.outline:nth-child(2) td:nth-child(1) table.subOutline:nth-child(2) tbody:nth-child(1) tr:nth-child(2) > td.subOutline:nth-child(6)");
	@SuppressWarnings("deprecation")
	public void clickondownlaodevenwsepinmailerfile(createeven even)
	{
		driver.findElement(evotingmenu).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(downlaodevenwsepinmailer).click();
		if(driver.findElement(evennoclick).isDisplayed())
		{
			evno=driver.findElement(evennoclick).getText();
			System.out.println("even no : " + evno);
			driver.findElement(evennoclick).click();
		}
		else {
			System.out.println("even no not found");
		}
	}
	@SuppressWarnings("deprecation")
	public void generatepinmailerfile(createeven even) throws InterruptedException
	{	
		String genpinactual_page=driver.getTitle();
		String expectedpinpage="Pin Mailer File Generation";
		Assert.assertEquals(genpinactual_page, expectedpinpage);
		//assert.assertEquals(genpinactual_page, expectedpinpage)
		System.out.println("even printed here : " + even.getExtractionofeven());


		if (evno.equals(even.getExtractionofeven()))
		{	

			/*if(driver.findElement(generatepinmailerbutton).isEnabled())
			{
				driver.findElement(generatepinmailerbutton).click();
				//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(confirmpinmailerbutton).click();	
				Thread.sleep(5000);
				driver.findElement(refreshstatusbutton).click();
				driver.findElement(clickongeneratefile).getText().substring(0, 4);
				System.out.println("Isenabled method");
			}*/
		
				
				String actualStatus=driver.findElement(Fileprocessstatus).getText();
				System.out.println("filestatus:"+actualStatus);
				while (actualStatus.equals("File Under Processing"))
				{
					
					driver.findElement(refreshstatusbutton).click();
					actualStatus=driver.findElement(Fileprocessstatus).getText();
					
				}
			
				
				driver.findElement(generatepinmailerbutton).click();
				driver.findElement(confirmpinmailerbutton).click();	
				Thread.sleep(5000);
				// explicit wait - to wait for the compose button to be click-able
				//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
				//driver.findElement(refreshstatusbutton).click();
				driver.findElement(clickongeneratefile).click();
				System.out.println("without enabled method");

			

		}
		else
		{
			System.out.println("even id not matched to generate the file");
		}



	}
}

