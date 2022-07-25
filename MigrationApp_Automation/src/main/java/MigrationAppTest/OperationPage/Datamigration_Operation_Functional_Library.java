package MigrationAppTest.OperationPage;

import org.openqa.selenium.support.PageFactory;
import MigrationAppTest.CommonPackage.CommonUtilities;
import MigrationAppTest.CommonPackage.MigrationApp_CommonMethodLibrary;


public class Datamigration_Operation_Functional_Library extends MigrationApp_CommonMethodLibrary{
	
	Datamigration_Object_Library DatamigrationObjectLibrary;

	public Datamigration_Operation_Functional_Library() throws Exception {
		super();
		
		DatamigrationObjectLibrary=PageFactory.initElements(driver, Datamigration_Object_Library.class);
		commonUtil = new CommonUtilities();	
		
	}
	public void operation(String Customers_NameFilter,String CustomersName,String CustomersList,String Tenant_IDFilter,String Tenant_NameFilter,String Tenant_customerFilter,String Tenant_typeFilter) throws Exception {
		DatamigrationObjectLibrary.Operation_link.click();
		DatamigrationObjectLibrary.Customer_link.click();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.Name_filter.sendKeys(Customers_NameFilter);
		if(DatamigrationObjectLibrary.searchresultNamefilter_Customers.getText().contains(Customers_NameFilter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Name_filter.clear();
			DatamigrationObjectLibrary.Name_filter.sendKeys("89075");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Name filter is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Name_filter.clear();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.New_button.click();
		if(DatamigrationObjectLibrary.Create_And_EditPage.isDisplayed()){
			System.out.println("New button is working");
		}
		DatamigrationObjectLibrary.Cancel_button.click();
		if(DatamigrationObjectLibrary.CustomersPage.isDisplayed()) {
			System.out.println("New button is working");
		}
		DatamigrationObjectLibrary.New_button.click();
		DatamigrationObjectLibrary.Input_inner.sendKeys(CustomersName);
		DatamigrationObjectLibrary.Save_button.click();
		if(DatamigrationObjectLibrary.searchresultNamefilter_Customers.getText().contains(CustomersName)) {
			System.out.println("Customer created sucessfully");
		
	}
		int customer_table=DatamigrationObjectLibrary.customerListtable.size();
		for(int i=0;i<=customer_table;i++) {
			String customertable=DatamigrationObjectLibrary.customerListtable.get(i).getText();
			if(customertable.contains(CustomersList)) {
				DatamigrationObjectLibrary.customer_List_table.get(i).click();
				break;
			}
		}
		DatamigrationObjectLibrary.Tenants_link.click();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.Tenant_id_filter.sendKeys(Tenant_IDFilter);
		if(DatamigrationObjectLibrary.searchresultTenantIDfilter_Tenants.getText().contains(Tenant_IDFilter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Tenant_id_filter.clear();
			DatamigrationObjectLibrary.Tenant_id_filter.sendKeys("89075");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Tenant filter is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Tenant_id_filter.clear();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.Tenant_Name_Filter.sendKeys(Tenant_NameFilter);
		if(DatamigrationObjectLibrary.searchresultTenantNamefilter_Tenants.getText().contains(Tenant_NameFilter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Tenant_Name_Filter.clear();
			DatamigrationObjectLibrary.Tenant_Name_Filter.sendKeys("89075");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Tenant filter is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Tenant_Name_Filter.clear();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.Tenant_Customer_filter.sendKeys(Tenant_customerFilter);
		if(DatamigrationObjectLibrary.searchresultTenantNamefilter_Tenants.getText().contains(Tenant_customerFilter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Tenant_Customer_filter.clear();
			DatamigrationObjectLibrary.Tenant_Customer_filter.sendKeys("89075");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Tenant filter is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Tenant_Customer_filter.clear();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.Tenant_Type_Filter.sendKeys(Tenant_typeFilter);
		if(DatamigrationObjectLibrary.searchresultTenantNamefilter_Tenants.getText().contains(Tenant_typeFilter)) {
			System.out.println("Search result found");
			DatamigrationObjectLibrary.Tenant_Type_Filter.clear();
			DatamigrationObjectLibrary.Tenant_Type_Filter.sendKeys("89075");
			if(DatamigrationObjectLibrary.searchresultnoresultfound.getText().contains("No records available")) {
				System.out.println("Tenant filter is working");
			}
		}else {			
			
			System.out.println("Search result not found");
        }
		DatamigrationObjectLibrary.Tenant_Type_Filter.clear();
		Thread.sleep(5000);
		DatamigrationObjectLibrary.New_button.click();
		if(DatamigrationObjectLibrary.Tenant_Add_Tenant_Header.isDisplayed()) {
			System.out.println("Add New Tenant Page is loading successfully");
		}
		DatamigrationObjectLibrary.Jobs_link.click();
		
		DatamigrationObjectLibrary.Job_setting.click();
	}
}