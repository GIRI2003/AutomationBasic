package rahulsheetyDropdown;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKartPractice {

	public static void main(String[] args) {

		String[] veg = {"Brocolli","Cauliflower","Carrot"};
		List<String> vegetableList = Arrays.asList(veg);
		
		WebDriver driver = new ChromeDriver();
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
		
		
	}

}
