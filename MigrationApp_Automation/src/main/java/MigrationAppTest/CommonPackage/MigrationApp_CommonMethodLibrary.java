package MigrationAppTest.CommonPackage;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeTest;



import org.openqa.selenium.support.ui.WebDriverWait;
	

public class MigrationApp_CommonMethodLibrary extends MigrationApp_Constants{
	
	

	public MigrationApp_CommonMethodLibrary() throws Exception {
			super();
		}
	public void startbrowser() throws Exception{
			System.setProperty("webdriver.chrome.driver",Chromedriverpath+"chromedriver.exe");
			System.setProperty("jacobdllpath","C:\\Users\\srinivasan.palani\\eclipse-workspace\\jacob-1.19\\jacob-1.19\\jacob-1.19-x64.dll");
			driver =new ChromeDriver();
			//LibraryLoader.loadJacobLibrary(); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(5000);
			System.out.println("Browser loaded");
			
			
	}
	public void launchApplication() throws Exception{
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(startapplication);
			Thread.sleep(3000);
			System.out.println("Launched TractionNext Application");


	
	}
			
	       public void quitBrowser() throws Exception {
			Thread.sleep(3000);
			driver.manage().deleteAllCookies();
			driver.quit();
		}
			public void clearCookies(){
				Iterable<org.openqa.selenium.Cookie> cookies = driver.manage().getCookies();
				for(org.openqa.selenium.Cookie s : cookies){
					driver.manage().deleteCookie(s);
					driver.manage().deleteAllCookies();	
					driver.navigate().refresh();
		}
		

		
		
	}}



