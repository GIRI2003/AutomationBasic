package rahulsheetyDropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calandar {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		// Default the return date will be disabled
		boolean initial = driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled();
		Assert.assertFalse(initial);
		
		driver.findElement(By.cssSelector("input[id*='rbtnl_Trip_1']")).click();
		boolean afterSelectingRoundTrip = driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled();
		Assert.assertTrue(afterSelectingRoundTrip);
		
//		driver.findElement(By.cssSelector(".custom_date_pic.required.home-date-pick.valid")).click();
		
		
		
		
		
	}

}
