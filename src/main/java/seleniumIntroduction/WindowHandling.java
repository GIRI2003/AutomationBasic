package seleniumIntroduction;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	
	ChromeDriver driver;
	public WindowHandling(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public void singleList() {
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
	
	public void multiList() {
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
		Set<String> newBrowserTab = driver.getWindowHandles();
		List<String> newBrowserTabList = new ArrayList<String>(newBrowserTab);
		String newBrowserTabChild = newBrowserTabList.get(1);
		driver.switchTo().window(newBrowserTabChild);
		System.out.println("URL of newBrowserTabChild -- "+driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.name("123newmessagewindow321")).click();
		Set<String> newMessageWindow = driver.getWindowHandles();
		List<String> newMessageWindowList = new ArrayList<String>(newMessageWindow);
		String newMessageWindowChild = newMessageWindowList.get(1);
		driver.switchTo().window(newMessageWindowChild);
//		System.out.println("URL of newMessageWindowChild -- "+driver.getCurrentUrl());
		driver.close();
		
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.linkText("New Browser Tab Link")).click();
		Set<String> newBrowserTabLink = driver.getWindowHandles();
		List<String> newBrowserTabLinkList = new ArrayList<String>(newBrowserTabLink);
		String newBrowserTabLinkChild = newBrowserTabLinkList.get(1);
		driver.switchTo().window(newBrowserTabLinkChild);
		System.out.println("URL of newBrowserTabLinkChild -- "+driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println("URL of ParentWindow -- "+driver.getCurrentUrl());
		driver.quit();
	}

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WindowHandling handling = new WindowHandling(driver);
		handling.singleList();
		
		
		
	}

}
