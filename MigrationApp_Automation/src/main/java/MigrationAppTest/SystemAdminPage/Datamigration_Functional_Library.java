package MigrationAppTest.SystemAdminPage;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MigrationAppTest.CommonPackage.CommonUtilities;
import MigrationAppTest.CommonPackage.MigrationApp_CommonMethodLibrary;


public class Datamigration_Functional_Library extends MigrationApp_CommonMethodLibrary{
	
	Datamigration_Object_Library DatamigrationObjectLibrary;

	public Datamigration_Functional_Library() throws Exception {
		super();
		
		DatamigrationObjectLibrary=PageFactory.initElements(driver, Datamigration_Object_Library.class);
		commonUtil = new CommonUtilities();	
		
	}
	public void System_Adminstrator(String Product_NameFilter,String Product_DescriptionFilter,String Product_DeploymentFilter ,String Job_Type_Name_Filter,String Job_Type_Source_Filter,String Job_Type_Target_Filter
) throws Exception {
		DatamigrationObjectLibrary.System_Administrator.click();
		DatamigrationObjectLibrary.Products.click();
		DatamigrationObjectLibrary.Name_filter.sendKeys(Product_NameFilter);
		if(DatamigrationObjectLibrary.searchresultNamefilter_Product.getText().contains(Product_NameFilter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Name_filter.clear();
			DatamigrationObjectLibrary.Name_filter.sendKeys("Test");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Name filter is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Name_filter.clear();
		driver.navigate().refresh();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.Description_filter.sendKeys(Product_DescriptionFilter);
		if(DatamigrationObjectLibrary.searchresultDesfilter_Product.getText().contains(Product_DescriptionFilter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Description_filter.clear();
			DatamigrationObjectLibrary.Description_filter.sendKeys("Test");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Name filter is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Description_filter.clear();
		driver.navigate().refresh();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.Deployment_type_filter.sendKeys(Product_DeploymentFilter);
		if(DatamigrationObjectLibrary.searchresultDesfilter_Product.getText().contains(Product_DeploymentFilter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Name_filter.clear();
			DatamigrationObjectLibrary.Description_filter.sendKeys("Test");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Name filter is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Deployment_type_filter.clear();
		driver.navigate().refresh();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.System_Administrator.click();
		DatamigrationObjectLibrary.Job_Types.click();
		DatamigrationObjectLibrary.Name_filter.sendKeys(Job_Type_Name_Filter);
		if(DatamigrationObjectLibrary.searchresultNamefilter_JobTypes.getText().contains(Job_Type_Name_Filter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Name_filter.clear();
			DatamigrationObjectLibrary.Name_filter.sendKeys("Test");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Job types is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Name_filter.clear();
		driver.navigate().refresh();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.Source_filter.sendKeys(Job_Type_Source_Filter);
		if(DatamigrationObjectLibrary.SearchresultSourcefilter_JobTypes.getText().contains(Job_Type_Source_Filter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Source_filter.clear();
			DatamigrationObjectLibrary.Source_filter.sendKeys("Test");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Job types is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Source_filter.clear();
		driver.navigate().refresh();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.Target_filter.sendKeys(Job_Type_Target_Filter);
		if(DatamigrationObjectLibrary.SearchresultTargetfilter_JobTypes.getText().contains(Job_Type_Target_Filter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Target_filter.clear();
			DatamigrationObjectLibrary.Target_filter.sendKeys("Test");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Job types is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Target_filter.clear();
		
	}
	
}