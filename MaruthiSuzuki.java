package qeagleWeek1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MaruthiSuzuki {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.marutisuzuki.com/");
		driver.findElement(By.className("headerSearch-btn")).click();
		driver.findElement(By.name("key")).sendKeys("Swift",Keys.ENTER);
		driver.findElement(By.className("icon-general_info")).click();
		WebElement dd = driver.findElement(By.id("selectcity1"));
		Select obj=new Select(dd);
		obj.selectByVisibleText("INDI");
		driver.findElement(By.className("nav-link")).click();
		driver.findElement(By.linkText("SAFETY")).click();
		String text = driver.findElement(By.className("caption-text")).getText();
		System.out.println(text);
		
		
		

	}

}
