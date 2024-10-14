package qeagleWeek1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TelerikPratice {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.telerik.com/contact");
		
		WebElement drop1 = driver.findElement(By.id("Dropdown-1"));
		Select obj = new Select(drop1);
		obj.selectByValue("Invoicing/Billing");
		
		WebElement drop2 = driver.findElement(By.id("Dropdown-2"));
		Select obj1 = new Select(drop2);
		obj1.selectByVisibleText("Testing Framework");
		
		driver.findElement(By.id("Textbox-1")).sendKeys("Saravana");
		driver.findElement(By.id("Textbox-2")).sendKeys("Karthik");
		
		WebElement drop3 = driver.findElement(By.id("Country-1"));
		Select obj3 = new Select(drop3);
		obj3.selectByIndex(1);
		
		driver.findElement(By.id("Email-1")).sendKeys("msk2602@gmail.com");
		
		driver.findElement(By.id("Textbox-3")).sendKeys("MSK Pvt Ltd");
		
		driver.findElement(By.id("Textbox-4")).sendKeys("9597161525");
		
		
		
	}

}
