package extentReports;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	ExtentReports reports;
//	Add extentReport, Selenium-java, TestNG dependency
	@BeforeTest
	public void extentReportTest() {
		File file = new File(System.getProperty("user.dir")+"\\Reports\\report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		sparkReporter.config().setReportName("Web Automation Testing");
		sparkReporter.config().setDocumentTitle("Web Automation");
		
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);	
		reports.setSystemInfo("Tester", "Girinath A");
		
	}
	
	
	@Test
	public void demoTest() {
		ExtentTest test = reports.createTest("Demo Test");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
		test.fail("Test failed purposly");
		reports.flush();
	}

}
