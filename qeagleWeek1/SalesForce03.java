package qeagleWeek1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SalesForce03 {
	
	public static void main(String[] args) throws InterruptedException {

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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		Thread.sleep(5000);
		
		WebElement workTypeGroups = driver.findElement(By.xpath("//span/p[text()='Work Type Groups']"));
		
		JavascriptExecutor Executer = (JavascriptExecutor) driver;
		Executer.executeScript("arguments[0].click();", workTypeGroups);
		
		Thread.sleep(5000);
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']"));
		searchbox.clear();
		searchbox.sendKeys("Salesforce Automation By Saravana Karthik");
		
		
		WebElement table = driver.findElement(By.xpath("//table/tbody/tr/th/span/a[@title='Salesforce Automation By Saravana Karthik']"));
		
		String text = table.getText();
		System.out.println(text);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//table[@role='grid']/tbody/tr/td)[5]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(5000);
			
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).clear();
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Automation");
		driver.findElement(By.xpath("//button[@aria-label='Group Type']")).click();
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		
		
		WebElement groupname = driver.findElement(By.xpath("//table/tbody/tr/th/span/a[@title='Salesforce Automation By Saravana Karthik']"));
		Executer.executeScript("arguments[0].click();",groupname);
		WebElement Description = driver.findElement(By.xpath("//slot/lightning-formatted-text[text()='Automation']"));
		String desctext = Description.getText();
		System.out.println(desctext);
		if(desctext.equalsIgnoreCase("Automation")) {
			System.out.println("Description is done ");
			
			
		}else {
			System.out.println("Description is not done");
		}
		
	}

}
