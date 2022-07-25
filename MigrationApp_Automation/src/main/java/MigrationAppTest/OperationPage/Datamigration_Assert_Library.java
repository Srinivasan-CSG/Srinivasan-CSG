package MigrationAppTest.OperationPage;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MigrationAppTest.CommonPackage.CommonUtilities;
import MigrationAppTest.CommonPackage.MigrationApp_CommonMethodLibrary;


public class Datamigration_Assert_Library extends MigrationApp_CommonMethodLibrary{
	
	Datamigration_Object_Library DatamigrationObjectLibrary;

	public Datamigration_Assert_Library() throws Exception {
		super();
		
	
		DatamigrationObjectLibrary=PageFactory.initElements(driver, Datamigration_Object_Library.class);
	commonUtil = new CommonUtilities();	
	
}}/*
public void ValidLogin(String username,String password) throws Exception {
	LoginPageObjectLibrary.submit.click();
	for(WebElement li: LoginPageObjectLibrary.ErrorMessageText_LoginPage) {
		String error=li.getText();
		if(error.contains("Username is required.")) {
			softAssert.assertEquals(error, "Username is required.","Error Message captured successfully");
			LoginPageObjectLibrary.login.clear();
			LoginPageObjectLibrary.login.sendKeys(username);
		}
		LoginPageObjectLibrary.submit.click();
		if(error.contains("Username is required.")) {
			softAssert.assertEquals(error, "Username is required.","Error Message captured successfully");
			LoginPageObjectLibrary.Password.clear();
			LoginPageObjectLibrary.Password.sendKeys(password);
		}
		break;
	}
	
	
	LoginPageObjectLibrary.submit.click();
	Thread.sleep(5000);
	
}
public void walkPopup()throws Exception 
{
	try {
		  LoginPageObjectLibrary.Welcomepopup.click();
		  System.out.println("Element Found");
		
	} catch (NoSuchElementException e) {
	    System.out.println("Element Not Found");
	}
}
public void UserAccountLogout() throws Exception {
	LoginPageObjectLibrary.UserAccountLink.click();
	Thread.sleep(2000);
	LoginPageObjectLibrary.UserAccoutLogout.click();
}
}*/
