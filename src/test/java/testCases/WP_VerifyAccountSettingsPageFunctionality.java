package testCases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.WPHomePage;
import utility.TestSetUp;
import utility.Log;
import utility.Utils;
/**
 * 
 * @author QA - Rahul Tiwari
 * This Class will verify Account Settings Page Functionality, Change Password Tab and Personal Details Functionality.
 * It will include all positive and negative cases.
 */
public class WP_VerifyAccountSettingsPageFunctionality extends TestSetUp{

	/**
	 * This method will verify --On clicking Account Settings, User is Navigated to Account Settings Page &
	 * verify Page Title and Bread Crumb of Account Settings Page.
	 */

	@Test(enabled=true)
	public void verifyPageTitleAndBreadCrumbOfAccountSettingsPage() {
		Log.info("Validation of Breadcrumb and page title of Account Settings Page started---------");
		reportStep("Validation of Breadcrumb and page title of Account Settings Page started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		reportStep("Verification of Successful Login started", "PASS");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		verifyTextOfAccountSettingsLink().
		clickAccountSettingsLink().
		verifyAccountSettingsBreadCrumbisPresent().
		verifyTextOfAccountSettingsLinkOnLeftNavPanel();
		String pageTitle=Utils.getTestData(2, "pageTitle");
		if(pageTitle.equals(driver.getTitle())) {
			Log.info("Page Title of Account Settings Page is---------- "+pageTitle);
			reportStep("Page Title of Account Settings Page is --------------- "+pageTitle, "PASS");
		}else {
			Log.info("Page Title of Account Settings Page is "+driver.getTitle());
			reportStep("Page Title of Account Settings Page Mismatched. Actual Page Title is------ "+driver.getTitle(), "FAIL");
		}
		Log.info("Validation of Breadcrumb and page title of Account Settings Page Completed---------");
		reportStep("Validation of Breadcrumb and page title of Account Settings Page Completed---------", "PASS");

	}

	/**
	 * This method will verify Account Settings page will have two Tabs -Personal Details and Change Password
	 * Verify text of both Personal and Change Password Tabs 
	 * Verify both tabs are clickable
	 */


	@Test(enabled=true)
	public void verifyTextOfTabsUnderAccountSettingsAndTabsAreClickable() {
		Log.info("Validation of Personal and Change Password Tabs started---------");
		reportStep("Validation of Personal and Change Password Tabs started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		verifyTextOfPersonalDetailsTab().
		clickChangePasswordTab().
		verifyTextOfChangePasswordTab().
		clickPersonalDetailsTab();
		Log.info("Validation of Personal and Change Password Tabs  COMPLETED---------");
		reportStep("Validation of Personal and Change Password Tabs  COMPLETED---------", "PASS");
	}

	/**
	This method will verify Personal Details Tab will have three labels : Full Name:, Email Address:, Mobile Number and 
	 * "NOTE : To change your email/mobile number please write to dev@pouringpounds.com". Verify Text of SAVE CHANGES button.
	 */

	@Test(enabled=true)
	public void verifyTextOfBothTabsComponentsInAccountSettingsPage() {
		Log.info("Validation of text of Personal and Change Password Tab's Components started---------");
		reportStep("Validation of text of Personal and Change Password Tab's Components started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		verifyCountryCodeLabelIsPresent().
		verifyTextOfSaveChangesButtonPersonalDetailsTab().
		verifyFullNameLabelIsPresent().
		verifyEmailaddressLabelIsPresent().
		verifyEmailLinkPersonalDetailsIsPresent().
		verifyInfoChangeMobileLabelIsPresent().
		verifyMobileNumberLabelIsPresent().
		verifyTextOfSaveChangesButtonPersonalDetailsTab().
		clickChangePasswordTab().
		verifyConfirmNewPasswordLabelIsPresent().
		verifyCurrentPasswordLabelIsPresent().
		verifyNewPasswordLabelIsPresent().
		verifyTextOfSaveChangesButton();
		Log.info("Validation of text of Personal and Change Password Tab's Components COMPLETED---------");
		reportStep("Validation of text of Personal and Change Password Tab's Components COMPLETED---------", "PASS");
	}
	
	/**
	 * This method will verify Email ID and Mobile Number Field is disable in Personal Details
	 * TAB of Account Setting Page. This will also verify error message :  
	 * The fullname may not be greater than 50 characters
	 */
	
	@Test(enabled=true)
	public void verifyEmailAndMobileNumberTextBoxIsDisable() {
		Log.info("Validation of text of Personal and Change Password Tab's Components started---------");
		reportStep("Validation of text of Personal and Change Password Tab's Components started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		verifyMobileNumberTextBoxIsDisabled().
		verifyEmailTextBoxIsDisabled().
		enterMoreThanFiftyCharInInFullName().
		clickSaveChangesButtonPersonalDetailsTab().
		clickSaveChangesButtonPersonalDetailsTab().
		verifyErrorMessageForMoreThanFiftyChar();	
	}
	
	/**
	 *  Verify user is able to change full name and save it
	 */
	
	@Test(enabled=true)
	public void changeFullNameInPersonalDetailsTab() {
		Log.info("Validation of text of Personal and Change Password Tab's Components started---------");
		reportStep("Validation of text of Personal and Change Password Tab's Components started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		String name=Utils.getTestData(3,"name");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		editFullName(name).
		clickSaveChangesButtonPersonalDetailsTab().
		clickSaveChangesButtonPersonalDetailsTab().
		verifySuccessMessageAfterSave();
	}
	
	/**
	 * This method will change current password
	 */
	
	@Test(enabled=true)
	public void verifyChangePasswordFunctionality() {
		Log.info("Validation of Change Password Functionality started---------");
		reportStep("Validation of Change Password Functionality started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		clickChangePasswordTab().
		enterCurrentPassword(password).
		enterNewPassword(password).
		reEnterNewPassword(password).
		clickSaveChangesButton().
		verifySuccessMessageAfterSave();
		Log.info("Validation of Change Password Functionality COMPLETED---------");
		reportStep("Validation of Change Password Functionality COMPLETED---------", "PASS");
	}
	
	/**
	 * This method will verify error message for full name
	 */
	@Test(enabled=true)
	public void verifyErrorMessageForFullName() {
		Log.info("Validation of Error Messages For Full Name started---------");
		reportStep("Validation of Error Messages For Full Name started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		clearFullName().
		clickSaveChangesButtonPersonalDetailsTab().
		verifyErrorMessageFoFullName();
		Log.info("Validation of Error Messages For Full Name COMPLETED---------");
		reportStep("Validation of Error Messages For Full Name COMPLETED---------", "PASS");
	}
	
	/**
	 * This method will verify all Error Messages present in Change Password Tab by clicking on 
	 * SAVE CHANGES BUTTON DIRECTLY.
	 */
	@Test(enabled=true)
	public void verifyErrorMessageInChangePasswordTabByClickingOnSaveButtonDirectly() {
		Log.info("Validation of All Error Messages In Change Password TAB started---------");
		reportStep("Validation of All Error Messages In Change Password TAB started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		clickChangePasswordTab().
		clickSaveChangesButton().
		verifyPresenceOfErrorMsgCurrentPwd().
		verifyPresenceOfErrorMsgNewPwd().
		verifyPresenceOfErrorMsgConfirmNewPwd();
		Log.info("Validation of All Error Messages In Change Password TAB COMPLETED---------");
		reportStep("Validation of All Error Messages In Change Password TAB COMPLETED---------", "PASS");
	}
	
	/**
	 * This method will verify Error Message present in Change Password Tab by clicking on each 
	 * text boxes and then clicking on search bar one by one.
	 */
	@Test(enabled=true)
	public void verifyErrorMessageInChangePasswordTabByClickingOnEachTxtBoxAndClickSomeWhereElse() {
		Log.info("Validation of All Error Messages In Change Password TAB started---------");
		reportStep("Validation of All Error Messages In Change Password TAB started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		clickChangePasswordTab().
		enterCurrentPassword("").
		searchForVoucherOrStore(""). // This method is present in both HomePage and Account Setting Page in order to avoid creation of multiple objects.
		verifyPresenceOfErrorMsgCurrentPwd().
		enterNewPassword("").
		searchForVoucherOrStore("").
		verifyPresenceOfErrorMsgNewPwd().
		reEnterNewPassword("").
		searchForVoucherOrStore("").
		verifyPresenceOfErrorMsgConfirmNewPwd();
		Log.info("Validation of All Error Messages In Change Password TAB COMPLETED---------");
		reportStep("Validation of All Error Messages In Change Password TAB COMPLETED---------", "PASS");
	}
	
	/**
	 * This messages will verify all error messages one by one in change password tab
	 * by clicking on each text boxes and then Pressing TAB key. All message will appear will 
	 * appear each time user presses TAB key.
	 */
	@Test(enabled=true)
	public void verifyErrorMessageInChangePasswordTabByClickingOnEachTxtBoxAndThenPressingTabKey() {
		Log.info("Validation of All Error Messages In Change Password TAB started---------");
		reportStep("Validation of All Error Messages In Change Password TAB started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		clickChangePasswordTab().
		enterCurrentPassword("").
		enterCurrentPassword(Keys.TAB).
		verifyPresenceOfErrorMsgCurrentPwd().
		enterNewPassword(Keys.TAB).
		verifyPresenceOfErrorMsgNewPwd().
		reEnterNewPassword(Keys.TAB).
		verifyPresenceOfErrorMsgConfirmNewPwd();
		Log.info("Validation of All Error Messages In Change Password TAB COMPLETED---------");
		reportStep("Validation of All Error Messages In Change Password TAB COMPLETED---------", "PASS");
	}
	
	/**
	 * This method will verify that a user will be unable to change password if current password is incorrect.
	 */
	@Test(enabled=true)
	public void verifyUserIsUnableToChangePwdIfCurrentPwdIsIncorrect() {
		Log.info("Validation of Error Message In Change Password TAB when current password is incorrect started---------");
		reportStep("Validation of Error Message In Change Password TAB when current password is incorrect started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		String incorrectPassword=Utils.getTestData(2,"incorrectPassword");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		clickChangePasswordTab().
		enterCurrentPassword(incorrectPassword).
		enterNewPassword(password).
		reEnterNewPassword(password).
		clickSaveChangesButton().
		verifyPresenceOfErrorMsgincorrectCurrentPwd();
		Log.info("Validation of Error Message In Change Password TAB when current password is incorrect Completed---------");
		reportStep("Validation of Error Message In Change Password TAB when current password is incorrect Completed---------", "PASS");
	}
	
	/**
	 * This method will verify error message when a user Is unable to change password if new password and confirm new password is incorrect.
	 */
	
	@Test(enabled=true)
	public void verifyUserIsUnableToChangePwdIfNewPwdAndConfirmNewPwdIsDifferent() {
		Log.info("Validation of Error Message In Change Password TAB when current password is incorrect started---------");
		reportStep("Validation of Error Message In Change Password TAB when current password is incorrect started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		String incorrectPassword=Utils.getTestData(2,"incorrectPassword");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		clickChangePasswordTab().
		enterCurrentPassword(password).
		enterNewPassword(password).
		reEnterNewPassword(incorrectPassword).
		clickSaveChangesButton().
		verifyPresenceOfErrorMsgMismatchNewPwd();
		Log.info("Validation of Error Message In Change Password TAB when current password is incorrect Completed---------");
		reportStep("Validation of Error Message In Change Password TAB when current password is incorrect Completed---------", "PASS");
	}
	
	/**
	 * This method will verify error message if user is trying to enter single character in Full Name and then clicking on SAVE CHANGES BUTTON.
	 * Expected Error message is: 
	 */
	
	@Test(enabled=true)
	public void verifyErrorMessageForMinCharFullName() {
		Log.info("Validation of Error Messages For Minimum Character in Full Name started---------");
		reportStep("Validation of Error Messages For Minimum Character in Full Name started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		editFullName(Utils.getTestData(3, "minChar")).
		clickSaveChangesButtonPersonalDetailsTab().
		clickSaveChangesButtonPersonalDetailsTab().
		verifyErrorMessageForMinCharFullName();
		Log.info("Validation of Error Messages For Minimum Character in Full Name COMPLETED---------");
		reportStep("Validation of Error Messages For Minimum Character in Full Name COMPLETED---------", "PASS");
	}
	
	/**
	 * This method will verify minimum length for current password, new password and confirm new password field
	 * of Change Password Tab in Account Setting Page.
	 */
	@Test(enabled=true)
	public void verifyminCharacterPwdInChangePwdTab() {
		Log.info("Validation of Error Messages For Minimum Character in Change Password Tab for all three text boxes started---------");
		reportStep("Validation of Error Messages For Minimum Character in Change Password Tab for all three text boxes started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		clickChangePasswordTab().
		enterCurrentPassword(Utils.getTestData(3, "minChar")).
		enterNewPassword(Utils.getTestData(3, "minChar")).
		reEnterNewPassword(Utils.getTestData(3, "minChar")).
		clickSaveChangesButton().
		verifyErrorMessageForMinCharPasswordInChangePwdTab();
		Log.info("Validation of Error Messages For Minimum Character in Change Password Tab for all three text boxes COMPLETED---------");
		reportStep("Validation of Error Messages For Minimum Character in Change Password Tab for all three text boxes COMPLETED---------", "PASS");
	}
	
	/**
	 * This method will verify max length for current password, new password and confirm new password field
	 * of Change Password Tab in Account Setting Page.
	 */
	@Test(enabled=true)
	public void verifyMaxLengthPwdForAllInChangePwdTab() {
		Log.info("Validation of max length for current password, new password and confirm new password field in Change Password Tab for all three text boxes started---------");
		reportStep("Validation of max length for current password, new password and confirm new password field in Change Password Tab for all three text boxes started---------", "INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabeloOnHomePage().
		clickAccountSettingsLink().
		clickChangePasswordTab().
		verifyMaxLengthForCurrentPwd().
		verifyMaxLengthForEnterNewPwd().
		verifyMaxLengthForReEnterNewPwd();
		Log.info("Validation of max length for current password, new password and confirm new password field in Change Password Tab for all three text boxes COMPLETED---------");
		reportStep("Validation of max length for current password, new password and confirm new password field in Change Password Tab for all three text boxes COMPLETED---------", "PASS");
	}
	
}
