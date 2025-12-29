package seleniumIntroduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DragAndDrop {
	ChromeDriver driver;

	public DragAndDrop(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public void MouseActions() {
		driver.get("https://vinothqaacademy.com/mouse-event/");
		WebElement source = driver.findElement(By.id("draggableElement"));
		WebElement target = driver.findElement(By.id("droppableElement"));
		WebElement moveToTextBox = driver.findElement(By.id("textbox"));
		WebElement DoubleClick = driver.findElement(By.id("dblclick"));
		WebElement RightClick = driver.findElement(By.id("rightclick"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		builder.moveToElement(moveToTextBox).click().sendKeys("Girinath").perform();
		builder.doubleClick(DoubleClick).perform();
		System.out.println(driver.findElement(By.id("demo")).getText()); 
		builder.contextClick(RightClick).perform();
	}
	
	public void DropDownActions() {
		driver.get("https://letcode.in/dropdowns");
		WebElement SelectbyVisibleText = driver.findElement(By.id("fruits"));
		Select dropdown = new Select(SelectbyVisibleText);
		dropdown.selectByVisibleText("Orange");
		List<WebElement> options = dropdown.getOptions();
//		options.forEach(i -> System.out.println(i.getText()));
		for(WebElement option: options) {
			System.out.println(option.getText());
		}
		
		WebElement SelectByValue = driver.findElement(By.id("country"));
		Select dropdown1 = new Select(SelectByValue);
		dropdown1.selectByValue("India");
//		String text = dropdown1.getFirstSelectedOption().getText();
//		System.out.println(text);
		
		WebElement SelectMultiple = driver.findElement(By.id("superheros"));
		Select dropdown2 = new Select(SelectMultiple);
//		boolean multiple = dropdown2.isMultiple();
//		System.out.println("Is this dropdown multi select? "+multiple);
		dropdown2.selectByIndex(1);
		dropdown2.selectByIndex(2);
		dropdown2.deselectByIndex(2);
	}
	
	
	public void BootStrapDropDown() {
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.findElement(By.xpath("(//div[contains(@class,'ui selection dropdown')])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='Male'])[1]")).click();
	}
	
	
	
	public void TearDown() {
		driver.quit();
	}
	
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		DragAndDrop drag=new DragAndDrop(driver);
		drag.MouseActions();
		drag.TearDown();
		
	}
	
	

}
