import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// 1. Give me the count of links on the page
		System.out.println("The page has " + driver.findElements(By.tagName("a")).size() + " links.");

		// 2. Count of links on the footer of the page
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
		System.out.println("There are " + footerDriver.findElements(By.tagName("a")).size() + " links in the footer.");

		// 3. Links count of first column of the footer
		WebElement columnOneDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
		System.out.println("There are " + columnOneDriver.findElements(By.tagName("a")).size()
				+ " links in the first columt of the footer");

		// Click on each link in the column and check if pages are opening
		Actions a = new Actions(driver);
		for (int i = 1; i < columnOneDriver.findElements(By.tagName("a")).size(); i++) {
			String ctrlClickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnOneDriver.findElements(By.tagName("a")).get(i).sendKeys(ctrlClickLink);

		}

		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}

}
