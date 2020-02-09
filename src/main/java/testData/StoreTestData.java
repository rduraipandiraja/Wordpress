package testData;

import javax.annotation.CheckForNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;

import pageObjects.WPStorePage;
import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class StoreTestData extends TestSetUp{
	public static final Logger log = LogManager.getLogger(WPStorePage.class);
	private String info="Loading Store Test Data";
	public String pass="Successfully fetched Store Test Data";
	private String fail="Unable to fetch Store Test Data";
	public StoreTestData(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		Log.info(info);
		reportStep(info, "INFO");
		try {
			Log.debug(pass);
			reportStep(pass, "PASS");
		} catch (Exception e) {
			Log.error(fail);
			reportStep(fail, "FAIL");
		} 
	}

	// Store_One_ - Core details
	private static String str_Store_One_Name;
	private static String str_Store_One_Short_Description;
	private static String str_Store_One_Primary_Cashback_Details;
	private static String str_Store_One_Primary_Cashback_Value;
	private static String str_Store_One_Secondary_Cashback_Details;
	private static String str_Store_One_Secondary_Cashback_Value;
	private static String str_Store_One_linkURL;
	private static String storeOneVoucherOneName;
	private static String str_Store_One_Voucher_Two_CODE;
	private static String str_Store_One_Voucher_Two_Name;
	private static String str_Store_One_Final_Terms_condition;
	private static String str_Store_One_Voucher_One_Desc;
	private static String str_Store_One_Voucher_Two_Desc;

	// Store_Two_ - Core details
	private static String str_Store_Two_Name;
	private static String str_Store_Two_Short_Desc_App;
	private static String str_Store_Two_Primary_Cashback_Value;
	private static String str_Store_Two_Primary_Cashback_Details;
	private static String str_Store_Two_Secondary_Cashback_Details;
	private static String str_Store_Two_Secondary_Cashback_Value;
	private static String str_Store_Two_Voucher_Two_CODE;
	private static String str_Store_Two_Voucher_Two_Name;
	private static String str_Store_Two_linkURL;

	// Store_Three - Core details
	private static String str_Store_Three_Name;
	private static String str_Store_Three_Primary_Cashback_Value;
	private static String str_Store_Three_Primary_Cashback_Details;
	private static String str_Store_Three_Secondary_Cashback_Value;
	private static String str_Store_Three_Secondary_Cashback_Details;
	private static String str_Store_Three_linkURL;

	// Store_Four - Core details
	private static String str_Store_Four_Name;

	// Store_Six - Core details
	private static String str_Store_Six_Name;
	private static String str_Store_Six_Primary_Cashback_Value;
	private static String str_Store_Six_Primary_Cashback_Details;
	private static String str_Store_Six_Secondary_Cashback_Value;
	private static String str_Store_Six_Secondary_Cashback_Details;

	// Store_Seven - Core details
	private static String str_Store_Seven_Name;
	private static String str_Store_Seven_Primary_Cashback_Value;
	private static String str_Store_Seven_Primary_Cashback_Details;
	private static String str_Store_Seven_Secondary_Cashback_Value;
	private static String str_Store_Seven_Secondary_Cashback_Details;

	// Store_Eight - Core details
	private static String str_Store_Eight_Name;
	private static String str_Store_Eight_Short_Desc_App;
	private static String str_Store_Eight_Primary_Cashback_Details;
	private static String str_Store_Eight_Primary_Cashback_Value;
	private static String str_Store_Eight_Secondary_Cashback_Details;
	private static String str_Store_Eight_Secondary_Cashback_Value;
	private static String str_Store_Eight_linkURL;
	private static String str_Store_Eight_Voucher_Two_CODE;
	private static String str_Store_Eight_Voucher_Two_Name;

	// Store_Nine_ - Core details
	private static String str_Store_Nine_Name;
	private static String str_Store_Nine_Short_Desc_App;
	private static String str_Store_Nine_Primary_Cashback_Details;
	private static String str_Store_Nine_Primary_Cashback_Value;
	private static String str_Store_Nine_Secondary_Cashback_Details;
	private static String str_Store_Nine_Secondary_Cashback_Value;
	private static String str_Store_Nine_Voucher_Two_CODE;
	private static String str_Store_Nine_Voucher_Two_Name;
	private static String str_Store_Nine_linkURL;

	// Store_Eleven - Core details
	private static String str_Store_Eleven_Name;  	

	// Store_Twelve - Core details
	private static String str_Store_Twelve_Name;

	// Store_Thirteen - Core details
	private static String str_Store_Thirteen_Name; 

	// Store_Fourteen - Core details
	private static String str_Store_Fourteen_Name; 	

	// Store_Twelve - Core details
	private static String str_Store_Fifteen_Name; 	
	private static String str_Store_Fifteen_Primary_Cashback_Details;
	private static String str_Store_Fifteen_Primary_Cashback_Value;
	private static String str_Store_Fifteen_Secondary_Cashback_Details;
	private static String str_Store_Fifteen_Secondary_Cashback_Value;
	private static String str_Store_Ten_Name;

	// Extract Network 18 Core Details

	
	
	
	public static void main(String str[]) {
		extractJsonValuesForStoreOne("N18_Store_One");
	}
	@CheckForNull
	public static String extractJsonValuesForStoreOne(String storeName) {

		String statusOfJsonObjectLoading ="Passed";
		try
		{	
			
			//Fetch the required value from the required store type
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);

			/********************************************************************* Store -1 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_One - Core details
			str_Store_One_Name  												=  objMainNode.get(storeName+"_Name").toString().trim();										 				
			str_Store_One_Primary_Cashback_Details 								=  objMainNode.get(storeName+"_Primary_Cashback_Details").toString().trim(); 	 
			str_Store_One_Primary_Cashback_Value  					    		=  objMainNode.get(storeName+"_Primary_Cashback_Value").toString().trim();
			str_Store_One_Secondary_Cashback_Details 							=  objMainNode.get(storeName+"_Secondary_Cashback_Details").toString().trim();
			str_Store_One_Secondary_Cashback_Value  							=  objMainNode.get(storeName+"_Secondary_Cashback_Value").toString().trim();
			str_Store_One_Voucher_Two_Name 										=  objMainNode.get(storeName+"_Voucher_Two_Name").toString().trim();
			storeOneVoucherOneName                                              =  objMainNode.get(storeName+"_Voucher_One_Name").toString().trim();
			str_Store_One_Short_Description										=  objMainNode.get(storeName+"_Short_Desc").toString().trim();
			str_Store_One_Voucher_One_Desc										=  objMainNode.get(storeName+"_Voucher_One_Desc").toString().trim();
			str_Store_One_Voucher_Two_Desc										=  objMainNode.get(storeName+"_Voucher_Two_Desc").toString().trim();
			
		}
		catch(Exception objError){

			statusOfJsonObjectLoading = "Failed";
			objError.printStackTrace();
		}

		return statusOfJsonObjectLoading;


		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}
	
	@CheckForNull
	public static String extractJsonValuesForStoreTen(String storeName) {


		try
		{	

			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);
			str_Store_Ten_Name  												=  objMainNode.get(storeName+"_Name").toString().trim();										 				
			
		}
		catch(Exception objError){
			objError.printStackTrace();
		}

		return str_Store_Ten_Name;


		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValuesForStoreTwo(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try {

			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);

			/********************************************************************* Store -2 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Two_ - Core details
			str_Store_Two_Name  												=  objMainNode.get(storeName+"_Name").toString().trim();
			str_Store_Two_linkURL 												=  objMainNode.get(storeName+"_linkURL").toString().trim();					
			str_Store_Two_Short_Desc_App 										=  objMainNode.get(storeName+"_Short_Desc_App").toString().trim(); 				
			str_Store_Two_Primary_Cashback_Details 								= objMainNode.get(storeName+"_Primary_Cashback_Details").toString().trim(); 	 
			str_Store_Two_Primary_Cashback_Value  					    		= objMainNode.get(storeName+"_Primary_Cashback_Value").toString().trim();
			str_Store_Two_Secondary_Cashback_Details 							= objMainNode.get(storeName+"_Secondary_Cashback_Details").toString().trim();
			str_Store_Two_Secondary_Cashback_Value  							= objMainNode.get(storeName+"_Secondary_Cashback_Value").toString().trim();
			str_Store_Two_Voucher_Two_Name 										= objMainNode.get(storeName+"_Voucher_Two_Name").toString().trim();
			str_Store_Two_Voucher_Two_CODE 										= objMainNode.get(storeName+"_Voucher_Two_CODE").toString().trim();

		}
		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			////ExtentTestManager.getTest().log(LogStatus.FAIL, "Sorry,Internal Memory Variables are not loaded Properly,So Up coming dependant execution are going to be Skipped");
			objError.printStackTrace();
		}

		return statusJsonValueLoaded;


		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValueForStoreThree(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try
		{
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);

			/********************************************************************* Store -3 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Three - Core details
			str_Store_Three_Name  								=  objMainNode.get(storeName+"_Name").toString().trim();	
			str_Store_Three_linkURL  							=  objMainNode.get(storeName+"_linkURL").toString().trim();
			str_Store_Three_Primary_Cashback_Value  			=  objMainNode.get(storeName+"_Primary_Cashback_Value").toString().trim();
			str_Store_Three_Primary_Cashback_Details  			=  objMainNode.get(storeName+"_Primary_Cashback_Details").toString().trim();
			str_Store_Three_Secondary_Cashback_Value  			=  objMainNode.get(storeName+"_Secondary_Cashback_Value").toString().trim();
			str_Store_Three_Secondary_Cashback_Details  		=  objMainNode.get(storeName+"_Secondary_Cashback_Details").toString().trim();

		}
		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			objError.printStackTrace();
		}

		return statusJsonValueLoaded;


		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValueForStoreFour(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try
		{
			//Fetch the required value from the required store type
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);

			/********************************************************************* Store -4 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Four - Core details
			str_Store_Four_Name  								=  objMainNode.get(storeName+"_Name").toString().trim();

		}

		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			objError.printStackTrace();
		}
		return statusJsonValueLoaded;
		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValueForStoreSix(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try
		{
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);

			/********************************************************************* Store -4 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Six - Core details
			str_Store_Six_Name  										=  objMainNode.get(storeName+"_Name").toString().trim();	
			str_Store_Six_Primary_Cashback_Value  						=  objMainNode.get(storeName+"_Primary_Cashback_Value").toString().trim();	
			str_Store_Six_Primary_Cashback_Details  					=  objMainNode.get(storeName+"_Primary_Cashback_Details").toString().trim();	
			str_Store_Six_Secondary_Cashback_Value  					=  objMainNode.get(storeName+"_Secondary_Cashback_Value").toString().trim();	
			str_Store_Six_Secondary_Cashback_Details  					=  objMainNode.get(storeName+"_Secondary_Cashback_Details").toString().trim();	

		}

		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			objError.printStackTrace();
		}

		return statusJsonValueLoaded;


		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValueForStoreSeven(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try
		{
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);

			/********************************************************************* Store -4 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Seven - Core details
			str_Store_Seven_Name  										=  objMainNode.get(storeName+"_Name").toString().trim();	
			str_Store_Seven_Primary_Cashback_Value  					=  objMainNode.get(storeName+"_Primary_Cashback_Value").toString().trim();	
			str_Store_Seven_Primary_Cashback_Details  					=  objMainNode.get(storeName+"_Primary_Cashback_Details").toString().trim();	
			str_Store_Seven_Secondary_Cashback_Value  					=  objMainNode.get(storeName+"_Secondary_Cashback_Value").toString().trim();	
			str_Store_Seven_Secondary_Cashback_Details  				=  objMainNode.get(storeName+"_Secondary_Cashback_Details").toString().trim();	

		}

		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			objError.printStackTrace();
		}

		return statusJsonValueLoaded;


		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValueForStoreEight(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try
		{
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);

			/********************************************************************* Store -4 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Eight - Core details  
			str_Store_Eight_Name  												=  objMainNode.get(storeName+"_Name").toString().trim();
			str_Store_Eight_linkURL 											=  objMainNode.get(storeName+"_linkURL").toString().trim();					
			str_Store_Eight_Short_Desc_App 										=  objMainNode.get(storeName+"_Short_Desc_App").toString().trim(); 				
			str_Store_Eight_Primary_Cashback_Details 							= objMainNode.get(storeName+"_Primary_Cashback_Details").toString().trim(); 	 
			str_Store_Eight_Primary_Cashback_Value  					    	= objMainNode.get(storeName+"_Primary_Cashback_Value").toString().trim();
			str_Store_Eight_Secondary_Cashback_Details 							= objMainNode.get(storeName+"_Secondary_Cashback_Details").toString().trim();
			str_Store_Eight_Secondary_Cashback_Value  							= objMainNode.get(storeName+"_Secondary_Cashback_Value").toString().trim();
			str_Store_Eight_Voucher_Two_Name 									= objMainNode.get(storeName+"_Voucher_Two_Name").toString().trim();
			str_Store_Eight_Voucher_Two_CODE 									= objMainNode.get(storeName+"_Voucher_Two_CODE").toString().trim();


		}

		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			objError.printStackTrace();
		}

		return statusJsonValueLoaded;


		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValueForStoreNine(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try
		{
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);
			/********************************************************************* Store -4 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Two_ - Core details
			str_Store_Nine_Name  												=  objMainNode.get(storeName+"_Name").toString().trim();
			str_Store_Nine_linkURL 												=  objMainNode.get(storeName+"_linkURL").toString().trim();					
			str_Store_Nine_Short_Desc_App 										=  objMainNode.get(storeName+"_Short_Desc_App").toString().trim(); 				
			str_Store_Nine_Primary_Cashback_Details 							= objMainNode.get(storeName+"_Primary_Cashback_Details").toString().trim(); 	 
			str_Store_Nine_Primary_Cashback_Value  					    	= objMainNode.get(storeName+"_Primary_Cashback_Value").toString().trim();
			str_Store_Nine_Secondary_Cashback_Details 							= objMainNode.get(storeName+"_Secondary_Cashback_Details").toString().trim();
			str_Store_Nine_Secondary_Cashback_Value  							= objMainNode.get(storeName+"_Secondary_Cashback_Value").toString().trim();
			str_Store_Nine_Voucher_Two_Name 									= objMainNode.get(storeName+"_Voucher_Two_Name").toString().trim();
			str_Store_Nine_Voucher_Two_CODE 									= objMainNode.get(storeName+"_Voucher_Two_CODE").toString().trim();

		}

		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			objError.printStackTrace();
		}

		return statusJsonValueLoaded;


		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValueForStoreEleven(String storeName) {
		String statusJsonValueLoaded ="Passed";
		try
		{
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);

			/********************************************************************* Store -4 Details Assigning *********************************************************************************/
			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Nine - Core details            
			str_Store_Eleven_Name  								=  objMainNode.get(storeName+"_Name").toString().trim();

		}
		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			objError.printStackTrace();
		}
		return statusJsonValueLoaded;
		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValueForStoreTwelve(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try
		{
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);

			/********************************************************************* Store -4 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Twelve - Core details            
			str_Store_Twelve_Name  													=  objMainNode.get(storeName+"_Name").toString().trim();	


		}
		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Sorry,Internal Memory Variables are not loaded Properly,So Up coming dependant execution are going to be Skipped");
			objError.printStackTrace();
		}

		return statusJsonValueLoaded;


		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String  extractJsonValueForStoreThirteen(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try
		{
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);

			/********************************************************************* Store -4 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Thirteen - Core details            
			str_Store_Thirteen_Name  												=  objMainNode.get(storeName+"_Name").toString().trim();	
		}
		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			objError.printStackTrace();
		}
		return statusJsonValueLoaded;
		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValueForStoreFourteen(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try
		{
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);
			/********************************************************************* Store -4 Details Assigning *********************************************************************************/
			/*  Normal Primary / Secondary Cash back with Percentage */	
			// Store_Fourteen - Core details            
			str_Store_Fourteen_Name  												=  objMainNode.get(storeName+"_Name").toString().trim();	
		}
		catch(Exception objError){
			statusJsonValueLoaded = "Failed";
			objError.printStackTrace();
		}
		return statusJsonValueLoaded;
		/*************************************************************************************End of Stores Details Assigning*******************************************************************************/
	}

	// extract_Values_From_Json_And_Load_Internal_Variables
	public static String extractJsonValueForStoreFifteen(String storeName) {

		String statusJsonValueLoaded ="Passed";
		try
		{
			JSONObject objMainNode 				= Utils.fetchJsonValuesForStore(storeName);
			/********************************************************************* Store -4 Details Assigning *********************************************************************************/

			/*  Normal Primary / Secondary Cash back with Percentage */
			// Store_Fifteen - Core details            
			str_Store_Fifteen_Name  												=  objMainNode.get(storeName+"_Name").toString().trim();	
			str_Store_Fifteen_Primary_Cashback_Value  								=  objMainNode.get(storeName+"_Primary_Cashback_Value").toString().trim();
			str_Store_Fifteen_Primary_Cashback_Details  							=  objMainNode.get(storeName+"_Primary_Cashback_Details").toString().trim();
			str_Store_Fifteen_Secondary_Cashback_Value  							=  objMainNode.get(storeName+"_Secondary_Cashback_Value").toString().trim();
			str_Store_Fifteen_Secondary_Cashback_Details  							=  objMainNode.get(storeName+"_Secondary_Cashback_Details").toString().trim();
			str_Store_Fifteen_Name  												=  objMainNode.get(storeName+"_Name").toString().trim();
			str_Store_Fifteen_Primary_Cashback_Details 							= objMainNode.get(storeName+"_Primary_Cashback_Details").toString().trim(); 	 
			str_Store_Fifteen_Primary_Cashback_Value  					    	= objMainNode.get(storeName+"_Primary_Cashback_Value").toString().trim();
			str_Store_Fifteen_Secondary_Cashback_Details 							= objMainNode.get(storeName+"_Secondary_Cashback_Details").toString().trim();
			str_Store_Fifteen_Secondary_Cashback_Value  							= objMainNode.get(storeName+"_Secondary_Cashback_Value").toString().trim();
		}
		catch(Exception objError){
			statusJsonValueLoaded = "Failed";

			objError.printStackTrace();
		}

		return statusJsonValueLoaded;

	}


	//*************************************************************************************************************************************************************************************//
	//** 											    					 get Methods												   			    								 **//
	//*************************************************************************************************************************************************************************************//

	public String getStoreName(String requiredValue) {

		String string = "";

		switch (requiredValue) {

		case "str_Store_One_Name":

			reportStep("First Store Name is : "+str_Store_One_Name, "INFO");
			return str_Store_One_Name;

		case "str_Store_Two_Name":

			reportStep("Second Store Name is: "+str_Store_Two_Name, "INFO");
			return str_Store_Two_Name;

		case "str_Store_Three_Name":

			reportStep("Third Store Name is : "+str_Store_Three_Name, "INFO");
			return str_Store_Three_Name;

		case "str_Store_Four_Name":

			reportStep("str_Store_Four_Name: "+str_Store_Four_Name, "INFO");
			return str_Store_Four_Name;


		case "str_Store_Six_Name":

			reportStep("str_Store_Six_Name: "+str_Store_Six_Name, "INFO");
			return str_Store_Six_Name;

		case "str_Store_Seven_Name":

			reportStep("str_Store_Seven_Name: "+str_Store_Seven_Name, "INFO");
			return str_Store_Seven_Name;

		case "str_Store_Eight_Name":

			reportStep("str_Store_Eight_Name: "+str_Store_Eight_Name, "INFO");
			return str_Store_Eight_Name;

		case "str_Store_Nine_Name":

			reportStep("str_Store_Nine_Name: "+str_Store_Nine_Name, "INFO");
			return str_Store_Nine_Name;

		case "str_Store_Eleven_Name":

			reportStep("str_Store_Eleven_Name: "+str_Store_Eleven_Name, "INFO");
			return str_Store_Eleven_Name;

		case "str_Store_Twelve_Name":

			reportStep("str_Store_Twelve_Name: "+str_Store_Twelve_Name, "INFO");
			return str_Store_Twelve_Name;

		case "str_Store_Thirteen_Name":

			reportStep("str_Store_Thirteen_Name: "+str_Store_Thirteen_Name, "INFO");
			return str_Store_Thirteen_Name;

		case "str_Store_Fourteen_Name":

			reportStep("str_Store_Fourteen_Name: "+str_Store_Fourteen_Name, "INFO");
			return str_Store_Fourteen_Name;

		case "str_Store_Fifteen_Name":

			reportStep("str_Store_Fifteen_Name: "+str_Store_Fifteen_Name, "INFO");
			return str_Store_Fifteen_Name;
			}

		return string;
	}

	public String getRequiredShortDescription(String requiredValue) {

		String string = "";

		switch (requiredValue) {

		case "str_Store_One_Short_Description":

			reportStep("str_Store_One_Short_Desc_App: "+str_Store_One_Short_Description, "INFO");
			return str_Store_One_Short_Description;

		case "str_Store_Two_Short_Desc_App":

			reportStep("str_Store_Two_Short_Desc_App: "+str_Store_Two_Short_Desc_App, "INFO");
			return str_Store_Two_Short_Desc_App;

		case "str_Store_Eight_Short_Desc_App":

			reportStep("str_Store_Eight_Short_Desc_App: "+str_Store_Eight_Short_Desc_App, "INFO");
			return str_Store_Eight_Short_Desc_App;

		case "str_Store_Nine_Short_Desc_App":

			reportStep("str_Store_Nine_Short_Desc_App: "+str_Store_Nine_Short_Desc_App, "INFO");
			return str_Store_Nine_Short_Desc_App;

		}

		return string;
	}

	public String getRequiredPrimaryCashbackDetails(String requiredValue) {

		String string = "";

		switch (requiredValue) {

		case "str_Store_One_Primary_Cashback_Details":

			reportStep("str_Store_One_Primary_Cashback_Details: "+str_Store_One_Primary_Cashback_Details, "INFO");
			return str_Store_One_Primary_Cashback_Details;

		case "str_Store_Two_Primary_Cashback_Details":

			reportStep("str_Store_Two_Primary_Cashback_Details: "+str_Store_Two_Primary_Cashback_Details, "INFO");
			return str_Store_Two_Primary_Cashback_Details;

		case "str_Store_Three_Primary_Cashback_Details":

			reportStep("str_Store_Three_Primary_Cashback_Details: "+str_Store_Three_Primary_Cashback_Details, "INFO");
			return str_Store_Three_Primary_Cashback_Details;

		case "str_Store_Six_Primary_Cashback_Details":

			reportStep("str_Store_Six_Primary_Cashback_Details: "+str_Store_Six_Primary_Cashback_Details, "INFO");
			return str_Store_Six_Primary_Cashback_Details;

		case "str_Store_Seven_Primary_Cashback_Details":

			reportStep("str_Store_Seven_Primary_Cashback_Details: "+str_Store_Seven_Primary_Cashback_Details, "INFO");
			return str_Store_Seven_Primary_Cashback_Details;

		case "str_Store_Eight_Primary_Cashback_Details":

			reportStep("str_Store_Eight_Primary_Cashback_Details: "+str_Store_Eight_Primary_Cashback_Details, "INFO");
			return str_Store_Eight_Primary_Cashback_Details;

		case "str_Store_Nine_Primary_Cashback_Details":

			reportStep("str_Store_Nine_Primary_Cashback_Details: "+str_Store_Nine_Primary_Cashback_Details, "INFO");
			return str_Store_Nine_Primary_Cashback_Details;

		case "str_Store_Fifteen_Primary_Cashback_Details":

			reportStep("str_Store_Fifteen_Primary_Cashback_Details: "+str_Store_Fifteen_Primary_Cashback_Details, "INFO");
			return str_Store_Fifteen_Primary_Cashback_Details;

		}

		return string;
	}

	public String getRequiredPrimaryCashbackValue(String requiredValue) {

		String string = "";

		switch (requiredValue) {

		case "str_Store_One_Primary_Cashback_Value":

			reportStep("str_Store_One_Primary_Cashback_Value: "+str_Store_One_Primary_Cashback_Value, "INFO");
			return str_Store_One_Primary_Cashback_Value;

		case "str_Store_Two_Primary_Cashback_Value":

			reportStep("str_Store_Two_Primary_Cashback_Value: "+str_Store_Two_Primary_Cashback_Value, "INFO");
			return str_Store_Two_Primary_Cashback_Value;

		case "str_Store_Three_Primary_Cashback_Value":

			reportStep("str_Store_Three_Primary_Cashback_Value: "+str_Store_Three_Primary_Cashback_Value, "INFO");
			return str_Store_Three_Primary_Cashback_Value;

		case "str_Store_Six_Primary_Cashback_Value":

			reportStep("str_Store_Six_Primary_Cashback_Value: "+str_Store_Six_Primary_Cashback_Value, "INFO");
			return str_Store_Six_Primary_Cashback_Value;

		case "str_Store_Seven_Primary_Cashback_Value":

			reportStep("str_Store_Seven_Primary_Cashback_Value: "+str_Store_Seven_Primary_Cashback_Value, "INFO");
			return str_Store_Seven_Primary_Cashback_Value;

		case "str_Store_Eight_Primary_Cashback_Value":

			reportStep("str_Store_Eight_Primary_Cashback_Value: "+str_Store_Eight_Primary_Cashback_Value, "INFO");
			return str_Store_Eight_Primary_Cashback_Value;

		case "str_Store_Nine_Primary_Cashback_Value":

			reportStep("str_Store_Nine_Primary_Cashback_Value: "+str_Store_Nine_Primary_Cashback_Value, "INFO");
			return str_Store_Nine_Primary_Cashback_Value;

		case "str_Store_Fifteen_Primary_Cashback_Value":

			reportStep("str_Store_Fifteen_Primary_Cashback_Value: "+str_Store_Fifteen_Primary_Cashback_Value, "INFO");
			return str_Store_Fifteen_Primary_Cashback_Value;

		}

		return string;
	}

	public String getRequiredSecondaryCashbackDetails(String requiredValue) {

		String string = "";

		switch (requiredValue) {

		case "str_Store_One_Secondary_Cashback_Details":

			reportStep("str_Store_One_Secondary_Cashback_Details: "+str_Store_One_Secondary_Cashback_Details, "INFO");
			return str_Store_One_Secondary_Cashback_Details;

		case "str_Store_Two_Secondary_Cashback_Details":

			reportStep("str_Store_Two_Secondary_Cashback_Details: "+str_Store_Two_Secondary_Cashback_Details, "INFO");
			return str_Store_Two_Secondary_Cashback_Details;

		case "str_Store_Three_Secondary_Cashback_Details":

			reportStep("str_Store_Three_Secondary_Cashback_Details: "+str_Store_Three_Secondary_Cashback_Details, "INFO");
			return str_Store_Three_Secondary_Cashback_Details;

		case "str_Store_Six_Secondary_Cashback_Details":

			reportStep("str_Store_Six_Secondary_Cashback_Details: "+str_Store_Six_Secondary_Cashback_Details, "INFO");
			return str_Store_Six_Secondary_Cashback_Details;

		case "str_Store_Seven_Secondary_Cashback_Details":

			reportStep("str_Store_Seven_Secondary_Cashback_Details: "+str_Store_Seven_Secondary_Cashback_Details, "INFO");
			return str_Store_Seven_Secondary_Cashback_Details;

		case "str_Store_Eight_Secondary_Cashback_Details":

			reportStep("str_Store_Eight_Secondary_Cashback_Details: "+str_Store_Eight_Secondary_Cashback_Details, "INFO");
			return str_Store_Eight_Secondary_Cashback_Details;

		case "str_Store_Nine_Secondary_Cashback_Details":

			reportStep("str_Store_Nine_Secondary_Cashback_Details: "+str_Store_Nine_Secondary_Cashback_Details, "INFO");
			return str_Store_Nine_Secondary_Cashback_Details;

		case "str_Store_Fifteen_Secondary_Cashback_Details":

			reportStep("str_Store_Fifteen_Secondary_Cashback_Details: "+str_Store_Fifteen_Secondary_Cashback_Details, "INFO");
			return str_Store_Fifteen_Secondary_Cashback_Details;

		}

		return string;
	}

	public String getRequiredSecondaryCashbackValue(String requiredValue) {

		String string = "";

		switch (requiredValue) {

		case "str_Store_One_Secondary_Cashback_Value":

			reportStep("str_Store_One_Secondary_Cashback_Value: "+str_Store_One_Secondary_Cashback_Value, "INFO");
			return str_Store_One_Secondary_Cashback_Value;

		case "str_Store_Two_Secondary_Cashback_Value":

			reportStep("str_Store_Two_Secondary_Cashback_Value: "+str_Store_Two_Secondary_Cashback_Value, "INFO");
			return str_Store_Two_Secondary_Cashback_Value;

		case "str_Store_Three_Secondary_Cashback_Value":

			reportStep("str_Store_Three_Secondary_Cashback_Value: "+str_Store_Three_Secondary_Cashback_Value, "INFO");
			return str_Store_Three_Secondary_Cashback_Value;

		case "str_Store_Six_Secondary_Cashback_Value":

			reportStep("str_Store_Six_Secondary_Cashback_Value: "+str_Store_Six_Secondary_Cashback_Value, "INFO");
			return str_Store_Six_Secondary_Cashback_Value;

		case "str_Store_Seven_Secondary_Cashback_Value":

			reportStep("str_Store_Seven_Secondary_Cashback_Value: "+str_Store_Seven_Secondary_Cashback_Value, "INFO");
			return str_Store_Seven_Secondary_Cashback_Value;

		case "str_Store_Eight_Secondary_Cashback_Value":

			reportStep("str_Store_Eight_Secondary_Cashback_Value: "+str_Store_Eight_Secondary_Cashback_Value, "INFO");
			return str_Store_Eight_Secondary_Cashback_Value;

		case "str_Store_Nine_Secondary_Cashback_Value":

			reportStep("str_Store_Nine_Secondary_Cashback_Value: "+str_Store_Nine_Secondary_Cashback_Value, "INFO");
			return str_Store_Nine_Secondary_Cashback_Value;

		case "str_Store_Fifteen_Secondary_Cashback_Value":

			reportStep("str_Store_Fifteen_Secondary_Cashback_Value: "+str_Store_Fifteen_Secondary_Cashback_Value, "INFO");
			return str_Store_Fifteen_Secondary_Cashback_Value;

		}

		return string;
	}

	public String getRequiredLinkUrl(String requiredValue) {

		String string = "";

		switch (requiredValue) {

		case "str_Store_One_linkURL":

			reportStep("str_Store_One_linkURL: "+str_Store_One_linkURL, "INFO");
			return str_Store_One_linkURL;

		case "str_Store_Two_linkURL":

			reportStep("str_Store_Two_linkURL: "+str_Store_Two_linkURL, "INFO");
			return str_Store_Two_linkURL;

		case "str_Store_Three_linkURL":

			reportStep("str_Store_Three_linkURL: "+str_Store_Three_linkURL, "INFO");
			return str_Store_Three_linkURL;

		case "str_Store_Eight_linkURL":

			reportStep("str_Store_Eight_linkURL: "+str_Store_Eight_linkURL, "INFO");
			return str_Store_Eight_linkURL;

		case "str_Store_Nine_linkURL":

			reportStep("str_Store_Nine_linkURL: "+str_Store_Nine_linkURL, "INFO");
			return str_Store_Nine_linkURL;
		}

		return string;
	}

	public String getRequiredVoucherCode(String requiredValue) {

		String string = "";

		switch (requiredValue) {

		case "str_Store_One_Voucher_Two_CODE":

			reportStep("str_Store_One_Voucher_Two_CODE: "+str_Store_One_Voucher_Two_CODE, "INFO");
			return str_Store_One_Voucher_Two_CODE;

		case "str_Store_Two_Voucher_Two_CODE":

			reportStep("Store Two Voucher Code is : "+str_Store_Two_Voucher_Two_CODE, "INFO");
			return str_Store_Two_Voucher_Two_CODE;

		case "str_Store_Eight_Voucher_Two_CODE":

			reportStep("str_Store_Eight_Voucher_Two_CODE: "+str_Store_Eight_Voucher_Two_CODE, "INFO");
			return str_Store_Eight_Voucher_Two_CODE;

		case "str_Store_Nine_Voucher_Two_CODE":

			reportStep("str_Store_Nine_Voucher_Two_CODE: "+str_Store_Nine_Voucher_Two_CODE, "INFO");
			return str_Store_Nine_Voucher_Two_CODE;
		}

		return string;
	}

	public String getRequiredVoucherName(String requiredValue) {

		String string = "";

		switch (requiredValue) {

		case "str_Store_One_Voucher_Two_Name":

			reportStep("str_Store_One_Voucher_Two_Name: "+str_Store_One_Voucher_Two_Name, "INFO");
			return str_Store_One_Voucher_Two_Name;

		case "str_Store_Two_Voucher_Two_Name":

			reportStep("str_Store_Two_Voucher_Two_Name: "+str_Store_Two_Voucher_Two_Name, "INFO");
			return str_Store_Two_Voucher_Two_Name;

		case "str_Store_Eight_Voucher_Two_Name":

			reportStep("str_Store_Eight_Voucher_Two_Name: "+str_Store_Eight_Voucher_Two_Name, "INFO");
			return str_Store_Eight_Voucher_Two_Name;

		case "str_Store_Nine_Voucher_Two_Name":

			reportStep("str_Store_Nine_Voucher_Two_Name: "+str_Store_Nine_Voucher_Two_Name, "INFO");
			return str_Store_Nine_Voucher_Two_Name;
		}

		return string;
	}

	public void passStoreFourIndexAccordingToApiLevel(String apiLevel) {

		switch (apiLevel) {
		case "21":
			extractJsonValueForStoreFour("TAB_CB_Store_Four");

			break;

		case "22":
			extractJsonValueForStoreFour("MOB_N18_Store_Four");

			break;

		case "23":
			extractJsonValueForStoreFour("MOB_RW_Store_Four");

			break;

		case "24":
			extractJsonValueForStoreFour("MOB_CB_Store_Four");

			break;

		case "25":
			extractJsonValueForStoreFour("N18_Store_Four");

			break;

		case "26":
			extractJsonValueForStoreFour("RW_Store_Four");

			break;

		case "27":
			extractJsonValueForStoreFour("CB_Store_Four");

			break;
		}
	}



	public String getRequiredTermsConditions(String requiredValue) {

		String string = "";

		switch (requiredValue) {

		case "str_Store_One_Final_Terms_condition":

			reportStep("str_Store_One_Final_Terms_condition: "+str_Store_One_Final_Terms_condition, "INFO");
			return str_Store_One_Final_Terms_condition;

		}

		return string;
	}

	public String getVoucherOneName(String voucherOneName) {
		reportStep("voucherOneName: "+storeOneVoucherOneName, "INFO");
		switch(voucherOneName) {
		case "storeOneVoucherOneName":
			return storeOneVoucherOneName;
		case "str_Store_One_Voucher_One_Name":
			return storeOneVoucherOneName;
		}
		return voucherOneName;

	}

	public String getVoucherOneDescription(String voucherOneDescription) {

		switch(voucherOneDescription) {
		case "str_Store_One_Voucher_One_Desc":
			reportStep("First Voucher Description is:  "+str_Store_One_Voucher_One_Desc, "INFO");
			return str_Store_One_Voucher_One_Desc;
		}
		return voucherOneDescription;

	}

	public String getVoucherTwoDescription(String voucherTwoDescription) {

		switch(voucherTwoDescription) {
		case "str_Store_One_Voucher_Two_Desc":
			reportStep("Second Voucher Description is:  "+str_Store_One_Voucher_Two_Desc, "INFO");
			return str_Store_One_Voucher_One_Desc;
		}
		return voucherTwoDescription;

	}

}
