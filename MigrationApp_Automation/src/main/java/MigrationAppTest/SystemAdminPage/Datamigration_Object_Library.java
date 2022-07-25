package MigrationAppTest.SystemAdminPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Datamigration_Object_Library {
	
	@FindBy(id="UserName")
	public WebElement login;
		
	@FindBy(id="Password")
	public WebElement Password;
	
	@FindBy(xpath="//span[contains(text(),'System Administrator')]")
	public WebElement System_Administrator;
	
	@FindBy(xpath="//span[contains(text(),'Products')]")
	public WebElement Products;
	
	@FindBy(xpath="//div/span[contains(text(),'Job Types')]")
	public WebElement Job_Types;
	
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
	
	@FindBy(xpath="//td[contains(text(),'DES')]")
	public WebElement searchresultNamefilter_Product;
	
	@FindBy(xpath="//td[contains(text(),'OnSite Application')]")
	public WebElement searchresultDesfilter_Product;
	
	@FindBy(xpath="//input[@aria-label='Description Filter']")
	public WebElement Description_filter;
		
	@FindBy(xpath="//input[@aria-label='Deployment Type Filter']")
	public WebElement Deployment_type_filter;
	
	@FindBy(xpath="//td[contains(text(),'Onsite')]")
	public WebElement searchresultDiployfilter_Product;
	
	@FindBy(xpath="//input[@aria-label='Source Filter']")
	public WebElement Source_filter;
	
	@FindBy(xpath="//td[contains(text(),'DES')]")
	public WebElement SearchresultSourcefilter_JobTypes;
	
	@FindBy(xpath="//input[@aria-label='Target Filter']")
	public WebElement Target_filter;
	
	@FindBy(xpath="//td[contains(text(),'NEXUS')]")
	public WebElement SearchresultTargetfilter_JobTypes;
	
	@FindBy(xpath="//button[contains(text(),'NEW')]")
	public WebElement New_button;
	
	@FindBy(xpath="//input[@class='k-input-inner']")
	public WebElement Input_inner;
	
	@FindBy(xpath="//span[contains(text(),' Save ')]")
	public WebElement Save_button;
	
	@FindBy(xpath="//span[contains(text(),' Cancel ')]")
	public WebElement Cancel_button;
	
	@FindBy(xpath="//input[@aria-label='Tenant Id Filter']")
	public WebElement Tenant_id_filter;
	
	@FindBy(xpath="//input[@aria-label='Customer Filter']")
	public WebElement Customer_filter;
	
	@FindBy(xpath="//input[@aria-label='Tenant Type Filter']")
	public WebElement Tenant_Type_Filter;
	
	@FindBy(xpath="//button[@aria-label='Select']")
	public WebElement Drop_Down;
	
	@FindBy(xpath="//span[contains(text(),' Get Tenant ')]")
	public WebElement Get_Tenant;
	
	@FindBy(xpath="//input[@aria-label='Tenant Name Filter']")
	public WebElement Tenant_Name_Filter;
	
	
}
