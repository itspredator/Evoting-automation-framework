package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CapchaReader {

	public static void getCapcha(WebDriver driver, By rtacaptchainnputbox) throws AWTException, InterruptedException {

		Robot robot = new Robot();

		int x = 390, y = 450;
		robot.mouseMove(x, y);

		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

		// robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		for (int i = 0; i <= 5; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		}

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(8000);

		x = 1150;
		y = 300;//350
		robot.mouseMove(x, y);

		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		Thread.sleep(6000);

		x = 1250;
		y = 335;
		robot.mouseMove(x, y);

		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(4000);

		// driver.findElement(rtalogincaptaimage);
		WebElement captaText = driver.findElement(rtacaptchainnputbox);
		captaText.click();
		captaText.sendKeys(Keys.CONTROL, "v");
	}

}
