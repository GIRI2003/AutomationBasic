package arrtibutes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Invocation {
	
	@Test(invocationCount = 3) //Runs 3 times, when using invocationTimeOuts = 1000 -> 
	//Script should fail when the n->3 testcases are not completed within 1 second
	public void invocate() {
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
