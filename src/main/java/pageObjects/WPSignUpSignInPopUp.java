package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;

import utility.TestSetUp;
import utility.Log;
import utility.Utils;

public class WPSignUpSignInPopUp extends TestSetUp{
	Boolean presence;
	public static final Logger log = LogManager.getLogger(WPSignUpSignInPopUp.class);	
	public WPSignUpSignInPopUp(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		String info="Trying to open Sign In Sign Up Pop Up";
		String pass="Successfully open or Sign In Sign Up Pop Up";
		String fail="Unable to open Sign In Sign Up Pop Up";
		Log.info(info);
		reportStep(info, "INFO");
			if(Utils.verifyElementPresence(lnkSignUp)|| Utils.verifyElementPresence(txtBxOTP)) {
				Log.info(pass);
				reportStep(pass, "PASS");
			}else {
				Log.error(fail);
				reportStep(fail, "FAIL");
			}

	}	

	@FindBy(xpath = "//*[@class='fl forgotPassPopup' or @id='email']")
	private static WebElement lnkTxtBxConstantElement;

	@FindBy(id="popup_signin")
	private static WebElement lnkSignInTab;

	//Click on Sign In Tab
	public WPSignUpSignInPopUp clickOnlnkSignInTab() {
		try {
			reportStep("Clicking On Sign In Tab", "INFO");
			Log.info("Clicking On Sign In Tab");
			Utils.explicitWaitForClick(lnkSignInTab);
			reportStep("Clicked Successfully on Sign In Tab", "PASS");
			Log.info("Clicked Successfully on Sign In Tab");
		}catch(Exception e) {
			Log.error("Unable to Click Sign In Tab");
			reportStep("Unable to Click Sign In Tab", "FAIL");
		}
		return this;
	}
	@FindBy(name="uname")
	private static WebElement txtBxEmail;

	// Entering email id during Sign In
	public WPSignUpSignInPopUp enterEmailDuringSignIn(String email) {
		String locator="Trying to enter Email:--  "+email;
		String pass="Successfully entered email: --"+email;
		String fail="Unable to enter email : "+email+" Please see the screenshot to know reason--";
		try {
			Log.info(locator);
			reportStep(locator, "INFO");
			Utils.sendKeys(txtBxEmail,email);
			reportStep(pass, "PASS");
			Log.info(pass);
		}catch(Exception e) {
			Log.fatal(fail);
			reportStep(fail, "FAIL");
			
		}
		return this;
	}

	//Verifying Email Placeholder Value during Sign In
	public WPSignUpSignInPopUp verifyEmailPlaceHolderValue() {
		try {
			reportStep("Trying to fetch Placeholder value", "INFO");
			Log.info("Trying to fetch Placeholder value");
			Utils.verifyPlaceHolderValue(txtBxEmail, "Enter Email");
			reportStep("Able to fetch Placeholder value", "PASS");
			Log.info("Able to fetch Placeholder value");
		}catch(Exception e) {
			reportStep("Unable to fetch Placeholder value", "FAIL");
			Log.error("Unable to fetch Placeholder value");
		}
		return this;
	}

	

	//verify Max Character Allowed In Email Field
	public WPSignUpSignInPopUp verifyMaxCharacterAllowedInEmailField() {
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
	public WPSignUpSignInPopUp verifyMaxCharacterInPasswordField() {
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

	// Verify Password Textbox placeholder value
	public WPSignUpSignInPopUp verifyPasswordPlaceHolderValue() {
		try {
			reportStep("Trying to fetch Placeholder value of Password TextBox", "INFO");
			Log.info("Trying to fetch Placeholder value TextBox");
			Utils.verifyPlaceHolderValue(txtBxEmail, "Enter Email");
			reportStep("Able to fetch Placeholder value of Password TextBox", "PASS");
			Log.info("Able to fetch Placeholder value of Password TextBox");
		}catch(Exception e) {
			Log.error("Unable to fetch Placeholder value of Password TextBox");
			reportStep("Unable to fetch Placeholder value of Password TextBox", "FAIL");
		}
		return this;
	}

	//Enter Password during sign in
	public WPSignUpSignInPopUp enterPasswordDuringSignIn(String password) {
		String info="Trying to enter password: "+password;
		String pass="Entered  password Successfully : " +password;
		String fail="Unable to enter Password during Sign In "+password;
		try {			
			reportStep(info, "INFO");
			Log.info(info);
			Utils.sendKeys(txtBxPassword,password);
			reportStep(pass, "PASS");
			Log.info(pass);
		}catch(Exception e) {
			reportStep(fail, "FAIL");
			Log.fatal(fail);
		}
		return this;
	}
	@FindBy(id="to_be_check_signin")
	private static WebElement txtBxCaptchaSignIn;

	@FindBy(id="btnLayoutSignIn")
	private static WebElement btnSignInWithEmail;

	//Click on Sign In Button
	public WPHomePage clickOnSignInButton() {

		reportStep("Clicking On Sign In With Email button", "INFO");
		Log.info("Clicking On Sign In With Email button");
		if(Utils.click(btnSignInWithEmail)) {
			reportStep("Clicked Successfully on Sign In With Email button", "PASS");
			Log.info("Clicked Successfully on Sign In With Email button");
		} else {
			reportStep("Unable to Click Sign In With Email button", "FAIL");
			Log.fatal("Unable to Click Sign In With Email button");
		}
		return new WPHomePage(driver,logger);
	}
	
	public WPSignUpSignInPopUp clickOnSignInButtonFail() {

		reportStep("Clicking On Sign In With Email button", "INFO");
		Log.info("Clicking On Sign In With Email button");
		if(Utils.click(btnSignInWithEmail)) {
			reportStep("Clicked Successfully on Sign In With Email button", "PASS");
			Log.info("Clicked Successfully on Sign In With Email button");
		} else {
			reportStep("Unable to Click Sign In With Email button", "FAIL");
			Log.fatal("Unable to Click Sign In With Email button");
		}
		return this;
	}
	
	@FindBy(id="lnkLayoutForgotPassword")
	private static WebElement lnkForgotPassword;

	// click on Forgot Password link
	public WPForgotPassword clickOnForgotPassword() {
		reportStep("Clicking On Forgot Password Button", "INFO");
		Log.info("Clicking On Forgot Password Button ");
		if(Utils.click(lnkForgotPassword)) {
			reportStep("Clicked Successfully on Forgot Password", "PASS");
			Log.info("Clicked Successfully on Forgot Password");
		}else {
			Log.error("Unable to Click Forgot Password Button");
			reportStep("Unable to Click Forgot Password Button ", "FAIL");				
		}
		return new WPForgotPassword(driver, logger);
	}

	@FindBy(xpath="//*[contains(text(),'The username/password is invalid.')]")
	private static WebElement errMsgInvalidUserPwd;

	//Verify Presence of error message
	public WPSignUpSignInPopUp verifyPresenceOfErrorMsg() throws Exception{
		try {
			reportStep("Verifying presence of error message in case user enters wrong emauil id or password is present on Home Page", "INFO");
			Log.info("Verifying presence of error message in case user enters wrong emauil id or password is present on Home Page");
			Utils.verifyElementPresence(errMsgInvalidUserPwd);
			reportStep("Verification completed presence of error message in case user enters wrong emauil id or password is present on Home Page", "PASS");
			Log.info("Verification completed presence of error message in case user enters wrong emauil id or password is present on Home Page");
		}catch(Exception e) {
			reportStep("Verification completed unsuccessfully presence of error message in case user enters wrong emauil id or password is present on Home Page", "FAIL");
			Log.info("Verification completed unsuccessfully presence of error message in case user enters wrong emauil id or password is present on Home Page");
		}
		return this;
	}
	@FindBy(xpath="//*[contains(text(),'Please enter valid Email.')]")
	private static WebElement errMsgBlankEmailID;

	// Verify presence of Blank Email error messAGE
	public WPSignUpSignInPopUp verifyPresenceOfErrorMsgBlankEmail() throws Exception{
		try {
			reportStep("Verifying presence of error message in case user don't enter any emauil id during sign in", "INFO");
			Log.info("Verifying presence of error message in case user don't enter any emauil id during sign in");
			Utils.verifyElementPresence(errMsgBlankEmailID);
			reportStep("Verification completed presence of error message in case user don't enter any emauil id during sign in", "PASS");
			Log.info("Verification completed presence of error message in case user don't enter any emauil id during sign ine");
		}catch(Exception e) {
			reportStep("Verification completed unsuccessfully presence of error message in case user don't enter any emauil id during sign in", "FAIL");
			Log.info("Verification completed unsuccessfully presence of error message in case user don't enter any emauil id during sign in");
		}
		return this;
	}
	@FindBy(xpath="//*[contains(text(),'Please enter valid password.')]")
	private static WebElement errMsgBlankPassword;

	// Verify presence of Blank Password error messAGE
	public WPSignUpSignInPopUp verifyPresenceOfErrorMsgBlankPwd() throws Exception{
		try {
			reportStep("Verifying presence of error message in case user don't enter any password  during sign in", "INFO");
			Log.info("Verifying presence of error message in case user don't enter any password  during sign in");
			Utils.verifyElementPresence(errMsgBlankPassword);
			reportStep("Verification completed presence of error message in case user don't enter any emauil  during sign in", "PASS");
			Log.info("Verification completed presence of error message in case user don't enter any emauil during sign ine");
		}catch(Exception e) {
			reportStep("Verification completed unsuccessfully presence of error message in case user don't enter any password during sign in", "FAIL");
			Log.info("Verification completed unsuccessfully presence of error message in case user don't enter any password during sign in");
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
	public WPSignUpSignInPopUp verifyCountOfErrorMessages() {
		try {
			reportStep("Trying to locate the error message on Login Form", "INFO");
			Log.info("Trying to locate the error message on Login Form");
			if(errMsgLoginForm.isDisplayed()) {
				throw new InterruptedException("Error message are still displaying on Login Pop Up. It should goes off after reset");
			}
			reportStep("Reset Functionality of login pop up are working properly","PASS");
		}catch(Exception e) {
			Log.error("Error message are still displaying on Login Pop Up. It should goes off after reset");
			reportStep("Error message are still displaying on Login Pop Up. It should goes off after reset","FAIL");
		}
		return this;
	}

	@FindBy(xpath="(//input[@class='form_control error'])[1]")
	private static List<WebElement> errorMsgSignUp;
	//Verify Count Of Error Message During Sign Up
	public WPSignUpSignInPopUp verifyCountOfErrorMessagesInSignUp() {
		try {
			reportStep("Trying to locate the error message on Sign Up Form", "INFO");
			Log.info("Trying to locate the error message on Sign Up Form");
			int size=errorMsgSignUp.size();
			if(size>0) {
				throw new InterruptedException("Error message are still displaying on Sign Up Pop Up. It should goes off after reset");
			}
			Log.info("Reset Functionality of Sign Up pop up are working properly");
			reportStep("Reset Functionality of Sign Up pop up are working properly","PASS");
		}catch(Exception e) {
			Log.error("Error message are still displaying on Login Pop Up. It should goes off after reset");
			reportStep("Error message are still displaying on Login Pop Up. It should goes off after reset","FAIL");
		}
		return this;
	}
	@FindBy(id="cboxClose")
	private static WebElement btnClosePopUp;

	//close Login Pop Up
	public WPHomePage closeLoginPopUp() {
		try {
			reportStep("Trying to find Close Icon on Pop Up window","INFO");
			Log.info("Trying to find Close Icon on Pop Up window");
			Utils.click(btnClosePopUp);
			Log.info("Clicked Successfully Close Icon on Pop Up window");
			reportStep("Clicked Successfully Close Icon on Pop Up window","PASS");
		}catch(Exception e) {
			Log.info("Unable to click at Close Icon on Pop Up window");
			reportStep("Unable to click at Close Icon on Pop Up window","PASS");
		}
		return new WPHomePage(driver,logger);
	}
	@FindBy(xpath="//div[@id='secRightSignIn']//a[text()='SIGN IN']")
	private static WebElement lnkSignInLoginForm;

	//Verify Sign In Tab on Login Form
	public WPSignUpSignInPopUp verifySignInLinkOnLoginFrom() {
		try {
			reportStep("Locating Sign In Link of Login Pop Up","INFO");
			Log.info("Locating Sign In Link of Login Pop Up");
			presence=Utils.verifyElementPresence(lnkSignInLoginForm);
			if(presence==false) {
				throw new InterruptedException("Sign In Link of Login Pop Up is not visible");
			}
			reportStep("Verified presence of Sign In Link of Login Pop Up","PASS");
			Log.info("Verified presence of Sign In Link of Login Pop Up");
		}catch(Exception e) {
			reportStep("Sign In Link of Login Pop Up was not visible","FAIL");
			Log.fatal("Sign In Link of Login Pop Up was not visible");
		}
		return this;
	}

	@FindBy(id="lnkLayoutSignUp")
	private static WebElement lnkSignUp;

	//Click Sign Up Tab
	public WPSignUpSignInPopUp clickSignUpTab() {
		try {
			reportStep("Clicking Sign Up Tab in Login Form","INFO");
			Log.info("Clicking Sign Up Tab in Login Form");
			Utils.click(lnkSignUp);
			reportStep("Clicked successfully Sign Up Tab in Login Form","PASS");
			Log.info("Clicked successfully Sign Up Tab in Login Form");
		}catch(Exception e) {
			Log.info("Unable to click  Sign Up Tab in Login Form");
			reportStep("Unable to click  Sign Up Tab in Login Form","FAIL");
		}
		return this;
	}
	public WPSignUpSignInPopUp verifyTextOfSignUpTab() {
		reportStep("Verifying Sign Up Text of Sign Up Tab in Login Form","INFO");
		Log.info("Verifying Sign Up Text of Sign Up Tab in Login Form");
		if(lnkSignUp.getText().toString().equals("SIGN UP")) {
			reportStep("Verified Successfully Sign Up Text of Sign Up Tab in Login Form","PASS");
			Log.info("Verified Successfully Sign Up Text of Sign Up Tab in Login Form");
		}else {
			Log.info("Unable to Verify label of Sign Up TAB  is equal to \"SIGN UP\"  in Login Form");
			reportStep("Unable to Verify label of Sign Up TAB  is equal to \"SIGN UP\"  in Login Form","FAIL");
		}

		return this;
	}

	@FindBy(xpath="//*[contains(text(),'New  to CashKaro?')]")
	private static WebElement lblNewToCashKaro;

	//Verify New To Cashkaro Label
	public WPSignUpSignInPopUp verifyNewToCashKaroLabel() {
		reportStep("Verifying New To Cashkaro Label","INFO");
		Log.info("Verifying New To Cashkaro Label");
		if(Utils.verifyElementPresence(lblNewToCashKaro)) {
			reportStep("Verifyied Successfully New To Cashkaro Label","PASS");
			Log.info("Verifyied Successfully New To Cashkaro Label");
		}else {
			Log.info("Unable to Verify Successfully New To Cashkaro Label");
			reportStep("Unable to Verify Successfully New To Cashkaro Label","FAIL");
		}

		return this;
	}

	@FindBy(id="firstname")
	private static WebElement txtBxFullName;

	//Verifying Placeholder value of Full Name text box in Sign Up Pop up
	public WPSignUpSignInPopUp verifyPlaceholderValueFullNameDuringSignUp() {
		reportStep("Verifying Placeholder value of Full Name text box in Sign Up Pop up","INFO");
		Log.info("Verifying Placeholder value of Full Name text box in Sign Up Pop up");
		Utils.explicitWaitForVisibility(txtBxFullName);
		if(txtBxFullName.getAttribute("value").equals("Full Name:*")) {
			reportStep("Verifyied Successfully Placeholder value of Full Name text box in Sign Up Pop up","PASS");
			Log.info("Verifyied Successfully Placeholder value of Full Name text box in Sign Up Pop up");
		}else {
			Log.info("Unable to Verify Placeholder value of Full Name text box in Sign Up Pop up");
			reportStep("Unable to Verify Placeholder value of Full Name text box in Sign Up Pop up","FAIL");
		}
		return this;
	}

	public WPSignUpSignInPopUp verifyPlaceholderValueFullNameDuringSignUpJoinFree() {
		reportStep("Verifying Placeholder value of Full Name text box in Sign Up Pop up","INFO");
		Log.info("Verifying Placeholder value of Full Name text box in Sign Up Pop up");
		Utils.explicitWaitForVisibility(txtBxFullName);
		if(txtBxFullName.getAttribute("value").equals("Please type your name")) {
			reportStep("Verifyied Successfully Placeholder value of Full Name text box in Sign Up Pop up","PASS");
			Log.info("Verifyied Successfully Placeholder value of Full Name text box in Sign Up Pop up");
		}else {
			Log.info("Unable to Verify Placeholder value of Full Name text box in Sign Up Pop up");
			reportStep("Unable to Verify Placeholder value of Full Name text box in Sign Up Pop up","FAIL");
		}
		return this;
	}
	//Fetch Console value of Full Name Textbox
	public WPSignUpSignInPopUp verifyValueOfFullNameTextBox(String expected) {
		reportStep("Verifying Placeholder value of Full Name text box in Sign Up Pop up","INFO");
		Log.info("Verifying Placeholder value of Full Name text box in Sign Up Pop up");
		//String actual=Utils.fetchConsoleValue("#firstname", driver);
		if(txtBxFullName.getAttribute("value").equals(expected)) {
			reportStep("Verifyied Successfully value of Full Name text box in Sign Up Pop up","PASS");
			Log.info("Verifyied Successfully value of Full Name text box in Sign Up Pop up");
		}else {
			Log.info("Unable to Verify value of Full Name text box in Sign Up Pop up");
			reportStep("Unable to Verify value of Full Name text box in Sign Up Pop up","FAIL");
		}
		return this;
	}

	//Verifying expected value of full name
	public WPSignUpSignInPopUp verifyErrorMessageForFullNameSignUp() {
		String expected= Utils.getTestData(1, "errorFullName");
		String actual=Utils.fetchConsoleValue("#firstname", driver);
		Log.info("Verifying actual vs Expected value");
		reportStep("Verifying actual vs Expected value","INFO");
		if(actual.equals(expected)) {
			Log.info("Verified Error message successfully for Full Name text box in Sign Up Pop up. Actual is "+actual+" and expected was "+expected);
			reportStep("Verified Error message successfully for Full Name text box in Sign Up Pop upActual is "+actual+" and expected was "+expected,"PASS");
		}else {
			Log.info("Unable to Verify Error message for Full Name text box in Sign Up Pop up. Actual is "+actual+" but expected was "+expected);
			reportStep("Unable to Verify Error message for Full Name text box in Sign Up Pop upActual is "+actual+" but expected was "+expected,"ERROR");
		}
		return this;
	}

	//Entering Full name in Full Name Text Box in Sign Up Pop Up
	public WPSignUpSignInPopUp enterFullNameDuringSignUp(String fullName) {
		reportStep("Entering Full name in Full Name "+ fullName +" Text Box in Sign Up Pop Up","INFO");
		Log.info("Entering Full name in Full Name "+ fullName +" Text Box in Sign Up Pop Up");
		if(Utils.sendKeys(txtBxFullName, fullName)) {
			reportStep("Entered Full name Successfully in Full Name Text Box in Sign Up Pop Up","PASS");
			Log.info("Entered Full name Successfully in Full Name text box in Sign Up Pop up");
		}else {
			Log.info("Unable to Enter "+ fullName +" Full name Successfully in Full Name text box in Sign Up Pop up");
			reportStep("Unable to Enter "+ fullName +" Full name Successfully in Full Name text box in Sign Up Pop up","FAIL");
		}
		return this;
	}
	//This method will verify max length of Full Name
	public WPSignUpSignInPopUp verifyMaxLengthOfFullNameFieldSignUp() {
		String max="50";
		String actualMaxLength=txtBxFullName.getAttribute("maxlength");
		Log.info("Verifying max length of Full Name Field in Sign Up");
		reportStep("Verifying max length of Full Name Field in Sign Up","INFO");
		if(actualMaxLength.contentEquals(max)) {
			Log.info("Max Length of Full Name field in Sign Up should be 50 and it is: " +actualMaxLength);
			reportStep("Max Length of Full Name field in Sign Up should be 50 and  it is: " +actualMaxLength,"PASS");
		}else {
			Log.info("Max Length of Full Name field in Sign Up should be 50 but it is: " +actualMaxLength);
			reportStep("Max Length of Full Name field in Sign Up should be 50 but it is: " +actualMaxLength,"FAIL");
		}
		return this;
	}

	//This email address is for Sign Up Functionality
	@FindBy(id="email")
	private static WebElement txtBxEmailAddressSignUp;

	//Verifying Placeholder value of Email Address text box in Sign Up Pop up
	public WPSignUpSignInPopUp verifyPlaceholderValueEmailAddressDuringSignUp() {
		reportStep("Verifying Placeholder value of Email Address text box in Sign Up Pop up","INFO");
		Log.info("Verifying Placeholder value of Full Name text box in Sign Up Pop up");
		if(txtBxEmailAddressSignUp.getAttribute("value").equals("Email Address:*")) {
			reportStep("Verifyied Successfully Placeholder value of Email Address text box in Sign Up Pop up","PASS");
			Log.info("Verifyied Successfully Placeholder value of Email Address text box in Sign Up Pop up");
		}else {
			Log.info("Unable to Verify Placeholder value of Email Address text box in Sign Up Pop up");
			reportStep("Unable to Verify Placeholder value of Email Address text box in Sign Up Pop up","FAIL");
		}
		return this;
	}	

	public WPSignUpSignInPopUp verifyErrorMessageForInvalidEmailSignUp() {
		String expected= Utils.getTestData(1, "errorEmailAddress");
		String actual=Utils.fetchConsoleValue("#email", driver);
		if(actual.equals(expected)) {
			Log.info("Verified Error message successfully for Email Address text box in Sign Up Pop up. Actual is "+actual+" and expected was "+expected);
			reportStep("Verified Error message successfully for Email Address text box in Sign Up Pop upActual is "+actual+" and expected was "+expected,"PASS");
		}else {
			Log.info("Unable to Verify Error message for Email Address text box in Sign Up Pop up. Actual is "+actual+" but expected was "+expected);
			reportStep("Unable to Verify Error message for Email Address text box in Sign Up Pop upActual is "+actual+" but expected was "+expected,"ERROR");
		}
		return this;
	}

	//Entering Email in Email ID text box in Sign Up Pop up
	public WPSignUpSignInPopUp enterEmailIDDuringSignUp(String email) {
		reportStep("Entering Email in Email ID text box in Sign Up Pop up","INFO");
		Log.info("Entering Email in Email ID text box in Sign Up Pop up");
		if(Utils.sendKeys(txtBxEmailAddressSignUp, email)) {
			reportStep("Entered Email: "+ email+" in Email ID text box in Sign Up Pop up","PASS");
			Log.info("Entered Email : "+ email+" in Email ID text box in Sign Up Pop up");
		}else {
			Log.info("Unable to Enter Email in Email ID text box in Sign Up Pop up");
			reportStep("Unable to enter Email in Email ID text box in Sign Up Pop up","FAIL");
		}
		return this;
	}

	//This method will verify max length of Email Id
	public WPSignUpSignInPopUp verifyMaxLengthOfEmailIdFieldSignUp() {
		String max="50";
		String actualMaxLength=txtBxEmailAddressSignUp.getAttribute("maxlength");
		Log.info("Verifying max length of Email ID Field in Sign Up");
		reportStep("Verifying max length of Email ID Field in Sign Up","INFO");
		if(actualMaxLength.contentEquals(max)) {
			Log.info("Max Length of email id field in Sign Up should be 50 and it is: " +actualMaxLength);
			reportStep("Max Length of email id field in Sign Up should be 50 and  it is: " +actualMaxLength,"PASS");
		}else {
			Log.info("Max Length of email id field in Sign Up should be 50 but it is: " +actualMaxLength);
			reportStep("Max Length of email id field in Sign Up should be 50 but it is: " +actualMaxLength,"FAIL");
		}
		return this;
	}

	@FindBy(id="pwd-txt")
	private static WebElement txtBxChoosePasswordSignUp;

	//Below method is verify error message in case user is entering less than 6 character
	public WPSignUpSignInPopUp verifyErrorMessagePleaseChoosePassword() {
		String expected= "Please choose a password";
		String actual=Utils.fetchConsoleValue("#pwd-txt", driver);
		Log.info("verifying error message for Please Choose a password ");
		reportStep("verifying error message for Please choose a password", "INFO");
		if(actual.equals(expected)) {
			Log.info("Verified error message  Please choose a password in case user is not entering any character in password field during Sign Up");
			reportStep("Verified error message  Please choose a password in case user is not entering any character in password field during Sign Up","PASS");
		}else {
			Log.info("Unable to verify error message Please choose a password in case user is not entering any character in password field during Sign Up");
			reportStep("Unable to verify error message  Please choose a password in case user is not entering any character in password field during Sign Up","ERROR");
		}
		return this;
	}

	//Below method is verify error message in case user is entering less than 6 character
	public WPSignUpSignInPopUp verifyErrorMessageForMinCharacterPassword() {
		String expected= Utils.getTestData(2, "minCharPassword");
		String actual=Utils.fetchConsoleValue("#pwd-txt", driver);
		Log.info("verifying error message for min character password: " +expected);
		reportStep("verifying error message for min character password: " +expected, "INFO");
		if(actual.equals(expected)) {
			Log.info("Verified error message " + actual+" in case user is entering less than 6 character in password field during Sign Up");
			reportStep("Verified error message " + actual+" in case user is entering less than 6 character in password field during Sign Up","PASS");
		}else {
			Log.info("Unable to verify error message " + expected+" in case user is entering less than 6 character in password field during Sign Up");
			reportStep("Unable to verify error message " + expected+" in case user is entering less than 6 character in password field during Sign Up","ERROR");
		}
		return this;
	}

	//Below method is verify max character that can be enter in password field
	public WPSignUpSignInPopUp verifyMaxCharacterPasswordSignUp() {
		String expected= "20";
		String actual=txtBxChoosePasswordSignUAfterFocus.getAttribute("maxlength");
		if(actual.equals(expected)) {
			Log.info("Verified max length of Password field in Sign UP. It is " + actual);
			reportStep("Verified max length of Password field in Sign UP. It is " + actual,"PASS");
		}else {
			Log.info("Max length is password field is not equal to "+expected+ " But it is " + actual);
			reportStep("Max length is password field is not equal to "+expected+ " But it is " + actual,"PASS");
		}
		return this;
	}

	@FindBy(id="password")
	private static WebElement txtBxChoosePasswordSignUAfterFocus;

	//Verifying Placeholder value of Password text box in Sign Up Pop up
	public WPSignUpSignInPopUp verifyPlaceholderValuePasswordSignUp() {
		reportStep("Verifying Placeholder value of Password text box in Sign Up Pop up","INFO");
		Log.info("Verifying Placeholder value of Password text box in Sign Up Pop up");
		if(txtBxChoosePasswordSignUp.getAttribute("value").equals("Choose Password:*")) {
			reportStep("Verifyied Successfully Placeholder value of Password text box in Sign Up Pop up","PASS");
			Log.info("Verifyied Successfully Placeholder value of Password text box in Sign Up Pop up");
		}else {
			Log.info("Unable to Verify Placeholder value of Password text box in Sign Up Pop up");
			reportStep("Unable to Verify Placeholder value of Password text box in Sign Up Pop up","FAIL");
		}
		return this;
	}	

	public WPSignUpSignInPopUp verifyPlaceholderValuePasswordSignUpJoinFree() {
		reportStep("Verifying Placeholder value of Password text box in join Free Page","INFO");
		Log.info("Verifying Placeholder value of Password text box in join Free Page");
		if(txtBxChoosePasswordSignUp.getAttribute("value").equals("*Enter a password")) {
			reportStep("Verifyied Successfully Placeholder value of Password text box in join Free Page","PASS");
			Log.info("Verifyied Successfully Placeholder value of Password text box in join Free Page");
		}else {
			Log.info("Unable to Verify Placeholder value of Password text box in join Free Page");
			reportStep("Unable to Verify Placeholder value of Password text box in join Free Page","FAIL");
		}
		return this;
	}
	public WPSignUpSignInPopUp enterPasswordSignUp(String password) {
		reportStep("Entering password value in Password text box in Sign Up Pop up","INFO");
		Log.info("Entering password value in Password text box in Sign Up Pop up");
		Utils.click(txtBxChoosePasswordSignUp);
		if(Utils.sendKeys(txtBxChoosePasswordSignUAfterFocus, password)){
			reportStep("Entered password : \""+password+"\"value successfully in Password text box in Sign Up Pop up","PASS");
			Log.info("Entered password : \""+password+"\"value successfully in Password text box in Sign Up Pop up");
		}else {
			Log.info("Unable to enter  password in Password text box in Sign Up Pop up");
			reportStep("Unable to enter  password in Password text box in Sign Up Pop up","FAIL");
		}
		return this;
	}

	@FindBy(id="mobile_number")
	private static WebElement txtBxMobileNumberSignUp;

	//verify place holder value of mobile number text box
	public WPSignUpSignInPopUp verifyPlaceholderValueOfMobileNumberTextBoxSignUp(String input) {
		reportStep("verifying value of mobile number text box in Sign Up Pop Up","INFO");
		Log.info("verifying value of mobile number text box in Sign Up Pop Up");
		Utils.explicitWaitForVisibility(txtBxMobileNumberSignUp);
		//String value = (String) ((JavascriptExecutor) driver).executeScript("return $(\"#mobile_number\").val()");
		String value = Utils.fetchConsoleValue("#mobile_number", driver);
		//"Please enter valid mobile number""Enter Mobile Number:*"
		System.out.println(value);
		if(value.equals(input)) {
			Log.info("verified successfully value of mobile number text box in Sign Up Pop Up. It is "+ value);
			reportStep("verified place holder value successfully of mobile number text box in Sign Up Pop Up. It is: "+ value,"PASS");
		}else {
			Log.info("Unable to verify place holder value of mobile number text box in Sign Up Pop Up. Expected is: Enter Mobile Number:* and Actual is  "+value);
			reportStep("Unable to verify place holder value of mobile number text box in Sign Up Pop Up. It is: "+ value,"FAIL");
		}
		return this;
	}

	public WPSignUpSignInPopUp clickMobileNumberTextBoxSignUp() {
		reportStep("Clicking on Mobile number Text Box in Sign Up Form","INFO");
		Log.info("Clicking on Mobile number Text Box in Sign Up Form");
		if(Utils.click(txtBxMobileNumberSignUp)) {
			reportStep("Clicked succcessfully on Mobile number Text Box in Sign Up Form","PASS");
			Log.info("Clicked succcessfully on Mobile number Text Box in Sign Up Form");
		}else {
			reportStep("Unable to click on Mobile number Text Box in Sign Up Form","PASS");
			Log.info("Unable to click on Mobile number Text Box in Sign Up Form");
		}
		return this;
	}

	public WPSignUpSignInPopUp verifyNegativeScenariosForMobileNumberTextBoxSignUp(String input) {
		reportStep("verifying whether alplhabets and special characters can be entered in mobile number text box of Sign Up Pop Up","INFO");
		Log.info("verifying whether alplhabets and special characters can be entered in mobile number text box of Sign Up Pop Up");
		Utils.sendKeys(txtBxMobileNumberSignUp, input);
		String value = Utils.fetchConsoleValue("#mobile_number", driver);
		if(!value.equals(input)) {
			Log.info("alplhabets and special characters cannot be entered in mobile number text box of Sign Up Pop Up");
			reportStep("alplhabets and special characters cannot be entered in mobile number text box of Sign Up Pop Up","PASS");
		}else {
			Log.error("alplhabets and special characters can be entered in mobile number text box of Sign Up Pop Up");
			reportStep("alplhabets and special characters can be entered in mobile number text box of Sign Up Pop Up","ERROR");
			reportStep("Value Entered: " +input+ " Value accepted by textboxes: " +value,"ERROR");
		}
		return this;
	}
	//Verifying max-length of Mobile Number text box in Sign Up Pop up
	public WPSignUpSignInPopUp verifyMaxLengthOfMobileNumber() {
		reportStep("Verifying Max Length of Mobile Number text box in Sign Up Pop up","INFO");
		Log.info("Verifying Max Length of Mobile Number text box in Sign Up Pop up");
		if(txtBxMobileNumberSignUp.getAttribute("maxlength").equals("10")) {
			reportStep("Verifyied Successfully Max Length of Mobile Number text box is 10 in Sign Up Pop up","PASS");
			Log.info("Verifyied Successfully Max Length of Mobile Number text box is 10 in Sign Up Pop up");
		}else {
			Log.info("Unable to Verify Max Length of Mobile Number text box is not 10 in Sign Up Pop up");
			reportStep("Unable to Verify Max Length of Mobile Number text box is not 10 in Sign Up Pop up","FAIL");
		}
		return this;
	}

	//Entering Mobile Number during Sign Up
	public WPSignUpSignInPopUp enterMobileNumberSignUp(String mobileNumber) {
		if(Utils.sendKeys(txtBxMobileNumberSignUp, mobileNumber)) {
			Log.info("Entered Mobile Number successfully in mobile number Text Box");
			reportStep("Entered Mobile Number successfully in mobile number Text Box","PASS");
		}else {
			Log.error("Unable to enter Mobile Number successfully in mobile number Text Box");
			reportStep("Unable to enter mobile Number successfully in mobile number Text Box","FAIL");
		}

		return this;
	}

	@FindBy(id="to_be_check")
	private static WebElement txtBxCaptchaSignUp;

	//Entering Captcha value during Sign Up
	public WPSignUpSignInPopUp enterCaptchaSignUp(String captcha) {
		if(Utils.sendKeys(txtBxMobileNumberSignUp, captcha)) {
			Log.info("Entered Captcha successfully in Captcha Text Box");
			reportStep("Entered Captcha successfully in Captcha Text Box","PASS");
		}else {
			Log.error("Unable to enter Captcha in Captcha Text Box");
			reportStep("Unable to enterCaptcha in Captcha Text Box","FAIL");
		}

		return this;
	}

	@FindBy(id="join_free_submit")
	private static WebElement btnJoinWithEmailSignUpPopUp;

	//Clicking Join With Email Button during Sign Up
	public WPSignUpSignInPopUp clickJoinWithEmailDuringSignUp() {
		Log.info("Clicking Join With Email Button during Sign Up");
		reportStep("Clicking Join With Email Button during Sign Up","INFO");
		if(Utils.click(btnJoinWithEmailSignUpPopUp)) {
			Log.info("Clicked successfully Join With Email Button during Sign Up");
			reportStep("Clicked successfully Join With Email Button during Sign Up","PASS");
		}else {
			Log.info("Unable to Click Join With Email Button during Sign Up");
			reportStep("Unable to Click Join With Email Button during Sign Up","FAIL");
		}
		explicitWaitForOTPTxtBox();
		return this;
	}

	//Verifying Label "JOIN WITH EMAIL" during Sign Up
	public WPSignUpSignInPopUp verifyJoinWithEmailLabelSignUp() {
		Log.info("Verifying Label \"JOIN WITH EMAIL\" during Sign Up");
		reportStep("Verifying Label \"JOIN WITH EMAIL\" during Sign Up","INFO");
		if(btnJoinWithEmailSignUpPopUp.getText().toString().equals("SIGN UP")) {
			Log.info("Verified successfully Label \"JOIN WITH EMAIL\" during Sign Up");
			reportStep("Verified successfully \"JOIN WITH EMAIL\" during Sign Up","PASS");
		}else {
			Log.info("Unable to Verify \"JOIN WITH EMAIL\" during Sign Up");
			reportStep("Unable to Verify \"JOIN WITH EMAIL\" during Sign Up","FAIL");
		}
		return this;
	}

	@FindBy(id="btnLayoutAddMobileNo")
	private static WebElement btnSendOtp;

	@FindBy(id="invalidOtp")
	private static WebElement lblInvalidOtp;

	public WPSignUpSignInPopUp verifyLabelInvalidOtp() {
		Log.info("Fetching Invalid otp Label on OTP Form during Sign Up");
		reportStep("Fetching Invalid otp Label on OTP Form during Sign Up","INFO");
		Utils.explicitWaitForVisibility(lblInvalidOtp);
		String expected="Invalid OTP code";
		String actual=lblInvalidOtp.getText();
		if(expected.equals(actual)) {
			Log.info("Fetching Invalid otp Label on OTP Form during Sign Up");
			reportStep("Fetching Invalid otp Label on OTP Form during Sign Up","PASS");
		}else {
			Log.info(actual +" is actual Invalid otp Label but expected text should be "+expected+" on OTP Form during Sign Up");
			reportStep("actual +\" is actual Invalid otp Label but expected text should be \"+expected+\" on OTP Form during Sign Up","FAIL");
		}
		return this;
	}
	public WPSignUpSignInPopUp clearOtpField() {
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

	@FindBy(id="otp")
	private static WebElement txtBxOTP;

	//Enter OTP in otp text box
	public WPSignUpSignInPopUp enterOtpDuringSignUp(String mobile) {
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

	public WPSignUpSignInPopUp explicitWaitForOTPTxtBox() {
		Log.info("Waiting for OTP text Box");
		//reportStep("Waiting for OTP text Box","INFO");
		if(Utils.explicitWaitForVisibility(txtBxOTP)) {
			Log.info("OTP Text appeared.");
		}else {
			Log.info("OTP Text Box did not appeared.");
		}
		Log.info("Explicitly waited for OTP text box.");
		//reportStep("Explicitly waited for OTP text box.","PASS");

		return this;
	}

	@FindBy(id="btnLayoutVerifyOTP")
	private static WebElement btnVerifyOTP;

	//Click Verify OTP after entering OTP
	public WPHomePage clickVerifyOTP() {
		Log.info("Clicking Verify OTP  during Sign Up");
		reportStep("Clicking Verify OTP  Button during Sign Up","INFO");
		if(Utils.explicitWaitForClick(btnVerifyOTP)) {
			Log.info("Clicked successfully Verify OTP  Button during Sign Up");
			reportStep("Clicked successfully Verify OTP  Button during Sign Up","PASS");
		}else {
			Log.info("Unable to Click Verify OTP  Button during Sign Up");
			reportStep("Unable to Click Verify OTP  Button during Sign Up","FAIL");
		}
		return new WPHomePage(driver,logger);
	}
	
	public WPSignUpSignInPopUp clickVerifyOTPFail() {
		Log.info("Clicking Verify OTP  during Sign Up");
		reportStep("Clicking Verify OTP  Button during Sign Up","INFO");
		if(Utils.explicitWaitForClick(btnVerifyOTP)) {
			Log.info("Clicked successfully Verify OTP  Button during Sign Up");
			reportStep("Clicked successfully Verify OTP  Button during Sign Up","PASS");
		}else {
			Log.info("Unable to Click Verify OTP  Button during Sign Up");
			reportStep("Unable to Click Verify OTP  Button during Sign Up","FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//em[contains(text(),'Number already in use. Please enter different number.')]")
	private static WebElement errMsgDuplicatePhoneNumber;
	
	@FindBy(xpath = "//em[contains(text(),'An account with this Email ID already exists!')]")
	private static WebElement errMsgDuplicateEmailId;

	//Verify Duplicate Email Error Message
	public WPSignUpSignInPopUp verifyErrorMsgRegisteredEmailSignUp() {
		Log.info("Verifying Error message if a email is already registered  during Sign Up");
		reportStep("Verifying Error message if a email is already registered  during Sign Up","INFO");
		Utils.explicitWaitForVisibility(errMsgDuplicateEmailId);
		if(Utils.verifyElementPresence(errMsgDuplicateEmailId)) {
			Log.info("Verified Error message \"An account with this Email ID already exists!\" if a email is already registered  during Sign Up");
			reportStep("Verified Error message \"An account with this Email ID already exists!\" if a email is already registered  during Sign Up","PASS");
		}else {
			Log.info("Unable to verify Error message \"An account with this Email ID already exists!\" if a email is already registered  during Sign Up");
			reportStep("Unable to verify Error message \"An account with this Email ID already exists!\" if a email is already registered  during Sign Up","FAIL");
		}
		return this;
	}



	//Verify Error Message if a phone number already exist
	public WPSignUpSignInPopUp verifyErrorMsgRegisteredPhoneSignUp() {
		Log.info("Verifying Error message if a Phone is already registered  during Sign Up");
		reportStep("Verifying Error message if a Phone is already registered  during Sign Up","INFO");
		if(Utils.verifyElementPresence(errMsgDuplicatePhoneNumber)) {
			Log.info("Verified Error message \"Number already in use. Please enter different number.\" if a Phone is already registered  during Sign Up");
			reportStep("Verified Error message \"Number already in use. Please enter different number.\" if a Phone is already registered  during Sign Up","PASS");
		}else {
			Log.info("Unable to verify Error message \"Number already in use. Please enter different number.\" if a email is already registered  during Sign Up");
			reportStep("Unable to verify Error message \"Number already in use. Please enter different number.\" if a email is already registered  during Sign Up","FAIL");
		}
		return this;
	}

	@FindBy(id="lnkLayoutTermsConditions")
	private static WebElement lnkTermsAndConditions;

	//Clicking on Terms and Conditions link on Sign Up Form
	public WPTermsAndConditions clickTermsAndConditions() {
		Log.info("Clicking on Terms and Conditions link on Sign Up Form");
		reportStep("Clicking on Terms and Conditions link on Sign Up Form","INFO");
		if(Utils.click(lnkTermsAndConditions)) {
			Log.info("Clicking on Terms and Conditions link on Sign Up Form");
			reportStep("Clicking on Terms and Conditions link on Sign Up Form","PASS");
			Utils.switchToNewlyOpenWindow(driver);
		}else {
			Log.info("Unable to Click Terms and Conditions link on Sign Up Form");
			reportStep("Unable to Click Terms and Conditions link on Sign Up Form","FAIL");
		}
		return new WPTermsAndConditions(driver, logger);
	}

	

	
	@FindBy(id="wigzo-custom-close")
	private static WebElement lnkClosePopUp;

	@FindBy(id="resendOTP")
	private static WebElement btnResendOtp;

	//Click Resend OTP Button
	public WPSignUpSignInPopUp clickResendOtpButton() throws InterruptedException {
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

	//Verify the label "Enter the OTP sent to your registered mobile number"  in OTP For Sign Up Form
	public WPSignUpSignInPopUp verifyPresenceOfLabelEnterOtpSent() throws InterruptedException {
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
	public WPSignUpSignInPopUp closeOtpPopUp() {
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
}
