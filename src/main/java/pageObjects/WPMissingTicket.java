package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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

public class WPMissingTicket extends TestSetUp{

	private Boolean presence;
	public static final Logger log = LogManager.getLogger(WPMissingTicket.class);

	//Parameterized Constructor for WP_MissingTicket
	public WPMissingTicket(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;
		String info="Waiting for the Missing Cashback Page To Load";
		String pass="Successfully landed on the Missing Cashback page";
		String fail="Unable to land on the Missing Cashback page";
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info(info);
		reportStep(info, "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lnkMissingCashBackLeftNav));
			Log.info(pass);
			reportStep(pass, "PASS");
		} catch (Exception e) {
			Log.error(fail);
			reportStep(fail, "FAIL");

		} 
	}
	
	@FindBy(xpath="//a[contains(text(),'Missing Cashback?')]")
	private static WebElement lnkMissingCashBackLeftNav;
	
	@FindBy(id="transaction_date")
	private static WebElement txtBxTransactionDate;

	//This method will click Date of transaction Text Box
	public WPMissingTicket clickDateOfTransactionTextBox() {
		String locator="Locating \"Date Of Transaction\" Text Box in Missing Cashback Page";
		String pass="Successfully clicked \"Date Of Transaction\" Text Box in Missing Cashback Page";
		String fail="Unable to Locate \"Date Of Transaction\" Text Box in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.jsClick(txtBxTransactionDate, driver); //Js Click is used to reduce execution time
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//td[contains(@class,'minical_today')]")
	private static WebElement datePickerTodayDate;

	//This method will click Today's Date
	public WPMissingTicket clickTodaysDateInDatePicker() {
		String locator="Locating \"Today's Date\" in Date Picker in Missing Cashback Page";
		String pass="Successfully clicked \"Today's Date\" in Date Picker  in Missing Cashback Page";
		String fail="Unable to Locate \"Today's Date\" in Date Picker  in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.click(datePickerTodayDate);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	private WebElement fourBackDate() {
		WebElement element=driver.findElement(By.xpath("//td[contains(@class,'minical_day_"+Utils.backDateFourDays()+" minical_day')][1]"));
		return element;
	}

	//This method will click Today's Date
	public WPMissingTicket clickFourDaysBackDate() {
		String locator="Locating \"Four Days Back Date\" in Date Picker in Missing Cashback Page";
		String pass="Successfully clicked \"Four Days Back Date\" in Date Picker  in Missing Cashback Page";
		String fail="Unable to Locate \"Four Days Back Date\" in Date Picker  in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.click(fourBackDate());
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="transaction_reference")
	private static WebElement txtBxTansactionId;

	//This method will Enter transaction Id in Text Box
	public WPMissingTicket enterTransactionId(String transactionId) {
		String locator="Locating \"Transaction Id :\" "+transactionId+"  in Text Box in Missing Cashback Page";
		String pass="Successfully entered  " +transactionId+ " \"Transaction Id\" in Text Box in Missing Cashback Page";
		String fail="Unable to Locate \"Transaction Id : \" "+transactionId+"Text Box in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.sendKeys(txtBxTansactionId, transactionId);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="ordervalue")
	private static WebElement txtBxTotalAmountPaid;

	//This method will Enter Total Amount Paid in Text Box
	public WPMissingTicket enterTotalAmountPaid(String totalAmountPaid) {
		String locator="Locating \"Total Amount Paid\" in Text Box in Missing Cashback Page";
		String pass="Successfully entered  " +totalAmountPaid+ " \"Total Amount Paid\" in Text Box of Missing Cashback Page";
		String fail="Unable to Locate \"Total Amount Paid: \" "+totalAmountPaid+" in Text Box of Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.sendKeys(txtBxTotalAmountPaid, totalAmountPaid);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="ticket_attachment")
	private static WebElement lnkTicketAttachment;
	
	public WPMissingTicket uploadFile(String path) {
		String locator="Locating \"Choose File\"  in Missing Cashback Page";
		String pass="Successfully  \"Uploaded file\" from "+path+"  in Missing Cashback Page";
		String fail="Unable to Locate \"Choose File\"  in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.sendKeys(lnkTicketAttachment, path);
		if(presence) {
			Log.info(pass+"File Path: " +path);
			reportStep(pass+"File Path: " +path, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="coupon_used")
	private static WebElement txtBxCouponCodeUsed;

	//This method will Enter Coupon Code Used in Text Box
	public WPMissingTicket enterCouponCodeUsed(String couponCodeUsed) {
		String locator="Locating \"Coupon Code Used\" in Text Box in Missing Cashback Page";
		String pass="Successfully entered  " +couponCodeUsed+ " \"Coupon Code Used\" in Text Box in Missing Cashback Page";
		String fail="Unable to Locate \"Coupon Code Used\" Text Box in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.sendKeys(txtBxCouponCodeUsed, couponCodeUsed);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="details")
	private static WebElement txtBxTransactionDetails;

	//This method will Enter Transaction Details Used in Text Box
	public WPMissingTicket enterTransactionDetails(String transactionDetails) {
		String locator="Locating \"Transaction Details\" in Text Area in Missing Cashback Page";
		String pass="Successfully entered  " +transactionDetails+ " \"Transaction Details\" in Text Area in Missing Cashback Page";
		String fail="Unable to enter \"Transaction Details: \" "+transactionDetails+" Text Area in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.sendKeys(txtBxTransactionDetails, transactionDetails);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="lblTransactionDate")
	private static WebElement lblDateOfTransaction;

	//This method verify Date of transaction Label
	public WPMissingTicket verifyDateOfTransactionLabelIsVisible() {
		String locator="Locating Date Of Transaction Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"Date Of Transaction\" Label in Missing Cashback Page";
		String fail="Unable to locate \"Date Of Transaction\" Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(lblDateOfTransaction);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//label[contains(text(),'Enter the date of transaction')]")
	private static WebElement lblEnterDateOfTransaction;

	//This method verify Date of transaction Label
	public WPMissingTicket verifyEnterDateOfTransactionLabelIsVisible() {
		String locator="Locating \"Enter The Date Of Transaction\" Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"Enter The Date Of Transaction\" Label in Missing Cashback Page";
		String fail="Unable to locate \"Enter The Date Of Transaction\" Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(lblDateOfTransaction);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//div[contains(text(),'RETAILER YOU SHOPPED AT')]")
	private static WebElement lblRetailerYouShoppedAt;

	//This method verify RETAILER YOU SHOPPED AT Label
	public WPMissingTicket verifyRetailerYouShoppedAtLabelIsVisible() {
		String locator="Locating \"RETAILER YOU SHOPPED AT\" Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"RETAILER YOU SHOPPED AT\" Label in Missing Cashback Page";
		String fail="Unable to locate \"RETAILER YOU SHOPPED AT\" Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(lblRetailerYouShoppedAt);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="store")
	private static WebElement ddlSelectRetailer;
	public WPMissingTicket selectFirstRetailerDropDropDownListInMissingCashBackPage() {
		String locator="Locating \"Select Retailer Drop Drop Down List\" in Missing Cashback Page";
		String pass="Successfully selected \"Retailer  From Drop Drop Down List\" in Missing Cashback Page. Retailer selected is : ";
		String fail="Unable to locate \"Select Retailer Drop Drop Down List\" in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		try {
			String value=Utils.getTestData(7, "retailerName");
			Select selectRetailer=new Select(ddlSelectRetailer);
			Thread.sleep(1000);
			selectRetailer.selectByVisibleText(value);;
			Log.info(pass+ value);
			reportStep(pass+ value, "PASS");
		}catch(Exception e) {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//div[contains(text(),'SELECT EXIT CLICK & TRANSACTION DETAILS')]")
	private static WebElement lblSelectExitClickAndTransactionDetailst;

	//This method verify RETAILER YOU SHOPPED AT Label
	public WPMissingTicket verifySelectExitClickAndTransactionDetailsLabelIsVisible() {
		String locator="Locating \"SELECT EXIT CLICK & TRANSACTION DETAILS\" Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"SELECT EXIT CLICK & TRANSACTION DETAILS\" Label in Missing Cashback Page";
		String fail="Unable to locate \"SELECT EXIT CLICK & TRANSACTION DETAILS\" Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(lblSelectExitClickAndTransactionDetailst);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//em[contains(text(),'Have multiple exit clicks for the same retailer? Select any one and we will take care of the rest!')]")
	private static WebElement lblHaveMultipleClickSameRetailers;

	//This method verify presence of "Have multiple exit clicks for the same retailer? Select any one and we will take care of the rest!" Label
	public WPMissingTicket verifylblHaveMultipleClickSameRetailersLabelIsVisible() {
		String locator="Locating \"Have multiple exit clicks for the same retailer? Select any one and we will take care of the rest!\" Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"Have multiple exit clicks for the same retailer? Select any one and we will take care of the rest!\" Label in Missing Cashback Page";
		String fail="Unable to locate \"Have multiple exit clicks for the same retailer? Select any one and we will take care of the rest!\" Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(lblHaveMultipleClickSameRetailers);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//li[contains(text(),'Exit Click Time')]")
	private static WebElement ColumnNameExitClickTime;

	//This method verify Exit Click Time Column Name in Missing Cashback Page
	public WPMissingTicket verifyExitClickTimeTableColumnIsVisible() {
		String locator="Locating \"Exit Click Time\" Column Name in Missing Cashback Page";
		String pass="Successfully verified presence of \"Exit Click Time\" Column Name in Missing Cashback Page";
		String fail="Unable to locate \"Exit Click Time\"  Column Name in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(ColumnNameExitClickTime);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//li[contains(text(),'Transaction ID')]")
	private static WebElement columnNameTransactionID;

	//This method verify Transaction ID Column Name in Missing Cashback Page
	public WPMissingTicket verifyTransactionIdTableColumnIsVisible() {
		String locator="Locating \"Transaction ID\" Column Name in Missing Cashback Page";
		String pass="Successfully verified presence of \"Transaction ID\" Column Name in Missing Cashback Page";
		String fail="Unable to locate \"Transaction ID\"  Column Name in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(columnNameTransactionID);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//li[contains(text(),'Transaction Amount')]")
	private static WebElement tblListTransactionAmount;

	//This method verify Transaction Amount Column Name in Missing Cashback Page
	public WPMissingTicket verifyTransactionAmountTableListIsVisible() {
		String locator="Locating \"Transaction Amount\" Column Name in Missing Cashback Page";
		String pass="Successfully verified presence of \"Transaction Amount\" Column Name in Missing Cashback Page";
		String fail="Unable to locate \"Transaction Amount\"  Column Name in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(tblListTransactionAmount);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//li[contains(text(),'Earnings')]")
	private static WebElement tblListEarnings;

	//This method verify Earnings Column Name in Missing Cash back Page
	public WPMissingTicket verifyEarningsTableListIsVisible() {
		String locator="Locating \"Earnings\" Column Name in Missing Cashback Page";
		String pass="Successfully verified presence of \"Earnings\" Column Name in Missing Cashback Page";
		String fail="Unable to locate \"Earnings\"  Column Name in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(tblListEarnings);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//li[contains(text(),'Coupon Details')]")
	private static WebElement tblListCouponDetails;

	//This method verify Coupon Details Column Name in Missing Cash back Page
	public WPMissingTicket verifyCouponDetailsTableListIsVisible() {
		String locator="Locating \"Coupon Details\" Column Name in Missing Cashback Page";
		String pass="Successfully verified presence of \"Coupon Details\" Column Name in Missing Cashback Page";
		String fail="Unable to locate \"Coupon Details\"  Column Name in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(tblListCouponDetails);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//li[contains(text(),'Status')]")
	private static WebElement tblListStatus;

	//This method verify Status Column Name in Missing Cash back Page
	public WPMissingTicket verifyStatusTableListIsVisible() {
		String locator="Locating \"Status\" Column Name in Missing Cashback Page";
		String pass="Successfully verified presence of \"Status\" Column Name in Missing Cashback Page";
		String fail="Unable to locate \"Status\"  Column Name in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(tblListStatus);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//li[contains(text(),'Info')]")
	private static WebElement tblListInfo;

	//This method verify Info Column Name in Missing Cash back Page
	public WPMissingTicket verifyInfoTableListIsVisible() {
		String locator="Locating \"Info\" Column Name in Missing Cashback Page";
		String pass="Successfully verified presence of \"Info\" Column Name in Missing Cashback Page";
		String fail="Unable to locate \"Info\"  Column Name in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(tblListInfo);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//div[contains(text(),'ENTER MISSING CASHBACK DETAILS')]")
	private static WebElement lblEnterMissingCashbackDetails;

	//This method verify "ENTER MISSING CASHBACK DETAILS" Step 4 in Missing Cash back Page
	public WPMissingTicket verifyEnterMissingCashbackDetailsLabelIsVisible() {
		String locator="Locating \"ENTER MISSING CASHBACK DETAILS\" Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"ENTER MISSING CASHBACK DETAILS\" Label in Missing Cashback Page";
		String fail="Unable to locate \"ENTER MISSING CASHBACK DETAILS\"  Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(lblEnterMissingCashbackDetails);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//em[contains(text(),'Sorry, we don’t see any clicks from your account on this date. Please select a valid date of transaction or you can reach us at')]")
	private static WebElement errorMsgWeDontSeeAnyClicks;

	//This method verify "Sorry, we don’t see any clicks from your account on this date. Please select a valid date of transaction or you can reach us at" in Missing Cash back Page
	public WPMissingTicket verifySorryWeDontSeeAnyClickErrorMsgIsVisible() {
		String locator="Locating \"Sorry, we don’t see any clicks from your account on this date. Please select a valid date of transaction or you can reach us at\" Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"Sorry, we don’t see any clicks from your account on this date. Please select a valid date of transaction or you can reach us at\" Label in Missing Cashback Page";
		String fail="Unable to locate \"Sorry, we don’t see any clicks from your account on this date. Please select a valid date of transaction or you can reach us at\"  Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(errorMsgWeDontSeeAnyClicks);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//label[contains(text(),'Your Transaction ID*:')]")
	private static WebElement lblYourTransactionID;

	//This method verify presence of "Your Transaction ID*:" in Missing Cash back Page
	public WPMissingTicket verifyYourTransactionIDIsVisible() {
		String locator="Locating \"Your Transaction ID*:\" Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"Your Transaction ID*:\" Label in Missing Cashback Page";
		String fail="Unable to locate \"Your Transaction ID*:\"  Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(lblYourTransactionID);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//label[contains(text(),'Total Amount Paid (Without Discount)*:')]")
	private static WebElement lblTotalAmountPaid;

	//This method verify presence of "Total Amount Paid (Without Discount)*:" in Missing Cash back Page
	public WPMissingTicket verifyTotalAmountPaidLabelIsVisible() {
		String locator="Locating \"Total Amount Paid (Without Discount)*:\" Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"Total Amount Paid (Without Discount)*:\" Label in Missing Cashback Page";
		String fail="Unable to locate \"Total Amount Paid (Without Discount)*:\"  Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(lblTotalAmountPaid);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//input[@class='error_b']")
	private static WebElement errorInUpload;

	//This method verify presence of "Total Amount Paid (Without Discount)*:" in Missing Cash back Page
	public WPMissingTicket verifyErrorInUploadIsVisible() {
		String locator="Locating \"Error In Upload \" Input in Missing Cashback Page";
		String pass="Successfully verified presence of \"Error In Upload \" Input in Missing Cashback Page";
		String fail="Unable to locate \"Error In Upload \" Input in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(errorInUpload);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	@FindBy(xpath="//em[contains(text(),'Please Accept Terms')]")
	private static WebElement errMsgPleaseAcceptTerms;
	
	public WPMissingTicket verifyPleaseAcceptTermsErrorMsgIsVisible() {
		String locator="Locating \"Please Accept Terms \" error message in Missing Cashback Page";
		String pass="Successfully verified presence of \"Please Accept Terms \" error message in Missing Cashback Page";
		String fail="Unable to locate \"Please Accept Terms\" error message in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(errMsgPleaseAcceptTerms);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//label[contains(text(),'Coupon Code Used')]")
	private static WebElement lblCouponCodeUsed;

	//This method verify "Coupon Code Used" in Missing Cash back Page
	public WPMissingTicket verifyCouponCodeUsedIsVisible() {
		String locator="Locating \"Coupon Code Used\" Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"Coupon Code Used\" Label in Missing Cashback Page";
		String fail="Unable to locate \"Coupon Code Used\"  Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(lblCouponCodeUsed);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//label[contains(text(),'Details of Transaction')]")
	private static WebElement lblDetailsOfTransaction;

	//This method verify presence of "Details of Transaction" in Missing Cash back Page
	public WPMissingTicket verifyDetailsOfTransactionLabelIsVisible() {
		String locator="Locating \"Details of Transaction\" Label in Missing Cashback Page";
		String pass="Successfully verified presence of \"Details of Transaction\" Label in Missing Cashback Page";
		String fail="Unable to locate \"Details of Transaction\"  Label in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(lblDetailsOfTransaction);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="iconCheckBox")
	private static WebElement chkBoxTermsAndConditions;

	//This method click "Terms & Conditions Check Box" in Missing Cash back Page
	public WPMissingTicket clickChkBoxTermsAndConditions() {
		String locator="Locating \"Terms & Conditions Check Box\" in Missing Cashback Page";
		String pass="Successfully Clicked \"Terms & Conditions Check Box\" in Missing Cashback Page";
		String fail="Unable to locate \"Terms & Conditions Check Box\" in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(chkBoxTermsAndConditions)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//a[contains(text(),'SELECT')]")
	private static WebElement lnkSelect;

	//This method click "SELECT Link" in Missing Cash back Page
	public WPMissingTicket clickSelectLink() {
		String locator="Locating \"SELECT Link\" in Missing Cashback Page";
		String pass="Successfully Clicked \"SELECT Link\" in Missing Cashback Page";
		String fail="Unable to locate \"SELECT Link\" in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(Utils.explicitWaitForClick(lnkSelect)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="btnAddTicket")
	private static WebElement btnSubmit;

	//This method click "Submit Button" in Missing Cash back Page
	public WPMissingTicket clickSubmitButton() {
		String locator="Locating \"Submit Button\" in Missing Cashback Page";
		String pass="Successfully Clicked \"Submit Button\" in Missing Cashback Page";
		String fail="Unable to locate \"Submit Button\" in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(btnSubmit)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//article/ul/li/strong)[1]")
	private static WebElement lblDateValue;
	
	public WPMissingTicket verifyValueOfDate(String date) {
		String locator="Locating \"Value Of Date\" in Missing Cashback Page";
		String pass="Successfully validated \"Value Of Date is : \" "+date+" in Missing Cashback Page";
		String fail="Unable to locate \"Value Of Date: \" "+date+" in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(lblDateValue.getText().trim().toString().equals(date)) {
			Log.info(pass +date);
			reportStep(pass  +date, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//article/ul/li/strong)[2]")
	private static WebElement lblRetailerName;
	
	public WPMissingTicket verifyNameOfRetailer(String retailerName) {
		String locator="Locating \"Name Of Retailer\" in Missing Cashback Page";
		String pass="Successfully validated \"Name Of Retailer is \" "+retailerName+" in Missing Cashback Page";
		String fail="Unable to locate \"Name Of Retailer:\" "+retailerName+" in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(lblRetailerName.getText().toString().equals(retailerName)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//article/ul/li/strong)[3]")
	private static WebElement lblTransactionAmountValue;
	
	public WPMissingTicket verifyTransactionAmountValue(String transactionAmountValue) {
		String locator="Locating \"Value Of Transaction Amount\" in Missing Cashback Page";
		String pass="Successfully validated \"Value Of Transaction Amount\":" +transactionAmountValue+" in Missing Cashback Page";
		String fail="Unable to locate \"Value Of Transaction Amount\" " +transactionAmountValue+" in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		String actual=lblTransactionAmountValue.getText().toString();
		actual=Utils.extractOnlyNumber(actual);
		transactionAmountValue=transactionAmountValue+"00"; // 00 is added because .00 gets added by default
		if(actual.equals(transactionAmountValue)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//a[contains(text(),'View')])[1]")
	private static WebElement lnkViewTicket;
	
	public WPMissingTicket clickViewTicketLink() {
		String locator="Locating \"View Ticket link\" in Missing Cashback Page";
		String pass="Successfully Clicked \"View Ticket link\" in Missing Cashback Page";
		String fail="Unable to locate \"View Ticket link\" in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		Utils.sleep();
		if(Utils.jsClick(lnkViewTicket, driver)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//p[contains(text(),'Your cashback query has been submitted successfully. You can track the status of your query under Cashback Tickets.')]")
	private static WebElement successMessageSubmitTicket;

	//This method will verify presence of "Your cash back query has been submitted successfully. You can track the status of your query under Cashback Tickets." in Missing Cash back Page
	public WPMissingTicket verifyPresenceOfsuccessMessageSubmitTicket() {
		String locator="Locating \"Your cashback query has been submitted successfully. You can track the status of your query under Cashback Tickets.\" message in Missing Cashback Page";
		String pass="Successfully verified presence of  \"Your cashback query has been submitted successfully. You can track the status of your query under Cashback Tickets.\"  message in Missing Cashback Page";
		String fail="Unable to locate \"Your cashback query has been submitted successfully. You can track the status of your query under Cashback Tickets.\" message in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(successMessageSubmitTicket);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//strong[contains(.,'Sent to retailer')]")
	private static WebElement lblSentToRetailer;
	//This method will verify presence of "Sent To Retailer" status of Ticket in Missing Cash back Page
		public WPMissingTicket verifyPresenceOfSentToRetailerStatus() {
			String locator="Locating \"Sent To Retailer\" status of Ticket in Missing Cashback Page";
			String pass="Successfully verified presence of  \"Sent To Retailer\"  status of Ticket in Missing Cashback Page";
			String fail="Unable to locate \"Sent To Retailer\" status of Ticket in Missing Cashback Page";
			Log.info(locator);
			reportStep(locator, "INFO");
			presence=Utils.verifyElementPresence(lblSentToRetailer);
			if(presence) {
				Log.info(pass);
				reportStep(pass, "PASS");
			}else {
				Log.info(fail);
				reportStep(fail, "FAIL");
			}
			return this;
		}
		
		@FindBy(xpath="//strong[contains(.,'Received')]")
		private static WebElement lblReceived;
		//This method will verify presence of "Received" status of Ticket in Missing Cash back Page
			public WPMissingTicket verifyPresenceOfReceivedStatus() {
				String locator="Locating \"Received\" status of Ticket in Missing Cashback Page";
				String pass="Successfully verified presence of  \"Received\"  status of Ticket in Missing Cashback Page";
				String fail="Unable to locate \"Received\" status of Ticket in Missing Cashback Page";
				Log.info(locator);
				reportStep(locator, "INFO");
				presence=Utils.verifyElementPresence(lblReceived);
				if(presence) {
					Log.info(pass);
					reportStep(pass, "PASS");
				}else {
					Log.info(fail);
					reportStep(fail, "FAIL");
				}
				return this;
			}
	
			@FindBy(xpath="//strong[contains(.,'Resolved')]")
			private static WebElement lblResolved;
			//This method will verify presence of "Resolved" status of Ticket in Missing Cash back Page
				public WPMissingTicket verifyPresenceOfResolvedStatus() {
					String locator="Locating \"Resolved\" status of Ticket in Missing Cashback Page";
					String pass="Successfully verified presence of  \"Resolved\"  status of Ticket in Missing Cashback Page";
					String fail="Unable to locate \"Resolved\" status of Ticket in Missing Cashback Page";
					Log.info(locator);
					reportStep(locator, "INFO");
					presence=Utils.verifyElementPresence(lblResolved);
					if(presence) {
						Log.info(pass);
						reportStep(pass, "PASS");
					}else {
						Log.info(fail);
						reportStep(fail, "FAIL");
					}
					return this;
				}
	@FindBy(xpath="//p[contains(text(),'If you did a transaction via us & did not get the qualifying Cashback')]")
	private static WebElement infoMessageIfYouDidATransaction;

	//This method will verify presence of  "If you did a transaction via us & did not get the qualifying Cashback/Rewards, don't worry! Just raise a Missing Cashback/Rewards ticket & our team will escalate your transaction to the retailer. Please note that retailers only accept Missing Cashback/Rewards claims for the last 10 days." in Missing Cash back Page
	public WPMissingTicket verifyPresenceOfinfoMessageIfYouDidATransaction() {
		String locator="Locating \"If you did a transaction via us & did not get the qualifying Cashback/Rewards, don't worry! Just raise a Missing Cashback/Rewards ticket & our team will escalate your transaction to the retailer. Please note that retailers only accept Missing Cashback/Rewards claims for the last 10 days.\" message in Missing Cashback Page";
		String pass="Successfully verified presence of  \"If you did a transaction via us & did not get the qualifying Cashback/Rewards, don't worry! Just raise a Missing Cashback/Rewards ticket & our team will escalate your transaction to the retailer. Please note that retailers only accept Missing Cashback/Rewards claims for the last 10 days.\"  message in Missing Cashback Page";
		String fail="Unable to locate \"If you did a transaction via us & did not get the qualifying Cashback/Rewards, don't worry! Just raise a Missing Cashback/Rewards ticket & our team will escalate your transaction to the retailer. Please note that retailers only accept Missing Cashback/Rewards claims for the last 10 days.\" message in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(infoMessageIfYouDidATransaction);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//p[contains(text(),'Your cashback query reply has been submitted successfully.')]")
	private static WebElement infoMessageQuerySubmittedSuccessFully;

	//This method will verify presence of  "Your cashback query reply has been submitted successfully." in Missing Cash back Page
	public WPMissingTicket verifyPresenceOfinfoMessageQuerySubmittedSuccessFully() {
		String locator="Locating \"Your cashback query reply has been submitted successfully.\" message in Missing Cashback Page";
		String pass="Successfully verified presence of  \"Your cashback query reply has been submitted successfully.\"  message in Missing Cashback Page";
		String fail="Unable to locate \"Your cashback query reply has been submitted successfully.\" message in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.verifyElementPresence(infoMessageQuerySubmittedSuccessFully);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="cboxClose")
	private static WebElement btnClose;

	//This method will click close Icon In Pop Up
	public WPMissingTicket clickCloseIconInPopUp() {
		String locator="Locating \"close Icon In Pop Up\" in Missing Cashback Page";
		String pass="Successfully \"clicked close Icon In Pop Up\"  in Missing Cashback Page";
		String fail="Unable to locate \"close Icon In Pop Up\"  in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.click(btnClose);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="lnkAddTicket")
	private static WebElement lnkAddTicket;

	//This method will click close Icon In Pop Up
	public WPMissingTicket clickAddTicketLink() {
		String locator="Locating \"Add Ticket Link\" in Missing Cashback Page";
		String pass="Successfully \"clicked Add Ticket Link\"  in Missing Cashback Page";
		String fail="Unable to locate \"Add Ticket Link\"  in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.click(lnkAddTicket);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="lnkSubmit")
	private static WebElement lnkSubmit;

	//This method will click Submit Link
	public WPMissingTicket clickSubmitButtonForReply() {
		String locator="Locating \"Submit Link\" in Missing Cashback Page";
		String pass="Successfully \"clicked Submit Link\"  in Missing Cashback Page";
		String fail="Unable to locate \"Submit Link\"  in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		presence=Utils.click(lnkSubmit);
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="reply_txt")
	private static WebElement txtAreaReply;

	//This method will enter text 
	public WPMissingTicket enterInReplyTextArea() {
		String locator="Locating \"Text Area Reply\" in Missing Cashback Page";
		String pass="Successfully entered : Automation \" in Text Area Reply\"  in Missing Cashback Page";
		String fail="Unable to locate \"Text Area Reply\"  in Missing Cashback Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		Utils.explicitWaitForVisibility(txtAreaReply);
		presence=Utils.sendKeys(txtAreaReply, "Automation");
		if(presence) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
}
