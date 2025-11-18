package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Homepage extends Basepage  {

	
	public Homepage(WebDriver driver) {
		super(driver);
		
	}
      
	
	@FindBy(xpath="//button[text()='Login']")
	public WebElement loginbtn;
	
	public void gologin()
	{
	loginbtn.click();
	}
	

	
	
}
