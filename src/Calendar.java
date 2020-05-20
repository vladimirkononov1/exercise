import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");

		driver.findElement(By.id("travel_date")).click();
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("Jun")){
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
		}
		
		List<WebElement> days = driver.findElements(By.cssSelector("[class=' table-condensed'] [class='day']"));
		int count = days.size();
		for(int i=0; i<count; i++) {
			String text = driver.findElements(By.cssSelector(".day")).get(i).getText();
			if(text.equalsIgnoreCase("29")) {
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}
	}

}
