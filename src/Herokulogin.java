import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Herokulogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("myown xpath");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mypassword");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".example h2")).getText());
		driver.findElement(By.xpath("//*[contains(@target, 'blank')]")).click();


		driver.quit();
	}

}
