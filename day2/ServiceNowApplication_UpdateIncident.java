package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ServiceNowApplication_UpdateIncident extends ServiceNowBaseClass{

	@BeforeTest
	public void setValues() {
		
		excelFileName="ServiceNowApplication";
		inputsheet="Sheet2";
	}	
	
    @Test(dataProvider="sendData")
	
	public void serviceNowApplication_UpdateIncident(String urg,String st) {
		
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(ServiceNowApplication_NewIncident.incidentno,Keys.ENTER);
		WebElement incno = driver.findElement(By.xpath("//td[@class='vt']//a"));
		String no=incno.getText();
		System.out.println("Updated Incident no:"+no);
		incno.click();
		WebElement urgency = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		move.moveToElement(urgency).perform();
		urgency.click();
		Select Priority=new Select(urgency);
		Priority.selectByVisibleText(urg);
		WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']"));
		move.moveToElement(state).perform();
		state.click();
		Select Inprogress=new Select(state);
		Inprogress.selectByVisibleText(st);
		WebElement update = driver.findElement(By.xpath("(//button[text()='Update'])[2]"));
		move.moveToElement(update).perform();
		update.click();
		driver.findElement(By.xpath("(//td[@class='vt'])[1]//a")).click();
		String incidentstate = driver.findElement(By.xpath("(//span[@class='sn-widget-list-table-cell'])[2]//span")).getText();
		System.out.println("Incident State:"+incidentstate);
		String priority = driver.findElement(By.xpath("(//span[@class='sn-widget-list-table-cell'])[4]//span")).getText();
		System.out.println("Priority:"+priority);
	    if(incidentstate.equals(st)) {
		
			System.out.println("Incident got updated");
		}
		else {
			
			System.out.println("Incident not updated");
			
		}
		
		
	}

}
