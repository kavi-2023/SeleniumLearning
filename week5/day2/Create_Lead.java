package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Create_Lead extends BaseClass {
	
	@Test
	public void CreateLeadTest() {
	
	driver.findElement(By.linkText("Create Lead")).click();
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kavi");
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys("A");
	driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("K");
	driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
	driver.findElement(By.id("createLeadForm_description")).sendKeys("Software");
	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("k@123.com");
	driver.findElement(By.xpath("//input[contains(@id,'primaryPhoneNumber')]")).sendKeys("9000235468");
	WebElement stateProvince=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
	Select StPrvnc=new Select(stateProvince);
	StPrvnc.selectByVisibleText("New York");
	driver.findElement(By.name("submitButton")).click();
	System.out.println("Title :"+driver.getTitle());

}
}	
