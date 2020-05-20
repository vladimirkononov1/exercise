import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RahulshettyAcademy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get("https://www.rahulshettyacademy.com/");
//		driver.get("http://www.qaclickacademy.com/interview.php");

		
//		driver.findElement(By.xpath("//div[@class='header-upper']/div/div/div/nav/div[2]/ul/li[1]/following-sibling::li[3]")).click();
//		driver.findElement(By.xpath("//a[text()='Articles']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@class='arrow-box']/parent::div")).getAttribute("class"));
//		System.out.println(driver.findElement(By.xpath(".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));

		driver.findElement(By.xpath("//footer[@class='main-footer']/div/div/div/div[2]/ul/li[1]")).click();

	}

}
