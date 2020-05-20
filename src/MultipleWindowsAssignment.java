import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindowsAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		WebDriverWait w = new WebDriverWait(driver, 3);
		
		driver.findElement(By.xpath("//a[contains(text(), 'Multiple')]")).click();
		driver.findElement(By.cssSelector("[id='content'] a")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		//Printing Child Window Text
		System.out.println("Child Window Text:\n" 
		+ driver.findElement(By.cssSelector("div h3")).getText());
		driver.switchTo().window(parentWindow);
		//Printing Parent Window Text
		System.out.println("\nParent Window Text:\n" + driver.findElement(By.cssSelector("div h3")).getText());
		
		driver.quit();

	}

}
