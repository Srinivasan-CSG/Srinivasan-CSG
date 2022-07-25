package MigrationApp.Test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import MigrationAppTest.CommonPackage.CommonUtilities;
import MigrationAppTest.CommonPackage.MigrationApp_BaseLibrary;
import MigrationAppTest.CommonPackage.MigrationApp_CommonMethodLibrary;
import MigrationAppTest.OperationPage.Datamigration_Operation_Functional_Library;
import MigrationAppTest.SystemAdminPage.Datamigration_Functional_Library;
import jdk.internal.org.objectweb.asm.commons.Method;


public class MigrationAppTest_Functionality extends MigrationApp_BaseLibrary{
	


	public MigrationAppTest_Functionality() throws Exception {
		super();
	}	
	
CommonUtilities commonUtil;
MigrationApp_BaseLibrary testBaseLibrary;
MigrationApp_CommonMethodLibrary CommonMethodLibrary;
Datamigration_Functional_Library DatamigrationFunctionalLibrary;
Datamigration_Operation_Functional_Library DatamigrationFunctionlLibrary;

public static WebDriver driver;

@BeforeClass(alwaysRun = true)
public void Setup() throws Exception {
CommonMethodLibrary = new MigrationApp_CommonMethodLibrary();
commonUtil = new CommonUtilities();
testBaseLibrary = new MigrationApp_BaseLibrary();
DatamigrationFunctionalLibrary = new Datamigration_Functional_Library();
DatamigrationFunctionlLibrary = new Datamigration_Operation_Functional_Library();
}

//---------User Account Module---------------------------------------------------------------------//
@DataProvider(name ="Datamigration_Parameters")
public String[][] UserAccount() throws Exception {
return commonUtil.fetchInputData(Inputfilepath,datasheetMigrtionAppTestInput,Datamigration_Parameters);
}
@Test(dataProvider = "Datamigration_Parameters",priority=0)
public void UserAccount(String RunMode,String Product_NameFilter,String Product_DescriptionFilter,String Product_DeploymentFilter ,String Job_Type_Name_Filter,String Job_Type_Source_Filter,String Job_Type_Target_Filter
		,String Customers_NameFilter,String CustomersName, String CustomersList,String Tenant_IDFilter,String Tenant_NameFilter,String Tenant_customerFilter,String Tenant_typeFilter)throws Exception{
	
	System.out.println("Testing");
	DatamigrationFunctionalLibrary.System_Adminstrator(Product_NameFilter,Product_DescriptionFilter,Product_DeploymentFilter ,Job_Type_Name_Filter,Job_Type_Source_Filter,Job_Type_Target_Filter);
	DatamigrationFunctionlLibrary.operation(Customers_NameFilter,CustomersName,CustomersList,Tenant_IDFilter,Tenant_NameFilter,Tenant_customerFilter,Tenant_typeFilter);
	
}


@AfterMethod
public void appendFinalHTMLReport(ITestResult result) throws Exception{
    if(result.getStatus() == ITestResult.FAILURE)
    {
    	
       Thread.sleep(3000);
    }else if(result.getStatus() == ITestResult.SUCCESS){
    	System.out.println("Module executed successfully");
    	Thread.sleep(3000);
    	
    	}/*else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());*/
		
      }
 }
