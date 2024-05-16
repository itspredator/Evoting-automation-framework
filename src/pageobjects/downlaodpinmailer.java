package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class downlaodpinmailer
{

	WebDriver driver;	
	public String evno;
	public downlaodpinmailer(WebDriver driver)
	{
		this.driver=driver;
	}

	By evotingmenu=By.xpath("//strong[contains(text(),'e-Voting')]");
	By downlaodevenwsepinmailer=By.xpath("//a[contains(text(),'Download Even Wise Pin Mailer File')]");
	By evennoclick=By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/a[1]");
	By generatepinmailerbutton=By.xpath("//input[@id='pinbutton']");
	By refreshstatusbutton=By.xpath("//input[@id='refresh_button']");
	By evennoconfirmailerpage=By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[1]");
	By confirmpinmailerbutton=By.xpath("//input[@id='pinbutton']");
	By backonconfirmpinmailer=By.xpath("//input[@id='refresh_button']");
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

			if(driver.findElement(generatepinmailerbutton).isEnabled())
			{
				driver.findElement(generatepinmailerbutton).click();
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(confirmpinmailerbutton).click();	
			}
			else {
				Thread.sleep(4000);
				driver.findElement(generatepinmailerbutton).click();
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(confirmpinmailerbutton).click();	
			}

		}
		else
		{
			System.out.println("even id not matched to generate the file");
		}



	}
}
