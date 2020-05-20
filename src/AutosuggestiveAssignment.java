import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement input = driver.findElement(By.id("autocomplete"));

		input.sendKeys("uni");
		Thread.sleep(1000);
		input.sendKeys(Keys.DOWN);

		// The other way to get the value without using JavascriptExecutor
//		System.out.println(input.getAttribute("value"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		String text = (String) js.executeScript(script);
		
		String inputValue = input.getAttribute("value"); //in case to use none JavascriptExecutor

		
		int i = 0;
		while(!text.equalsIgnoreCase("United States (USA)")) {
			i++;
			inputValue = input.getAttribute("value"); //in case to use none JavascriptExecutor
			input.sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			System.out.println(text);
			
			if(i>10) {
				System.out.println("Element not found");
				break;
			}else if(text.equalsIgnoreCase("United States (USA)")){
				System.out.println("\nSuccess!");
			}
		}
		driver.close();
	}

}
