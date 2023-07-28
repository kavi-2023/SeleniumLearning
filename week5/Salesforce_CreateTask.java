package week5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Salesforce_CreateTask {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(c);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://qeagle-dev-ed.my.salesforce.com/");
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-input-has-icon_left-right')]//input[@class='slds-input']")).sendKeys("task",Keys.ENTER);
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		driver.findElement(By.xpath("//a[contains(@class, 'slds-button--icon-border-filled')]")).click();
		driver.findElement(By.xpath("//div[text()='New Task']")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");
		
		
		
	}

}
