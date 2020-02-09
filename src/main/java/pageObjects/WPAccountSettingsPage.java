package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
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

public class WPAccountSettingsPage extends TestSetUp{
	private boolean presence=false;
	public static final Logger log = LogManager.getLogger(WPAccountSettingsPage.class);	

	//Constructor for WP_AccountSettingsPage
	public WPAccountSettingsPage(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info("Waiting for the Account Settings Page");
		reportStep("Waiting for the Account Settings Page", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lnkAccountSettings));
			Log.info("Successfully landed on the Account Settings Page");
			reportStep("Successfully landed on the Account Settings Page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Account Settings Page", "FAIL");
			Log.error("Not able to land on the Account Settings Page");
		} 
	}

	@FindBy(id="idMenuAccountSettings")
	private static WebElement lnkAccountSettings;

	//This method will Click Account Settings Link on Home Page
	public WPAccountSettingsPage clickAccountSettingsLink() {
		try {
			Log.info("Locating Account Settings Link on Home Page");
			reportStep("Locating Account Settings Link on Home Page", "INFO");
			Utils.explicitWaitForClick(lnkAccountSettings);
			Log.info("Clicked Successfully Account Settings Link on Home Page");
			reportStep("Clicked Successfully Account Settings Link on Home Page", "PASS");
		}catch(Exception e) {
			Log.error("Unable to click Account Settings Link on Home Page");
			reportStep("Unable to click Account Settings Link on Home Page", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//span[text()='Account Settings']")
	private static WebElement lblBreadCrumbAccountSettings;
	public WPAccountSettingsPage verifyAccountSettingsBreadCrumbisPresent() {
		Log.info("Locating Account Settings Bread Crumb on Account Settings Page");
		reportStep("Locating Account Settings Bread Crumb on Account Settings Page", "INFO");
		presence=Utils.verifyElementPresence(lblBreadCrumbAccountSettings);
		if(presence) {
			Log.info("Account Settings Bread Crumb is present on Account Settings Page");
			reportStep("Account Settings Bread Crumb is present on Account Settings Page.", "PASS");
		}else {
			Log.error("Unable to locate Account Settings Bread Crumb on Account Settings Page");
			reportStep("Unable to locate Account Settings Bread Crumb on Account Settings Page", "FAIL");
		}
		return this;
	}

	//This method will verify text of Account Settings Link on Home Page
	public WPAccountSettingsPage verifyTextOfAccountSettingsLink() {

		Log.debug("Locating Account Settings Link on Home Page");
		reportStep("Locating Account Settings Link on Home Page", "INFO");
		String actual=lnkAccountSettings.getText();
		if(actual.equals("Account Settings")) {
			Log.debug("Text of Account Settings Link is " +actual+ " on Home Page");
			reportStep("Text of Account Settings Link is " +actual+ " on Home Page", "PASS");
		}else {
			Log.info("Unable to verify Account Settings text on Home Page. It is " +actual);
			reportStep("Unable to verify Account Settings text on Home Page. It is " +actual, "FAIL");
		}


		return this;
	}

	@FindBy(id="idLeftNavAccountSettings")
	private static WebElement lnkAccountSettingsLeftNav;

	//This method will Click Account Settings Link in Left Navigation Panel of Account Setings Page
	public WPAccountSettingsPage clickAccountSettingsLeftNavLink() {
		try {
			Log.info("Locating Account Settings Link of Left Navigation Panel of Account Seetings Page");
			reportStep("Locating Account Settings Link of Left Navigation Panel of Account Seetings Page", "INFO");
			Utils.explicitWaitForClick(lnkAccountSettingsLeftNav);
			Log.info("Clicked Successfully Account Settings Link of Left Navigation Panel of Account Seetings Page");
			reportStep("Clicked Successfully Account Settings Link of Left Navigation Panel of Account Seetings Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Account Settings Link of Left Navigation Panel of Account Seetings Page");
			reportStep("Unable to click Account Settings Link of Left Navigation Panel of Account Seetings Page", "FAIL");
		}
		return this;
	}

	//This method will verify text of Account Settings Link in Left Navigation Panel of Account Setings Page
	public WPAccountSettingsPage verifyTextOfAccountSettingsLinkOnLeftNavPanel() {

		Log.info("Locating Text of Account Settings Link in Left Navigation Panel of Account Setings Page ");
		reportStep("Locating Account Settings Link in Left Navigation Panel of Account Setings Page", "INFO");
		String actual=lnkAccountSettingsLeftNav.getText();
		if(actual.equals("Account Settings")) {
			Log.debug("Text of Account Settings Link is " +actual+ " in Left Navigation Panel of Account Setings Page");
			reportStep("Text of Account Settings Link is " +actual+ " in Left Navigation Panel of Account Setings Page", "PASS");
		}else {
			Log.info("Unable to verify Account Settings text in Left Navigation Panel of Account Seetings Page. It is " +actual);
			reportStep("Unable to verify Account Settings text in Left Navigation Panel of Account Seetings Page. It is " +actual, "FAIL");
		}


		return this;
	}

	@FindBy(id="tabPersonalDetails")
	private static WebElement lnkPersonalDetails;


	//This method will verify text of Personal Details Tab in Account Setings Page
	public WPAccountSettingsPage verifyTextOfPersonalDetailsTab() {

		Log.info("Locating Personal Details Tab in Account Setings Page");
		reportStep("Locating Personal Details Tab in Account Setings Page", "INFO");
		String actual=lnkPersonalDetails.getText();
		if(actual.equals("Personal Details")) {
			Log.debug("Text of Personal Details Tab in Account Setings Page is " +actual);
			reportStep("Text of  Personal Details Tab in Account Setings Page is " +actual, "PASS");
		}else {
			Log.info("Unable to verify Text of  Personal Details Tab in Account Setings Page. It is " +actual);
			reportStep("Unable to Text of  Personal Details Tab in Account Setings Page. It is "+actual, "FAIL");
		}


		return this;
	}

	//This method will Click Personal Details Tab in Account Setings Page
	public WPAccountSettingsPage clickPersonalDetailsTab() {
		try {
			Log.info("Locating Personal Details Tab in Account Settings Page");
			reportStep("Locating Personal Details Tab in Account Settings Page", "INFO");
			Utils.explicitWaitForClick(lnkPersonalDetails);
			Log.info("Clicked Successfully Personal Details Tab in Account Settings Page");
			reportStep("Clicked Successfully Personal Details Tab in Account Settings Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Personal Details Tab in Account Settings Page");
			reportStep("Unable to click Personal Details Tab in Account Settings Page", "FAIL");
		}
		return this;
	}

	@FindBy(id="tabChangePassword")
	private static WebElement lnkChangePassword;

	//This method will verify text of Change Password Tab in Account Setings Page
	public WPAccountSettingsPage verifyTextOfChangePasswordTab() {

		Log.info("Locating Change Password Tab in Account Settings Page");
		reportStep("Locating Change Password Tab in Account Settings Page", "INFO");
		String actual=lnkChangePassword.getText();
		if(actual.equals("Change Password")) {
			Log.debug("Text of Change Password Tab in Account Settings Page is " +actual);
			reportStep("Text of  Personal Details Tab in Account Settings Page is " +actual, "PASS");
		}else {
			Log.info("Unable to verify Text of Change Password Tab in Account Settings Page. It is " +actual);
			reportStep("Unable to Text of  Change Password Tab in Account Settings Page. It is "+actual, "FAIL");
		}


		return this;
	}

	//This method will Click Change Password Tab in Account Setings Page
	public WPAccountSettingsPage clickChangePasswordTab() {
		try {
			Log.info("Locating Change Password Tab in Account Settings Page");
			reportStep("Locating Change Password in Account Settings Page", "INFO");
			Utils.explicitWaitForClick(lnkChangePassword);
			Log.info("Clicked Successfully Change Password Tab in Account Settings Page");
			reportStep("Clicked Successfully Change Password Tab in Account Settings Page", "PASS");
		}catch(Exception e) {
			Log.info("Unable to click Change Password Tab in Account Settings Page");
			reportStep("Unable to click Change Password Tab in Account Settings Page", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//label[text()='Current password:']") // id or name is not present. Xpath will take care of Text as well
	private static WebElement lblCurrentPassword;

	//This method will verify text of Current Password Label in Change Password Tab of Account Settings Page
	public WPAccountSettingsPage verifyCurrentPasswordLabelIsPresent() {
		
		Log.info("Locating Current Password Label in Change Password Tab of Account Settings Page");
		reportStep("Locating Current Password Label in Change Password Tab of Account Settings Page", "INFO");
		presence=Utils.verifyElementPresence(lblCurrentPassword);
		if(presence) {
			Log.debug("Current Password Label is present in Change Password Tab of Account Settings Page.");
			reportStep("Current Password Label is present in Change Password Tab of Account Settings Page.", "PASS");
		}else {
			Log.info("Current Password Label is not present in Change Password Tab of Account Settings Page");
			reportStep("Current Password Label is not present in Change Password Tab of Account Settings Page", "FAIL");
		}


		return this;
	}

	@FindBy(xpath="//label[text()='New password:']") // id or name is not present. Xpath will take care of Text as well
	private static WebElement lblNewPassword;

	//This method will verify text of New Password Label in Change Password Tab of Account Settings Page
	public WPAccountSettingsPage verifyNewPasswordLabelIsPresent() {
		
		Log.info("Locating New Password Label in Change Password Tab of Account Settings Page");
		reportStep("Locating New Password Label in Change Password Tab of Account Settings Page", "INFO");
		presence=Utils.verifyElementPresence(lblNewPassword);
		if(presence) {
			Log.debug("New Password Label is present in Change Password Tab of Account Settings Page.");
			reportStep("New Password Label is present in Change Password Tab of Account Settings Page.", "PASS");
		}else {
			Log.info("New Password Label is not present in Change Password Tab of Account Settings Page");
			reportStep("New Password Label is not present in Change Password Tab of Account Settings Page", "FAIL");
		}


		return this;
	}

	@FindBy(xpath="//label[text()='Confirm new password:']") // id or name is not present. Xpath will take care of Text as well
	private static WebElement lblConfirmNewPassword;

	//This method will verify text of New Password Label in Change Password Tab of Account Settings Page
	public WPAccountSettingsPage verifyConfirmNewPasswordLabelIsPresent() {
		
		Log.info("Locating Confirm new password Label in Change Password Tab of Account Settings Page");
		reportStep("Locating Confirm new password Label in Change Password Tab of Account Settings Page", "INFO");
		presence=Utils.verifyElementPresence(lblConfirmNewPassword);
		if(presence) {
			Log.debug("Confirm new password Label is present in Change Password Tab of Account Settings Page.");
			reportStep("Confirm new password Label is present in Change Password Tab of Account Settings Page.", "PASS");
		}else {
			Log.info("Confirm new password Label is not present in Change Password Tab of Account Settings Page");
			reportStep("Confirm new password Label is not present in Change Password Tab of Account Settings Page", "FAIL");
		}


		return this;
	}

	@FindBy(id="change_password")
	private static WebElement btnSaveChanges;

	//This method will verify text of SAVE CHANGES button in Account Settings Page
	public WPAccountSettingsPage verifyTextOfSaveChangesButton() {

		Log.info("Locating SAVE CHANGES button in Account Settings Page");
		reportStep("Locating SAVE CHANGES button in Account Settings Page", "INFO");
		String actual=btnSaveChanges.getText();
		if(actual.equals("SAVE CHANGES")) {
			Log.debug("Text of SAVE CHANGES button in Account Settings Page is " +actual);
			reportStep("Text of  Personal Details Tab in Account Settings Page is " +actual, "PASS");
		}else {
			Log.info("Unable to verify Text of SAVE CHANGES button in Account Settings Page. It is " +actual);
			reportStep("Unable to Text of  SAVE CHANGES button in Account Settings Page. It is "+actual, "FAIL");
		}


		return this;
	}

	//This method will click SAVE CHANGES button in Account Setings Page
	public WPAccountSettingsPage clickSaveChangesButton() {

		Log.info("Locating SAVE CHANGES button in Account Settings Page");
		reportStep("Locating SAVE CHANGES button in Account Settings Page", "INFO");
		if(Utils.click(btnSaveChanges)) {
			Log.debug("Clicked successfully SAVE CHANGES button in Account Settings Page ");
			reportStep("Clicked successfully SAVE CHANGES buttonin Account Settings Page ", "PASS");
		}else {
			Log.info("Unable to click SAVE CHANGES button in Account Settings Page. ");
			reportStep("Unable to click SAVE CHANGES button in Account Settings Page.", "FAIL");
		}


		return this;
	}

	@FindBy(id="cur_pwd")
	private static WebElement txtBxCurrentPassword;
	
	public WPAccountSettingsPage verifyMaxLengthForCurrentPwd() {
		String length=Utils.getTestData(2, "maxLengthPassword");
		Log.info("Trying to locate Current password field");
		reportStep("Trying to locate Current password field", "INFO");
		if(txtBxCurrentPassword.getAttribute("maxlength").toString().equals(length)) {
			Log.info("Max Length for Enter Current Password field is : "+length);
			reportStep("Max Length for Enter Current Password field is :"+length, "PASS");
		}else {
			Log.info("Max Length for Enter Current Password field is not : "+length +"It is: "+txtBxCurrentPassword.getAttribute("maxlength").toString());
			reportStep("Max Length for Enter Current Password field is not : "+length +" . It is: " +txtBxCurrentPassword.getAttribute("maxlength").toString(), "FAIL");
		}
		return this;
	}
	
	public WPAccountSettingsPage enterCurrentPassword(String currentPassword) {
		Log.info("Trying to locate current password field");
		reportStep("Trying to locate current password field", "INFO");
		Utils.sendKeys(txtBxCurrentPassword, currentPassword);
		Log.info("Successfully entered current Password: "+currentPassword+ " in current password field");
		reportStep("Successfully entered current Password: "+currentPassword+ " in current password field", "PASS");
		return this;
	}

	public WPAccountSettingsPage enterCurrentPassword(Keys key) {
		Log.info("Trying to locate current password field");
		reportStep("Trying to locate current password field", "INFO");
		Utils.sendKeys(txtBxCurrentPassword, key);
		Log.info("Successfully entered"+ key +"current Password in current password field");
		reportStep("Successfully entered"+ key +"current Password in current password field", "PASS");
		return this;
	}

	@FindBy(id="pwd")
	private static WebElement txtBxNewPassword;

	public WPAccountSettingsPage enterNewPassword(String newPassword) {
		Log.info("Trying to locate new password field");
		reportStep("Trying to locate new password field", "INFO");
		Utils.sendKeys(txtBxNewPassword, newPassword);
		Log.info("Successfully entered new Password in new password field");
		reportStep("Successfully entered new Password in new password field", "PASS");
		return this;
	}

	public WPAccountSettingsPage enterNewPassword(Keys key) {
		Log.info("Trying to locate new password field");
		reportStep("Trying to locate new password field", "INFO");
		Utils.sendKeys(txtBxNewPassword, key);
		Log.info("Successfully entered"+ key +" new Password in new password field");
		reportStep("Successfully entered"+ key +" new Password in new password field", "PASS");
		return this;
	}
	
	public WPAccountSettingsPage verifyMaxLengthForEnterNewPwd() {
		String length=Utils.getTestData(2, "maxLengthPassword");
		Log.info("Trying to locate new password field");
		reportStep("Trying to locate new password field", "INFO");
		if(txtBxNewPassword.getAttribute("maxlength").toString().equals(length)) {
			Log.info("Max Length for Enter new Password field is : "+length);
			reportStep("Max Length for Enter new Password field is :"+length, "PASS");
		}else {
			Log.info("Max Length for Enter new Password field is not : "+length +"It is: "+txtBxNewPassword.getAttribute("maxlength").toString());
			reportStep("Max Length for Enter new Password field is not : "+length +" . It is: " +txtBxNewPassword.getAttribute("maxlength").toString(), "FAIL");
		}
		return this;
	}
	
	@FindBy(id="con_pwd")
	private static WebElement txtBxReEnterPassword;

	public WPAccountSettingsPage reEnterNewPassword(String newPassword) {
		Log.info("Trying to locate new password field");
		reportStep("Trying to locate new password field", "INFO");
		Utils.sendKeys(txtBxReEnterPassword, newPassword);
		Log.info("Successfully reentered new Password in new password field");
		reportStep("Successfully reentered new Password in new password field", "PASS");
		return this;
	}
	
	public WPAccountSettingsPage verifyMaxLengthForReEnterNewPwd() {
		String length=Utils.getTestData(2, "maxLengthPassword");
		Log.info("Trying to locate re new password field");
		reportStep("Trying to locate re new password field", "INFO");
		if(txtBxReEnterPassword.getAttribute("maxlength").toString().equals(length)) {
			Log.info("Max Length for Re Enter Password field is : "+length);
			reportStep("Max Length for Re Enter Password field is :"+length, "PASS");
		}else {
			Log.info("Max Length for RenEnter Password field is not : "+length +"It is: "+txtBxReEnterPassword.getAttribute("maxlength").toString());
			reportStep("Max Length for Re Enter Password field is not : "+length +" . It is: " +txtBxReEnterPassword.getAttribute("maxlength").toString(), "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//em[text()='For security, password must be at least 6 characters long.']")
	private static List<WebElement> errMsgMinCharacterPwd;
	
	public WPAccountSettingsPage verifyErrorMessageForMinCharPasswordInChangePwdTab() {
		for(int i=0;i<errMsgMinCharacterPwd.size();i++) {
			Log.info("Locating error message for " +i+1+ " error message : \"For security, password must be at least 6 characters long.\" in change Password Tab");
			reportStep("Locating error message for " +i+1+ " error message : \"For security, password must be at least 6 characters long.\" in change Password Tab", "INFO");
			presence=Utils.verifyElementPresence(errMsgMinCharacterPwd.get(i));
			if(presence) {
				Log.info("Error message for " +i+1+ " error message : \"For security, password must be at least 6 characters long.\" in change Password Tab is displayed");
				reportStep("Error message for " +i+1+ " error message : \"For security, password must be at least 6 characters long.\" in change Password Tab  is displayed", "PASS");
			}
			else {
				Log.info("Error message for " +i+1+ " error message : \"For security, password must be at least 6 characters long.\" in change Password Tab is not displayed.");
				reportStep("Error message for " +i+1+ " error message : \"For security, password must be at least 6 characters long.\" in change Password Tab  is not displayed", "FAIL");
			}
		}
		
		return this;
	}
	public WPAccountSettingsPage reEnterNewPassword(Keys key) {
		Log.info("Trying to locate new password field");
		reportStep("Trying to locate new password field", "INFO");
		Utils.sendKeys(txtBxReEnterPassword, key);
		Log.info("Successfully reentered "+ key +" new Password in new password field");
		reportStep("Successfully reentered  "+ key +" new Password in new password field", "PASS");
		return this;
	}
	@FindBy(xpath="//label[text()='Full Name:']") // id or name is not present. Xpath will take care of Text as well
	private static WebElement lblFullName;

	//This method will verify text of FullName Label in Personal Details Tab of Account Settings Page
	public WPAccountSettingsPage verifyFullNameLabelIsPresent() {
		
		Log.info("Locating Full Name Label in Personal Details Tab of Account Settings Page");
		reportStep("Locating Full NameLabel in Personal Details Tab of Account Settings Page", "INFO");
		presence=Utils.verifyElementPresence(lblFullName);
		if(presence) {
			Log.info("Full Name Label is present in Personal Details Tab of Account Settings Page.");
			reportStep("Full Name Label is present in Personal Details Tab of Account Settings Page.", "PASS");
		}else {
			Log.info("Full Name Label is not present in Personal Details Tab of Account Settings Page");
			reportStep("Full Name Label is not present in Personal Details Tab of Account Settings Page", "FAIL");
		}


		return this;
	}

	@FindBy(xpath="//label[text()='Email address:']") // id or name is not present. Xpath will take care of Text as well
	private static WebElement lblEmailAddress;

	//This method will verify text of Email address Label in Personal Details Tab of Account Settings Page
	public WPAccountSettingsPage verifyEmailaddressLabelIsPresent() {
		
		Log.info("Locating Email address Label in Personal Details Tab of Account Settings Page");
		reportStep("Locating Email address Label in Personal Details Tab of Account Settings Page", "INFO");
		presence=Utils.verifyElementPresence(lblEmailAddress);
		if(presence) {
			Log.info("Email address Label is present in Personal Details Tab of Account Settings Page.");
			reportStep("Email address Label is present in Personal Details Tab of Account Settings Page.", "PASS");
		}else {
			Log.info("Email address Label is not present in Personal Details Tab of Account Settings Page");
			reportStep("Email address Label is not present in Personal Details Tab of Account Settings Page", "FAIL");
		}


		return this;
	}
	@FindBy(xpath="//label[text()='Mobile Number:']") // id or name is not present. Xpath will take care of Text as well
	private static WebElement lblMobileNumber;

	//This method will verify text of Mobile Number Label in Personal Details Tab of Account Settings Page
	public WPAccountSettingsPage verifyMobileNumberLabelIsPresent() {
		
		Log.info("Locating Mobile Number Label in Personal Details Tab of Account Settings Page");
		reportStep("Locating Mobile Number Label in Personal Details Tab of Account Settings Page", "INFO");
		presence=Utils.verifyElementPresence(lblMobileNumber);
		if(presence) {
			Log.info("Mobile Number Label is present in Personal Details Tab of Account Settings Page.");
			reportStep("Mobile Number Label is present in Personal Details Tab of Account Settings Page.", "PASS");
		}else {
			Log.info("Mobile Number Label is not present in Personal Details Tab of Account Settings Page");
			reportStep("Mobile Number Label is not present in Personal Details Tab of Account Settings Page", "FAIL");

		}
		return this;
	}

	@FindBy(xpath="//p[contains(text(),'To change your email/mobile number please write to')]") // id or name is not present. Xpath will take care of Text as well
	private static WebElement lblInfoChangeMobile;

	//This method will verify text of Mobile Number Label in Personal Details Tab of Account Settings Page
	public WPAccountSettingsPage verifyInfoChangeMobileLabelIsPresent() {
		
		Log.info("Locating \" To change your email/mobile number please write to \" Label in Personal Details Tab of Account Settings Page");
		reportStep("Locating \" To change your email/mobile number please write to \" Label in Personal Details Tab of Account Settings Page", "INFO");
		presence=Utils.verifyElementPresence(lblInfoChangeMobile);
		if(presence) {
			Log.info("\" To change your email/mobile number please write to \" Label is present in Personal Details Tab of Account Settings Page.");
			reportStep("\" To change your email/mobile number please write to \" Label is present in Personal Details Tab of Account Settings Page.", "PASS");
		}else {
			Log.info("\" To change your email/mobile number please write to \" Label is not present in Personal Details Tab of Account Settings Page");
			reportStep("\" To change your email/mobile number please write to \" Label is not present in Personal Details Tab of Account Settings Page", "FAIL");
		}

		return this;
	}

	@FindBy(xpath="//span[text()='+91']") // id or name is not present. Xpath will take care of Text as well
	private static WebElement lblCountryCode;

	//This method will verify text of +91 Country Code Label in Personal Details Tab of Account Settings Page
	public WPAccountSettingsPage verifyCountryCodeLabelIsPresent() {
		
		Log.info("Locating \" +91 Country Code \" Label in Personal Details Tab of Account Settings Page");
		reportStep("Locating \" +91 Country Code \" Label in Personal Details Tab of Account Settings Page", "INFO");
		presence=Utils.verifyElementPresence(lblCountryCode);
		if(presence) {
			Log.info("\" +91 Country Code \" Label is present in Personal Details Tab of Account Settings Page.");
			reportStep("\"+91 Country Code \" Label is present in Personal Details Tab of Account Settings Page.", "PASS");
		}else {
			Log.info("\" +91 Country Code \" Label is not present in Personal Details Tab of Account Settings Page");
			reportStep("\"+91 Country Code \" Label is not present in Personal Details Tab of Account Settings Page", "FAIL");
		}

		return this;
	}

	@FindBy(id="sumbit_personal")
	private static WebElement btnSaveChangesPersonalDetails;

	//This method will verify text of SAVE CHANGES button in Account Setings Page
	public WPAccountSettingsPage verifyTextOfSaveChangesButtonPersonalDetailsTab() {

		Log.info("Locating SAVE CHANGES button in Personal Details Tab of Account Settings Page");
		reportStep("Locating SAVE CHANGES button in Personal Details Tab of Account Settings Page", "INFO");
		String actual=btnSaveChangesPersonalDetails.getText();
		if(actual.equals("SAVE CHANGES")) {
			Log.debug("Text of SAVE CHANGES button in Personal Details Tab of Account Settings Page is " +actual);
			reportStep("Text of  Personal Details Tab Personal Details Tab of Account Settings Page is " +actual, "PASS");
		}else {
			Log.info("Unable to verify Text of SAVE CHANGES button in Personal Details Tab of Account Settings Page. It is " +actual);
			reportStep("Unable to Text of  SAVE CHANGES button in Personal Details Tab of Account Settings Page. It is "+actual, "FAIL");
		}


		return this;
	}

	//This method will click SAVE CHANGES button in Account Setings Page
	public WPAccountSettingsPage clickSaveChangesButtonPersonalDetailsTab() {

		Log.info("Locating SAVE CHANGES button in Personal Details Tab of Account Settings Page");
		reportStep("Locating SAVE CHANGES button in Personal Details Tab of Account Settings Page", "INFO");
		if(Utils.click(btnSaveChangesPersonalDetails)) {
			Log.info("Clicked successfully SAVE CHANGES button in Personal Details Tab of Account Settings Page");
			reportStep("Clicked successfully SAVE CHANGES buttonin Personal Details Tab of Account Settings Page ", "PASS");
		}else {
			Log.info("Unable to click SAVE CHANGES button in Personal Details Tab of Account Settings Page.");
			reportStep("Unable to click SAVE CHANGES button in Personal Details Tab of Account Settings Page.", "FAIL");
		}


		return this;
	}
	@FindBy(xpath="//em[text()='Changes successfully saved']")
	private static WebElement successMessageAfterSave;

	public WPAccountSettingsPage verifySuccessMessageAfterSave() {
		Log.info("Locating success message in Personal Details Tab of Account Settings Page");
		reportStep("Locating Success message in Personal Details Tab of Account Settings Page", "INFO");
		boolean enable=Utils.verifyElementPresence(successMessageAfterSave);
		if(enable) {
			Log.info("Located --- Changes successfully saved in Personal Details Tab of Account Settings Page");
			reportStep("Located --- Changes successfully saved in Personal Details Tab of Account Settings Page", "PASS");
		}else {
			Log.info("Unable to locate---  --- Changes successfully saved in Personal Details Tab of Account Settings Page");
			reportStep("Unable to locate  --- Changes successfully saved in Personal Details Tab of Account Settings Page", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//em[text()='Please type your name']")
	private static WebElement errorMsgFullName;

	public WPAccountSettingsPage verifyErrorMessageFoFullName() {
		Log.info("Locating error message in Personal Details Tab of Account Settings Page");
		reportStep("Locating Email Text Box in Personal Details Tab of Account Settings Page", "INFO");
		boolean presence=Utils.verifyElementPresence(errorMsgFullName);
		if(presence) {
			Log.info("Located --- Please Type Your Name Error message in Personal Details Tab of Account Settings Page");
			reportStep("Located --- Please Type Your Name Error message in Personal Details Tab of Account Settings Page", "PASS");
		}else {
			Log.info("Unable to locate--- Please Type Your Name Error message in Personal Details Tab of Account Settings Page");
			reportStep("Unable to locate Please Type Your Name Error message in Personal Details Tab of Account Settings Page", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//em[text()=' The fullname must be at least 2 characters. ']")
	private static WebElement errorMessageMinCharacterFullName;

	public WPAccountSettingsPage verifyErrorMessageForMinCharFullName() {
		Log.info("Locating error message for full name Minimum character in Personal Details Tab of Account Settings Page");
		reportStep("Locating error message for full name Minimum character in Personal Details Tab of Account Settings Page", "INFO");
		boolean enable=Utils.verifyElementPresence(errorMessageMinCharacterFullName);
		if(enable) {
			Log.info("Located --- \"The fullname must be at least 2 characters.\" in Personal Details Tab of Account Settings Page");
			reportStep("Located --- \" The fullname must be at least 2 characters.\" in Personal Details Tab of Account Settings Page", "PASS");
		}else {
			Log.info("Unable to locate--- \"The fullname must be at least 2 characters.\" in Personal Details Tab of Account Settings Page");
			reportStep("Unable to locate-- \" The fullname must be at least 2 characters. \" in Personal Details Tab of Account Settings Page", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//em[text()=' The fullname may not be greater than 50 characters. ']")
	private static WebElement errorMessageMaxCharacter;

	public WPAccountSettingsPage verifyErrorMessageForMoreThanFiftyChar() {
		Log.info("Locating error message in Personal Details Tab of Account Settings Page");
		reportStep("Locating Email Text Box in Personal Details Tab of Account Settings Page", "INFO");
		boolean enable=Utils.verifyElementPresence(errorMessageMaxCharacter);
		if(enable) {
			Log.info("Located --- The fullname may not be greater than 50 characters. in Personal Details Tab of Account Settings Page");
			reportStep("Located --- The fullname may not be greater than 50 characters. in Personal Details Tab of Account Settings Page", "PASS");
		}else {
			Log.info("Unable to locate--- The fullname may not be greater than 50 characters. in Personal Details Tab of Account Settings Page");
			reportStep("Unable to locate The fullname may not be greater than 50 characters. in Personal Details Tab of Account Settings Page", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//a[contains(@href,'mail')]") // id or name is not present. Also email id is environment dependent
	private static WebElement lnkEmailPersonalDetailsTab;

	//This method will verify Email ID Link is present in Personal Details Tab of Account Settings Page
	public WPAccountSettingsPage verifyEmailLinkPersonalDetailsIsPresent() {
		
		Log.info("Locating Email ID Link in Personal Details Tab of Account Settings Page");
		reportStep("Locating Email ID Link in Personal Details Tab of Account Settings Page", "INFO");
		presence=Utils.verifyElementPresence(lnkEmailPersonalDetailsTab);
		if(presence) {
			Log.info("Email ID Link is present in Personal Details Tab of Account Settings Page.");
			reportStep("Email ID Link is present in Personal Details Tab of Account Settings Page.", "PASS");
		}else {
			Log.info("Email ID Link is not present in Personal Details Tab of Account Settings Page");
			reportStep("Email ID Link is not present in Personal Details Tab of Account Settings Page", "FAIL");

		}
		return this;
	}

	@FindBy(id="fullname") 
	private static WebElement txtBxFullName;

	//This method will verify full name text box is editable in Personal Details Tab of Account Settings Page
	public WPAccountSettingsPage editFullName(String name) {
		Log.info("Locating Full Name Text Box in Personal Details Tab of Account Settings Page");
		reportStep("Locating  Full Name Text Box in Personal Details Tab of Account Settings Page", "INFO");
		String value=txtBxFullName.getText().toString();
		Log.info("Current Value of Full Name Text Box is "+value+" in Personal Details Tab of Account Settings Page");
		reportStep("Current Value of Full Name Text Box is "+value+" in Personal Details Tab of Account Settings Page", "PASS");
		txtBxFullName.clear();
		Utils.sendKeys(txtBxFullName, name);
		Log.info(" Full Name Text Box is editable in Personal Details Tab of Account Settings Page");
		reportStep("Full Name Text Box is editable in Personal Details Tab of Account Settings Page", "PASS");
		return this;
	}

	//This method will empty Full Name text box in Personal Details Tab of Account Settings Page
	public WPAccountSettingsPage clearFullName() {
		Log.info("Locating Full Name Text Box in Personal Details Tab of Account Settings Page");
		reportStep("Locating  Full Name Text Box in Personal Details Tab of Account Settings Page", "INFO");
		txtBxFullName.clear();
		Log.info("Current Value of Full Name Text Box is  in Personal Details Tab of Account Settings Page");
		reportStep("Current Value of Full Name Text Box is  in Personal Details Tab of Account Settings Page", "PASS");
		return this;
	}


	//This method will verify max length of full name text box is editable in Personal Details Tab of Account Settings Page
	public WPAccountSettingsPage enterMoreThanFiftyCharInInFullName() {
		Log.info("Locating Full Name Text Box in Personal Details Tab of Account Settings Page");
		reportStep("Locating  Full Name Text Box in Personal Details Tab of Account Settings Page", "INFO");
		txtBxFullName.clear();
		Utils.sendKeys(txtBxFullName, Utils.getTestData(3, "fullNameMoreThanFiftyChar"));
		Log.info("Successfully entered more than fifty character in Full Name Text Box is in Personal Details Tab of Account Settings Page");
		reportStep("Successfully entered more than fifty character in Full Name Text Box is in Personal Details Tab of Account Settings Page", "PASS");
		Utils.sleep();
		return this;
	}

	@FindBy(xpath="(//input[@readonly='readonly'])[2]")
	private static WebElement txtBxMobileNumber;

	public WPAccountSettingsPage verifyMobileNumberTextBoxIsDisabled() {
		Log.info("Locating Mobile Number Text Box in Personal Details Tab of Account Settings Page");
		reportStep("Locating Mobile Number Text Box in Personal Details Tab of Account Settings Page", "INFO");
		boolean presence=Utils.verifyElementPresence(txtBxMobileNumber);
		if(! presence) {
			Log.info("Mobile Number Text Box is enable in Personal Details Tab of Account Settings Page");
			reportStep("Mobile Number Text Box is enable in Personal Details Tab of Account Settings Page", "FAIL");
		}else {
			Log.info("Mobile Number Text Box is disable in Personal Details Tab of Account Settings Page");
			reportStep("Mobile Number Text Box is disable in Personal Details Tab of Account Settings Page", "PASS");
		}
		return this;
	}

	@FindBy(xpath="(//input[@readonly='readonly'])[1]")
	private static WebElement txtBxEmail;

	public WPAccountSettingsPage verifyEmailTextBoxIsDisabled() {
		Log.info("Locating Email Text Box in Personal Details Tab of Account Settings Page");
		reportStep("Locating Email Text Box in Personal Details Tab of Account Settings Page", "INFO");
		boolean enable=Utils.verifyElementPresence(txtBxMobileNumber);
		if(! enable) {
			Log.info("Email Text Box is enable in Personal Details Tab of Account Settings Page");
			reportStep("Email Text Box is enable in Personal Details Tab of Account Settings Page", "FAIL");
		}else {
			Log.info("Email Text Box is disable in Personal Details Tab of Account Settings Page");
			reportStep("Email Text Box is disable in Personal Details Tab of Account Settings Page", "PASS");
		}
		return this;
	}

	@FindBy(xpath="//em[text()='Please enter your current password.']")
	private static WebElement errMsgCurrentPwd;

	//This method will verify presence of Error Message for current Password in Change Password Tab of Account Settings Page
	public WPAccountSettingsPage verifyPresenceOfErrorMsgCurrentPwd() {
		Log.info("Locating Error Messages for current Password in Change Password Tab of Account Settings Page");
		reportStep("Locating Error Messages for current Password in Change Password Tab of Account Settings Page", "INFO");
		boolean presence=Utils.verifyElementPresence(errMsgCurrentPwd);
		if(presence) {
			Log.info("Error Messages for current Password in Change Password Tab of Account Settings Page is visible in case user directly click on Save Button");
			reportStep("Error Messages for current Password in Change Password Tab of Account Settings Page is visible in case user directly click on Save Button", "PASS");
		}else {
			Log.info("Error Messages for current Password in Change Password Tab of Account Settings Page was not displayed in case user directly click on Save Button");
			reportStep("Error Messages for current Password in Change Password Tab of Account Settings Page was not displayed in case user directly click on Save Button", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//em[text()='Please enter your new password.']")
	private static WebElement errMsgNewPwd;

	//This method will verify presence of Error Message for New Password in Change Password Tab of Account Settings Page
	public WPAccountSettingsPage verifyPresenceOfErrorMsgNewPwd() {
		Log.info("Locating Error Messages for New Password in Change Password Tab of Account Settings Page");
		reportStep("Locating Error Messages for New Password in Change Password Tab of Account Settings Page", "INFO");
		boolean presence=Utils.verifyElementPresence(errMsgNewPwd);
		if(presence) {
			Log.info("Error Messages for New Password in Change Password Tab of Account Settings Page is visible in case user directly click on Save Button");
			reportStep("Error Messages for New Password in Change Password Tab of Account Settings Page is visible in case user directly click on Save Button", "PASS");
		}else {
			Log.info("Error Messages for New Password in Change Password Tab of Account Settings Page was not displayed in case user directly click on Save Button");
			reportStep("Error Messages for New Password in Change Password Tab of Account Settings Page was not displayed in case user directly click on Save Button", "FAIL");
		}
		return this;
	}


	@FindBy(xpath="//em[text()='Please re-enter your new password.']")
	private static WebElement errMsgConfirmPwd;

	//This method will verify presence of Error Message for Re enter New Password in Change Password Tab of Account Settings Page
	public WPAccountSettingsPage verifyPresenceOfErrorMsgConfirmNewPwd() {
		Log.info("Locating Error Message for Re enter New Password in Change Password Tab of Account Settings Page");
		reportStep("LocatingError Message for Re enter New Password in Change Password Tab of Account Settings Page", "INFO");
		boolean presence=Utils.verifyElementPresence(errMsgConfirmPwd);
		if(presence) {
			Log.info("Error Message for Re enter New Password in Change Password Tab of Account Settings Page is visible in case user directly click on Save Button");
			reportStep("Error Message for Re enter New Password in Change Password Tab of Account Settings Page is visible in case user directly click on Save Button", "PASS");
		}else {
			Log.info("Error Message for Re enter New Password in Change Password Tab of Account Settings Page was not displayed in case user directly click on Save Button");
			reportStep("Error Message for Re enter New Password in Change Password Tab of Account Settings Page was not displayed in case user directly click on Save Button", "FAIL");
		}
		return this;
	}

	//Search Store or Coupon element
	@FindBy(name="search_store")
	private static WebElement txtBxSearchStoreOrCoupons;

	// Searching Voucher and Store
	public WPAccountSettingsPage searchForVoucherOrStore(String search) {
		try {
			reportStep("Locating Search Bar in Header Section", "INFO");
			Log.info("Locating Search Bar in Header Section");
			Utils.explicitWaitForClick(txtBxSearchStoreOrCoupons);
			Utils.sendKeysAndPressEnter(txtBxSearchStoreOrCoupons, search);
			reportStep("Successfully entered what needs to be searched: " +search, "PASS");
			Log.info("Successfully entered what needs to be searched");
		}catch(Exception e) {
			Log.fatal("Unable to enter what needs to be searched in Home Page Search Bar");
			reportStep("Unable to enter what needs to be searched in Home Page Search Bar", "FAIL");
		}
		return this;
	}

	@FindBy(xpath = "//em[text()='Your password does not match. Please check and try again.']")
	private static WebElement errMsgIncorrectCurrentPwd;

	//This method will verify that a user will be unable to change password if current password is incorrect.
	public WPAccountSettingsPage verifyPresenceOfErrorMsgincorrectCurrentPwd() {
		Log.info("Locating Error Message for incorrect current password in Change Password Tab when user is trying to change password");
		reportStep("Locating Error Message for incorrect current password in Change Password Tab when user is trying to change password", "INFO");
		boolean presence=Utils.verifyElementPresence(errMsgIncorrectCurrentPwd);
		if(presence) {
			Log.info("Error Message for incorrect current password in Change Password Tab is present when user is trying to change password. Error message is: \"Your password does not match. Please check and try again.\" ");
			reportStep("Error Message for incorrect current password in Change Password Tab is present when user is trying to change password. Error message is: \"Your password does not match. Please check and try again.\"", "PASS");
		}else {
			Log.info("Error Message for incorrect current password in Change Password Tab is not displayed when user is trying to change password.");
			reportStep("Error Message for incorrect current password in Change Password Tab is not displayed when user is trying to change password.", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//em[text()='Password does not match.']")
	private static WebElement errMsgMisMatchNewPassword;
	
	//This method will verify that a user will be unable to change password if new password and confirm new password is different..
		public WPAccountSettingsPage verifyPresenceOfErrorMsgMismatchNewPwd() {
			Log.info("Locating Error Message for mismatch between new password and re-enter New password in Change Password Tab when user is trying to change password");
			reportStep("Locating Error Message for mismatch between new password and re-enter New password in Change Password Tab when user is trying to change password", "INFO");
			boolean presence=Utils.verifyElementPresence(errMsgMisMatchNewPassword);
			if(presence) {
				Log.info("Error Message for mismatch between new password and re-enter New password in Change Password Tab is displayed when user is trying to change password. Error message is: \"Password does not match.\" ");
				reportStep("Error Message for mismatch between new password and re-enter New password in Change Password Tab is displayed when user is trying to change password. Error message is: \"Password does not match.\" ", "PASS");
			}else {
				Log.info("Error Message for mismatched password in Change Password Tab is not displayed when user is trying to change password.");
				reportStep("Error Message for mismatched password in Change Password Tab is not displayed when user is trying to change password.", "FAIL");
			}
			return this;
		}
}
