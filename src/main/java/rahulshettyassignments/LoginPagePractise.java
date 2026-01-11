package rahulshettyassignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePractise {

	public static void main(String[] args) {
		
		String username = "rahulshettyacademy";
		String password = "learning";
		
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		WebElement okayButton = driver.findElement(By.id("okayBtn"));
		wait.until(ExpectedConditions.visibilityOf(okayButton));
		okayButton.click();
		
		WebElement dropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select select = new Select(dropdown);
		select.selectByValue("stud");
		
		driver.findElement(By.cssSelector("#terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();
		
		driver.switchTo().alert().accept();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//a[text()='ProtoCommerce Home']")));
		
		
		List<WebElement> addProductToCartButton = driver.findElements(By.cssSelector(".btn.btn-info"));
		for(WebElement addButton : addProductToCartButton) {
			addButton.click();
		}
		
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		driver.findElement(By.id("country")).sendKeys("India");
		WebElement countryWait = driver.findElement(By.cssSelector(".suggestions"));
		wait.until(ExpectedConditions.visibilityOf(countryWait));
		driver.findElement(By.xpath("//a[text()='India']")).click();
		
		driver.findElement(By.id("checkbox2")).click();
		
		driver.findElement(By.cssSelector(".btn.btn-success.btn-lg")).click();
		
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());
	}

}
