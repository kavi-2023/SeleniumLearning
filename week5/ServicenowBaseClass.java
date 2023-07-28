package week5;

import io.github.sukgu.Shadow;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class ServicenowBaseClass {
	
	public  ChromeDriver driver;
	ChromeOptions c=new ChromeOptions();
	public static String incidentno;
	public Shadow shadow;
	public Actions move;
  
  @BeforeMethod
  public void preCondition() {
	  
	    c.addArguments("--disable-notifications");
	    driver=new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://dev78229.service-now.com/");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Service@2023");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	    shadow=new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Incidents");
		WebElement incident = shadow.findElementByXPath("//a[contains(@class,'keyboard-navigatable highlighted-item')]");
	    move=new Actions(driver);
		move.moveToElement(incident).perform();
		incident.click();
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
  }

  @AfterMethod
    public void postCondition() {
	  
  
       driver.close();
 }

}
