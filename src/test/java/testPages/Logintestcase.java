package testPages;

import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.Homepage;
import pages.Loginpage;
import testBase.Baseclass;
import utilities.DataProviders;

public class Logintestcase extends Baseclass {
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verifylogin(String username,String password) throws InterruptedException
	{  
		
		
		logger.info(" ***** first login test ****** " );
		Homepage hp=new Homepage(driver);
		hp.gologin();
		Thread.sleep(1000);
		Loginpage lp=new Loginpage(driver);
		lp.login(username, password);
        Assert.assertTrue(lp.isLoginSuccessful(), "Login failed for: " + username);
        
         Thread.sleep(1000);
			logger.info("successfully completed");
			
		
	}
	
	

}
