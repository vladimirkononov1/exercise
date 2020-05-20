import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CleartripAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");

		Select adults = new Select(driver.findElement(By.id("Adults")));
		Select children = new Select(driver.findElement(By.id("Childrens")));

		adults.selectByValue("2");
		children.selectByValue("3");

		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();
		driver.findElement(By.id("MoreOptionsLink")).click();

		driver.findElement(By.cssSelector("[name='airline']")).sendKeys("delta");

		driver.findElement(By.id("SearchBtn")).click();
		System.out.println("The error message is: " + driver.findElement(By.id("homeErrorMessage")).getText());

		driver.close();
	}
}
