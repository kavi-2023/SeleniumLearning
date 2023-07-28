package week5.day2;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;



public class BaseClass {
	
	public  static ChromeDriver driver;
	@BeforeMethod

  public void preCondition() {
		
		driver=new ChromeDriver();
	  		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement usrname=driver.findElement(By.id("username"));
		usrname.sendKeys("demoSalesManager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
  }
  
  
  

@AfterMethod
public void postCondition() {
	  
	  driver.close();

}
}
