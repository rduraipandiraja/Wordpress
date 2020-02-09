package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class WPStoreCategoryPage extends TestSetUp{
	Boolean presence;
	public static final Logger log = LogManager.getLogger(WPStoreCategoryPage.class);
	
	//Constructor
	public WPStoreCategoryPage(WebDriver driver, ExtentTest logger){

		this.driver = driver;
		this.logger = logger;
		String locator="Loading Store Category Page";
		String pass="Successfully loaded Store Category Page";
		String fail="Store Category Page was not loaded properply. Please see the screenshot below: ";
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Log.debug(locator);
		reportStep(locator, "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lnkSortByPopularity));
			Log.info(pass);
			reportStep(pass, "PASS");
		} catch (Exception e) {
			Log.error(fail);
			reportStep(e.getMessage(), "INFO");
			reportStep(fail, "FAIL");
		} 
	}
	
	@FindBy(id="category_sort_byPopularity")
	private static WebElement lnkSortByPopularity;
	
	public WPStoreCategoryPage clickOnPopularityLink() {
		String locator="Locating Sort by Popularity Link";
		String pass="Successfully clicked Sort by Popularity Link";
		String fail="Unable to click Sort by Popularity Link";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkSortByPopularity)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="category_sort_byAZ")
	private static WebElement lnkSortByAZ;
	
	public WPStoreCategoryPage clickOnAtoZLink() {
		String locator="Locating Sort by A to Z Link";
		String pass="Successfully clicked Sort by A to Z Link";
		String fail="Unable to click Sort by A to Z Link";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkSortByAZ)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="category_sort_byPercent")
	private static WebElement lnkSortByPercent;
	
	public WPStoreCategoryPage clickOnPercentLink() {
		String locator="Locating Sort by Percent Link";
		String pass="Successfully clicked Sort by Percent Link";
		String fail="Unable to click Sort by Percent Link";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkSortByPercent)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="category_sort_byAmount")
	private static WebElement lnkSortByAmount;
	
	public WPStoreCategoryPage clickOnAmountLink() {
		String locator="Locating Sort by Amount Link";
		String pass="Successfully clicked Sort by Amount Link";
		String fail="Unable to click Sort by Amount Link";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkSortByAmount)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(id="category_sort_byNewest")
	private static WebElement lnkSortByNewest;
	
	public WPStoreCategoryPage clickOnNewestLink() {
		String locator="Locating Sort by Newest Link";
		String pass="Successfully clicked Sort by Newest Link";
		String fail="Unable to click Sort by Newest Link";
		Log.info(locator);
		reportStep(locator, "INFO");
		if(Utils.click(lnkSortByNewest)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	@FindBy(xpath="(//article/div[@class='store_card_parent']//p)[1]")
	private static WebElement lblFirstShortDescriptionStoreCard;
	
	public WPStoreCategoryPage verifytextOfFirstShortDescriptionSortBy(String shortDescription) {
		String locator="Locating Short Descriontion Of First Store Card Sort By Newest";
		String pass="Successfully verified text of Short Descriontion Of First Store Card Sort By Newest. Actual is: " +lblFirstShortDescriptionStoreCard.getText();
		String fail="Unable to verify text of Short Descriontion Of First Store Card Sort By Newest. Actual is: " +lblFirstShortDescriptionStoreCard.getText();
		Log.info(locator);
		reportStep(locator, "INFO");
		if(lblFirstShortDescriptionStoreCard.getText().toString().trim().equals(shortDescription)) {
			Log.info(pass);
			reportStep(pass, "PASS");
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//a[contains(@id,'category_resultsImg')]/img")
	private static List<WebElement> imgStoreCard;
	

	public WPStoreCategoryPage verifyStoreCardsAreSorted() {
		String locator="Locating Store Card Image";
		String pass="Successfully fetched Store Card Image Alt Atribute";
		String fail="Unable to fetch Store Card Image Alt Atribute";
		Log.info(locator);
		reportStep(locator, "INFO");
		List<String> list = new ArrayList<String>();
		try {
			for(int i=0;i<imgStoreCard.size();i++) {
				boolean add=list.add(imgStoreCard.get(i).getAttribute("alt").toString());
				String added="Added Successfully: " +list.get(i);
				if(add) {
					Log.info(added);
					reportStep(added, "PASS");	
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		boolean isSorted=Utils.isSorted(list);
		if(isSorted) {
			Log.info(pass);
			reportStep(pass, "PASS");	
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	@FindBy(id="link_topStores_recomdImg_0")
	private static WebElement lnkImgStore;
	
	//Click Store Image 
	public WPStorePage clickStoreImageInSCP() {// SCP stands for Stores Category Page
		try {
			reportStep("Clicking First Store Image in SLP ", "PASS");
			Log.info("Clicking First Store Image in SLP");
			Utils.explicitWaitForClick(lnkImgStore);
			reportStep("Clicked successfully First Store Image in SLP", "PASS");
			Log.info("Clicked Successfully on Logo");
		}catch(Exception e) {
			Log.fatal("Unable to Click  First Store Image in SLP");
			reportStep("Unable to Click First Store Image in SLP", "FAIL");
		}
		return new WPStorePage(driver, logger);
	}
	
	@FindBy(xpath="(//a[contains(text(),'ACTIVATE CASHBACK')])")
	private static List<WebElement> lnkActivateCashback;
	
	// Click Activate Cashback button
	public WPSignUpSignInPopUp clickActivateCashBackInSCP() {// SCP stands for Stores Category Page
		try {
			reportStep("Locating Activate Cashback in SLP", "PASS");
			Log.info("Locating Activate Cashback in SLP ");
			Utils.explicitWaitForVisibility(lnkActivateCashback.get(0));
			Utils.click(lnkActivateCashback.get(0));
			reportStep("Clicked successfully Activate Cashback in SLP", "PASS");
			Log.info("Clicked Successfully Activate Cashback in SLP");
		}catch(Exception e) {
			Log.fatal("Unable to Click  Activate Cashback in SLP");
			reportStep("Unable to Click Activate Cashback in SLP", "FAIL");
		}
		return new WPSignUpSignInPopUp(driver, logger);
	}
	
	public WPStoreCategoryPage verifyPaginationFunctionalityInStoreCategoryPage() {
		String info="Verifying Pagination Functionality in Store Category Page.";
		String pass="Successfully verified Pagination Functionality in Store Category Page. ";
		String fail="Pagination Functionality in Store Category Page is not working properly. Please see the screenshot below: ";
		String defaault="Store Card Count is not 24 in Store Category Page";
		reportStep(info, "INFO");
		Log.info(info);
		int initially=countStoreCardInStoreCategoryPage();
		if(initially!=24) {
			Log.info(defaault);
			reportStep(defaault, "FAIL");
		}
		for(int i=0;i<3;i++) {
			Utils.scrollToBottomOfPage(driver);
			Utils.sleep();
		}
		if(Utils.explicitWaitForUrlContains("paging=2")) {
			Log.info(pass);
			reportStep(pass, "PASS");
			
		}else {
			Log.info(fail);
			reportStep(fail, "FAIL");
		}
		return this;
	}
	
	
	@FindBy(xpath="//div[@class='store_card_parent']")
	private static List<WebElement> storeCard;
	
	public int countStoreCardInStoreCategoryPage() {
		String info="Counting Store Card Count in Store Category Page";
		String pass="Successfully counted Store Card in Store Category Page. It is:  ";
		String fail="Store Card Count is zero. Please see the screenshot below: ";
		reportStep(info, "INFO");
		Log.info(info);
		int count=storeCard.size();
		if(count==0) {
			Log.info(fail);
			reportStep(fail, "FAIL");
			
		}else {
			Log.info(pass+count);
			reportStep(pass+count, "PASS");
		}
		return count;
	}
}
