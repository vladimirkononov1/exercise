import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssignmentCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement option1 = driver.findElement(By.id("checkBoxOption1"));
		option1.click();
		Assert.assertTrue(option1.isSelected());
		Thread.sleep(2000);
		option1.click();
		Assert.assertFalse(option1.isSelected());
		
//		List<WebElement> numCheckboxes = driver.findElements(By.cssSelector("#checkbox-example > fieldset >label"));
//		System.out.println("There are " + numCheckboxes.size() + " checkboxes");
		
		System.out.println("There are " + driver.findElements(By.cssSelector("input[type=checkbox]")).size() +
				" checkboxes");

	}

}
