import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/");
		Thread.sleep(2000);

		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(2000);

		WebElement source = driver.findElement(By.xpath("//*[@class=\"fsw_inputBox searchCity inactiveWidget activeWidget\"]/div/div/div/div/input"));
		source.sendKeys("del");
		Thread.sleep(2000);
		source.sendKeys(Keys.ARROW_DOWN);
		source.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

//		driver.findElement(By.id("toCity")).click();
//		Thread.sleep(2000);
		
		WebElement destination = driver.findElement(By.xpath("//*[@class=\"hsw_autocomplePopup autoSuggestPlugin\"]/div/input"));
		destination.sendKeys("del");
		Thread.sleep(2000);
		for(int i=0; i<4; i++) {
			Thread.sleep(1000);
			destination.sendKeys(Keys.ARROW_DOWN);	
		}
		destination.sendKeys(Keys.ENTER);
		
		

		
	}

}
