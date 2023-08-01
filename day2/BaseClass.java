package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public  RemoteWebDriver driver;
public String excelFileName;
	
	@Parameters({"BROWSER","URL","USER","PWD"})
	@BeforeMethod

  public void preCondition(String BROWSER,String URL,String USER,String PWD) {
		
		if(BROWSER.equals("Chrome")) {
			
			driver=new ChromeDriver();
		}
		
		else if(BROWSER.equals("Edge")) {
			
			driver= new EdgeDriver(); 
		}
	  		
		driver.get(URL);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement usrname=driver.findElement(By.id("username"));
		usrname.sendKeys(USER);
		
		driver.findElement(By.id("password")).sendKeys(PWD);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
  }
  
	@DataProvider
	public String[][] sendData() throws IOException{
		
		return ReadingExcel.excelNameMthd(excelFileName);  
  
	}
@AfterMethod
public void postCondition() {
	  
	  driver.close();

}
}



