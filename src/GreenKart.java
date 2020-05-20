import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//implicit wait
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//explicit wait creating object
		WebDriverWait w = new WebDriverWait(driver, 5);


		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Tomato" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//		Thread.sleep(3000);
		addItems(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
		

//		driver.close();
	}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;

		for (int i = 0; i < products.size(); i++) {
			// format it to get actual vegetable name
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// convert array into array list for easy search
			// check whether name you extracted is present in arrayList or not
			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				j++;
				// click on Add to cart
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
	
	

}
