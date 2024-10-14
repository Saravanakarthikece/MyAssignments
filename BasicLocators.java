package qeagleWeek1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocators {
	
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("http://leaftaps.com/opentaps/control/main");
//		WebElement userName = driver.findElement(By.id("username"));
//		userName.sendKeys("Demosalesmanager");
//		String input = userName.getAttribute("value");
//		System.out.println(input);
//		driver.findElement(By.id("password")).sendKeys("crmsfa");
//		driver.findElement(By.className("decorativeSubmit")).click();
		driver.manage().window().maximize();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.findElement(By.id("username")).sendKeys("Democsr");

		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.partialLinkText("CRM/")).click();

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.tagName("a"));
	}

}
