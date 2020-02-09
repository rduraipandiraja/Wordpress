package testCases;

import org.testng.annotations.Test;
import pageObjects.WPHomePage;
import pageObjects.WPSignUpSignInPopUp;
import utility.TestSetUp;
import utility.Log;
import utility.Utils;
/**
 * This class will verify various login and error scenario in WordPress.
 * @author QA - Rahul Tiwari
 *
 */
public class WP_Verify_login_Functionality extends TestSetUp{
	
	/**
	 * Verify Successful login into wordpress application using correct user id and password.
	 * Upon login  verify My Account label is present.
	 * Test Data: Correct EMail ID and Correct Password.
	 */
	@Test(enabled=true)
	public void verifySuccessfulLoginWithCorrectCredential() {
		try {
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Verification of Successful Login started", "PASS");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel();
			reportStep("Verification of Successful Login started", "PASS");
		}catch(Exception e) {
			reportStep("Verification of Successful Login failed", "FAIL");
			throw e;
		}
	}

	/**
	 * Verify Error Message while login with email id which are not registered.
	 * Test Data: Unregistered Email ID and dummy password
	 * @throws Exception
	 */
	@Test(enabled=true)
	public void verifyUnsuccessfulLoginUsingUnregisteredEmailID() throws Exception{
		try {
			reportStep("Verification of unsuccessful Login started", "PASS");
			String email=Utils.getTestData(0,"InvalidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsg();
			reportStep("Verification of unsuccessful Login started", "PASS");
		}catch(Exception e) {
			reportStep("Verification of unsuccessful Login failed", "FAIL");
			throw e;
		}
	}
	/**
	 * Verify Error message while login by entering wrong password.
	 * Test Data: Registered User ID and Incorrect Password
	 * @throws Exception
	 */
	@Test(enabled=true)
	public void verifyUnsuccessfulLoginUsingInvalidPassword() throws Exception{
		try {
			reportStep("Verification of unsuccessful Login started", "PASS");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"InvalidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsg();
			reportStep("Verification of unsuccessful Login Completed", "PASS");
		}catch(Exception e) {
			reportStep("Verification of unsuccessful Login failed", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify the format of email id.
	 * It should accept values like: abc@abc.com , rahul@gmail.com
	 * Invalid Email id example: abc@, abc@mn@n.com, @gmail.com, 12345
	 * @throws Exception
	 */
	@Test(enabled=true)
	public void verifyFormatOfEmailID() throws Exception{
		try {
			reportStep("Verification of unsuccessful Login started", "PASS");
			String email=Utils.getTestData(0,"InvalidFormatEmailID");;
			String password=Utils.getTestData(0,"InvalidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankEmail();
			reportStep("Verification of unsuccessful Login Completed", "PASS");
		}catch(Exception e) {
			reportStep("Verification of unsuccessful Login failed", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify Error message by clicking submit button without entering email id
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void verifyPresenceOfErrorMessageWithBlankEmailID()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message with Blank Email started", "PASS");
			Log.info("Verification of Presence of Error Message with Blank Email started");
			String password=Utils.getTestData(0,"InvalidPassword");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterPasswordDuringSignIn(password).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankEmail();
			reportStep("Verification of Presence of Error Message with Blank Email completed", "PASS");
			Log.info("Verification of Presence of Error Message with Blank Email completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with Blank Email completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with Blank Email completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify Error message by clicking submit button without entering password
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void verifyPresenceOfErrorMessageWithBlankPassword()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message with Blank Password started", "PASS");
			Log.info("Verification of Presence of Error Message with Blank Password started");
			String email=Utils.getTestData(0,"ValidUserId");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankPwd();
			reportStep("Verification of Presence of Error Message with Blank Password completed", "PASS");
			Log.info("Verification of Presence of Error Message with Blank Password completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with Blank Password completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with Blank Password completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify Presence of Sign In Link At top of login Form
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void verifyPresenceOfSignInLinkAtTopOfLoginForm()throws Exception {
		try {
			reportStep("Verification of Presence of Sign In Link at top of Login Form started", "INFO");
			Log.info("Verification of Presence of Sign In Link at top of Login Form started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			verifySignInLinkOnLoginFrom();
			reportStep("Verification of Presence of Sign In Link at top of Login Form completed", "PASS");
			Log.info("Verification of Presence of Sign In Link at top of Login Form completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Sign In Link at top of Login Form completed Unsuccessfully");
			reportStep("Verification of Presence of Sign In Link at top of Login Form completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify Minimum character of password field. It should be six.
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void verifyMinimumCharacterForPasswordField()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message for minimum characters in Password field started", "INFO");
			Log.info("Verification of Presence of Error Message for minimum characters in Password field started");
			String minimumChar=Utils.getTestData(0,"minCharPassword");
			String email=Utils.getTestData(0,"ValidUserId");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(minimumChar).
			clickOnSignInButton();
			new WPSignUpSignInPopUp(driver,logger).
			verifyPresenceOfErrorMsgBlankPwd();
			reportStep("Verification of Presence of Error Message for minimum characters in Password field completed", "PASS");
			Log.info("Verification of Presence of Error Message for minimum characters in Password field completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with Blank Password completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with Blank Password completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify maximum character for password field
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void verifyMaximumCharacterForPasswordField()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message for maximum characters in Password field started", "INFO");
			Log.info("Verification of Presence of Error Message for maximum characters in Password field started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			verifyMaxCharacterInPasswordField();
			reportStep("Verification of Presence of Error Message for maximum characters in Password field completed", "PASS");
			Log.info("Verification of Presence of Error Message for maximum characters in Password field completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with maximum characters password field completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with maximum characters in Password field completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify Place holder value of both Email ID and Password Text boxes
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void verifyPlaceHolderValueOfEmailAndPasswordTextBoxes()throws Exception {
		try {
			reportStep("Verification of Presence of Placeholder Value of Email and Password Textboxes started", "INFO");
			Log.info("Verification of Presence of Placeholder Value of Email and Password Textboxes  started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			verifyPasswordPlaceHolderValue().
			verifyEmailPlaceHolderValue();	  			
			reportStep("Verification of Presence of Placeholder Value of Email and Password Textboxes completed", "PASS");
			Log.info("Verification of Presence of Placeholder Value of Email and Password Textboxes completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Placeholder Value of Email and Password Textboxes  completed Unsuccessfully");
			reportStep("Verification of Presence of Placeholder Value of Email and Password Textboxes completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify Max Character an email field should accepts. It should be 50.
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void verifyMaxCharInEmailField()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message for maximum characters in Password field started", "INFO");
			Log.info("Verification of Presence of Error Message for maximum characters in Password field started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			verifyMaxCharacterAllowedInEmailField();
			reportStep("Verification of Presence of Error Message for maximum characters in Password field completed", "PASS");
			Log.info("Verification of Presence of Error Message for maximum characters in Password field completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with maximum characters password field completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with maximum characters in Password field completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify Error message by clicking submit button without entering email id and password both.
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void verifyPresenceOfErrorMessageBothUserNamePwdBlank()throws Exception {
		try {
			reportStep("Verification of Presence of Error Message with Username and Blank Password started", "INFO");
			Log.info("Verification of Presence of Error Message with Blank Username and Password --- started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			clickOnSignInButtonFail().
			verifyErrorMsgInCaseBothUserNamePwdBlank();
			reportStep("Verification of Presence of Error Message with Blank Username and Password completed", "PASS");
			Log.info("Verification of Presence of Error Message with Blank Username and Password completed");
		}catch(Exception e) {
			Log.error("Verification of Presence of Error Message with Blank Username and Password completed Unsuccessfully");
			reportStep("Verification of Presence of Error Message with Blank Username and Password completed Unsuccessfully", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Verify Reset Functionality. Home Page> Sign In Link ->
	 * Click Sign In Button without entering email id and password.> Close Login Form. > Open Login Form> Verify those error message are not visible.
	 * @throws Exception
	 */
	
	@Test(enabled=true) 
	public void verifyResetFunctionalityOfLoginPopUp() throws Exception {
		try {
			reportStep("Verification of Reset Functionality Of Login Pop Up started", "INFO");
			Log.info("Verification of Reset Functionality Of Login Pop Up started");
			new WPHomePage(driver, logger).
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			clickOnSignInButtonFail().
			verifyPresenceOfErrorMsgBlankEmail().
			closeLoginPopUp().
			clickOnlblSignInSignUP().
			clickOnlnkSignIn().
			verifyCountOfErrorMessages();
			reportStep("Verification of Reset Functionality Of Login Pop Up completed successfully", "PASS");
			Log.info("Verification of Reset Functionality Of Login Pop Up completed successfully");
		}catch(Exception e) {
			reportStep("Verification of Reset Functionality Of Login Pop Up completed unsuccessfully", "FAIL");
			Log.info("Verification of Reset Functionality Of Login Pop Up completed unsuccessfully");
			throw e;
		}
	}
	
	/**
	 * Home page ->HamburgerMenu->Select_A_Category->ClickOnImage->Store_Page-> Click on Main CTA (Activate button)->SuccessfulLogin
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void successfulLoginViaMainCategoryAndMainCTA() throws Exception{
		try {
			String category=Utils.getTestData(0, "category");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Verification of Successful Login Through Main Category and Main CTA started", "INFO");
			Log.info("Verification of Successful Login Through Main Category and Main CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickStoreImageInSCP().
			clickMainCtaActivateCashBackLink().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Verification of Successful Login Through Main Category and Main CTA Completed");
			reportStep("Verification of Successful Login Through Main Category and Main CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Verification of Through Main Category and Main CTA Failed");
			reportStep("Verification of Through Main Category and Main CTA Failed", "FAIL");
		}
	}
	
	/**
	 * Home page ->HamburgerMenu->Select_A_Category->Click on STORESCARD CTA (Activate button)->SuccessfulLogin
	 * Upon successful login ,reload the current page with pagination"
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void successfulLoginViaMainCategoryAndStoreCardCTA() throws Exception{
		try {
			String category=Utils.getTestData(0, "category1");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Verification of Successful Login Through Main Category and Main CTA started", "INFO");
			Log.info("Verification of Successful Login Through Main Category and Main CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickActivateCashBackInSCP().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Verification of Successful Login Through Main Category and Main CTA Completed");
			reportStep("Verification of Successful Login Through Main Category and Main CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Verification of Successful Login Through Main Category and Main CTA Completed");
			e.printStackTrace();
			reportStep("Verification of Successful Login Through Main Category and Main CTA Completed", "FAIL");
			throw e;
		}
	}
	
	/**
	 * Home page ->HamburgerMenu->Select_A_Category->ClickOnImage->Store_Page-> 
	 * Click on Voucher CTA (Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void successfulLoginViaMainCategoryAndVoucherCTA() throws Exception{
		try {
			String category=Utils.getTestData(0, "category");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Verification of Successful Login Through Main Category and Voucher CTA started", "INFO");
			Log.info("Verification of Successful Login Through Main Category and Voucher CTA started");
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickStoreImageInSCP().
			clickVoucherCtaActivateCashBackLink().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Verification of Successful Login Through Main Category and Voucher CTA Completed");
			reportStep("Verification of Successful Login Through Main Category and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Verification of Successful Login Through Main Category and Voucher CTA FAILED");
			reportStep("Verification of Successful Login Through Main Category and Voucher CTA Completed", "FAIL");
		}
	}
	
	/**
	 * HomePage->SearchStore->ClickOnStoreCardButton(Activate Cashback)->Successful Login.Upon successful login, reload the current page. 
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void successfulLoginViaSearchAndStoreCardActivateCashBack() throws Exception{
		try {
			reportStep("Verification of Successful Login Through Search Functionality and Voucher CTA started", "PASS");
			Log.info("Verification of Successful Login Through Search Functionality  and Voucher CTA started");
			String itemToBeSearched=Utils.getTestData(0, "searchStore");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickOnStoreCardActivateCashBackLink().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Verification of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Verification of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * HomePage->SearchStore->ClickOnVoucherCardButton(Activate Cashback)->Successful Login.Upon successful login, reload the current page. 
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void successfulLoginViaSearchAndVoucherCardActivateCashBack() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchStore");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "PASS");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickOnVoucherCardActivateCashBackLink().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	/**
	 * HomePage->SearchResult->Search_Retailer_Page-> ViewAll->Click on StoreCardCTA>>SuccessfulLogin
 	 * Upon successful login, reload the current page with pagination"
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void successfulLoginViaViewAllFunctionalityStoreCardCTAForRetailer() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchStoreViewAll");
			String email=Utils.getTestData(0,"ValidUserId");;
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickViewAllLinkRetailer().
			clickActivateCashBackInSLP().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	/**
	 *  HomePage->SearchResult-->Search_Coupon_Page-> >ViewAll->Click on StoreCardCTA>(Activate button)->SuccessfulLogin
 	 *  Upon successful login , reload the current page.
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void successfulLoginViaViewAllFunctionalityStoreCardCTAForVoucher() throws Exception{
		try {
			String itemToBeSearched=Utils.getTestData(0, "searchVoucherViewAll");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			new WPHomePage(driver, logger).
			searchForVoucherOrStore(itemToBeSearched).
			clickViewAllLinkVoucher().
			clickActivateCashBackInSLP().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	/**
	 * HomePage->ClickOnStorecardButton(Activate CashBack)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void successfulLoginViaHomePageStoreCardActivateCashBackLink() throws Exception{
		try {
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			clickStoreCardActivateCashbackLink().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	/**
	 * HomePage->ClickOnImage->Store_Page-> Click on Main CTA(Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void successfulLoginViaHomePageImageMainCTA() throws Exception{
		try {
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "INFO");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			clickFirstStoreCard().
			clickMainCtaActivateCashBackLink().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
	
	/**
	 * HomePage->ClickOnImage->Store_Page-> Click on Voucher CTA (Activate button)->SuccessfulLogin.Upon successful login, reload the current page. 
	 * @throws Exception
	 */
	
	@Test(enabled=true)
	public void successfulLoginViaHomePageImageVoucherCTA() throws Exception{
		try {
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA started", "PASS");
			Log.info("Validation of Successful Login ThroughSearch Functionality  and Voucher CTA started");
			String email=Utils.getTestData(0,"ValidUserId");
			String password=Utils.getTestData(0,"ValidPassword");
			new WPHomePage(driver, logger).
			clickFirstStoreCard().
			clickActivateRewardsGuestUser().
			enterEmailDuringSignIn(email).
			enterPasswordDuringSignIn(password).
			clickOnSignInButton().
			verifyPresenceOfMyAccountLabel().
			refreshHomePage(driver);
			Log.info("Validation of Successful Login Through Search Functionality  and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "PASS");
		}catch(Exception e) {
			Log.info("Validation of Successful Login Through Search Functionality and Voucher CTA Completed");
			reportStep("Validation of Successful Login Through Search Functionality and Voucher CTA Completed", "FAIL");
		}
	}
}



