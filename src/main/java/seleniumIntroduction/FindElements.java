package seleniumIntroduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/edit");
		List<WebElement> lables = driver.findElements(By.tagName("label"));
		System.out.println(lables.size());
		driver.quit();
		
		
//		for (WebElement label : lables) {
//			String text = label.getText();
//			System.out.println(text);
//		}
//		System.out.println(lables.get(lables.size()-1).getText());
//		System.out.println(lables.get(lables.size()-1));
//		driver.quit();
		
//		WebElement lableSize = lables.get(lables.size()-1);
		
	}

}
