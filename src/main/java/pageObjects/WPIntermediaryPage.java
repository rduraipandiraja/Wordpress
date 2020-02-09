package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class WPIntermediaryPage extends TestSetUp{
	Boolean presence;
	public static final Logger log = LogManager.getLogger(WPIntermediaryPage.class);

	//Parameterized Constructor for WP_MissingTicket
	public WPIntermediaryPage(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;
		String info="Waiting for the Intermediary Page Page To Load";
		String pass="Successfully landed on the Intermediary Page page";
		String fail="Unable to land on the Intermediary Page page";
		PageFactory.initElements(driver, this);
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info(info);
		reportStep(info, "INFO");
		try {
			//wait.until(ExpectedConditions.visibilityOf(imgArrowNavigation));
			Log.info(pass);
			reportStep(pass, "PASS");
		} catch (Exception e) {
			Log.error(fail);
			reportStep(fail, "FAIL");

		} 
	}
	
	@FindBy(xpath="//img[contains(@src,'intermediary_animation.gif')]")
	private static WebElement imgArrowNavigation;
	
	public  WPIntermediaryPage verifyArrowNavigationIsPresent() {
		String locator="Locating text of \"Arrow Navigation Image\" in Intermediary Page.";
		String pass="Successfully verified presence of \"Arrow Navigation\" Image in Intermediary Page.";
		String fail="Unable to locate text of Currency \"Arrow Navigation\" Image in Intermediary Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(imgArrowNavigation)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//h1[contains(text(),'Congratulations, nothing more to do!')]")
	private static WebElement lblContratulations;
	
	public  WPIntermediaryPage verifyContratulationsNothingMoreToDoText() {
		String locator="Locating text of \"Congratulations, nothing more to do!\" in Intermediary Page";
		String pass="Successfully verified presence of \"Congratulations, nothing more to do!\" text in Intermediary Page";
		String fail="Unable to locate text of Currency \"Congratulations, nothing more to do!\" text in Intermediary Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblContratulations)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="lblIntermediateRetailerTxt")
	private static WebElement lblRetailerName;

	
	public  WPIntermediaryPage verifyIntermediaryRetailerNameIsPresent() {
		String locator="Locating text of \"Intermediary Retailer Name\" in Intermediary Page";
		String pass="Successfully verified presence of \"Intermediary Retailer Name\" Image in Intermediary Page";
		String fail="Unable to locate text of Currency \"Intermediary Retailer Name\" Image in Intermediary Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblRetailerName)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	@FindBy(id="imgIntermediateCKLogo")
	private static WebElement imgIntermediaryWordPressLogo;
	
	public  WPIntermediaryPage verifyIntermediaryWordPressLogoIsPresent() {
		String locator="Locating text of \"Intermediary Word Press Logo\" in Intermediary Page";
		String pass="Successfully verified presence of \"Intermediary Word Press Logo\" Image in Intermediary Page";
		String fail="Unable to locate text of Currency \"Intermediary Word Press Logo\" Image in Intermediary Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(imgIntermediaryWordPressLogo)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="imgCashbackIntermediate")
	private static WebElement imgIntermediaryCurrencySymbol;
	
	public  WPIntermediaryPage verifyIntermediaryCurrencySymbolIsPresent() {
		String locator="Locating text of \"Intermediary Currency Symbol\" in Intermediary Page";
		String pass="Successfully verified presence of \"Intermediary Currency Symbol\" Image in Intermediary Page";
		String fail="Unable to locate text of Currency \"Intermediary Currency Symbol\" Image in Intermediary Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(imgIntermediaryCurrencySymbol)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//a[contains(text(),'click here')]")
	private static WebElement lnkClickHere;
	
	public  WPIntermediaryPage clickHereLink() {
		String locator="Locating text of \"Click Here Link\" in Intermediary Page";
		String pass="Successfully verified presence of \"Click Here Link\" Image in Intermediary Page";
		String fail="Unable to locate text of Currency \"Click Here Link\" Image cashback.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.explicitWaitForClick(lnkClickHere)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//h2[contains(.,'be added to your account within 72 hours.') and contains(text(),'Shop normally at Cashback Store')]")
	private static WebElement lblTimeForCashBack;
	
	public  WPIntermediaryPage verifyTimeOfCashbackIsPresent(String storeName) {
		String locator="Locating text of \"Shop normally at "+storeName+". Cashback will automatically be added to your account within 72 hours.\" in Intermediary Page";
		String pass="Successfully verified presence of \"Shop normally at "+storeName+". Cashback will automatically be added to your account within 72 hours.\" in Intermediary Page";
		String fail="Unable to locate text of Currency \"Shop normally at "+storeName+". Cashback will automatically be added to your account within 72 hours.\" in Intermediary Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblTimeForCashBack)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//body)[1]")
	private static WebElement page;
	
	public  WPIntermediaryPage stopIntermediaryPageFromNavigation() {
		String locator="Trying to halt the Intermediary Page";
		String pass="Successfully Trying to halted the Intermediary Page";
		//String fail="Unable to halt  the Intermediary Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		Log.info(pass);
		reportStep(pass, "PASS");
		for(int i=0;i<20;i++) {
			Utils.sendKeys(page, Keys.ESCAPE);
		}
		return this;
	}
	
}
