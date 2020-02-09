package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import utility.TestSetUp;
import utility.Log;
import utility.Utils;

public class WPMyEarningsPage extends TestSetUp{
	Boolean presence;
	String txtTodayDate="Text Of Todays Date is: ";
	public static final Logger log = LogManager.getLogger(WPMyEarningsPage.class);

	//Parameterized Constructor for My Earnings
	public WPMyEarningsPage(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;
		String info="Loading My Earnings Page.";
		String pass="Successfully loaded My Earnings Page.";
		String fail= "Unable to load My Earnings Page. Please see the screenshot below:";
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info(info);
		reportStep(info, "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(tabCashBackEarning));
			Log.info(pass);
			reportStep(pass, "PASS");
		} catch (Exception e) {
			Log.error(fail);
			reportStep(fail, "FAIL");

		} 
	}

	@FindBy(id="idLeftNavPayments")
	private static WebElement lnkLeftNavPayment;
	//Click Payment Link of Left Navigation Panel
	public WPPaymentPage clickPaymentLinkLeftNavigationPanel() {
		try {
			Log.info("Locating Payment Link of Left Navigation Panel");
			reportStep("Locating Payment Link of Left Navigation Panel", "INFO");
			Utils.explicitWaitForClick(lnkLeftNavPayment);
			Log.info("Successfully clicked Payment Link of Left Navigation Panel");
			reportStep("Successfully clicked Payment Link of Left Navigation Panel", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Payment Link of Left Navigation Panel");
			reportStep("Unable to click Payment Link of Left Navigation Panel", "FAIL");
		}
		return new WPPaymentPage(driver, logger);
	}

	@FindBy(id="idMenuEarnings")
	private static WebElement lnkMyEarning;
	//Click My Earning Link
	public WPMyEarningsPage clickMyEarningLink() {
		try {
			Log.info("Locating My Earnings link on My Earning Page");
			reportStep("Locating My Earnings link on My Earning Page", "INFO");
			Utils.explicitWaitForClick(lnkMyEarning);
			Log.info("Successfully clicked My Earnings link on My Earning Page");
			reportStep("Successfully clicked My Earnings link on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click My Earnings link on My Earning Page");
			reportStep("Unable to click My Earnings link on My Earning Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="tabCashbackEarnings")
	private static WebElement tabCashBackEarning;
	//click Tab CashBack Earning
	public WPMyEarningsPage clickTabCashBackEarning() {
		try {
			Log.info("Locating tab CashBack Earning on My Earning Page");
			reportStep("Locating tab CashBack Earning on My Earning Page", "INFO");
			Utils.explicitWaitForClick(lnkMyEarning);
			Log.info("Successfully clicked tab CashBack Earning on My Earning Page");
			reportStep("Successfully clicked tab CashBack Earning on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click tab CashBack Earning on My Earning Page");
			reportStep("Unable to click tab CashBack Earning on My Earning Page", "FAIL");
		}
		return this;
	}


	@FindBy(id="tabRewardEarnings")
	private static WebElement tabRewardEarnings;
	//Click Tab Reward Earnings
	public WPMyEarningsPage clickTabRewardEarnings() {
		try {
			Log.info("Locating Tab Reward Earnings on My Earning Page");
			reportStep("Locating Tab Reward Earnings on My Earning Page", "INFO");
			Utils.explicitWaitForVisibility(tabRewardEarnings);
			Utils.jsClick(tabRewardEarnings, driver);
			Log.info("Successfully clicked Tab Reward Earnings on My Earning Page");
			reportStep("Successfully clicked Tab Reward Earnings on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Tab Reward Earnings on My Earning Page");
			reportStep("Unable to click Tab Reward Earnings on My Earning Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="lnkCashbackRequestFromCashback")
	private static WebElement btnRequestCashbackPayment;

	//verify REQUEST Cashback PAYMENT
	public WPMyEarningsPage verifyRequestCashbackIsEnabled () {
		String started="Locating REQUEST Cashback PAYMENT  button on My Earning Page";
		String pass="REQUEST Cashback PAYMENT  button on My Earning Page is enabled";
		String fail="REQUEST Cashback PAYMENT  button on My Earning Page is not enabled";
		try {				
			Log.info(started);
			reportStep(started, "INFO");
			Utils.verifyElementIsEnabled(btnRequestCashbackPayment);
			Log.info(pass);
			reportStep(pass, "PASS");
		}catch(Exception e) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	//Click REQUEST CASHBACK PAYMENT
	public WPMyEarningsPage clickRequestCashbackPaymentButton () {
		try {
			Log.info("Locating REQUEST CASHBACK PAYMENT  button on My Earning Page");
			reportStep("Locating REQUEST CASHBACK PAYMENT button  on My Earning Page", "INFO");
			Utils.explicitWaitForClick(btnRequestCashbackPayment);
			Log.info("Successfully clicked REQUEST CASHBACK PAYMENT button on My Earning Page");
			reportStep("Successfully clicked REQUEST CASHBACK PAYMENT  button on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click REQUEST CASHBACK PAYMENT  button on My Earning Page");
			reportStep("Unable to click REQUEST CASHBACK PAYMENT button on My Earning Page", "FAIL");
		}
		return this;
	}

	//Click REQUEST CASHBACK PAYMENT
	public WPPaymentPage clickRequestCashbackPaymentButtonToNavigate () {
		try {
			Log.info("Locating REQUEST CASHBACK PAYMENT  button on My Earning Page");
			reportStep("Locating REQUEST CASHBACK PAYMENT button  on My Earning Page", "INFO");
			Utils.explicitWaitForClick(btnRequestCashbackPayment);
			Log.info("Successfully clicked REQUEST CASHBACK PAYMENT button on My Earning Page");
			reportStep("Successfully clicked REQUEST CASHBACK PAYMENT  button on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click REQUEST CASHBACK PAYMENT  button on My Earning Page");
			reportStep("Unable to click REQUEST CASHBACK PAYMENT button on My Earning Page", "FAIL");
		}
		return new WPPaymentPage(driver, logger);
	}

	//Click REQUEST CASHBACK PAYMENT To Navigate To Payment Form
	public WPPaymentPage clickRequestCashbackPaymentButtonToNavigateToPaymentForm () {
		try {
			Log.info("Locating REQUEST CASHBACK PAYMENT  button on My Earning Page");
			reportStep("Locating REQUEST CASHBACK PAYMENT button  on My Earning Page", "INFO");
			Utils.explicitWaitForClick(btnRequestCashbackPayment);
			Log.info("Successfully clicked REQUEST CASHBACK PAYMENT button on My Earning Page");
			reportStep("Successfully clicked REQUEST CASHBACK PAYMENT  button on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click REQUEST CASHBACK PAYMENT  button on My Earning Page");
			reportStep("Unable to click REQUEST CASHBACK PAYMENT button on My Earning Page", "FAIL");
		}
		return new WPPaymentPage(driver, logger);
	}

	@FindBy(id="lnkRewardsRequestFromCashback")
	private static WebElement btnREQUESTREWARDSPAYMENT;
	//Click REQUEST Rewards PAYMENT
	public WPMyEarningsPage clickRequestRewardsPaymentButton () {
		try {
			Log.info("Locating REQUEST REWARDS PAYMENT  button on My Earning Page");
			reportStep("Locating REQUEST REWARDS PAYMENT button  on My Earning Page", "INFO");
			Utils.explicitWaitForClick(btnREQUESTREWARDSPAYMENT);
			Log.info("Successfully clicked REQUEST REWARDS PAYMENT button on My Earning Page");
			reportStep("Successfully clicked REQUEST REWARDS PAYMENT  button on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click REQUEST REWARDS PAYMENT  button on My Earning Page");
			reportStep("Unable to click REQUEST REWARDS PAYMENT button on My Earning Page", "FAIL");
		}
		return this;
	}

	//verify REQUEST Rewards PAYMENT
	public WPMyEarningsPage verifyRequestRewardsIsEnabled () {
		String started="Locating REQUEST REWARDS PAYMENT  button on My Earning Page";
		String pass="REQUEST REWARDS PAYMENT  button on My Earning Page is enabled";
		String fail="REQUEST REWARDS PAYMENT  button on My Earning Page is not enabled";
		try {				
			Log.info(started);
			reportStep(started, "INFO");
			Utils.verifyElementIsEnabled(btnREQUESTREWARDSPAYMENT);
			Log.info(pass);
			reportStep(pass, "PASS");
		}catch(Exception e) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	//
	public WPPaymentPage clickRequestRewardsPaymentButtonToNavigateToPaymentForm() {
		try {
			Log.info("Locating REQUEST REWARDS PAYMENT  button on My Earning Page");
			reportStep("Locating REQUEST REWARDS PAYMENT button  on My Earning Page", "INFO");
			Utils.explicitWaitForClick(btnREQUESTREWARDSPAYMENT);
			Log.info("Successfully clicked REQUEST REWARDS PAYMENT button on My Earning Page");
			reportStep("Successfully clicked REQUEST REWARDS PAYMENT  button on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click REQUEST REWARDS PAYMENT  button on My Earning Page");
			reportStep("Unable to click REQUEST REWARDS PAYMENT button on My Earning Page", "FAIL");
		}
		return new WPPaymentPage(driver, logger);
	}


	@FindBy(id="lnkCashbackEarned")
	private static WebElement lnkTotalCashBackEarnedHeader;
	//Click Total CashBack Earned
	public WPMyEarningsPage clickTotalCashBackEarnedHeaderLink () {
		try {
			Log.info("Locating link Total CashBack Earned at Top on My Earning Page");
			reportStep("Locating link Total CashBack Earned at Top on My Earning Page", "INFO");
			Utils.explicitWaitForClick(lnkTotalCashBackEarnedHeader);
			Log.info("Successfully clicked link Total CashBack Earned at Top on My Earning Page");
			reportStep("Successfully clicked link Total CashBack Earned at Top on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click link Total CashBack Earned at Top on My Earning Page");
			reportStep("Unable to click link Total CashBack Earned at Top on My Earning Page", "FAIL");
		}
		return this;
	}

	public WPMyEarningsPage verifyTotalCashBackEarnedHeaderLinkIsCollapsed () {
		String locator="Locating link Total CashBack Earned at Top on My Earning Page";
		String pass="Total CashBack Earned at Top on My Earning Page is collapsed";
		String failed="Total CashBack Earned at Top on My Earning Page is not collapsed";
		try {
			Log.info(locator);
			reportStep(locator, "INFO");
			if(lnkTotalCashBackEarnedHeader.getAttribute("class").equalsIgnoreCase("fr pos active")) {
				Log.info(pass);
				reportStep(pass, "PASS");
			}
		}catch(Exception e) {
			Log.info(failed);
			reportStep(failed, "FAIL");
		}
		return this;
	}

	public WPMyEarningsPage verifyTotalCashBackEarnedHeaderLinkIsExpanded() {
		String locator="Locating link Total CashBack Earned at Top on My Earning Page";
		String pass="Total CashBack Earned at Top on My Earning Page is Expanded";
		String failed="Total CashBack Earned at Top on My Earning Page is not Expanded";
		try {
			Log.info(locator);
			reportStep(locator, "INFO");
			if(lnkTotalCashBackEarnedHeader.getAttribute("class").equalsIgnoreCase("fr pos")) {
				Log.info(pass);
				reportStep(pass, "PASS");
			}
		}catch(Exception e) {
			Log.info(failed);
			reportStep(failed, "FAIL");
		}
		return this;
	}

	@FindBy(id="lnkRewardsEarned")
	private static WebElement lnkTotalRewardsEarnedHeader;
	//Click Total CashBack Earned
	public WPMyEarningsPage clickTotalRewardsEarnedHeaderLink () {
		try {
			Log.info("Locating link Total Rewards Earned at Top on My Earning Page");
			reportStep("Locating link Total Rewards Earned at Top on My Earning Page", "INFO");
			Utils.explicitWaitForClick(lnkTotalRewardsEarnedHeader);
			Log.info("Successfully clicked link Total Rewards Earned at Top on My Earning Page");
			reportStep("Successfully clicked link Total Rewards Earned at Top on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click link Total Rewards Earned at Top on My Earning Page");
			reportStep("Unable to click link Total Rewards Earned at Top on My Earning Page", "FAIL");
		}
		return this;
	}

	public WPMyEarningsPage verifyTotalRewardsEarnedHeaderLinkIsCollapsed () {
		String locator="Locating link Total Rewards Earned at Top on My Earning Page";
		String pass="Total Rewards Earned at Top on My Earning Page is collapsed";
		String failed="Total Rewards Earned at Top on My Earning Page is not collapsed";
		try {
			Log.info(locator);
			reportStep(locator, "INFO");
			if(lnkTotalCashBackEarnedHeader.getAttribute("class").equalsIgnoreCase("fr pos active")) {
				Log.info(pass);
				reportStep(pass, "PASS");
			}
		}catch(Exception e) {
			Log.info(failed);
			reportStep(failed, "FAIL");
		}
		return this;
	}

	public WPMyEarningsPage verifyTotalRewardsEarnedHeaderLinkIsExpanded() {
		String locator="Locating link Total Rewards Earned at Top on My Earning Page";
		String pass="Total Rewards Earned at Top on My Earning Page is Expanded";
		String failed="Total Rewards Earned at Top on My Earning Page is not Expanded";
		try {
			Log.info(locator);
			reportStep(locator, "INFO");
			if(lnkTotalCashBackEarnedHeader.getAttribute("class").equalsIgnoreCase("fr pos")) {
				Log.info(pass);
				reportStep(pass, "PASS");
			}
		}catch(Exception e) {
			Log.info(failed);
			reportStep(failed, "FAIL");
		}
		return this;
	}

	@FindBy(id="lnkPaymentRequestOptionButton0")
	private static WebElement lnkCombineRewardsPlusCashBack;
	//Click Combine Rewards Plus CashBack Link In Pop Up
	public WPPaymentPage clickCombineRewardsPlusCashBackLink () {
		try {
			Log.info("Locating Combine Rewards Plus CashBack Link In Pop Up on My Earning Page");
			reportStep("Locating Combine Rewards Plus CashBack Link In Pop Up on My Earning Page", "INFO");
			Utils.explicitWaitForClick(lnkCombineRewardsPlusCashBack);
			Log.info("Successfully clicked Combine Rewards Plus CashBack Link In Pop Up on My Earning Page");
			reportStep("Successfully clicked Combine Rewards Plus CashBack Link In Pop Up on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Combine Rewards Plus CashBack Link In Pop Up on My Earning Page");
			reportStep("Unable to click Combine Rewards Plus CashBack Link In Pop Up on My Earning Page", "FAIL");
		}
		return new WPPaymentPage(driver, logger);
	}

	@FindBy(xpath="//a[text()='ONLY REDEEM CASHBACK EARNINGS']")
	private static WebElement lnkOnlyRedeemCashBackEarnings;
	//Click ONLY REDEEM CASHBACK EARNINGS Link In Pop Up
	public WPPaymentPage clickOnlyRedeemCashBackEarningsLink () {
		try {
			Log.info("Locating ONLY REDEEM CASHBACK EARNINGS Link In Pop Up on My Earning Page");
			reportStep("Locating ONLY REDEEM CASHBACK EARNINGS Link In Pop Up on My Earning Page", "INFO");
			Utils.explicitWaitForClick(lnkOnlyRedeemCashBackEarnings);
			Log.info("Successfully clicked ONLY REDEEM CASHBACK EARNINGS Link In Pop Up on My Earning Page");
			reportStep("Successfully clicked ONLY REDEEM CASHBACK EARNINGS Link In Pop Up on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click ONLY REDEEM CASHBACK EARNINGS Link In Pop Up on My Earning Page");
			reportStep("Unable to click ONLY REDEEM CASHBACK EARNINGS Link In Pop Up on My Earning Page", "FAIL");
		}
		return new WPPaymentPage(driver, logger);
	}

	@FindBy(xpath="//a[text()='ONLY REDEEM REWARDS EARNINGS']")
	private static WebElement lnkOnlyRedeemREWARDSEarnings;
	//Click ONLY REDEEM CASHBACK EARNINGS Link In Pop Up
	public WPPaymentPage clickOnlyRedeemRewardsEarningsLink () {
		try {
			Log.info("Locating ONLY REDEEM REWARDS EARNINGS Link In Pop Up on My Earning Page");
			reportStep("Locating ONLY REDEEM REWARDS EARNINGS Link In Pop Up on My Earning Page", "INFO");
			Utils.explicitWaitForClick(lnkOnlyRedeemREWARDSEarnings);
			Log.info("Successfully clicked ONLY REDEEM REWARDS EARNINGS Link In Pop Up on My Earning Page");
			reportStep("Successfully clicked ONLY REDEEM REWARDS EARNINGS Link In Pop Up on My Earning Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click ONLY REDEEM REWARDS EARNINGS Link In Pop Up on My Earning Page");
			reportStep("Unable to click ONLY REDEEM REWARDS EARNINGS Link In Pop Up on My Earning Page", "FAIL");
		}
		return new WPPaymentPage(driver, logger);
	}

	@FindBy(xpath="//p[contains(text(),'Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)?')]")
	private static WebElement paragraphMsgCombineCashBackRewards;
	//Verify presence of message Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cash back & redeem together via Gift Cards or Wallet transfer (not NEFT)?
	public WPMyEarningsPage verifyPresenceMessageToCombineCashBackAndRewards () {
		Log.info("Locating message : Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)? In Pop Up on My Earning Page");
		reportStep("Locating message : Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)? In Pop Up on My Earning Page", "INFO");
		presence=Utils.verifyElementPresence(paragraphMsgCombineCashBackRewards);
		if(presence) {
			Log.info("Successfully verified presence of message : Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)? In Pop Up on My Earning Page");
			reportStep("Successfully verified presence of message : Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)? In Pop Up on My Earning Page", "PASS");
		}else {
			Log.info("Unable to verify presence of message : Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)?  In Pop Up on My Earning Page");
			reportStep("Unable to verify presence of message : Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)?  In Pop Up on My Earning Page", "FAIL");
		}

		return this;
	}
	
	@FindBy(xpath="//p[contains(text(),'Thanks. You also have ₹500.00 Cashback earnings ready to be withdrawn. Would you like to combine them with these Rewards & redeem together via Gift Cards or Wallet transfer (not NEFT)?')]")
	private static WebElement paragraphMsgCombineCashBackPlusRewards;
	//Verify presence of message Thanks. You also have ₹500.00 Cashback earnings ready to be withdrawn. Would you like to combine them with these Rewards & redeem together via Gift Cards or Wallet transfer (not NEFT)?
	public WPMyEarningsPage verifyPresenceMessageToCombineCashBackPlusRewards () {
		Log.info("Locating message : Thanks. You also have ₹500.00 Cashback earnings ready to be withdrawn. Would you like to combine them with these Rewards & redeem together via Gift Cards or Wallet transfer (not NEFT)? In Pop Up on My Earning Page");
		reportStep("Locating message : Thanks. You also have ₹500.00 Cashback earnings ready to be withdrawn. Would you like to combine them with these Rewards & redeem together via Gift Cards or Wallet transfer (not NEFT)? In Pop Up on My Earning Page", "INFO");
		presence=Utils.verifyElementPresence(paragraphMsgCombineCashBackPlusRewards);
		if(presence) {
			Log.info("Successfully verified presence of message : Thanks. You also have ₹500.00 Cashback earnings ready to be withdrawn. Would you like to combine them with these Rewards & redeem together via Gift Cards or Wallet transfer (not NEFT)? In Pop Up on My Earning Page");
			reportStep("Successfully verified presence of message : Thanks. You also have ₹500.00 Cashback earnings ready to be withdrawn. Would you like to combine them with these Rewards & redeem together via Gift Cards or Wallet transfer (not NEFT)? In Pop Up on My Earning Page", "PASS");
		}else {
			Log.info("Unable to verify presence of message : Thanks. You also have ₹500.00 Cashback earnings ready to be withdrawn. Would you like to combine them with these Rewards & redeem together via Gift Cards or Wallet transfer (not NEFT)?  In Pop Up on My Earning Page");
			reportStep("Unable to verify presence of message : Thanks. You also have ₹500.00 Cashback earnings ready to be withdrawn. Would you like to combine them with these Rewards & redeem together via Gift Cards or Wallet transfer (not NEFT)?  In Pop Up on My Earning Page", "FAIL");
		}

		return this;
	}

	@FindBy(xpath="//h2[contains(text(),'PAYMENT THRESHOLD NOT REACHED')]")
	private static WebElement paragraphMsgThresholdNotReached;

	//Verify presence of message PAYMENT THRESHOLD NOT REACHED
	public WPMyEarningsPage verifyPresenceMessageThresholdNotReached () {
		Log.info("Locating message : \"PAYMENT THRESHOLD NOT REACHED\" In Pop Up on My Earning Page");
		reportStep("Locating message : \"PAYMENT THRESHOLD NOT REACHED\" In Pop Up on My Earning Page", "INFO");
		presence=Utils.verifyElementPresence(paragraphMsgThresholdNotReached);
		if(presence) {
			Log.info("Successfully verified presence of message : \"PAYMENT THRESHOLD NOT REACHED\" In Pop Up on My Earning Page");
			reportStep("Successfully verified presence of message : \"PAYMENT THRESHOLD NOT REACHED\" In Pop Up on My Earning Page", "PASS");
		}else {
			Log.info("Unable to verify presence of message : \"PAYMENT THRESHOLD NOT REACHED\" In Pop Up on My Earning Page");
			reportStep("Unable to verify presence of message : \"PAYMENT THRESHOLD NOT REACHED\" In Pop Up on My Earning Page", "FAIL");
		}

		return this;
	}

	@FindBy(xpath="//p[contains(text(),'Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.')]")
	private static WebElement paragraphMsgUnableToProcessRequest;

	//Verify presence of message--Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.
	public WPMyEarningsPage verifyPresenceMessageUnableToProcessRequest() {
		Log.info("Locating message : \"Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.\" In Pop Up on My Earning Page");
		reportStep("Locating message : \"Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.\" In Pop Up on My Earning Page", "INFO");
		presence=Utils.verifyElementPresence(paragraphMsgUnableToProcessRequest);
		if(presence) {
			Log.info("Successfully verified presence of message : \"Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.\" In Pop Up on My Earning Page");
			reportStep("Successfully verified presence of message : \"Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.\" In Pop Up on My Earning Page", "PASS");
		}else {
			Log.info("Unable to verify presence of message : \"Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.\" In Pop Up on My Earning Page");
			reportStep("Unable to verify presence of message : \"Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.\" In Pop Up on My Earning Page", "FAIL");
		}

		return this;
	}




	//Add Cashback to Account
	public WPMyEarningsPage addCashbackRewards(String amount, String email, String cashBackType) {
		Log.info("Adding "+cashBackType+" CashBack to user account");
		reportStep("Adding "+cashBackType+" CashBack to user account", "INFO");
		Utils.addCashbackRewards(driver, amount, email, cashBackType);
		Log.info("Successfully Added " +amount+ " CashBack of type "+cashBackType+" to user account");
		reportStep("Successfully Added " +amount+ " CashBack of type "+cashBackType+" to user account", "PASS");
		return this;
	}

	@FindBy(xpath = "//li[contains(text(),'Paid Cashback')]")
	private static WebElement lblPaidCashBack;
	//verify presence of Paid Cash back
	public WPMyEarningsPage verifyPresenceOfPaidCashbackHeaderSection() {
		String locator="Locating \"Paid Cash back\" in labels of header section";
		String pass="Successfully verified presence of \"Paid Cashback\" in header section";
		String fail="Unable to verify presence of \"Paid Cash back\" in Header Section";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblPaidCashBack);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//li[contains(text(),'Paid Rewards')]")
	private static WebElement lblPaidRewards;
	//verify presence of Paid Rewards
	public WPMyEarningsPage verifyPresenceOfPaidRewardsHeaderSection() {
		String locator="Locating \"Paid Rewards\" in labels of header section";
		String pass="Successfully verified presence of \"Paid Rewards\" in header section";
		String fail="Unable to verify presence of \"Paid Rewards\" in Header Section";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblPaidRewards);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//li[contains(text(),'Pending Cashback')]")
	private static WebElement lblPendingCashback;
	//verify presence of Pending Cash back
	public WPMyEarningsPage verifyPresenceOfPendingCashbackHeaderSection() {
		String locator="Locating \"Pending Cashback\" in labels of header section";
		String pass="Successfully verified presence of \"Pending Cashback\" in header section";
		String fail="Unable to verify presence of \"Pending Cashback\" in Header Section";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblPendingCashback);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//li[contains(text(),'Pending Rewards')]")
	private static WebElement lblPendingRewards;
	//verify presence of Pending Rewards
	public WPMyEarningsPage verifyPresenceOfPendingRewardsHeaderSection() {
		String locator="Locating \"Pending Rewards\" in labels of header section";
		String pass="Successfully verified presence of \"Pending Rewards\" in header section";
		String fail="Unable to verify presence of \"Pending Rewards\" in Header Section";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblPendingRewards);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "(//li[contains(text(),'Available for Payment')])[1]")
	private static WebElement lblAvailableCashback;
	//verify presence of Available for Payment Rewards Cash back
	public WPMyEarningsPage verifyPresenceOfAvailableForPaymentCashbackHeaderSection() {
		String locator="Locating \"Available for Payment Cashback\" in labels of header section";
		String pass="Successfully verified presence of \"Available for Payment Cashback\" in header section";
		String fail="Unable to verify presence of \"Available for Payment Cashback \" in Header Section";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblAvailableCashback);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "(//li[contains(text(),'Available for Payment')])[2]")
	private static WebElement lblAvailableRewards;
	//verify presence of Available for Payment Rewards
	public WPMyEarningsPage verifyPresenceOfAvailableForPaymentRewardsHeaderSection() {
		String locator="Locating \"Available for Payment Rewards\" in labels of header section";
		String pass="Successfully verified presence of \"Available for Payment Rewards\" in header section";
		String fail="Unable to verify presence of \"Available for Payment Rewards \" in Header Section";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblAvailableRewards);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//p[contains(text(),'Your Total Cashback Earnings')]")
	private static WebElement lblCashbackEarnings;
	//verify presence of Your Total Cashback Earnings
	public WPMyEarningsPage verifyPresenceOfTotalCashbackEarnings() {
		String locator="Locating \"Your Total Cashback Earnings\" in labels of header section";
		String pass="Successfully verified presence of \"Your Total Cashback Earnings\" in header section";
		String fail="Unable to verify presence of \"Your Total Cashback Earnings\" in Header Section";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblCashbackEarnings);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//p[contains(text(),'Your Total Reward Earnings')]")
	private static WebElement lblRewardsEarnings;
	//verify presence of Your Total Reward Earnings
	public WPMyEarningsPage verifyPresenceOfTotalRewardEarnings() {
		String locator="Locating \"Your Total Reward Earnings\" in labels of header section";
		String pass="Successfully verified presence of \"Your Total Reward Earnings\" in header section";
		String fail="Unable to verify presence of \"Your Total Reward Earnings\" in Header Section";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblRewardsEarnings);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//p[contains(text(),'Missing Rewards?')]")
	private static WebElement lblMissingRewards;
	//verify presence of Missing Rewards? 
	public WPMyEarningsPage verifyPresenceOfMissingRewardsLabel() {
		String locator="Locating \"Missing Rewards? \" in labels of header section";
		String pass="Successfully verified presence of \"Missing Rewards? \" in header section";
		String fail="Unable to verify presence of \"Missing Rewards? \" in Header Section";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblMissingRewards);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//p[contains(text(),'Missing Cashback?')]")
	private static WebElement lblMissingCashback;
	//verify presence of Missing Cash back?  
	public WPMyEarningsPage verifyPresenceOfMissingCashbackLabel() {
		String locator="Locating \"Missing Cashback? \" labels ";
		String pass="Successfully verified presence of \"Missing Cashback? \"";
		String fail="Unable to verify presence of \"Missing Cashback? \"";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblMissingCashback);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id = "idRewardShowMore")
	private static WebElement lnkRewardShowMore;
	//verify presence of Reward Show More Link under Rewards Tab
	public WPMyEarningsPage verifyPresenceOfRewardShowMoreLink() {
		String locator="Locating \"Show More Rewards\" Link ";
		String pass="Successfully verified presence of \"Show More Rewards\" Link ";
		String fail="Unable to verify presence of \"Show More Rewards\" Link ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lnkRewardShowMore);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	//Click Reward Show More Link under Rewards Tab
	public WPMyEarningsPage clickRewardsShowMoreLink() {
		String locator="Locating \"Show More Rewards\" Link ";
		String pass="Successfully clicked \"Show More Rewards\" Link ";
		String fail="Unable to click \"Show More Rewards\" Link ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.click(lnkRewardShowMore);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id = "idCashbackShowMore")
	private static WebElement idCashbackShowMore;
	//verify presence of Show More Link under Cashback Tab
	public WPMyEarningsPage verifyPresenceOfCashbackShowMoreLink() {
		String locator="Locating \"Show More Cashback\" Link ";
		String pass="Successfully verified presence of \"Show More Cashback\" Link ";
		String fail="Unable to verify presence of \"Show More Cashback\" Link ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(idCashbackShowMore);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	//Click Reward Show More Link under Cashback Tab
	public WPMyEarningsPage clickCashbackShowMoreLink() {
		String locator="Locating \"Show More Cashback\" Link ";
		String pass="Successfully clicked \"Show More Cashback\" Link ";
		String fail="Unable to click \"Show More Cashback\" Link ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.click(idCashbackShowMore);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//div[@id='idCashbackEarnings']/ul")
	private static List<WebElement> rowCashBackEarnings;
	//Count Number of rows under Table Cash back earnings Tab
	public WPMyEarningsPage verifyNumberOfRowsIsGreaterAfterClickingShowMoreLinkUnderCashBackEarningTab() {
		String locator="Locating \"Number of Rows \" under Cashback Earnings Tab";
		Log.info(locator);
		reportStep(locator, "INFO");
		int initial=rowCashBackEarnings.size();
		clickCashbackShowMoreLink();
		int after=rowCashBackEarnings.size();
		String pass="PASS: Number of Rows initially was: " +initial+ " and after clicking Show More Link, count of rows under Cashback Earnings Tab is: " +after;
		String fail="FAIL: Number of Rows initially was: " +initial+ " and after clicking Show More Link, count of rows under Cashback Earnings Tab is: " +after;
		boolean compare=Utils.compareCountOfList(initial,after);
		if(compare) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//div[@id='idRewardEarnings']/ul")
	private static List<WebElement> rowRewardsEarnings;
	//Count Number of rows under Table Rewards Earnings Tab
	public WPMyEarningsPage verifyNumberOfRowsIsGreaterAfterClickingShowMoreLinkUnderRewardsEarningTab() {
		String locator="Locating \"Number of Rows \" under Rewards Earnings Tab";	
		Log.info(locator);
		reportStep(locator, "INFO");
		int initial=rowRewardsEarnings.size();
		clickRewardsShowMoreLink();
		int  after=rowRewardsEarnings.size();
		String pass="PASS: Number of Rows initially was: " +initial+ " and after clicking Show More Link, count of rows under Rewards Earnings Tab is: " +after;
		boolean compare=Utils.compareCountOfList(initial,after);
		if(compare) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			String fail="FAIL: Number of Rows initially was: " +initial+ " and after clicking Show More Link, count of rows under Rewards Earnings Tab is: " +after;
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="idShowCashbackEarnings")
	private static WebElement ddlMonthYear;
	//This method will validate default selected month and Year in Month drop down
	public WPMyEarningsPage verifyFirstSelectedValueInMonthYearDropDownList() {
		String locator="Locating month and year drop down list under My Earning Left Nav";
		String pass="Successfully Located Month Year Drop Down List under My Earning Left Nav. Default Selected value is : ";
		String fail="Unable to Locate Month Year Drop Down List under My Earning Left Nav";
		String currentMonthYear=Utils.getCurrentMonthAndYear();
		Log.info(locator);
		reportStep(locator, "INFO");
		Select select=new Select(ddlMonthYear);
		String actual=select.getFirstSelectedOption().getText().toString();
		reportStep("First Selected Value in drop down is : " +actual , "INFO");
		if(currentMonthYear.equals(actual)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}

	@FindBy(id="lnkRaiseTicketCashback")
	private static WebElement lnkRaiseTicket;
	//Click RAISE TICKET Link on my My Earnings Page
	public WPAddTicketForm clickRaiseTicketLink() {
		String locator="Locating \"RAISE TICKET\" Link ";
		String pass="Successfully clicked \"RAISE TICKET\" Link ";
		String fail="Unable to click \"RAISE TICKET\" Link ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.click(lnkRaiseTicket);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return new WPAddTicketForm(driver, logger);
	}
	
	@FindBy(xpath="(//div[@id='idCashbackEarnings']/ul[2]//li/strong)[1]")
	private static WebElement lblDayMonthYearCashBack;
	//This method will verify todays date in CashBack Tab
	public WPMyEarningsPage verifyTextOfFirstRowDateInMyEarningCashBackType() {
		String locator="Locating Day, month and year Label in First Row under My Earning Cash Back Earnings";
		String pass="Successfully verified Text Of Day, month and year Label in First Row under My Earning Cash Back Earnings. It is : ";
		String fail="Unable to Locate Day, month and year Label in First Row under My Earning Cash Back Earnings";
		String todaysDate=Utils.todaysDateDdMmmYyyy();
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblDayMonthYearCashBack.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(todaysDate.equals(actual)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idRewardEarnings']/ul[2]//li/strong)[1]")
	private static WebElement lblDayMonthYearRewards;
	//This method will verify todays date in Rewards Tab
	public WPMyEarningsPage verifyTextOfFirstRowDateInMyEarningRewardsType() {
		String locator="Locating Day, month and year Label in First Row under My Earning Rewards Earnings";
		String pass="Successfully verified Text Of Day, month and year Label in First Row under My Earning Rewards Earnings. It is : ";
		String fail="Unable to Locate Day, month and year Label in First Row under My Earning Rewards Earnings";
		String todaysDate=Utils.todaysDateDdMmmYyyy();
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblDayMonthYearRewards.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(todaysDate.equals(actual)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idCashbackEarnings']/ul[2]//li/strong)[4]")
	private static WebElement lblCashBackAmountFirstRow;
	
	public WPMyEarningsPage verifyTextOfFirstRowCashBackAmountInMyEarningCashBackType() {
		String locator="Locating Cashback Amount in First Row under My Earning Cash Back Earnings";
		String pass="Successfully verified Text Of Cashback Amount Label in First Row under My Earning Cash Back Earnings. It is : ";
		String fail="Unable to Locate Cashback Amount Label in First Row under My Earning Cash Back Earnings";
		String cashBackAmount=Utils.getTestData(6,"thresholdAmount");
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblCashBackAmountFirstRow.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.contains(cashBackAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(id="lblPendingCashbackAmt")
	private static WebElement lblPendingCashBackAmountTop;
	
	public WPMyEarningsPage verifyTextOfPendingCashBackAmountAtTopInMyEarning() {
		String locator="Locating Pending Cashback Amount at Top under My Earning Cash Back Earnings";
		String pass="Successfully verified Text Of Pending Cashback Amount at Top under My Earning Cash Back Earnings. It is : ";
		String fail="Unable to Locate Pending Cashback Amount at Top under My Earning Cash Back Earnings. It is : ";
		String cashBackAmount=Utils.getTestData(6,"thresholdAmount");
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblPendingCashBackAmountTop.getText().toString();
		if(actual.contains(cashBackAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail+actual);
			reportStep(fail+actual, "PASS");
		}
		return this;
	}
	@FindBy(id="lblPendingRewardsAmt")
	private static WebElement lblPendingRewardsAmountTop;
	
	public WPMyEarningsPage verifyTextOfPendingRewardsAmountAtTopInMyEarning() {
		String locator="Locating Pending Rewards Amount at Top under My Earning Rewards Earnings";
		String pass="Successfully verified Text Of Pending Rewards Amount at Top under My Earning RewardsEarnings. It is : ";
		String fail="Unable to Locate Pending Rewards Amount at Top under My Earning Rewards Earnings. It is : ";
		String cashBackAmount=Utils.getTestData(6,"thresholdAmount");
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblPendingRewardsAmountTop.getText().toString();
		if(actual.contains(cashBackAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail+actual);
			reportStep(fail+actual, "PASS");
		}
		return this;
	}
	
	@FindBy(id="lblAvailableCashback")
	private static WebElement lblAvailableCashBackAmountTop;
	
	public WPMyEarningsPage verifyTextOfAvailableCashBackAmountAtTopInMyEarning() {
		String locator="Locating Available Cashback Amount at Top under My Earning Cash Back Earnings";
		String pass="Successfully verified Text Of Available Cashback Amount at Top under My Earning Cash Back Earnings. It is : ";
		String fail="Unable to Locate Available Cashback Amount at Top under My Earning Cash Back Earnings It is : ";
		String cashBackAmount=Utils.extractOnlyNumber(Utils.getTestData(6,"thresholdAmount"));
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblAvailableCashBackAmountTop.getText().toString();
		actual=Utils.extractOnlyNumber(actual);
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.equals(cashBackAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail+actual);
			reportStep(fail+actual, "PASS");
		}
		return this;
	}
	
	@FindBy(id="lblAvailableRewardsAmt")
	private static WebElement lblAvailableRewardsAmountTop;
	
	public WPMyEarningsPage verifyTextOfAvailableRewardsAmountAtTopInMyEarning() {
		String locator="Locating Available Rewards Amount at Top under My Earning Cash Back Earnings";
		String pass="Successfully verified Text Of Available Rewards Amount at Top under My Earning Cash Back Earnings. It is : ";
		String fail="Unable to Locate Available Rewards Amount at Top under My Earning Cash Back Earnings It is : ";
		String cashBackAmount=Utils.extractOnlyNumber(Utils.getTestData(6,"thresholdAmount"));
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblAvailableRewardsAmountTop.getText().toString();
		actual=Utils.extractOnlyNumber(actual);
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.equals(cashBackAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail+actual);
			reportStep(fail+actual, "PASS");
		}
		return this;
	}
	
	@FindBy(id="lblCashbackEarningsAmt")
	private static WebElement lblYourTotalCashBackEarningsAmount;
	
	public WPMyEarningsPage verifyTextOfYourTotalCashBackEarningsAmountInMyEarning() {
		String locator="Locating Your Total CashBack Earnings \"Amount\" under My Earning Cash Back Earnings";
		String pass="Successfully verified Text OfYour Total CashBack Earnings \"Amount\" under My Earning Cash Back Earnings. It is : ";
		String fail="Unable to Locate Your Total CashBack Earnings \"Amount\" under My Earning Cash Back Earnings It is : ";
		String cashBackAmount=Utils.extractOnlyNumber(Utils.getTestData(6,"thresholdAmount"));
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblYourTotalCashBackEarningsAmount.getText().toString();
		actual=Utils.extractOnlyNumber(actual);
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.equals(cashBackAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail+actual);
			reportStep(fail+actual, "PASS");
		}
		return this;
	}
	
	@FindBy(id="lblRewardsEarningsAmt")
	private static WebElement lblYourTotalRewardsEarningsAmount;
	
	public WPMyEarningsPage verifyTextOfYourTotalRewardsEarningsAmountInMyEarning() {
		String locator="Locating Your Total Rewards Earnings \"Amount\" under My Earning Cash Back Earnings";
		String pass="Successfully verified Text OfYour Total Rewards Earnings \"Amount\" under My Earning Cash Back Earnings. It is : ";
		String fail="Unable to Locate Your Total Rewards Earnings \"Amount\" under My Earning Cash Back Earnings It is : ";
		String cashBackAmount=Utils.extractOnlyNumber(Utils.getTestData(6,"thresholdAmount"));
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblYourTotalRewardsEarningsAmount.getText().toString();
		actual=Utils.extractOnlyNumber(actual);
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.equals(cashBackAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail+actual);
			reportStep(fail+actual, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idRewardEarnings']/ul[2]//li/strong)[4]")
	private static WebElement lblRewardsAmountFirstRow;
	
	public WPMyEarningsPage verifyTextOfFirstRowRewardsAmountInMyEarningRewardsType() {
		String locator="Locating Rewards Amount in First Row under My Earning Rewards Earnings";
		String pass="Successfully verified Text Of Rewards Amount Label in First Row under My Earning Rewards Earnings. It is : ";
		String fail="Unable to Locate Rewards Amount Label in First Row under My Earning Rewards Earnings";
		String rewardsAmount=Utils.getTestData(6,"thresholdAmount");
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblRewardsAmountFirstRow.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.contains(rewardsAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idCashbackEarnings']/ul[2]//li/strong)[2]")
	private static WebElement lblRetailerNameFirstRowCashBack;
	
	public WPMyEarningsPage verifyTextOfFirstRowRetailerNameInMyEarningCashBackType() {
		String locator="Locating Retailer Name in First Row under My Earning Cash Back Earnings";
		String pass="Successfully verified Text Of Retailer Name Label in First Row under My Earning Cash Back Earnings. It is : ";
		String fail="Unable to Locate Retailer Name Label in First Row under My Earning Cash Back Earnings";
		String rewardsAmount=Utils.getTestData(6,"retailerName");
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblRetailerNameFirstRowCashBack.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.contains(rewardsAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idRewardEarnings']/ul[2]//li/strong)[2]")
	private static WebElement lblRetailerNameFirstRowRewards;
	
	public WPMyEarningsPage verifyTextOfFirstRowRetailerNameInMyEarningRewardsType() {
		String locator="Locating Retailer Name in First Row under My Earning Rewards Earnings";
		String pass="Successfully verified Text Of Retailer Name Label in First Row under My Earning Rewards Earnings. It is : ";
		String fail="Unable to Locate Retailer Name Label in First Row under My Earning Rewards Earnings";
		String rewardsAmount=Utils.getTestData(6,"retailerName");
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblRetailerNameFirstRowRewards.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.contains(rewardsAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idCashbackEarnings']/ul[2]//li/strong)[3]")
	private static WebElement lblOrderIdFirstRowCashBack;
	
	public WPMyEarningsPage verifyTextOfFirstRowOrderIdInMyEarningCashBackType(String orderId) {
		String locator="Locating Order Id in First Row under My Earning Cash Back Earnings";
		String pass="Successfully verified Text Of Order Id Label in First Row under My Earning Cash Back Earnings. It is : ";
		String fail="Unable to Locate Order Id Label in First Row under My Earning Cash Back Earnings";
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblOrderIdFirstRowCashBack.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.equals(orderId)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idRewardEarnings']/ul[2]//li/strong)[3]")
	private static WebElement lblOrderIdFirstRowRewards;
	
	public WPMyEarningsPage verifyTextOfFirstRowOrderIdInMyEarningRewardsType(String orderId) {
		String locator="Locating Order Id in First Row under My Earning Rewards Earnings";
		String pass="Successfully verified Text Of Order Id Label in First Row under My Earning Rewards Earnings. It is : ";
		String fail="Unable to Locate Order Id Label in First Row under My Earning Rewards Earnings";
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblOrderIdFirstRowRewards.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.equals(orderId)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idRewardEarnings']/ul[2]//li/strong)[4]")
	private static WebElement lblOrderAmountFirstRowRewards;
	
	public WPMyEarningsPage verifyTextOfFirstRowOrderAmountInMyEarningRewardsType() {
		String locator="Locating Order Amount in First Row under My Earning Rewards Earnings";
		String pass="Successfully verified Text Of Order Amount Label in First Row under My Earning Rewards Earnings. It is : ";
		String fail="Unable to Locate Order Amount Label in First Row under My Earning Rewards Earnings";
		Log.info(locator);
		reportStep(locator, "INFO");
		String orderAmount=Utils.getTestData(6, "orderAmount");
		String actual=lblOrderIdFirstRowRewards.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.contains(orderAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idCashbackEarnings']/ul[2]//li/strong)[4]")
	private static WebElement lblOrderAmountFirstRowCashBack;
	
	public WPMyEarningsPage verifyTextOfFirstRowOrderAmountInMyEarningCashBackType() {
		String locator="Locating Order Amount in First Row under My Earning CashBack Earnings";
		String pass="Successfully verified Text Of Order Amount Label in First Row under My Earning CashBack Earnings. It is : ";
		String fail="Unable to Locate Order Amount Label in First Row under My Earning CashBack Earnings";
		Log.info(locator);
		reportStep(locator, "INFO");
		String orderAmount=Utils.getTestData(6, "orderAmount");
		String actual=lblOrderAmountFirstRowCashBack.getText().toString();
		actual=Utils.extractOnlyNumber(actual);
		reportStep(txtTodayDate +actual , "INFO");
		if(actual.contains(orderAmount)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="//strong[contains(text(),'Pending')]")
	private static WebElement lblPendingStatus;
	
	public WPMyEarningsPage verifyPresenceOfPendingStatusLabel() {
		String locator="Locating \"Pending Status\" Label ";
		String pass="Successfully verified presence of \"Pending Status\" Label ";
		String fail="Unable to verify presence of \"Pending Status\" Label ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblPendingStatus);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//strong[contains(text(),'Confirmed')]")
	private static WebElement lblConfirmedStatus;
	
	public WPMyEarningsPage verifyPresenceOfConfirmedStatusLabel() {
		String locator="Locating \"Confirmed Status\" Label ";
		String pass="Successfully verified presence of \"Confirmed Status\" Label ";
		String fail="Unable to verify presence of \"Confirmed Status\" Label ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblConfirmedStatus);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//strong[contains(text(),'Cancelled')]")
	private static WebElement lblCancelledStatus;
	
	public WPMyEarningsPage verifyPresenceOfCancelledStatusLabel() {
		String locator="Locating \"Cancelled Status\" Label ";
		String pass="Successfully verified presence of \"Cancelled Status\" Label ";
		String fail="Unable to verify presence of \"Cancelled Status\" Label ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblCancelledStatus);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//strong[contains(text(),'Requested')]")
	private static WebElement lblRequestedStatus;
	
	public WPMyEarningsPage verifyPresenceOfRequestedStatusLabel() {
		String locator="Locating \"Requested Status\" Label ";
		String pass="Successfully verified presence of \"Requested Status\" Label ";
		String fail="Unable to verify presence of \"Requested Status\" Label ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblRequestedStatus);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//strong[contains(text(),'Paid')]")
	private static WebElement lblPaidStatus;
	
	public WPMyEarningsPage verifyPresenceOfPaidStatusLabel() {
		String locator="Locating \"Paid Status\" Label ";
		String pass="Successfully verified presence of \"Paid Status\" Label ";
		String fail="Unable to verify presence of \"Paid Status\" Label ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblPaidStatus);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idCashbackEarnings']/ul[2]//li/strong)[7]")
	private static WebElement lblDayMonthYearCashBackExpected;
	//This method will verify todays date in CashBack Tab
	public WPMyEarningsPage verifyTextOfFirstRowDateInMyEarningExpectedCashBackType() {
		String locator="Locating Day, month and year Label in Expected date Row under My Earning Cash Back Earnings";
		String pass="Successfully verified Text Of Day, month and year Label in Expected date Row under My Earning Cash Back Earnings. It is : ";
		String fail="Unable to Locate Day, month and year Label in Expected date Row under My Earning Cash Back Earnings";
		String todaysDate=Utils.todaysDateDdMmmYyyy();
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblDayMonthYearCashBackExpected.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(todaysDate.equals(actual)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='idRewardEarnings']/ul[2]//li/strong)[7]")
	private static WebElement lblDayMonthYearRewardsExpected;
	//This method will verify todays date in Rewards Tab
	public WPMyEarningsPage verifyTextOfFirstRowDateInMyEarningExpectedRewardsType() {
		String locator="Locating Day, month and year Label in Expected date Row under My Earning Rewards Earnings";
		String pass="Successfully verified Text Of Day, month and year Label in Expected date Row under My Earning Rewards Earnings. It is : ";
		String fail="Unable to Locate Day, month and year Label in Expected date Row under My Earning Rewards Earnings";
		String todaysDate=Utils.todaysDateDdMmmYyyy();
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblDayMonthYearRewardsExpected.getText().toString();
		reportStep(txtTodayDate +actual , "INFO");
		if(todaysDate.equals(actual)) {
			Log.info(pass+actual);
			reportStep(pass+actual, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "PASS");
		}
		return this;
	}
}
