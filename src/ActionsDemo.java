import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\vladi\\workspace\\geckodriver.exe");
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		
		//Type capital letters in Search field
		a.clickAndHold(search).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//Moves to Specific element
		a.moveToElement(move).build().perform();
		
		//Drag and Drop

	}

}
