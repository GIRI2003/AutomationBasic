package seleniumIntroduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	ChromeDriver driver;
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://letcode.in/alert");
	}
	
	public void simpleAlert() {
		driver.findElement(By.id("accept")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	public void confirmAlert() {
		driver.findElement(By.id("confirm")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}
	
	public void promptAlert() {
		driver.findElement(By.id("prompt")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Girinath");
		driver.switchTo().alert().accept();
	}
	
	public void mordernAlert() {
		driver.findElement(By.id("modern")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='title']")).getText());
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HandleAlerts alertObj = new HandleAlerts();
		alertObj.launchBrowser();
		alertObj.simpleAlert();
		alertObj.confirmAlert();
		alertObj.promptAlert();
		alertObj.mordernAlert();
		alertObj.tearDown();
		
		
	}

}
