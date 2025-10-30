package testPages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Loginpage;
import testBase.Basepage;

public class Logintestcase extends Basepage {
	
	@Test
	public void verifylogin()
	{  
		
		
		//homepage
		Homepage hp=new Homepage(driver);
		hp.gologin();
		
		//loginpage
		Loginpage lp=new Loginpage(driver);
		lp.setEmail();
		lp.setPassword();
		lp.clickLogin();
		
	}
	
	

}
