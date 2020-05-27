package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class windowPopUp {

	public WebDriver driver;

	private By basicAuth = By.linkText("Basic Auth");
	
	@BeforeTest
	public void initialized() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void getPopUpWindow() {
		// TODO Auto-generated method stub

		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(basicAuth).click();
		System.out.println("Login Success!\n");
	}

}
