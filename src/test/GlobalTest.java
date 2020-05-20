package test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GlobalTest extends TestBase{
		
//	@Test(enabled=false)
//	public void login() throws IOException {
//		loginNew();
//		driver.close();
//	}
	
	@Test
	public void printName() throws IOException {
		printUsername();
	}
	
	@Test
	public void loginOld() throws IOException {
		loginTest();
//		driver.close();
	}

}
