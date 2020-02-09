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

import testData.StoreTestData;

import org.json.simple.parser.JSONParser;
import utility.TestSetUp;
import utility.Log;
import utility.Utils;

public class WPStorePage extends TestSetUp{
	public static final Logger log = LogManager.getLogger(WPStorePage.class);
	public static JSONParser ObjJparser = new JSONParser();

	//Constructor
	public WPStorePage(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.debug("Loading the Store page");
		reportStep("Loading the Store page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(imgStoreImage));
			Log.debug("Successfully landed on the Store page");
			reportStep("Successfully landed on the Store page ", "PASS");
		} catch (Exception e) {
			Log.error("Not able to land on the Store page");
			reportStep("Not able to land on the Store page", "FAIL");
		} 
	}

	@FindBy(id="imgStore")
	private static WebElement imgStoreImage;
	
	@FindBy(id="lnkStoreTermsConditions")
	private static WebElement lnkMainCtaActivateCashback;

	//Click Main CTA 
	public WPSignUpSignInPopUp clickMainCtaActivateCashBackLink() {
		try {
			Log.info("Locating Main CTA Activate Cashback Link on Store Page");
			reportStep("Locating Main CTA Activate Cashback Link on Store Page", "INFO");
			Utils.explicitWaitForClick(lnkMainCtaActivateCashback);
			Log.info("Clicked Successfully Main CTA Activate Cashback Link on Store Page");
			reportStep("Clicked Successfully Main CTA Activate Cashback Link on Store Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Main CTA Activate Cashback Link on Store Page");
			reportStep("Unable to click Main CTA Activate Cashback Link on Store Page", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}

	@FindBy(id="lnkTermsConditions0")
	private static WebElement lnkVoucherCtaActivateCashback;

	//Click Voucher CTA
	public WPSignUpSignInPopUp clickVoucherCtaActivateCashBackLink() {
		try {
			Log.debug("Locating Voucher CTA Activate Cashback Link on Store Page");
			reportStep("Locating Voucher CTA Activate Cashback Link on Store Page", "INFO");
			Utils.click(lnkVoucherCtaActivateCashback);
			Log.debug("Clicked Successfully Voucher CTA Activate Cashback Link on Store Page");
			reportStep("Clicked Successfully Voucher CTA Activate Cashback Link on Store Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Voucher CTA Activate Cashback Link on Store Page");
			reportStep("Unable to click Voucher CTA Activate Cashback Link on Store Page", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}

	@FindBy(xpath="(//a[contains(text(),'ACTIVATE CASHBACK')])")
	private static List<WebElement> lnkActivateCashback;

	//Click Activate Cashback
	public WPStorePage clickActivateCashBackInSP() {// SP stands for Stores Page
		try {
			reportStep("Locating Activate Cashback in SP", "INFO");
			Log.info("Locating Activate Cashback in SP ");
			Utils.explicitWaitForVisibility(lnkActivateCashback.get(0));
			Utils.click(lnkActivateCashback.get(0));
			reportStep("Clicked successfully Activate Cashback in SP", "PASS");
			Log.info("Clicked Successfully Activate Cashback in SLP");
		}catch(Exception e) {
			Log.error("Unable to Click  Activate Cashback in SP");
			reportStep("Unable to Click Activate Cashback in SP", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//a[contains(text(),' ACTIVATE REWARDS')])")
	private static List<WebElement> lnkActivateRewards;

	//Click Activate Cashback
	public WPStorePage clickActivateRewardsInSP() {// SP stands for Stores Page
		try {
			reportStep("Locating Activate Rewards in SP", "INFO");
			Log.info("Locating Activate Rewards in SP ");
			Utils.explicitWaitForVisibility(lnkActivateRewards.get(0));
			Utils.click(lnkActivateRewards.get(0));
			reportStep("Clicked successfully Activate Rewards in SP", "PASS");
			Log.info("Clicked Successfully Activate Rewards in SLP");
		}catch(Exception e) {
			Log.error("Unable to Click  Activate Rewards in SP");
			reportStep("Unable to Click Activate Rewards in SP", "FAIL");
		}
		return this;
	}
	
	public WPSignUpSignInPopUp clickActivateRewardsGuestUser() {// SP stands for Stores Page
		try {
			reportStep("Locating Activate Rewards in SP", "INFO");
			Log.info("Locating Activate Rewards in SP ");
			Utils.explicitWaitForVisibility(lnkActivateRewards.get(0));
			Utils.click(lnkActivateRewards.get(0));
			reportStep("Clicked successfully Activate Rewards in SP", "PASS");
			Log.info("Clicked Successfully Activate Rewards in SLP");
		}catch(Exception e) {
			Log.error("Unable to Click  Activate Rewards in SP");
			reportStep("Unable to Click Activate Rewards in SP", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}

	@FindBy(id = "lblStoreShortDes")
	private static WebElement lblStoreShortDescription;

	public  WPStorePage verifyStorePageShortDescriptionText(String shortDesc) {
		String locator="Locating Short Description for Store in Store Page";
		String pass="Successfully verified presence of Short Description for Store in Store Page. It is : "+lblStoreShortDescription.getText();
		String fail="Unable to locate Short Description for Store in Store Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		String shortDescription=new StoreTestData(driver, logger).getRequiredShortDescription(shortDesc);
		if(lblStoreShortDescription.getText().toString().trim().equals(shortDescription)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//p[@id='lblVoucherTitle0']/span")
	private static WebElement lblVoucherTitle;

	public  WPStorePage verifyStorePageVoucherTitleText(String voucherOneName) {
		String locator="Locating Voucher Title for Store in Store Page";
		String pass="Successfully verified presence of Voucher Title for Store in Store Page. It is : "+lblVoucherTitle.getText();
		String fail="Unable to locate Voucher Title for Store in Store Page";
		String voucherTitle=new StoreTestData(driver, logger).getVoucherOneName(voucherOneName);
		Log.info(locator);
		reportStep(locator, "INFO");
		System.out.println(voucherTitle);
		System.out.println(lblVoucherTitle.getText().toString());
		if(lblVoucherTitle.getText().toString().trim().equals(voucherTitle)) 
		{
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lblPrimaryCashbackDetails")
	private static WebElement lblPrimaryCashbackDetails;

	public  WPStorePage verifyStorePagePrimaryCashBackDetailsText(String primaryCashBack) {
		String locator="Locating Primary CashBack Details for Store in Store Page";
		String pass="Successfully text of Primary CashBack Details for Store in Store Page. It is : "+lblPrimaryCashbackDetails.getText();
		String fail="Unable to locate text of Primary CashBack Details .It is : "+lblPrimaryCashbackDetails.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		String primaryCashBackDetail=new StoreTestData(driver, logger).getRequiredPrimaryCashbackDetails(primaryCashBack);
		if(lblPrimaryCashbackDetails.getText().toString().trim().equals(primaryCashBackDetail)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="(//span[contains(text(),'Exclusive: Expires in')])[1]")
	private static WebElement lblPrimaryCalenderCashbackExpiresIn;

	public  WPStorePage verifyStorePagePrimaryCalenderCashBackExpiresIn() {
		String locator="Locating \" Exclusive : Expires in ** days\" for Primary CashBack in Store Page";
		String pass="Successfully verified presence of \" Exclusive : Expires in ** days\" for Primary Calender CashBack in Store Page. It is : "+lblPrimaryCalenderCashbackExpiresIn.getText();
		String fail="Unable to locate text : \" Exclusive : Expires in ** days\" for Primary Calender CashBack Details in Store Page. It is : " +lblPrimaryCalenderCashbackExpiresIn.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblPrimaryCalenderCashbackExpiresIn)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="(//span[contains(text(),'Exclusive: Expires in')])[2]")
	private static WebElement lblSecondaryCalenderCashbackExpiresIn;

	public  WPStorePage verifyStorePageSecondaryCalenderCashBackExpiresIn() {
		String locator="Locating \" Exclusive : Expires in ** days\" for Secondary Calender CashBack in Store Page";
		String pass="Successfully verified presence of \" Exclusive : Expires in ** days\" for Secondary Calender CashBack in Store Page. It is : "+lblSecondaryCalenderCashbackExpiresIn.getText();
		String fail="Unable to locate text : \" Exclusive : Expires in ** days\" for Secondary Calender CashBack Details in Store Page. It is : " +lblSecondaryCalenderCashbackExpiresIn.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblSecondaryCalenderCashbackExpiresIn)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="(//span[contains(text(),'Increased: Expires in')])[1]")
	private static WebElement lblPrimaryCalenderIncreasedExpiresIn;

	public  WPStorePage verifyStorePagePrimaryCalenderIncreasedExpiresIn() {
		String locator="Locating \" Increased : Expires in ** days\" for Primary CashBack CashBack in Store Page";
		String pass="Successfully verified presence of \" Increased : Expires in ** days\" for Primary Calender CashBack in Store Page. It is : "+lblPrimaryCalenderIncreasedExpiresIn.getText();
		String fail="Unable to locate text : \" Increased : Expires in ** days\" for Primary Calender CashBack Details in Store Page. It is : " +lblPrimaryCalenderIncreasedExpiresIn.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblPrimaryCalenderIncreasedExpiresIn)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//span[contains(text(),'Increased') and contains(text(),'Expires in')])[1]")
	private static WebElement lblPrimaryCalenderRewardsIncreasedExpiresIn;

	public  WPStorePage verifyStorePagePrimaryRewardsCalenderIncreasedExpiresIn() {
		String locator="Locating \" Increased : Expires in ** days\" for Primary CashBack CashBack in Store Page";
		String pass="Successfully verified presence of \" Increased : Expires in ** days\" for Primary Calender CashBack in Store Page. It is : "+lblPrimaryCalenderRewardsIncreasedExpiresIn.getText();
		String fail="Unable to locate text : \" Increased : Expires in ** days\" for Primary Calender CashBack Details in Store Page. It is : " +lblPrimaryCalenderRewardsIncreasedExpiresIn.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblPrimaryCalenderRewardsIncreasedExpiresIn)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="(//span[contains(text(),'Increased: Expires in')])[2]")
	private static WebElement lblSecondaryCalenderIncreasedExpiresIn;

	public  WPStorePage verifyStorePageSecondaryCalenderIncreasedExpiresIn() {
		String locator="Locating \" Increased : Expires in ** days\" for Secondary Calender CashBack in Store Page";
		String pass="Successfully verified presence of \" Increased : Expires in ** days\" for Secondary Calender CashBack in Store Page. It is : "+lblSecondaryCalenderIncreasedExpiresIn.getText();
		String fail="Unable to locate text : \" Increased : Expires in ** days\" for Secondary Calender CashBack Details in Store Page. It is : " +lblSecondaryCalenderIncreasedExpiresIn.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblSecondaryCalenderIncreasedExpiresIn)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//span[contains(text(),'Increased') and contains(text(),'Expires in')])[2]")
	private static WebElement lblSecondaryRewardsCalenderIncreasedExpiresIn;

	public  WPStorePage verifyStorePageSecondaryRewardsCalenderIncreasedExpiresIn() {
		String locator="Locating \" Increased : Expires in ** days\" for Secondary Calender CashBack in Store Page";
		String pass="Successfully verified presence of \" Increased : Expires in ** days\" for Secondary Calender CashBack in Store Page. It is : "+lblSecondaryRewardsCalenderIncreasedExpiresIn.getText();
		String fail="Unable to locate text : \" Increased : Expires in ** days\" for Secondary Calender CashBack Details in Store Page. It is : " +lblSecondaryRewardsCalenderIncreasedExpiresIn.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblSecondaryRewardsCalenderIncreasedExpiresIn)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lblSecondaryCashbackDetails0")
	private static WebElement lblSecondaryCashbackDetails;

	public  WPStorePage verifyStorePageSecondaryCashBackDetailsText(String secondaryCashBackDetails) {
		String locator="Locating Secondary CashBack Details for Store in Store Page";
		String pass="Successfully verified text of Secondary CashBack Details for Store in Store Page. It is : "+lblSecondaryCashbackDetails.getText();
		String fail="Unable to locate text of Secondary CashBack Details .It is : "+lblSecondaryCashbackDetails.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		String secCashBackDetails=new StoreTestData(driver, logger).getRequiredSecondaryCashbackDetails(secondaryCashBackDetails);
		if(lblSecondaryCashbackDetails.getText().toString().trim().equals(secCashBackDetails)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lblSecondaryCashbackDetails1")
	private static WebElement lblSecondSecondaryCashBackDetails;

	public  WPStorePage verifyStorePageSecondSecondaryCashBackDetailsText(String secondaryCashBackDetails) {
		String locator="Locating 2nd Secondary CashBack Details for Store in Store Page";
		String pass="Successfully verified text of 2nd Secondary CashBack Details for Store in Store Page. It is : "+lblSecondSecondaryCashBackDetails.getText();
		String fail="Unable to locate text of 2nd Secondary CashBack Details .It is : "+lblSecondSecondaryCashBackDetails.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		String secCashBackDetails=new StoreTestData(driver, logger).getRequiredSecondaryCashbackDetails(secondaryCashBackDetails);
		if(lblSecondSecondaryCashBackDetails.getText().toString().trim().equals(secCashBackDetails)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	@FindBy(id="lblPrimaryCashback")
	private static WebElement lblPrimaryCashbackValue;

	public  WPStorePage verifyStorePagePrimaryCashbackValueText(String primaryCashBackValue) {
		String locator="Locating text of Primary CashBack Value for Store in Store Page.";
		String pass="Successfully verified value of text of Primary CashBack Value for Store in Store Page. It is : "+lblPrimaryCashbackValue.getText();
		String fail="Unable to locate text of Primary CashBack Value for Store in Store Page.It is : "+lblPrimaryCashbackValue.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		String primaryCashbackValueExpected=new StoreTestData(driver, logger).getRequiredPrimaryCashbackValue(primaryCashBackValue);
		String primaryCashbackValueActual=Utils.extractOnlyNumber(lblPrimaryCashbackValue.getText().toString().trim());
		if(primaryCashbackValueActual.equals(primaryCashbackValueExpected)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lblSecondaryCashback0")
	private static WebElement lblSecondaryCashbackValue;

	public  WPStorePage verifyStorePageSecondaryCashbackValueText(String secondaryCashBackValue) {
		String locator="Locating text of Secondary CashBack Value for Store in Store Page.";
		String pass="Successfully verified value of text of Secondary CashBack Value for Store in Store Page. It is : "+lblSecondaryCashbackValue.getText();
		String fail="Unable to locate text of Secondary CashBack Value for Store in Store Page.It is : "+lblSecondaryCashbackValue.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		String secCashBackValue=new StoreTestData(driver, logger).getRequiredSecondaryCashbackValue(secondaryCashBackValue);
		String secondaryCashbackValue=Utils.extractOnlyNumber(lblSecondaryCashbackValue.getText().toString().trim());
		if(secondaryCashbackValue.equals(secCashBackValue)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lblSecondaryCashback1")
	private static WebElement lblSecondSecondaryCashBackValue;

	public  WPStorePage verifyStorePageSecondSecondaryCashbackValueText(String secondSecondaryCashBackValue) {
		String locator="Locating text of 2nd Secondary CashBack Value for Store in Store Page.";
		String pass="Successfully verified value of text of 2nd Secondary CashBack Value for Store in Store Page. It is : "+lblSecondSecondaryCashBackValue.getText();
		String fail="Unable to locate text of 2nd Secondary CashBack Value for Store in Store Page.It is : "+lblSecondSecondaryCashBackValue.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		String secCashBackValue=new StoreTestData(driver, logger).getRequiredSecondaryCashbackValue(secondSecondaryCashBackValue);
		String secondaryCashbackValue=Utils.extractOnlyNumber(lblSecondSecondaryCashBackValue.getText().toString().trim());
		if(secondaryCashbackValue.equals(secCashBackValue)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//p[@id='lblVoucherTitle1']/span")
	private static WebElement lblVoucherTwoName;

	public  WPStorePage verifyStorePageVoucherTwoText(String voucherTwoName) {
		String locator="Locating text of Secondary CashBack Value for Store in Store Page.";
		String pass="Successfully verified value of text of Secondary CashBack Value for Store in Store Page. It is : "+lblVoucherTwoName.getText();
		String fail="Unable to locate text of Secondary CashBack Value for Store in Store Page.It is : "+lblVoucherTwoName.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		String secondVoucherName=new StoreTestData(driver, logger).getRequiredVoucherName(voucherTwoName);
		if(secondVoucherName.equals(lblVoucherTwoName.getText().toString())) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	@FindBy(id="lnkCashbackRates")
	private static WebElement lnkShowCashBackRates;

	public  WPStorePage clickLinkShowCashbackRates() {
		String locator="Locating Show Cashback Rates Link in Store Page";
		String pass="Successfully clicked Show Cashback Rates Link in Store Page";
		String fail="Unable to locate Show Cashback Rates Link in Store Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkShowCashBackRates)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lnkCashbackRates")
	private static WebElement lnkHideCashBackRates;

	public  WPStorePage clickLinkHideCashbackRates() {
		String locator="Locating Hide Cashback Rates Link in Store Page";
		String pass="Successfully clicked Hide Cashback Rates Link in Store Page";
		String fail="Unable to locate Hide Cashback Rates Link in Store Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkHideCashBackRates)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lnkVoucherDescription1")
	private static WebElement lnkSeeOrHideDetailsForSecondVoucher;

	public  WPStorePage clickLinkSeeOrHideDetailsForSecondVoucher() {
		String locator="Locating See Or Hide Details For Second Voucher Link in Store Page";
		String pass="Successfully clicked See Or Hide Details For Second Voucher Link in Store Page";
		String fail="Unable to locate See Or Hide Details For Second Voucher Link in Store Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkSeeOrHideDetailsForSecondVoucher)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lnkVoucherDescription0")
	private static WebElement lnkSeeOrHideDetailsForFirstVoucher;

	public  WPStorePage clickLinkSeeOrHideDetailsForFirstVoucher() {
		String locator="Locating See Or Hide Details For First Voucher Link in Store Page";
		String pass="Successfully clicked See Or Hide Details For First Voucher Link in Store Page";
		String fail="Unable to locate See Or Hide Details For First Voucher Link in Store Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkSeeOrHideDetailsForFirstVoucher)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//span[contains(text(),'COPY CODE')]")
	private static WebElement lblCopyCode;

	public  WPStorePage clickCopyCode() {
		String locator="Locating Copy Code Label in Store Page";
		String pass="Successfully clicked \"Copy Code \" Label in Store Page";
		String fail="Unable to locate \"Copy Code\" Label in Store Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lblCopyCode)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//span[contains(text(),'COPIED')]")
	private static WebElement lblCopied;

	public  WPStorePage verifyCouponCodeIsCopied() {
		String locator="Locating \"COPIED\" Label in Store Page";
		String pass="Successfully verified presence of \"COPIED \" Label in Store Page";
		String fail="Unable to locate \"COPIED\" Label in Store Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblCopied)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lblVoucherDescription0")
	private static WebElement lblFirstVoucherDescription;

	public  WPStorePage verifyFirstVoucherDescriptionText(String voucherOneDescription) {
		String locator="Locating Voucher Description For First Voucher in Store Page";
		String pass="Successfully verified text of Voucher Description For First Voucher in Store Page. It is: " +lblFirstVoucherDescription.getText().toString();
		String fail="Unable to locate Voucher Description For First Voucher in Store Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		String firstVoucherDescription=new StoreTestData(driver, logger).getVoucherOneDescription(voucherOneDescription);
		if(lblFirstVoucherDescription.getText().toString().equals(firstVoucherDescription)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lblVoucherDescription1")
	private static WebElement lblSecondVoucherDescription;

	public  WPStorePage verifySecondVoucherDescriptionText(String voucherTwoDescription) {
		String locator="Locating Voucher Description For Second Voucher in Store Page";
		String pass="Successfully verified text of Voucher Description For Second Voucher in Store Page. It is: " +lblFirstVoucherDescription.getText().toString();
		String fail="Unable to locate Voucher Description For Second Voucher in Store Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		String secondVoucherDescription=new StoreTestData(driver, logger).getVoucherTwoDescription(voucherTwoDescription);
		if(lblSecondVoucherDescription.getText().toString().equals(secondVoucherDescription)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	public  WPStorePage verifyCouponCodeText(String voucherCode) {
		String locator="Fetching text in clipboard and storing in an String Object";
		String pass="Successfully verified text of Coupon Code . Actual Is : " ;
		String fail="Text Copied to clipboad is not matching with what is copied in Clipboard. Expected Was : ";
		Log.info(locator);
		reportStep(locator, "INFO");
		String couponCode=new StoreTestData(driver, logger).getRequiredVoucherCode(voucherCode);
		String codeCopied=Utils.getClipBoardText();
		if(codeCopied.equals(couponCode)) {
			Log.info(pass+codeCopied);
			reportStep(pass+codeCopied, "PASS");
		}else {
			Log.info(fail+couponCode);
			reportStep(fail+couponCode, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="(//div[contains(text(),'EXCLUSIVE')])[2]")
	private static WebElement lblExclusiveOfferType;

	public  WPStorePage verifyExclusiveLabelInStorePage() {
		String locator="Locating text of Exclusive Label in Store Page.";
		String pass="Successfully verified presence of Exclusive Label in Store Page. Text is : "+lblExclusiveOfferType.getText();
		String fail="Unable to locate text of Exclusive Label in Store Page.It is : "+lblExclusiveOfferType.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblExclusiveOfferType)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	@FindBy(id="iconVoucherDescClose0")
	private static WebElement iconClose;
	
	public  WPStorePage clickCloseIcon() {
		String locator="Locating close icon in Store Page.";
		String pass="Successfully clicked close icon";
		String fail="Unable to locate close icon in Store Page";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(iconClose)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[contains(text(),'INCREASED')])[1]")
	private static WebElement lblIncreasedOfferType;

	public  WPStorePage verifyIncreasedLabelInStorePage() {
		String locator="Locating text of Increased Label in Store Page.";
		String pass="Successfully verified presence of Increased Label in Store Page. Text is : "+lblIncreasedOfferType.getText();
		String fail="Unable to locate text of Increased Label in Store Page.It is : "+lblIncreasedOfferType.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblIncreasedOfferType)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="(//div[contains(text(),'Coupons Cashback & Rewards')])[1]")
	private static WebElement lblVoucherHeading;

	public  WPStorePage verifyVoucherHeadingLabelInStorePage() {
		String locator="Locating text of Voucher Heading Label in Store Page.";
		String pass="Successfully verified presence of Voucher Heading Label in Store Page. Text is : "+lblVoucherHeading.getText();
		String fail="Unable to locate text of Voucher Heading Label in Store Page.It is : "+lblVoucherHeading.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(lblVoucherHeading)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//article[contains(@class,'newuser')]")
	private static List<WebElement> newUserStoreModule;


	public  int countNumberOfNewUserVoucherCard() {
		String locator="Locating Number Of New User Voucher Card in Store Page.";
		String pass="Successfully Counted number Number Of New User Voucher Card in Store Page. It is: " +newUserStoreModule.size();
		String fail="Unable to locate Number Of New User Voucher Card in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(newUserStoreModule.size()!=0) {
			Log.info(pass);
			reportStep(pass, "PASS");
			return newUserStoreModule.size();
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return newUserStoreModule.size();
	}
	@FindBy(xpath="//article")
	private static List<WebElement> allUserStoreModule;

	public  int countNumberOfAllUserVoucherCard() {
		String locator="Locating Number Of All User Voucher Card in Store Page.";
		String pass="Successfully Counted number Number Of All User Voucher Card in Store Page. It is: " +allUserStoreModule.size();
		String fail="Unable to locate Number Of All User Voucher Card in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(allUserStoreModule.size()!=0) {
			Log.info(pass);
			reportStep(pass, "PASS");
			return allUserStoreModule.size();
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return allUserStoreModule.size();
	}

	public WPStorePage verifyAllUserNewUserRadioButtonFucntionality() {
		String info="Validating count of \" New User Voucher Card \" should be less than count of all user Voucher Card count";
		String pass="Count of \"New User Voucher Card \" is less than count of \"All user Voucher Card\" count";
		String fail="Count of New User Voucher Card is equal to count of all user Voucher Card count";
		Log.info(info);
		reportStep(info, "INFO");
		clickAllNewRadioButton();
		int newUserCount=countNumberOfNewUserVoucherCard();
		clickAllUserRadioButton();
		int allUserCount=countNumberOfAllUserVoucherCard();
		if(allUserCount>newUserCount) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}

	@FindBy(id="lblAllUser")
	private static WebElement rdBtnAllUser;
	public WPStorePage clickAllUserRadioButton() {
		String locator="Locating Radio Button For all users in Store Page.";
		String pass="Successfully clicked Radio Button For all users in Store Page.";
		String fail="Unable to locate Radio Button For all users in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.explicitWaitForClick(rdBtnAllUser)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="lblNewUser")
	private static WebElement rdBtnNewUser;
	public WPStorePage clickAllNewRadioButton() {
		String locator="Locating Radio Button For New users in Store Page.";
		String pass="Successfully clicked Radio Button For New users in Store Page.";
		String fail="Unable to locate Radio Button For New users in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.explicitWaitForClick(rdBtnNewUser)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//strong[@id='lblPrimaryCashback' and contains(text(),'%')]")
	private static WebElement percentageSymbolPrimaryCashBack;
	
	public  WPStorePage verifyPercentageSymbolPrimaryCashBack() {
		String locator="Locating text of % symbol in Primary cashback.";
		String pass="Successfully verified presence of % symbol in Primary cashback. Text is : "+percentageSymbolPrimaryCashBack.getText();
		String fail="Unable to locate text of % symbol in Primary cashback.It is : "+percentageSymbolPrimaryCashBack.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(percentageSymbolPrimaryCashBack)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//strong[@id='lblSecondaryCashback0' and contains(text(),'%')]")
	private static WebElement percentageSymbolSecondaryCashBack;
	
	public  WPStorePage verifyPercentageSymbolSecondaryCashBack() {
		String locator="Locating text of % symbol in Secondary cashback.";
		String pass="Successfully verified presence of % symbol in Secondary cashback. Text is : "+percentageSymbolSecondaryCashBack.getText();
		String fail="Unable to locate text of % symbol in Secondary cashback.It is : "+percentageSymbolSecondaryCashBack.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(percentageSymbolSecondaryCashBack)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//strong[@id='lblPrimaryCashback' and contains(text(),'₹')]")
	private static WebElement currencySymbolPrimaryCashBack;
	
	public  WPStorePage verifyCurrencySymbolPrimaryCashBack() {
		String locator="Locating text of Currency symbol in Primary cashback.";
		String pass="Successfully verified presence of Currency symbol in Primary cashback. Text is : "+currencySymbolPrimaryCashBack.getText();
		String fail="Unable to locate text of Currency symbol in Primary cashback.It is : "+currencySymbolPrimaryCashBack.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(currencySymbolPrimaryCashBack)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//strong[@id='lblSecondaryCashback0' and contains(text(),'Rs.')]")
	private static WebElement currencySymbolSecondaryCashBack;
	
	public  WPStorePage verifyCurrencyeSymbolSecondaryCashBack() {
		String locator="Locating text of Currency symbol in Secondary cashback.";
		String pass="Successfully verified presence of Currency symbol in Secondary cashback. Text is : "+currencySymbolSecondaryCashBack.getText();
		String fail="Unable to locate text of Currency symbol in Secondary cashback.It is : "+currencySymbolSecondaryCashBack.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(currencySymbolSecondaryCashBack)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//p[contains(text(),'Sorry, there are no offers available for ') and contains(text(),' currently. Please check back after some time.')]")
	private static WebElement infoNoOffersAvailableMsg;
	
	public  WPStorePage verifyMessageNoOffersAvailableIsDisplayed(String storeName) {
		String locator="Locating text of \"Sorry, there are no offers available for "+storeName+" currently. Please check back after some time.\"";
		String pass="Successfully verified presence of \"Sorry, there are no offers available for "+storeName+" currently. Please check back after some time.\"";
		String fail="Unable to locate \"Sorry, there are no offers available for "+storeName+" currently. Please check back after some time.\"";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.verifyElementPresence(infoNoOffersAvailableMsg)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//a[contains(text(),'GRAB DEAL')]")
	private static List<WebElement> lnkGrabDeal;
	
	public  WPIntermediaryPage clickGrabDealLink(int i) {
		String locator="Locating Grab Deal in Store Page.";
		String pass="Successfully clicked Grab Deal in Store Page.";
		String fail="Unable to locate Grab Deal in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkGrabDeal.get(i))) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return new WPIntermediaryPage(driver, logger);
	}
	
	@FindBy(xpath= "//span[contains(text(),'CASHBACK')]")
	private static WebElement lnkCashbackCategory;
	
	public  WPStorePage clickCashbackCategory() {
		String locator="Locating Cashback Category in Store Page.";
		String pass="Successfully clicked Cashback Category in Store Page.";
		String fail="Unable to locate Cashback Category in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkCashbackCategory)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath= "//span[contains(text(),'REWARDS')]")
	private static WebElement lnkRewardsCategory;
	
	public  WPStorePage clickRewardsCategory() {
		String locator="Locating Rewards Category in Store Page.";
		String pass="Successfully clicked Rewards Category in Store Page.";
		String fail="Unable to locate Rewards Category in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkRewardsCategory)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath= "//span[text()='All']")
	private static WebElement lnkAllCategory;
	
	public  WPStorePage clickAllCategory() {
		String locator="Locating All Category in Store Page.";
		String pass="Successfully clicked All Category in Store Page.";
		String fail="Unable to locate All Category in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkAllCategory)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath= "//span[contains(text(),'NETWORK')]")
	private static WebElement lnkNetworkEighteenCategory;
	
	public  WPStorePage clickNetworkEighteenCategory() {
		String locator="Locating Network Eighteen Category in Store Page.";
		String pass="Successfully clicked Network Eighteen Category in Store Page.";
		String fail="Unable to locate Network Eighteen Category in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkNetworkEighteenCategory)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="lnkCategoryList")
	private static WebElement lnkCategoryList;
	
	public  WPStorePage clickCategoriesList() {
		String locator="Locating Categories Drop Down in Store Page.";
		String pass="Successfully Categories Drop Down in Store Page.";
		String fail="Unable to locate Categories Drop Down in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkCategoryList)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//article[@style!='display: none;']")
	private static List<WebElement> categoryVisibleVoucherCard;

	public  int countNumberOfVisibleVoucherCard() {
		String locator="Locating Number Of All User Voucher Card in Store Page.";
		String pass="Successfully Counted number Number Of All User Voucher Card in Store Page. It is: " +categoryVisibleVoucherCard.size();
		String fail="Unable to locate Number Of All User Voucher Card in Store Page.";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(categoryVisibleVoucherCard.size()!=0) {
			Log.info(pass);
			reportStep(pass, "PASS");
			return categoryVisibleVoucherCard.size();
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return categoryVisibleVoucherCard.size();
	}
	
}


