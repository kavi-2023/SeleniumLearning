package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Salesforce extends SalesforceBaseClass {
	

	@BeforeTest
	public void setValues() {
	 excelname="Salesforce";
	 Sheet="Sheet1"; 
	}
	
	@Test(dataProvider="sendData")
	public  void main(String question,String details) {
		
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Content");
		driver.findElement(By.xpath("//a[@class='slds-text-heading_small']")).click();
		WebElement Chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", Chatter);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(question);
		driver.findElement(By.xpath("//div[contains(@class,'slds-text-color_weak slds-grow')]")).sendKeys(details);
		driver.findElement(By.xpath("//button[contains(@class,'qe-questionPostDesktop MEDIUM')]")).click();
		String askquestion = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		System.out.println(askquestion);
		if(askquestion.equals(question)) {
			
			System.out.println("Question is matched");
		}
		else {
			
			System.out.println("Question is not matched");
		}
	}

}
