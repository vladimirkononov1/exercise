package test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload {

		public WebDriver driver;
		public WebDriverWait wait;
		
		public File f; 
		private By chooseFile = By.xpath("//li[@class='element-with-tooltip']//span[contains(text(),'Choose File')]");
		private By downloadButton = By.xpath("//li[@class='element-with-tooltip']//p[contains(text(),'DOWNLOAD')]");
				
		@BeforeTest
		public void initialized() {
			
			String downloadPath = System.getProperty("user.dir");			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vladi\\workspace\\chromedriver.exe");
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadPath);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(options);
			f = new File(downloadPath + "/Vladimir_Kononov_Resume_ORIG.zip");

		}

		@AfterTest
		public void tearDown() {
			driver.quit();
		}

		@Test
		public void fileUpload() throws InterruptedException, IOException {
			wait = new WebDriverWait(driver, 10);
			driver.get("https://avepdf.com/en/pdf-to-jpeg");
			driver.findElement(chooseFile).click();
			Thread.sleep(3000);
			Runtime.getRuntime().exec("C:\\Users\\vladi\\OneDrive\\Documents\\check\\fileUpload.exe");
			wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButton));
			driver.findElement(downloadButton).click();
			Thread.sleep(5000);
			if(f.exists()) {
				Assert.assertTrue(f.exists());
				System.out.println(f);
				System.out.println("File downloaded successfully!");
				if(f.delete()) {
					System.out.println("file deleted");
				}
			} else {
				System.out.println(f);
				System.out.println("File not found");
			}
		}

}
