package seleniumIntroduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		Actions builder = new Actions(driver);
		driver.get("https://www.flipkart.com/");
		
		
		WebElement Login = driver.findElement(By.xpath("//span[.='Login']"));
		WebElement myProfile = driver.findElement(By.xpath("//a[.='My Profile']"));
		builder.moveToElement(Login).click().perform();
		builder.moveToElement(myProfile).click().perform();
		
		System.out.println(driver.getTitle());
		
	}

}
