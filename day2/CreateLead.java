package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	
	@BeforeTest
	public void setValues(){
		
		excelFileName="CreateLead";
	}
	
	@Test(dataProvider="sendData")
	public void CreateLeadTest(String cName,String fName,String lName,String phNo) {
	
	driver.findElement(By.linkText("Create Lead")).click();
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
//	driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fLName);
//	driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(dName);
//	driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
//	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
	driver.findElement(By.xpath("//input[contains(@id,'primaryPhoneNumber')]")).sendKeys(phNo);
	WebElement stateProvince=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
	Select StPrvnc=new Select(stateProvince);
	StPrvnc.selectByVisibleText("New York");
	driver.findElement(By.name("submitButton")).click();
	System.out.println("Title :"+driver.getTitle());

}
	
	
		
		
}	




