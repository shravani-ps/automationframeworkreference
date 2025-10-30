package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class Basepage {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String browser;
	
	@BeforeClass
	public void initconfiguration()

	{
		
		if(Constants.browser.equals("chrome")) {
			driver=new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shravani\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
			
			
		}
		driver.get(Constants.testurl);
		driver.manage().window().maximize();
		
			
	}
	
}
