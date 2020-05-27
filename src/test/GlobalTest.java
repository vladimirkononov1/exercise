package test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GlobalTest extends TestBase{
	public WebDriver driver;
	
	@BeforeTest
	public void initializedDriver() throws IOException {
		driver = loginTest();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
		
//	@Test(enabled=false)
//	public void login() throws IOException {
//		loginNew();
//	}
	
	@Test
	public void printName() throws IOException {
		printUsername();
	}
	
	@Test
	public void loginOld() throws IOException {
		loginTest();
		System.out.println("one more printed message");
		System.out.println("added by develop");
		System.out.println("added by master");
	}

}
