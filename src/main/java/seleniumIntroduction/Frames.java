package seleniumIntroduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {

//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/frame");

		driver.switchTo().frame("firstFr");
		driver.findElement(By.name("fname")).sendKeys("Girinath");	
		driver.findElement(By.name("lname")).sendKeys("A");

		WebElement innerFrameXpath = driver.findElement(By.xpath("//iframe[@src='innerframe']"));
		driver.switchTo().frame(innerFrameXpath);
		driver.findElement(By.name("email")).sendKeys("girirohi2@gmail.com");

		driver.switchTo().parentFrame();
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys("Ayyasamy");

		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Work-Space")).click();

		driver.quit();
	}

}
