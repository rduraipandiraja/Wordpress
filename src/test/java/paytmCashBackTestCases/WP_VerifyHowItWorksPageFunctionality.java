package paytmCashBackTestCases;

import org.testng.annotations.Test;

import pageObjects.WPHomePage;
import utility.Log;
import utility.TestSetUp;
import utility.Utils;
/**
 * 
 * @author QA - Rahul Tiwari
 * In this class, validation of How It Works Page functionality is covered.
 */
public class WP_VerifyHowItWorksPageFunctionality extends TestSetUp{
	@Test(enabled=true)
	public void verifyHowItWorksPageContainsData() {
		String start="Validation of How It Works Page ----- Started";
		String completed="Validation of How It Works Page ----- Completed.";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		clickHowItWorksLink();
		Utils.explicitWaitForUrlContains("/how-it-works");
		Log.info(completed);
		reportStep(completed, "PASS");
	}
}
