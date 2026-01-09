package parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LearnParameters {
	WebDriver driver;
	@Test
	@Parameters({"mailID", "password", "browser"})
	public void login(String email, String password, String browser) {
		
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			
		default:
			break;
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
		System.out.println(text);
		driver.quit();
	}
	
	
	
}
