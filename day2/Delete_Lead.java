package week5.day2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Delete_Lead extends BaseClass{
	
	@Test
	
public void DeleteLeadTest() throws InterruptedException {
				
	    driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	    driver.findElement(By.xpath("(//a[@class='x-tab-right'])[2]")).click();
	    driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9000235468");
	    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	    Thread.sleep(2000);
	    String Leadid=driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
	    System.out.println(Leadid);
	    driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
	    driver.findElement(By.xpath("//a[text()='Delete']")).click();
	    driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	    driver.findElement(By.xpath("//input[@name='id']")).sendKeys(Leadid);
	    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	    Thread.sleep(1000);
	    String msg=driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
	    System.out.println("Message:"+msg);
	       
	    
	}

}
