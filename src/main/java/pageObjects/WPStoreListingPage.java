package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import utility.TestSetUp;
import utility.Log;
import utility.Utils;

public class WPStoreListingPage extends TestSetUp{
	public static final Logger log = LogManager.getLogger(WPStoreListingPage.class);
	
	//Constructore
	public WPStoreListingPage(WebDriver driver, ExtentTest logger){
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.debug("Waiting for the Home page");
		reportStep("Waiting for the Home page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lblSearchResults));
			Log.info("Successfully landed on the Store Listing Page");
			reportStep("Successfully landed on the Home page ", "PASS");
		} catch (Exception e) {
			Log.error("Not able to land on the Home page");
			reportStep("Not able to land on the Home page", "FAIL");
		} 
	}
	
	@FindBy(xpath="//h2[contains(text(),'SEARCH RESULTS')]")
	private static WebElement lblSearchResults;

	@FindBy(xpath="(//a[contains(text(),'ACTIVATE CASHBACK')])")
	private static List<WebElement> lnkActivateCashback;
	
	// Click Activate Cashback Button
	public WPSignUpSignInPopUp clickActivateCashBackInSLP() {// SLP stands for Stores Listing Page
		try {
			reportStep("Locating Activate Cashback in SLP", "INFO");
			Log.info("Locating Activate Cashback in SLP ");
			Utils.explicitWaitForVisibility(lnkActivateCashback.get(0));
			Utils.click(lnkActivateCashback.get(0));
			reportStep("Clicked successfully Activate Cashback in SLP", "PASS");
			Log.info("Clicked Successfully Activate Cashback in SLP");
		}catch(Exception e) {
			Log.error("Unable to Click  Activate Cashback in SP");
			reportStep("Unable to Click Activate Cashback in SP", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}
}
