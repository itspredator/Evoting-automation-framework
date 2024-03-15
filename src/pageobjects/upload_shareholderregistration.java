package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import utility.ConfigReader;

public class upload_shareholderregistration {
	WebDriver driver;
	public upload_shareholderregistration(WebDriver driver) {

		this.driver=driver;
		// TODO Auto-generated constructor stub
	}




	By evtngdropdown= By.xpath("//font[contains(text(),'e-Voting')]");
	By drpdownshldrregfile=By.linkText("Upload ShareHolder Registration File");
	By firstcutoffuploadradiobtn=By.cssSelector("table.outline:nth-child(3) tbody:nth-child(2) tr:nth-child(2) td.font > input:nth-child(1)");
	By seconduplaodradiobtn=By.xpath("//input[@id='uploadFileType']");
	By ckboxlastfileflag=By.xpath("//input[@id='lastFileFlag']");
	By selectfiletoupload=By.xpath("//input[@id='Uploadfile']");
	By submitbutton=By.xpath("//input[@id='submitButton']");
	By resetbutton=By.xpath("//tbody/tr[2]/td[1]/input[2]");
	String filesucessmsg="File uploaded successfully with Process id";

	public void uploadshareholderdropdown()
	{	ConfigReader configreader=ConfigReader.getinstance();
	String upload_type=configreader.getProprty("Upload_Type");
	System.out.println("The selected upload type \t" +upload_type);
	driver.findElement(evtngdropdown).click();
	driver.findElement(drpdownshldrregfile).click();
	System.out.println("-------inside upload shareholder file module------");
	String actualtitle=driver.getTitle();
	String expetitle="Upload Registrar";
	SoftAssert sf=new SoftAssert();
	sf.assertEquals(expetitle, actualtitle);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));



	if(upload_type.equals("First_upload"))
	{

		driver.findElement(firstcutoffuploadradiobtn).click();
		driver.findElement(selectfiletoupload).sendKeys("E:\\SurajSanity\\SurajSanity\\RTAFILEUPLOAD1\\RTAFILEUPLOAD1 (2).zip");
		driver.findElement(submitbutton).click();
		if(driver.getPageSource().contains("Unable to read file"))

		{
			System.out.println("file contains error");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));	
		}
		else
		{
			System.out.println("file uploaded sucessfully with second uplaod");
		}
		/*} else {
			driver.findElement(firstcutoffuploadradiobtn).click();
			driver.findElement(selectfiletoupload).sendKeys("E:\\SurajSanity\\SurajSanity\\RTAFILEUPLOAD1\\RTAFILEUPLOAD1 (2).zip");
			driver.findElement(submitbutton).click();
			String msg=driver.findElement(submitbutton).getText();
			System.out.println(msg);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/


		//} 
	}


	else if(upload_type.equals("Second_upload"))
	{

		driver.findElement(seconduplaodradiobtn).click();
		driver.findElement(selectfiletoupload).sendKeys("E:\\SurajSanity\\SurajSanity\\RTAFILEUPLOAD1\\RTAFILEUPLOAD1 - Copy - Copy.zip");
		driver.findElement(ckboxlastfileflag).click();
		driver.findElement(submitbutton).click();

		if(driver.getPageSource().contains("Unable to read file"))
		{

			System.out.println("file contains error");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		}
		else {
			System.out.println("file uploaded sucessfully with second uplaod");

		}

	}


	}
}
