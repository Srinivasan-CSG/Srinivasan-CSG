package MigrationAppTest.OperationPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Datamigration_Object_Library {
		
	@FindBy(xpath="//div/span[contains(text(),'Operation')]")
	public WebElement Operation_link;
	
	@FindBy(xpath="//div/span[contains(text(),'Customers')]")
	public WebElement Customer_link;
	
	@FindBy(xpath="//div/span[contains(text(),'Tenants')]")
	public WebElement Tenants_link;
	
	@FindBy(xpath="//div/span[contains(text(),'Jobs')]")
	public WebElement Jobs_link;
	
	@FindBy(xpath="//div/span[contains(text(),'Job Settings')]")
	public WebElement Job_setting;
	
	@FindBy(xpath="//input[@aria-label='Name Filter']")
	public WebElement Name_filter;
	
	@FindBy(xpath="//td[contains(text(),'Des-Nexus')]")
	public WebElement searchresultNamefilter_JobTypes;
	
	@FindBy(xpath="//td[contains(text(),' No records available')]")
	public WebElement searchresultnoresultfound;
	
	@FindBy(xpath="//td[contains(text(),'Customerone')]")
	public WebElement searchresultNamefilter_Customers;
	
	@FindBy(xpath="//button[contains(text(),'NEW')]")
	public WebElement New_button;
	
	@FindBy(xpath="//span[contains(text(),'Create / Edit Customer')]")
	public WebElement Create_And_EditPage;
	
	@FindBy(xpath="//input[@class='k-input-inner']")
	public WebElement Input_inner;
	
	@FindBy(xpath="//span[contains(text(),' Save ')]")
	public WebElement Save_button;
	
	@FindBy(xpath="//span[contains(text(),' Cancel ')]")
	public WebElement Cancel_button;
	
	@FindBy(xpath="//div[@class='page-title']/span")
	public WebElement CustomersPage;
	
	@FindBy(xpath="//input[@aria-label='Tenant Id Filter']")
	public WebElement Tenant_id_filter;
	
	@FindBy(xpath="//input[@aria-label='Customer Filter']")
	public WebElement Tenant_Customer_filter;
	
	@FindBy(xpath="//tbody/tr[*]/td[1]")
	public List<WebElement> customerListtable;
	
	@FindBy(xpath="//tbody/tr[*]/td[2]/i")
	public List<WebElement> customer_List_table;
	
	@FindBy(xpath="//input[@aria-label='Tenant Type Filter']")
	public WebElement Tenant_Type_Filter;
	
	@FindBy(xpath="//span[contains(text(),'Add tenant')]")
	public WebElement Tenant_Add_Tenant_Header;
	
	@FindBy(xpath="//button[@aria-label='Select']")
	public WebElement Drop_Down;
	
	@FindBy(xpath="//span[contains(text(),' Get Tenant ')]")
	public WebElement Get_Tenant;
	
	@FindBy(xpath="//input[@aria-label='Tenant Name Filter']")
	public WebElement Tenant_Name_Filter;
	
	@FindBy(xpath="//input[@aria-label='Tenant Id Filter']")
	public WebElement Tenant_id_Filter;
	
	@FindBy(xpath="//td[1][contains(text(),'chp')]")
	public WebElement searchresultTenantIDfilter_Tenants;
	
	@FindBy(xpath="//td[2][contains(text(),'chp')]")
	public WebElement searchresultTenantNamefilter_Tenants;
	
	@FindBy(xpath="//td[contains(text(),'tester123')]")
	public WebElement searchresultCustomerfilter_Tenants;
	
	@FindBy(xpath="//tr[2]//td[contains(text(),'LAW')]")
	public WebElement searchresultTenanttypefilter_Tenants;
	
	
	
	@FindBy(xpath="//input[@aria-label='Customer Filter']")
	public WebElement Customer_Filter;
	
	@FindBy(xpath="//input[@aria-label='TenantId Filter']")
	public WebElement TenantID_Filter;
	
	@FindBy(xpath="//input[@aria-label='TenantName Filter']")
	public WebElement TenantName_Filter;
	
	@FindBy(xpath="//input[@aria-label='JobName Filter']")
	public WebElement JobName_Filter;
	
	@FindBy(xpath="//input[@aria-label='Source Filter']")
	public WebElement Source_Filter;
	
	@FindBy(xpath="//input[@aria-label='Target Filter']")
	public WebElement Target_Filter;
}
