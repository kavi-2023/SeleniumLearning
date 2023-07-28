package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Duplicate_Lead extends BaseClass{
	
	@Test
	public void DuplicateLeadTest() {
						
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kavi");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("A");
			driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("K");
			driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
			driver.findElement(By.id("createLeadForm_description")).sendKeys("Software");
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("k@123.com");
			WebElement stateProvince=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select StPrvnc=new Select(stateProvince);
			StPrvnc.selectByVisibleText("New York");
			driver.findElement(By.name("submitButton")).click();
			driver.findElement(By.linkText("Duplicate Lead")).click();
		    driver.findElement(By.id("createLeadForm_companyName")).clear();
		    driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TL");
			driver.findElement(By.id("createLeadForm_firstName")).clear();
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kavitha");
			driver.findElement(By.linkText("Create Lead")).click();
			System.out.println("Title :"+driver.getTitle());
			
		}

}
