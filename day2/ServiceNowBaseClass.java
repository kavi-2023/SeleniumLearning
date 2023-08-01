package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.sukgu.Shadow;

public class ServiceNowBaseClass {

	public RemoteWebDriver driver;
	public String excelFileName;
	public String inputsheet;
	public static String search = "Incidents";
	public static String incidentno;
	public Shadow shadow;
	public Actions move;

	@Parameters({ "Browser", "url", "user", "pwd" })
	@BeforeMethod
	public void preCondition(String Browser, String url, String user, String pwd) {

		if (Browser.equals("Chrome")) {
			ChromeOptions c = new ChromeOptions();

			c.addArguments("--disable-notifications");
			driver = new ChromeDriver(c);
		} else if (Browser.equals("Edge")) {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--disable-notifications");
			driver = new EdgeDriver(option);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get(url);
		driver.findElement(By.id("user_name")).sendKeys(user);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//input[@id='filter']").sendKeys(search, Keys.ENTER);
		WebElement incident = shadow.findElementByXPath("//a[contains(@class,'keyboard-navigatable highlighted-item')]");
		move = new Actions(driver);
		move.moveToElement(incident).perform();
		incident.click();
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
	}

	@DataProvider
	public String[][] sendData() throws IOException {

		return ServiceNowApplicationReadingExcel.readExcelData(excelFileName, inputsheet);
	}

	@AfterMethod
	public void postCondition() {

		driver.close();
	}

}
