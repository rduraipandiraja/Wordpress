package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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

public class WPSearchResultsPage extends TestSetUp{
	Boolean presence;
	public static final Logger log = LogManager.getLogger(WPSearchResultsPage.class);

	//Constructor
	public WPSearchResultsPage(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.debug("Waiting for the Home page");
		reportStep("Waiting for the Home page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lblSearchResults));
			Log.debug("Successfully landed on the Search Results page");
			reportStep("Successfully landed on the Search Results Page ", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("Not able to land on the Search Results page", "FAIL");
			Log.error("Not able to land on the Search Results page");
		} 
	}

	@FindBy(xpath="//h2[contains(text(),'SEARCH RESULTS')]")
	private static WebElement lblSearchResults;

	@FindBy(xpath="(//a[contains(text(),'ACTIVATE CASHBACK')])[1]")
	private static WebElement lnkActivateCashbackInStoreCard;

	//Click on Store card Activate Cashback Link
	public WPSignUpSignInPopUp clickOnStoreCardActivateCashBackLink() {
		try {
			Log.info("Locating Store Card Activate Cashback Link the Search Results page");
			reportStep("Locating Store Card Activate Cashback Link the Search Results page", "PASS");
			Utils.explicitWaitForClick(lnkActivateCashbackInStoreCard);
			Log.info("Successfully clicked Store Card Activate Cashback Link the Search Results page");
			reportStep("Successfully clicked Store Card Activate Cashback Link the Search Results page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Store Card Activate Cashback Link the Search Results page");
			reportStep("Unable to click Store Card Activate Cashback Link the Search Results page", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}

	@FindBy(xpath="//div[@class='voucher_card']/a[contains(text(),' ACTIVATE CASHBACK')]")
	private static WebElement lnkVoucherCardActivateCashback;

	//Click on Voucher Card Activate Cashback Link
	public WPSignUpSignInPopUp clickOnVoucherCardActivateCashBackLink() {
		try {
			Log.info("Locating Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Locating Voucher Card Activate Cashback Link the Search Results page", "PASS");
			Utils.explicitWaitForClick(lnkActivateCashbackInStoreCard);
			Log.info("Successfully clicked Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Successfully clicked Voucher Card Activate Cashback Link the Search Results page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Unable to click Voucher Card Activate Cashback Link the Search Results page", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}

	//Click on Voucher Card Activate Cashback Link
	public WPSearchResultsPage clickOnVoucherCardActivateCashBack() {
		try {
			Log.info("Locating Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Locating Voucher Card Activate Cashback Link the Search Results page", "PASS");
			Utils.explicitWaitForClick(lnkActivateCashbackInStoreCard);
			Log.info("Successfully clicked Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Successfully clicked Voucher Card Activate Cashback Link the Search Results page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Voucher Card Activate Cashback Link the Search Results page");
			reportStep("Unable to click Voucher Card Activate Cashback Link the Search Results page", "FAIL");
		}
		return this;
	}
	@FindBy(xpath="//*[contains(text(),'My Account')]")
	private static WebElement lblMyAccount;
	
	public WPSearchResultsPage clickMyAccountLabel() {
		try {
			reportStep("Verifying My Account Label is present on Home Page or not", "INFO");
			Log.info("Verifying My Account Label is present on Home Page or not");
			Utils.explicitWaitForClick(lblMyAccount);
			reportStep("Clicked Successfully on My Account Label on Home Page", "PASS");
			Log.info("Clicked Successfully on My Account Label on Home Page");
		}catch(Exception e) {
			reportStep("Unable to Click on My Account Label on Home Page", "FAIL");
			Log.error("Unable to Click on My Account Label on Home Page");
		}
		return this;
	}

	@FindBy(xpath="(//a[contains(text(),'VIEW ALL')])[1]")
	private static WebElement lnkViewAllRetailers;

	//Click View All Link in retailers section 
	public WPStoreListingPage clickViewAllLinkRetailer() {
		try {
			Log.info("Locating View All Link the Search Results page");
			reportStep("Locating View All Link in the Search Results page", "PASS");
			Utils.explicitWaitForClick(lnkViewAllRetailers);
			Log.info("Successfully clicked View All Link in the Search Results page");
			reportStep("Successfully clicked View All Link in the Search Results page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click  View All Link in the Search Results page");
			reportStep("Unable to click View All Link in the Search Results page", "FAIL");
		}
		return new WPStoreListingPage(driver, logger);
	}

	@FindBy(xpath="(//a[contains(text(),'VIEW ALL')])[2]")
	private static WebElement lnkViewAllVoucher;

	//Click view all link in Voucher Section
	public WPStoreListingPage clickViewAllLinkVoucher() {
		try {
			Log.info("Locating View All Link For Voucher the Search Results page");
			reportStep("Locating View All Link for Voucher in the Search Results page", "PASS");
			Utils.explicitWaitForClick(lnkViewAllVoucher);
			Log.info("Successfully clicked View All Link For Voucherin the Search Results page");
			reportStep("Successfully clicked View All Link For Voucher in the Search Results page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click  View All Link Voucher in the Search Results page");
			reportStep("Unable to click View All Link  Voucher in the Search Results page", "FAIL");
		}
		return new WPStoreListingPage(driver, logger);
	}
	
	@FindBy(id="idMenuEarnings")
	private static WebElement lnkMyEarning;
	//Click My Earning Link
	public WPMyEarningsPage clickMyEarningLink() {
		try {
			Log.info("Locating My Earnings link on Search Result Page");
			reportStep("Locating My Earnings link on Search Result Page", "INFO");
			Utils.explicitWaitForClick(lnkMyEarning);
			Log.info("Successfully clicked My Earnings link on Search Result Page");
			reportStep("Successfully clicked My Earnings link on  Search Result Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click My Earnings link on  Search Result Page");
			reportStep("Unable to click My Earnings link on  Search Result Page", "FAIL");
		}
		return new WPMyEarningsPage(driver, logger);
	}
	
	@FindBy(id="idMenuMissingCashback")
	private static WebElement lnkMissingCashBack;
	//Click My Earning Link
	public WPMissingTicket clickMissingCashBackLink() {
		try {
			Log.info("Locating Missing Cashback link on Search Result Page");
			reportStep("Locating Missing Cashback link on Search Result Page", "INFO");
			Utils.explicitWaitForClick(lnkMissingCashBack);
			Log.info("Successfully clicked Missing Cashback link on Search Result Page");
			reportStep("Successfully clicked Missing Cashback link on  Search Result Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Missing Cashback link on  Search Result Page");
			reportStep("Unable to click Missing Cashback link on  Search Result Page", "FAIL");
		}
		return new WPMissingTicket(driver, logger);
	}
	@FindBy(name="search_store")
	private static WebElement txtBxSearchStoreOrCoupons;
	
	public WPSearchResultsPage searchForVoucherOrStore(String search) {
		try {
			reportStep("Locating Search Bar in Header Section", "INFO");
			Log.info("Locating Search Bar in Header Section");
			Utils.explicitWaitForClick(txtBxSearchStoreOrCoupons);
			Utils.sendKeysAndPressEnter(txtBxSearchStoreOrCoupons, search);
			reportStep("Successfully entered "+search+"  to be searched: " +search, "PASS");
			Log.info("Successfully entered "+search+" to be searched");
		}catch(Exception e) {
			Log.fatal("Unable to enter "+search+" to be searched in Home Page Search Bar");
			reportStep("Unable to enter "+search+" to be searched in Home Page Search Bar", "FAIL");
		}
		return this;
	}
	
	// To make this dynamic below approach has been used instead of page factory
	public WebElement firstStoreImageInStoreCardOnSearchResult(String storeName) {
		WebElement element = null;
		try {
			String locator="Successfully located First Store Image in Search Result Page";
			System.out.println("(//a[@title='"+storeName +"'])[1]");
			element=driver.findElement(By.xpath("(//a[@title='"+storeName +"'])[1]"));
			Log.info(locator);
			reportStep(locator, "PASS");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public WPStorePage clickOnStoreImage(String storeName) {
		String pass="Successfully clicked on first Store Card Image in Search Result Page to Navigate to Store Page";
		String fail="Unable to click at first Store Card Image in Search Result Page";
		if(Utils.click(firstStoreImageInStoreCardOnSearchResult(storeName))){
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return new WPStorePage(driver, logger);
	}
	
	public WPSearchResultsPage verifyInactiveStoreNotDisplayingInSearchResultPage(String storeName) {
		String locator="Locating Inactive Store in Search Result Page";
		String pass="Inactive Store is displaying in Search Result Page is verified successfully";
		String fail="Inactive Store is displaying in Search Result Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		int size=Utils.getNumberOfElements(driver.findElements(By.xpath("(//a[@title='"+storeName +"'])[1]")));
		if(size>0) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}else {
			Log.info(pass);
			reportStep(pass, "PASS");
		}
		return this;
	}
}
