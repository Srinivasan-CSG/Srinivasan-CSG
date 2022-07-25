package MigrationAppTest.CommonPackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;




public class MigrationApp_Constants
{
			
		protected CommonUtilities commonUtil = new CommonUtilities();
		public static WebDriver driver;
		public static String startapplication;
	    public static String applicationURL;
		public static String Inputfilepath=System.getProperty("user.dir")+File.separator+"resources"+File.separator+"Input"+File.separator+"MigrationAppTest_InputTable.xls";
	    public static String Chromedriverpath=System.getProperty("user.dir")+File.separator+"resources"+File.separator+"Drivers"+File.separator;
	    public JavascriptExecutor jse = (JavascriptExecutor)driver; 
	    public static String datasheetMigrtionAppTestInput;
	    public SoftAssert softAssert = new SoftAssert();		 
	    public static String Datamigration_Parameters; 
	    public static String SystemAdmin;
	    	   
	    
//Constructors of Base class	    
	    
public MigrationApp_Constants() throws Exception {
	    Properties MigrationAppProp = new Properties();		
	    MigrationAppProp.load(new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"resources"+File.separator+"properties"+File.separator+"MigrationAppTest.properties")));
		startapplication = MigrationAppProp.getProperty("application_URL");
		
		datasheetMigrtionAppTestInput = MigrationAppProp.getProperty("excel.MigrationAppTest.datasheet");
		Datamigration_Parameters=MigrationAppProp.getProperty("excel.MigrationAppTest.Datamigration_Parameters");
	 	SystemAdmin=MigrationAppProp.getProperty("excel.MigrationAppTest.SystemAdmin");
	 	
	 	
	}
}
