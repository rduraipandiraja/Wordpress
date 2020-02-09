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

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class WPPaymentForm extends TestSetUp{
	public static final Logger log = LogManager.getLogger(WPPaymentForm.class);
	public WPPaymentForm(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;
		String info="Loading payment Form";
		String pass="Successfully loaded Payment Form";
		String fail="Unable to Load Payment Form";
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info(info);
		reportStep(info, "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(ddlChoosePaymentMethod));
			Log.info(pass);
			reportStep(pass, "PASS");
		} catch (Exception e) {
			reportStep(fail, "FAIL");
			Log.error(fail);
		} 
	}
	

	
	@FindBy(id="bacs_bank_select")
	private static WebElement ddlChoosePaymentMethod; // ddl stands for drop down list
	//Click ONLY REDEEM CASHBACK EARNINGS Link In Pop Up
	public WPPaymentForm selectPaymentMethod (String paymentMethod) {
		try {
			Log.info("Locating Payment Method on Payment Page");
			reportStep("Locating Payment Method on Payment Page", "INFO");
			Select select= new Select(ddlChoosePaymentMethod);
			select.selectByVisibleText(paymentMethod);
			Log.info("Successfully selected " +paymentMethod+ " on Payment Page");
			reportStep("Successfully selected " +paymentMethod+ " on Payment Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to select " +paymentMethod+ " on Payment Page");
			reportStep("Unable to select " +paymentMethod+ " on Payment Page", "FAIL");
		}
		return this;
	}

	public WPPaymentForm verifyDefaultSelectedPaymentMethod (String defaultSelected) {
		Log.info("Locating Payment Method on Payment Page");
		reportStep("Locating Payment Method on Payment Page", "INFO");
		Select select= new Select(ddlChoosePaymentMethod);
		if(select.getFirstSelectedOption().getText().equals(defaultSelected)) {	
		//if(select.getFirstSelectedOption().getText().equals("Bank Payment (NEFT)")) {	
			Log.info("\"Bank Payment (NEFT) \" was selected by default on Payment Form");
			reportStep("\"Bank Payment (NEFT) \" was selected by default on Payment Form", "PASS");
		}else {
			Log.info("\"Bank Payment (NEFT) \" was not selected by default on Payment Form");
			reportStep("\"Bank Payment (NEFT) \" was not selected by default on Payment Form", "FAIL");
		}
		return this;
	}

	public WPPaymentForm verifyAllPaymentOptionsAreAvailable (String paymentOptions) {
		String locator="Locating Payment Method on Payment Page";
		String pass="PASS: Expected and Actual values are as follows respectively: ";
		String fail="FAIL: Expected and Actual values are as follows respectively: ";
		String[] paymentoption=Utils.splitBasedOnComma(paymentOptions);
		Log.info(locator);
		reportStep(locator, "INFO");
		Select select= new Select(ddlChoosePaymentMethod);
		List<WebElement> list=select.getOptions();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().toString().equals(paymentoption[i])) {
				Log.info(pass + paymentoption[i]+" & " +list.get(i).getText().toString());
				reportStep(pass + paymentoption[i]+" & " +list.get(i).getText().toString(),"PASS");
			}else {
				Log.info(fail + paymentoption[i]+" & " +list.get(i).getText().toString());
				reportStep(fail + paymentoption[i]+" & " +list.get(i).getText().toString(),"FAIL");
			}
		}
		return this;
	}

	public WPPaymentForm verifyChoosePaymentMethodIsVisible () {
		String locator="Locating Payment Method on Payment Page";
		String pass="Successfully verified presence of Choose Payment Drop Down on Payment Page";
		String fail="Unable to verify presence of Choose Payment Drop Down on Payment Page";
		try {				
			Log.info(locator);
			reportStep(locator, "INFO");
			Utils.verifyElementPresence(ddlChoosePaymentMethod);
			Log.info(pass);
			reportStep(pass, "PASS");
		}catch(Exception e) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//input[contains(@id,'acc_name')]")
	private static WebElement txtBxNameOfAccountHolder;
	//Enter Name of Account Holder in Text Box on Payment Page
	public WPPaymentForm enterNameOfAccountHolder (String name) {
		Log.info("Locating Name of Account Holder Text Box on Payment Page");
		reportStep("Locating Name of Account Holder Text Box on Payment Page", "INFO");
		if(Utils.sendKeys(txtBxNameOfAccountHolder, name)) {
			Log.info("Successfully entered "+name+" Name of Account Holder Text Box on Payment Page");
			reportStep("Successfully entered "+name+"  Name of Account Holder Text Box on Payment Page", "PASS");
		}else {
			Log.info("Unable to enter "+name+" Name of Account Holder Text Box on Payment Page");
			reportStep("Unable to enter " +name+" Name of Account Holder Text Box on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="neft_bank")
	private static WebElement txtBxBankName;
	//Enter Bank Name in Text Box on Payment Page
	public WPPaymentForm enterBankName (String name) {
		Log.info("Locating Bank Name Text Box on Payment Page");
		reportStep("Locating Bank Name Text Box on Payment Page", "INFO");
		if(Utils.sendKeys(txtBxBankName, name)) {
			Log.info("Successfully entered "+name+" Bank Name Text Box on Payment Page");
			reportStep("Successfully entered "+name+" Bank Name Text Box on Payment Page", "PASS");
		}else {
			Log.info("Unable to enter "+name+" Bank Name Text Box on Payment Page");
			reportStep("Unable to enter "+name+" Bank Name Text Box on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="bacs_bank_name")
	private static WebElement txtBxBankNameBacs;
	//Enter Bank Name in Text Box on Payment Page
	public WPPaymentForm enterBankNameBacs (String name) {
		Log.info("Locating Bank Name Bacs Text Box on Payment Page");
		reportStep("Locating Bank Name Bacs Text Box on Payment Page", "INFO");
		if(Utils.sendKeys(txtBxBankNameBacs, name)) {
			Log.info("Successfully entered "+name+" Bank Name Bacs Text Box on Payment Page");
			reportStep("Successfully entered "+name+" Bank Name Bacs Text Box on Payment Page", "PASS");
		}else {
			Log.info("Unable to enter "+name+" Bank Name Bacs Text Box on Payment Page");
			reportStep("Unable to enter "+name+" Bank Name Bacs Text Box on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="neft_bank_branch")
	private static WebElement txtBxBankBranchName;
	//Enter Bank Branch Name in Text Box on Payment Page
	public WPPaymentForm enterBankBranchName (String name) {
		Log.info("Locating Bank Branch Name Text Box on Payment Page");
		reportStep("Locating Bank Branch Name Text Box on Payment Page", "INFO");
		if(Utils.sendKeys(txtBxBankBranchName, name)) {
			Log.info("Successfully entered "+name+" Bank Branch Name Text Box on Payment Page");
			reportStep("Successfully entered " +name+" Bank Branch Name Text Box on Payment Page", "PASS");
		}else {
			Log.info("Unable to enter "+name+" Bank Branch Name Text Box on Payment Page");
			reportStep("Unable to enter "+name+" Bank Branch Name Text Box on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//input[contains(@id,'acc_number')]")
	private static WebElement txtBxBankAccountNumber;
	//Enter Bank Account Number in Text Box on Payment Page
	public WPPaymentForm enterBankAccountNumber(String number) {
		Log.info("Locating Bank Account Number Text Box on Payment Page");
		reportStep("Locating Bank Account Number Text Box on Payment Page", "INFO");
		if(Utils.sendKeys(txtBxBankAccountNumber, number)) {
			Log.info("Successfully entered "+number+"Bank Account Number Text Box on Payment Page");
			reportStep("Successfully entered "+number+" Bank Account Number Text Box on Payment Page", "PASS");
		}else {
			Log.info("Unable to enter Bank Account Number Text Box on Payment Page");
			reportStep("Unable to enter Bank Account Number Text Box on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="bacs_sort_code")
	private static WebElement txtBxBacsSortCode;
	//Enter Bank Account Number in Text Box on Payment Page
	public WPPaymentForm enterSortCodeBacs(String code) {
		Log.info("Locating Sort code for BACS Bank Text Box on Payment Page");
		reportStep("Locating Sort code for BACS Bank Text Box on Payment Page", "INFO");
		if(Utils.sendKeys(txtBxBacsSortCode, code)) {
			Log.info("Successfully entered "+code+" Sort code for BACS Bank Text Box on Payment Page");
			reportStep("Successfully entered "+code+" Sort code for BACS Bank Text Box on Payment Page", "PASS");
		}else {
			Log.info("Unable to enter "+code+" Sort code for BACS Bank in Text Box on Payment Page");
			reportStep("Unable to enter "+code+" Sort code for BACS Bank in Text Box on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="neft_ifsc_code")
	private static WebElement txtBxbankIFSCCode;
	//Enter Bank IFSC Code in Text Box on Payment Page
	public WPPaymentForm enterBankIfscCode(String code) {
		String bank=" Bank IFSC Code Text Box on Payment Page";
		Log.info("Locating "+bank);
		reportStep("Locating" +bank, "INFO");
		if(Utils.sendKeys(txtBxbankIFSCCode, code)) {
			Log.info("Successfully entered "+code+bank);
			reportStep("Successfully entered "+code+bank, "PASS");
		}else {
			Log.info("Unable to enter "+code+bank);
			reportStep("Unable to enter "+code+bank, "FAIL");
		}
		return this;
	}


	@FindBy(xpath ="//input[contains(@id,'email')]")
	private static WebElement txtBxEmailAddress;
	//Enter Email Address in Text Box on Payment Page
	public WPPaymentForm enterEmailAddress(String email) {
		Log.info("Locating Email Address Text Box on Payment Page");
		reportStep("Locating Email Address Text Box on Payment Page", "INFO");
		if(Utils.sendKeys(txtBxEmailAddress, email)) {
			Log.info("Successfully entered Email Address: " + email + " Text Box on Payment Page");
			reportStep("Successfully entered Email Address: " + email + " Text Box on Payment Page", "PASS");
		}else {
			Log.info("Unable to enter Email Address Text Box on Payment Page");
			reportStep("Unable to enter Email Address Text Box on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="businessid_name")
	private static WebElement ddlChooseCharityName; // ddl stands for drop down list
	//Select Charity Name from drop down
	public WPPaymentForm selectCharityName (String charityName) {
		try {
			Log.info("Locating Payment Method on Payment Page");
			reportStep("Locating Payment Method on Payment Page", "INFO");
			Utils.scrollingToPageElement(ddlChooseCharityName, driver);
			Select select= new Select(ddlChooseCharityName);
			select.selectByVisibleText(charityName);
			Log.info("Successfully selected " +charityName+ " on Payment Page");
			reportStep("Successfully selected " +charityName+ " on Payment Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to select " +charityName+ " on Payment Page");
			reportStep("Unable to select " +charityName+ " on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="charity_amount")
	private static WebElement txtBxCharityAmount;
	//Enter Cashback you wish to donate in Text Box on Payment Page
	public WPPaymentForm enterCharityAmount(String amount) {
		Log.info("Locating Cashback you wish to donate Text Box on Payment Page");
		reportStep("Locating Cashback you wish to donate Text Box on Payment Page", "INFO");
		Utils.scrollingToPageElement(txtBxCharityAmount, driver);
		if(Utils.sendKeys(txtBxCharityAmount, amount)) {
			Log.info("Successfully entered "+amount+" Cashback you wish to donate Text Box on Payment Page");
			reportStep("Successfully entered Cashback "+amount+"you wish to donate Text Box on Payment Page", "PASS");
		}else {
			Log.info("Unable to enter Cashback "+amount+" you wish to donate Text Box on Payment Page");
			reportStep("Unable to enter Cashback "+amount+" you wish to donate Text Box on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="confirmpayment")
	private static WebElement btnGetPaid;
	//click Get Paid Button on Payment Page
	public WPPaymentForm clickGetPaidButton() {
		Log.info("Locating Get Paid Button on Payment Page");
		reportStep("Locating Get Paid Button on Payment Page", "INFO");
		if(Utils.jsClick(btnGetPaid, driver)) {
			Log.info("Successfully clicked Get Paid Button on Payment Page");
			reportStep("Successfully clicked Get Paid Button on Payment Page", "PASS");
		}else {
			Log.info("Unable to click Get Paid Button on Payment Page");
			reportStep("Unable to click Get Paid Button on Payment Page", "FAIL");
		}
		return this;
	}

	public WPPaymentForm verifyTextOfGetPaidButton() {
		String locator="Locating \"Get Paid\" Button ";
		String pass="Successfully verified presence of \"Get Paid\" Button. It is :  ";
		String fail="Unable to verify presence of \"Get Paid\" Button. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(btnGetPaid.getText().trim().equals("GET PAID")) {
			Log.info(pass);
			reportStep(pass +btnGetPaid.getText().trim(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + btnGetPaid.getText().trim(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//p[text()='Congratulations! We have received your payment request. Please allow 6-8 business days for the money to reach you. Enjoy your earnings!']")
	private static WebElement paragraphSuccessMsgClaimedCashback;

	//Verify presence of message -- Congratulations! We have received your payment request. Please allow 6-8 business days for the money to reach you. Enjoy your earnings!
	public WPPaymentForm verifyPresenceMessageAfterSuccessfulClaimingCashback () {
		Log.info("Locating message : Congratulations! We have received your payment request. Please allow 6-8 business days for the money to reach you. Enjoy your earnings! After Clicking Get Paid Button in Payment Page.");
		reportStep("Locating message : Congratulations! We have received your payment request. Please allow 6-8 business days for the money to reach you. Enjoy your earnings! After Clicking Get Paid Button in Payment Page.", "INFO");
		boolean presence = Utils.verifyElementPresence(paragraphSuccessMsgClaimedCashback);
		if(presence) {
			Log.info("Successfully verified presence of message : Congratulations! We have received your payment request. Please allow 6-8 business days for the money to reach you. Enjoy your earnings! After Clicking Get Paid Button in Payment Page.");
			reportStep("Successfully verified presence of message : Congratulations! We have received your payment request. Please allow 6-8 business days for the money to reach you. Enjoy your earnings! After Clicking Get Paid Button in Payment Page.", "PASS");
		}else {
			Log.info("Unable to verify presence of message : Congratulations! We have received your payment request. Please allow 6-8 business days for the money to reach you. Enjoy your earnings! After Clicking Get Paid Button in Payment Page.");
			reportStep("Unable to verify presence of message : Congratulations! We have received your payment request. Please allow 6-8 business days for the money to reach you. Enjoy your earnings! After Clicking Get Paid Button in Payment Page.", "FAIL");
		}

		return this;
	}

	@FindBy(xpath="//p[contains(text(),'Thank you for your donation and generosity. Your donation shall be sent shortly. Also, please allow 3-5 working days for your cashback to reach you.')]")
	private static WebElement paragraphSuccessMsgDonation;

	public WPPaymentForm verifyPresenceMessageAfterSuccessfulDonation () {
		Log.info("Locating message : Thank you for your donation and generosity. Your donation shall be sent shortly. Also, please allow 3-5 working days for your cashback to reach you. After Clicking Get Paid Button in Payment Page.");
		reportStep("Locating message : Thank you for your donation and generosity. Your donation shall be sent shortly. Also, please allow 3-5 working days for your cashback to reach you. After Clicking Get Paid Button in Payment Page.", "INFO");
		boolean presence=Utils.verifyElementPresence(paragraphSuccessMsgDonation);
		if(presence) {
			Log.info("Successfully verified presence of message : Thank you for your donation and generosity. Your donation shall be sent shortly. Also, please allow 3-5 working days for your cashback to reach you. After Clicking Get Paid Button in Payment Page.");
			reportStep("Successfully verified presence of message : Thank you for your donation and generosity. Your donation shall be sent shortly. Also, please allow 3-5 working days for your cashback to reach you. After Clicking Get Paid Button in Payment Page.", "PASS");
		}else {
			Log.info("Unable to verify presence of message : Thank you for your donation and generosity. Your donation shall be sent shortly. Also, please allow 3-5 working days for your cashback to reach you.");
			reportStep("Unable to verify presence of message : Thank you for your donation and generosity. Your donation shall be sent shortly. Also, please allow 3-5 working days for your cashback to reach you.", "FAIL");
		}

		return this;
	}
	//Verify "Thank you for your donation and generosity. Your donation shall be sent shortly. Also, please allow 3-5 working days for your cashback to reach you."

	@FindBy(id="paymentOtp")
	private static WebElement txtBxOTP;
	//Enter Cashback you wish to donate in Text Box on Payment Page
	public WPPaymentForm enterOTP(String otp) {
		Log.info("Locating OTP Text Box on Payment Page");
		reportStep("Locating OTP Text Box on Payment Page", "INFO");
		if(Utils.sendKeys(txtBxOTP, otp)) {
			Log.info("Successfully entered OTP "+ otp +" in Text Box on Payment Page");
			reportStep("Successfully entered OTP "+ otp +" in Text Box on Payment Page", "PASS");
		}else {
			Log.info("Unable to enter OTP --"+ otp +" -- in Text Box on Payment Page");
			reportStep("Unable to enter OTP -- "+ otp +" -- in Text Box on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="btnLayoutPaymentVerifyOTP")
	private static WebElement btnVerifyOtp;
	//click Verify OTP Button on Payment Page
	public WPPaymentForm clickVerifyOTPButton() {
		Log.info("Locating Verify OTP Button on Payment Page");
		reportStep("Locating Verify OTP Button on Payment Page", "INFO");
		if(Utils.click(btnVerifyOtp)) {
			Log.info("Successfully clicked Verify OTP Button on Payment Page");
			reportStep("Successfully clicked Verify OTP Button on Payment Page", "PASS");
		}else {
			Log.info("Unable to click Verify OTP Button on Payment Page");
			reportStep("Unable to click Verify OTP Button on Payment Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="cboxClose")
	private static WebElement btnClosePopUp;
	//click Close Pop Up Button on Payment Page
	public WPPaymentForm clickClosePopUpIconToStayOnPaymentPage() {
		Log.info("Locating Close Pop Up Button on Payment Page");
		reportStep("Locating Close Pop Up Button on Payment Page", "INFO");
		if(Utils.click(btnClosePopUp)) {
			Log.info("Successfully clicked Close Pop Up Button on Payment Page");
			reportStep("Successfully clicked Close Pop Up Button on Payment Page", "PASS");
		}else {
			Log.info("Unable to click Close Pop Up Button on Payment Page");
			reportStep("Unable to click Close Pop Up Button on Payment Page", "FAIL");
		}
		return this;
	}

	//click Close Pop Up Button on Payment Page
	public WPMyEarningsPage clickClosePopUpIcon() {
		Log.info("Locating Close Pop Up Button on Payment Page");
		reportStep("Locating Close Pop Up Button on Payment Page", "INFO");
		if(Utils.jsClick(btnClosePopUp, driver)) {
			Log.info("Successfully clicked Close Pop Up Button on Payment Page");
			reportStep("Successfully clicked Close Pop Up Button on Payment Page", "PASS");
		}else {
			Log.info("Unable to click Close Pop Up Button on Payment Page");
			reportStep("Unable to click Close Pop Up Button on Payment Page", "FAIL");
		}
		return new WPMyEarningsPage(driver, logger);
	}

	@FindBy(xpath="//p[contains(text(),'A payment request from you is already Pending. This will be processed shortly. Once this is paid, you can request for another payment.')]")
	private static WebElement paragraphMsgPaymentRequestAlreadyPending;

	//Verify presence of message--A payment request from you is already Pending. This will be processed shortly. Once this is paid, you can request for another payment.
	public WPPaymentForm verifyPresenceMessagePaymentRequestAlreadyPending() {
		String locator="Locating message : \"A payment request from you is already Pending. This will be processed shortly. Once this is paid, you can request for another payment.\" In Pop Up on Payment Page";
		String pass="Successfully verified presence of message : \"A payment request from you is already Pending. This will be processed shortly. Once this is paid, you can request for another payment.\" In Pop Up on Payment Page";
		String fail="Unable to verify presence of message : \"A payment request from you is already Pending. This will be processed shortly. Once this is paid, you can request for another payment.\" In Pop Up on Payment Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(paragraphMsgPaymentRequestAlreadyPending);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}

		return this;
	}

	@FindBy(xpath="//a[contains(text(),'ONLY REDEEM CASHBACK EARNINGS')]")
	private static WebElement lnkOnlyRedeemREWARDSEarnings;
	//Click ONLY REDEEM CASHBACK EARNINGS Link In Pop Up
	public WPPaymentForm clickOnlyRedeemRewardsEarningsLink () {
		String locator="Locating ONLY REDEEM REWARDS EARNINGS Link In Pop Up on Payment Page";
		String pass="Successfully clicked ONLY REDEEM REWARDS EARNINGS Link In Pop Up on Payment Page";
		String fail="Unable to click ONLY REDEEM REWARDS EARNINGS Link In Pop Up on Payment Page";
		try {
			Log.info(locator);
			reportStep(locator, "INFO");
			Utils.explicitWaitForClick(lnkOnlyRedeemREWARDSEarnings);
			Log.info(pass);
			reportStep(pass, "PASS");
		}catch(Exception e) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//p[contains(text(),'Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)?')]")
	private static WebElement paragraphMsgCombineCashBackRewards;
	//Verify presence of message Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cash back & redeem together via Gift Cards or Wallet transfer (not NEFT)?
	public WPPaymentForm verifyPresenceMessageToCombineCashBackAndRewards () {
		String locator="Locating message : Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)? In Pop Up on Payment Page";
		String pass="Successfully verified presence of message : Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)? In Pop Up on Payment Page";
		String fail="Unable to verify presence of message : Thanks. You also have ₹500.00 Rewards earnings ready to be withdrawn. Would you like to combine them with these Cashback & redeem together via Gift Cards or Wallet transfer (not NEFT)?  In Pop Up on Payment Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(paragraphMsgCombineCashBackRewards);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}

		return this;
	}

	@FindBy(xpath="//h2[contains(text(),'PAYMENT THRESHOLD NOT REACHED')]")
	private static WebElement paragraphMsgThresholdNotReached;

	//Verify presence of message PAYMENT THRESHOLD NOT REACHED
	public WPPaymentForm verifyPresenceMessageThresholdNotReached () {
		String locator="Locating message : \"PAYMENT THRESHOLD NOT REACHED\" In Pop Up on My Payment Page";
		String pass="Successfully verified presence of message : \"PAYMENT THRESHOLD NOT REACHED\" In Pop Up on Payment Page";
		String fail="Unable to verify presence of message : \"PAYMENT THRESHOLD NOT REACHED\" In Pop Up on My Payment Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(paragraphMsgThresholdNotReached);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}

		return this;
	}

	@FindBy(xpath="//p[contains(text(),'Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.')]")
	private static WebElement paragraphMsgUnableToProcessRequest;

	//Verify presence of message--Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.
	public WPPaymentForm verifyPresenceMessageUnableToProcessRequest() {
		String locator="Locating message : \"Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.\" In Pop Up on Payment Page";
		String pass="Successfully verified presence of message : \"Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.\" In Pop Up on Payment Page";
		String fail="Unable to verify presence of message : \"Therefore we are unable to process your request at this time. Please don’t hesitate to contact us via the website itself if you have any questions.\" In Pop Up on Payment Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(paragraphMsgUnableToProcessRequest);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}

		return this;
	}

	//Add Cashback to Account
	public WPPaymentForm addCashbackRewards(String amount, String email, String cashBackType) {
		Log.info("Adding "+cashBackType+" CashBack to user account");
		reportStep("Adding "+cashBackType+" CashBack to user account", "INFO");
		Utils.addCashbackRewards(driver, amount, email, cashBackType);
		Log.info("Successfully Added " +amount+ " CashBack of type "+cashBackType+" to user account");
		reportStep("Successfully Added " +amount+ " CashBack of type "+cashBackType+" to user account", "PASS");
		return this;
	}

	@FindBy(xpath="//a[text()='ONLY REDEEM CASHBACK EARNINGS']")
	private static WebElement lnkOnlyRedeemCashBackEarnings;

	//Click ONLY REDEEM CASHBACK EARNINGS Link In Pop Up
	public WPPaymentForm clickOnlyRedeemCashBackEarningsLink () {
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
		return this;
	}

	@FindBy(id="lnkPaymentRequestOptionButton0")
	private static WebElement lnkCombineRewardsPlusCashBack;

	public WPPaymentForm clickCombineRewardsPlusCashBackLink () {
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
		return this;
	}

	@FindBy(xpath = "//div[text()='CHOOSE PAYMENT METHOD']")
	private static WebElement lblChoosePaymentMethod;
	//verify presence of Choose Payment Method
	public WPPaymentForm verifyPresenceOfChoosePaymentMethodLabel() {
		String locator="Locating \"CHOOSE PAYMENT METHOD\" Label ";
		String pass="Successfully verified presence of \"CHOOSE PAYMENT METHOD\" Label ";
		String fail="Unable to verify presence of \"CHOOSE PAYMENT METHOD\" Label ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblChoosePaymentMethod);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//b[contains(text(),'REWARDS AVAILABLE FOR PAYMENT')]")
	private static WebElement lblRewardsAvailableForPayment;
	//verify presence of REWARDS AVAILABLE FOR PAYMENT Label
	public WPPaymentForm verifyPresenceOfRewardsAvailableForPaymentLabel() {
		String locator="Locating \"REWARDS AVAILABLE FOR PAYMENT\" Label ";
		String pass="Successfully verified presence of \"REWARDS AVAILABLE FOR PAYMENT\" Label ";
		String fail="Unable to verify presence of \"REWARDS AVAILABLE FOR PAYMENT\" Label ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblRewardsAvailableForPayment);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//b[contains(text(),'CASHBACK AVAILABLE FOR PAYMENT')]")
	private static WebElement lblCashbackAvailableForPayment;
	//verify presence of Cashback AVAILABLE FOR PAYMENT Label
	public WPPaymentForm verifyPresenceOfCashbackAvailableForPaymentLabel() {
		String locator="Locating \"Cashback AVAILABLE FOR PAYMENT\" Label ";
		String pass="Successfully verified presence of \"Cashback AVAILABLE FOR PAYMENT\" Label. It is : ";
		String fail="Unable to verify presence of \"Cashback AVAILABLE FOR PAYMENT\" Label. It is  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblCashbackAvailableForPayment);
		if(presence) {
			Log.info(pass+ lblCashbackAvailableForPayment.getText().toString());
			reportStep(pass+ lblCashbackAvailableForPayment.getText().toString(), "PASS");
		}else {
			Log.info(fail+ lblCashbackAvailableForPayment.getText().toString());
			reportStep(fail+ lblCashbackAvailableForPayment.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "(//strong[contains(text(),'₹250.00')])[2]")
	private static WebElement lblRewardsAmountAvailableForPayment;
	//verify presence of REWARDS Amount AVAILABLE FOR PAYMENT Label
	public WPPaymentForm verifyPresenceOfRewardsAmountAvailableForPaymentLabel() {
		String locator="Locating \"REWARDS Amount AVAILABLE FOR PAYMENT\" Label ";
		String pass="Successfully verified presence of \"REWARDS Amount AVAILABLE FOR PAYMENT\" Label. It is :  ";
		String fail="Unable to verify presence of \"REWARDS Amount AVAILABLE FOR PAYMENT\" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblRewardsAmountAvailableForPayment);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblRewardsAmountAvailableForPayment.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblRewardsAmountAvailableForPayment.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//div[contains(text(),'ENTER GIFT CARD DETAILS')]")
	private static WebElement lblEnterGiftCardDetails;
	//verify presence of ENTER GIFT CARD DETAILS Label
	public WPPaymentForm verifyPresenceOfEnterGiftCardDetailsLabel() {
		String locator="Locating \"ENTER GIFT CARD DETAILS\" Label ";
		String pass="Successfully verified presence of \"ENTER GIFT CARD DETAILS\" Label. It is :  ";
		String fail="Unable to verify presence of \"ENTER GIFT CARD DETAILS\" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblEnterGiftCardDetails);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblEnterGiftCardDetails.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblEnterGiftCardDetails.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Email ID to send gift card')]")
	private static WebElement lblEmailIdToSendGiftCard;
	//verify presence of ENTER GIFT CARD DETAILS Label
	public WPPaymentForm verifyPresenceOfEmailIdToSendGiftCardLabel() {
		String locator="Locating \"Email ID to send gift card\" Label ";
		String pass="Successfully verified presence of \"Email ID to send gift card\" Label. It is :  ";
		String fail="Unable to verify presence of \"Email ID to send gift card\" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblEmailIdToSendGiftCard);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblEmailIdToSendGiftCard.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblEmailIdToSendGiftCard.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//p[contains(text(),'WOULD YOU LIKE TO DONATE SOME REWARDS TO CHARITY?')]")
	private static WebElement lblWouldYouDonateCharity;
	//verify presence of WOULD YOU LIKE TO DONATE SOME REWARDS TO CHARITY?  Label
	public WPPaymentForm verifyPresenceOfWouldYouDonateCharityLabel() {
		String locator="Locating \"WOULD YOU LIKE TO DONATE SOME REWARDS TO CHARITY? \" Label ";
		String pass="Successfully verified presence of \"WOULD YOU LIKE TO DONATE SOME REWARDS TO CHARITY? \" Label. It is :  ";
		String fail="Unable to verify presence of \"WOULD YOU LIKE TO DONATE SOME REWARDS TO CHARITY? \" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblWouldYouDonateCharity);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblWouldYouDonateCharity.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblWouldYouDonateCharity.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//p[contains(text(),'WOULD YOU LIKE TO DONATE SOME CASHBACK TO CHARITY?')]")
	private static WebElement lblWouldYouDonateCharityCashback;
	//verify presence of WOULD YOU LIKE TO DONATE SOME Cashback TO CHARITY?  Label
	public WPPaymentForm verifyPresenceOfWouldYouDonateCashbackCharityLabel() {
		String locator="Locating \"WOULD YOU LIKE TO DONATE SOME REWARDS TO CHARITY? \" Label ";
		String pass="Successfully verified presence of \"WOULD YOU LIKE TO DONATE SOME REWARDS TO CHARITY? \" Label. It is :  ";
		String fail="Unable to verify presence of \"WOULD YOU LIKE TO DONATE SOME REWARDS TO CHARITY? \" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblWouldYouDonateCharityCashback);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblWouldYouDonateCharityCashback.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblWouldYouDonateCharityCashback.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Select Charity To Donate Rewards to')]")
	private static WebElement lblSelectCharityToDonate;
	//verify presence of Select Charity To Donate Label
	public WPPaymentForm verifyPresenceOfSelectCharityToDonateLabel() {
		String locator="Locating \"Select Charity To Donate Rewards to\" Label ";
		String pass="Successfully verified presence of \"Select Charity To Donate Rewards to\" Label. It is :  ";
		String fail="Unable to verify presence of \"Select Charity To Donate Rewards to\" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblSelectCharityToDonate);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblSelectCharityToDonate.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblSelectCharityToDonate.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Select Charity To Donate Cashback to')]")
	private static WebElement lblSelectCharityToDonateCashBack;
	//verify presence of Select Charity To Donate Cashback Label
	public WPPaymentForm verifyPresenceOfSelectCharityToDonateCashbackLabel() {
		String locator="Locating \"Select Charity To Donate Cashback to\" Label ";
		String pass="Successfully verified presence of \"Select Charity To Donate Cashback to\" Label. It is :  ";
		String fail="Unable to verify presence of \"Select Charity To Donate Cashback to\" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblSelectCharityToDonateCashBack);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblSelectCharityToDonateCashBack.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblSelectCharityToDonateCashBack.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Rewards you wish to donate')]")
	private static WebElement lblRewardsYouWishToDonate;
	//verify presence of Rewards you wish to donate Label
	public WPPaymentForm verifyPresenceOfRewardsYouWishToDonateLabel() {
		String locator="Locating \"Rewards you wish to donate\" Label ";
		String pass="Successfully verified presence of \"Rewards you wish to donate\" Label. It is :  ";
		String fail="Unable to verify presence of \"Rewards you wish to donate\" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblRewardsYouWishToDonate);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblRewardsYouWishToDonate.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblRewardsYouWishToDonate.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Cashback you wish to donate')]")
	private static WebElement lblCashbackYouWishToDonate;
	//verify presence of Cashback you wish to donate Label
	public WPPaymentForm verifyPresenceOfCashbackYouWishToDonateLabel() {
		String locator="Locating \"Cashback you wish to donate\" Label ";
		String pass="Successfully verified presence of \"Cashback you wish to donate\" Label. It is :  ";
		String fail="Unable to verify presence of \"Cashback you wish to donate\" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblCashbackYouWishToDonate);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblCashbackYouWishToDonate.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblCashbackYouWishToDonate.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Rewards Available after donation')]")
	private static WebElement lblRewardsAvailableAfterDonation;
	//verify presence of Rewards Available after donation Label
	public WPPaymentForm verifyPresenceOfRewardsAvailableAfterDonationLabel() {
		String locator="Locating \"Rewards Available after donation\" Label ";
		String pass="Successfully verified presence of \"Rewards Available after donation\" Label. It is :  ";
		String fail="Unable to verify presence of \"Rewards Available after donation\" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblRewardsAvailableAfterDonation);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblRewardsAvailableAfterDonation.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblRewardsAvailableAfterDonation.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Cashback Available after donation')]")
	private static WebElement lblCashbackAvailableAfterDonation;
	//verify presence of Cashback Available after donation Label
	public WPPaymentForm verifyPresenceOfCashbackAvailableAfterDonationLabel() {
		String locator="Locating \"Cashback Available after donation\" Label ";
		String pass="Successfully verified presence of \"Cashback Available after donation\" Label. It is :  ";
		String fail="Unable to verify presence of \"Cashback Available after donation\" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblCashbackAvailableAfterDonation);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblCashbackAvailableAfterDonation.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblCashbackAvailableAfterDonation.getText().toString(), "FAIL");
		}
		return this;
	}
	@FindBy(xpath = "(//strong[contains(text(),'₹250.00')])[3]")
	private static WebElement lblAmountAvailableAfterDonation;
	//verify presence of Amount Available After Donation
	public WPPaymentForm verifyPresenceOfAmountAvailableAfterDonation() {
		String locator="Locating \"Amount Available after donation\" Label ";
		String pass="Successfully verified presence of \"Amount Available after donation\" Label. It is :  ";
		String fail="Unable to verify presence of \"Amount Available after donation\" Label. . It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblAmountAvailableAfterDonation);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblAmountAvailableAfterDonation.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblAmountAvailableAfterDonation.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//input[@value='0']")
	private static WebElement txtBxCharityAmountValue;
	//verify presence of Amount Available After Donation
	public WPPaymentForm verifyPresenceCharityAmountTextBox() {
		String locator="Locating \"Amount Available after donation\" Label ";
		String pass="Successfully verified presence of \"Amount Available after donation\" Label.";
		String fail="Unable to verify presence of \"Amount Available after donation\" Label.";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(txtBxCharityAmountValue);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//div[contains(text(),'ENTER BANK DETAILS')]")
	private static WebElement lblEnterBankDetails;
	//verify presence of ENTER BANK DETAILS Label
	public WPPaymentForm verifyPresenceOfEnterBankDetailsLabel() {
		String locator="Locating \"ENTER BANK DETAILS\" Label ";
		String pass="Successfully verified presence of \"ENTER BANK DETAILS\" Label. It is :  ";
		String fail="Unable to verify presence of \"ENTER BANK DETAILS\" Label. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblEnterBankDetails);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblEnterBankDetails.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblEnterBankDetails.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Name of Bank Account Holder:')]")
	private static WebElement lblNameOfBankAccountHolder;
	//verify presence of Name of Bank Account Holder: Label
	public WPPaymentForm verifyPresenceOfNameOfBankAccountHolderLabel() {
		String locator="Locating \"Name of Bank Account Holder:\" Label ";
		String pass="Successfully verified presence of \"Name of Bank Account Holder:\" Label. It is :  ";
		String fail="Unable to verify presence of \"Name of Bank Account Holder:\" Label. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblNameOfBankAccountHolder);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblNameOfBankAccountHolder.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblNameOfBankAccountHolder.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Bank name:')]")
	private static WebElement lblBankName;
	//verify presence of Bank name: Label
	public WPPaymentForm verifyPresenceOfBankNameLabel() {
		String locator="Locating \"Bank name:\" Label ";
		String pass="Successfully verified presence of \"Bank name:\" Label. It is :  ";
		String fail="Unable to verify presence of \"Bank name:\" Label. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblBankName);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblBankName.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblBankName.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Bank Branch Name:')]")
	private static WebElement lblBankBranchName;
	//verify presence of Bank Branch name: Label
	public WPPaymentForm verifyPresenceOfBankBranchNameLabel() {
		String locator="Locating \"Bank Branch name:\" Label ";
		String pass="Successfully verified presence of \"Bank Branch name:\" Label. It is :  ";
		String fail="Unable to verify presence of \"Bank Branch name:\" Label. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblBankBranchName);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblBankBranchName.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblBankBranchName.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'Bank Account number:')]")
	private static WebElement lblBankAccountNumber;
	//verify presence of Bank Branch name: Label
	public WPPaymentForm verifyPresenceOfBankAccountNumberLabel() {
		String locator="Locating \"Bank Account number:\" Label ";
		String pass="Successfully verified presence of \"Bank Account number:\" Label. It is :  ";
		String fail="Unable to verify presence of \"Bank Account number:\" Label. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblBankAccountNumber);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblBankAccountNumber.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblBankAccountNumber.getText().toString(), "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'IFSC Code for Bank:')]")
	private static WebElement lblBankIfscCode;
	//verify presence of IFSC Code for Bank: Label
	public WPPaymentForm verifyPresenceOfBankIfscCodeLabel() {
		String locator="Locating \"IFSC Code for Bank:\" Label ";
		String pass="Successfully verified presence of \"IFSC Code for Bank:\" Label. It is :  ";
		String fail="Unable to verify presence of \"IFSC Code for Bank:\" Label. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblBankIfscCode);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblBankIfscCode.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblBankIfscCode.getText().toString(), "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//b[contains(text(),'EARNINGS AVAILABLE FOR PAYMENT')]")
	private static WebElement lblEarningAvailableForPayment;
	//verify presence of EARNINGS AVAILABLE FOR PAYMENT Label in Payment Page
	public WPPaymentForm verifyEarningAvailableForPaymentLabel() {
		String locator="Locating \"EARNINGS AVAILABLE FOR PAYMENT\" Label in Payment Page";
		String pass="Successfully verified presence of \"EARNINGS AVAILABLE FOR PAYMENT\" Label in Payment Page. It is :  ";
		String fail="Unable to verify presence of \"EARNINGS AVAILABLE FOR PAYMENT\" Label in Payment Page. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblEarningAvailableForPayment);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblEarningAvailableForPayment.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblEarningAvailableForPayment.getText().toString(), "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//strong[contains(text(),'₹500.00')]")
	private static WebElement lblAmountAvailableForPayment;
	//verify presence of Rs.500.00 Amount AVAILABLE FOR PAYMENT Label in Payment Page
	public WPPaymentForm verifyAmountAvailableForPaymentLabel() {
		String locator="Locating \"Rs.500.00 Amount AVAILABLE FOR PAYMENT\" Label in Payment Page";
		String pass="Successfully verified presence of \"Rs.500.00 Amount AVAILABLE FOR PAYMENT\" Label in Payment Page. It is :  ";
		String fail="Unable to verify presence of \"Rs.500.00 Amount AVAILABLE FOR PAYMENT\" Label in Payment Page. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblAmountAvailableForPayment);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblAmountAvailableForPayment.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblAmountAvailableForPayment.getText().toString(), "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//p[contains(.,'( Cashback: ₹250.00 , Rewards: ₹250.00 )')]")
	private static WebElement lblCashBackAndRewardsAmount;
	//verify presence of  ( Cashback: Rs.250.00 , Rewards: Rs.250.00 ) Amount AVAILABLE FOR PAYMENT Label in Payment Page
	public WPPaymentForm verifyCashBackAndRewardsAmount250Each() {
		String locator="Locating \"( Cashback: Rs.250.00 , Rewards: Rs.250.00 )\" Label in Payment Page";
		String pass="Successfully verified presence of \"( Cashback: Rs.250.00 , Rewards: Rs.250.00 )\" Label in Payment Page. It is :  ";
		String fail="Unable to verify presence of \"( Cashback: Rs.250.00 , Rewards: Rs.250.00 )\" Label in Payment Page. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		String expected="( Cashback: Rs.250.00 , Rewards: Rs.250.00 )";
		String actual=lblCashBackAndRewardsAmount.getText().trim().toString();
		if(expected.equals(actual)) {
			Log.info(pass);
			reportStep(pass +lblAmountAvailableForPayment.getText().toString(), "PASS");
		}
		boolean presence=Utils.verifyElementPresence(lblCashBackAndRewardsAmount);
		if(presence) {
			Log.info(pass);
			reportStep(pass +expected, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + actual, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//p[contains(text(),'*If sum of Confirmed Cashback + Confirmed Rewards is over ₹250.00, you can request payment.')]")
	private static WebElement lblTermsAndCondition1;
	//verify presence of "*If sum of Confirmed Cashback + Confirmed Rewards is over Rs.250.00, you can request payment." Label in Payment Page
	public WPPaymentForm verifyInfoAboutRequestPayment1() {
		String locator="Locating \"*If sum of Confirmed Cashback + Confirmed Rewards is over Rs.250.00, you can request payment.\" Label in Payment Page";
		String pass="Successfully verified presence of \"*If sum of Confirmed Cashback + Confirmed Rewards is over Rs.250.00, you can request payment.\" Label in Payment Page. It is :  ";
		String fail="Unable to verify presence of \"*If sum of Confirmed Cashback + Confirmed Rewards is over Rs.250.00, you can request payment.\" Label in Payment Page. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblTermsAndCondition1);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblTermsAndCondition1.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblTermsAndCondition1.getText().toString(), "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//p[contains(.,'However, if total Confirmed Rewards + Cashback is over ₹250.00, they can be paid via Gift Cards.')]")
	private static WebElement lblTermsAndCondition3;
	//verify presence of "However, if total Confirmed Rewards + Cashback is over Rs.250.00, they can be paid via Gift Cards." Label in Payment Page
	public WPPaymentForm verifyInfoAboutRequestPayment3() {
		String locator="Locating \" However, if total Confirmed Rewards + Cashback is over Rs.250.00, they can be paid via Gift Cards.\" Label in Payment Page";
		String pass="Successfully verified presence of \"However, if total Confirmed Rewards + Cashback is over Rs.250.00, they can be paid via Gift Cards.\" Label in Payment Page. It is :  ";
		String fail="Unable to verify presence of \"However, if total Confirmed Rewards + Cashback is over Rs.250.00, they can be paid via Gift Cards.\" Label in Payment Page. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblTermsAndCondition3);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblTermsAndCondition3.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblTermsAndCondition3.getText().toString(), "FAIL");
		}
		return this;
	}
	

	@FindBy(id = "lnkMorePaymentInfo")
	private static WebElement lnkClickHereForMoreInfo;
	//verify presence of "*Rewards cannot be paid as Cash via NEFT." Label in Payment Page
	public WPPaymentForm clickHereLinkInPaymentPage() {
		String locator="Locating \"here\" link in Payment Page";
		String pass="Successfully Clicked \"here\" link in Payment Page.";
		String fail="Unable to Click \"here\" link in Payment Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.click(lnkClickHereForMoreInfo);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id = "iconPaymentInformationClose")
	private static WebElement lnkClickHereCloseIcon;
	//verify presence of "*Rewards cannot be paid as Cash via NEFT." Label in Payment Page
	public WPPaymentForm clickHereLinkCloseIconInPaymentPage() {
		String locator="Locating \"Click here Close Icon\" link in Payment Page";
		String pass="Successfully Clicked \"Click here Close Icon\" link in Payment Page.";
		String fail="Unable to Click \"Click here Close Icon\" link in Payment Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.click(lnkClickHereCloseIcon);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//strong[contains(text(),'*Rewards cannot be paid as Cash via NEFT.')]")
	private static WebElement lblTermsAndCondition2;
	//verify presence of "*Rewards cannot be paid as Cash via NEFT." Label in Payment Page
	public WPPaymentForm verifyInfoAboutRequestPayment2() {
		String locator="Locating \"*Rewards cannot be paid as Cash via NEFT.\" Label in Payment Page";
		String pass="Successfully verified presence of \"*Rewards cannot be paid as Cash via NEFT.\" Label in Payment Page. It is :  ";
		String fail="Unable to verify presence of \"*Rewards cannot be paid as Cash via NEFT.\" Label in Payment Page. It is :  ";
		Log.info(locator);
		reportStep(locator, "INFO");
		boolean presence=Utils.verifyElementPresence(lblTermsAndCondition2);
		if(presence) {
			Log.info(pass);
			reportStep(pass +lblTermsAndCondition2.getText().toString(), "PASS");
		}else {
			Log.info(fail);
			reportStep(fail + lblTermsAndCondition2.getText().toString(), "FAIL");
		}
		return this;
	}
}
