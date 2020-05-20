import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");

		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

		// Javascript DOM can extract hidden elements
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text = (String) js.executeScript(script);
		System.out.println(text);
		int i = 0;

		while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
			i++;
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			System.out.println(text);

			if (i > 10) {
				break;
			}
		}
		if (i > 10) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found!");
		}
	}

}
