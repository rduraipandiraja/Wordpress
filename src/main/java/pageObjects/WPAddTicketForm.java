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

public class WPAddTicketForm extends TestSetUp{
	private static boolean presence=false;
	public static final Logger log = LogManager.getLogger(WPAddTicketForm.class);
	public WPAddTicketForm(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;
		String info="Loading Add Ticket Form";
		String pass="Successfully loaded Add Ticket Form";
		String fail="Unable to Load Add Ticket Form";
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info(info);
		reportStep(info, "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(txtBxTransactionDate));
			Log.info(pass);
			reportStep(pass, "PASS");
		} catch (Exception e) {
			reportStep(fail, "FAIL");
			Log.error(fail);
		} 
	}
	
	@FindBy(id="cboxClose")
	private static WebElement btnClose;
	
	public WPMissingTicket clickCloseIconInPopUp() {
		String locator="Locating \"close Icon In Pop Up\" in Add Ticket Form";
		String pass="Successfully \"clicked close Icon In Pop Up\"  in Add Ticket Form";
		String fail="Unable to locate \"close Icon In Pop Up\"  in Add Ticket Form";
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
		return new WPMissingTicket(driver, logger);
	}
	
	@FindBy(id="transaction_date")
	private static WebElement txtBxTransactionDate;

	//This method will click Date of transaction Text Box
	public WPAddTicketForm clickDateOfTransactionTextBox() {
		String locator="Locating \"Date Of Transaction\" Text Box in Add Ticket Form";
		String pass="Successfully clicked \"Date Of Transaction\" Text Box in Add Ticket Form";
		String fail="Unable to Locate \"Date Of Transaction\" Text Box in Add Ticket Form";
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
	public WPAddTicketForm clickTodaysDateInDatePicker() {
		String locator="Locating \"Today's Date\" in Date Picker in Add Ticket Form";
		String pass="Successfully clicked \"Today's Date\" in Date Picker  in Add Ticket Form";
		String fail="Unable to Locate \"Today's Date\" in Date Picker  in Add Ticket Form";
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
	public WPAddTicketForm clickFourDaysBackDate() {
		String locator="Locating \"Four Days Back Date\" in Date Picker in Add Ticket Form";
		String pass="Successfully clicked \"Four Days Back Date\" in Date Picker  in Add Ticket Form";
		String fail="Unable to Locate \"Four Days Back Date\" in Date Picker  in Add Ticket Form";
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
	public WPAddTicketForm enterTransactionId(String transactionId) {
		String locator="Locating \"Transaction Id :\" "+transactionId+"  in Text Box in Add Ticket Form";
		String pass="Successfully entered  " +transactionId+ " \"Transaction Id\" in Text Box in Add Ticket Form";
		String fail="Unable to Locate \"Transaction Id : \" "+transactionId+"Text Box in Add Ticket Form";
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
	public WPAddTicketForm enterTotalAmountPaid(String totalAmountPaid) {
		String locator="Locating \"Total Amount Paid\" in Text Box in Add Ticket Form";
		String pass="Successfully entered  " +totalAmountPaid+ " \"Total Amount Paid\" in Text Box of Add Ticket Form";
		String fail="Unable to Locate \"Total Amount Paid: \" "+totalAmountPaid+" in Text Box of Add Ticket Form";
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
	
	public WPAddTicketForm uploadFile(String path) {
		String locator="Locating \"Choose File\"  in Add Ticket Form";
		String pass="Successfully  \"Uploaded file\" from "+path+"  in Add Ticket Form";
		String fail="Unable to Locate \"Choose File\"  in Add Ticket Form";
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
	public WPAddTicketForm enterCouponCodeUsed(String couponCodeUsed) {
		String locator="Locating \"Coupon Code Used\" in Text Box in Add Ticket Form";
		String pass="Successfully entered  " +couponCodeUsed+ " \"Coupon Code Used\" in Text Box in Add Ticket Form";
		String fail="Unable to Locate \"Coupon Code Used\" Text Box in Add Ticket Form";
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
	public WPAddTicketForm enterTransactionDetails(String transactionDetails) {
		String locator="Locating \"Transaction Details\" in Text Area in Add Ticket Form";
		String pass="Successfully entered  " +transactionDetails+ " \"Transaction Details\" in Text Area in Add Ticket Form";
		String fail="Unable to enter \"Transaction Details: \" "+transactionDetails+" Text Area in Add Ticket Form";
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
	public WPAddTicketForm verifyDateOfTransactionLabelIsVisible() {
		String locator="Locating Date Of Transaction Label in Add Ticket Form";
		String pass="Successfully verified presence of \"Date Of Transaction\" Label in Add Ticket Form";
		String fail="Unable to locate \"Date Of Transaction\" Label in Add Ticket Form";
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
	public WPAddTicketForm verifyEnterDateOfTransactionLabelIsVisible() {
		String locator="Locating \"Enter The Date Of Transaction\" Label in Add Ticket Form";
		String pass="Successfully verified presence of \"Enter The Date Of Transaction\" Label in Add Ticket Form";
		String fail="Unable to locate \"Enter The Date Of Transaction\" Label in Add Ticket Form";
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
	public WPAddTicketForm verifyRetailerYouShoppedAtLabelIsVisible() {
		String locator="Locating \"RETAILER YOU SHOPPED AT\" Label in Add Ticket Form";
		String pass="Successfully verified presence of \"RETAILER YOU SHOPPED AT\" Label in Add Ticket Form";
		String fail="Unable to locate \"RETAILER YOU SHOPPED AT\" Label in Add Ticket Form";
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
	public WPAddTicketForm selectFirstRetailerDropDropDownListInMissingCashBackPage() {
		String locator="Locating \"Select Retailer Drop Drop Down List\" in Add Ticket Form";
		String pass="Successfully selected \"Retailer  From Drop Drop Down List\" in Add Ticket Form. Retailer selected is : ";
		String fail="Unable to locate \"Select Retailer Drop Drop Down List\" in Add Ticket Form";
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
	public WPAddTicketForm verifySelectExitClickAndTransactionDetailsLabelIsVisible() {
		String locator="Locating \"SELECT EXIT CLICK & TRANSACTION DETAILS\" Label in Add Ticket Form";
		String pass="Successfully verified presence of \"SELECT EXIT CLICK & TRANSACTION DETAILS\" Label in Add Ticket Form";
		String fail="Unable to locate \"SELECT EXIT CLICK & TRANSACTION DETAILS\" Label in Add Ticket Form";
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
	public WPAddTicketForm verifylblHaveMultipleClickSameRetailersLabelIsVisible() {
		String locator="Locating \"Have multiple exit clicks for the same retailer? Select any one and we will take care of the rest!\" Label in Add Ticket Form";
		String pass="Successfully verified presence of \"Have multiple exit clicks for the same retailer? Select any one and we will take care of the rest!\" Label in Add Ticket Form";
		String fail="Unable to locate \"Have multiple exit clicks for the same retailer? Select any one and we will take care of the rest!\" Label in Add Ticket Form";
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

	//This method verify Exit Click Time Column Name in Add Ticket Form
	public WPAddTicketForm verifyExitClickTimeTableColumnIsVisible() {
		String locator="Locating \"Exit Click Time\" Column Name in Add Ticket Form";
		String pass="Successfully verified presence of \"Exit Click Time\" Column Name in Add Ticket Form";
		String fail="Unable to locate \"Exit Click Time\"  Column Name in Add Ticket Form";
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

	//This method verify Transaction ID Column Name in Add Ticket Form
	public WPAddTicketForm verifyTransactionIdTableColumnIsVisible() {
		String locator="Locating \"Transaction ID\" Column Name in Add Ticket Form";
		String pass="Successfully verified presence of \"Transaction ID\" Column Name in Add Ticket Form";
		String fail="Unable to locate \"Transaction ID\"  Column Name in Add Ticket Form";
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

	//This method verify Transaction Amount Column Name in Add Ticket Form
	public WPAddTicketForm verifyTransactionAmountTableListIsVisible() {
		String locator="Locating \"Transaction Amount\" Column Name in Add Ticket Form";
		String pass="Successfully verified presence of \"Transaction Amount\" Column Name in Add Ticket Form";
		String fail="Unable to locate \"Transaction Amount\"  Column Name in Add Ticket Form";
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
	public WPAddTicketForm verifyEarningsTableListIsVisible() {
		String locator="Locating \"Earnings\" Column Name in Add Ticket Form";
		String pass="Successfully verified presence of \"Earnings\" Column Name in Add Ticket Form";
		String fail="Unable to locate \"Earnings\"  Column Name in Add Ticket Form";
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
	public WPAddTicketForm verifyCouponDetailsTableListIsVisible() {
		String locator="Locating \"Coupon Details\" Column Name in Add Ticket Form";
		String pass="Successfully verified presence of \"Coupon Details\" Column Name in Add Ticket Form";
		String fail="Unable to locate \"Coupon Details\"  Column Name in Add Ticket Form";
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
	public WPAddTicketForm verifyStatusTableListIsVisible() {
		String locator="Locating \"Status\" Column Name in Add Ticket Form";
		String pass="Successfully verified presence of \"Status\" Column Name in Add Ticket Form";
		String fail="Unable to locate \"Status\"  Column Name in Add Ticket Form";
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
	public WPAddTicketForm verifyInfoTableListIsVisible() {
		String locator="Locating \"Info\" Column Name in Add Ticket Form";
		String pass="Successfully verified presence of \"Info\" Column Name in Add Ticket Form";
		String fail="Unable to locate \"Info\"  Column Name in Add Ticket Form";
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
	public WPAddTicketForm verifyEnterMissingCashbackDetailsLabelIsVisible() {
		String locator="Locating \"ENTER MISSING CASHBACK DETAILS\" Label in Add Ticket Form";
		String pass="Successfully verified presence of \"ENTER MISSING CASHBACK DETAILS\" Label in Add Ticket Form";
		String fail="Unable to locate \"ENTER MISSING CASHBACK DETAILS\"  Label in Add Ticket Form";
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
	public WPAddTicketForm verifySorryWeDontSeeAnyClickErrorMsgIsVisible() {
		String locator="Locating \"Sorry, we don’t see any clicks from your account on this date. Please select a valid date of transaction or you can reach us at\" Label in Add Ticket Form";
		String pass="Successfully verified presence of \"Sorry, we don’t see any clicks from your account on this date. Please select a valid date of transaction or you can reach us at\" Label in Add Ticket Form";
		String fail="Unable to locate \"Sorry, we don’t see any clicks from your account on this date. Please select a valid date of transaction or you can reach us at\"  Label in Add Ticket Form";
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
	public WPAddTicketForm verifyYourTransactionIDIsVisible() {
		String locator="Locating \"Your Transaction ID*:\" Label in Add Ticket Form";
		String pass="Successfully verified presence of \"Your Transaction ID*:\" Label in Add Ticket Form";
		String fail="Unable to locate \"Your Transaction ID*:\"  Label in Add Ticket Form";
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
	public WPAddTicketForm verifyTotalAmountPaidLabelIsVisible() {
		String locator="Locating \"Total Amount Paid (Without Discount)*:\" Label in Add Ticket Form";
		String pass="Successfully verified presence of \"Total Amount Paid (Without Discount)*:\" Label in Add Ticket Form";
		String fail="Unable to locate \"Total Amount Paid (Without Discount)*:\"  Label in Add Ticket Form";
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
	public WPAddTicketForm verifyErrorInUploadIsVisible() {
		String locator="Locating \"Error In Upload \" Input in Add Ticket Form";
		String pass="Successfully verified presence of \"Error In Upload \" Input in Add Ticket Form";
		String fail="Unable to locate \"Error In Upload \" Input in Add Ticket Form";
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
	
	public WPAddTicketForm verifyPleaseAcceptTermsErrorMsgIsVisible() {
		String locator="Locating \"Please Accept Terms \" error message in Add Ticket Form";
		String pass="Successfully verified presence of \"Please Accept Terms \" error message in Add Ticket Form";
		String fail="Unable to locate \"Please Accept Terms\" error message in Add Ticket Form";
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
	public WPAddTicketForm verifyCouponCodeUsedIsVisible() {
		String locator="Locating \"Coupon Code Used\" Label in Add Ticket Form";
		String pass="Successfully verified presence of \"Coupon Code Used\" Label in Add Ticket Form";
		String fail="Unable to locate \"Coupon Code Used\"  Label in Add Ticket Form";
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
	public WPAddTicketForm verifyDetailsOfTransactionLabelIsVisible() {
		String locator="Locating \"Details of Transaction\" Label in Add Ticket Form";
		String pass="Successfully verified presence of \"Details of Transaction\" Label in Add Ticket Form";
		String fail="Unable to locate \"Details of Transaction\"  Label in Add Ticket Form";
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
	public WPAddTicketForm clickChkBoxTermsAndConditions() {
		String locator="Locating \"Terms & Conditions Check Box\" in Add Ticket Form";
		String pass="Successfully Clicked \"Terms & Conditions Check Box\" in Add Ticket Form";
		String fail="Unable to locate \"Terms & Conditions Check Box\" in Add Ticket Form";
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
	public WPAddTicketForm clickSelectLink() {
		String locator="Locating \"SELECT Link\" in Add Ticket Form";
		String pass="Successfully Clicked \"SELECT Link\" in Add Ticket Form";
		String fail="Unable to locate \"SELECT Link\" in Add Ticket Form";
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
	public WPAddTicketForm clickSubmitButton() {
		String locator="Locating \"Submit Button\" in Add Ticket Form";
		String pass="Successfully Clicked \"Submit Button\" in Add Ticket Form";
		String fail="Unable to locate \"Submit Button\" in Add Ticket Form";
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
	
		
	@FindBy(xpath="//p[contains(text(),'Your cashback query has been submitted successfully. You can track the status of your query under Cashback Tickets.')]")
	private static WebElement successMessageSubmitTicket;

	//This method will verify presence of "Your cash back query has been submitted successfully. You can track the status of your query under Cashback Tickets." in Missing Cash back Page
	public WPAddTicketForm verifyPresenceOfsuccessMessageSubmitTicket() {
		String locator="Locating \"Your cashback query has been submitted successfully. You can track the status of your query under Cashback Tickets.\" message in Add Ticket Form";
		String pass="Successfully verified presence of  \"Your cashback query has been submitted successfully. You can track the status of your query under Cashback Tickets.\"  message in Add Ticket Form";
		String fail="Unable to locate \"Your cashback query has been submitted successfully. You can track the status of your query under Cashback Tickets.\" message in Add Ticket Form";
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
		public WPAddTicketForm verifyPresenceOfSentToRetailerStatus() {
			String locator="Locating \"Sent To Retailer\" status of Ticket in Add Ticket Form";
			String pass="Successfully verified presence of  \"Sent To Retailer\"  status of Ticket in Add Ticket Form";
			String fail="Unable to locate \"Sent To Retailer\" status of Ticket in Add Ticket Form";
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
		


	@FindBy(xpath="//p[contains(text(),'If you did a transaction via us & did not get the qualifying Cashback')]")
	private static WebElement infoMessageIfYouDidATransaction;

	//This method will verify presence of  "If you did a transaction via us & did not get the qualifying Cashback/Rewards, don't worry! Just raise a Missing Cashback/Rewards ticket & our team will escalate your transaction to the retailer. Please note that retailers only accept Missing Cashback/Rewards claims for the last 10 days." in Missing Cash back Page
	public WPAddTicketForm verifyPresenceOfinfoMessageIfYouDidATransaction() {
		String locator="Locating \"If you did a transaction via us & did not get the qualifying Cashback/Rewards, don't worry! Just raise a Missing Cashback/Rewards ticket & our team will escalate your transaction to the retailer. Please note that retailers only accept Missing Cashback/Rewards claims for the last 10 days.\" message in Add Ticket Form";
		String pass="Successfully verified presence of  \"If you did a transaction via us & did not get the qualifying Cashback/Rewards, don't worry! Just raise a Missing Cashback/Rewards ticket & our team will escalate your transaction to the retailer. Please note that retailers only accept Missing Cashback/Rewards claims for the last 10 days.\"  message in Add Ticket Form";
		String fail="Unable to locate \"If you did a transaction via us & did not get the qualifying Cashback/Rewards, don't worry! Just raise a Missing Cashback/Rewards ticket & our team will escalate your transaction to the retailer. Please note that retailers only accept Missing Cashback/Rewards claims for the last 10 days.\" message in Add Ticket Form";
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
	public WPAddTicketForm verifyPresenceOfinfoMessageQuerySubmittedSuccessFully() {
		String locator="Locating \"Your cashback query reply has been submitted successfully.\" message in Add Ticket Form";
		String pass="Successfully verified presence of  \"Your cashback query reply has been submitted successfully.\"  message in Add Ticket Form";
		String fail="Unable to locate \"Your cashback query reply has been submitted successfully.\" message in Add Ticket Form";
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
	
	
	
	
	
	@FindBy(id="lnkSubmit")
	private static WebElement lnkSubmit;

	//This method will click Submit Link
	public WPMissingTicket clickSubmitButtonForReply() {
		String locator="Locating \"Submit Link\" in Add Ticket Form";
		String pass="Successfully \"clicked Submit Link\"  in Add Ticket Form";
		String fail="Unable to locate \"Submit Link\"  in Add Ticket Form";
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
		return new WPMissingTicket(driver, logger);
	}
}
