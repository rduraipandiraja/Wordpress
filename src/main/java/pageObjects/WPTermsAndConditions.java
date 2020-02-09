package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class WPTermsAndConditions extends TestSetUp{
	public static final Logger log = LogManager.getLogger(WPTermsAndConditions.class);

	public WPTermsAndConditions(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		String info="Loading Tems and Conditions Page";
		String pass="Successfully navigated to Tems and Conditions Page";
		String fail="Unable to navigate to Tems and Conditions Page";
		Log.info(info);
		reportStep(info, "INFO");
		try {
			if(Utils.verifyElementPresence(headingTermsAndConditions)) {
				Log.info(pass);
				reportStep(pass, "PASS");
			}else {
				Log.error(fail);
				reportStep(fail, "FAIL");
			}
		} catch (Exception e) {
			Log.error(fail);
			reportStep(fail, "FAIL");

		} 
	}
	
	@FindBy(xpath="//h1[text()='Terms & Conditions']")
	private static WebElement headingTermsAndConditions;
	
	public WPTermsAndConditions verifyPageTitleOfTermsAndCondition(String pageTitle) {
		Log.info("Verifying Page Title of Terms and Conditions Page");
		reportStep("Verifying Page Title of Terms and Conditions Page","INFO");
		String title=Utils.getPageTitle(driver);
		if(title.equals(pageTitle)) {
			Log.info("Verified Page Title of Terms and Conditions Page");
			reportStep("Verifyied Page Title of Terms and Conditions Page","PASS");
		}else {
			Log.info("Page Title of Terms and Conditions Page is not as expected. Actual is " +pageTitle);
			reportStep("Page Title of Terms and Conditions Page is not as expected. Actual is " +pageTitle,"FAIL");
		}
		return this;
	}
}
