package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class WPForgotPassword extends TestSetUp{
	Boolean presence;
	public static final Logger log = LogManager.getLogger(WPForgotPassword.class);

	// Constructor of Forgot Password Pop Up
	public WPForgotPassword(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info("Waiting for Forgot Password Pop Up to Load");
		reportStep("Waiting for Forgot Password Pop Up to Load", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(txtBxForgotPasswordEmail));
			Log.info(" Forgot Password Pop Up Loaded Successfully");
			reportStep("Forgot Password Pop Up Loaded Successfully", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to load Forgot Password Pop Up", "FAIL");
			Log.error("Not able to load Forgot Password Pop Up");
		} 
	}	


	@FindBy(id="from_email")
	private static WebElement txtBxForgotPasswordEmail;

	// This method will enter email id in Forgot Password Email
	public WPForgotPassword enterForgotPasswordEmail(String email){
		Log.info("Locating Forgot Password Email");
		reportStep("Locating Forgot Password Email", "INFO");
		if(Utils.sendKeys(txtBxForgotPasswordEmail, email)) {
			Log.info("Successfully enter Forgot Password Email: " +email);
			reportStep("Successfully enter Password Email: " +email, "PASS");
		}
		else {
			Log.info("Unable to enter Forgot Password Email");
			reportStep("Unable to enter Password Email: "+email, "FAIL");
		}
		return this;
	}

	// This method will verify max length of email id in Forgot Password Pop Up
	public WPForgotPassword verifyMaxLengthOfForgotPasswordEmail(){
		Log.info("Locating Forgot Password Email");
		reportStep("Locating Forgot Password Email", "INFO");
		String maxLength=Utils.getTestData(2, "maxLength");
		if(maxLength.equals(txtBxForgotPasswordEmail.getAttribute("maxlength").toString())) {
			Log.info("Max length of Forgot Password Email is: " +maxLength);
			reportStep("Max length of Forgot Password Email is: " +maxLength, "PASS");
		}
		else {
			Log.info("Max length of Forgot Password Email is not equal to :" +maxLength +". It is equal to: " +txtBxForgotPasswordEmail.getAttribute("maxlength").toString()  );
			reportStep("Max length of Forgot Password Email is not equal to :" +maxLength +". It is equal to: " +txtBxForgotPasswordEmail.getAttribute("maxlength").toString(), "FAIL");
		}
		return this;
	}

	// This method will verify Place holder value of Forgot Password email 
	public WPForgotPassword verifyPlaceholderValueOfForgotPwdEmail(){
		Log.info("Locating Forgot Password Email");
		reportStep("Locating Forgot Password Email", "INFO");
		presence=Utils.verifyPlaceHolderValue(txtBxForgotPasswordEmail, "Enter Email");
		if(presence) {
			Log.info("Place Holder value of Forgot Password email is :  \"Enter Email.\"");
			reportStep("Place Holder value of Forgot Password email is :  \"Enter Email.\"", "PASS");
		}
		else {
			Log.info("Place Holder value of Forgot Password email mismatched.");
			reportStep("Place Holder value of Forgot Password email mismatched.", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//em[text()='Please enter valid email address.']")
	private static WebElement errMsgInvalidEmail;

	//This method will verify error message if user enters invalid email id.
	public WPForgotPassword verifyInvalidEmailErrorMsg(){
		Log.info("Locating Error Msg Invalid Email Error Message");
		reportStep("Locating Error Msg Invalid Email Error Message", "INFO");
		presence=Utils.verifyElementPresence(errMsgInvalidEmail);
		if(presence) {
			Log.info("Error Msg Invalid Email Error Message is present.");
			reportStep("Error Msg Invalid Email Error Message: Please enter valid email address is present.", "PASS");
		}
		else {
			Log.info("Error Msg Invalid Email Error Message is not displayed.");
			reportStep("Error Msg Invalid Email Error Message: Please enter valid email address is not displayed.", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//h2[text()='ENTER CORRECT EMAIL ID']")
	private static WebElement errMsgEnterCorrectMail;

	//This method will verify error message if user enters unregistered email id--ENTER CORRECT EMAIL ID.
	public WPForgotPassword verifyEnterCorrectMailIdMsg(){
		Log.info("Locating Error Msg --ENTER CORRECT EMAIL ID");
		reportStep("Locating Error Msg --ENTER CORRECT EMAIL ID", "INFO");
		presence=Utils.verifyElementPresence(errMsgEnterCorrectMail);
		if(presence) {
			Log.info("Error Msg --ENTER CORRECT EMAIL ID-- is present.");
			reportStep("Error Msg --ENTER CORRECT EMAIL ID-- is present.", "PASS");
		}
		else {
			Log.info("Error Msg --ENTER CORRECT EMAIL ID-- is not displayed.");
			reportStep("Error Msg --ENTER CORRECT EMAIL ID-- is not displayed.", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//span[contains(text(),'YOUR EMAIL ADDRESS')]")
	private static WebElement errMsgThisIsntYourEmail;

	//This method will verify error message if user enters unregistered email id--ENTER CORRECT EMAIL ID.
	public WPForgotPassword verifyErrorMsgOopsThisIsntYourEmail(){
		Log.info("Locating Error Msg --THIS ISN'T YOUR EMAIL ADDRESS!");
		reportStep("Locating Error Msg --THIS ISN'T YOUR EMAIL ADDRESS!", "INFO");
		presence=Utils.verifyElementPresence(errMsgThisIsntYourEmail);
		if(presence) {
			Log.info("Error Msg --THIS ISN'T YOUR EMAIL ADDRESS!-- is present.");
			reportStep("Error Msg --THIS ISN'T YOUR EMAIL ADDRESS!-- is present.", "PASS");
		}
		else {
			Log.info("Error Msg --THIS ISN'T YOUR EMAIL ADDRESS!-- is not displayed.");
			reportStep("Error Msg --THIS ISN'T YOUR EMAIL ADDRESS!-- is not displayed.", "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//a[text()='LOGIN']") // No Id or name is provided.
	private static WebElement lnkLogin;

	//Below method will click on Login Link As well as verify the text of Login link
	public WPSignUpSignInPopUp clickOnLoginLink(){
		Log.info("Locating login Link in Forgot Password Pop Up");
		reportStep("Locating login Link in Forgot Password Pop Up", "INFO");
		presence=Utils.click(lnkLogin);
		if(presence) {
			Log.info("Successfully Clicked on Login link");
			reportStep("Successfully Clicked on Login link", "PASS");
		}
		else {
			Log.info("Unable to Click on Login link");
			reportStep("Unable to Click on Login link.", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}

	@FindBy(xpath="//span[text()='RESET PASSWORD']")
	private static WebElement lblResetPassword;

	//This method will verify RESET PASSWORD Label in Forgot Password Pop Up.
	public WPForgotPassword verifyPresenceOFResetPasswordLabel(){
		Log.info("Locating RESET PASSWORD Label in Forgot Password Pop Up.");
		reportStep("Locating RESET PASSWORD Label in Forgot Password Pop Up.", "INFO");
		presence=Utils.verifyElementPresence(lblResetPassword);
		if(presence) {
			Log.info("RESET PASSWORD Label in Forgot Password Pop Up is present.");
			reportStep("RESET PASSWORD Label in Forgot Password Pop Up is present.", "PASS");
		}
		else {
			Log.info("RESET PASSWORD Label in Forgot Password Pop Up is not displayed.");
			reportStep("RESET PASSWORD Label in Forgot Password Pop Up is not displayed.", "FAIL");
		}
		return this;
	}

	@FindBy(id="submit_req")
	private static WebElement lnkResetPassword;

	//This method will verify text of Reset Password Link.
	public WPForgotPassword verifyResetPasswordText(){
		Log.info("Locating RESET PASSWORD link in Forgot Password Pop Up.");
		reportStep("Locating RESET PASSWORD Link in Forgot Password Pop Up.", "INFO");
		String expected="RESET PASSWORD";
		String actual=lnkResetPassword.getText().toString();
		if(actual.equals(expected)) {
			Log.info("RESET PASSWORD Link in Forgot Password Pop Up Text is : " +actual);
			reportStep("RESET PASSWORD Link in Forgot Password Pop Up Text is : " +actual, "PASS");
		}
		else {
			Log.info("RESET PASSWORD Link in Forgot Password Pop Up Text is : " +actual);
			reportStep("RESET PASSWORD Link in Forgot Password Pop Up Text is : " +actual, "FAIL");
		}
		return this;
	}

	// This method will click on Reset Password Link
	public WPForgotPassword clickResetPasswordLink(){
		Log.info("Locating RESET PASSWORD link in Forgot Password Pop Up.");
		reportStep("Locating RESET PASSWORD Link in Forgot Password Pop Up.", "INFO");
		if(Utils.click(lnkResetPassword)) {
			Log.info("Clicked Reset Password in Forgot Password Pop Up Successfully");
			reportStep("Clicked Reset Password in Forgot Password Pop Up Successfully", "PASS");
		}
		else {
			Log.info("Unable to Click Reset Password in Forgot Password Pop Up Successfully");
			reportStep("Unable to Click Reset Password in Forgot Password Pop Up Successfully", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//h2[text()='EMAIL SENT WITH NEW PASSWORD']")
	private static WebElement lblSuccessMessageForgotPassword;

	public WPForgotPassword verifyPresenceOfSuccessMessageForgotPassword(){
		Log.info("Locating Success Message : EMAIL SENT WITH NEW PASSWORD");
		reportStep("Locating Success Message : EMAIL SENT WITH NEW PASSWORD", "INFO");
		presence=Utils.verifyElementPresence(lblSuccessMessageForgotPassword);
		if(presence) {
			Log.info("Located Successfully Success Message : EMAIL SENT WITH NEW PASSWORD");
			reportStep("Located Successfully Success Message : EMAIL SENT WITH NEW PASSWORD.", "PASS");
		}
		else {
			Log.info("Unable to locate Success Message : EMAIL SENT WITH NEW PASSWORD");
			reportStep("Unable to locate Success Message : EMAIL SENT WITH NEW PASSWORD", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//span[text()='PASSWORD SENT!']")
	private static WebElement lblSuccessMsgPasswordSent;

	public WPForgotPassword verifyPresenceOfPasswordSentSuccessMessage(){
		Log.info("Locating Success Message : PASSWORD SENT!");
		reportStep("Locating Success Message : PASSWORD SENT!", "INFO");
		Utils.explicitWaitForVisibility(lblSuccessMsgPasswordSent);
		presence=Utils.verifyElementPresence(lblSuccessMsgPasswordSent);
		if(presence) {
			Log.info("Located Successfully Success Message : PASSWORD SENT!");
			reportStep("Located Successfully Success Message : PASSWORD SENT!", "PASS");
		}
		else {
			Log.info("Unable to locate Success Message : PASSWORD SENT!");
			reportStep("Unable to locate Success Message : PASSWORD SENT!", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//p[text()='You’ve got mail!']")
	private static WebElement lblyouHaveGotMail;

	public WPForgotPassword verifyPresenceOfYouHaveGotMailMsg(){
		Log.info("Locating Success Message : You Have got Mail !");
		reportStep("Locating Success Message : You Have got Mail !", "INFO");
		presence=Utils.verifyElementPresence(lblyouHaveGotMail);
		if(presence) {
			Log.info("Located Successfully Success Message :You Have got Mail !");
			reportStep("Located Successfully Success Message : You Have got Mail !", "PASS");
		}
		else {
			Log.info("Unable to locate Success Message : You Have got Mail !");
			reportStep("Unable to locate Success Message : You Have got Mail !", "FAIL");
		}
		return this;
	}

}
