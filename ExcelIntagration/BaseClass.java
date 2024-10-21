package ExcelIntagration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public ChromeDriver driver;
	
	@BeforeMethod
	public void preCondition() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(opt);
		opt.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		
	}

	@AfterMethod
	public void postCondition() {
		
		driver.close();
		
	}
	

}
