package qeagleWeek2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNow {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev242606.service-now.com/");
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("v^S8PbUx1J^k");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service Catalog");
		shadow.findElementByXPath("//mark[text()='Service Catalog']").click();
		Thread.sleep(3000);

		Shadow shadow2 = new Shadow(driver);
		WebElement frame1 = shadow2.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//table[@class='drag_section_header']/tbody/tr/td/a[text()='Mobiles']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']")).click();
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("99");
		WebElement monthData = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select obj=new Select(monthData);
		obj.selectByIndex(2);
		driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
		driver.findElement(By.xpath("//button[@data-original-title='Order Now']")).click();
		String ReqNo = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
		System.out.println("Request Number: "+ReqNo);
		File scr = driver.getScreenshotAs(OutputType.FILE);
		File dcr = new File("./snap/img.png");
		FileUtils.copyFile(scr, dcr);

	
	}

}
