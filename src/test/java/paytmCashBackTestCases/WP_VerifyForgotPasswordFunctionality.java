package paytmCashBackTestCases;

import org.testng.annotations.Test;
import pageObjects.WPHomePage;
import utility.TestSetUp;
import utility.Log;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 * This class will verify all negative test cases related with Forgot Password Functionality.
 * Getting Password from email is not automated. This testing needs to be done manually.
 * 
 */
public class WP_VerifyForgotPasswordFunctionality extends TestSetUp{

	/**
	 * This method will verify Forgot Password Functionality. 
	 * Enter correct email and click on Reset Password Link. 
	 * Verify Success Message.
	 */
	@Test(enabled=true)
	public void verifySuccessfulForgotPasswordFunctionality() {
		Log.info("Validation of Forgot Password Functionality started--------");
		reportStep("Validation of Forgot Password Functionality started--------", "INFO");
		String email=Utils.getTestData(5,"forgotPasswordEmail");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickOnForgotPassword().
		enterForgotPasswordEmail(email).
		clickResetPasswordLink().
		verifyPresenceOfPasswordSentSuccessMessage().
		verifyPresenceOfSuccessMessageForgotPassword().
		verifyPresenceOfYouHaveGotMailMsg();
		Log.info("Validation of Forgot Password Functionality COMPLETED--------");
		reportStep("Validation of Forgot Password Functionality COMPLETED--------", "PASS");
	}

	/**
	 * This method will verify all label and button Text in Forgot Password Pop Up
	 * Also it will verify placeholder value of ForgotPassword Email
	 */
	@Test(enabled=true)
	public void verifyDefaultContentOfForgotPasswordPopUp() {
		Log.info("Validation of Forgot Password Default Content started--------");
		reportStep("Validation of Forgot Password Default Content started--------", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickOnForgotPassword().
		verifyPlaceholderValueOfForgotPwdEmail().
		verifyPresenceOFResetPasswordLabel().
		verifyResetPasswordText().
		clickOnLoginLink();
		Log.info("Validation of Forgot Password Default Content COMPLETED--------");
		reportStep("Validation of Forgot Password Default Content COMPLETED--------", "PASS");

	}

	/**
	 * This method will Verify error message "Please enter valid email address." 
	 * if user is not registered. Verify text "ENTER CORRECT EMAIL ID". 
	 * Verify text "Your Email ID was not found.
	 */
	@Test(enabled=true)
	public void verifyErrorMessageInForgotPwdIfUserIsnotRegistered() {
		Log.info("Validation of Forgot Password Functionality started--------");
		reportStep("Validation of Forgot Password Functionality started--------", "INFO");
		String email=Utils.generateRandomEmailId();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickOnForgotPassword().
		enterForgotPasswordEmail(email).
		clickResetPasswordLink().
		verifyInvalidEmailErrorMsg().
		verifyErrorMsgOopsThisIsntYourEmail().
		verifyEnterCorrectMailIdMsg();
		Log.info("Validation of Forgot Password Functionality COMPLETED--------");
		reportStep("Validation of Forgot Password Functionality COMPLETED--------", "PASS");
	}
	
	/**
	 * This method will verify Format of Email ID in Forgot Password Pop Up.
	 */
	@Test(enabled=true)
	public void verifyFormatOfEmailAddressInForgotPasswordPopUp() {
		Log.info("Validation of Format of email id accepted In Forgot Password pop up Started -----");
		reportStep("Validation of Format of email id accepted In Forgot Password pop up  Started -----", "INFO");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickOnForgotPassword().
		clickResetPasswordLink().
		verifyInvalidEmailErrorMsg().
		clickOnLoginLink().
		clickOnForgotPassword().
		enterForgotPasswordEmail(Utils.getTestData(2, "invalidEmailId1")).
		clickResetPasswordLink().
		verifyInvalidEmailErrorMsg().
		clickOnLoginLink().
		clickOnForgotPassword().
		enterForgotPasswordEmail(Utils.getTestData(2, "invalidEmailId2")).
		clickResetPasswordLink().
		verifyInvalidEmailErrorMsg().
		clickOnLoginLink().
		clickOnForgotPassword().
		enterForgotPasswordEmail(Utils.getTestData(2, "invalidEmailId3")).
		clickResetPasswordLink().
		verifyInvalidEmailErrorMsg();
		Log.info("Validation of Format of email id accepted In Forgot Password pop up COMPLETED -----");
		reportStep("Validation of Format of email id accepted In Forgot Password pop up  COMPLETED -----", "PASS");
	}
	
	/**
	 * This method will verify max length of 
	 * Email ID in Forgot Password Pop Up.
	 */
	@Test(enabled=true)
	public void verifyMaxLengthOfForgotPasswordEmailId() {
		Log.info("Validation of Max-Length of email id In Forgot Password pop up Started -----");
		reportStep("Validation of Max-Length of email id In Forgot Password pop up Started  -----", "INFO");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickOnForgotPassword().
		verifyMaxLengthOfForgotPasswordEmail();
		Log.info("Validation of Max-Length of email id In Forgot Password pop up COMPLETED -----");
		reportStep("Validation of Max-Length of email id In Forgot Password pop up COMPLETED  -----", "PASS");
	}
}
