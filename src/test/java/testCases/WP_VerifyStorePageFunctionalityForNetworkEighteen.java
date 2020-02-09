package testCases;

import org.testng.annotations.Test;

import pageObjects.WPHomePage;
import pageObjects.WPIntermediaryPage;
import testData.StoreTestData;
import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class WP_VerifyStorePageFunctionalityForNetworkEighteen extends TestSetUp{
	@Test(enabled=true)
	public void verifyAllUserNewUserRadioButtonFunctionality() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("N18_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String start="Validation of All User Radio Button and New User Radio Button Functionality...... Started";
		String completed="Validation of All User Radio Button and New User Radio Button Functionality...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		verifyAllUserNewUserRadioButtonFucntionality();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	@Test(enabled=true)
	public void verifyLnkUrlContainsOnClickingGrabDealInStorePage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("N18_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String email=Utils.getTestData(2,"ValidUserId");;
		String password=Utils.getTestData(2,"password");
		String start="Validation of presence of Link URL on clicking Grab Deal Link  in Store Page....... Started";
		String completed="Validation of presence of Link URL on clicking Grab Deal Link  in Store Page....... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickGrabDealLink(1);
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains("myntra");
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	@Test(enabled=true)
	public void verifyNormalCashbackBothPryAndSecondaryInPercentage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("N18_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String start="Validation of Normal Network 18 for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Normal Network 18 for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		verifyStorePageShortDescriptionText("str_Store_One_Short_Description").
		verifyStorePageVoucherTitleText("str_Store_One_Voucher_One_Name").
		verifyStorePageVoucherTwoText("str_Store_One_Voucher_Two_Name").
		clickLinkSeeOrHideDetailsForFirstVoucher().
		clickLinkSeeOrHideDetailsForFirstVoucher().
		verifyFirstVoucherDescriptionText("str_Store_One_Voucher_One_Desc").
		clickLinkSeeOrHideDetailsForSecondVoucher().
		verifySecondVoucherDescriptionText("str_Store_One_Voucher_Two_Desc");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	@Test(enabled=true)
	public void verifyIntermediaryPageAfterClickingGrabDeal() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("N18_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String email=Utils.getTestData(2,"ValidUserId");;
		String password=Utils.getTestData(2,"password");
		String start="Validation of presence of Link URL on clicking Grab Deal Link  in Store Page....... Started";
		String completed="Validation of presence of Link URL on clicking Grab Deal Link  in Store Page....... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickGrabDealLink(1);
		Utils.switchToNewlyOpenWindow(driver);
		new WPIntermediaryPage(driver, logger).
		stopIntermediaryPageFromNavigation().
		verifyArrowNavigationIsPresent().
		verifyIntermediaryCurrencySymbolIsPresent().
		verifyIntermediaryRetailerNameIsPresent().
		verifyIntermediaryWordPressLogoIsPresent().
		clickHereLink();
		Utils.explicitWaitForUrlContains("myntra");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
}




