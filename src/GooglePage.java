import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@id='searchform']/form/div[2]/div/div/div/div/input")).sendKeys("Kharkiv" + Keys.ENTER);

		
		
//		driver.quit();
	}

}
