package week6.day1;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass {
	
	@Test(dataProvider="sendData")
	
	public void DeleteLeadTest(String pNo) throws InterruptedException {
					
		    driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		    driver.findElement(By.xpath("(//a[@class='x-tab-right'])[2]")).click();
		    driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pNo);
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
	
	@DataProvider
   public String[][] sendData() {
	 
	 String[][] data=new String[2][1];
	 data[0][0]="90";
	 data[1][0]="91";
	 return data;
	 
 }
	
}


