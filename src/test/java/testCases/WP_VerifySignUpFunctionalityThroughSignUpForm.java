package testCases;

import org.testng.annotations.Test;

import pageObjects.WPHomePage;
import pageObjects.WPJoinFree;
import pageObjects.WPSignUpSignInPopUp;
import utility.TestSetUp;
import utility.Log;
import utility.Utils;

/**	
 * @author QA - Rahul Tiwari
 * This class will verify various functionality of Sign UP. 
 * It will cover Sign Up from Sign Up pop Up and Sign Up from Join Free Page.
 * Test Data are fetched from TestData.xml file.
 */
public class WP_VerifySignUpFunctionalityThroughSignUpForm extends TestSetUp{

	/**Verify On clicking Sign UP link you are landed into Sign Up Form.
	 *  Also verify Sign UP text with this.Verify placeholder value : Full Name:*,
	 *  Email Address*,Choose Password*,Enter Mobile Number:* 
	 *  Verify Sign Up Text for the button.
	 */	
	@Test(enabled=true)
	public void verifyPlaceHolderValueOfAllFieldsInSignUpPopUp() {
		Log.info("Validation of PlaceHolder Value Of All Fields In SignUp PopUp Started -----");
		reportStep("Validation of PlaceHolder Value Of All Fields In SignUp PopUp Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		verifyTextOfSignUpTab().
		clickSignUpTab().
		verifyPlaceholderValueFullNameDuringSignUp().
		verifyPlaceholderValuePasswordSignUp().
		verifyEmailPlaceHolderValue().
		verifyJoinWithEmailLabelSignUp().
		verifyPlaceholderValueOfMobileNumberTextBoxSignUp(Utils.getTestData(1, "placeHolderMobileNumber"));
		Log.info("Validation of PlaceHolder Value Of All Fields In SignUp PopUp Completed -----");
		reportStep("Validation of PlaceHolder Value Of All Fields In SignUp PopUp Completed -----", "PASS");

	}

	/**This method will verify successful Sign Up using correct credentials.
	 * Enter Full Name, Mobile Number which should be unique, Email Id which should be unique and password.
	 */
	@Test(enabled=true)
	public void successFulSignUpUsingCorrectCredentials() {
		Log.info("Validation of SignUp Successful Functionality Started -----");
		reportStep("Validation of SignUp Successful Functionality Started -----", "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		refreshHomePage(driver);
		Log.info("Validation of SignUp Successful Functionality Completed -----");
		reportStep("Validation of SignUp Successful Functionality Completed -----", "PASS");

	}

	/**Below method will verify Error messages for Mobile Number Field
	 */
	@Test(enabled=true)
	public void verifyErrorMessageAndNegativeScenariosForMobileFieldInSignUp() {
		Log.info("Validation of All Negative Scenarios For Mobile Number Fields In SignUp PopUp Started -----");
		reportStep("Validation of All Negative Scenarios For Mobile Number Fields In SignUp PopUp Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		verifyNegativeScenariosForMobileNumberTextBoxSignUp(Utils.getTestData(2, "specialCharacter")).
		verifyNegativeScenariosForMobileNumberTextBoxSignUp(Utils.getTestData(2, "alphaunumeric")).
		verifyMaxLengthOfMobileNumber().
		clickMobileNumberTextBoxSignUp().
		clickJoinWithEmailDuringSignUp().
		verifyPlaceholderValueOfMobileNumberTextBoxSignUp(Utils.getTestData(1, "errorMsgMobileNumber"));
		Log.info("Validation of All Negative Scenarios For Mobile Number  Fields In SignUp PopUp Completed -----");
		reportStep("Validation of All Negative Scenarios For Mobile Number  Fields In SignUp PopUp Completed -----", "PASS");

	}

	/**Below method will verify Terms and condition page and its functionality
	 */
	@Test(enabled=true)
	public void verifyTermsAndConditionsFunctionalitySignUp() {
		Log.info("Validation of Terms and Conditions Functionality In SignUp PopUp Started -----");
		reportStep("Validation of Terms and Conditions Functionality  In SignUp PopUp Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		clickTermsAndConditions().
		verifyPageTitleOfTermsAndCondition(Utils.getTestData(2, "pageTitle"));
		Log.info("Validation of Terms and Conditions Functionality  In SignUp PopUp Completed -----");
		reportStep("Validation of Terms and Conditions Functionality In SignUp PopUp Completed -----", "PASS");

	}

	/**Below message will verify Format of email id which should not be accepted
	 */
	@Test(enabled=true)
	public void verifyFormatOfEmailIdInSignUpForm() {
		Log.info("Validation of Format of email id accepted In SignUp PopUp Started -----");
		reportStep("Validation of Format of email id accepted In SignUp PopUp Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessageForInvalidEmailSignUp().
		enterEmailIDDuringSignUp(Utils.getTestData(2, "invalidEmailId1")).
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessageForInvalidEmailSignUp().
		enterEmailIDDuringSignUp(Utils.getTestData(2, "invalidEmailId2")).
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessageForInvalidEmailSignUp().
		enterEmailIDDuringSignUp(Utils.getTestData(2, "invalidEmailId3")).
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessageForInvalidEmailSignUp().
		verifyMaxLengthOfEmailIdFieldSignUp();
		Log.info("Validation of Format of email id accepted In SignUp PopUp is Completed -----");
		reportStep("Validation of Format of email id accepted In SignUp PopUp is Completed -----", "PASS");
	}

	/**Below method will verify error message for full name
	 */
	@Test(enabled=true)
	public void verifyNegativeCasesOfFullNameInSignUpForm() {
		Log.info("Validation of Full Name Format In SignUp PopUp Started -----");
		reportStep("Validation of Full Name Format In SignUp PopUp Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessageForFullNameSignUp().
		enterFullNameDuringSignUp(Utils.getTestData(2, "invalidFullName1")).
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessageForFullNameSignUp().
		enterFullNameDuringSignUp(Utils.getTestData(2, "invalidFullName2")).
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessageForFullNameSignUp().
		verifyMaxLengthOfFullNameFieldSignUp();
		Log.info("Validation of Full Name Format In SignUp PopUp is Completed -----");
		reportStep("Validation of Full Name Format In SignUp PopUp is Completed -----", "PASS");

	}

	/**Below method will verify negative scenarios for password field
	 */
	@Test(enabled=true)
	public void verifyMaxAndMinLengthOfPasswordFieldInSignUp() {
		String password=Utils.getTestData(2, "minCharPassword1");
		Log.info("Validation of Minimum and maximum length Password Field In SignUp PopUp Started -----");
		reportStep("Validation of Minimum and maximum length Password Field In SignUp PopUp Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessagePleaseChoosePassword().
		enterPasswordSignUp(password).
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessageForMinCharacterPassword().
		verifyMaxCharacterPasswordSignUp();	  
		Log.info("Validation of Minimum and maximum length Password Field In SignUp PopUp is Completed -----");
		reportStep("Validation of Minimum and maximum length Password Field In SignUp PopUp is Completed -----", "PASS"); 
	}

	/**Verify Error Message while Sign Up with email id which are already registered in SIGN IN /SIGN UP TAB
	 */
	@Test(enabled=true)
	public void verifyErrorMsgInCaseEmailAlreadyExist() {
		Log.info("Validation of Error Message if user email is already registered In SignUp PopUp Started -----");
		reportStep("Validation of Error Message if user email is already registered In SignUp PopUp Started -----", "INFO");
		String email=Utils.getTestData(2, "ValidUserId"); // This email id needs to be registered
		String password=Utils.getTestData(2, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTPFail().
		verifyErrorMsgRegisteredEmailSignUp();
		Log.info("Validation of Error Message if user email is already registered In SignUp PopUp Completed -----");
		reportStep("Validation of Error Message if user email is already registered In SignUp PopUp Completed -----", "PASS");
	}

	/** Verify If user is using existing email id for sign up, on submitting OTP, user should be navigated to Sign UP form and form will
  be refilled. Password field will be reset to default. All other values entered by user will be preserved.
	 */
	@Test(enabled=true)
	public void verifySignUpFormWillBeRefilledDuringSignUpIfEmailIdAlreadyRegistered() {
		Log.info("Validation of Sign Up Form Reset To Default if user email is already registered In SignUp PopUp Started -----");
		reportStep("Validation of Sign Up Form Reset To Default if user email is already registered In SignUp PopUp Started -----", "INFO");
		String email=Utils.getTestData(2, "ValidUserId"); // This email id needs to be registered
		String password=Utils.getTestData(2, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP();
		new WPSignUpSignInPopUp(driver, logger).
		verifyPlaceholderValuePasswordSignUp().
		verifyValueOfFullNameTextBox(Utils.getTestData(1, "fullName"));
		Log.info("Validation of Sign Up Form Reset To Default if user email is already registered In SignUp PopUp Completed -----");
		reportStep("Validation of Sign Up Form Reset To Default if user email is already registered In SignUp PopUp Completed -----", "PASS");
	}

	/**
	 * verify invalid OTP Text on OTP form.Verify after entering incorrect OTP , user should be able to
	 * edit the the OTP text box when the navigation is through Sign UP Form 
	 */

	@Test(enabled=true)
	public void verifyErrorMessageForIncorrectOtpReenterCorrectOtp() {
		String otp="123456";
		Log.info("Validation of Invalid OTP Error message In SignUp PopUp Started -----");
		reportStep("Validation of Invalid OTP Error message In SignUp PopUp Started -----", "INFO");
		String email=Utils.generateRandomEmailId(); // This email id should be unique
		String password=Utils.getTestData(2, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		enterOtpDuringSignUp(otp).
		clickVerifyOTPFail().
		clearOtpField().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel();
		Log.info("Validation of Invalid OTP Error message In SignUp PopUp Completed -----");
		reportStep("Validation of Invalid OTP Error message In SignUp PopUp Completed -----", "PASS");
	}

	/**
	 * Verify Error message while login by entering phone number which is already registered in SIGN IN/ SIGN UP Tab
	 */
	@Test(enabled=true)
	public void verifyErrorMsgIfPhoneNumberIsAlreadyRegistered() {
		Log.info("Validation of Error Message if user Phone is already registered In SignUp PopUp Started -----");
		reportStep("Validation of Error Message if user Phone is already registered In SignUp PopUp Started -----", "INFO");
		String email=Utils.getTestData(2, "ValidUserId"); // This email id needs to be registered
		String password=Utils.getTestData(2, "password");
		String mobile=Utils.getTestData(2, "phoneNumberAlreadyRegistered");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		verifyErrorMsgRegisteredPhoneSignUp();
		Log.info("Validation of Error Message if user Phone is already registered In SignUp PopUp Completed -----");
		reportStep("Validation of Error Message if user Phone is already registered In SignUp PopUp Completed -----", "PASS");
	}

	/**
	 * Verify Reset functionality during SIGN UP  By closing pop up
	 */
	@Test(enabled=true)
	public void verifyResetFunctionalityByClosingPopUp() throws Exception {
		reportStep("Verification of Reset Functionality Of Sign Up Pop Up started", "PASS");
		Log.info("Verification of Reset Functionality Of Sign Up Pop Up started");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessageForInvalidEmailSignUp().
		closeLoginPopUp().
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		verifyCountOfErrorMessagesInSignUp();
		reportStep("Verification of Reset Functionality Of Sign Up Pop Up completed successfully", "PASS");
		Log.info("Verification of Reset Functionality Of Sign Up Pop Up completed successfully");
	}

	/**
	 * Verify Reset functionality during SIGN UP  By Switching Tabs
	 */
	@Test(enabled=true)
	public void verifyResetFunctionalityBySwitchingTabsInSignUp() throws Exception {
		reportStep("Verification of Reset Functionality Of Sign Up Pop Up started", "PASS");
		Log.info("Verification of Reset Functionality Of Sign Up Pop Up started");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		clickJoinWithEmailDuringSignUp().
		verifyErrorMessageForInvalidEmailSignUp().
		clickOnlnkSignInTab().
		clickSignUpTab().
		verifyCountOfErrorMessagesInSignUp();
		reportStep("Verification of Reset Functionality Of Sign Up Pop Up completed successfully", "PASS");
		Log.info("Verification of Reset Functionality Of Sign Up Pop Up completed successfully");
	}

	/**
	 *Verify Resend Code in OTP Screen when navigation should be Sign UP form.
	 *Verify Resend Code is disabled for 30 second> After 30 seconds it will be enabled.
	 *Verify the label "Enter the OTP sent to your registered mobile number"  in OTP For Sign Up Form.
	 * @throws InterruptedException 
	 */
	
	@Test(enabled=true)
	public void verifyResendCodeFunctionalityAndLabelEnterOtpThroughSignUpForm() throws InterruptedException {
		Log.info("Validation of Resend OTP Functionality Started -----");
		reportStep("Validation of Resend OTP Functionality Started -----", "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		verifyPresenceOfLabelEnterOtpSent().
		clickResendOtpButton().
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		refreshHomePage(driver);
		Log.info("Validation of Resend OTP Functionality Started -----");
		reportStep("Validation of Resend OTP Functionality Started -----", "PASS");

	}

	/**
	 * Verify on closing OTP Pop up user navigate back to Sign up Form and except Password field, all other retains the value entered by user
	 */
	@Test(enabled=true)
	public void verifyOnClosingOtpPopUpOnlyPasswordFieldIsNotRetained() {
		Log.info("Validation of Resend OTP Functionality Started -----");
		reportStep("Validation of Resend OTP Functionality Started -----", "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		clickJoinWithEmailDuringSignUp().
		closeOtpPopUp().
		verifyPlaceholderValuePasswordSignUp();
		Log.info("Validation of Resend OTP Functionality Started -----");
		reportStep("Validation of Resend OTP Functionality Started -----", "PASS");
	}

	/**
	 *  Verify Sign up functionality by clicking on image in  category page to navigate to Store Page and then clicking on Main CTA.
	 *  Home page ->HamburgerMenu->Select_A_Category->ClickOnImage->Store_Page-> Click on Main CTA (Activate button)-> Successful Sign Up
	 */
	@Test(enabled=true) //https://paytmcashback.com is not working will execute and this method will be tested once the site is UP
	public void successfulSignUpViaMainCategoryAndMainCTA() throws Exception{
		try {
			String category=Utils.getTestData(1, "category");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			reportStep("Validation of Successful SignUp Through Main Category and Main CTA started", "PASS");
			Log.info("Validation of Successful SignUp Through Main Category and Main CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickStoreImageInSCP().
			clickMainCtaActivateCashBackLink().
			clickSignUpTab().
			enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringSignUp(email).
			enterPasswordSignUp(password).
			enterMobileNumberSignUp(mobile).
			clickJoinWithEmailDuringSignUp().
			enterOtpDuringSignUp(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful SignUp Through Main Category and Main CTA Completed");
			reportStep("Validation of Successful SignUp Through Main Category and Main CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Sign Up Through Main Category and Main CTA Failed");
			reportStep("Validation of  Sign Up Through Main Category and Main CTA Failed", "FAIL");
		}
	}

	/**
	 * verify successful sign up in category page by clicking on store card CTA Activate button.
	 * Home page ->HamburgerMenu->Select_A_Category->Click on STORESCARD CTA (Activate button)-> Successful Sign UP
	 * Upon successful  Sign UP, reload the current page".
	 * @throws Exception
	 */

	@Test(enabled=true)//https://paytmcashback.com is down, will execute and test method once the site is UP
	public void successfulSignUpViaMainCategoryAndStoreCardCTA() throws Exception{
		try {
			String category=Utils.getTestData(1, "category");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			reportStep("Validation of Successful SignUp Through Main Category and Main CTA started", "PASS");
			Log.info("Validation of Successful SignUp Through Main Category and Main CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickActivateCashBackInSCP().
			clickSignUpTab().
			enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringSignUp(email).
			enterPasswordSignUp(password).
			enterMobileNumberSignUp(mobile).
			clickJoinWithEmailDuringSignUp().
			enterOtpDuringSignUp(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful SignUp Through Main Category and Main CTA Completed");
			reportStep("Validation of Successful SignUp Through Main Category and Main CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful SignUp Through Main Category and Main CTA Completed");
			reportStep("Validation of Successful SignUp Through Main Category and Main CTA Completed", "FAIL");
		}
	}

	/**
	 * Verify Sign up functionality by clicking on image in  category page to navigate to Store Page and then clicking on Voucher CTA.
	 * Home page ->HamburgerMenu->Select_A_Category->ClickOnImage->Store_Page-> Click on Voucher CTA (Activate button)-> 
	 * Successful Sign UP .Upon successful login, reload the current page. 
	 * @throws Exception
	 */

	@Test(enabled=true)//https://paytmcashback.com is down, will execute and test method once the site is UP
	public void successfulSignUpViaMainCategoryAndVoucherCTA() throws Exception{
		try {
			String category=Utils.getTestData(1, "category");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			reportStep("Validation of Successful Sign Up Through Main Category and Voucher CTA started", "PASS");
			Log.info("Validation of Successful Sign Up Through Main Category and Voucher CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickStoreImageInSCP().
			clickVoucherCtaActivateCashBackLink().
			clickSignUpTab().
			enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringSignUp(email).
			enterPasswordSignUp(password).
			enterMobileNumberSignUp(mobile).
			clickJoinWithEmailDuringSignUp().
			enterOtpDuringSignUp(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Sign Up Through Main Category and Voucher CTA Completed");
			reportStep("Validation of Successful Sign Up Through Main Category and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Sign Up Through Main Category and Voucher CTA FAILED");
			reportStep("Validation of Sign Up Through Main Category and Voucher CTA FAILED", "PASS");
		}
	}

	/**
	 * Verify successful sign up by searching store and click Store card Activate Button.
	 * HomePage->SearchStore->ClickOnStoreCardButton(Activate Cashback)->Successful Login.Upon Successful Sign UP , reload the current page. 
	 * @throws Exception
	 */

	@Test(enabled=true)
	public void successfulSignUpViaSearchAndStoreCardActivateCashBack() throws Exception{
		try {
			reportStep("Validation of Successful SignUp Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful SignUp Through Search Functionality  and Voucher CTA started");
			String itemToBeSearched=Utils.getTestData(2, "searchStore");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickOnStoreCardActivateCashBackLink().
			clickSignUpTab().
			enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringSignUp(email).
			enterPasswordSignUp(password).
			enterMobileNumberSignUp(mobile).
			clickJoinWithEmailDuringSignUp().
			enterOtpDuringSignUp(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Sign Up Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Sign Up Through Search Functionality and Voucher CTA FAILED");
			reportStep("Validation of Sign Up Through Search Functionality and Voucher CTA FAILED", "PASS");
		}
	}

	/**
	 * Verify successful sign Up by clicking on Voucher Card Activate Cashback button by searching Store.
	 * HomePage->SearchStore->ClickOnVoucherCardButton(Activate Cashback)->Successful Login.Upon Successful Sign UP , reload the current page. 
	 * @throws Exception
	 */
	@Test(enabled=true)
	public void successfulSignUpViaSearchAndVoucherCardActivateCashBack() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(2, "searchStore");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Sign Up ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickOnVoucherCardActivateCashBackLink().
			clickSignUpTab().
			enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringSignUp(email).
			enterPasswordSignUp(password).
			enterMobileNumberSignUp(mobile).
			clickJoinWithEmailDuringSignUp().
			enterOtpDuringSignUp(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Sign Up Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Sign Up Through Search Functionality and Voucher CTA FAILED");
			reportStep("Validation of Sign Up Through Search Functionality and Voucher CTA FAILED", "FAIL");
		}
	}

	/**
	 * Verify successful sign up by searching retailer and then clicking view all link and store card CTA button
	 * @throws Exception
	 */

	@Test(enabled=true)
	public void successfulSignUpViaViewAllFunctionalityStoreCardCTAForRetailer() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchStoreViewAll");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Sign Up ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickViewAllLinkRetailer().
			clickActivateCashBackInSLP().
			clickSignUpTab().
			enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringSignUp(email).
			enterPasswordSignUp(password).
			enterMobileNumberSignUp(mobile).
			clickJoinWithEmailDuringSignUp().
			enterOtpDuringSignUp(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Sign Up Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Sign Up Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}

	/**
	 * Verify successful sign up by searching voucher and then clicking view all link and store card CTA button
	 * @throws Exception
	 */
	@Test(enabled=true)
	public void successfulSignUpViaViewAllFunctionalityStoreCardCTAForVoucher() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(2, "searchVoucherViewAll");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA started", "PASS");
			Log.info("Validation of Successful Sign Up ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickViewAllLinkVoucher().
			clickActivateCashBackInSLP().
			clickSignUpTab().
			enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringSignUp(email).
			enterPasswordSignUp(password).
			enterMobileNumberSignUp(mobile).
			clickJoinWithEmailDuringSignUp().
			
			 
			enterOtpDuringSignUp(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Sign Up Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Sign Up Through Search Functionality and Voucher CTA FAILED");
			reportStep("Validation of Sign Up Through Search Functionality and Voucher CTA FAILED", "FAIL");
		}
	}

	/**
	 * Verify successful sign up by clicking on store card activate sign up on Home Page
	 * @throws Exception
	 */
	@Test(enabled=true)
	public void successfulSignUpViaHomePageStoreCardActivateCashBackLink() throws Exception{
		try {
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA started", "PASS");
			Log.info("Validation of Successful Sign Up ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			clickStoreCardActivateCashbackLink().
			clickSignUpTab().
			enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringSignUp(email).
			enterPasswordSignUp(password).
			enterMobileNumberSignUp(mobile).
			clickJoinWithEmailDuringSignUp().
			enterOtpDuringSignUp(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Sign Up Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Sign Up Through Search Functionality and Voucher CTA FAILED");
			reportStep("Validation of Sign Up Through Search Functionality and Voucher CTA FAILED", "FAIL");
		}
	}

	/**
	 * Verify Sign Up functionality by clicking on image on home page and then clicking on Main CTA in Store Page
	 * @throws Exception
	 */
	@Test(enabled=true)
	public void successfulSignUpViaHomePageImageMainCTA() throws Exception{
		try {
			reportStep("Validation of Sign Up Through Search Functionality and Voucher CTA started", "PASS");
			Log.info("Validation of Sign Up ThroughSearch Functionality  and Voucher CTA started");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			new WPHomePage(driver, logger).clickFirstStoreCard().
			clickMainCtaActivateCashBackLink().
			clickSignUpTab().
			enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringSignUp(email).
			enterPasswordSignUp(password).
			enterMobileNumberSignUp(mobile).
			clickJoinWithEmailDuringSignUp().
			enterOtpDuringSignUp(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Sign Up Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Sign Up Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Sign Up  Through Search Functionality and Voucher CTA FAILED");
			reportStep("Validation of Successful Sign Up  Through Search Functionality and Voucher CTA FAILED", "FAIL");
		}
	}

	/**
	 * Verify Sign Up functionality by clicking on image on home page and then clicking on Voucher CTA in Store Page
	 */
	@Test(enabled=true)
	public void successfulSignUpViaHomePageImageVoucherCTA(){
		try {
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA started", "PASS");
			Log.info("Validation of Successful Sign Up ThroughSearch Functionality  and Voucher CTA started");
			String email=Utils.generateRandomEmailId();
			String password=Utils.getTestData(1, "password");
			String mobile=Utils.generateRandomMobileNumber();
			new WPHomePage(driver, logger).
			clickFirstStoreCard().
			clickActivateRewardsGuestUser().
			clickSignUpTab().
			enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringSignUp(email).
			enterPasswordSignUp(password).
			enterMobileNumberSignUp(mobile).
			clickJoinWithEmailDuringSignUp().
			enterOtpDuringSignUp(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Sign Up Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Sign Up Through Search Functionality and Voucher CTA FAILED");
			reportStep("Validation of Successful Sign Up Through Search Functionality and Voucher CTA FAILED", "FAIL");
		}
	}

	/**
	 * Verify Join Free Link and verify on click it is landing to join Free Page. Verify Page Title.
	 * Also veify Sign UP text with this.Verify placeholder value : Full Name:*, Email Address*,Choose Password*,Enter Mobile Number:* and
	 * Verify Sign Up Text for the button.
	 */

	@Test(enabled=true)
	public void verifyPlaceHolderValueOfAllFieldsInjoinFreePage() {
		Log.info("Validation of PlaceHolder Value Of All Fields In join Free Page Started -----");
		reportStep("Validation of PlaceHolder Value Of All Fields In join Free Page Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		verifyPlaceholderValueFullNameDuringJoinFree().
		verifyPlaceholderValuePasswordJoinFree().
		verifyEmailPlaceHolderValueJoinFree().
		verifyJoinWithEmailLabelJoinFree();
		Log.info("Validation of PlaceHolder Value Of All Fields In join Free Page Completed -----");
		reportStep("Validation of PlaceHolder Value Of All Fields In join Free Page Completed -----", "PASS");

	}

	/**
	 * Home Page>Join Free Link > Join Free Page>Enter all info> OTP Verification screen > 
	 * Verify Acoount Created Successfully Message> Post that You will be landed on Home Page for Registered User>
	 * Refresh the Page and again verify.
	 */

	@Test(enabled=true)
	public void successFulSignUpUsingCorrectCredentialsInJoinFreePage() {
		Log.info("Validation of SignUp Successful Functionality Started -----");
		reportStep("Validation of SignUp Successful Functionality Started -----", "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		enterFullNameDuringJoinFree(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringJoinFree(email).
		enterPasswordJoinFree(password).
		enterMobileNumberJoinFree(mobile).
		clickJoinWithEmailDuringJoinFree().
		enterOtpDuringJoinFree(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		refreshHomePage(driver);
		Log.info("Validation of SignUp Successful Functionality Completed -----");
		reportStep("Validation of SignUp Successful Functionality Completed -----", "PASS");

	}

	/**
	 *  Verify error message for Mobile Number: "Please enter valid mobile Number." Click on the text box and then click some where else. 
	 *  User will see this error. 
	 *  Covers multiple negative values in different combination such min and max length,  special char, empty value   etc.
	 */


	@Test(enabled=true)
	public void verifyErrorMessageAndNegativeScenariosForMobileFieldInjoinFree() {
		Log.info("Validation of All Negative Scenarios For Mobile Number Fields In join Free Page Started -----");
		reportStep("Validation of All Negative Scenarios For Mobile Number Fields In join Free Page Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		verifyNegativeScenariosForMobileNumberTextBoxJoinFree(Utils.getTestData(2, "specialCharacter")).
		verifyNegativeScenariosForMobileNumberTextBoxJoinFree(Utils.getTestData(2, "alphaunumeric")).
		verifyMaxLengthOfMobileNumber().
		clickMobileNumberTextBoxJoinFree().
		clickJoinWithEmailDuringJoinFree().
		verifyPlaceholderValueOfMobileNumberTextBoxJoinFree(Utils.getTestData(1, "errorMsgMobileNumber"));
		Log.info("Validation of All Negative Scenarios For Mobile Number  Fields In join Free Page Completed -----");
		reportStep("Validation of All Negative Scenarios For Mobile Number  Fields In join Free Page Completed -----", "PASS");

	}

	/**
	 * Verify Terms and Conditions text and link. On clicking the link a new Tab should open. Verify Page Title of Tems and Condition Page
	 */

	@Test(enabled=true)
	public void verifyTermsAndConditionsFunctionalityJoinFreePage() {
		Log.info("Validation of Terms and Conditions Functionality In Join Free Page Started -----");
		reportStep("Validation of Terms and Conditions Functionality  In Join Free Page Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		clickTermsAndConditionsJoinFree().
		verifyPageTitleOfTermsAndCondition(Utils.getTestData(2, "pageTitle"));
		Log.info("Validation of Terms and Conditions Functionality  In Join Free Page Completed -----");
		reportStep("Validation of Terms and Conditions Functionality In Join Free Page Completed -----", "PASS");

	}

	/**
	 * Verify error for email : "Please enter a valid email". Click on the text box and then click some where else. User will see this error.
	 * Verify the format of email id in Join Free Page
	 */
	@Test(enabled=true)
	public void verifyFormatOfEmailIdInJoinFreePage() {
		Log.info("Validation of Format of email id accepted In Join Free Page Started -----");
		reportStep("Validation of Format of email id accepted In Join Free Page Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMessageForInvalidEmailJoinFree().
		enterEmailIDDuringJoinFree(Utils.getTestData(2, "invalidEmailId1")).
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMessageForInvalidEmailJoinFree().
		enterEmailIDDuringJoinFree(Utils.getTestData(2, "invalidEmailId2")).
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMessageForInvalidEmailJoinFree().
		enterEmailIDDuringJoinFree(Utils.getTestData(2, "invalidEmailId3")).
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMessageForInvalidEmailJoinFree().
		verifyMaxLengthOfEmailIdFieldJoinFree();
		Log.info("Validation of Format of email id accepted In Join Free Page is Completed -----");
		reportStep("Validation of Format of email id accepted In Join Free Page is Completed -----", "PASS");
	}

	/**
	 * Verify error for Full Name: "Please Enter Your Name". Click on the text box and then click some where else.
	 *  User will see this error. Make sure its covers multiple nagative values in diff combination such as min and max length,  
	 *  special char, empty value prefixs suffix space  etc.
	 */

	@Test(enabled=true)
	public void verifyNegativeCasesOfFullNameInjoinFreePage() {
		Log.info("Validation of Full Name Format In Join Free Page Started -----");
		reportStep("Validation of Full Name Format In Join Free Page Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMessageForFullNameJoinFree().
		enterFullNameDuringJoinFree(Utils.getTestData(2, "invalidFullName1")).
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMessageForFullNameJoinFree().
		enterFullNameDuringJoinFree(Utils.getTestData(2, "invalidFullName2")).
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMessageForFullNameJoinFree().
		verifyMaxLengthOfFullNameFieldJoinFree();
		Log.info("Validation of Full Name Format In Join Free Page is Completed -----");
		reportStep("Validation of Full Name Format In Join Free Page is Completed -----", "PASS");

	}

	/**
	 * Verify error message for Password "Please choose a password". Click on the text box and then click Sign Up. User will see this error.
	 * Verify Minimum character of password field using Join Free Page
	 * Verify maximum character for password field using Join Free Page
	 */
	//Below method will verify negative scenarios for password field
	@Test(enabled=true)
	public void verifyMaxAndMinLengthOfPasswordFieldInJoinFree() {
		String password=Utils.getTestData(2, "minCharPassword1");
		Log.info("Validation of Minimum and maximum length Password Field In Join Free Page Started -----");
		reportStep("Validation of Minimum and maximum length Password Field In Join Free Page Started -----", "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMessagePleaseChoosePassword().
		enterPasswordJoinFree(password).
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMessageForMinCharacterPassword().
		verifyMaxCharacterPasswordJoinFree();	  
		Log.info("Validation of Minimum and maximum length Password Field In Join Free Page is Completed -----");
		reportStep("Validation of Minimum and maximum length Password Field In Join Free Page is Completed -----", "PASS"); 
	}

	/**
	 * Verify Error Message while Sign Up with email id which are already registered in Join Free Page
	 */

	@Test(enabled=true)
	public void verifyErrorMsgInCaseEmailAlreadyExistJoinFreePage() {
		Log.info("Validation of Error Message if user email is already registered In Join Free Page Started -----");
		reportStep("Validation of Error Message if user email is already registered In Join Free Page Started -----", "INFO");
		String email=Utils.getTestData(2, "ValidUserId"); // This email id needs to be registered
		String password=Utils.getTestData(2, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		enterFullNameDuringJoinFree(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringJoinFree(email).
		enterPasswordJoinFree(password).
		enterMobileNumberJoinFree(mobile).
		clickJoinWithEmailDuringJoinFree().
		enterOtpDuringJoinFree(mobile).
		clickVerifyOTPFail().
		verifyErrorMsgRegisteredEmailJoinFree();
		Log.info("Validation of Error Message if user email is already registered In Join Free Page Completed -----");
		reportStep("Validation of Error Message if user email is already registered In Join Free Page Completed -----", "PASS");
	}

	/**
	 * Verify If user is using existing email id for sign up, on submitting OTP, user should be navigated toJoin Free Page and form should be refilled.
	 */

	@Test(enabled=true)
	public void verifyJoinFreeWillBeRefilledDuringSignUpIfEmailIdAlreadyRegistered() {
		Log.info("Validation of Join Free Page Reset To Default if user email is already registered In Join Free Page Started -----");
		reportStep("Validation of Join Free Page Reset To Default if user email is already registered In Join Free Page Started -----", "INFO");
		String email=Utils.getTestData(2, "ValidUserId"); // This email id needs to be registered
		String password=Utils.getTestData(2, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		enterFullNameDuringJoinFree(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringJoinFree(email).
		enterPasswordJoinFree(password).
		enterMobileNumberJoinFree(mobile).
		clickJoinWithEmailDuringJoinFree().
		enterOtpDuringJoinFree(mobile).
		clickVerifyOTPFail().
		verifyPlaceholderValuePasswordJoinFree().
		verifyValueOfFullNameTextBox(Utils.getTestData(1, "fullName"));
		Log.info("Validation of Join Free Page Reset To Default if user email is already registered In Join Free Page Completed -----");
		reportStep("Validation of Join Free Page Reset To Default if user email is already registered In Join Free Page Completed -----", "PASS");
	}

	/**
	 * Verify error message "Invalid OTP Code" on OTP screen during sign up when user enters incorrect OTP when the navigation is through Join Free Page
	 * Verify after entering incorrect OTP , user should be able to edit the the OTP text box when the navigation is through Join Free Page
	 */

	@Test(enabled=true)
	public void verifyErrorMessageForIncorrectOtpReenterCorrectOtpJoinFree() {
		String otp="123456";
		Log.info("Validation of Error Message when user enters incorrect OTP Started -----");
		reportStep("Validation of Error Message when user enters incorrect OTP Started -----", "INFO");
		String email=Utils.generateRandomEmailId(); // This email id should be unique
		String password=Utils.getTestData(2, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		enterFullNameDuringJoinFree(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringJoinFree(email).
		enterPasswordJoinFree(password).
		enterMobileNumberJoinFree(mobile).
		clickJoinWithEmailDuringJoinFree().
		enterOtpDuringJoinFree(otp).
		clickVerifyOTPFail().
		verifyLabelInvalidOtp().
		clearOtpField().
		enterOtpDuringJoinFree(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel();
		Log.info("Validation of Error Message when user enters incorrect OTP Completed -----");
		reportStep("Validation of Error Message when user enters incorrect OTP Completed -----", "PASS");
	}

	/**
	 * Verify Error message while login by entering phone number which is already registered in Join Free Page
	 */

	@Test(enabled=true)
	public void verifyErrorMsgIfPhoneNumberIsAlreadyRegisteredJoinFree() {
		Log.info("Validation of Error Message if user Phone is already registered In Join Free Page Started -----");
		reportStep("Validation of Error Message if user Phone is already registered In Join Free Page Started -----", "INFO");
		String email=Utils.getTestData(2, "ValidUserId"); // This email id needs to be registered
		String password=Utils.getTestData(2, "password");
		String mobile=Utils.getTestData(2, "phoneNumberAlreadyRegistered");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		enterFullNameDuringJoinFree(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringJoinFree(email).
		enterPasswordJoinFree(password).
		enterMobileNumberJoinFree(mobile).
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMsgRegisteredPhoneJoinFree();
		Log.info("Validation of Error Message if user Phone is already registered In Join Free Page Completed -----");
		reportStep("Validation of Error Message if user Phone is already registered In Join Free Page Completed -----", "PASS");
	}

	/**
	 * Verify Reset functionality during SIGN UP  by navigating to some other page and then coming back to Join Free Page
	 * Expected Result: Error message should not be visible.
	 * @throws Exception
	 */

	@Test(enabled=true)
	public void verifyResetFunctionalityOfJoinFreePage() throws Exception {
		reportStep("Validation of Reset Functionality Of Join Free Page started", "PASS");
		Log.info("Validation of Reset Functionality Of Join Free Page started");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		clickJoinWithEmailDuringJoinFree().
		verifyErrorMessageForInvalidEmailJoinFree();
		new WPJoinFree(driver,logger).
		clickLogo().
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		verifyCountOfErrorMessagesInJoinFree();
		reportStep("Validation of Reset Functionality Of Join Free Page completed successfully", "PASS");
		Log.info("Validation of Reset Functionality Of Join Free Page completed successfully");
	}

	/**
	 * Verify Resend Code in OTP Screen when navigation should be Sign UP form.
	 * Verify the label "Enter the OTP sent to your registered mobile number"  in OTP For Sign Up Form
	 * Home> Sign Up Form > Enter all details correctly > and click Sign UP > 
	 * Verify Resend Code is disabled for 30 second> After 30 seconds it will be enabled
	 * @throws Exception 
	 */

	@Test(enabled=true)
	public void verifyResendCodeFunctionalityAndLabelEnterOtpThroughJoinFree() throws Exception {
		Log.info("Validation of Resend OTP Functionality Join Free Page Started -----");
		reportStep("Validation of Resend OTP Functionality Join Free Page Started -----", "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		try {
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickJoinFreeLink().
			enterFullNameDuringJoinFree(Utils.getTestData(1, "fullName")).
			enterEmailIDDuringJoinFree(email).
			enterPasswordJoinFree(password).
			enterMobileNumberJoinFree(mobile).
			clickJoinWithEmailDuringJoinFree().
			verifyPresenceOfLabelEnterOtpSent().
			clickResendOtpButton().
			enterOtpDuringJoinFree(mobile).
			clickVerifyOTP().
			verifyPresenceOfMyAccountLabel();
			Log.info("Validation of Resend OTP Functionality Join Free Page Completed -----");
			reportStep("Validation of Resend OTP Functionality Join Free Page Completed -----", "PASS");
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Verify on closing OTP Pop up user navigate back to Sign up Form and except Password field , all other retains the value entered by user
	 */

	@Test(enabled=true)
	public void verifyOnClosingOtpPopUpOnlyPasswordFieldIsNotRetainedJoinFree() {
		Log.info("Validation of Closing OTP Pop Up Functionality in Join Free Page Started -----");
		reportStep("Validation of Closing OTP Pop Up Functionality in Join Free Page Started -----", "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickJoinFreeLink().
		enterFullNameDuringJoinFree(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringJoinFree(email).
		enterPasswordJoinFree(password).
		enterMobileNumberJoinFree(mobile).
		clickJoinWithEmailDuringJoinFree().
		closeOtpPopUp().
		verifyPlaceholderValuePasswordJoinFree();
		Log.info("Validation of Closing OTP Pop Up Functionality in Join Free Page Completed -----");
		reportStep("Validation of Closing OTP Pop Up Functionality in Join Free Page Completed -----", "PASS");
	}
}
