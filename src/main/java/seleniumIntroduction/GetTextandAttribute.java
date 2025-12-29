package seleniumIntroduction;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextandAttribute {
	
	ChromeDriver driver;
	
	public GetTextandAttribute(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public void getTextMethod() {
		String text = driver.findElement(By.tagName("h1")).getText();
		System.out.println(text);
		
		String text2 = driver.findElement(By.xpath("(//div[@class='card-content'])[1]")).getText();
		System.out.println(text2);
	}
	
	public void getAttributeMethod() {
		String attribute = driver.findElement(By.id("join")).getAttribute("value");
		System.out.println(attribute);
		
		String attribute2 = driver.findElement(By.id("fullName")).getAttribute("placeholder");
		System.out.println(attribute2);

		String attribute3 = driver.findElement(By.id("getMe")).getAttribute("id");
		System.out.println(attribute3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://letcode.in/edit");
		GetTextandAttribute TextAttri = new GetTextandAttribute(driver);
		TextAttri.getTextMethod();
		TextAttri.getAttributeMethod();
		driver.quit();
	}

}
