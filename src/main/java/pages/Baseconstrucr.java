package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Baseconstrucr {
	

    WebDriver driver;
  	Baseconstrucr(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);

}
}
