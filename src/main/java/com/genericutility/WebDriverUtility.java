package com.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	public void windowmaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void windowminimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void handledropdown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
    
	public void handledropdown(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void mousehoveraction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void rightclick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	public void rightclick1(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element);
	}

	public void switchwindow(WebDriver driver, String PartialTitle) {
		Set<String> AllWinID = driver.getWindowHandles();

		for (String WindID : AllWinID) {
			String actualTitle = driver.switchTo().window(WindID).getTitle();
			if (actualTitle.contains(PartialTitle)) {
				break;
			}
		}
	}

	public String screenshot(WebDriver driver, String Screenshotname) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\screenshot\\" + Screenshotname + ".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}

}
