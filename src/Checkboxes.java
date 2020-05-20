import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		Thread.sleep(2000);
		
		WebElement checkboxSeniorCitizen = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));

		Assert.assertFalse(checkboxSeniorCitizen.isSelected());
//		if(checkboxSeniorCitizen.isSelected()) {
//			System.out.println("SeniorCitizen checkbox is selected");
//		} else {
//			System.out.println("SeniorCitizen checkbox is NOT selected");
//		}
		checkboxSeniorCitizen.click();
		
		Assert.assertTrue(checkboxSeniorCitizen.isSelected());
//		if(checkboxSeniorCitizen.isSelected()) {
//			System.out.println("SeniorCitizen checkbox is selected");
//		} else {
//			System.out.println("SeniorCitizen checkbox is NOT selected");
//		}
		System.out.println("Number of checkboxes on the page is " +
		driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//Selecting adult passengers
		WebElement passengersDropDown = driver.findElement(By.id("divpaxinfo"));
		passengersDropDown.click();
		
		Select adults = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adults.selectByValue("5");
		var result = passengersDropDown.getText();
		Assert.assertEquals(passengersDropDown.getText(), result);
		
		System.out.println(result);
		

	}

}
