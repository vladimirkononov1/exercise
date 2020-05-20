import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RediffPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get("https://www.rediff.com/");

//		driver.findElement(By.xpath("//a[contains(@title, 'Sign in')]")).click();
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='login1']")));
//		driver.findElement(By.cssSelector("input[id='login1']")).sendKeys("myUsername");
		element.sendKeys("myUsername");
//		driver.findElement(By.xpath("//input[@id='login1']"));
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("myPassword");
		driver.findElement(By.cssSelector("input[value='Sign in']")).click();
		
		
//		driver.quit();

	}
	
	

}
