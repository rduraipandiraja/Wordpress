package utility;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.WPCreationOfDataByHittingURLS;

public class Utils extends TestSetUp{
	private static Boolean presence =false;  
	public WebDriver driver=null;
	private static String testData=null;
	static WebDriverWait  wait;
	private static Random random=new Random(); 

	private static final XMLReader objXMLReader = new XMLReader(System.getProperty("user.dir") + "/src/main/java/testData/Testdata.xml");

	public static boolean jsClick(WebElement element, WebDriver driver){
		try{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			return true;
		}catch(Exception e){
			System.out.println("Unable to click element " +element);
			return false;
		}	
	}
	public static String getTestData(int index,String key){
		try {
			Log.info("Fetching Test Data for the test");
			List<Hashtable<String, String>> testDataHashTable = objXMLReader.getDataAsList("BasedOnFunctionality");
			testData= testDataHashTable.get(index).get(key).trim();
			Log.info("Successfully fetched Test Data for the test");
			return testData;
		}catch(Exception e) {
			Log.error("Unable to get Test Data: " +key);
			throw e;

		}		
	}


	public static void scrollingToPageElement(WebElement element,WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static WebElement highLight(WebElement element, WebDriver driver){
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", element);
		}
		return element;
	}
	public static Boolean verifyElementPresence(WebElement element) {

		try {
			explicitWaitForVisibility(element);
			//presence =element.isDisplayed();
			wait.until(ExpectedConditions.visibilityOf(element));
			presence = true;
		}catch(Exception e) {
			presence = false;
			e.printStackTrace();
		}
		if(presence==false) {
			System.out.println("Element is not displayed" +element);
			Log.error(element +" is not present" +element);
		}else {
			System.out.println("Element is displayed " +element);
			Log.info(element +" is present and visible " +element);
		}
		return presence;
	}
	
	public static Boolean verifyElementPresence(WebDriver driver,WebElement element) {

		try {
			explicitWaitForVisibility(element);
			//presence =element.isDisplayed();
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.visibilityOf(element));
			presence = true;
		}catch(Exception e) {
			presence = false;
			e.printStackTrace();
		}
		if(presence==false) {
			System.out.println("Element is not displayed" +element);
			Log.error(element +" is not present" +element);
		}else {
			System.out.println("Element is displayed " +element);
			Log.info(element +" is present and visible " +element);
		}
		return presence;
	}
	
	public static int getNumberOfElements(List<WebElement> list) {
		int size=list.size();
		return size;
	}
	public static String getCurrentWindowHandle(WebDriver driver) {
		String handle=driver.getWindowHandle();
		return handle;
	}
	public static void openNewTab(WebDriver driver) {
		//element.sendKeys(Keys.CONTROL+"t");
		String a = "window.open('about:blank','_blank');";
		((JavascriptExecutor)driver).executeScript(a);
	}
	public static void switchBackToPreviousWindow(String nameOfHandle, WebDriver driver) {
		driver.switchTo().window(nameOfHandle);
	}
	public static void switchToNewlyOpenWindow(WebDriver driver) {
		Set<String> handles=driver.getWindowHandles();
		System.out.println(handles);
		List<String> list=convertSetToList(handles);
		int size=list.size();
		System.out.println(size);
		driver.switchTo().window(list.get(size-1));
		System.out.println(driver.getWindowHandle());

	}
	public static void switchToParentWindow(WebDriver driver) {
		Set<String> handles=driver.getWindowHandles();
		List<String> list=convertSetToList(handles);
		driver.switchTo().window(list.get(0));

	}
	public static List<String> convertSetToList(Set<String> handles){
		int size=handles.size();
		List<String> list=new ArrayList<String>(size);
		for(String str: handles) {
			list.add(str);
		}
		return list;	
	}
	public static String getTestDataPath(){
		String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"testData"+File.separator;
		return path;
	}
	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void sleep(){
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static String getTimeStamp() {
		Date d = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String currentDate = sdf.format(d);
		return currentDate;
	}

	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}



	public static Boolean explicitWaitForVisibility(WebElement element) {
		try {
			Log.info("Waiting for element: "+element+" to be Visible");
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.info("Element is visible: " +element);
			return presence=true;
		}catch(Exception e) {
			return false;
		}
	}
	public static boolean explicitWaitForClick(WebElement element) {
		try {
			Log.info("Waiting for element to be clickable");
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean explicitWaitForUrlContains(String urlContains) {
		try {
			Log.info("Waiting for URL to contains: " +urlContains);
			wait.until(ExpectedConditions.urlContains(urlContains));
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public static void newWindowAction(WebDriver driver)throws Exception {
		try {
			String handle = driver.getWindowHandle();
			System.out.println(handle);
			java.util.Set<String> handles = driver.getWindowHandles();
			System.out.println(handles);
			// Pass a window handle to the other window
			for (String handle1 : driver.getWindowHandles()) {
				System.out.println(handle1);
				Thread.sleep(1000);
				driver.switchTo().window(handle1);
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());

			}
		} catch (Exception e) {
			Log.error("Exception in Class Utils | Method NewWindowAction");
			throw (e);
		}

	}
	public static boolean jsSendkeys(WebElement element, String str, WebDriver driver) {
		try {
			JavascriptExecutor jse = ((JavascriptExecutor)driver);
			jse.executeScript("arguments[0].value=str;", element);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public static String covertMillis(Long millis){
		long hours = TimeUnit.MILLISECONDS.toHours(millis);
		millis -= TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
		millis -= TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
		return String.format("%02d:%02d:%02d",hours, minutes,seconds);
	}
	public static boolean click(WebElement element) {
		try {
			Log.info("Waiting for element to be visible");
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.info("Clicking on " +element);
			element.click();
			Log.info("Clicked Successfully on " +element);
			return true;	
		}

		catch(Exception e) {
			Log.error("Unable to click "+element);
			return false;
		}
	}
	public static boolean sendKeys(WebElement element, String string) {
		try {
			if(element.isDisplayed()) {
				element.clear();
				Log.info("Cleared the textboxes" +element);
				element.sendKeys(string);
				Log.info("Entered successfully " +string + "in the text box" +element);
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
			Log.error("Unable to enter " +string + "in the text box" +element);
		}
		return false;
	}
	public static boolean moveToElementAndClick(WebElement element, WebDriver driver) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		builder.moveToElement(element).click().perform();
		return true;
	}
	public static boolean sendKeysAndPressEnter(WebElement element, String string) {
		try {
			element.clear();
			Log.info("Cleared the textboxes" +element);
			element.sendKeys(string);
			element.sendKeys(Keys.ENTER);
			Log.info("Entered successfully " +string + "in the text box" +element);
			return true;

		}catch(Exception e) {
			Log.error("Unable to enter " +string + "in the text box" +element);
			return false;
		}
	}
	public static boolean verifyPlaceHolderValue(WebElement element, String expected) {
		try {
			Log.info("Verifying Placeholder Value of " +element);
			if(expected.equals(element.getAttribute("placeholder").toString())){
				presence=true;
			}else {
				presence=false;
			}
			Log.info("Fetched the Placeholder Attribute Successfully");
		}catch(Exception e) {
			Log.error("Unable to Fetch the Placeholder Attribute");
		}
		return presence;
	}

	public static void refresh(WebDriver driver) {
		sleep();
		driver.navigate().refresh();
		implicitWait(driver);
	}

	// Below method will return OTP as a String during Sign Up
	public static String getOTPCode(String mobileNumber,WebDriver driver) {
		String otp = "";
		//String otpURL="http://cashkaro.ppdevchn15.com/getcode.php?page=signupotp_app&mobile="+mobileNumber;
		String otpURL="http://partner2.iamsavings.co.uk/getcode.php?page=signupotp_app&mobile="+mobileNumber;
		openNewTab(driver);
		switchToNewlyOpenWindow(driver);
		driver.get(otpURL);
		refresh(driver);
		WebElement element= driver.findElement(By.xpath("//body"));
		try {
			otp=element.getText().toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		otp=extractOnlyNumber(otp);
		Log.info("Otp is: "+otp);
		closeCurrentWindow(driver);
		switchToParentWindow(driver);
		System.out.println("Fetched OTP is :"+otp);
		return otp;

	}

	//Below method will return a String by generating 10 digit random mobile number
	public static String generateRandomMobileNumber() {
		//String mobileNumber=""; 
		StringBuilder mobileNumber=new StringBuilder();
		String mobNumber=getTestData(1, "dynamicMobile"); 
		char[] c=new char[1]; 
		for (int i = 0; i < 1; i++){ 
			c[i] = mobNumber.charAt(random.nextInt(mobNumber.length())); 
			mobileNumber =mobileNumber.append(c[i]); 
		} 
		for(int i=0;i<9;i++) {
			mobileNumber = mobileNumber.append(random.nextInt(9));
		}
		System.out.println(mobileNumber);
		return mobileNumber.toString();
	}

	//Below method will return random email ID. For this Current Time Stamp is being used.
	public static String generateRandomEmailId() {
		String email=getTestData(1, "dynamicEmail"); 
		email=getTimeStamp()+email;
		System.out.println(email);
		return email;
	}

	//Below method will return console value of browser. You have to pass locator as a parameter
	public static String fetchConsoleValue(String browserLocator, WebDriver driver) {
		String value="";
		System.out.println("return $("+browserLocator+").val()");
		value=(String) ((JavascriptExecutor) driver).executeScript("return $(\""+browserLocator+"\").val()");
		return value;
	}
	public static String getPageTitle(WebDriver driver) {
		String title="";
		title=driver.getTitle();
		Log.info("Successfully fetched Page Title. Page Title is: "+title);
		return title;
	}
	public static void waitForResendOTP(WebElement element, WebDriver driver) {
		Log.info("Waiting for resend otp button");
		WebDriverWait  wait = new WebDriverWait(driver, 300);
		Log.info("Waited successfully for resend otp button");
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static boolean verifyElementIsEnabled(WebElement element) {
		if(element.isEnabled()) {
			Log.info(element +"is enabled");
			return true;
		}else {
			Log.info(element +"is disabled");
			return false;
		}
	}

	public static boolean sendKeys(WebElement element, Keys key) {
		element.sendKeys(key);
		return true;
	}

	public static boolean getElementFromPage(WebElement element) {
		try {
			presence=verifyElementPresence(WPCreationOfDataByHittingURLS.lblSuccessMessage);
			if(presence) {
				Log.info("Element is present");
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			Log.error("Unable to add rewards or cashback. Please check !");
			return false;
		}		
	}

	public static void addCashbackRewards(WebDriver driver,String amount, String email, String cashBackType) {
		String baseURL="http://partner2.iamsavings.co.uk/getcode.php?page=add_bonus&email=";
		String cashbackRewardURL=baseURL+email+"&cashback="+amount+"&cashback_type="+cashBackType;
		openNewTab(driver);
		Log.info("Opened New Tab");
		switchToNewlyOpenWindow(driver);
		presence=verifyElementPresence(WPCreationOfDataByHittingURLS.lblSuccessMessage);
		if(presence) {
			Log.info("\"Success\" Message is present");
		}
		else {
			Log.error("\"Success\" Message is present");
		}
		Log.info("Successfully switched to new window");
		driver.get(cashbackRewardURL);
		Log.info("Successfully added money to account");
		closeCurrentWindow(driver);
		switchToParentWindow(driver);
		Log.info("Successfully switched back to Parent Window");
	}

	public static void clearCashbackRewards(WebDriver driver,String email) {
		String url="http://partner2.iamsavings.co.uk/getcode.php?page=create_cashout&email=";
		String clearPendingCashbackUrl=url+email;
		openNewTab(driver);
		Log.info("Opened New Tab");
		switchToNewlyOpenWindow(driver);
		Log.info("Successfully switched to new window");
		driver.get(clearPendingCashbackUrl);
		Log.info("Successfully added money to account");
		closeCurrentWindow(driver);
		switchToParentWindow(driver);
		Log.info("Successfully switched back to Parent Window");
	}
	public static String backDate() {    
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-d");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));

		Calendar objCalender  = Calendar.getInstance();

		objCalender.add(Calendar.DATE, - 4);
		Date currentDate    = objCalender.getTime();

		String strNumber_Days_To_BackDated_Exit_Clicks  = dateFormatGmt.format(currentDate);

		return strNumber_Days_To_BackDated_Exit_Clicks;
	} 


	public static String backDateFourDays() {    
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("MM_d_yyyy");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));

		Calendar objCalender  = Calendar.getInstance();

		objCalender.add(Calendar.DATE, - 4);
		Date currentDate    = objCalender.getTime();

		String strNumber_Days_To_BackDated_Exit_Clicks  = dateFormatGmt.format(currentDate).toString();

		return strNumber_Days_To_BackDated_Exit_Clicks;
	}
	public static String todaysDateDdMmmYyyy() {    
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("d-MMM-yyyy");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));

		Calendar objCalender  = Calendar.getInstance();

		objCalender.add(Calendar.DATE, 0);
		Date currentDate    = objCalender.getTime();

		String strNumber_Days_To_BackDated_Exit_Clicks  = dateFormatGmt.format(currentDate);

		return strNumber_Days_To_BackDated_Exit_Clicks;
	}
	//https://cashkaro.iamsavings.co.uk/getcode.php?page=ticket&id=LCCHKR6811662&date=2018-12-12
	public static String backDatingAnExitId(WebDriver driver,String exitId,String partnerType) {
		String security="https://";
		String baseUrl="partner2.iamsavings.co.uk/getcode.php?page=ticket&id=";
		String date=backDate();
		String dateBackingUrl=security+baseUrl+exitId+"&date="+date;
		Log.info(dateBackingUrl);
		openNewTab(driver);
		Log.info("Opened New Tab");
		switchToNewlyOpenWindow(driver);
		Log.info("Successfully switched to new window");
		driver.get(dateBackingUrl);
		Log.info("Successfully added money to account");
		closeCurrentWindow(driver);
		switchToParentWindow(driver);
		Log.info("Successfully switched back to Parent Window");
		return date;
	}

	public static void closeCurrentWindow(WebDriver driver) {
		Log.info("Closing Current Window");
		driver.close();
		Log.info("Successfully Closed Current Window");
	}

	public static boolean compareCountOfList(int initial,int after) {
		Log.info("Intial Count is : " +initial);
		Log.info("After Count is : " +after);
		boolean compare=false;
		if(after-initial>0) {
			Log.info("After value is greater than initial");
			compare=true;
		}
		Log.info("After value is lesser than initial");
		return compare;
	}

	public static String[] splitBasedOnComma(String csv){
		String[] list=csv.split(",");
		return list;
	}

	public static String getCurrentMonthAndYear() {
		String monthYear=null;
		LocalDate currentDate=LocalDate.now(); 
		Month month=currentDate.getMonth();
		int year=currentDate.getYear();
		monthYear=month.toString() +" "+year;
		return monthYear;
	}
	
	public static String extractOnlyNumber(String alphaNumeric) {
		String onlyNumber="";
		 for (char ch : alphaNumeric.toCharArray()) {
	            //5
	            if (Character.isDigit(ch)) {
	            	onlyNumber=onlyNumber+ch;
	            }
	        }
		 System.out.println(onlyNumber);
		return onlyNumber;
	}
	
	public static boolean isSorted(List<String> list)
	{
		 // Copies all of the elements from one list into another.
	    List<String> listSorted = new ArrayList<String>(list);

	    // Sorts the new list.
	    Collections.sort(listSorted);

	    // Check if both of list are equals.
	    return listSorted.equals(list);
	}
	public static JSONObject fetchJsonValuesForStore(String storeName) {
		JSONObject objStoreSpecific = new JSONObject();
		JSONObject objMainNode 	=null;
		JSONParser ObjJparser = new JSONParser();
		try
		{
			// Creating the Json object to the entire json data which is retrived from API
			JSONObject objJsonObject 			= (JSONObject) ObjJparser.parse(new FileReader(System.getProperty("user.dir") + "/src/main/resources/WP_StoreCreatedData.json"));
			if(storeName.contains("CB_Store")) {
				objStoreSpecific 				= (JSONObject) objJsonObject.get("CB_Store");
			} else if(storeName.contains("RW_Store")) {
				objStoreSpecific 				= (JSONObject) objJsonObject.get("RW_Store");
			}else if(storeName.contains("N18_Store")) {
				objStoreSpecific 				= (JSONObject) objJsonObject.get("N18_Store");
			}
			objMainNode 				= (JSONObject) objStoreSpecific.get(storeName);
		}catch(Exception e) {
			
		}
		
		return objMainNode;
	}
	
	public static String getClipBoardText() {
		String data = null;
		try {
			data = (String) Toolkit.getDefaultToolkit()
			        .getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static void scrollToBottomOfPage(WebDriver driver) {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}
