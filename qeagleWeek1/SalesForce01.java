package qeagleWeek1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForce01 {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Opp = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();", Opp);
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		WebElement userName = driver.findElement(By.xpath("//input[@name='Name']"));
		userName.sendKeys("SaravanaKarthik");
		String UserName = userName.getAttribute("value");
		System.out.println("User name: "+UserName);
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("10001");
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();
		Thread.sleep(300);
		WebElement stageClick = driver.findElement(By.xpath("(//div[@class='slds-combobox_container']/div/div/button)[2]"));
		js.executeScript("arguments[0].click();", stageClick);
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(5000);
		String CreatedName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		System.out.println("Created Opportunity Name: "+CreatedName);
		
		if(CreatedName.equalsIgnoreCase(UserName)) {
			System.out.println("The opportunity name has been successfully generated");
		}else {
			System.out.println("The attempt to generate the opportunity name was unsuccessful.");
		}
		
		
		
		
		
	}

}
