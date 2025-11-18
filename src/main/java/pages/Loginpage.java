package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Loginpage extends Basepage {
	
	public Loginpage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@title='Submit the form']")
	WebElement btnLogin;


	public void setEmail(String username) {
		txtEmailAddress.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	
	

	public void login(String username, String password) {
		// TODO Auto-generated method stub
		setEmail(username);
		setPassword(password);
		clickLogin();
	}
	
	    /** ✅ Check if login is successful */
	    public boolean isLoginSuccessful() {
	        try {
	            // Example: check that a logout link or dashboard appears
	            return driver.findElement(By.xpath("//a[@routerlink='./f']")).isDisplayed();
	            // or check for title, URL, etc.:
	            // return driver.getTitle().contains("Dashboard");
	        } catch (Exception e) {
	            return false;
	        }
	    }
	}


