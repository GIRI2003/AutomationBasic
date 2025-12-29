package arrtibutes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadPoolSize {

//ThreadPoolSize runs the count of tests parallel
//threadPoolSize can be used only when invocationCount attribute invovled

	@Test(invocationCount = 3, threadPoolSize = 3)
	public void findSize() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/edit");
		List<WebElement> lables = driver.findElements(By.tagName("label"));
		System.out.println(lables.size());
		driver.quit();
	}
	
//TimeOuts used to fail a testcase when a testcase is not completed within a given timeline
	@Test(timeOut = 10000, enabled = false)
	public void findSize2() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/edit");
		List<WebElement> lables = driver.findElements(By.tagName("label"));
		System.out.println(lables.size());
		driver.quit();
	}
	
	
//ExpectedExceptions used to pass a testcase even if fails
//ExpectedExceptions will not work for findElements only works for findElement
	@Test(expectedExceptions = {NoSuchElementException.class}, enabled = false)
	public void findSize3() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/edit");
		WebElement lables = driver.findElement(By.tagName("nolable"));
		System.out.println(lables.getText());
		driver.quit();
	}
	
	
}
