package paytmCashBackTestCases;

import org.testng.annotations.Test;

import pageObjects.WPHomePage;
import pageObjects.WPStorePage;
import testData.StoreTestData;
import utility.Log;
import utility.TestSetUp;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 * This class will validate various Store Page Cashback related scenario both positive and negative.
 * For this, various kinds of data needs to be created from Admin and then needs to validate the same in front end.
 * For Test Data for this page, JSON file is being used.
 * 
 */
public class WP_VerifyStorePageFunctionalityForCashBack extends TestSetUp{
	
	/**
	 * Method Name: verifyNormalCashbackBothPryAndSecondaryInPercentage
	 * This method will verify Normal Cashback for both Primary and secondary in percentage.
	 * Here Store is created with Normal Cashback data in Pecentage.
	 */
	@Test(enabled=false )
	public void verifyNormalCashbackBothPryAndSecondaryInPercentage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("CB_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String start="Validation of Normal Cashback for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Normal Cashback for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_One_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_One_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_One_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_One_Secondary_Cashback_Value").
		verifyPercentageSymbolPrimaryCashBack().
		verifyPercentageSymbolSecondaryCashBack().
		clickLinkHideCashbackRates().
		verifyStorePageShortDescriptionText("str_Store_One_Short_Description").
		verifyStorePageVoucherTitleText("storeOneVoucherOneName").
		verifyStorePageVoucherTwoText("str_Store_One_Voucher_Two_Name").
		clickLinkSeeOrHideDetailsForFirstVoucher().
		clickLinkSeeOrHideDetailsForFirstVoucher().
		verifyFirstVoucherDescriptionText("str_Store_One_Voucher_One_Desc").
		clickLinkSeeOrHideDetailsForSecondVoucher().
		verifySecondVoucherDescriptionText("str_Store_One_Voucher_Two_Desc");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * This method will validate Message presence in case there is no offers present in Store Page.
	 * Message: Sorry, there are no offers available for "Store Name" currently. Please check back after some time.
	 */
	@Test(enabled=true)
	public void verifyPresenceOfMessageWhenNoOffersArePresentInStorePage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("CB_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String start="Validation of Normal Cashback for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Normal Cashback for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		verifyMessageNoOffersAvailableIsDisplayed(storeName);
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyCalenderCashbackBothPrimaryAndSecondaryInPercentage
	 * This method will verify Calendar Cash back for both Primary and secondary in percentage.
	 * Here Coupon code is copied or not is also verified.
	 */
	@Test(enabled=true)
	public void verifyCalendarCashbackBothPrimaryAndSecondaryInPercentage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreTwo("CB_Store_Two");
		String storeName=std.getStoreName("str_Store_Two_Name");
		String start="Validation of Calender Cashback for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Calender Cashback for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyPercentageSymbolPrimaryCashBack().
		verifyPercentageSymbolSecondaryCashBack().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Two_Primary_Cashback_Details").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Two_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Two_Secondary_Cashback_Value").
		clickLinkHideCashbackRates().
		clickCopyCode().
		verifyCouponCodeIsCopied().
		verifyCouponCodeText("str_Store_Two_Voucher_Two_CODE");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyMultipleSecondaryCashbackBothPrimaryAndSecondaryInPercentage
	 * This method will verify scenario where multiple secondary cash back value would
	 * be there and one primary value. All the value would be in Percentage
	 */
	@Test(enabled=true)
	public void verifyMultipleSecondaryCashbackBothPrimaryAndSecondaryInPercentage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreThree("CB_Store_Three");
		String storeName=std.getStoreName("str_Store_Three_Name");
		String start="Validation of Multiple Secondary Cashback for both Primary and secondary Voucher in percentage...... Started";
		String completed="Validation of Multiple Secondary Cashback for both Primary and secondary Voucher in percentage...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyPercentageSymbolPrimaryCashBack().
		verifyPercentageSymbolSecondaryCashBack().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Three_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_Three_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Three_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Three_Secondary_Cashback_Value").
		verifyStorePageSecondSecondaryCashBackDetailsText("str_Store_Three_Secondary_Cashback_Details").
		verifyStorePageSecondSecondaryCashbackValueText("str_Store_Three_Secondary_Cashback_Value").
		clickLinkHideCashbackRates();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyInactiveStoreWillNotBeDisplayedInFrontEnd
	 * This method will validate that inactive store will not display in
	 * front end on searching.
	 */
	@Test(enabled=true)
	public void verifyInactiveStoreWillNotBeDisplayedInFrontEnd() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreFour("CB_Store_Four");
		String storeName=std.getStoreName("str_Store_Four_Name");
		String start="Validation of Inactive Store Not Displaying in Front End ...... Started";
		String completed="Validation of Inactive Store Not Displaying in Front End ...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		verifyInactiveStoreNotDisplayingInSearchResultPage(storeName);
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyCalendarPrimaryAndSecondaryCashbackExclusiveExpiresInDays
	 * This method will verify scenario where secondary calendar cash back value would
	 * be there and one primary calendar value. This will also verify Exclusive: Expires in x days text
	 */
	@Test(enabled=true)
	public void verifyCalendarPrimaryAndSecondaryCashbackExclusiveExpiresInDays() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreSix("CB_Store_Six");
		String storeName=std.getStoreName("str_Store_Six_Name");
		String start="Validation of Multiple Secondary Calender Cashback for both Primary and secondary Voucher in Currency...... Started";
		String completed="Validation of Multiple Secondary Calender Cashback for both Primary and secondary Voucher in Currency...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Six_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_Six_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Six_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Six_Secondary_Cashback_Value").
		verifyStorePageSecondaryCalenderCashBackExpiresIn().
		verifyStorePagePrimaryCalenderCashBackExpiresIn().
		clickLinkHideCashbackRates();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyCalendarPrimaryAndSecondaryCashbackIncreasedExpiresInDays
	 * This method will verify scenario where secondary calendar cash back value would
	 * be there and one primary calendar value. This method will also verify Increased: Expires in x days text
	 */
	@Test(enabled=true)
	public void verifyCalendarPrimaryAndSecondaryCashbackIncreasedExpiresInDays() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreSeven("CB_Store_Seven");
		String storeName=std.getStoreName("str_Store_Seven_Name");
		String start="Validation of Increased Expires in x days for primary and Secondary Calender Cashback ...... Started";
		String completed="Validation of Increased Expires in x days for primary and Secondary Calender Cashback ...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Seven_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_Seven_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Seven_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Seven_Secondary_Cashback_Value").
		verifyStorePagePrimaryCalenderIncreasedExpiresIn().
		verifyStorePageSecondaryCalenderIncreasedExpiresIn().
		clickLinkHideCashbackRates();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyCalendarPryAndSecondaryCashbackAndNormalSecondaryCashbackWithIncreasedExpiresIn
	 * This method will validate Calendar Primary and Secondary Cash back with normal Secondary Cash back.
	 * Also it will validate Increased Expires In scenario
	 */
	@Test(enabled=true)
	public void verifyCalendarPryAndSecondaryCashbackAndNormalSecondaryCashbackWithIncreasedExpiresIn() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreNine("CB_Store_Nine");
		String storeName=std.getStoreName("str_Store_Nine_Name");
		String start="Validation of Increased Expires in x days for primary and Secondary Calender Cashback along with normal Secondary Cashback...... Started";
		String completed="Validation of Increased Expires in x days for primary and Secondary Calender Cashback along with normal Secondary Cashback...... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickLinkShowCashbackRates().
		verifyCurrencyeSymbolSecondaryCashBack().
		verifyCurrencySymbolPrimaryCashBack().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Nine_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_Nine_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Nine_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Nine_Secondary_Cashback_Value").
		verifyStorePageSecondSecondaryCashBackDetailsText("str_Store_Nine_Secondary_Cashback_Details").
		verifyStorePageSecondSecondaryCashbackValueText("str_Store_Nine_Secondary_Cashback_Value").
		verifyStorePagePrimaryCalenderIncreasedExpiresIn().
		verifyStorePageSecondaryCalenderIncreasedExpiresIn().
		clickLinkHideCashbackRates();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyAllUserNewUserRadioButtonFunctionality
	 * This test will validate All User and New User Radio Button Functionality.
	 */
	@Test(enabled=true)
	public void verifyAllUserNewUserRadioButtonFunctionality() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreEleven("CB_Store_Eleven");
		String storeName=std.getStoreName("str_Store_Eleven_Name");
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

	/**
	 * Method Name: verifyvoucherHeadingIncreasedAndExclusiveLabelInStorePage
	 * This test will validate presence of Voucher Heading, Increased And Exclusive Label 
	 * in Store Page.
	 */
	@Test(enabled=true)
	public void verifyVoucherHeadingIncreasedAndExclusiveLabelInStorePage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreEleven("CB_Store_Eleven");
		String storeName=std.getStoreName("str_Store_Eleven_Name");
		String start="Validation of presence of Voucher Heading, Increased And Exclusive Label  in Store Page....... Started";
		String completed="Validation presence of Voucher Heading, Increased And Exclusive Label  in Store Page....... Completed";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName).
		clickCloseIcon().
		verifyExclusiveLabelInStorePage().
		verifyIncreasedLabelInStorePage().
		verifyVoucherHeadingLabelInStorePage();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyLnkUrlContainsOnClickingActivateCashBackInStorePage
	 * This test will validate presence of Link URL contains "Myntra" on
	 * clicking Activate Cash back Link in Store Page.
	 */
	@Test(enabled=true)
	public void verifyLnkUrlContainsOnClickingActivateCashBackInStorePage() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreEleven("CB_Store_Eleven");
		String storeName=std.getStoreName("str_Store_Eleven_Name");
		String email=Utils.getTestData(2,"ValidUserId");;
		String password=Utils.getTestData(2,"password");
		String start="Validation of presence of Link URL on clicking Activate CashBack Link  in Store Page....... Started";
		String completed="Validation of presence of Link URL on clicking Activate CashBack Link  in Store Page....... Completed";
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
		clickActivateCashBackInSP();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains("myntra");
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyNormalCashbackBothPryAndSecondaryInPercentageForRegisteredUser
	 * This method will verify Normal Cashback for both Primary and secondary in percentage For Registered User.
	 * Here Store is created with Normal Cashback data in Pecentage.
	 */
	@Test(enabled=false )
	public void verifyNormalCashbackBothPryAndSecondaryInPercentageForRegisteredUser() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValuesForStoreOne("CB_Store_One");
		String storeName=std.getStoreName("str_Store_One_Name");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		String start="Validation of Normal Cashback for both Primary and secondary Voucher in percentage For Registered User...... Started";
		String completed="Validation of Normal Cashback for both Primary and secondary Voucher in percentage For Registered User...... Completed";
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
		clickLinkShowCashbackRates().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_One_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_One_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_One_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_One_Secondary_Cashback_Value").
		clickLinkHideCashbackRates().
		verifyStorePageShortDescriptionText("str_Store_One_Short_Description").
		verifyStorePageVoucherTitleText("storeOneVoucherOneName").
		verifyStorePageVoucherTwoText("str_Store_One_Voucher_Two_Name").
		clickLinkSeeOrHideDetailsForFirstVoucher().
		clickLinkSeeOrHideDetailsForFirstVoucher().
		verifyFirstVoucherDescriptionText("str_Store_One_Voucher_One_Desc").
		clickLinkSeeOrHideDetailsForSecondVoucher().
		verifySecondVoucherDescriptionText("str_Store_One_Voucher_Two_Desc");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	/**
	 * Method Name: verifyMultipleSecondaryCashbackBothPrimaryAndSecondaryInPercentageForRegisteredUser
	 * This method will verify scenario where multiple secondary cash back value would
	 * be there and one primary value For Registered User. All the value would be in Percentage
	 */
	@Test(enabled=true)
	public void verifyMultipleSecondaryCashbackBothPrimaryAndSecondaryInPercentageForRegisteredUser() {
		StoreTestData std=new StoreTestData(driver, logger);
		StoreTestData.extractJsonValueForStoreThree("CB_Store_Three");
		String storeName=std.getStoreName("str_Store_Three_Name");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		String start="Validation of Multiple Secondary Cashback for both Primary and secondary Voucher in percentage For Registered User...... Started";
		String completed="Validation of Multiple Secondary Cashback for both Primary and secondary Voucher in percentage For Registered User...... Completed";
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
		clickLinkShowCashbackRates().
		verifyStorePagePrimaryCashBackDetailsText("str_Store_Three_Primary_Cashback_Details").
		verifyStorePagePrimaryCashbackValueText("str_Store_Three_Primary_Cashback_Value").
		verifyStorePageSecondaryCashBackDetailsText("str_Store_Three_Secondary_Cashback_Details").
		verifyStorePageSecondaryCashbackValueText("str_Store_Three_Secondary_Cashback_Value").
		verifyStorePageSecondSecondaryCashBackDetailsText("str_Store_Three_Secondary_Cashback_Details").
		verifyStorePageSecondSecondaryCashbackValueText("str_Store_Three_Secondary_Cashback_Value").
		clickLinkHideCashbackRates();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	/**
	 * Method Name: verifyCategoriesFunctionalityForCashBackInStorePage
	 * Below method will require a Store in which all three categories : Rewards, Cashback and Network 18 type boucher should be present.
	 * It will verify all three categories one by one.
	 * 
	 */
	@Test(enabled=true)
	public void verifyCategoriesFunctionalityForCashBackInStorePage() {
		String started="Validation of Store Page Category Drop Down Functionality ......started";
		String completed="Validation of Store Page Category Drop Down Functionality ......completed";
		Log.info(started);
		reportStep(started, "INFO");
		String storeName=StoreTestData.extractJsonValuesForStoreTen("CB_Store_Ten");
		new WPHomePage(driver, logger).
		searchForVoucherOrStore(storeName).
		clickOnStoreImage(storeName);
		WPStorePage storePage=new WPStorePage(driver, logger);
		int defaultVoucherCount=storePage.countNumberOfAllUserVoucherCard();
		storePage.clickCategoriesList().
		clickNetworkEighteenCategory();
		int networkEighteenVoucherCardCount=storePage.countNumberOfVisibleVoucherCard();
		storePage.clickCategoriesList().
		clickRewardsCategory();
		int rewardsVoucherCardCount=storePage.countNumberOfVisibleVoucherCard();
		storePage.clickCategoriesList().
		clickCashbackCategory();
		int cashbackVoucherCardCount=storePage.countNumberOfVisibleVoucherCard();
		storePage.clickCategoriesList().
		clickAllCategory();
		int allVoucherCardCount=storePage.countNumberOfVisibleVoucherCard();
			if((defaultVoucherCount==allVoucherCardCount)&&(defaultVoucherCount==(networkEighteenVoucherCardCount+rewardsVoucherCardCount+cashbackVoucherCardCount))) {
				Log.info(completed);
				reportStep(completed, "PASS");
			}else {
				Log.info(completed);
				reportStep(completed, "FAIL");
			}
	}
}
