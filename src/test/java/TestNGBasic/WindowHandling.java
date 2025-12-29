package TestNGBasic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandling {

	
	@Test
	public void main() {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://vinothqaacademy.com/multiple-windows/");
		driver.findElement(By.name("newbrowserwindow123")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		List<String> allWindowList = new ArrayList<String>(allWindowHandles);
		String parentWindow = allWindowList.get(0);
		String newbrowserWindow = allWindowList.get(1);
		driver.switchTo().window(newbrowserWindow);
		System.out.println("URL of newbrowserWindowChild -- "+driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.name("145newbrowsertab234")).click();
		allWindowList.clear();
		Set<String> newBrowserTab = driver.getWindowHandles();
		allWindowList.addAll(newBrowserTab);
		String parentBrowserTab = allWindowList.get(0);
		String childBrowserTab = allWindowList.get(1);
		driver.switchTo().window(childBrowserTab);
		System.out.println("URL of newBrowserTabChild -- "+driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentBrowserTab);
		
		driver.findElement(By.name("123newmessagewindow321")).click();
		allWindowList.clear();
		Set<String> newMessageWindow = driver.getWindowHandles();
		allWindowList.addAll(newMessageWindow);
		String parentMessageWindow = allWindowList.get(0);
		String childMessageWindow = allWindowList.get(1);
		driver.switchTo().window(childMessageWindow);
//		System.out.println("URL of newBrowserTabChild -- "+driver.getTitle());
		driver.close();
		driver.switchTo().window(parentMessageWindow);
		
		driver.findElement(By.linkText("New Browser Tab Link")).click();
		allWindowList.clear();
		Set<String> newBrowserTabLink = driver.getWindowHandles();
		allWindowList.addAll(newBrowserTabLink);
		String parentBrowserTabLink = allWindowList.get(0);
		String childBrowserTabLink = allWindowList.get(1);
		driver.switchTo().window(childBrowserTabLink);
		System.out.println("URL of newBrowserTabChild -- "+driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentBrowserTabLink);
		System.out.println("URL of ParentWindow -- "+driver.getCurrentUrl());
		driver.quit();
		
	}

}
