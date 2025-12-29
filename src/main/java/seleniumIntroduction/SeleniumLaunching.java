package seleniumIntroduction;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class SeleniumLaunching {

	ChromeDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		SeleniumLaunching screenshot = new SeleniumLaunching();
		screenshot.launchBrowser();
		screenshot.screenshotElement();
//		screenshot.screenshotSection();
//		screenshot.screenShotWindow();
		
	}
	
	public void launchBrowser() {
//		System.setProperty("webdriver.chrome.driver", 
//				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://letcode.in/button");
		driver.manage().window().maximize();
	}
	
	public void screenShotWindow() throws IOException {
		File sourceFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/img1.png");
		FileHandler.copy(sourceFile, destFile);
		
	}
	
	public void screenshotElement() throws IOException {
		WebElement element = driver.findElement(By.id("property"));
		File sourceElement = element.getScreenshotAs(OutputType.FILE);
		File destElement = new File("./screenshots/img2.png");
		FileHandler.copy(sourceElement, destElement);
	}
	
	public void screenshotSection() throws IOException {
		WebElement section = driver.findElement(By.xpath("//div[@class='content']"));
		File sourceSection = section.getScreenshotAs(OutputType.FILE);
		File destSection = new File("./screenshots/img3.png");
		FileHandler.copy(sourceSection, destSection);
	
	}

}
