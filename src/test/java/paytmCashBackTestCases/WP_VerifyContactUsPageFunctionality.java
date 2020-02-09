package paytmCashBackTestCases;

import org.testng.annotations.Test;

import pageObjects.WPContactUsPage;
import pageObjects.WPHomePage;
import pageObjects.WPSignUpSignInPopUp;
import utility.TestSetUp;
import utility.Log;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 *This class will verify Contact Us page functionality for both guest user and registered user.
 *Also it will include all validations for positive and negative scenarios.
 *GU stands for Guest User
 *RU stands for Registered User
 */
public class WP_VerifyContactUsPageFunctionality extends TestSetUp{

	/**
	 * This method will verify default Page Content for Guest User e.g
	 *  all labels, presence of Submit button and its text, Page Header Info
	 *  
	 */
	@Test(enabled=true)
	public void GU_verifyDefaultPageContent() {
		Log.info("Validation of default content for Guest User in contact Us page started-----");
		reportStep("Validation of default content for Guest User in contact Us page started-----", "INFO");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		verifyPresenceOfChooseTopicLabelInContactUsPage().
		verifyPresenceOfEmailAddressLabelInContactUsPage().
		verifyPresenceOfMessageLabelInContactUsPage().
		verifyPresenceOfNameLabelInContactUsPage().
		verifyPresenceOfSayHelloLabelInContactUsPage().
		verifyPresenceOfSubmitButtonInContactUsPage().
		verifyPresenceOfSubmitTextInSubmitButtonOfContactUsPage();
		Log.info("Validation of default content for Guest User in contact Us page COMPLETED-----");
		reportStep("Validation of default content for Guest User in contact Us page COMPLETED-----", "PASS");
	}
	
	/**
	 * This method will verify default Page Content for Registered User e.g
	 *  all labels, presence of Submit button and its text, Page Header Info
	 *  
	 */
	@Test(enabled=true)
	public void RU_verifyDefaultPageContent() {
		Log.info("Validation of default content for Registered User in contact Us page started-----");
		reportStep("Validation of default content for Registered User in contact Us page started-----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		verifyPresenceOfChooseTopicLabelInContactUsPage().
		verifyPresenceOfEmailAddressLabelInContactUsPage().
		verifyPresenceOfMessageLabelInContactUsPage().
		verifyPresenceOfNameLabelInContactUsPage().
		verifyPresenceOfSayHelloLabelInContactUsPage().
		verifyPresenceOfSubmitButtonInContactUsPage().
		verifyPresenceOfSubmitTextInSubmitButtonOfContactUsPage();
		Log.info("Validation of default content for Registered User in contact Us page COMPLETED-----");
		reportStep("Validation of default content for Registered User in contact Us page COMPLETED-----", "PASS");
	}
	
	/**
	 * This method will verify presence of error message in case guest user submits an empty form 
	 *  in Contact Us Page.
	 */
	@Test(enabled=true)
	public void GU_verifyErrorMessageForEmptyFieldsInContactUsPage(){
		Log.info("Validation of Error Messages when guest User submit empty form in contact Us page started-----");
		reportStep("Validation of Error Messages when guest User submit empty form in contact Us page started-----", "INFO");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		clickSubmitButtonInConTactUs().
		verifyPresenceOfErrorMsgForChooseTopic().
		verifyPresenceOfErrorMsgEmptyFullName().
		verifyPresenceOfErrorMsgEmailAddress().
		verifyPresenceOfErrorMsgEmptyMessage();
		Log.info("Validation of Error Messages when guest  User submit empty form in contact Us page COMPLETED-----");
		reportStep("Validation of Error Messages when guest User submit empty form in contact Us page COMPLETED-----", "PASS");
	}
	
	/**
	 * This method will verify presence of error message in case registered user submits an empty form 
	 *  in Contact Us Page.
	 */
	@Test(enabled=true)
	public void RU_verifyErrorMessageForEmptyFieldsInContactUsPage(){
		Log.info("Validation of Error Messages when Registered User submit empty form in contact Us page started-----");
		reportStep("Validation of Error Messages  when Registered User submit empty form in contact Us page started-----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		clickSubmitButtonInConTactUs().
		verifyPresenceOfErrorMsgForChooseTopic().
		verifyPresenceOfErrorMsgEmptyFullName().
		verifyPresenceOfErrorMsgEmailAddress().
		verifyPresenceOfErrorMsgEmptyMessage();
		Log.info("Validation of Error Messages  when Registered User submit empty form in contact Us page COMPLETED-----");
		reportStep("Validation of Error Messages when Registered User submit empty form in contact Us page COMPLETED-----", "PASS");
	}
	
	/**
	 * Verify Error Message "Please Choose the subject" when guest user click on "Select from List below"
	 * and then click on search bar at header.
	 */
	@Test(enabled=true)
	public void GU_verifyErrorMessageForDropDownWhenUserClickDropDownAndClickSowmewhereElse(){
		Log.info("Validation of Error Messages when Guest User s click on \"Select from List below\" and then click on search bar started-----");
		reportStep("Validation of Error Messages when Guest User s click on \"Select from List below\" and then click on search bar started-----", "INFO");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		clickChooseTopicDropDown().
		searchForVoucherOrStore("").
		verifyPresenceOfErrorMsgForChooseTopic();
		Log.info("Validation of Error Messages when Guest User s click on \"Select from List below\" and then click on search bar COMPLETED-----");
		reportStep("Validation of Error Messages when Guest User s click on \"Select from List below\" and then click on search bar COMPLETED-----", "PASS");
		
	}
	
	/**
	 * Verify Error Message "Please Choose the subject" when Registered user click on "Select from List below"
	 * and then click on search bar at header.
	 */
	@Test(enabled=true)
	public void RU_verifyErrorMessageForDropDownWhenUserClickDropDownAndClickSowmewhereElse(){
		Log.info("Validation of Error Messages when Registered Users click on \"Select from List below\" and then click on search bar started-----");
		reportStep("Validation of Error Messages when Registered Users click on \"Select from List below\" and then click on search bar started-----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		clickChooseTopicDropDown().
		searchForVoucherOrStore("").
		verifyPresenceOfErrorMsgForChooseTopic();
		Log.info("Validation of Error Messages when Registered Users click on \"Select from List below\" and then click on search bar COMPLETED-----");
		reportStep("Validation of Error Messages when Registered Users click on \"Select from List below\" and then click on search bar COMPLETED-----", "PASS");
		
	}
	
	/**
	 * Verify Error Message "Please type your name" when Guest user click on Full Name Text Box
	 * and then click on search bar at header.
	 */
	@Test(enabled=true)
	public void GU_verifyErrorMessageWhenUserClickOnNameAndThenClickSowmewhereElse(){
		Log.info("Validation of Error Messages when Guest Users click on \"Name Text box\" and then click on search bar started-----");
		reportStep("Validation of Error Messages when Guest Users click on \"Name Text box\" and then click on search bar started-----", "INFO");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		enterFullName("").
		searchForVoucherOrStore("").
		verifyPresenceOfErrorMsgEmptyFullName();
		Log.info("Validation of Error Messages when Guest Users click on \"Name Text box\" and then click on search bar COMPLETED-----");
		reportStep("Validation of Error Messages when Guest Users click on \"Name Text box\" and then click on search bar COMPLETED-----", "PASS");
		
	}
	
	/**
	 * Verify Error Message "Please type your name" when Registered user click on Full Name Text Box
	 * and then click on search bar at header.
	 */
	@Test(enabled=true)
	public void RU_verifyErrorMessageWhenUserClickOnNameAndThenClickSowmewhereElse(){
		Log.info("Validation of Error Messages when Registered Users click on \"Name Text box\" and then click on search bar started-----");
		reportStep("Validation of Error Messages when Registered Users click on \"Name Text box\" and then click on search bar started-----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		enterFullName("").
		searchForVoucherOrStore("").
		verifyPresenceOfErrorMsgEmptyFullName();
		Log.info("Validation of Error Messages when Registered Users click on \"Name Text box\" and then click on search bar COMPLETED-----");
		reportStep("Validation of Error Messages when Registered Users click on \"Name Text box\" and then click on search bar COMPLETED-----", "PASS");
		
	}
	
	/**
	 * Verify Error Message "Please enter a valid email" when Guest user click on Email Address Text Box
	 * and then click on search bar at header.
	 */
	@Test(enabled=true)
	public void GU_verifyErrorMessageWhenUserClickOnEmailAndThenClickSowmewhereElse(){
		Log.info("Validation of Error Messages when Guest Users click on \"Email Address text box\" and then click on search bar started-----");
		reportStep("Validation of Error Messages when Guest Users click on \"Email Address text box\" and then click on search bar started-----", "INFO");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		enterEmailAddress("").
		searchForVoucherOrStore("").
		verifyPresenceOfErrorMsgEmailAddress();
		Log.info("Validation of Error Messages when Guest Users click on \"Email Address text box\" and then click on search bar COMPLETED-----");
		reportStep("Validation of Error Messages when Guest Users click on \"Email Address text box\" and then click on search bar COMPLETED-----", "PASS");
		
	}
	
	/**
	 * Verify Error Message "Please enter a valid email" when Registered user click on Email Address Text Box
	 * and then click on search bar at header.
	 */
	@Test(enabled=true)
	public void RU_verifyErrorMessageWhenUserClickOnEmailAndThenClickSowmewhereElse(){
		Log.info("Validation of Error Messages when Guest Users click on \"Email Address text box\" and then click on search bar started-----");
		reportStep("Validation of Error Messages when Guest Users click on \"Email Address text box\" and then click on search bar started-----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		enterEmailAddress("").
		searchForVoucherOrStore("").
		verifyPresenceOfErrorMsgEmailAddress();
		Log.info("Validation of Error Messages when Registered Users click on \"Email Address text box\" and then click on search bar COMPLETED-----");
		reportStep("Validation of Error Messages when Registered Users click on \"Email Address text box\" and then click on search bar COMPLETED-----", "PASS");
		
	}
	
	/**
	 * Verify Error Message "Please type your message" when Registered user click on Message Text Area
	 * and then click on search bar at header.
	 */
	@Test(enabled=true)
	public void RU_verifyErrorMessageWhenUserClickOnMessageAndThenClickSowmewhereElse(){
		Log.info("Validation of Error Messages when Registered Users click on \"Message Text Area\" and then click on search bar started-----");
		reportStep("Validation of Error Messages when Registered Users click on \"Message Text Area\" and then click on search bar started-----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		enterMessageInMessageTextArea("").
		searchForVoucherOrStore("").
		verifyPresenceOfErrorMsgEmptyMessage();
		Log.info("Validation of Error Messages when Registered Users click on \"Message Text Area\" and then click on search bar COMPLETED-----");
		reportStep("Validation of Error Messages when Registered Users click on \"Message Text Area\" and then click on search bar COMPLETED-----", "PASS");
		
	}
	
	/**
	 * Verify Error Message "Please type your message" when Guest user click on Message Text Area
	 * and then click on search bar at header.
	 */
	@Test(enabled=true)
	public void GU_verifyErrorMessageWhenUserClickOnMessageAndThenClickSowmewhereElse(){
		Log.info("Validation of Error Messages when Guest User s click on \"Message Text Area\" and then click on search bar started-----");
		reportStep("Validation of Error Messages when Guest User s click on \"Message Text Area\" and then click on search bar started-----", "INFO");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		enterMessageInMessageTextArea("").
		searchForVoucherOrStore("").
		verifyPresenceOfErrorMsgEmptyMessage();
		Log.info("Validation of Error Messages when Guest Users click on \"Message Text Area\" and then click on search bar COMPLETED-----");
		reportStep("Validation of Error Messages when Guest Users click on \"Message Text Area\" and then click on search bar COMPLETED-----", "PASS");
		
	}
	
	/**
	 * This method will verify max length of email id and name field for Guest User in contact us Page.
	 */
	@Test(enabled=true)
	public void GU_verifyMaxLengthOfEmailAndNameFieldInContactUsPage() {
		Log.info("Validation of Max length of EMail Address and Full Name Textbox for Guest User started-----");
		reportStep("Validation of Max length of EMail Address and Full Name Textbox for Guest User started-----", "INFO");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		verifyMaxLenthOfNameTextBox().
		verifyMaxLenthOfEmailAddressTextBox();
		Log.info("Validation of Max length of EMail Address and Full Name Textbox for Guest User COMPLETED----------");
		reportStep("Validation of Max length of EMail Address and Full Name Textbox for Guest User COMPLETED----------", "PASS");
	}
	
	/**
	 * This method will verify max length of email id and name field for Registered User in contact us Page.
	 */
	@Test(enabled=true)
	public void RU_verifyMaxLengthOfEmailAndNameFieldInContactUsPage() {
		Log.info("Validation of Max length of EMail Address and Full Name Textbox for Registered User started-----");
		reportStep("Validation of Max length of EMail Address and Full Name Textbox for Registered User started-----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		verifyMaxLenthOfNameTextBox().
		verifyMaxLenthOfEmailAddressTextBox();
		Log.info("Validation of Max length of EMail Address and Full Name Textbox for Registered User COMPLETED----------");
		reportStep("Validation of Max length of EMail Address and Full Name Textbox for Registered User COMPLETED----------", "PASS");
	}
	
	/**
	 * For Guest User:
	 * This method will verify that on clicking Contact Us in footer from footer, user should navigated to 
	 * Contact Us Page and it will Verify Page Title of Contact Us Page.
	 */
	@Test(enabled=true)
	public void GU_verifyOnClickingContactUsLinkFromFooterUserWillNavigateToContactUsPage() {
		Log.info("Validation of Navigation by clicking on Contact Us Link from Contact Us Page for Guest User started-----");
		reportStep("Validation of Navigation by clicking on Contact Us Link from Contact Us Page for Guest User started-----", "INFO");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		verifyPageTitle().
		clickContactUsLink().
		verifyPageTitle();
		Log.info("Validation of Navigation by clicking on Contact Us Link from Contact Us Page for Guest User COMPLETED-----");
		reportStep("Validation of Navigation by clicking on Contact Us Link from Contact Us Page for Guest User COMPLETED-----", "PASS");
	}
	
	
	/**
	 * For Registered User:
	 * This method will verify that on clicking Contact Us in footer from footer, user should navigated to 
	 * Contact Us Page and it will Verify Page Title of Contact Us Page.
	 */
	@Test(enabled=true)
	public void RU_verifyOnClickingContactUsLinkFromFooterUserWillNavigateToContactUsPage() {
		Log.info("Validation of Navigation by clicking on Contact Us Link from Contact Us Page for Guest User started-----");
		reportStep("Validation of Navigation by clicking on Contact Us Link from Contact Us Page for Guest User started-----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		verifyPageTitle().
		clickContactUsLink().
		verifyPageTitle();
		Log.info("Validation of Navigation by clicking on Contact Us Link from Contact Us Page for Guest User COMPLETED-----");
		reportStep("Validation of Navigation by clicking on Contact Us Link from Contact Us Page for Guest User COMPLETED-----", "PASS");
	}
	
	/**
	 * This method will verify format of email id which will not be accepted for Guest User in Contact Us Page.
	 */
	@Test(enabled=true)
	public void GU_verifyFormatOfEmailAdrressInContactUsPage() {
		Log.info("Validation of Format of email id accepted In Contact Us Page Started -----");
		reportStep("Validation of Format of email id accepted In  Contact Us Page Started -----", "INFO");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		clickSubmitButtonInConTactUs().
		verifyPresenceOfErrorMsgEmailAddress().
		refreshContactUsPage().
		enterEmailAddress(Utils.getTestData(2, "invalidEmailId1")).
		clickSubmitButtonInConTactUs().
		verifyPresenceOfErrorMsgEmailAddress().
		refreshContactUsPage().
		enterEmailAddress(Utils.getTestData(2, "invalidEmailId2")).
		clickSubmitButtonInConTactUs().
		verifyPresenceOfErrorMsgEmailAddress().
		refreshContactUsPage().
		enterEmailAddress(Utils.getTestData(2, "invalidEmailId3")).
		clickSubmitButtonInConTactUs().
		verifyPresenceOfErrorMsgEmailAddress();
		Log.info("Validation of Format of email id accepted In  Contact Us Page is Completed -----");
		reportStep("Validation of Format of email id accepted In  Contact Us Page is Completed -----", "PASS");
	}
	
	/**
	 * This method will verify format of email id which will not be accepted for Registered User in Contact Us Page.
	 */
	
	@Test(enabled=true)
	public void RU_verifyFormatOfEmailAdrressInContactUsPage() {
		Log.info("Validation of Format of email id accepted In Contact Us Page Started -----");
		reportStep("Validation of Format of email id accepted In  Contact Us Page Started -----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		clickSubmitButtonInConTactUs().
		verifyPresenceOfErrorMsgEmailAddress().
		refreshContactUsPage().
		enterEmailAddress(Utils.getTestData(2, "invalidEmailId1")).
		clickSubmitButtonInConTactUs().
		verifyPresenceOfErrorMsgEmailAddress().
		refreshContactUsPage().
		enterEmailAddress(Utils.getTestData(2, "invalidEmailId2")).
		clickSubmitButtonInConTactUs().
		verifyPresenceOfErrorMsgEmailAddress().
		refreshContactUsPage().
		enterEmailAddress(Utils.getTestData(2, "invalidEmailId3")).
		clickSubmitButtonInConTactUs().
		verifyPresenceOfErrorMsgEmailAddress();
		Log.info("Validation of Format of email id accepted In  Contact Us Page is Completed -----");
		reportStep("Validation of Format of email id accepted In  Contact Us Page is Completed -----", "PASS");
	}
	
	/**
	 * This method will verify format of full name for Guest User.
	 * It will enter numbers and special characters and then click on Submit.
	 * On clicking Submit, form will give error message as system will not accept either 
	 * of the inputs. After clicking Submit method will verify presence of error message.
	 * 
	 */
	
	@Test(enabled=true)
	public void GU_verifyNegativeCasesForFullNameInContactUsPage() {
		Log.info("Validation of Full Name Format In Contact Us Page Started -----");
		reportStep("Validation of Full Name Format In Contact Us  Page Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickContactUsLink().
		clickSubmitButtonInConTactUs().
		verifyErrorMsgForFullNameTxtBox().
		refreshContactUsPage().
		enterFullName(Utils.getTestData(2, "invalidFullName1")).
		clickSubmitButtonInConTactUs().
		verifyErrorMsgForFullNameTxtBox().
		refreshContactUsPage().
		enterFullName(Utils.getTestData(2, "invalidFullName2")).
		clickSubmitButtonInConTactUs().
		verifyErrorMsgForFullNameTxtBox();
		Log.info("Validation of Full Name Format In Contact Us  Page is Completed -----");
		reportStep("Validation of Full Name Format In Contact Us  Page is Completed -----", "PASS");

	}
	
	/**
	 * This method will verify format of full name for Registered User.
	 * It will enter numbers and special characters and then click on Submit.
	 * On clicking Submit, form will give error message as system will not accept either 
	 * of the inputs. After clicking Submit method will verify presence of error message.
	 * 
	 */
	
	@Test(enabled=true)
	public void RU_verifyNegativeCasesForFullNameInContactUsPage() {
		Log.info("Validation of Full Name Format In Contact Us Page Started -----");
		reportStep("Validation of Full Name Format In Contact Us  Page Started -----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		clickSubmitButtonInConTactUs().
		verifyErrorMsgForFullNameTxtBox().
		refreshContactUsPage().
		enterFullName(Utils.getTestData(2, "invalidFullName1")).
		clickSubmitButtonInConTactUs().
		verifyErrorMsgForFullNameTxtBox().
		refreshContactUsPage().
		enterFullName(Utils.getTestData(2, "invalidFullName2")).
		clickSubmitButtonInConTactUs().
		verifyErrorMsgForFullNameTxtBox();
		Log.info("Validation of Full Name Format In Contact Us  Page is Completed -----");
		reportStep("Validation of Full Name Format In Contact Us  Page is Completed -----", "PASS");

	}
	
	/**
	 * This method will verify when a guest user logins from Contact Us Page
	 * He should land into Contact Us Page.
	 * Pre-condition: User account should be registered.
	 */
	@Test(enabled=true)
	public void RU_verifyWhenGuestUserLoginFromContactUsPageLandsIntoContactUsPage() {
		Log.info("Validation Guest User Login From Contact Us Page Landing Into Contact Us Page Started -----");
		reportStep("Validation Guest User Login From Contact Us Page Landing Into Contact Us Page Started -----", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		verifyPageTitle();
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		verifyPageTitle();
		Log.info("Validation Guest User Login From Contact Us Page Landing Into Contact Us Page COMPLETED -----");
		reportStep("Validation Guest User Login From Contact Us Page Landing Into Contact Us Page COMPLETED -----", "PASS");
	}
	
	/**
	 * This method will verify when a user registered from contact us page, after successful
	 * registration user will land into Contact Us Page
	 */
	@Test(enabled=true)
	public void GU_verifyWhenUserSignUpSuccessfullyFromContactUsPageLandIntoContactUsPage() {
		Log.info("Validation Guest User Login From Contact Us Page Landing Into Contact Us Page Started -----");
		reportStep("Validation Guest User Login From Contact Us Page Landing Into Contact Us Page Started -----", "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickContactUsLink().
		verifyPageTitle();
		new WPHomePage(driver, logger). // Here new object creation is necessary.
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		explicitWaitForOTPTxtBox();
		String otp=Utils.getOTPCode(mobile, driver);
		new WPSignUpSignInPopUp(driver, logger). // Here new object creation is necessary.
		enterOtpDuringSignUp(otp).
		clickVerifyOTP();
		new WPContactUsPage(driver, logger). // Here new object creation is necessary.
		verifyPageTitle();
		Log.info("Validation Guest User Login From Contact Us Page Landing Into Contact Us Page COMPLETED -----");
		reportStep("Validation Guest User Login From Contact Us Page Landing Into Contact Us Page COMPLETED -----", "PASS");
	}
	
	/**
	 * This method will verify full name, email and message body is editable and enabled for Guest User.
	 */
	@Test(enabled=true)
	public void GU_verifyNameEmailAndMessageIsEnabledAndEditable() {
		Log.info("Validation of Full Name, Email and Message body enability and Editability in Contact Us Page Started -----");
		reportStep("Validation of Full Name, Email and Message body enability and Editability in Contact Us Page Started -----", "INFO");
		String initialName=Utils.getTestData(4, "initialName");
		String initialMessage=Utils.getTestData(4, "initialMessage");
		String laterName=Utils.getTestData(4, "laterName");
		String initialEmail=Utils.getTestData(4, "initialEmail");
		String laterEmail=Utils.getTestData(4, "laterEmail");
		String laterMessage=Utils.getTestData(4, "laterMessage");
		new WPHomePage(driver, logger).
		clickContactUsLink().
		enterEmailAddress(initialEmail).
		enterFullName(initialName).
		enterMessageInMessageTextArea(initialMessage);
		initialName=Utils.fetchConsoleValue("#fullname", driver); //Below three lines are hardcoded. Will discuss with Mallikarjuna on this.
		initialEmail=Utils.fetchConsoleValue("#contact_from_email", driver);
		initialMessage=Utils.fetchConsoleValue("#message", driver);
		new WPContactUsPage(driver, logger).
		enterEmailAddress(laterEmail).
		enterFullName(laterName).
		enterMessageInMessageTextArea(laterMessage).
		verifyEmailAddressIsEditableAndEnabled(initialEmail).
		verifyNameTextBoxIsEditableAndEnabled(initialName).
		verifyTextAreaIsEditableAndEnabled(initialMessage);
		Log.info("Validation of Full Name, Email and Message body enability and Editability in Contact Us Page COMPLETED -----");
		reportStep("Validation of Full Name, Email and Message body enability and Editability in Contact Us Page COMPLETED -----", "PASS");
	}
	
	/**
	 * This method will verify full name, email and message body is editable and enabled for Registered User.
	 */
	@Test(enabled=true)
	public void RU_verifyNameEmailAndMessageIsEnabledAndEditable() {
		Log.info("Validation of Full Name, Email and Message body enability and Editability in Contact Us Page Started -----");
		reportStep("Validation of Full Name, Email and Message body enability and Editability in Contact Us Page Started -----", "INFO");
		String initialName=Utils.getTestData(4, "initialName");
		String initialMessage=Utils.getTestData(4, "initialMessage");
		String laterName=Utils.getTestData(4, "laterName");
		String initialEmail=Utils.getTestData(4, "initialEmail");
		String laterEmail=Utils.getTestData(4, "laterEmail");
		String laterMessage=Utils.getTestData(4, "laterMessage");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		enterEmailAddress(initialEmail).
		enterFullName(initialName).
		enterMessageInMessageTextArea(initialMessage);
		initialName=Utils.fetchConsoleValue("#fullname", driver); //Below three lines are hardcoded. Will discuss with Mallikarjuna on this.
		initialEmail=Utils.fetchConsoleValue("#contact_from_email", driver);
		initialMessage=Utils.fetchConsoleValue("#message", driver);
		new WPContactUsPage(driver, logger).
		enterEmailAddress(laterEmail).
		enterFullName(laterName).
		enterMessageInMessageTextArea(laterMessage).
		verifyEmailAddressIsEditableAndEnabled(initialEmail).
		verifyNameTextBoxIsEditableAndEnabled(initialName).
		verifyTextAreaIsEditableAndEnabled(initialMessage);
		Log.info("Validation of Full Name, Email and Message body enability and Editability in Contact Us Page COMPLETED -----");
		reportStep("Validation of Full Name, Email and Message body enability and Editability in Contact Us Page COMPLETED -----", "PASS");
	}
	
	/**
	 * This method will select "General Enquires" from Drop Down Choose topic, enter Name, email and message 
	 * about user concerns and click on Submit button on Contact Us Page For Guest User.
	 */
	@Test(enabled=true)
	public void GU_verifySubmitionOfContactUsFormBySelectingGeneralQueries() {
		Log.info("Validation of Submission of Contact Us Form By Selecting General Queries in Contact Us Page Started -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting General Queries in Contact Us Page Started ----- -----", "INFO");
		String name=Utils.getTestData(4, "initialName");
		String email=Utils.getTestData(4, "initialEmail");
		String message=Utils.getTestData(4, "initialMessage");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		selectByValueFromDropDown("General enquires").
		enterFullName(name).
		enterEmailAddress(email).
		enterMessageInMessageTextArea(message).
		clickSubmitButtonInConTactUs().
		successMsgSentSuccesFullyContactUs();
		Log.info("Validation of Submission of Contact Us Form By Selecting General Queries in Contact Us Page COMPLETED -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting General Queries in Contact Us Page COMPLETED -----", "PASS");
	}
	
	/**
	 * This method will select "General Enquires" from Drop Down Choose topic, enter Name, email and message 
	 * about user concerns and click on Submit button on Contact Us Page For Registered User.
	 */
	@Test(enabled=true)
	public void RU_verifySubmitionOfContactUsFormBySelectingGeneralQueries() {
		Log.info("Validation of Submission of Contact Us Form By Selecting \"General Queries\" in Contact Us Page Started -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting \"General Queries\" in Contact Us Page Started -----", "INFO");
		String name=Utils.getTestData(4, "initialName");
		String message=Utils.getTestData(4, "initialMessage");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		selectByValueFromDropDown("General enquires").
		enterFullName(name).
		enterEmailAddress(email).
		enterMessageInMessageTextArea(message).
		clickSubmitButtonInConTactUs().
		successMsgSentSuccesFullyContactUs();
		Log.info("Validation of Submission of Contact Us Form By Selecting \"General Queries\" in Contact Us Page COMPLETED -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting \"General Queries\" in Contact Us Page COMPLETED -----", "PASS");
	}
	
	/**
	 * This method will select "My cashback is incorrect or missing" from Drop Down Choose topic, enter Name, email and message 
	 * about user concerns and click on Submit button on Contact Us Page For Guest User.
	 */
	@Test(enabled=true)
	public void GU_verifySubmitionOfContactUsFormBySelectingCashbackIncorrectOrMissing() {
		Log.info("Validation of Submission of Contact Us Form By Selecting \"My cashback is incorrect or missing\" in Contact Us Page Started -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting \"My cashback is incorrect or missing\" in Contact Us Page Started -----", "INFO");
		String name=Utils.getTestData(4, "initialName");
		String email=Utils.getTestData(4, "initialEmail");
		String message=Utils.getTestData(4, "initialMessage");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		selectByValueFromDropDown("My cashback is incorrect or missing").
		enterFullName(name).
		enterEmailAddress(email).
		enterMessageInMessageTextArea(message).
		clickSubmitButtonInConTactUs().
		successMsgSentSuccesFullyContactUs();
		Log.info("Validation of Submission of Contact Us Form By Selecting \"My cashback is incorrect or missing\" in Contact Us Page COMPLETED -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting \"My cashback is incorrect or missing\" in Contact Us Page COMPLETED -----", "PASS");
	}
	
	/**
	 * This method will select "My cashback is incorrect or missing" from Drop Down Choose topic, enter Name, email and message 
	 * about user concerns and click on Submit button on Contact Us Page For Registered User.
	 */
	@Test(enabled=true)
	public void RU_verifySubmitionOfContactUsFormBySelectingCashbackIncorrectOrMissing() {
		Log.info("Validation of Submission of Contact Us Form By Selecting \"My cashback is incorrect or missing\" in Contact Us Page Started -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting \"My cashback is incorrect or missing\" in Contact Us Page Started -----", "INFO");
		String name=Utils.getTestData(4, "initialName");
		String message=Utils.getTestData(4, "initialMessage");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		selectByValueFromDropDown("My cashback is incorrect or missing").
		enterFullName(name).
		enterEmailAddress(email).
		enterMessageInMessageTextArea(message).
		clickSubmitButtonInConTactUs().
		successMsgSentSuccesFullyContactUs();
		Log.info("Validation of Submission of Contact Us Form By Selecting \"My cashback is incorrect or missing\" in Contact Us Page  COMPLETED -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting \"My cashback is incorrect or missing\" in Contact Us Page COMPLETED -----", "PASS");
	}
	
	/**
	 * This method will select "Other" from Drop Down Choose topic, enter Name, email and message 
	 * about user concerns and click on Submit button on Contact Us Page For Guest User.
	 */
	@Test(enabled=true)
	public void GU_verifySubmitionOfContactUsFormBySelectingOtherInDropDown() {
		Log.info("Validation of Submission of Contact Us Form By Selecting \"OTHER\" in Contact Us Page Started -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting \"OTHER\" in Contact Us Page Started -----", "INFO");
		String name=Utils.getTestData(4, "initialName");
		String email=Utils.getTestData(4, "initialEmail");
		String message=Utils.getTestData(4, "initialMessage");
		new WPHomePage(driver,logger).
		clickContactUsLink().
		selectByValueFromDropDown("Other").
		enterFullName(name).
		enterEmailAddress(email).
		enterMessageInMessageTextArea(message).
		clickSubmitButtonInConTactUs().
		successMsgSentSuccesFullyContactUs();
		Log.info("Validation of Submission of Contact Us Form By Selecting \"OTHER\" in Contact Us Page COMPLETED -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting \"OTHER\" in Contact Us Page  COMPLETED -----", "PASS");
	}
	
	/**
	 * This method will select "Other" from Drop Down Choose topic, enter Name, email and message 
	 * about user concerns and click on Submit button on Contact Us Page For Registered User.
	 */
	@Test(enabled=true)
	public void RU_verifySubmitionOfContactUsFormBySelectingOtherInDropDown() {
		Log.info("Validation of Submission of Contact Us Form By Selecting \"OTHER\" in Contact Us Page Started -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting \"OTHER\" in Contact Us Page Started -----", "INFO");
		String name=Utils.getTestData(4, "initialName");
		String message=Utils.getTestData(4, "initialMessage");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver,logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickContactUsLink().
		selectByValueFromDropDown("Other").
		enterFullName(name).
		enterEmailAddress(email).
		enterMessageInMessageTextArea(message).
		clickSubmitButtonInConTactUs().
		successMsgSentSuccesFullyContactUs();
		Log.info("Validation of Submission of Contact Us Form By Selecting \"OTHER\" in Contact Us Page Started  COMPLETED -----");
		reportStep("Validation of Submission of Contact Us Form By Selecting \"OTHER\" in Contact Us Page COMPLETED -----", "PASS");
	}
	
	
}
