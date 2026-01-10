package rahulsheetyDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAsserting {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement familyCheckbox = driver.findElement(By.cssSelector("input[id*='friendsandfamily']"));
		Assert.assertFalse(familyCheckbox.isSelected());
		familyCheckbox.click();
		Assert.assertTrue(familyCheckbox.isSelected());
		
		WebElement seniorCitizenCheckbox = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
		seniorCitizenCheckbox.click();
		Assert.assertTrue(seniorCitizenCheckbox.isSelected());
		
		
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("div[id='discount-checkbox'] input[type='checkbox']"));
		Assert.assertEquals( 5 , checkBoxes.size());
		driver.quit();
	}

}
