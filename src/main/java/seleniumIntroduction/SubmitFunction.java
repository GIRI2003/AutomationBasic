package seleniumIntroduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SubmitFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://letcode.in/forms");
		
		driver.findElement(By.id("firstname")).sendKeys("Girinath");
		
		driver.findElement(By.id("lasttname")).sendKeys("A");
		
		driver.findElement(By.id("email")).sendKeys("gmail.com");
		
		WebElement CountryCode = driver.findElement(By.xpath("(//div[@class='select']/select)[1]"));
		Select selectCountryCode = new Select(CountryCode);
		selectCountryCode.selectByValue("91");
		
		driver.findElement(By.id("Phno")).sendKeys("9090990909");
		
		driver.findElement(By.id("Addl1")).sendKeys("Street 1");
		
		driver.findElement(By.id("Addl2")).sendKeys("Chennai");
		
		driver.findElement(By.id("state")).sendKeys("TamilNadu");
		
		driver.findElement(By.id("postalcode")).sendKeys("600001");
	
		WebElement country = driver.findElement(By.xpath("(//div[@class='select']/select)[2]"));
		Select selectCountry = new Select(country);
		selectCountry.selectByValue("India");
		
		driver.findElement(By.id("Date")).sendKeys("27-03-2003");
		
		driver.findElement(By.id("male")).click();
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		
		driver.quit();
		
	}

}
