package week5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ServiceNowApplication_NewCaller extends ServicenowBaseClass {
		
	@Test
	
	public  void serviceNowApplication_NewCaller() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@id='list_nav_incident']//button[text()='New']")).click();
	    incidentno = driver.findElement(By.xpath("//input[@id=\"incident.number\"]")).getAttribute("value");
		System.out.println("Incidentno:"+incidentno);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Testincident");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentno,Keys.ENTER);
		String incno = driver.findElement(By.xpath("//td[@class='vt']//a")).getText();
		if(incidentno.equals(incno)) {
			
			System.out.println("Incident created");
		}
		
		else {
			
			System.out.println("Incident not created");
		}
				
		
	}

}
