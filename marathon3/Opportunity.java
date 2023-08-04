package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Opportunity extends SalesforceBaseClass{
	
	@BeforeTest
	public void setValues(){
		excelname="Salesforce";
		Sheet="Sheet2";
	}
	
	@Test(dataProvider="sendData")
public void opportunitycreation(String oppname,String amt) throws InterruptedException {
						
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(2000);
		WebElement keydeals = driver.findElement(By.xpath("//a[@class='filterIcon slds-button slds-button--icon-more ']"));
		Actions move=new Actions(driver);
		move.moveToElement(keydeals).perform();
		driver.executeScript("arguments[0].click();", keydeals);
		WebElement allopportunities = driver.findElement(By.xpath("//a[@title='All Opportunities']"));
		driver.executeScript("arguments[0].click();", allopportunities);
		WebElement keydealsviewall = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		move.moveToElement(keydealsviewall).perform();
		driver.executeScript("arguments[0].click();", keydealsviewall);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(oppname);
		WebElement type = driver.findElement(By.xpath("(//span[text()='--None--'])[2]"));
		driver.executeScript("arguments[0].click();", type);
		WebElement newcust = driver.findElement(By.xpath("(//span[@class='slds-media__body'])[5]//span"));
		driver.executeScript("arguments[0].click();", newcust);
		WebElement LeadSource = driver.findElement(By.xpath("(//span[text()='--None--'])[3]"));
		driver.executeScript("arguments[0].click();", LeadSource);
		WebElement partner = driver.findElement(By.xpath("//span[text()='Partner Referral']"));
		driver.executeScript("arguments[0].click();", partner);
		driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow']//input)[1]")).sendKeys(amt);
		WebElement closedate = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		driver.executeScript("arguments[0].click();", closedate);
		WebElement date = driver.findElement(By.xpath("(//td[@class='slds-is-today'])//following::td//span"));
		driver.executeScript("arguments[0].click();", date);
		WebElement stage = driver.findElement(By.xpath("(//span[text()='--None--'])[1]"));
		driver.executeScript("arguments[0].click();", stage);
		WebElement needanalysis = driver.findElement(By.xpath("//span[text()='Needs Analysis']"));
		driver.executeScript("arguments[0].click();", needanalysis);
		WebElement pricampgnsrc = driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[2]"));
		driver.executeScript("arguments[0].click();", pricampgnsrc);
		WebElement newcampgn = driver.findElement(By.xpath("//span[text()='New Campaign']"));
		driver.executeScript("arguments[0].click();", newcampgn);
		driver.findElement(By.xpath("(//input[@class=' input'])[1]")).sendKeys("New Campaign");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String cmpgnmsg = driver.findElement(By.xpath("//span[contains(@class,'forceActionsText')]")).getText();
		System.out.println(cmpgnmsg);
				

}

}
