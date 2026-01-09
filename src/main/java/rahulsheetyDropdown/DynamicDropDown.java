package rahulsheetyDropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDropDown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		

		WebElement startDropDown = driver.findElement(By.id("glsctl00_mainContent_ddl_originStation1_CTNR"));
		wait.until(ExpectedConditions.visibilityOf(startDropDown));
		
		driver.findElement(By.cssSelector
				("div[id='glsctl00_mainContent_ddl_originStation1_CTNR'] a[value='MAA']")).click();
		
		WebElement destDropDown = driver.findElement
				(By.id("glsctl00_mainContent_ddl_destinationStation1_CTNR"));
		wait.until(ExpectedConditions.visibilityOf(destDropDown));
		
		driver.findElement(By.cssSelector
				("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='CJB']")).click();
		
		
		driver.quit();
	}

}
