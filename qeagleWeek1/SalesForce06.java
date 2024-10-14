
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SalesForce06 {
	
	public static void main(String[] args) {
		
		ChromeOptions chromeoption = new ChromeOptions();
		chromeoption.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeoption);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(30);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		WebElement legalEntity = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		executor.executeScript("arguments[0].click();", legalEntity);
		
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]")).click();
		
		WebElement LEdropdown = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		
		executor.executeScript("arguments[0].click();", LEdropdown);
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation By Saravana Karthik");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement LEName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='outputField']"));
		String EntityName = LEName.getText();
		System.out.println(EntityName);
		Assert.assertEquals(EntityName, "Salesforce Automation By Saravana Karthik");
		System.out.println("It Verifies the Name of the Legal Entity");
		driver.close();
	}

}
