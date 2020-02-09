package paytmCashBackTestCases;

import org.testng.annotations.Test;

import pageObjects.WPAdmin;
import pageObjects.WPHomePage;
import pageObjects.WPMyEarningsPage;
import pageObjects.WPPaymentPage;
import pageObjects.WPSearchResultsPage;
import utility.TestSetUp;
import utility.Log;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 *	This class will verify various successful Payment Processing Scenario.
 *  This class will also verify negative scenarios in which user will not be able to claim cashback and rewards.
 *
 */

public class WP_VerifyPaymentProcessingOfBothCashbackAndRewardsInMyEarnings extends TestSetUp{

	/**
	 * This method will verify successful payment processing by clicking Request cash back Payment button for already registered user.
	 */

	@Test(enabled=true)
	public void verifySuccessfulCashBackPaymentForAlreadyRegisteredUser() {
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for already registered user.---- Started");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for already registered user.---- Started", "INFO");
		String otp="";
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType="Cashback";
		String email=Utils.getTestData(2,"ValidUserId");
		String password=Utils.getTestData(2,"password");
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email); 
		WPPaymentPage paymentPage = new WPHomePage(driver, logger).
				clickOnlblSignInSignUP().
				clickOnlnkSignIn().
				enterEmailDuringSignIn(email).
				enterPasswordDuringSignIn(password).
				clickOnSignInButton().
				clickMyAccountLabel().
				clickMyEarningLink().
				addCashbackRewards(amount, email, cashBackType).
				clickRequestCashbackPaymentButton().
				clickOnlyRedeemCashBackEarningsLink().
				clickGetPaidButton();
		otp=Utils.getOTPCode(Utils.getTestData(2, "phoneNumberAlreadyRegistered"), driver);
		paymentPage.
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for already registered user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for already registered user.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify Successful Payment processing 
	 * for a New User using Cash back Payment Processing method.
	 */
	@Test(enabled=true)
	public void verifySuccessfulCashBackPaymentForNewUser() {
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for New User.---- Started");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for New User .---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String ifscCode=Utils.getTestData(6, "ifscCode");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String bankBranchName=Utils.getTestData(6, "bankBranchName");
		String bankName=Utils.getTestData(6, "bankName");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String otp="";
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
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon().
		verifyPresenceOfRequestedStatusLabel();
		Utils.clearCashbackRewards(driver, email); 
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		verifyPresenceOfPaidStatusLabel();
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for New user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for New user.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify Successful Payment processing 
	 * for a New User using Rewards Payment Processing method.
	 */
	@Test(enabled=true)
	public void verifySuccessfulRewardPaymentForNewUser() {
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for New User.---- Started");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for New User .---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		String otp="";
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
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon().
		clickTabRewardEarnings().
		verifyPresenceOfRequestedStatusLabel();
		Utils.clearCashbackRewards(driver, email); 
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		clickTabRewardEarnings().
		verifyPresenceOfPaidStatusLabel();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify existing user is able to donate Charity
	 * using Cash back Payment Processing method.
	 */

	@Test(enabled=true)
	public void verifyUserIsAbleToDonateCashbackToCharity() {
		Log.info("Validation of Charity Donation via Rewards.---- Started");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for New User .---- Started", "INFO");
		String otp="";
		String charityName=Utils.getTestData(6, "charityName");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String sortCode=Utils.getTestData(6, "sortCode");
		String bankName=Utils.getTestData(6, "bankName");
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
		selectPaymentMethod("UK Bank Payment (BACS)").
		enterBankAccountNumber(bankAccountNumber).
		enterNameOfAccountHolder(accountHolderName).
		enterSortCodeBacs(sortCode).
		enterBankNameBacs(bankName).
		selectCharityName(charityName).
		enterCharityAmount(amount).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulDonation();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED", "PASS");
	}

	/**
	 *  This method will Verify user is able to Process Payment Using BACS Bank Payment Mode.
	 */
	@Test(enabled=true)
	public void verifyUserIsAbleToProcessPaymentUsingBacsUKBank() {
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for BACS UK Bank.---- Started");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for BACS UK Bank.---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		String otp="";
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String sortCode=Utils.getTestData(6, "sortCode");
		String bankName=Utils.getTestData(6, "bankName");
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
		selectPaymentMethod("UK Bank Payment (BACS)").
		enterBankAccountNumber(bankAccountNumber).
		enterNameOfAccountHolder(accountHolderName).
		enterSortCodeBacs(sortCode).
		enterBankNameBacs(bankName).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for BACS UK Bank.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for BACS UK Bank.---- COMPLETED", "PASS");
	}

	/**
	 *  This method will Verify user is able to Process Payment Using Paypal Payment Mode.
	 */
	@Test(enabled=true)
	public void verifyUserIsAbleToProcessPaymentUsingPaypalPaymentMode() {
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for Paypal Payment Mode.---- Started");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for Paypal Payment Mode.---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		String otp="";
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
		selectPaymentMethod("Paypal").
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for Paypal Payment Mode.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for Paypal Payment Mode.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify new user is able to Process Payment Using Flipkart Gift Card.
	 */
	@Test(enabled=true)
	public void verifyUserIsAbleToProcessPaymentUsingFlipkartGiftCardPaymentMode() {
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for Flipkart Gift Card Payment Mode.---- Started");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for Flipkart Gift Card Payment Mode.---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		String otp="";
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
		selectPaymentMethod("Paypal").
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for Flipkart Gift Card Payment Mode.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for Flipkart Gift Card Payment Mode.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify new user is will not be able to Process Cash back Payment Using If he has cash back less
	 * than Threshold limit. Set Threshold= 250 & Cash back amount =249
	 */
	@Test(enabled=true)
	public void verifyUserIsUnableToProcessCashbackIfCashBackIsLessThanThresholdLimit() {
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- Started");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- Started", "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
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
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageThresholdNotReached().
		verifyPresenceMessageUnableToProcessRequest();
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- COMPLETED");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify new user is will not be able to Process Rewards Payment Request If he has Rewards  less
	 * than Threshold limit. Set Threshold= 250 & Rewards amount =249
	 */
	@Test(enabled=true)
	public void verifyUserIsUnableToProcessRewardsIfRewardsIsLessThanThresholdLimit() {
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Rewards---- Started");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Rewards---- Started", "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
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
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageThresholdNotReached().
		verifyPresenceMessageUnableToProcessRequest();
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Rewards---- COMPLETED");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Rewards---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing for combined cash back and rewards scenario.
	 * User Clicks Request Cash back button.
	 * Cash back + Rewards Amount should be greater than threshold limit for a new user.
	 * Payment Processing Type should be Rewards.
	 */
	@Test(enabled=true)
	public void verifySuccessfulCombinedCashbackRewardsByClickingRequestCashbackPaymentAndCombineRewardsPlusCashBackLinkCombineValueGreater() {
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for New User.---- Started");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for New User .---- Started", "INFO");
		String amount1=Utils.getTestData(6, "combineCashbackAmount1");
		String amount2=Utils.getTestData(6, "combineCashbackAmount2");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String otp=null;
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
		addCashbackRewards(amount1, email, cashBackType).
		addCashbackRewards(amount2, email, cashBackTypeRewards).
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards().
		clickCombineRewardsPlusCashBackLink().	
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for New user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for New user.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing for combined cash back and rewards scenario.
	 * Cash back + Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Rewards button.
	 * Payment Processing Type should be Rewards.
	 */
	@Test(enabled=true)
	public void verifySuccessfulCombinedCashbackRewardsByClickingRequestRewardPaymentAndCombineRewardsPlusCashBackLinkCombineValueGreater() {
		Log.info("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- Started");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button--- Started", "INFO");
		String amount1=Utils.getTestData(6, "combineCashbackAmount1");
		String amount2=Utils.getTestData(6, "combineCashbackAmount2");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String otp=null;
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
		addCashbackRewards(amount1, email, cashBackType).
		addCashbackRewards(amount2, email, cashBackTypeRewards).
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards().
		clickCombineRewardsPlusCashBackLink().
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- COMPLETED");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing for combined cash back and rewards scenario.
	 * Both Cash back and Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Rewards button.
	 * Payment Processing Type should be Rewards.
	 */
	@Test(enabled=true)
	public void verifySuccessfulCombinedCashbackRewardsWhenBothPaymentTypeGreaterThanThreshold() {
		Log.info("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold.---- Started");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold.---- Started", "INFO");
		String amount=Utils.getTestData(6, "moreThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String otp=null;
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
		addCashbackRewards(amount, email, cashBackTypeRewards).
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards().
		clickCombineRewardsPlusCashBackLink().
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold.---- COMPLETED");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing for Only Redeem Cash back Earnings scenario.
	 * Both Cash back and Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Cash back button and Only Redeem Cash back Earnings.
	 * Payment Processing Type should be Cash back.
	 */
	@Test(enabled=true)
	public void verifySuccessfulOnlyRedeemCashbackEarningsWhenBothPaymentTypeGreaterThanThreshold() {
		Log.info("Validation of successful successful payment processing for Only Redeem Cash back Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- Started");
		reportStep("Validation of successful successful payment processing for Only Redeem Cash back Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- Started", "INFO");
		String amount=Utils.getTestData(6, "moreThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String ifscCode=Utils.getTestData(6, "ifscCode");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String bankBranchName=Utils.getTestData(6, "bankBranchName");
		String bankName=Utils.getTestData(6, "bankName");
		String otp=null;
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
		addCashbackRewards(amount, email, cashBackTypeRewards).
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards().
		clickOnlyRedeemCashBackEarningsLink().
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful successful payment processing for Only Redeem Cash back Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- COMPLETED");
		reportStep("Validation of successful successful payment processing for Only Redeem Cash back Earnings scenario When Cashback & Rewards both Are Greater than Threshold---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing for Only Redeem Rewards Earnings scenario.
	 * Both Cash back and Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Cash back button and Only Redeem Cash back Earnings.
	 * Payment Processing Type should be Cash back.
	 */
	@Test(enabled=true)
	public void verifySuccessfulOnlyRedeemRewardsEarningsWhenBothPaymentTypeGreaterThanThreshold() {
		Log.info("Validation of successful successful payment processing for Only Redeem Rewards Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- Started");
		reportStep("Validation of successful successful payment processing for Only Redeem Rewards Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- Started", "INFO");
		String amount=Utils.getTestData(6, "moreThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String otp=null;
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
		addCashbackRewards(amount, email, cashBackTypeRewards).
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageToCombineCashBackPlusRewards().
		clickOnlyRedeemRewardsEarningsLink().
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		verifyPresenceMessageAfterSuccessfulClaimingCashback().
		clickClosePopUpIcon();
		Log.info("Validation of successful successful payment processing for Only Redeem Rewards Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- COMPLETED");
		reportStep("Validation of successful successful payment processing for Only Redeem Rewards Earnings scenario When Cashback & Rewards both Are Greater than Threshold---- COMPLETED", "PASS");
	}
	/**
	 * This method will verify presence of error message "A payment request from you is already Pending. 
	 * This will be processed shortly. Once this is paid, you can request for another payment."
	 * User Logins and click Payment Link in Left navigation Panel.
	 */

	@Test(enabled=true)
	public void verifyPaymentRequestAlreadyPendingMessageFromPaymentLeftNavigationForAlreadyRegisteredUser() {
		Log.info("Validation of Payment Request is Already Pening Left Navigation via Payment---- Started");
		reportStep("Validation of Payment Request is Already Pening Left Navigation via Payment---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String ifscCode=Utils.getTestData(6, "ifscCode");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String bankBranchName=Utils.getTestData(6, "bankBranchName");
		String bankName=Utils.getTestData(6, "bankName");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String otp="";
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
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		clickClosePopUpIcon().
		addCashbackRewards(amount, email, cashBackType).
		clickPaymentLinkLeftNavigationPanel().
		verifyPresenceMessagePaymentRequestAlreadyPending().
		clickClosePopUpIcon();
		Log.info("Validation of Payment Request is Already Pening Left Navigation via Payment.---- COMPLETED");
		reportStep("Validation of Payment Request is Already Pening Left Navigation via Payment.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify presence of error message "A payment request from you is already Pending. 
	 * This will be processed shortly. Once this is paid, you can request for another payment."
	 * User Logins and click "REQUEST CASHBACK PAYMENT" Link in My Earning Panel.
	 */

	@Test(enabled=true)
	public void verifyPaymentRequestAlreadyPendingMessageByClickingOnResquestCashbackPayment() {
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- Started");
		reportStep("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String ifscCode=Utils.getTestData(6, "ifscCode");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String bankBranchName=Utils.getTestData(6, "bankBranchName");
		String bankName=Utils.getTestData(6, "bankName");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String otp="";
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
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		clickClosePopUpIcon().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		verifyPresenceMessagePaymentRequestAlreadyPending().
		clickClosePopUpIcon();
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- COMPLETED");
		reportStep("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify presence of error message "A payment request from you is already Pending. 
	 * This will be processed shortly. Once this is paid, you can request for another payment."
	 * User Logins and click "REQUEST REWARDS PAYMENT" Link in My Earning Panel.
	 */
	@Test(enabled=true)
	public void verifyPaymentRequestAlreadyPendingMessageByClickingOnRequestRewardsPayment() {
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- Started");
		reportStep("Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String otp="";
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
		enterEmailAddress(email).
		clickGetPaidButton();
		
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		clickClosePopUpIcon().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestRewardsPaymentButtonToNavigateToPaymentForm().
		verifyPresenceMessagePaymentRequestAlreadyPending().
		clickClosePopUpIcon();
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- COMPLETED");
		reportStep("Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify error message pop up when a new user clicks on "REQUEST CASHBACK PAYMENT" button.
	 * Rewards +Cash back less than Threshold. 
	 */
	@Test(enabled=true)
	public void verifyPopUpErrorMessageWhenUserClickOnRequestCashBackPaymentAndUserHaveLessThanThreshold() {
		String start="Validation of Pop Up Error Message PAYMENT THRESHOLD NOT REACHED By Clicking REQUEST CASHBACK PAYMENT ---- Started";
		String completed="Validation of Pop Up Error Message PAYMENT THRESHOLD NOT REACHED By Clicking REQUEST CASHBACK PAYMENT ---- completed";
		Log.info(start);
		reportStep(start, "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
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
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageThresholdNotReached().
		verifyPresenceMessageUnableToProcessRequest();
		Log.info(completed);
		reportStep(completed, "PASS");

	}

	/**
	 * This method will verify error message pop up when a new user clicks on "REQUEST REWARDS PAYMENT" button.
	 * Rewards +Cash back less than Threshold. 
	 */
	@Test(enabled=true)
	public void verifyPopUpErrorMessageWhenUserClickOnRequestREWARDSPaymentAndUserHaveLessThanThreshold() {
		String start="Validation of Pop Up Error Message PAYMENT THRESHOLD NOT REACHED By Clicking REQUEST REWARDS PAYMENT ---- Started";
		String completed="Validation of Pop Up Error Message PAYMENT THRESHOLD NOT REACHED By Clicking REQUEST REWARDS PAYMENT ---- completed";
		Log.info(start);
		reportStep(start, "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
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
		verifyRequestCashbackIsEnabled().
		verifyRequestRewardsIsEnabled();
		Log.info(completed);
		reportStep(completed, "PASS");

	}

	/**
	 * This method will verify "REQUEST REWARDS PAYMENT" button and "REQUEST Cashback PAYMENT" button is enabled even when user has less than Threshold amount.
	 * Rewards +Cash back less than Threshold. 
	 */
	@Test(enabled=true)
	public void verifyRequestCashbackAndRequestRewardsPaymentButtonIsEnabledUserAmountLessThanThreshold() {
		String start="Validation of \"REQUEST REWARDS PAYMENT\" button and \"REQUEST Cashback PAYMENT\" button is enabled ---- Started";
		String completed="Validation of \"REQUEST REWARDS PAYMENT\" button and \"REQUEST Cashback PAYMENT\" button is enabled ---- completed";
		Log.info(start);
		reportStep(start, "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
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
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageThresholdNotReached().
		verifyPresenceMessageUnableToProcessRequest();
		Log.info(completed);
		reportStep(completed, "PASS");

	}

	/**
	 * This method will Verify status and other details of Cash back Type from Pending to Confirmed using exit click id
	 * @throws Exception 
	 */
	@Test(enabled=true)
	public void verifyStatusOfCashbackPendingAndConfirmedFromMyEarningPageUsingExitClickId() throws Exception {
		String started="Validation of status of Cash back from Pending to Confirmed ----- Started";
		String completed="Validation of status of Cash back from Pending to Confirmed ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String cashBackType=Utils.getTestData(6, "cashBackType");
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
		searchForVoucherOrStore(itemToBeSearched).
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
				retrieveExitClickChangeStatusToPending(driver, email,cashBackType);
		Utils.switchToParentWindow(driver);
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		verifyTextOfFirstRowDateInMyEarningCashBackType().
		verifyTextOfFirstRowCashBackAmountInMyEarningCashBackType().
		verifyTextOfFirstRowRetailerNameInMyEarningCashBackType().
		verifyTextOfFirstRowOrderIdInMyEarningCashBackType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningCashBackType().
		verifyPresenceOfPendingStatusLabel().
		verifyTextOfFirstRowDateInMyEarningExpectedCashBackType().
		verifyTextOfPendingCashBackAmountAtTopInMyEarning();
		Utils.switchToNewlyOpenWindow(driver);
		new WPAdmin(driver, logger).
		changePendingStatusToConfirm(driver,exitClickId);
		Utils.switchToParentWindow(driver);
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		verifyTextOfYourTotalCashBackEarningsAmountInMyEarning().
		verifyTextOfAvailableCashBackAmountAtTopInMyEarning().
		verifyPresenceOfConfirmedStatusLabel().
		verifyTextOfFirstRowDateInMyEarningCashBackType().
		verifyTextOfFirstRowCashBackAmountInMyEarningCashBackType().
		verifyTextOfFirstRowRetailerNameInMyEarningCashBackType().
		verifyTextOfFirstRowOrderIdInMyEarningCashBackType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningCashBackType().
		verifyTextOfPendingCashBackAmountAtTopInMyEarning();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will Verify status and other details of Cash back Type from Pending to Cancelled using exit click id
	 * @throws Exception 
	 */
	@Test(enabled=true)
	public void verifyStatusOfCashbackPendingAndCancelledFromMyEarningPageUsingExitClickId() throws Exception {
		String started="Validation of status of Cash back from Pending to Cancelled ----- Started";
		String completed="Validation of status of Cash back from Pending to Cancelled ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		new WPHomePage(driver, logger).
		clickOnlblSignInSignUP().
		clickOnlnkSignIn().
		clickSignUpTab().
		enterFullNameDuringSignUp(Utils.getTestData(1, "fullName")).
		enterEmailIDDuringSignUp(email).
		enterPasswordSignUp(password).
		enterMobileNumberSignUp(mobile).
		enterOtpDuringSignUp(mobile).
		clickVerifyOTP().
		verifyPresenceOfMyAccountLabel().
		searchForVoucherOrStore(itemToBeSearched).
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
				retrieveExitClickChangeStatusToPending(driver, email,cashBackType);
		Utils.switchToParentWindow(driver);
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		verifyTextOfFirstRowDateInMyEarningCashBackType().
		verifyTextOfFirstRowCashBackAmountInMyEarningCashBackType().
		verifyTextOfFirstRowRetailerNameInMyEarningCashBackType().
		verifyTextOfFirstRowOrderIdInMyEarningCashBackType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningCashBackType().
		verifyPresenceOfPendingStatusLabel().
		verifyTextOfFirstRowDateInMyEarningExpectedCashBackType().
		verifyTextOfPendingCashBackAmountAtTopInMyEarning();
		Utils.switchToNewlyOpenWindow(driver);
		new WPAdmin(driver, logger).
		changePendingStatusToCancel(driver,exitClickId);
		Utils.switchToParentWindow(driver);
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		verifyPresenceOfCancelledStatusLabel().
		verifyTextOfFirstRowDateInMyEarningCashBackType().
		verifyTextOfFirstRowCashBackAmountInMyEarningCashBackType().
		verifyTextOfFirstRowRetailerNameInMyEarningCashBackType().
		verifyTextOfFirstRowOrderIdInMyEarningCashBackType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningCashBackType();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will Verify status and other details of Rewards Type from Pending to Confirmed using exit click id
	 * @throws Exception 
	 */
	@Test(enabled=true)
	public void verifyStatusOfRewardsPendingAndConfirmedFromMyEarningPageUsingExitClickId() throws Exception {
		String started="Validation of status of Rewards from Pending to Confirmed ----- Started";
		String completed="Validation of status of Rewards from Pending to Confirmed ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String cashBackType=Utils.getTestData(6, "RewardsType");
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
		searchForVoucherOrStore(itemToBeSearched).
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
				retrieveExitClickChangeStatusToPending(driver, email,cashBackType);
		Utils.switchToParentWindow(driver);
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickTabRewardEarnings().
		verifyTextOfFirstRowDateInMyEarningRewardsType().
		verifyTextOfFirstRowRewardsAmountInMyEarningRewardsType().
		verifyTextOfFirstRowRetailerNameInMyEarningRewardsType().
		verifyTextOfFirstRowOrderIdInMyEarningRewardsType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningRewardsType().
		verifyPresenceOfPendingStatusLabel().
		verifyTextOfFirstRowDateInMyEarningExpectedRewardsType().
		verifyTextOfPendingRewardsAmountAtTopInMyEarning();
		Utils.switchToNewlyOpenWindow(driver);
		new WPAdmin(driver, logger).
		changePendingStatusToConfirm(driver,exitClickId);
		Utils.switchToParentWindow(driver);
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		clickTabRewardEarnings().
		verifyPresenceOfConfirmedStatusLabel().
		verifyTextOfFirstRowDateInMyEarningRewardsType().
		verifyTextOfFirstRowRewardsAmountInMyEarningRewardsType().
		verifyTextOfFirstRowRetailerNameInMyEarningRewardsType().
		verifyTextOfFirstRowOrderIdInMyEarningRewardsType(exitClickId).
		verifyTextOfYourTotalRewardsEarningsAmountInMyEarning().
		verifyTextOfAvailableRewardsAmountAtTopInMyEarning().
		verifyTextOfFirstRowOrderAmountInMyEarningRewardsType();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will Verify status and other details of Rewards Type from Pending to Cancelled using exit click id
	 * @throws Exception 
	 */
	@Test(enabled=true)
	public void verifyStatusOfRewardsPendingAndCancelledFromMyEarningPageUsingExitClickId() throws Exception {
		String started="Validation of status of Rewards from Pending to Cancelled ----- Started";
		String completed="Validation of status of Rewards from Pending to Cancelled ----- Completed";
		Log.info(started);
		reportStep(started, "INFO");
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String mobile=Utils.generateRandomMobileNumber();
		String itemToBeSearched=Utils.getTestData(7, "itemToBeSearched");
		String cashBackType=Utils.getTestData(6, "RewardsType");
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
		searchForVoucherOrStore(itemToBeSearched).
		clickOnVoucherCardActivateCashBack();
		Utils.switchToNewlyOpenWindow(driver);
		Utils.explicitWaitForUrlContains(itemToBeSearched);
		Utils.closeCurrentWindow(driver);
		Utils.switchToParentWindow(driver);
		Utils.openNewTab(driver);
		Utils.switchToNewlyOpenWindow(driver);
		String exitClickId=new WPAdmin(driver, logger).
				retrieveExitClickChangeStatusToPending(driver, email,cashBackType);
		Utils.switchToParentWindow(driver);
		new WPSearchResultsPage(driver, logger).
		clickMyAccountLabel().
		clickMyEarningLink().
		clickTabRewardEarnings().
		verifyTextOfFirstRowDateInMyEarningRewardsType().
		verifyTextOfFirstRowRewardsAmountInMyEarningRewardsType().
		verifyTextOfFirstRowRetailerNameInMyEarningRewardsType().
		verifyTextOfFirstRowOrderIdInMyEarningRewardsType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningRewardsType().
		verifyPresenceOfPendingStatusLabel().
		verifyTextOfFirstRowDateInMyEarningExpectedRewardsType().
		verifyTextOfPendingRewardsAmountAtTopInMyEarning();
		Utils.switchToNewlyOpenWindow(driver);
		new WPAdmin(driver, logger).
		changePendingStatusToCancel(driver, exitClickId);
		Utils.switchToParentWindow(driver);
		Utils.refresh(driver);
		new WPMyEarningsPage(driver, logger).
		clickTabRewardEarnings().
		verifyPresenceOfCancelledStatusLabel().
		verifyTextOfFirstRowDateInMyEarningRewardsType().
		verifyTextOfFirstRowRewardsAmountInMyEarningRewardsType().
		verifyTextOfFirstRowRetailerNameInMyEarningRewardsType().
		verifyTextOfFirstRowOrderIdInMyEarningRewardsType(exitClickId).
		verifyTextOfFirstRowOrderAmountInMyEarningRewardsType();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
}
