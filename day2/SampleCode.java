package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SampleCode {

	public static void main(String[] args) {
		
		EdgeDriver driver=new EdgeDriver();
		driver.get("http://www.google.com");

		ChromeDriver d=new ChromeDriver();		
		d.get("http://www.google.com");

	}

}
