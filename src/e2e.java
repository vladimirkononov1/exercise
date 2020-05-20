import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		Thread.sleep(2000);

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //From dropdown
		driver.findElement(By.xpath("//a[@value='DEL']")).click(); //Select From destination
		Thread.sleep(2000);
		
		//Select Senior Citizen
		driver.findElement(By.cssSelector("#ctl00_mainContent_SeniorCitizenDiv")).click();
		
		//Select One Way radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		//Select To destination
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(2000);
		
		//Select default depart date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click(); //Depart Date
		
		//Click Passengers dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		
		//Select number of adults
		Select adults = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adults.selectByValue("3");
		
		//Select currency
		Select currency = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		currency.selectByValue("USD");
		
		//Assert Return Date is inactive
//		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It's disabled");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		//Click Search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		driver.close();
	}

}
