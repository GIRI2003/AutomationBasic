package seleniumIntroduction;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoMode {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://letcode.in/");
		
	}

}
