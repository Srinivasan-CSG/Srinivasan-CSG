package MigrationAppTest.CommonPackage;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import jdk.internal.org.objectweb.asm.commons.Method;

public class MigrationApp_BaseLibrary extends MigrationApp_Constants{
	
	
	public MigrationApp_BaseLibrary() throws Exception {
		super();
		
		
	}
		public static WebDriver driver;
		MigrationApp_CommonMethodLibrary commonMethodLibrary = new MigrationApp_CommonMethodLibrary();
		CommonUtilities commonUtil = new CommonUtilities();
		
	@BeforeSuite(alwaysRun=true)
	public void launchbrowser()throws Exception {
		commonMethodLibrary.startbrowser();
		commonMethodLibrary.launchApplication();
		}
/*	
	@BeforeMethod
	public void beforeMethod(Method method) {
		test =extent.startTest(this.getClass().getSimpleName()+"::"+ method.getName());
		test.assignAuthor("Srinivasan");
		test.assignCategory("Sample Test");
	}*/
/*	@AfterTest(alwaysRun=true)	
	public void closeBrowserConnection() throws Exception {
		commonMethodLibrary.clearCookies();
		driver.quit();*/
	
		
	
}
