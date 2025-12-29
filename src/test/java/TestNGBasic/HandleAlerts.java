package TestNGBasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleAlerts {

	
	@Test
	public void launchBrowser() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://letcode.in/alert");
		
		driver.findElement(By.id("accept")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirm")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.id("prompt")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Girinath");
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("modern")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='title']")).getText());
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		driver.quit();
	}
	
	

}
