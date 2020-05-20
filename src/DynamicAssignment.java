import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DynamicAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// Select second checkbox
		WebElement checkbox = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]"));
		checkbox.findElement(By.id("checkBoxOption2")).click();
		String checkboxLabel = checkbox.getText();
		System.out.println(checkboxLabel);

		// Select an option in dropdown
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(checkboxLabel);

		// Enter the step 2 grabbed label text in edit box and click Alert
		driver.findElement(By.id("name")).sendKeys(checkboxLabel);
		driver.findElement(By.id("alertbtn")).click();

		// Verify if text grabbed from step 2 is present in the pop up message
		Alert alert = driver.switchTo().alert();

		// Use assertion
//		Assert.assertTrue(alert.getText().contains(checkboxLabel), "Alert doesn't contain " + checkboxLabel);

		if (alert.getText().contains(checkboxLabel)) {
			System.out.println("Alert contains " + checkboxLabel);
			alert.accept();
		} else {
			System.out.println("Alert doesn't contain " + checkboxLabel);
			alert.accept();

		}

		driver.close();
	}

}
