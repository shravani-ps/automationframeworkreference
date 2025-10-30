package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Basepage;

public class Homepage extends Basepage {

	
	WebDriver driver;
      
	
	@FindBy(xpath="//button[text()='Login']")
	public WebElement loginbtn;
	
	public void gologin()
	{
	loginbtn.click();
	}
	 public Homepage(WebDriver driver) 
     {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	    }

	
	
}
