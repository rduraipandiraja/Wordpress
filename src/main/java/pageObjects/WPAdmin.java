package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.app.ck.pages.admin.AdminCashbackPage;
import com.app.ck.pages.admin.AdminCoreFunction;
import com.app.ck.pages.admin.AdminMissingCashback;
import com.app.ck.pages.admin.AdminReportsPage;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Constant;
import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class WPAdmin extends TestSetUp{
	
	public WPAdmin(WebDriver driver, ExtentTest logger){
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		Log.info("Openinging Admin Page");
		reportStep("Openinging Admin Page", "INFO");
	}
	
	public WPAdmin loginToWordPressAdmin(String url,WebDriver driver,String userName,String pwd, String partnerType) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		reportStep("Successfully Opened Admin Site","PASS");
		AdminCoreFunction adminFunctions = new AdminCoreFunction(driver, logger);
		adminFunctions.selectDropdownValue(driver, partnerType);
		
		adminFunctions.enterUsername(userName);
		adminFunctions.enterPassword(pwd);
		adminFunctions.clickSubmit();
		return this;
	}
	
	public String retrieveExitClick(WebDriver driver, String userEmail) {
		String url=Constant.BETAADMIN;
		String password=Utils.getTestData(8, "password");
		String email=Utils.getTestData(8, "userName");
		String partnerType=Utils.getTestData(8, "partnerType");
		loginToWordPressAdmin(url,driver,email,password,partnerType);
		AdminCoreFunction adminFunctions = new AdminCoreFunction(driver, logger);
		AdminReportsPage reportsPage = new AdminReportsPage(driver, logger);
		adminFunctions.clickOnReports();
		reportsPage.clickExitClickSubMenu();
		reportsPage.selectSearchByDropDown(driver, "User Email");
		reportsPage.enterKeyword(userEmail);
		reportsPage.clickSubmit();
		String exitClick = reportsPage.extractExitClickValueFromResultstableFirstRow();	
		return exitClick;
	}
	
	public String retrieveMostRecentExitClick(WebDriver driver) {
		AdminReportsPage reportsPage = new AdminReportsPage(driver, logger);
		Utils.refresh(driver);
		String exitClick=reportsPage.extractExitClickValueFromResultstableFirstRow();
		return exitClick;
	}
	public String retrieveExitClickChangeStatusToPending(WebDriver driver, String userEmail,String cashBackType) {
		String url=Constant.BETAADMIN;
		String password=Utils.getTestData(8, "password");
		String email=Utils.getTestData(8, "userName");
		String partnerType=Utils.getTestData(8, "partnerType");
		loginToWordPressAdmin(url,driver,email,password,partnerType);
		AdminCoreFunction adminFunctions = new AdminCoreFunction(driver, logger);
		AdminReportsPage reportsPage = new AdminReportsPage(driver, logger);
		adminFunctions.clickOnReports();
		reportsPage.clickExitClickSubMenu();
		reportsPage.selectSearchByDropDown(driver, "User Email");
		reportsPage.enterKeyword(userEmail);
		reportsPage.clickSubmit();
		String exitClick = reportsPage.extractExitClickValueFromResultstableFirstRow();	
		AdminCashbackPage cashbackPage = new AdminCashbackPage(driver, logger);
		adminFunctions.clickCashbackMenu();
		cashbackPage.clickCashbackSubMenu();
		cashbackPage.clickAddNewButton();
		cashbackPage.enterExitId(exitClick);
		cashbackPage.entertransactionId(exitClick);
		cashbackPage.enterOrderId(exitClick);
		cashbackPage.setOrderDate();
		cashbackPage.enterOrderValue(Utils.getTestData(6, "totalOrderAmount"));
		cashbackPage.enterconfirmCommisionNetwork("500");
		cashbackPage.entercashback(Utils.getTestData(6, "thresholdAmount"));
		cashbackPage.selectCashbackTypeFromDropDown(cashBackType);
		cashbackPage.selectCashbackStatusFromDropDown("Pending");
		cashbackPage.setPendingDate();
		cashbackPage.enterDetails(exitClick);
		cashbackPage.clickSubmit();
		return exitClick;
	}
	
	public void changePendingStatusToConfirm(WebDriver driver,String exitClick) throws Exception{
		AdminCashbackPage cashbackPage = new AdminCashbackPage(driver, logger);
		cashbackPage.clickCashbackSubMenu();
		cashbackPage.selectSearchByStatusFromDropDown("Exit ID");
		cashbackPage.enterKeyword(exitClick);
		cashbackPage.selectCashbackStatusFromDropDown("Pending");
		cashbackPage.clickSubmit();
		Thread.sleep(3000);
		cashbackPage.clickEdit();
		cashbackPage.selectCashbackStatusFromDropDown("Confirmed");
		cashbackPage.setConfirmDate();
		cashbackPage.clickSubmit();
	}
	
	public void changePendingStatusToCancel(WebDriver driver,String exitClick) throws Exception {
		AdminCashbackPage cashbackPage = new AdminCashbackPage(driver, logger);
		cashbackPage.clickCashbackSubMenu();
		cashbackPage.selectSearchByStatusFromDropDown("Exit ID");
		cashbackPage.enterKeyword(exitClick);
		cashbackPage.selectCashbackStatusFromDropDown("Pending");
		cashbackPage.clickSubmit();
		Thread.sleep(3000);
		cashbackPage.clickEdit();
		cashbackPage.selectCashbackStatusFromDropDown("Cancelled");
		cashbackPage.setFailDate();
		cashbackPage.clickSubmit();

	}
	
	public String changeStatusMissingCashBackTicketToSentToRetailer(WebDriver driver,String exitClick) {		
		AdminCoreFunction adminFunctions = new AdminCoreFunction(driver, logger);
		AdminMissingCashback adminMissingCashback = new AdminMissingCashback(driver, logger);
		adminFunctions.clickOnInteractiveMainMenu();
		adminFunctions.clickOnsubMenuUserTickets();
		adminMissingCashback.selectSearchbyExitClickIDFromDropDown();
		adminMissingCashback.enerKeyWordatAdminMissingCashbackPage(exitClick);
		adminMissingCashback.clickOnSearchButton();
		String ticketId = adminMissingCashback.fetchTicketID(exitClick);
		adminMissingCashback.clickOnEditButton(exitClick);
		adminMissingCashback.enterAdminReply("Changing Status To Sent To Retailer");
		adminMissingCashback.selectTicketStatus("Sent to retailer");
		adminMissingCashback.clickOnSubmitButton();
		return ticketId;
	}
	
	public void changeStatusMissingCashBackTicketToResolved(WebDriver driver) {
		AdminMissingCashback adminMissingCashback = new AdminMissingCashback(driver, logger);
		adminMissingCashback.enterAdminReply("Changing Status To Sent To Resolved");
		adminMissingCashback.selectTicketStatus("Resolved");
		adminMissingCashback.clickOnSubmitButton();
	}
	
}
