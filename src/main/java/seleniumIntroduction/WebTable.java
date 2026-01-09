package seleniumIntroduction;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	ChromeDriver driver;
	
	public WebTable(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public void shoppingList() {
		driver.get("https://letcode.in/table");
		WebElement ShoppingList = driver.findElement(By.id("shopping"));
		List<WebElement> prices = ShoppingList.findElements(By.xpath("tbody/tr/td[2]"));
		int totalAmount=0;
		for (WebElement price : prices) {
			String text = price.getText().trim();
			int amount = Integer.parseInt(text);
			totalAmount = totalAmount + amount;
		}
		WebElement TotalPriceWebElement = ShoppingList.findElement(By.xpath("tfoot//td[2]"));
		String TotalPriceText = TotalPriceWebElement.getText().trim();
		int TotalPrice = Integer.parseInt(TotalPriceText);
		if(TotalPrice==totalAmount) {
			System.out.println("TestCase Passed");
		}else System.out.println("Failed");
	}
	
	
	public void selectTable() {
		driver.get("https://vinothqaacademy.com/webtable/");
		WebElement Table = driver.findElement(By.id("myTable"));
		
		
		List<WebElement> rows = Table.findElements(By.xpath("//tbody/tr"));
		
		List<String> NameList = Arrays.asList("Jane Smith","Samuel Johnson","John Doe","Vinoth R");
		
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String myName = cells.get(1).getText().trim();
			if(NameList.contains(myName)) {
				cells.get(0).findElement(By.tagName("input")).click();
			}
		}
		driver.findElement(By.id("deleteBtn")).click();
	
		driver.findElement(By.id("addBtn")).click();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
		
	}
	
	public void deleteProjectManager() {
		driver.get("https://vinothqaacademy.com/webtable/");
		WebElement Table = driver.findElement(By.id("myTable"));
		List<WebElement> rows = Table.findElements(By.xpath("//tbody/tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String role = cells.get(2).getText().trim();
			if(role.equals("Automation Architect")) {
				cells.get(0).findElement(By.tagName("input")).click();
			}
		};
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebTable table = new WebTable(driver);
		table.deleteProjectManager();
		
	}

}
