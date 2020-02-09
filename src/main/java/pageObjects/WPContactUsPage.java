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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import utility.TestSetUp;
import utility.Log;
import utility.Utils;

public class WPContactUsPage extends TestSetUp{
	Boolean presence;
	public static final Logger log = LogManager.getLogger(WPContactUsPage.class);


	public WPContactUsPage(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;

		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.info("Waiting for the Contact Us Page To Load");
		reportStep("Waiting for the Contact Us Page To Load", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lblChooseTopic));
			Log.info("Successfully landed on the Contact Us page");
			reportStep("Successfully landed on the Contact Us page ", "PASS");
		} catch (Exception e) {
			reportStep(e.getMessage(), "INFO");
			reportStep("Not able to land on the Contact Us page", "FAIL");
			Log.error("Not able to land on the Contact Us page");
		} 
	}	

	@FindBy(id="lblContactSubject")
	private static WebElement lblChooseTopic;

	//This method will verify presence of "Choose Topic" Label in Contact Us Page
	public WPContactUsPage verifyPresenceOfChooseTopicLabelInContactUsPage() {
		Log.info("Locating \"Choose Topic\" Label in Contact Us Page");
		reportStep("Locating \"Choose Topic\" Label in Contact Us Page", "INFO");
		presence=Utils.verifyElementPresence(lblChooseTopic);
		if(presence) {
			Log.info("\"Choose Topic\" Label in Contact Us Page is displayed");
			reportStep("\"Choose Topic\" Label in Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\"Choose Topic\" Label in Contact Us Page is not displayed");
			reportStep("\"Choose Topic\" Label in Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}

	@FindBy(id="subject")
	private static WebElement drpDownSelectTopic;

	//This method will click Choose Topic Drop down
	public WPContactUsPage clickChooseTopicDropDown() {
		Log.info("Locating Choose Topic Drop Down in Contact Us Page");
		reportStep("Locating Choose Topic Drop Down in Contact Us Page","INFO");
		if(Utils.click(drpDownSelectTopic)) {
			Log.info("Successfully clicked Choose Topic Drop Down in Contact Us Page");
			reportStep("Successfully clicked Choose Topic Drop Down in Contact Us Page","PASS");
		}else {
			Log.info("Unable to click Choose Topic Drop Down in Contact Us Page");
			reportStep("Unable to click Choose Topic Drop Down in Contact Us Page","FAIL");
		}
		return this;
	}

	public WPContactUsPage selectByValueFromDropDown(String value) {
		Log.info("Locating Choose Topic Drop Down in Contact Us Page");
		reportStep("Locating Choose Topic Drop Down in Contact Us Page","INFO");
		Select select=new Select(drpDownSelectTopic);
		select.selectByValue(value);
		List<WebElement> list=select.getAllSelectedOptions();
		WebElement element=list.get(0);
		String actual=element.getText();
		if(actual.equals(value)) {
			Log.info("Successfully selected \"" +value+"\" from dropdown Choose Topic");
			reportStep("Successfully selected \"" +value+"\" from dropdown Choose Topic","PASS");
		}else {
			Log.info("Unable to select \"" +value+"\" from dropdown Choose Topic");
			reportStep("Unable to select \"" +value+"\" from dropdown Choose Topic","FAIL");
		}
		return this;
	}

	//This method will select a value from drop down


	//This method will send Tab key in Choose Topic Drop Down
	public WPContactUsPage sendTabKeysInChooseTopicDropDown() {
		Log.info("Locating Choose Topic Drop Down in Contact Us Page");
		reportStep("Locating Choose Topic Drop Down in Contact Us Page","INFO");
		if(Utils.sendKeys(drpDownSelectTopic, Keys.TAB)) {
			Log.info("Successfully Send TAB Key in Choose Topic Drop Down in Contact Us Page");
			reportStep("Successfully Send TAB Key in Choose Topic Drop Down in Contact Us Page","PASS");
		}else {
			Log.info("Unable to Send TAB Key in Choose Topic Drop Down in Contact Us Page");
			reportStep("Unable to Send TAB Key in Choose Topic Drop Down in Contact Us Page","FAIL");
		}
		return this;
	}

	@FindBy(xpath="//em[text()='Please choose the subject.']")
	private static WebElement errMsgChooseTopic;

	//This method will verify presence of error message for Choose Topic in Contact Us Page.
	public WPContactUsPage verifyPresenceOfErrorMsgForChooseTopic() {
		Log.info("Locating \"Please choose the subject.\" Error Message in Contact Us Page");
		reportStep("Locating \"Please choose the subject.\"  Error Message in Contact Us Page", "INFO");
		presence=Utils.verifyElementPresence(errMsgChooseTopic);
		if(presence) {
			Log.info("\"Please choose the subject.\"  Error Message in Contact Us Page is displayed");
			reportStep("\"Please choose the subject.\"  Error Message in Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\"Please choose the subject.\"  Error Message in Contact Us Page is not displayed");
			reportStep("\"Please choose the subject.\"  Error Message in Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}

	@FindBy(id="lblContactName")
	private static WebElement lblName;

	//This method will verify presence of "Name" Label in Contact Us Page
	public WPContactUsPage verifyPresenceOfNameLabelInContactUsPage() {
		Log.info("Locating \"Name\" Label in Contact Us Page");
		reportStep("Locating \"Name\" Label in Contact Us Page", "INFO");
		presence=Utils.verifyElementPresence(lblName);
		if(presence) {
			Log.info("\"Name\" Label in Contact Us Page is displayed");
			reportStep("\"Name\" Label in Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\"Name\" Label in Contact Us Page is not displayed");
			reportStep("\"Name\" Label in Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}

	@FindBy(id="lblContactEmail")
	private static WebElement lblEmailAddress;

	//This method will verify presence of "Email Address" Label in Contact Us Page
	public WPContactUsPage verifyPresenceOfEmailAddressLabelInContactUsPage() {
		Log.info("Locating \"Email Address\" Label in Contact Us Page");
		reportStep("Locating \"Email Address\" Label in Contact Us Page", "INFO");
		presence=Utils.verifyElementPresence(lblEmailAddress);
		if(presence) {
			Log.info("\"Email Address\" Label in Contact Us Page is displayed");
			reportStep("\"Email Address\" Label in Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\"Email Address\" Label in Contact Us Page is not displayed");
			reportStep("\"Email Address\" Label in Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}

	@FindBy(id="lblContactMessage")
	private static WebElement lblMesssage;

	//This method will verify presence of "Message" Label in Contact Us Page
	public WPContactUsPage verifyPresenceOfMessageLabelInContactUsPage() {
		Log.info("Locating \"Message\" Label in Contact Us Page");
		reportStep("Locating \"Message\" Label in Contact Us Page", "INFO");
		presence=Utils.verifyElementPresence(lblMesssage);
		if(presence) {
			Log.info("\"Message\" Label in Contact Us Page is displayed");
			reportStep("\"Message\" Label in Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\"Message\" Label in Contact Us Page is not displayed");
			reportStep("\"Message\" Label in Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}

	@FindBy(id="submit_contactus")
	private static WebElement btnSubmit;

	//This method will verify presence of "Submit" button in Contact Us Page
	public WPContactUsPage verifyPresenceOfSubmitButtonInContactUsPage() {
		Log.info("Locating \"Submit\" button in Contact Us Page");
		reportStep("Locating \"Submit\" button in Contact Us Page", "INFO");
		presence=Utils.verifyElementPresence(btnSubmit);
		if(presence) {
			Log.info("\"Submit\" button in Contact Us Page is displayed");
			reportStep("\"Submit\" button in Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\"Submit\" button in Contact Us Page is not displayed");
			reportStep("\"Submit\" button in Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}

	//This method will verify presence of "Submit" text in Submit Button in Contact Us Page
	public WPContactUsPage verifyPresenceOfSubmitTextInSubmitButtonOfContactUsPage() {
		Log.info("Locating \"Submit\" button in Contact Us Page");
		reportStep("Locating \"Submit\" button in Contact Us Page", "INFO");
		if(btnSubmit.getText().toString().equals("SUBMIT")) {
			Log.info("\"Submit\" button text is equal to \"SUBMIT\"in Contact Us Page.");
			reportStep("\"Submit\" button text is equal to \"SUBMIT\"in Contact Us Page.", "PASS");
		}else {
			Log.info("\"Submit\" button  text is not equal to \"SUBMIT\"in Contact Us Page.");
			reportStep("\"Submit\" button  text is not equal to \"SUBMIT\"in Contact Us Page.", "FAIL");
		}
		return this;
	}

	//This method will Click "Submit" button in Contact Us Page
	public WPContactUsPage clickSubmitButtonInConTactUs() {
		Log.info("Locating \"Submit\" button in Contact Us Page");
		reportStep("Locating \"Submit\" button in Contact Us Page", "INFO");
		if(Utils.click(btnSubmit)) {
			Log.info("\"Submit\" button in Contact Us Page was clicked successfully");
			reportStep("\"Submit\" button in Contact Us Page was clicked successfully", "PASS");
		}else {
			Log.info("\"Submit\" button in Contact Us Page was not clicked.");
			reportStep("\"Submit\" button in Contact Us Page was not clicked.", "FAIL");
		}
		return this;
	}

	@FindBy(id="lblContactUsTitle")
	private static WebElement lblContactUsTitle;

	//This method will verify presence of "Say Hello!" Label in Contact Us Page
	public WPContactUsPage verifyPresenceOfSayHelloLabelInContactUsPage() {
		Log.info("Locating \"Say Hello!\" Label in Contact Us Page");
		reportStep("Locating \" Say Hello! \" Label in Contact Us Page", "INFO");
		presence=Utils.verifyElementPresence(lblContactUsTitle);
		if(presence) {
			Log.info("\" Say Hello!\" Label in Contact Us Page is displayed");
			reportStep("\" Say Hello!\" Label in Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\" Say Hello!\" Label in Contact Us Page is not displayed");
			reportStep("\" Say Hello!\" Label in Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}

	@FindBy(id="fullname")
	private static WebElement txtBxFullName;

	// This method will compare previous value of Name text box with current value of text box
	public WPContactUsPage verifyNameTextBoxIsEditableAndEnabled(String previous) {
		Log.info("Locating Name text box in Contact Us Page");
		reportStep("Locating Name text box in Contact Us Page", "INFO");
		String now=Utils.fetchConsoleValue("#fullname", driver);
		if(! previous.equals(now)) {
			Log.info("Name text box is editable and enabled. Previously entered data was: " +previous+ "and currently entered data is : "+now);
			reportStep("Name text box is editable and enabled. Previously entered data was: " +previous+ "and currently entered data is : "+now, "PASS");
		}else {
			Log.info("Name text box is not editable and enabled");
			reportStep("Name text box is not editable and enabled", "FAIL");
		}
		return this;	
	}

	//This method will enter text in Full Name Text box in Contact Us Page
	public WPContactUsPage enterFullName(String name) {
		Log.info("Locating Full Name Text box in Contact Us Page");
		reportStep("Locating Full Name Text box in Contact Us Page", "INFO");
		if(Utils.sendKeys(txtBxFullName, name)) {
			Log.info("Successfully entered \"Name\": " +name+"in Full Name Text box in Contact Us Page");
			reportStep("Successfully entered \"Name\": " +name+"in Full Name Text box in Contact Us Page", "PASS");
		}else {
			Log.info("Unable to enter \"Name\" in Full Name Text box in Contact Us Page");
			reportStep("Unable to enter \"Name\" in Full Name Text box in Contact Us Page", "FAIL");
		}
		return this;
	}

	//This method will verify max length of Full Name Text box in Contact Us Page
	public WPContactUsPage verifyMaxLenthOfNameTextBox() {
		String maxLength=Utils.getTestData(2, "maxLength");
		Log.info("Locating Full Name Text box in Contact Us Page");
		reportStep("Locating Full Name Text box in Contact Us Page", "INFO");
		if(txtBxFullName.getAttribute("maxlength").toString().equals(maxLength)) {
			Log.info("Successfully verified max length of Full Name Text box in Contact Us Page. It is "+ maxLength);
			reportStep("Successfully verified max length of Full Name Text box in Contact Us Page. It is "+ maxLength, "PASS");
		}else {
			Log.info("Unable to verify max length of Full Name Text box in Contact Us Page. It is "+ txtBxFullName.getAttribute("maxlength").toString());
			reportStep("Unable to verify max length of Full Name Text box in Contact Us Page. It is "+ txtBxFullName.getAttribute("maxlength").toString(), "FAIL");
		}
		return this;
	}

	//This method will verify max length of Email Text box in Contact Us Page
	public WPContactUsPage verifyMaxLenthOfEmailAddressTextBox() {
		String maxLength=Utils.getTestData(2, "maxLength");
		Log.info("Locating Email Address Text box in Contact Us Page");
		reportStep("Locating Email Address Text box in Contact Us Page", "INFO");
		if(txtBxEmailAddress.getAttribute("maxlength").toString().equals(maxLength)) {
			Log.info("Successfully verified max length of Email Address Text box in Contact Us Page. It is "+ maxLength);
			reportStep("Successfully verified max length of Email Address Text box in Contact Us Page. It is "+ maxLength, "PASS");
		}else {
			Log.info("Unable to verify max length of Email Address Text box in Contact Us Page. It is "+ txtBxEmailAddress.getAttribute("maxlength").toString());
			reportStep("Unable to verify max length of Email Address Text box in Contact Us Page. It is "+ txtBxEmailAddress.getAttribute("maxlength").toString(), "FAIL");
		}
		return this;
	}


	@FindBy(xpath="//em[text()='Please type your name']")
	private static WebElement errMsgFullNameTextBox;

	//This method will verify error message for full name text box
	public WPContactUsPage verifyErrorMsgForFullNameTxtBox() {
		Log.info("Locating Error Message for Full Name Text box in Contact Us Page");
		reportStep("Locating Error Message for Full Name Text box in Contact Us Page", "INFO");
		if(Utils.verifyElementPresence(errMsgFullNameTextBox)) {
			Log.info("Error Message Is Displayed \"Please type valid name\"" );
			reportStep("Error Message Is Displayed \"Please type valid name\"","PASS" );
		}else {
			Log.info("Error Message Is NOT Displayed \"Please type valid name\"" );
			reportStep("Error Message Is NOT Displayed \"Please type valid name\"","FAIL" );
		}
		return this;
	}

	@FindBy(id="contact_from_email")
	private static WebElement txtBxEmailAddress;

	// This method will compare previous value of Email text box with current value of text box
	public WPContactUsPage verifyEmailAddressIsEditableAndEnabled(String previous) {
		Log.info("Locating Email text box in Contact Us Page");
		reportStep("Locating Email text box in Contact Us Page", "INFO");
		String now=Utils.fetchConsoleValue("#contact_from_email", driver);
		if(! previous.equals(now)) {
			Log.info("Email text box is editable and enabled. Previously entered data is : " +previous +". Currently entered data is : " +now);
			reportStep("Email text box is editable and enabled. Previously entered data is : " +previous +". Currently entered data is : " +now, "PASS");
		}else {
			Log.info("Email text box is not editable and enabled");
			reportStep("Email text box is not editable and enabled", "FAIL");
		}
		return this;	
	}

	//This method will enter text in Email Address Text box in Contact Us Page
	public WPContactUsPage enterEmailAddress(String email) {
		Log.info("Locating Email Address Text box in Contact Us Page");
		reportStep("Locating Email Address Text box in Contact Us Page", "INFO");
		if(Utils.sendKeys(txtBxEmailAddress, email)) {
			Log.info("Successfully entered \"Email Address\": " +email+"in Email Address Text box in Contact Us Page");
			reportStep("Successfully entered \"Email Address\": " +email+"in Email Address Text box in Contact Us Page", "PASS");
		}else {
			Log.info("Unable to enter \"Email Address\" in Email Address Text box in Contact Us Page");
			reportStep("Unable to enter \"Email Address\" in Email Address Text box in Contact Us Page", "PASS");
		}
		return this;
	}

	@FindBy(xpath="//em[text()='Please type your name']")
	private static WebElement errMsgEmptyFullName;

	//This method will verify presence of error message for Empty Full Name in Contact Us Page.
	public WPContactUsPage verifyPresenceOfErrorMsgEmptyFullName() {
		Log.info("Locating \"Please type your name\" Error Message in Contact Us Page");
		reportStep("Locating \"Please type your name\"  Error Message in Contact Us Page", "INFO");
		presence=Utils.verifyElementPresence(errMsgEmptyFullName);
		if(presence) {
			Log.info("\"Please type your name\"  Error Message in Contact Us Page is displayed");
			reportStep("\"Please type your name\"  Error Message in Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\"Please type your name\"  Error Message in Contact Us Page is not displayed");
			reportStep("\"Please type your name\"  Error Message in Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}

	@FindBy(xpath="//em[text()='Please enter a valid email']")
	private static WebElement errMsgEmptyEmail;

	//This method will verify presence of error message for Empty Email Address in Contact Us Page.
	public WPContactUsPage verifyPresenceOfErrorMsgEmailAddress() {
		Log.info("Locating \"Please enter a valid email\" Error Message in Contact Us Page");
		reportStep("Locating \"Please enter a valid email\"  Error Message in Contact Us Page", "INFO");
		presence=Utils.verifyElementPresence(errMsgEmptyEmail);
		if(presence) {
			Log.info("\"Please enter a valid email\"  Error Message in Contact Us Page is displayed");
			reportStep("\"Please enter a valid email\"  Error Message in Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\"Please enter a valid email\"  Error Message in Contact Us Page is not displayed");
			reportStep("\"Please enter a valid email\"  Error Message in Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}

	@FindBy(id="message")
	private static WebElement txtAreaMessage;

	//This method will enter message in Message Text Area in Contact Us Page
	public WPContactUsPage enterMessageInMessageTextArea(String message) {
		Log.info("Locating Message Text Area in Contact Us Page");
		reportStep("Locating Message Text Area in Contact Us Page", "INFO");
		if(Utils.sendKeys(txtAreaMessage, message)) {
			Log.info("Successfully entered \"Message \": " +message+" in Message Text Area in Contact Us Page");
			reportStep("Successfully entered \"Message\": " +message+" in Message Text Area in Contact Us Page", "PASS");
		}else {
			Log.info("Unable to enter \"Message\"  in Message Text Area in Contact Us Page");
			reportStep("Unable to enter \" Message\"  in Message Text Area in Contact Us Page", "FAIL");
		}
		return this;
	}

	// This method will compare previous value of text area with current value of text area
	public WPContactUsPage verifyTextAreaIsEditableAndEnabled(String previous) {
		Log.info("Locating Message Text Area in Contact Us Page");
		reportStep("Locating Message Text Area in Contact Us Page", "INFO");
		String now=Utils.fetchConsoleValue("#message", driver);
		if(! previous.equals(now)) {
			Log.info("Message Text Area is editable and enabled. Previously entered data: "+previous+ "and currently entered data is: " +now);
			reportStep("Message Text Area is editable and enabled. Previously entered data: "+previous+ "and currently entered data is: " +now, "PASS");
		}else {
			Log.info("Message Text Area is not editable and enabled");
			reportStep("Message Text Area is not editable and enabled", "FAIL");
		}
		return this;	
	}

	@FindBy(xpath="//em[text()='Please type your message']")
	private static WebElement errMsgEmptyMessageBody;

	//This method will verify presence of error message for Empty Message in Contact Us Page.
	public WPContactUsPage verifyPresenceOfErrorMsgEmptyMessage() {
		Log.info("Locating \"Please type your message\" Error Message in Contact Us Page");
		reportStep("Locating \"Please type your message\"  Error Message in Contact Us Page", "INFO");
		presence=Utils.verifyElementPresence(errMsgEmptyMessageBody);
		if(presence) {
			Log.info("\"Please type your message\"  Error Message in Contact Us Page is displayed");
			reportStep("\"Please type your message\"  Error Message in Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\"Please type your message\"  Error Message in Contact Us Page is not displayed");
			reportStep("\"Please type your message\"  Error Message in Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}

	//Search Store or Coupon element
	@FindBy(name="search_store")
	private static WebElement txtBxSearchStoreOrCoupons;

	// Searching Voucher and Store
	public WPContactUsPage searchForVoucherOrStore(String search) {
		try {
			reportStep("Locating Search Bar in Header Section", "INFO");
			Log.info("Locating Search Bar in Header Section");
			Utils.explicitWaitForClick(txtBxSearchStoreOrCoupons);
			Utils.sendKeysAndPressEnter(txtBxSearchStoreOrCoupons, search);
			reportStep("Successfully entered what needs to be searched: " +search, "PASS");
			Log.info("Successfully entered what needs to be searched");
		}catch(Exception e) {
			Log.fatal("Unable to enter what needs to be searched in Search Bar");
			reportStep("Unable to enter what needs to be searched in Search Bar", "FAIL");
		}
		return this;
	}

	// Searching Voucher and Store
	public WPContactUsPage verifyPageTitle() {
		String pageTitle=Utils.getTestData(2, "pageTitle");
		reportStep("Getting Page Title of Contact Us Page", "INFO");
		Log.info("Getting Page Title of Contact Us Page");
		if(pageTitle.equals(Utils.getPageTitle(driver))) {
			Log.info("Page Title of Contact Us Page is equal to : "  +pageTitle);
			reportStep("Page Title of Contact Us Page is equal to : "  +pageTitle, "PASS");
		}else {
			Log.info("Page Title of Contact Us Page is not equal to : "  +pageTitle +". It is equal to : " +Utils.getPageTitle(driver));
			reportStep("Page Title of Contact Us Page is not equal to : "  +pageTitle +". It is equal to : " +Utils.getPageTitle(driver), "FAIL");
		}

		return this;
	}

	@FindBy(id="link_contactus")
	private static WebElement lnkContactUsFooter;

	//This method will click contact us link in footer of Contact Us Page
	public WPContactUsPage clickContactUsLink()  {
		Log.info("Locating Contact Us Link");
		reportStep("Locating Contact Us Link","INFO");
		if(Utils.jsClick(lnkContactUsFooter, driver)) {
			Log.info("Clicked Successfully on Contact Us Link in Footer");
			reportStep("Clicked Successfully on Contact Us Link in Footer","PASS");
		}else {
			Log.info("Unable to click Contact Us Link in Footer");
			reportStep("Unable to click Contact Us Link in Footer","FAIL");
		}
		return new WPContactUsPage(driver,logger);
	}

	//This method will refresh Contact Us Page
	public WPContactUsPage refreshContactUsPage()  {
		Log.info("Refreshing Contact Us Page");
		reportStep("Refreshing Contact Us Page","INFO");
		Utils.refresh(driver);
		Log.info("Contact Us Page is Refreshed");
		reportStep("Contact Us Page is Refreshed","PASS");
		return new WPContactUsPage(driver,logger);
	}

	@FindBy(xpath = "//em[text()='Your message has been sent successfully, we will contact you soon']")
	private static WebElement lblSuccessMessageForContactUsFormSubmit;

	//This method will verify success message "Your message has been sent successfully, we will contact you soon" in contact us Form
	public WPContactUsPage successMsgSentSuccesFullyContactUs()  {
		Log.info("Locating \"Your message has been sent successfully, we will contact you soon\" success message Contact Us Page");
		reportStep("Locating \"Your message has been sent successfully, we will contact you soon\" success message Contact Us Page","INFO");
		presence=Utils.verifyElementPresence(lblSuccessMessageForContactUsFormSubmit);
		if(presence) {
			Log.info("\"Your message has been sent successfully, we will contact you soon\" success message Contact Us Page is displayed");
			reportStep("\"Your message has been sent successfully, we will contact you soon\" success message Contact Us Page is displayed", "PASS");
		}else {
			Log.info("\"Your message has been sent successfully, we will contact you soon\" success message Contact Us Page is not displayed");
			reportStep("\"Your message has been sent successfully, we will contact you soon\" success message Contact Us Page is not displayed", "FAIL");
		}
		return this;
	}
}
