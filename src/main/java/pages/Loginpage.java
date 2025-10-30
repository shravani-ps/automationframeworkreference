package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.Basepage;

public class Loginpage extends Basepage {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@title='Submit the form']")
	WebElement btnLogin;


	public void setEmail() {
		txtEmailAddress.sendKeys("karunmca8@gmail.com");
	}

	public void setPassword() {
		txtPassword.sendKeys("Admin@123");
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	public Loginpage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
		
	}
	

}
