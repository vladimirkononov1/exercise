import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableExercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/26565/pak-vs-ban-1st-t20i-bangladesh-tour-of-pakistan-2020");

		WebElement table = driver.findElement(By.cssSelector("#innings_1 > div:nth-child(1)"));
		int count = table.findElements(By.cssSelector("#innings_1 div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
//		String extras = table.findElement(By.cssSelector("#innings_1 div[class='cb-col cb-col-100 cb-scrd-itms']:nth-child(10) div:nth-child(2)")).getText();
		String extras = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		String totalText = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		

		int numExtras = Integer.parseInt(extras);
		int total = Integer.parseInt(totalText);
		
		for(int i=0; i<count-2; i++) {
			String value = table.findElements(By.cssSelector("#innings_1 div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int num = Integer.parseInt(value);
			sum = sum + num;
		}
		sum = sum + numExtras;
		System.out.println(sum);
		Assert.assertEquals(sum, total);
		if(sum == total) {
			System.out.println("The test has passed!");
		}else {
			System.out.println("Something got wrong...");
		}
	}

}
