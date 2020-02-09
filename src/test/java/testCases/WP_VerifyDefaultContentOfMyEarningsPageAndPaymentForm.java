package testCases;

import org.testng.annotations.Test;

import pageObjects.WPHomePage;
import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class WP_VerifyDefaultContentOfMyEarningsPageAndPaymentForm extends TestSetUp{

	/**
	 * This method will validate "TOTAL CASHBACK EARNED" and "TOTAL REWARDS EARNED" link can be expanded and collapsed.
	 * Also it will verify label of "TOTAL CASHBACK EARNED" and "TOTAL REWARDS EARNED" link in the header 
	 * section.
	 */
	@Test(enabled=true)
	public void verifyTotalEarningsEarnedAndTotalCashbackEarnedCanbeExpandedAndCollapsed() {
		String start="Validation of \"TOTAL CASHBACK EARNED\" and \"TOTAL REWARDS EARNED\" link of Header Section My Earning Page Started";
		String completed="Validation of \"TOTAL CASHBACK EARNED\" and \"TOTAL REWARDS EARNED\" link of Header Section My Earning Page Completed";
		Log.info(start);
		reportStep(start,"INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email); 
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabel().
		clickMyEarningLink().
		verifyTotalCashBackEarnedHeaderLinkIsExpanded().
		verifyTotalRewardsEarnedHeaderLinkIsExpanded().
		clickTotalCashBackEarnedHeaderLink().
		clickTotalRewardsEarnedHeaderLink().
		verifyTotalCashBackEarnedHeaderLinkIsCollapsed().
		verifyTotalRewardsEarnedHeaderLinkIsCollapsed().
		clickTotalCashBackEarnedHeaderLink().
		clickTotalRewardsEarnedHeaderLink().
		verifyTotalCashBackEarnedHeaderLinkIsExpanded().
		verifyTotalRewardsEarnedHeaderLinkIsExpanded();
		Log.info(completed);
		reportStep(completed,"INFO");
	}
	
	/**
	 * This method will validate default content on My Earnings Label for a registered user.
	 * It will include validation of Paid Cahback, Paid Rewards, Pending Cashback, Pending Rewards, Available for Payment Cashback, Available
	 * for Payment Rewards, Your Total Earnings, etc..
	 */
	@Test(enabled=true)
	public void verifyDefaultConetentsOfMyEarningsLeftNavPage() {
		String start="Validation of default content of My Earning Page in left Navigation Page for existing user Started";
		String completed="Validation of default content of My Earning Page in left Navigation for existing user Page Completed";
		Log.info(start);
		reportStep(start,"INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		reportStep("Verification of Successful Login started", "PASS");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabel().
		clickMyEarningLink().
		verifyPresenceOfPaidCashbackHeaderSection().
		verifyPresenceOfPaidRewardsHeaderSection().
		verifyPresenceOfPendingCashbackHeaderSection().
		verifyPresenceOfPendingRewardsHeaderSection().
		verifyPresenceOfAvailableForPaymentCashbackHeaderSection().
		verifyPresenceOfAvailableForPaymentRewardsHeaderSection().
		verifyPresenceOfTotalCashbackEarnings().
		verifyPresenceOfCashbackShowMoreLink().
		verifyPresenceOfMissingCashbackLabel().
		clickTabRewardEarnings().
		verifyPresenceOfMissingRewardsLabel().
		verifyPresenceOfTotalRewardEarnings().
		verifyPresenceOfRewardShowMoreLink();
		Log.info(completed);
		reportStep(completed,"INFO");
	}
	
	/**
	 * This method will verify Show More Functionality by initially counting number of rows under Cashback Earning Tab then it will click Show More 
	 * Link under this tab and count number of rows. If Number of rows after clicking Show more is greater than initial count. Show more functionality 
	 * is working as expected. The same will be verified for Rewards Earnings Tab Show More.
	 * Preconditions: Atleast 6 to 7 request should be processed for the user so that Show More link is visible.
	 */
	@Test(enabled=true)
	public void verifyShowMoreFunctionalityUnderCashBackEarningsAndRewardsEarningsTab() {
		String start="Validation of Show More Functionality For both Cashback Earnings and Rewards Earnings Tab Started";
		String completed="Validation of Show More Functionality For both Cashback Earnings and Rewards Earnings Tab Completed";
		Log.info(start);
		reportStep(start,"INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email); 
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabel().
		clickMyEarningLink().
		verifyNumberOfRowsIsGreaterAfterClickingShowMoreLinkUnderCashBackEarningTab().
		clickTabRewardEarnings().
		verifyNumberOfRowsIsGreaterAfterClickingShowMoreLinkUnderRewardsEarningTab();
		Log.info(completed);
		reportStep(completed,"INFO");
	}
	
	/**
	 * This method will verify list of Payment Method available in Payment Form for a new User.
	 * 
	 */
	@Test(enabled=true)
	public void verifyListOfPaymentMethodAvailableInPaymentForm() {
		String start="Validation of List of Payment Method Option Avaiable in Payment Form Started";
		String completed="Validation of List of Payment Method Option Avaiable in Payment Form Completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String paymentOptions=Utils.getTestData(6, "paymentOptions");
		
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
		clickMyAccountLabel().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		verifyAllPaymentOptionsAreAvailable(paymentOptions);
		Log.info(completed);
		reportStep(completed,"PASS");
	}
	
	/**
	 * This method will verify default Components of Payment Form When New User request rewards Payment.
	 */
	@Test(enabled=true)
	public void verifyDefaultComponentsOfPaymentFormWhenNewUserRequestRewardsPayment() {
		String start="Validation of presence of default component in Payment Form when a user requested reward payment Started";
		String completed="Validation of presence of default component in Payment Form when a user requested reward payment completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		
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
		clickMyAccountLabel().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestRewardsPaymentButtonToNavigateToPaymentForm().
		verifyPresenceOfRewardsAvailableForPaymentLabel().
		verifyPresenceOfRewardsAmountAvailableForPaymentLabel().
		verifyPresenceOfChoosePaymentMethodLabel().
		verifyDefaultSelectedPaymentMethod("Amazon Gift Card").
		verifyPresenceOfEnterGiftCardDetailsLabel().
		verifyPresenceOfEmailIdToSendGiftCardLabel().
		verifyPresenceOfWouldYouDonateCharityLabel().
		verifyPresenceOfSelectCharityToDonateLabel().
		verifyPresenceOfRewardsYouWishToDonateLabel().
		verifyPresenceOfRewardsAvailableAfterDonationLabel().
		verifyTextOfGetPaidButton().
		verifyPresenceOfAmountAvailableAfterDonation().
		verifyPresenceCharityAmountTextBox();
		Log.info(completed);
		reportStep(completed,"PASS");
	}
	

	/**
	 * This method will verify default Components of Payment Form When New User request Cash back Payment.
	 */
	@Test(enabled=true)
	public void verifyDefaultComponentsOfPaymentFormWhenNewUserRequestCashbackPayment() {
		String start="Validation of presence of default component in Payment Form when a user requested Cashback payment Started";
		String completed="Validation of presence of default component in Payment Form when a user requested Cashback payment completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		
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
		clickMyAccountLabel().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigate().
		verifyPresenceOfCashbackAvailableForPaymentLabel().
		verifyPresenceOfRewardsAmountAvailableForPaymentLabel().
		verifyPresenceOfChoosePaymentMethodLabel().
		verifyDefaultSelectedPaymentMethod("Bank Payment (NEFT)").
		verifyPresenceOfEnterBankDetailsLabel().
		verifyPresenceOfNameOfBankAccountHolderLabel().
		verifyPresenceOfBankNameLabel().
		verifyPresenceOfCashbackAvailableForPaymentLabel().
		verifyPresenceOfBankAccountNumberLabel().
		verifyPresenceOfBankIfscCodeLabel().
		verifyPresenceOfBankBranchNameLabel().
		verifyPresenceOfSelectCharityToDonateCashbackLabel().
		verifyPresenceOfCashbackYouWishToDonateLabel().
		verifyPresenceOfCashbackAvailableAfterDonationLabel().
		verifyPresenceOfWouldYouDonateCashbackCharityLabel().
		verifyTextOfGetPaidButton().
		verifyPresenceOfAmountAvailableAfterDonation().
		verifyPresenceCharityAmountTextBox();
		Log.info(completed);
		reportStep(completed,"PASS");
	}
	
	/**
	 * This method will validate Month and Year drop down.
	 */
	@Test(enabled=true)
	public void verifyMonthDropDownInMyEarningsPage() {
		String start="Validation of presence of default component in Payment Form when a user requested Cashback payment Started";
		String completed="Validation of presence of default component in Payment Form when a user requested Cashback payment completed";
		Log.info(start);
		reportStep(start,"INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email); 
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		enterEmailDuringSignIn(email).
		enterPasswordDuringSignIn(password).
		clickOnSignInButton().
		clickMyAccountLabel().
		clickMyEarningLink().
		verifyFirstSelectedValueInMonthYearDropDownList();
		Log.info(completed);
		reportStep(completed,"PASS");
		
	}
	
	/**
	 * This method will validate default content of Payments Page when both cashback and rewards are more than or equal to threshold.
	 * Cash Back= Rs 250 and Rewards = Rs 250
	 * Each time a new user will be created.
	 *   
	 */
	@Test(enabled=true)
	public void verifyDefaultContentOfPaymentPageWhenBothCashBackAndRewardsEqualToThreshold() {
		String start="Validation of Default Content Of Payment Page When Both Cash Back And Rewards Equal To Threshold for a new user Started";
		String completed="Validation of Default Content Of Payment Page When Both Cash Back And Rewards Equal To Threshold for a new user completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String rewardsType=Utils.getTestData(6, "RewardsType");
		
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
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, rewardsType).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		verifyAmountAvailableForPaymentLabel().
		verifyEarningAvailableForPaymentLabel().
		verifyCashBackAndRewardsAmount250Each().
		verifyInfoAboutRequestPayment1().
		verifyInfoAboutRequestPayment2().
		clickHereLinkInPaymentPage().
		clickHereLinkCloseIconInPaymentPage().
		verifyInfoAboutRequestPayment3();
		Log.info(completed);
		reportStep(completed,"PASS");
	}
}
