package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WPCreationOfDataByHittingURLS {

	@FindBy(xpath = "//span[contains(text(),'Success')]")
	public static WebElement lblSuccessMessage;	
	
	@FindBy(xpath="")
	public static WebElement lblSuccessMessageForExitIt;
}
