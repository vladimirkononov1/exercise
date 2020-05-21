package test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public WebDriver driver = null;
	
	
	public WebDriver loginTest() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\vladi\\workspace\\Exercise\\src\\test\\datadriver.properties");
		prop.load(fis);
		
		if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vladi\\workspace\\geckodriver.exe");
			driver  = new FirefoxDriver();
		} else if (prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
		
		driver.findElement(By.id("gb_70")).click();
		driver.findElement(By.id("identifierId")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("identifierNext")).click();
		
		return driver;

	}
	
	public void printUsername() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\vladi\\workspace\\Exercise\\src\\test\\datadriver.properties");
		prop.load(fis);
		
		String user = prop.getProperty("username");
		System.out.println(user);
	}
	
}
