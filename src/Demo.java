import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
					

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create Driver object for chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("http://facebook.com");
		
//		driver.findElement(By.id("email")).sendKeys("test@gmail.com");;
//		driver.findElement(By.id("pass")).sendKeys("test");
//		driver.findElement(By.id("u_0_4")).submit();
//		driver.findElement(By.linkText("Forgot account?")).click();;
		
		
		
		driver.close();

	}

}
