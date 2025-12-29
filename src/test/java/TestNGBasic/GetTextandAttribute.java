package TestNGBasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetTextandAttribute {
	
	@Test
	public void main() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://letcode.in/edit");
		String attribute = driver.findElement(By.id("join")).getAttribute("value");
		System.out.println(attribute);
		
		String attribute2 = driver.findElement(By.id("fullName")).getAttribute("placeholder");
		System.out.println(attribute2);

		String attribute3 = driver.findElement(By.id("getMe")).getAttribute("id");
		System.out.println(attribute3);
		driver.quit();
	}

}
