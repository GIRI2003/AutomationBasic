package rahulsheetyDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement familyCheckbox = driver.findElement(By.cssSelector("input[id*='friendsandfamily']"));
		System.out.println("Before : "+familyCheckbox.isSelected()); 
		familyCheckbox.click();
		System.out.println("After : "+familyCheckbox.isSelected()); 
		
		
		
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("div[id='discount-checkbox'] input[type='checkbox']"));
		System.out.println("no.of.checkboxes : "+checkBoxes.size());
		
	}

}
