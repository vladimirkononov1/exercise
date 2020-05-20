import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Print number of rows
		
		WebElement table = driver.findElement(By.id("product"));
		System.out.println("The number of rows is " + table.findElements(By.tagName("tr")).size());
		
		//Print number of columns
		
//		System.out.println("The number of columns is " + table.findElements(By.xpath("//tr/th")).size());
		System.out.println("The number of columns is " + table.findElements(By.tagName("tr"))
		.get(0).findElements(By.tagName("th")).size() + "\n");

		
		//Print the second row content
		
//		int count = table.findElements(By.cssSelector("tr:nth-child(3) td")).size();
//		for(int i=0; i<count; i++) {
//			System.out.println(table.findElements(By.cssSelector("tr:nth-child(3) td")).get(i).getText());
//		}
		
		int count = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td")).size();
		List<WebElement> value = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		for(int i=0; i<count; i++) {
			System.out.println(value.get(i).getText());
		}
		
		driver.close();
	}

}
