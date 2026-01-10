package rahulsheetyDropdown;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GreenKartPractice {

	public static void main(String[] args) {

		String[] veg = {"Tomato","Beans","Apple"};
		List<String> vegetableList = Arrays.asList(veg);
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> VegetableNames = driver.findElements(By.cssSelector("h4[class='product-name']"));		
		int i = 0;
		for (WebElement vegetableName : VegetableNames) {
			String trimmedVegetableName = vegetableName.getText().split("-")[0].trim();
			if(vegetableList.contains(trimmedVegetableName)) {
				driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i).click();
			}
			i++;
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.cssSelector("div[class='action-block'] button")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
		        By.xpath("//table/tbody/tr/td[2]")));
		
		List<WebElement> addedItems = driver.findElements(By.xpath("//table/tbody/tr/td[2]/p"));
		for (WebElement addedItem : addedItems) {
			String addedItemName = addedItem.getText().split("-")[0].trim();
			System.out.println(addedItemName);
		}
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		
		WebElement promoMessage = driver.findElement(By.cssSelector(".promoInfo"));
		
		wait.until(ExpectedConditions.visibilityOf(promoMessage));
		
		String promoText = driver.findElement(By.cssSelector(".promoInfo")).getText(); 
		Assert.assertEquals(promoText, "Code applied ..!");
		driver.findElement(By.xpath("//div/button[text()='Place Order']")).click();
		
		
		WebElement selectCountry = driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select"));
		Select dropdown = new Select(selectCountry);
		dropdown.selectByValue("India");
		
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.cssSelector("div[class='wrapperTwo'] button")).click();
		driver.quit();
	}

}
