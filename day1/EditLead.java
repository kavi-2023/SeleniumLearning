package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends BaseClass{
	
	@Test(dataProvider="sendData")
	public void EditLeadTest(String cName,String fName,String lName,String fLName,String dName,String desc,String email,String clrdesc) {
						
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
			driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fLName);
			driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(dName);
			driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
			WebElement stateProvince=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select StPrvnc=new Select(stateProvince);
			StPrvnc.selectByVisibleText("New York");
			driver.findElement(By.name("submitButton")).click();
			driver.findElement(By.linkText("Edit")).click();
			driver.findElement(By.id("updateLeadForm_description")).clear();
			driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys(clrdesc);
			driver.findElement(By.name("submitButton")).click();
			System.out.println("Title :"+driver.getTitle());
			
		}
	
	@DataProvider
	public String[][] sendData() {
		
		String[][] data=new String[2][8];
		data[0][0]="TestLeaf";
		data[0][1]="Kavi";
		data[0][2]="A";
		data[0][3]="K";
		data[0][4]="IT";
		data[0][5]="Software";
		data[0][6]="k@123.com";
		data[0][7]="clear desc";
		
		data[1][0]="CTS";
		data[1][1]="Ananya";
		data[1][2]="R";
		data[1][3]="A";
		data[1][4]="IT";
		data[1][5]="Network";
		data[1][6]="A@456.com";
		data[1][7]="cleared desc";
		return data;
	}

}


