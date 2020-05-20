import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create Driver object for chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://login.salesforce.com");
////		driver.findElement(By.linkText("login")).click();
//		driver.findElement(By.id("username")).sendKeys("hello");
//		driver.findElement(By.id("password")).sendKeys("hello1234");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("hello");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("hello");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		var error = driver.findElement(By.cssSelector("div#error.loginError"));
		System.out.println("The error says: " + error.getText());


		
		
//		driver.close();

	}

}
