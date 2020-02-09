package pageObjects;

import java.util.List;

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

public class WPJoinFree extends TestSetUp{
	public static final Logger log = LogManager.getLogger(WPJoinFree.class);
	public WPJoinFree(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		String info="Trying to open Join Free Page.";
		String pass="Successfully open Join Free Page.";
		String fail="Unable to open Join Free Page.";
		Log.info(info);
		reportStep(info, "INFO");
			if(Utils.verifyElementPresence(txtBxEmailJoinFree)) {
				Log.info(pass);
				reportStep(pass, "PASS");
			}else {
				Log.error(fail);
				reportStep(fail, "FAIL");
			}

	}

	
	@FindBy(id="email")
	private static WebElement txtBxEmailJoinFree;
	
	@FindBy(name="uname")
	private static WebElement txtBxEmail;
	
	//Verifying Email Placeholder Value
	public WPJoinFree verifyEmailPlaceHolderValueJoinFree() {
		try {
			reportStep("Trying to fetch Placeholder value", "INFO");
			Log.info("Trying to fetch Placeholder value");
			Utils.verifyPlaceHolderValue(txtBxEmail, "*Please enter a valid email address");
			reportStep("Able to fetch Placeholder value", "PASS");
			Log.info("Able to fetch Placeholder value");
		}catch(Exception e) {
			reportStep("Unable to fetch Placeholder value", "FAIL");
			Log.error("Unable to fetch Placeholder value");
		}
		return this;
	}
	
	//verify Max Character Allowed In Email Field
	public WPJoinFree verifyMaxCharacterAllowedInEmailField() {
		try {
			// Below line needs to be changed while Test Scripting
			String expected="50";
			reportStep("Trying to fetch password attribute max-length", "INFO");
			Log.info("Trying to fetch password attribute max");
			String actual=txtBxEmail.getAttribute("maxlength").toString();
			if(! actual.equals(expected)) {
				throw new InterruptedException("Max Length is not 50 in Email Address field");
			}
			reportStep("Max Length is 50 in password field", "PASS");
			Log.info("Max Length is 50 in password field");
		}catch(Exception e) {
			Log.fatal("Max Length is not 50 in Email field");
			reportStep("Max Length is not 50 in Email field", "FAIL");
		}
		return this;
	}

	@FindBy(name="pwd")
	private static WebElement txtBxPassword;

	//	//verify Max Character Allowed In Password Field
	public WPJoinFree verifyMaxCharacterInPasswordField() {
		try {
			// Below line needs to be changed while Test Scripting
			String expected="20";
			reportStep("Trying to fetch password attribute max", "INFO");
			Log.info("Trying to enter password in Password field");
			String actual=txtBxPassword.getAttribute("maxlength").toString();
			if(! actual.equals(expected)) {
				throw new InterruptedException("Max Length is not 20 in password field");
			}
			reportStep("Max Length is 20 in password field", "PASS");
			Log.info("Max Length is 20 in password field");
		}catch(Exception e) {
			Log.fatal("Max Length is not 20 in password field");
			reportStep("Max Length is not 20 in password field", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//*[contains(text(),'The username/password is invalid.')]")
	private static WebElement errMsgInvalidUserPwd;

	//Verify Presence of error message
	public WPJoinFree verifyPresenceOfErrorMsg() throws Exception{
		try {
			reportStep("Verifying presence of error message in case user enters wrong email id or password is present on Join Free Page", "INFO");
			Log.info("Verifying presence of error message in case user enters wrong email id or password is present on Join Free Page");
			Utils.verifyElementPresence(errMsgInvalidUserPwd);
			reportStep("Verification completed presence of error message in case user enters wrong email id or password is present on Join Free Page", "PASS");
			Log.info("Verification completed presence of error message in case user enters wrong email id or password is present on Join Free Page");
		}catch(Exception e) {
			reportStep("Verification completed unsuccessfully presence of error message in case user enters wrong email id or password is present on Join Free Page", "FAIL");
			Log.info("Verification completed unsuccessfully presence of error message in case user enters wrong email id or password is present on Join Free Page");
		}
		return this;
	}
	
	@FindBy(xpath="//*[contains(text(),'Please enter valid Email.')]")
	private static WebElement errMsgBlankEmailID;

	// Verify presence of Blank Email error messAGE
	public WPJoinFree verifyPresenceOfErrorMsgBlankEmail() throws Exception{
		try {
			reportStep("Verifying presence of error message in case user don't enter any email id during Join Free", "INFO");
			Log.info("Verifying presence of error message in case user don't enter any email id during Join Free");
			Utils.verifyElementPresence(errMsgBlankEmailID);
			reportStep("Verification completed presence of error message in case user don't enter any email id during Join Free", "PASS");
			Log.info("Verification completed presence of error message in case user don't enter any email id during Join Freee");
		}catch(Exception e) {
			reportStep("Verification completed unsuccessfully presence of error message in case user don't enter any email id during Join Free", "FAIL");
			Log.info("Verification completed unsuccessfully presence of error message in case user don't enter any email id during Join Free");
		}
		return this;
	}
	
	@FindBy(xpath="//*[contains(text(),'Please enter valid password.')]")
	private static WebElement errMsgBlankPassword;

	// Verify presence of Blank Password error messAGE
	public WPJoinFree verifyPresenceOfErrorMsgBlankPwd() throws Exception{
		try {
			reportStep("Verifying presence of error message in case user don't enter any password  during Join Free", "INFO");
			Log.info("Verifying presence of error message in case user don't enter any password  during Join Free");
			Utils.verifyElementPresence(errMsgBlankPassword);
			reportStep("Verification completed presence of error message in case user don't enter any email  during Join Free", "PASS");
			Log.info("Verification completed presence of error message in case user don't enter any email during Join Freee");
		}catch(Exception e) {
			reportStep("Verification completed unsuccessfully presence of error message in case user don't enter any password during Join Free", "FAIL");
			Log.info("Verification completed unsuccessfully presence of error message in case user don't enter any password during Join Free");
		}
		return this;
	}

	@FindBy(id="login_msg")
	private static WebElement errMsgLoginForm;

	//// Verify presence of Blank Email and password error messAGE
	public void verifyErrorMsgInCaseBothUserNamePwdBlank() {
		String expectedValue1="Please enter valid Email.";
		String expectedValue2="Please enter valid password.";
		reportStep("Fetching actual Result from the Login Form", "INFO");
		Log.info("Fetching actual Result from the Login Form");
		String actualValue=errMsgLoginForm.getText().toString().trim();
		Log.info("Fetched actual Result from the Login Form");
		reportStep("Fetched actual Result from the Login Form", "PASS");
		if(actualValue.contains(expectedValue1) && actualValue.contains(expectedValue2) ) {
			Log.info("Error message has been compared and actual result is equal to expected result");
			reportStep("Error message has been compared and actual result is equal to expected result", "PASS");
		}else {
			Log.info("Error message has been compared and actual result is unequal to expected result");
			reportStep("Error message has been compared and actual result is unequal to expected result", "FAIL");
		}
	}

	//Verify Error message is displayed
	public WPJoinFree verifyCountOfErrorMessages() {
		try {
			reportStep("Trying to locate the error message on Login Form", "INFO");
			Log.info("Trying to locate the error message on Login Form");
			if(errMsgLoginForm.isDisplayed()) {
				throw new InterruptedException("Error message are still displaying on Join Free Page. It should goes off after reset");
			}
			reportStep("Reset Functionality of Join Free Page are working properly","PASS");
		}catch(Exception e) {
			Log.error("Error message are still displaying on Join Free Page. It should goes off after reset");
			reportStep("Error message are still displaying on Join Free Page. It should goes off after reset","FAIL");
		}
		return this;
	}

	@FindBy(xpath="(//input[@class='form_control error'])[1]")
	private static List<WebElement> errorMsgJoinFree;
	//Verify Count Of Error Message During Join Free
	public WPJoinFree verifyCountOfErrorMessagesInJoinFree() {
		try {
			reportStep("Trying to locate the error message on Join Free Form", "INFO");
			Log.info("Trying to locate the error message on Join Free Form");
			int size=errorMsgJoinFree.size();
			if(size>0) {
				throw new InterruptedException("Error message are still displaying on Join Free Page. It should goes off after reset");
			}
			Log.info("Reset Functionality of Join Free Page are working properly");
			reportStep("Reset Functionality of Join Free Page are working properly","PASS");
		}catch(Exception e) {
			Log.error("Error message are still displaying on Join Free Page. It should goes off after reset");
			reportStep("Error message are still displaying on Join Free Page. It should goes off after reset","FAIL");
		}
		return this;
	}
	
	
	@FindBy(xpath="//div[@id='secRightSignIn']//a[text()='Join Free']")
	private static WebElement lnkJoinFree;

	//Verify Join Free Tab on Login Form
	public WPJoinFree verifySignInLinkOnLoginFrom() {
		try {
			reportStep("Locating Join Free Link of Join Free Page","INFO");
			Log.info("Locating Join Free Link of Join Free Page");
			boolean presence = Utils.verifyElementPresence(lnkJoinFree);
			if(presence==false) {
				throw new InterruptedException("Join Free Link of Join Free Page is not visible");
			}
			reportStep("Verified presence of Join Free Link of Join Free Page","PASS");
			Log.info("Verified presence of Join Free Link of Join Free Page");
		}catch(Exception e) {
			reportStep("Join Free Link of Join Free Page was not visible","FAIL");
			Log.fatal("Join Free Link of Join Free Page was not visible");
		}
		return this;
	}
	
	@FindBy(id="firstname")
	private static WebElement txtBxFullName;
	
	public WPJoinFree verifyPlaceholderValueFullNameDuringJoinFree() {
		reportStep("Verifying Placeholder value of Full Name text box in Join Free Page","INFO");
		Log.info("Verifying Placeholder value of Full Name text box in Join Free Page");
		Utils.explicitWaitForVisibility(txtBxFullName);
		if(txtBxFullName.getAttribute("value").equals("Please type your name")) {
			reportStep("Verifyied Successfully Placeholder value of Full Name text box in Join Free Page","PASS");
			Log.info("Verifyied Successfully Placeholder value of Full Name text box in Join Free Page");
		}else {
			Log.info("Unable to Verify Placeholder value of Full Name text box in Join Free Page");
			reportStep("Unable to Verify Placeholder value of Full Name text box in Join Free Page","FAIL");
		}
		return this;
	}
	//Fetch Console value of Full Name Textbox
	public WPJoinFree verifyValueOfFullNameTextBox(String expected) {
		reportStep("Verifying Placeholder value of Full Name text box in Join Free Page","INFO");
		Log.info("Verifying Placeholder value of Full Name text box in Join Free Page");
		//String actual=Utils.fetchConsoleValue("#firstname", driver);
		if(txtBxFullName.getAttribute("value").equals(expected)) {
			reportStep("Verifyied Successfully value of Full Name text box in Join Free Page","PASS");
			Log.info("Verifyied Successfully value of Full Name text box in Join Free Page");
		}else {
			Log.info("Unable to Verify value of Full Name text box in Join Free Page");
			reportStep("Unable to Verify value of Full Name text box in Join Free Page","FAIL");
		}
		return this;
	}
	
	//Verifying expected value of full name
	public WPJoinFree verifyErrorMessageForFullNameJoinFree() {
		String expected= Utils.getTestData(1, "errorFullName");
		String actual=Utils.fetchConsoleValue("#firstname", driver);
		Log.info("Verifying actual vs Expected value");
		reportStep("Verifying actual vs Expected value","INFO");
		if(actual.equals(expected)) {
			Log.info("Verified Error message successfully for Full Name text box in Join Free Page. Actual is "+actual+" and expected was "+expected);
			reportStep("Verified Error message successfully for Full Name text box in Join Free PageActual is "+actual+" and expected was "+expected,"PASS");
		}else {
			Log.info("Unable to Verify Error message for Full Name text box in Join Free Page. Actual is "+actual+" but expected was "+expected);
			reportStep("Unable to Verify Error message for Full Name text box in Join Free PageActual is "+actual+" but expected was "+expected,"ERROR");
		}
		return this;
	}
	
	@FindBy(id="invalidOtp")
	private static WebElement lblInvalidOtp;

	public WPJoinFree verifyLabelInvalidOtp() {
		Log.info("Fetching Invalid otp Label on OTP Form during Join Free");
		reportStep("Fetching Invalid otp Label on OTP Form during Join Free","INFO");
		Utils.explicitWaitForVisibility(lblInvalidOtp);
		String expected="Invalid OTP code";
		String actual=lblInvalidOtp.getText();
		if(expected.equals(actual)) {
			Log.info("Fetching Invalid otp Label on OTP Form during Join Free");
			reportStep("Fetching Invalid otp Label on OTP Form during Join Free","PASS");
		}else {
			Log.info(actual +" is actual Invalid otp Label but expected text should be "+expected+" on OTP Form during Join Free");
			reportStep("actual +\" is actual Invalid otp Label but expected text should be \"+expected+\" on OTP Form during Join Free","FAIL");
		}
		return this;
	}
	public WPJoinFree clearOtpField() {
		Log.info("Clearing OTP Field after entering OTP");
		reportStep("Clearing OTP Field after entering OTP","INFO");
		try {
			txtBxOTP.clear();
			Log.info("Cleared the OTP Field after entering OTP");
			reportStep("Cleared the OTP Field after entering OTP","PASS");
		}catch(Exception e) {
			e.printStackTrace();
			Log.info("Unable to Clear the OTP Field after entering OTP");
			reportStep("Unable to Clear the OTP Field after entering OTP","FAIL");
		}
		return this;
	}
	
	public WPJoinFree clickVerifyOTPFail() {
		Log.info("Clicking Verify OTP  during Join Free");
		reportStep("Clicking Verify OTP  Button during Join Free","INFO");
		if(Utils.explicitWaitForClick(btnVerifyOTP)) {
			Log.info("Clicked successfully Verify OTP  Button during Join Free");
			reportStep("Clicked successfully Verify OTP  Button during Join Free","PASS");
		}else {
			Log.info("Unable to Click Verify OTP  Button during Join Free");
			reportStep("Unable to Click Verify OTP  Button during Join Free","FAIL");
		}
		return this;
	}

	@FindBy(id="otp")
	private static WebElement txtBxOTP;

	//Enter OTP in otp text box
	public WPJoinFree enterOtpDuringJoinFree(String mobile) {
		Log.info("Entering OTP in OTP Text Box during Join Free");
		reportStep("Entering OTP in OTP Text Box during Join Free","INFO");
		String otp=Utils.getOTPCode(mobile, driver);
		if(Utils.sendKeys(txtBxOTP, otp)) {
			Log.info("Entered Successfully OTP-- "+otp+" in OTP Text Box during Join Free");
			reportStep("Entered Successfully OTP-- "+otp+" in OTP Text Box during Join Free","PASS");
		}else {
			Log.info("Unable to Enter OTP in OTP Text Box during Join Free");
			reportStep("Unable to Enter OTP in OTP Text Box during Join Free","FAIL");
		}
		return this;
	}

	public WPJoinFree explicitWaitForOTPTxtBox() {
		Log.info("Waiting for OTP text Box");
		//reportStep("Waiting for OTP text Box","INFO");
		Utils.explicitWaitForVisibility(txtBxOTP);
		Log.info("Explicitly waited for OTP text box.");
		//reportStep("Explicitly waited for OTP text box.","PASS");

		return this;
	}

	@FindBy(id="btnLayoutVerifyOTP")
	private static WebElement btnVerifyOTP;

	//Click Verify OTP after entering OTP
	public WPHomePage clickVerifyOTP() {
		Log.info("Clicking Verify OTP  during Join Free");
		reportStep("Clicking Verify OTP  Button during Join Free","INFO");
		if(Utils.explicitWaitForClick(btnVerifyOTP)) {
			Log.info("Clicked successfully Verify OTP  Button during Join Free");
			reportStep("Clicked successfully Verify OTP  Button during Join Free","PASS");
		}else {
			Log.info("Unable to Click Verify OTP  Button during Join Free");
			reportStep("Unable to Click Verify OTP  Button during Join Free","FAIL");
		}
		return new WPHomePage(driver,logger);
	}

	@FindBy(xpath = "//em[contains(text(),'Number already in use. Please enter different number.')]")
	private static WebElement errMsgDuplicatePhoneNumber;
	
	@FindBy(xpath = "//em[contains(text(),'An account with this Email ID already exists!')]")
	private static WebElement errMsgDuplicateEmailId;

	//Verify Duplicate Email Error Message
	public WPJoinFree verifyErrorMsgRegisteredEmailJoinFree() {
		Log.info("Verifying Error message if a email is already registered  during Join Free");
		reportStep("Verifying Error message if a email is already registered  during Join Free","INFO");
		Utils.explicitWaitForVisibility(errMsgDuplicateEmailId);
		if(Utils.verifyElementPresence(errMsgDuplicateEmailId)) {
			Log.info("Verified Error message \"An account with this Email ID already exists!\" if a email is already registered  during Join Free");
			reportStep("Verified Error message \"An account with this Email ID already exists!\" if a email is already registered  during Join Free","PASS");
		}else {
			Log.info("Unable to verify Error message \"An account with this Email ID already exists!\" if a email is already registered  during Join Free");
			reportStep("Unable to verify Error message \"An account with this Email ID already exists!\" if a email is already registered  during Join Free","FAIL");
		}
		return this;
	}



	//Verify Error Message if a phone number already exist
	public WPJoinFree verifyErrorMsgRegisteredPhoneJoinFree() {
		Log.info("Verifying Error message if a Phone is already registered  during Join Free");
		reportStep("Verifying Error message if a Phone is already registered  during Join Free","INFO");
		if(Utils.verifyElementPresence(errMsgDuplicatePhoneNumber)) {
			Log.info("Verified Error message \"Number already in use. Please enter different number.\" if a Phone is already registered  during Join Free");
			reportStep("Verified Error message \"Number already in use. Please enter different number.\" if a Phone is already registered  during Join Free","PASS");
		}else {
			Log.info("Unable to verify Error message \"Number already in use. Please enter different number.\" if a email is already registered  during Join Free");
			reportStep("Unable to verify Error message \"Number already in use. Please enter different number.\" if a email is already registered  during Join Free","FAIL");
		}
		return this;
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'Terms & Conditions')]")
	private static WebElement lnkTermsAndConditionsJoinFree;

	//Clicking on Terms and Conditions link on Join Free Form
	public WPTermsAndConditions clickTermsAndConditionsJoinFree() {
		Log.info("Clicking on Terms and Conditions link on Join Free Form");
		reportStep("Clicking on Terms and Conditions link on Join Free Form","INFO");
		if(Utils.click(lnkTermsAndConditionsJoinFree)) {
			Log.info("Clicking on Terms and Conditions link on Join Free Form");
			reportStep("Clicking on Terms and Conditions link on Join Free Form","PASS");
			Utils.switchToNewlyOpenWindow(driver);
		}else {
			Log.info("Unable to Click Terms and Conditions link on Join Free Form");
			reportStep("Unable to Click Terms and Conditions link on Join Free Form","FAIL");
		}
		return new WPTermsAndConditions(driver, logger);
	}
	
	@FindBy(id="resendOTP")
	private static WebElement btnResendOtp;

	//Click Resend OTP Button
	public WPJoinFree clickResendOtpButton() throws InterruptedException {
		Log.info("Waiting for resend Otp button");
		reportStep("Waiting for resend Otp button","INFO");
		Utils.waitForResendOTP(btnResendOtp, driver);
		if(Utils.click(btnResendOtp)) {
			Log.info("Clicked Successfully resend Otp button");
			reportStep("Clicked Successfully resend Otp button","PASS");
		}else {
			Log.info("Unable to click resend Otp button");
			reportStep("Unable to click resend Otp button","FAIL");
		}
		return this;
	}

	@FindBy(id="lblLayoutOTPHead")
	private static WebElement lblEnterOtpSent;

	//Verify the label "Enter the OTP sent to your registered mobile number"  in OTP For Join Free Form
	public WPJoinFree verifyPresenceOfLabelEnterOtpSent() throws InterruptedException {
		Log.info("Verifying Presence of Label- Enter the OTP sent to your registered mobile number");
		reportStep("Verifying Presence of Label- Enter the OTP sent to your registered mobile number","INFO");
		Utils.waitForResendOTP(btnResendOtp, driver);
		if(Utils.verifyElementPresence(lblEnterOtpSent)) {
			Log.info("Verified Presence of Label- Enter the OTP sent to your registered mobile number");
			reportStep("Verified Presence of Label- Enter the OTP sent to your registered mobile number","PASS");
		}else {
			Log.info("Label- Enter the OTP sent to your registered mobile number- is not visible");
			reportStep("Label- Enter the OTP sent to your registered mobile number- is not visible","FAIL");
		}
		return this;
	}

	@FindBy(id="cboxClose")
	public static WebElement lnkCloseOtpPopUp;

	//Close OTP pop UP
	public WPJoinFree closeOtpPopUp() {
		Log.info("Closing OTP Pop Up on OTP Screen");
		reportStep("Closing OTP Pop Up on OTP Screen","INFO");
		if(Utils.click(lnkCloseOtpPopUp)) {
			Log.info("Closed successfully OTP Pop Up on OTP Screen");
			reportStep("Closed successfully OTP Pop Up on OTP Screen","PASS");
		}else {
			Log.info("Unable to Close OTP Pop Up on OTP Screen");
			reportStep("Unable to Close OTP Pop Up on OTP Screen","FAIL");
		}
		return this;
	}
	
	//Entering Full name in Full Name Text Box in Join Free Page
		public WPJoinFree enterFullNameDuringJoinFree(String fullName) {
			reportStep("Entering Full name in Full Name "+ fullName +" Text Box in Join Free Page","INFO");
			Log.info("Entering Full name in Full Name "+ fullName +" Text Box in Join Free Page");
			if(Utils.sendKeys(txtBxFullName, fullName)) {
				reportStep("Entered Full name Successfully in Full Name Text Box in Join Free Page","PASS");
				Log.info("Entered Full name Successfully in Full Name text box in Join Free Page");
			}else {
				Log.info("Unable to Enter "+ fullName +" Full name Successfully in Full Name text box in Join Free Page");
				reportStep("Unable to Enter "+ fullName +" Full name Successfully in Full Name text box in Join Free Page","FAIL");
			}
			return this;
		}
		
		//Entering Email in Email ID text box in Join Free Page
		public WPJoinFree enterEmailIDDuringJoinFree(String email) {
			reportStep("Entering Email in Email ID text box in Join Free Page","INFO");
			Log.info("Entering Email in Email ID text box in Join Free Page");
			if(Utils.sendKeys(txtBxEmailAddressJoinFree, email)) {
				reportStep("Entered Email: "+ email+" in Email ID text box in Join Free Page","PASS");
				Log.info("Entered Email : "+ email+" in Email ID text box in Join Free Page");
			}else {
				Log.info("Unable to Enter Email in Email ID text box in Join Free Page");
				reportStep("Unable to enter Email in Email ID text box in Join Free Page","FAIL");
			}
			return this;
		}
		
		@FindBy(id="pwd-txt")
		private static WebElement txtBxChoosePasswordJoinFree;
		
		public WPJoinFree verifyPlaceholderValuePasswordJoinFree() {
			reportStep("Verifying Placeholder value of Password text box in join Free Page","INFO");
			Log.info("Verifying Placeholder value of Password text box in join Free Page");
			if(txtBxChoosePasswordJoinFree.getAttribute("value").equals("*Enter a password")) {
				reportStep("Verifyied Successfully Placeholder value of Password text box in join Free Page","PASS");
				Log.info("Verifyied Successfully Placeholder value of Password text box in join Free Page");
			}else {
				Log.info("Unable to Verify Placeholder value of Password text box in join Free Page");
				reportStep("Unable to Verify Placeholder value of Password text box in join Free Page","FAIL");
			}
			return this;
		}
		
		@FindBy(id="mobile_number")
		private static WebElement txtBxMobileNumber;
		public WPJoinFree verifyNegativeScenariosForMobileNumberTextBoxJoinFree(String input) {
			reportStep("verifying whether alplhabets and special characters can be entered in mobile number text box of Join Free Page","INFO");
			Log.info("verifying whether alplhabets and special characters can be entered in mobile number text box of Join Free Page");
			Utils.sendKeys(txtBxMobileNumber, input);
			String value = Utils.fetchConsoleValue("#mobile_number", driver);
			if(!value.equals(input)) {
				Log.info("alplhabets and special characters cannot be entered in mobile number text box of Join Free Page");
				reportStep("alplhabets and special characters cannot be entered in mobile number text box of Join Free Page","PASS");
			}else {
				Log.error("alplhabets and special characters can be entered in mobile number text box of Join Free Page");
				reportStep("alplhabets and special characters can be entered in mobile number text box of Join Free Page","ERROR");
				reportStep("Value Entered: " +input+ " Value accepted by textboxes: " +value,"ERROR");
			}
			return this;
		}
		@FindBy(id="join_free_submit")
		private static WebElement btnJoinWithEmail;
		
		//Clicking Join With Email Button during Join Free
		public WPJoinFree clickJoinWithEmailDuringJoinFree() {
			Log.info("Clicking Join With Email Button during Join Free");
			reportStep("Clicking Join With Email Button during Join Free","INFO");
			if(Utils.click(btnJoinWithEmail)) {
				Log.info("Clicked successfully Join With Email Button during Join Free");
				reportStep("Clicked successfully Join With Email Button during Join Free","PASS");
			}else {
				Log.info("Unable to Click Join With Email Button during Join Free");
				reportStep("Unable to Click Join With Email Button during Join Free","FAIL");
			}
			explicitWaitForOTPTxtBox();
			return this;
		}
		
		public WPJoinFree verifyMaxLengthOfFullNameFieldJoinFree() {
			String max="50";
			String actualMaxLength=txtBxFullName.getAttribute("maxlength");
			Log.info("Verifying max length of Full Name Field in Join Free");
			reportStep("Verifying max length of Full Name Field in Join Free","INFO");
			if(actualMaxLength.contentEquals(max)) {
				Log.info("Max Length of Full Name field in Join Free should be 50 and it is: " +actualMaxLength);
				reportStep("Max Length of Full Name field in Join Free should be 50 and  it is: " +actualMaxLength,"PASS");
			}else {
				Log.info("Max Length of Full Name field in Join Free should be 50 but it is: " +actualMaxLength);
				reportStep("Max Length of Full Name field in Join Free should be 50 but it is: " +actualMaxLength,"FAIL");
			}
			return this;
		}
		//Below method is verify error message in case user is entering less than 6 character
		public WPJoinFree verifyErrorMessagePleaseChoosePassword() {
			String expected= "Please choose a password";
			String actual=Utils.fetchConsoleValue("#pwd-txt", driver);
			Log.info("verifying error message for Please Choose a password ");
			reportStep("verifying error message for Please choose a password", "INFO");
			if(actual.equals(expected)) {
				Log.info("Verified error message  Please choose a password in case user is not entering any character in password field during Join Free");
				reportStep("Verified error message  Please choose a password in case user is not entering any character in password field during Join Free","PASS");
			}else {
				Log.info("Unable to verify error message Please choose a password in case user is not entering any character in password field during Join Free");
				reportStep("Unable to verify error message  Please choose a password in case user is not entering any character in password field during Join Free","ERROR");
			}
			return this;
		}
		
		//Verifying Label "JOIN WITH EMAIL" during Join Free
		public WPJoinFree verifyJoinWithEmailLabelJoinFree() {
			Log.info("Verifying Label \"JOIN WITH EMAIL\" during Join Free");
			reportStep("Verifying Label \"JOIN WITH EMAIL\" during Join Free","INFO");
			if(btnJoinWithEmail.getText().toString().equals("SIGN UP")) {
				Log.info("Verified successfully Label \"JOIN WITH EMAIL\" during Join Free");
				reportStep("Verified successfully \"JOIN WITH EMAIL\" during Join Free","PASS");
			}else {
				Log.info("Unable to Verify \"JOIN WITH EMAIL\" during Join Free");
				reportStep("Unable to Verify \"JOIN WITH EMAIL\" during Join Free","FAIL");
			}
			return this;
		}
		
		@FindBy(id="password")
		private static WebElement txtBxChoosePasswordSignUAfterFocus;
	
		
		public WPJoinFree enterPasswordJoinFree(String password) {
			reportStep("Entering password value in Password text box in Join Free Page","INFO");
			Log.info("Entering password value in Password text box in Join Free Page");
			Utils.click(txtBxChoosePasswordJoinFree);
			if(Utils.sendKeys(txtBxChoosePasswordSignUAfterFocus, password)){
				reportStep("Entered password : \""+password+"\"value successfully in Password text box in Join Free Page","PASS");
				Log.info("Entered password : \""+password+"\"value successfully in Password text box in Join Free Page");
			}else {
				Log.info("Unable to enter  password in Password text box in Join Free Page");
				reportStep("Unable to enter  password in Password text box in Join Free Page","FAIL");
			}
			return this;
		}
		
		@FindBy(id="mobile_number")
		private static WebElement txtBxMobileNumberJoinFree;
		
		//Verifying max-length of Mobile Number text box in Join Free Page
		public WPJoinFree verifyMaxLengthOfMobileNumber() {
			reportStep("Verifying Max Length of Mobile Number text box in Join Free Page","INFO");
			Log.info("Verifying Max Length of Mobile Number text box in Join Free Page");
			if(txtBxMobileNumberJoinFree.getAttribute("maxlength").equals("10")) {
				reportStep("Verifyied Successfully Max Length of Mobile Number text box is 10 in Join Free Page","PASS");
				Log.info("Verifyied Successfully Max Length of Mobile Number text box is 10 in Join Free Page");
			}else {
				Log.info("Unable to Verify Max Length of Mobile Number text box is not 10 in Join Free Page");
				reportStep("Unable to Verify Max Length of Mobile Number text box is not 10 in Join Free Page","FAIL");
			}
			return this;
		}

		
		//Entering Mobile Number during Join Free
		public WPJoinFree enterMobileNumberJoinFree(String mobileNumber) {
			if(Utils.sendKeys(txtBxMobileNumberJoinFree, mobileNumber)) {
				Log.info("Entered Mobile Number successfully in mobile number Text Box");
				reportStep("Entered Mobile Number successfully in mobile number Text Box","PASS");
			}else {
				Log.error("Unable to enter Mobile Number successfully in mobile number Text Box");
				reportStep("Unable to enter mobile Number successfully in mobile number Text Box","FAIL");
			}

			return this;
		}
		
		//verify place holder value of mobile number text box
		public WPJoinFree verifyPlaceholderValueOfMobileNumberTextBoxJoinFree(String input) {
			reportStep("verifying value of mobile number text box in Join Free Page","INFO");
			Log.info("verifying value of mobile number text box in Join Free Page");
			Utils.explicitWaitForVisibility(txtBxMobileNumberJoinFree);
			//String value = (String) ((JavascriptExecutor) driver).executeScript("return $(\"#mobile_number\").val()");
			String value = Utils.fetchConsoleValue("#mobile_number", driver);
			//"Please enter valid mobile number""Enter Mobile Number:*"
			System.out.println(value);
			if(value.equals(input)) {
				Log.info("verified successfully value of mobile number text box in Join Free Page. It is "+ value);
				reportStep("verified place holder value successfully of mobile number text box in Join Free Page. It is: "+ value,"PASS");
			}else {
				Log.info("Unable to verify place holder value of mobile number text box in Join Free Page. Expected is: Enter Mobile Number:* and Actual is  "+value);
				reportStep("Unable to verify place holder value of mobile number text box in Join Free Page. It is: "+ value,"FAIL");
			}
			return this;
		}

		public WPJoinFree clickMobileNumberTextBoxJoinFree() {
			reportStep("Clicking on Mobile number Text Box in Join Free Form","INFO");
			Log.info("Clicking on Mobile number Text Box in Join Free Form");
			if(Utils.click(txtBxMobileNumberJoinFree)) {
				reportStep("Clicked succcessfully on Mobile number Text Box in Join Free Form","PASS");
				Log.info("Clicked succcessfully on Mobile number Text Box in Join Free Form");
			}else {
				reportStep("Unable to click on Mobile number Text Box in Join Free Form","PASS");
				Log.info("Unable to click on Mobile number Text Box in Join Free Form");
			}
			return this;
		}
		
		@FindBy(id="email")
		private static WebElement txtBxEmailAddressJoinFree;
		
		//Verifying Placeholder value of Email Address text box in Join Free Page
		public WPJoinFree verifyPlaceholderValueEmailAddressDuringJoinFree() {
			reportStep("Verifying Placeholder value of Email Address text box in Join Free Page","INFO");
			Log.info("Verifying Placeholder value of Full Name text box in Join Free Page");
			if(txtBxEmailAddressJoinFree.getAttribute("value").equals("Email Address:*")) {
				reportStep("Verifyied Successfully Placeholder value of Email Address text box in Join Free Page","PASS");
				Log.info("Verifyied Successfully Placeholder value of Email Address text box in Join Free Page");
			}else {
				Log.info("Unable to Verify Placeholder value of Email Address text box in Join Free Page");
				reportStep("Unable to Verify Placeholder value of Email Address text box in Join Free Page","FAIL");
			}
			return this;
		}	

		public WPJoinFree verifyErrorMessageForInvalidEmailJoinFree() {
			String expected= Utils.getTestData(1, "errorEmailAddress");
			String actual=Utils.fetchConsoleValue("#email", driver);
			if(actual.equals(expected)) {
				Log.info("Verified Error message successfully for Email Address text box in Join Free Page. Actual is "+actual+" and expected was "+expected);
				reportStep("Verified Error message successfully for Email Address text box in Join Free PageActual is "+actual+" and expected was "+expected,"PASS");
			}else {
				Log.info("Unable to Verify Error message for Email Address text box in Join Free Page. Actual is "+actual+" but expected was "+expected);
				reportStep("Unable to Verify Error message for Email Address text box in Join Free PageActual is "+actual+" but expected was "+expected,"ERROR");
			}
			return this;
		}
		
		//Below method is verify error message in case user is entering less than 6 character
		public WPJoinFree verifyErrorMessageForMinCharacterPassword() {
			String expected= Utils.getTestData(2, "minCharPassword");
			String actual=Utils.fetchConsoleValue("#pwd-txt", driver);
			Log.info("verifying error message for min character password: " +expected);
			reportStep("verifying error message for min character password: " +expected, "INFO");
			if(actual.equals(expected)) {
				Log.info("Verified error message " + actual+" in case user is entering less than 6 character in password field during Join Free");
				reportStep("Verified error message " + actual+" in case user is entering less than 6 character in password field during Join Free","PASS");
			}else {
				Log.info("Unable to verify error message " + expected+" in case user is entering less than 6 character in password field during Join Free");
				reportStep("Unable to verify error message " + expected+" in case user is entering less than 6 character in password field during Join Free","ERROR");
			}
			return this;
		}
		
		//Below method is verify max character that can be enter in password field
		public WPJoinFree verifyMaxCharacterPasswordJoinFree() {
			String expected= "20";
			String actual=txtBxChoosePasswordSignUAfterFocus.getAttribute("maxlength");
			if(actual.equals(expected)) {
				Log.info("Verified max length of Password field in Join Free. It is " + actual);
				reportStep("Verified max length of Password field in Join Free. It is " + actual,"PASS");
			}else {
				Log.info("Max length is password field is not equal to "+expected+ " But it is " + actual);
				reportStep("Max length is password field is not equal to "+expected+ " But it is " + actual,"PASS");
			}
			return this;
		}
		
		//This method will verify max length of Email Id
		public WPJoinFree verifyMaxLengthOfEmailIdFieldJoinFree() {
			String max="50";
			String actualMaxLength=txtBxEmailAddressJoinFree.getAttribute("maxlength");
			Log.info("Verifying max length of Email ID Field in Join Free");
			reportStep("Verifying max length of Email ID Field in Join Free","INFO");
			if(actualMaxLength.contentEquals(max)) {
				Log.info("Max Length of email id field in Join Free should be 50 and it is: " +actualMaxLength);
				reportStep("Max Length of email id field in Join Free should be 50 and  it is: " +actualMaxLength,"PASS");
			}else {
				Log.info("Max Length of email id field in Join Free should be 50 but it is: " +actualMaxLength);
				reportStep("Max Length of email id field in Join Free should be 50 but it is: " +actualMaxLength,"FAIL");
			}
			return this;
		}
		
		@FindBy(id="imgTopSiteLogo")
		private static WebElement lnkLogo;

		public WPHomePage clickLogo() {
			Log.info("Waiting for Logo");
			reportStep("Waiting for Logo","INFO");
			if(Utils.click(lnkLogo)) {
				Log.info("Clicked Successfully Logo");
				reportStep("Clicked Successfully Logo","PASS");
			}else {
				Log.info("Unable to click Logo");
				reportStep("Unable to click Logo","FAIL");
			}
			return new WPHomePage(driver, logger);
		}
		public WPJoinFree enterOtpDuringSignUp(String mobile) {
			Log.info("Entering OTP in OTP Text Box during Sign Up");
			reportStep("Entering OTP in OTP Text Box during Sign Up","INFO");
			String otp=Utils.getOTPCode(mobile, driver);
			if(Utils.sendKeys(txtBxOTP, otp)) {
				Log.info("Entered Successfully OTP-- "+otp+" in OTP Text Box during Sign Up");
				reportStep("Entered Successfully OTP-- "+otp+" in OTP Text Box during Sign Up","PASS");
			}else {
				Log.info("Unable to Enter OTP in OTP Text Box during Sign Up");
				reportStep("Unable to Enter OTP in OTP Text Box during Sign Up","FAIL");
			}
			return this;
		}

}
