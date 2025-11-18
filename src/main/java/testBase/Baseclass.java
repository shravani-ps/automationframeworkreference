package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.io.FileHandler;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeMethod
	@Parameters({"os","browser"})
	
	public void setup(String os,String br) throws IOException
	{
		FileReader file=new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		if(p.getProperty("execution_env").equalsIgnoreCase("Remote"))
		{
			//MutableCapabilities options; this may used from selenium 4 instead desiredcapabilities
			DesiredCapabilities capability=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				capability.setPlatform(Platform.WIN11);
			}else
			
				if(os.equalsIgnoreCase("mac"))
				{
					capability.setPlatform(Platform.MAC);
				}
				else
				{
					System.out.println("no matching");
				 return;
				}
			
			switch(br.toLowerCase())
			{
			case "chrome":capability.setBrowserName("chrome");break;
			case "firefox":capability.setBrowserName("firefox");break;
			default:System.out.println("invalidbrowser");return;
		
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444"), capability);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))	
		{
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		//case "edge":driver=new EdgeDriver();break;
		default:System.out.println("Invalid browser");return;
		}
		}
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void teardown()
	{
	if(driver!=null) {
		driver.quit();
	}
		
	}
//	public String randomstring()
//	{
//		String generatedstring=RandomStringUtils.randomAlphabetic(5);
//		return generatedstring;
//		
//	}
//	public String randomeNumber()
//	{
//		String generatedString=RandomStringUtils.randomNumeric(10);
//		return generatedString;
//	}
	public String capturescnshot(String tname)
	{
		String timestamp = new SimpleDateFormat("YYYYMMDDHHSS").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"/Screenshot/" + tname + "_" + timestamp +  ".png";
		File destination=new File(dest);
		try {
			FileHandler.copy(source,destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return dest;
		
	}
	
	
	

}
