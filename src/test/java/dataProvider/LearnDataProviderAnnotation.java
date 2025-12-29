package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LearnDataProviderAnnotation{
	

	
	@Test(dataProvider = "getLoginData", dataProviderClass = DataUtils.class)
	public void loginPage(String data[]) {		
		
//		System.out.println(data[0]);
//		System.out.println(data[1]);
//		System.out.println(data[2]);
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys(data[0]);
		driver.findElement(By.id("password")).sendKeys(data[1]);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
		System.out.println(text);
		driver.quit();
		
		
	}

}
