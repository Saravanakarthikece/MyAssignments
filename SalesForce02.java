package qeagleWeek1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForce02 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
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
		
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("SaravanaKarthik",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class='slds-table forceRecordLayout slds-table_header-fixed slds-table--header-fixed slds-table_edit slds-table--edit slds-table_bordered slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/td[8]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//span[text()='10']")).click();
		WebElement stageClick = driver.findElement(By.xpath("//button[@aria-label='Stage']/span"));
		js.executeScript("arguments[0].click();", stageClick);
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		WebElement delivaryStatus = driver.findElement(By.xpath("//button[@aria-label='Delivery/Installation Status']/span"));
		js.executeScript("arguments[0].click();", delivaryStatus);
		driver.findElement(By.xpath("//span[@title='In progress']")).click();
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SalesForce");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(3000);
		
		String stageValue = driver.findElement(By.xpath("//table[@class='slds-table forceRecordLayout slds-table_header-fixed slds-table--header-fixed slds-table_edit slds-table--edit slds-table_bordered slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/td[5]")).getText();
		System.out.println("Stage is : "+stageValue);
		
		if(stageValue.equalsIgnoreCase("Perception Analysis")) {
		System.out.println("This is the 'Perception Analysis' stage");	
		}else {
			System.out.println("This is not the 'Perception Analysis' stage");
		}
			
		
		

	}

}
