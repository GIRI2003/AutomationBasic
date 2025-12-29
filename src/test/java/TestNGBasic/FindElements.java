package TestNGBasic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElements {

	@Test
	public void main() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/edit");
		List<WebElement> lables = driver.findElements(By.tagName("label"));
		for (WebElement label : lables) {
			String text = label.getText();
			System.out.println(text);
		}
		System.out.println(lables.get(lables.size()-1).getText());
		System.out.println(lables.get(lables.size()-1));
		driver.quit();
		
	}

}
