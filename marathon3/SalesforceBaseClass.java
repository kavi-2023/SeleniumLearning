package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class SalesforceBaseClass {
	
	public RemoteWebDriver driver;
	public String excelname;
	public String Sheet;
	
	@Parameters({"Browser","url","user","pwd"})
  
  @BeforeMethod
  public void preCondition(String Browser,String url,String user,String pwd) {
		
	if (Browser.equalsIgnoreCase("Chrome")) {
				
    ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
    driver=new ChromeDriver(options);
	}
	
	else if (Browser.equalsIgnoreCase("Edge")) {
		
		EdgeOptions option=new EdgeOptions();
		option.addArguments("--disable-notifications");
		driver=new EdgeDriver(option);
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get(url);
	
	driver.findElement(By.id("username")).sendKeys(user);
	driver.findElement(By.id("password")).sendKeys(pwd);
	driver.findElement(By.id("Login")).click();
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
}
	
	@DataProvider
	public String[][] sendData() throws IOException {
		
		return SalesforceExcel.salesforceExcel(excelname,Sheet);
	}
	
	@AfterMethod
	public void postCondition() {
		
		driver.close();
		
	}
  
}  
