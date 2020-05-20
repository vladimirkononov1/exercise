import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		driver.findElement(By.xpath("//ul[@class='Bgzgmd']/li[2]")).click();
		System.out.println("Before Switching:");
		System.out.println(driver.getTitle() + "\n");
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		System.out.println("After Switching:");

		System.out.println(driver.getTitle() + "\n");
		
		driver.switchTo().window(parentWindow);
		System.out.println("Switching back to Parent:");
		System.out.println(driver.getTitle());

		
	}

}
