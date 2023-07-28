package week5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ServiceNowApplication_DeleteIncident extends ServicenowBaseClass {
	
	@Test
	
	public  void serviceNowApplication_DeleteIncident() throws InterruptedException {
		
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(ServiceNowApplication_NewCaller.incidentno,Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='vt']//a")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();
		String deletedinc = driver.findElement(By.xpath("(//div[@class='breadcrumb_container']//a)[9]//b")).getText();
		System.out.println("Deleted Incident:"+deletedinc.substring(9));
		String deletedmsg = driver.findElement(By.xpath("//div[@class='list2_empty-state-list']")).getText();
		System.out.println("Deleted Confirmation:"+deletedmsg);
		
	}
	


}
